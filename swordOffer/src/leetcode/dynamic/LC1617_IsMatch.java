package leetcode.dynamic;

public class LC1617_IsMatch {
    public static void main(String[] args) {

    }

    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n+1][m+1]; // 代表A的前i个字符与B的前j个字符 是否匹配

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                // 正则 分空串 非空串
                if (j == 0) {
                    dp[i][j] = i==0;
                } else {
                    // 如果正则 非空，分为 *和非*
                    if (B.charAt(j-1) != '*') { // 非*
                        if(i>0 && (A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.')) {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    } else { //  为 *
                        // B 正则 尾部带*
                        if (j>=2) {
                            dp[i][j] |= dp[i][j-2];
                        }
                        if (i>=1&&j>=2 && (A.charAt(i-1) == B.charAt(j-2) || B.charAt(j-2) == '.')) {
                           dp[i][j] |= dp[i-1][j];
                        }

                    }
                }
            }
        }
        return dp[n][m];
    }
}
