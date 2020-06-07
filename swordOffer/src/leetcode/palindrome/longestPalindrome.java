package leetcode.palindrome;

// https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode-solution/
public class longestPalindrome {
    public static void main(String[] args) {

    }

    public int longestPalindrome2(String s) {
        // 异常

        // Hashset 存放字符 判断

        return 0;
    }

    public int longestPanlindrome(String s) {
        if (s == null) return 0;

        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int cnt : count) {
            ans += cnt/2 * 2;
            if (ans%2==0 && cnt%2==1) {
                ans++;
            }
        }
        return ans;
    }



}
