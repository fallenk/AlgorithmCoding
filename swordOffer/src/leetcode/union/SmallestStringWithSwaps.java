package leetcode.union;

import java.util.*;

// LeetCode 1202

class DSU {
    int[] parent;
    public DSU(int len) {
        parent = new int[len];
        for (int i=0; i<len; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        int son, tmp;
        son = x;
        while (x != parent[x]) {
            x = parent[x];
        }

        while (son != x) {
            tmp = parent[son];
            parent[son] = x;
            son = tmp;

        }
        return x;
    }

    public int[] join(int x1, int x2) {
        int x = find(x1);
        int y = find(x2);
        if (x != y) {
            parent[x] = y;
        }
        return parent;
    }
}

public class SmallestStringWithSwaps {
    public static void main(String[] args) {

    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        DSU dsu = new DSU(100000);
        // 并查集的集合
        for (List<Integer> list : pairs) {
            dsu.join(list.get(0), list.get(1));
        }
        // 构建 Map存放并查集,每个下标集合有1个leader，用leader作为key(唯一)，下标集合List作为value
        // 从小到大遍历，使得List<Integer>中的值是有序的(事后不用再排序了)
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, unused -> new ArrayList<>()).add(i);
        }

        StringBuilder res = new StringBuilder(s);
        // 遍历所有下标集合
        for (List<Integer> idx_list : map.values())
            if (idx_list.size() > 1)
                sort(res, idx_list);

        return res.toString();
    }

    private void sort(StringBuilder res, List<Integer> idx_list) {
        int len = idx_list.size();
        char[] array = new char[len];
        for(int i=0; i<len; i++) {
            array[i] = res.charAt(idx_list.get(i));
        }
        Arrays.sort(array);
        for (int i=0; i<len; i++) {
            res.setCharAt(idx_list.get(i), array[i]);
        }
    }
}
