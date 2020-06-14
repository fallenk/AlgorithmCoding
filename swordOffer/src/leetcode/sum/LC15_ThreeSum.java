package leetcode.sum;

import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {
    public static void main(String[] args) {
        LC15_ThreeSum lc = new LC15_ThreeSum();
        int[] temp = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(lc.threeSum(temp));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first=0; first<len; first++) {
            if (first>0 && nums[first]==nums[first-1]) {
                continue;
            }
            int third = len-1;
            int target = -nums[first];
            for (int second = first+1; second<len; second++) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
