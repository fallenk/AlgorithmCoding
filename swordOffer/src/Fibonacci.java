public class Fibonacci {
    // offer 面试题10
    public static void main(String[] args) {
        Fibonacci  f = new Fibonacci();
        System.out.println(f.fibonacci2(4));
        System.out.println(f.fibonacci(4));
    }

    int[] p = new int[10000]; // 全局数据记录
    int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (p[n] != 0) {
            return p[n];
        }
        p[n] = fibonacci(n-1)+fibonacci(n-2);
        return p[n];
    }

    // 优化，从下而上
    int fibonacci2(int n) {
        if (n <=1) {
            return n;
        }
        int first =0, second = 1;
        int temp = 0;
        for (int i=2; i<=n; i++) {
          temp = second;
          second = first + second;
          first = temp;
        }
        return second;
    }

    // 青蛙跳台阶 一次1， 一次2， n阶几种跳法  从简单-> 到一般
    //

    // dp
    int fabonacci3(int n) {
        if (n <= 0) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }

}
