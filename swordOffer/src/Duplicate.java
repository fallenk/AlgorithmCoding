// 数组中重复的数字
public class Duplicate {

    public static void main(String[] args) {
        Duplicate dup = new Duplicate();
        int[] array = {2,1,3,1,4};
        int[] dupp = new int[5];
        System.out.println(dup.duplicate(array, 5, dupp));
    }

    //    public boolean duplicate(int numbers[], int length, int[] duplication) {
//
//        int[] arr = new int[length];
//        for (int i=0; i<length; i++) {
//            arr[i] = -1;
//        }
//        for(int i=0; i<length; i++) {
//            if (arr[numbers[i]] == -1) {
//                arr[numbers[i]] = numbers[i];
//            } else {
//                int target = arr[numbers[i]];
//                duplication[0] = target;
//                return true;
//            }
//        }
//        return false;
//    }


    // 1. 排序  2. hash表存数据
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <=0) {
            return false;
        }
        for (int i=0; i<length; i++) {


            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                if (numbers[numbers[i]] != numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[temp] = temp;
                }
            }

        }
        return false;
    }

}

