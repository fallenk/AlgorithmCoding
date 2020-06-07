package leetcode.tree;

//import javax.swing.tree.TreeNode;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class IsSymmetric {
    public static void main(String[] args) {
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val && check(left.left, right.right) && check(left.right, right.left)) {
            return true;
        }
        return false;
    }
}
