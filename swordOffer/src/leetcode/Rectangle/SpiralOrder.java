package leetcode.Rectangle;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
        System.out.println(so.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int top = 0, right = colLen-1, bottom = rowLen-1, left = 0;
        while (top>bottom && left > right) {
            // 向左搜
            for (int i=left; i<right; i++) {
                res.add(matrix[top][i]);
            }
            // 向下
            for (int i=top; i<bottom; i++) {
                res.add(matrix[i][right]);
            }
            //向左
            for (int i=right; i>left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i=bottom; i>top; i--) {
                res.add(matrix[i][left]);
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        if (top == bottom) {
            for (int i=left; i<=right; i++) res.add(matrix[top][i]);
        } else if (left == right) {
            for (int i=top; i<=bottom; i++) {
                res.add(matrix[i][left]);
            }
        }
        int[] ret = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            ret[i] = res.get(i).intValue();
        }
        return ret;
    }


    public int[] spiralOrder2(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int cnt = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int minLen = Math.min(rowLen, colLen);
        int cycleCnt = (int)Math.ceil(minLen / 2);


        for ( ; cnt < cycleCnt; cnt++) {

            // 向左扫
            int i = cnt;
            int j = cnt;
            if (colLen -1-cnt == cnt && rowLen-1-cnt == cnt) {
                res.add(matrix[cnt][cnt]);
                break;
            }
            if (colLen -1-cnt == cnt) {
                res.add(matrix[i][colLen -1-cnt]);
            } else {
                for ( ; j<colLen-1-cnt; j++) {
                    res.add(matrix[i][j]);
                }
            }


            // 向下扫
            i = cnt; j = colLen -1 - cnt;
            if (rowLen-1-cnt == cnt) {
                res.add(matrix[cnt][j]);
            } else {
                for ( ; i<rowLen-1-cnt; i++) {
                    res.add(matrix[i][j]);
                }
            }

            // 向左扫
            i = rowLen-1-cnt; j=colLen-1-cnt;
            for ( ; j>cnt; j--) {
                res.add(matrix[i][j]);
            }
            //向上扫
            i=rowLen-1-cnt; j = cnt;
            for ( ; i>cnt; i--) {
                res.add(matrix[i][j]);
            }

            cnt++;
        }

        int[] ret = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            ret[i] = res.get(i).intValue();
        }
        return ret;
    }
}
