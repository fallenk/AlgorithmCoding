package leetcode.math;

public class Exam9_isPalindrome {

    public static void main(String[] args) {
       Exam9_isPalindrome exam = new Exam9_isPalindrome();
       Boolean bool = exam.isPalindrome(10021);
        System.out.printf(bool.toString());
    }

    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
