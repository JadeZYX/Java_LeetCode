public class P0572SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //先看root 为 跟节点的大树是否跟subRoot一致
        //如果不一致，继续查看root的left subtree 和 right subtree 是否有一致的
        //corner case
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode node1,TreeNode node2){
        //两棵树是否一致，可以查看两棵树以当前node为root的subtree是否一样
         //左右子树都为true才返回最终结果true
        if(node1 == null && node2==null)return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return isSameTree(node1.left,node2.left) && isSameTree(node1.right, node2.right);
    }
}
