package leetcode.shift;

import java.util.ArrayList;
import java.util.List;

public class HasGroupSizeX {
    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qiu-jie-zui-da-gong-yue-shu-java-by-liweiwei1419/
    }

    public boolean hasGroupSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<>();
//        for ()
        return false;
    }
}
