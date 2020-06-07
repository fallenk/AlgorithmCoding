import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    // LeetCodee 1597
    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        tree.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, len-1,inorder,0,len-1, map);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex - inStart, rightNodes = inEnd - rootIndex; // 个数
            TreeNode leftSubtree = buildTree(preorder, preStart+1, preStart+leftNodes, inorder, inStart, rootIndex-1, map);
            TreeNode rightSubtree = buildTree(preorder, preEnd - rightNodes+1, preEnd, inorder, rootIndex+1, inEnd, map);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}