package leetcode.shift;

import java.util.ArrayList;
import java.util.List;
// 1260
public class ShiftGrid {
    public static void main(String[] args) {
        ShiftGrid sg = new ShiftGrid();
        int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(sg.shiftGrid(grid, 1));
    }

    public List<List<Integer>> shiftGrid3(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        for (;k>0; k--) {
            int[][] newGrid = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m-1; j++) {
                    newGrid[i][j+1] = grid[i][j];
                }
            }

            for (int i=0; i<n-1; i++) {
               newGrid[i+1][0] = grid[i][m-1];
            }

            newGrid[0][0] = grid[n-1][m-1];
            grid = newGrid;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<m; j++) {
                temp.add(grid[i][j]);
            }
            res.add(temp);
        }

        return res;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        for (; k>0; k--) {

            int previous = grid[n-1][m-1];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    int temp = grid[i][j];
                    grid[i][j] = previous;
                    previous = temp;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<m; j++) {
                temp.add(grid[i][j]);
            }
            res.add(temp);
        }

        return res;
    }

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        for (int i=0; i<k; i++) {
            grid = changeGrid(grid);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<grid.length; i++) {
            List<Integer> column = new ArrayList<>();
            for (int j=0; j<grid[0].length; j++) {
                column.add(grid[i][j]);
            }
            res.add(column);
        }
        return res;
    }
    private int[][] changeGrid(int[][] grid) {
        List<Integer> lastColumn = new ArrayList<>();
        int columnLen = grid[0].length;
        int rowLen = grid.length;

        for (int j=columnLen-1; j>0; j--) {
            for (int i=0; i<rowLen; i++) {
                if (j == columnLen-1) {
                    int last = grid[rowLen-1][columnLen-1];
                    for(int k=rowLen-1; k>0; k--) {
                        grid[k][j] =grid[k-1][j];
                    }
                    grid[0][j] = last;
                    for (int k=0;k<rowLen-1; k++) {
                        lastColumn.add(grid[k][j]);
                    }
                }
                grid[i][j] = grid[i][j-1];
            }
        }
        for (int j=0; j<rowLen; j++) {
            grid[0][j] = lastColumn.get(j);
        }
        return grid;

    }

    public List<List<Integer>> shiftGrid5(int[][] grid, int k){
        int numCols = grid[0].length;
        int numRows = grid.length;
        List<List<Integer>> newGrid = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            newGrid.add(newRow);
            for (int j=0; j< numCols; j++) {
                newRow.add(0);
            }
        }
        for (int i=0;i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
               int newCol = (j+k) % numCols;
               int wrapAroundCount = (j+k)/numCols;
               int newRow = (i + wrapAroundCount) % numRows;
               newGrid.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return newGrid;
    }
}
