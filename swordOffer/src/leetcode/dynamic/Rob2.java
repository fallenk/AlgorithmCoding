package leetcode.dynamic;

import java.util.Arrays;

// 213
public class Rob2 {
    public static void main(String[] args) {
        Rob2 rob = new Rob2();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob.rob2(nums));

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length<= 0) {
            return 0;
        }
        int length = nums.length;
       if (length == 1) {
           return nums[0];
       }
       if (length == 2) {
           return Math.max(nums[0], nums[1]);
       }
       // 偷第一间
        int[] dp1 = new int[length-1];
       dp1[0] = nums[0];
       dp1[1] = Math.max(nums[0], nums[1]);

       for (int i=2; i<length-1; i++) {
            dp1[i] = Math.max(dp1[i-2]+nums[i], dp1[i-1]);
       }
       // 不偷第一间
        int[] dp2 = new int[length];
       dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i=3; i<length; i++) {
           dp2[i] = Math.max(dp2[i-2]+nums[i], dp2[i-1]);
       }
       return Math.max(dp1[length-2], dp2[length-1]);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0 || nums ==null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0, nums.length-1)),
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                dp[0] = nums[0];
            }
            if (i==1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }
            if(i>1){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
        }
        return dp[n-1];
    }

    private int myRob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]), temp;
        for (int i=2; i<nums.length; i++) {
            temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        return second;
    }
}
