public class P0101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return helpSymmetric(root.left, root.right);
    }

    public boolean helpSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val !=q.val)
            return false;
        return helpSymmetric(p.left, q.right) && helpSymmetric(p.right, q.left);
    }
}
/*
//这棵树若是对称树，则它的左subtree的left child与右subtree的right child一致，且左subtree的rightchild
和右subtree的left child一致，比较两个节点是否一致可以引用sametree的思想，所以这里需要一个辅助函数
        P0101SymmetricTree p101=new P0101SymmetricTree();
        //BinarySearchTree bst=new BinarySearchTree(new int[]{1,2,2,3,4,4,3});
        //System.out.println(p101.isSymmetric(bst.root));

        BinaryTree bt = new BinaryTree(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(p101.isSymmetric(bt.root));
*/