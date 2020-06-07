public class Find {
    public static void main(String[] args) {
        Find fin = new Find();
//        fin.Find();
    }

    public boolean Find(int target, int[][] array) {
        int col = array.length-1;
        int row = array[0].length-1;

        // 边缘条件
        // 举例子，从特殊到普遍
        for (int i=0, j=row; i<=col&&j<=row&&j>=0; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }
}
