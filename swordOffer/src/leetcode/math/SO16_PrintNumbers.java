package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class SO16_PrintNumbers {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n; i++) {
            str.append('0');
        }
        List<Integer> ans = new ArrayList<>();
        while(!increment(str)) {
            // 去掉左边的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0' ) {
                index++;
            }
            //    System.out.println(str.toString().substring(index));
            ans.add(Integer.parseInt(str.toString().substring(index)));
        }

        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i=str.length()-1; i>=0; i--) {
            char s = (char)(str.charAt(i) +1);
            if (s > '9') {
                str.replace(i, i+1, "0");
                if (i ==0) {
                    isOverflow = true;
                }
            }

            else {
                str.replace(i, i+1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    int[] res;
    int nine=0, count=0, start, n;
    char[] num, loop={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers2(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) -1];
        num = new char[n];
        start = n-1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n-start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x+1);
        }
        nine--;
    }

}
