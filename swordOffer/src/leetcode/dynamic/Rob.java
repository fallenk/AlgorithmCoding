package leetcode.dynamic;
// 198
public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = new int[]{1,2,3,1};
//        System.out.println(nums.length);
        rob.rob2(nums);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length <=0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i == 0) {
                dp[0] = nums[0];
            } else if(i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }else {
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }

        }
        return dp[n-1];
    }
    // 上述方法使用了数组存储结果。考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额(叠加)相关，因此可以使用滚动数组，
    // 在每个时刻只需要存储前两间房屋的最高总金额。
    public int rob2(int[] nums) {
       if (nums == null || nums.length <=0) {
           return 0;
       }
       int length = nums.length;

       if (length == 1) {
          return nums[0];
       }
       if (length == 2) {
           return Math.max(nums[0], nums[1]);
       }
       int first = nums[0], second = Math.max(nums[0], nums[1]);
       for (int i=2; i<length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
       }
       return second;
    }
}
