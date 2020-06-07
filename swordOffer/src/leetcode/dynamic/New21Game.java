package leetcode.dynamic;

// LeetCode 837
public class New21Game {
    public static void main(String[] args) {
        New21Game game = new New21Game();
//        game.new21Game()
    }
    public double new21Game2(int N, int K, int W) {
       if (K<=1) {
           return 1.00;
       }
       double[] dp = new double[K+W+1];
       for (int i=K;i<=N && i<K+W; i++) {
           dp[i] = 1.00;
       }

       for (int i=K-1; i>=0; i--) {
           for (int j=1; j<=W; j++) {
               dp[i] += dp[i+j] / W;
           }
       }
       return dp[0];
    }
    public double new21Game3(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K+W+1];
        for (int i= K; i<=N && i<K+W; i++) {
            dp[i] = 1.0;
        }
        dp[K-1] = 1.0 * Math.min(N-K+1, W) / W;
        for (int i=K-2; i>=0; i--) {
            dp[i] = dp[i+1]-(dp[i+W+1] - dp[i+1]) /W;

        }
        return dp[0];
    }

    public double new21Game(int N, int K, int W) {
        // 先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
        if (N - K + 1 >= W) {
            return 1.0;
        }
        // dp 代表 拥有 x时的赢 的概率，填格子
        double[] dp = new double[K + W];

        // 将能赢得游戏的点数的概率设置为 1
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        // 计算K + W 这几个点数的概率和
        double sumProb = N - K + 1;
        // 从 K - 1 开始计算，
        for (int i = K - 1; i >= 0; i--) {
            // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
            dp[i] = sumProb / W;
            sumProb = sumProb - dp[i + W] + dp[i];
        }

        return dp[0];
    }
}
