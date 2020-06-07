//LeetCode 287. 寻找重复数
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        // 1. 二分查找 使用  cnt[i] 表示nums[]数组中小于等于i的数有多少个。假设我们重复的数为target，那在[1, target]中的所有数满足
        // cnt[i]<= i;在[target, n]所有数满足cnt[i]>i;具有单调性 =》二分查找 => 当重复次数大于2时
        int length = nums.length;
        int l=1, r = length-1, ans=-1;
        while (l<=r) {
            int mid = (l+r)>>1;
            int cnt=0;
            for (int i=0; i<length; i++) {
                if(nums[i] <= mid) { // 统计出小于cnt[mid] < mid 的值
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid+1;
            } else {
                r = mid-1;
                ans = mid;
            }
        }
        return ans;
    }

    // 快慢指针法 这个方法我们来将所有数二进制展开按位考虑如何找出重复的数，如果我们能确定重复数每一位是 1 还是 0 就可以按位还原出重复的数是什么。
    public int findDuplicate2(int[] nums) {
        int fast=0, slow=0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
    // 快慢指针法 重复数字
    public int findDuplicate3(int[] nums) {
        int slow=0, fast=0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        }while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow =nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
