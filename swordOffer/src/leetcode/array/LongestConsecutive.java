package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutive {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int cnt = 1;
        int res = 1;
        for (int i=1; i<len; i++) {

            if (nums[i]== nums[i-1]) {
                continue;
            }
            if (nums[i] - nums[i-1] == 1) {
                list.add(nums[i]);
                cnt++;
                if (res < cnt) {
                    res = cnt;
                }
            } else {
                list.clear();
                list.add(nums[i]);
                if (res < cnt) {
                    res = cnt;
                }
                cnt = 1;
            }
        }
        return res;

    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int len = nums.length;
        for (int i=0; i<len; i++) {

            if(!set.contains(nums[i]-1)) {
                int currentNum = nums[i];

                int cnt = 1;
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }

        return res;

    }

}
