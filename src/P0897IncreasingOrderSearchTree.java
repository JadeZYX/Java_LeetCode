import java.util.ArrayList;

public class P0897IncreasingOrderSearchTree {
    ArrayList<TreeNode> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        for (TreeNode node : list) {
            node.left = null;
            node.right = null;
            cur.right = node;
            cur = cur.right;
        }
        return dummy.right;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;// 出口
        // 拆解
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    // fangfa 2
    TreeNode dummy = new TreeNode(0);
    TreeNode current = dummy;

    public TreeNode increasingBST1(TreeNode root) {
        inorderTraversal1(root);
        return dummy.right;
    }
    public void inorderTraversal1(TreeNode root) {
        if (root == null)
            return;// 出口
        // 拆解
        inorderTraversal1(root.left);
        root.left = null;//更改原来节点左指针的方向。因为只有一个左指针，一个右zhizhen，右指针通过current来更改方向
        current.right = root;
        current = current.right;
        inorderTraversal1(root.right);
    }
    // 首先中序遍历BST 其次遍历结果用新的方式串联起来组成一棵新树
}
