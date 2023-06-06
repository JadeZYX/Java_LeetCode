public class P0110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {//由于主函数和辅助函数都要遍历整个数，所以O（N*N）
        if (root == null)
            return true;
        boolean leftSubtree = isBalanced(root.left);
        boolean rightSubtree = isBalanced(root.right);
        int Lheight = getheight(root.left);
        int Rheight = getheight(root.right);
        return leftSubtree && rightSubtree && (Math.abs(Lheight - Rheight) <= 1);
    }
//题解：平衡树需要满足它的左subtree是平衡树，它的右subtree是平衡树，以及左右高度差小于等于1.按照这种思路写
//主函数。辅函数用来求高度。一棵树的高度只有一个，就是左右子树的Max+1.所以我需要知道左subtree的高度和右subtree的高度，
//然后取较大值。递归结束语句是当走到Leaf节点高度就为0.
    int getheight(TreeNode node) {
        if (node == null)
            return 0;
        int L = getheight(node.left);
        int R = getheight(node.right);
        return Math.max(L, R) + 1;
    }
    boolean isBT=true;
    public boolean isBalanced1(TreeNode root){ //对上述方法对优化
        TravesalHeight(root);
        return isBT;
    }
    int TravesalHeight(TreeNode node){
        if(node==null) return 0;
        int HL=TravesalHeight(node.left);
        int HR=TravesalHeight(node.right);
        if(Math.abs(HL-HR)>1){
            isBT=false;
        }
        return Math.max(HL, HR)+1;
    }
}
