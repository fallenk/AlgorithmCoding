package leetcode.array;

// Leetcode 1343
public class NumOfSubarrays {
    public static void main(String[] args) {
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr.length == 0) {
            return 0;
        }
        int cnt=0, len=0,sum=0, number=k;
        while (k <= arr.length) {
            cnt = 0;
            for (int i=sum; i<k; i++) {
                cnt += arr[i];
            }
            if (cnt/number >= threshold) {
                len++;
            }
            k++;
            sum++;
        }
        return len;
    }

}

