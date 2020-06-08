public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,7,2,4,7,62,3,4,2,1,8,100,19};
        QuickSort qs = new QuickSort();
        int[] res = qs.quickSort(arr, 0, arr.length-1);
        for (int i=0; i<arr.length; i++) {
            System.out.println(res[i]);
        }
    }
    public int[] quickSort(int[] arr, int start, int end) {
       if (start > end) {
           return null;
       }
       if (start == end) {
           return arr;
       }
       int len = arr.length;
       int index = partition(arr, start, end);
       if (index > start) quickSort(arr, start, index-1);
       if (index < end) quickSort(arr, index+1, end);
        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        if (arr == null || start > end || arr.length == 0){
            return -1;
        }
        int baseVal = arr[start];
        int i,j;
        for (i=start, j=end;i<j; ) {
           while (arr[j] > baseVal && i <j) {
               j--;
           }
           while (arr[i] <= baseVal && i <j) {
               i++;
           }

           int temp=0;
           if (arr[i]>baseVal && arr[j] <=baseVal) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
           }
        }
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        return i;
    }
}
