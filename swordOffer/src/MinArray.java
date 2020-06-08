public class MinArray {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return Integer.MIN_VALUE;

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = i + (j-i)/2;
            if (numbers[m] > numbers[j]) {
                i = m+1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else  {
                j--;
            }
        }
        return numbers[i];

    }

}
