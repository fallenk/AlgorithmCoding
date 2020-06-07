package leetcode.dynamic;

public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        // 考虑前缀乘积
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        L[0] = 1;
        for (int i=1; i<len; i++) {
            L[i] =  L[i-1] * nums[i-1];
        }
        R[len-1] = 1;
        for (int i=len-2; i>=0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }

        int[] res = new int[len];
        for (int i=0; i<len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i=1; i<length; i++) {
            res[i] = nums[i-1] * res[i-1];
        }

        int R=1;
        for (int i = length-1; i>=0; i--) {
            res[i] = res[i] * R;
            R = nums[i] * R;
        }
        return res;
    }
}
