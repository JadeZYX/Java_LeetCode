public class P965UnivaluedBinaryTree { //单值
    boolean result = true;
    public boolean isUnivalTree(TreeNode root){//自下而上
        if(root==null) return true;
        if(root.left!=null&&root.val!=root.left.val) return false;
        if(root.right!=null&&root.val!=root.right.val) return false;
        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }

    public boolean isUnivalTree1(TreeNode root){//自上而下
        helper(root, root.val);
        return result;
    }

    private void helper(TreeNode node, int val) {
        if (node == null) return;
        if (node.val != val) {
            result = false;
            return;
        }

        helper(node.left, node.val);
        helper(node.right, node.val);
    }
}
