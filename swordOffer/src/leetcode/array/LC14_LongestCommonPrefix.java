package leetcode.array;

public class LC14_LongestCommonPrefix {
    public static void main(String[] args) {
        LC14_LongestCommonPrefix lc14_longestCommonPrefix = new LC14_LongestCommonPrefix();
        String[] strs = new String[] {"dog","racecar","car"};
        System.out.println(lc14_longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int len = strs.length;
        String prefix = strs[0];
        for (int i=1; i<len; i++) {

            int minLen = Math.min(prefix.length(), strs[i].length());
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=0; j<minLen; j++) {
                if (prefix.charAt(j) == strs[i].charAt(j)) {
                    stringBuilder.append(prefix.charAt(j));
                } else {
                    break;
                }
                prefix = stringBuilder.toString();
            }
            if (prefix.length() ==0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs==null || strs.length ==0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i=1; i<count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
           if (prefix.length() == 0) {
               break;
           }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs ==null || strs.length == 0) return "";

        int length = strs[0].length();
        int count = strs.length;
        for (int i=0; i<length; i++) {
            char c = strs[0].charAt(i);
            for (int j=1; j<count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

}
