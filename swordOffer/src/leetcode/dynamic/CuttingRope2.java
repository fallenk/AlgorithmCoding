package leetcode.dynamic;

public class CuttingRope2 {
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 2) {
            return (int) (quickPow(3, a) * b % 1000000007);
        } else {
            return (int) ((quickPow(3, a - 1) * (b + 3)) % 1000000007);
        }
    }

//    private long quickPow(int x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        long y = quickPow(x, n / 2);
//        return (n & 1) == 1 ? (y * y * x) % 1000000007 : (y * y) % 1000000007;
//    }

    private long quickPow(int x, long n) {
        long res = 1;
        long tt = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tt;
                res %= 1000000007;
            }
            tt *= tt;
            tt %= 1000000007;
            n /= 2;
        }
        return res;
    }

    public int cuttingRope3(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }
}
