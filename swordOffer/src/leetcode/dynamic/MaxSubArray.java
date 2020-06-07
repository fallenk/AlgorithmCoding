package leetcode.dynamic;

// https://leetcode-cn.com/problems/maximum-subarray/
public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;

        for (int i=0; i<len; i++) {
            int sum = 0;
            for (int j=i; j<len; i++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
    // 动态规划
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int[] f = new int[len]; // 前缀和 以i为结尾的连续子数组的最大和， 比较得到 f[i]的最大值
        int max = nums[0];
        for (int i=0; i<len; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;

    }
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int len = nums.length;
        int f = nums[0];
        int max = nums[0];
        for (int i=1; i<len; i++) {
            f = Math.max(f+nums[i], nums[i]);
            max = Math.max(f, max);
        }
        return max;
    }
    // 贪心算法 每次希望拿到最佳
    public int maxSubArray4(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;

        int sum = 0;
        for (int i=0; i<len; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;

    }
    // 分治法
    public int maxSubArray5(int[] nums) {
        int count = 0;
        for (int i = 0; i < 10; i++){
            count = count++;
        }
        System.out.print("count:"+count);
        return 0;
    }


}
