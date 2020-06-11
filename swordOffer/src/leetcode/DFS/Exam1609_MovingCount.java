package leetcode.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
public class Exam1609_MovingCount {
    public static void main(String[] args) {

    }

//    int m, n, k;
//    boolean[][] visited;
//    public int movingCount(int m, int n, int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0, 0, 0, 0);
//    }
//    public int dfs(int i, int j, int si, int sj) {
//        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
//        visited[i][j] = true;
////        return 1+dfs(i+1, j, (i+1) %10 != 0?si+1:si-8, sj) + dfs(i, j+1, si, (j+1)%10 != 0?sj+1:sj-8);
//        return 1+dfs(i+1, j, , sj) + dfs(i, j+1, si, (j+1)%10 != 0?sj+1:sj-8);
//    }

    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(map[i], 1);
        }
        return dfs(map, 0, 0, k);
    }

    public int dfs(int[][] map, int i, int j, int k) {
        if(i<0 || i>=map.length || j<0 || j>= map[0].length || get(i, j)>k || map[i][j] == 0) {
            return 0;
        }
        int temp =map[i][j];
        map[i][j] = 0;
        return temp + dfs(map, i+1, j, k) + dfs(map, i-1, j, k) + dfs(map, i, j+1, k) + dfs(map, i, j-1, k);
    }

    int get(int x, int y) {
        int res = 0;
        while (x != 0) {
            res += x%10;
            x /= 10;
        }
        while (y != 0) {
            res += y%10;
            y /= 10;
        }
        return res;
    }

    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            if (i>=m || j>= n || get(i, j)>k || visited[i][j] == true) {
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i+1, j});
            queue.add(new int[]{i, j+1});
        }
        return res;
    }

}
