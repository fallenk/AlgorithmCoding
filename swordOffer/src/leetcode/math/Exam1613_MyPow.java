package leetcode.math;

public class Exam1613_MyPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (x ==0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1/x;
            b = -b;
        }
        while (b >0) {
            if ((b&1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >>> 1;
        }
        return res;
    }
}
