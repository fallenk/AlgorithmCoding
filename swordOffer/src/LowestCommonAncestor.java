public class LowestCommonAncestor {
    // LeetCode 1513 最近公共父节点

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            if (root == p || root == q) {
                return root;
            } else {
                TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
                TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
                if (leftNode != null && rightNode != null) {
                    return root;
                } else  {
                    return leftNode == null ? rightNode : leftNode;
                }
            }
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val) {
//        this.val = val;
//    }
//}
