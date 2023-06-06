public class P0543DiameterOfBTree {
    int maxDiameter=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        helpDPS(root);
        return maxDiameter;
        
    }
    private int helpDPS(TreeNode node){
        if(node==null)return 0;
        int leftSubtree=helpDPS(node.left);
        int rightSubtree=helpDPS(node.right);
        maxDiameter=Math.max(maxDiameter, leftSubtree+rightSubtree);
        return Math.max(leftSubtree, rightSubtree)+1;
    }
}
//每一个节点所能贡献的最大高度，也就是找出每一个节点的左右孩子，取较长的。
