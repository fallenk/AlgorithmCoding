package leetcode.dynamic;

import java.util.Deque;
import java.util.LinkedList;

public class LC739_DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures1(int[] T) {
        if (T == null) return null;
        int length = T.length;
        int[] res = new int[length];
        boolean flag = false;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if(T[i]<=T[j]) {
                    res[i] = j-i;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                res[i] = 0;
            } else {
                flag = false;
            }

        }
       return res;
    }

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<len; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
