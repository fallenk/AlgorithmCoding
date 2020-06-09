package leetcode.dynamic;

public class TranslateNum {
    public static void main(String[] args) {

    }

    public int translate(int num) {
        if (num < 0) return -1;
        String src = String.valueOf(num);
        int len = src.length();
        int[] dp = new int[len];
//        dp[-1] = 0;
        dp[0] = 1;

        for (int i=1; i<len; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
            dp[i] += dp[i-1];

            String str = src.substring(i-1, i+1);
            if (str.compareTo("10") >=0 && str.compareTo("25") <=0) {
                if (i == 1) {
                    dp[i] += 1;
                    continue;
                }
                dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }

    public int translate2(int num) {
        if (num < 0) return -1;
        String str = String.valueOf(num);
        int len = str.length();
        int first = 0,  second = 0, res = 1;
        for (int i=0; i<len; i++) {
            first = second;
            second = res;
            res = 0;
            res += second;
            if (i==0) {
                continue;
            }
            String pre = str.substring(i-1, i+1);
            if (pre.compareTo("10") >= 0 && pre.compareTo("25") <= 0) {
                res += first;
            }
        }
        return res;
    }
}
