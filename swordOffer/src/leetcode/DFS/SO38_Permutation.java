package leetcode.DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SO38_Permutation {
    public static void main(String[] args) {

    }
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length -1) {
            res.add(String.valueOf(c)); //排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=x; i<c.length; i++) {
            if (set.contains(c[i])) continue;;
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
/*
*https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/hui-su-suan-fa-java-by-liweiwei1419/
* */