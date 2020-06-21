import java.util.ArrayList;
import java.util.List;

public class SO17_PrintNumbers {
    public static void main(String[] args) {
        SO17_PrintNumbers so17_printNumbers = new SO17_PrintNumbers();

        so17_printNumbers.printNumbers(1);
    }
    public int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        StringBuilder res = new StringBuilder();
        for (int i=0; i<n; i++) {
            res.append('0');
        }
        List<Integer> ans = new ArrayList<>();
        while (!increment(res)) {

            int index = 0;
            while(res.charAt(index) == '0' && index < res.length()) {
                index++;
            }
            ans.add(Integer.parseInt(res.toString().substring(index)));
            // ans.add(Integer.parseInt(str.toString().substring(index)));
        }

        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            result[i] = ans.get(i).intValue();
        }

        return result;
    }


    private boolean increment(StringBuilder res) {
        boolean isOverFlow = false;
        for(int i= res.length()-1; i>=0; i--) {
            char s = (char) (res.charAt(i) +1);
            if(s > '9') {
                res.replace(i, i+1, "0");
                if (i == 0) {
                    isOverFlow = true;
                }
            } else {
                res.replace(i, i+1, String.valueOf(s));
                break;
            }
        }
        return isOverFlow;
    }
    List<Integer> list;
    public int[] printNumbers2(int n) {
        if (n <= 0) {
            return new int[0];
        }
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void dfs(int n, int i, StringBuilder stringBuilder) {
       if(i == n) {
           while (stringBuilder.length() != 0 && stringBuilder.charAt(0) == '0') {
               stringBuilder.deleteCharAt(0);
           }
           if (stringBuilder.length() != 0) {
                list.add(Integer.parseInt(stringBuilder.toString()));
           }
           return;
       }
       for (int j=0; j<10; j++) {
           stringBuilder.append(j);
           dfs(n ,i+1, stringBuilder);
           if (stringBuilder.length() != 0) {
               stringBuilder.deleteCharAt(stringBuilder.length()-1);
           }
       }

    }
    // ----
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
