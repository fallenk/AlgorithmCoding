package leetcode.union;

// https://blog.csdn.net/qq_41593380/article/details/81146850
public class TestUnion {
    int[] pre;//里面全是掌门

    public static void main(String[] args) {

    }

    // 返回的是掌门
    public int unionSearch(int root) {
        int son, tmp;
        son = root;
        while (root != pre[root]) {  //寻找掌门
            root = pre[root];
        }

        while (son != root) {
            tmp = pre[son];
            pre[son] = root;
            son = tmp;
        }
        return root;
    }

    // 链接两个点
    public int[] join(int root1, int root2) {
        int x,y;
        x = unionSearch(root1);
        y = unionSearch(root2);
        if (x != y) {
            pre[x] = y;
        }
        return pre;
    }
}
