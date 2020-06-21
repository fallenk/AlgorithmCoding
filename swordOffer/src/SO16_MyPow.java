public class SO16_MyPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        long exp = n;
        if (exp < 0) {
            x = 1/x;
            exp = -exp;
        }
        double res = 1.0;
        while ( exp > 0) {
            if ((exp&1) == 1) {
                res *= x;
            }
            x *= x;
            exp >>= 1;
        }
        return res;
    }
}
