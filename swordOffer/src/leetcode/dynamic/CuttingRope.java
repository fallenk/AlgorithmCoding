package leetcode.dynamic;

public class CuttingRope {
    public static void main(String[] args) {



    }

    // 1. 暴力递归
    public int cuttingRope(int n) {
        // 出口
        if (n == 2) {
            return 1;
        }
        int res = -1;
        // 循环体
        for (int i=1; i<n; i++) {
            res = Math.max(res, Math.max(i * cuttingRope(n-i), i*(n-i)));
        }
        return res;
    }

    // 2. 记忆化技术 优化方案
    public int cuttingRope2(int n) {
        int[] memo = new int[n];
        return memorize(n, memo);
    }

    private int memorize(int n, int[] memo) {
        if (n ==2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int res = -1;
        for (int i=1; i<n; i++) {
            res = Math.max(res, Math.max(i*(n-i), i*memorize(n-i, memo)));
        }
        memo[n] = res;
        return memo[n];
    }
}
