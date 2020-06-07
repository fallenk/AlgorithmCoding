package leetcode.Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 84
public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea s = new LargestRectangleArea();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea2(heights));
    }

    // S = W * H
    // 枚举 高度，我们可以使用一重循环枚举某一根柱子的高度，将其固定为矩形的高度h。随后我们对这根柱子开始向两侧延伸，知道遇到高度小于h的柱子，
    // 就确定了矩形的左右边界。如果左右边界宽度之间为w，那么面积为w*h。
    // 思考二：枚举 宽度？固定左边界，巡航护
    // 暴力解法 缺点，每一路循环计算没有为下一轮记录下有用的信息！！  这是优化解法的第一步，空间换时间，
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int len = heights.length;
        for (int i=0; i<len; i++) {
            int h = heights[i];
            int left = i, right= i;
            while (left-1>=0 && heights[left-1] >= h) {
                left--;
            }
            while (right+1<len&&heights[right+1] >= h) {
                right++;
            }
            int w = right-left+1;
            area = Math.max(area, h*w);
        }
        return area;
    }

    // 使用 哨兵，避免特殊情况的讨论
    // 哨兵技巧的其他应用: 单链表的虚拟节点， 插入排序
    public int largestRectangleArea2(int[] heights){
        int len = heights.length;
         if (len == 0) {
             return 0;
         }
         if (len == 1) {
             return heights[0];
         }
         int area = 0;
         Deque<Integer> stack = new ArrayDeque<>();
         for (int i=0; i<len; i++) {
             // 出栈操作
             while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                // 当前元素高度 == 栈顶，也出栈
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                area = Math.max(area, width * height);
             }
             // 入栈
            stack.addLast(i);
         }
         // 剩余的出栈
         while (!stack.isEmpty()) {
             int height = heights[stack.removeLast()];
             while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                 stack.removeLast();
             }
             int width;
             if (stack.isEmpty()) {
                 width = len;
             } else {
                 width = len - stack.peekLast() - 1;
             }
             area = Math.max(area, width * height);
         }
         return area;
    }

    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}

