public class P0783MinDistanceBetweenBSTNodes {
    int min=Integer.MAX_VALUE;
    int previous=-1;
    public int minDiffInBST(TreeNode root){
        inOrder(root);
        return min;
    }
    void inOrder(TreeNode node){
        if(node==null)return;
        inOrder(node.left);
        if(previous!=-1){
            int distance=Math.abs(node.val-previous);
            min=Math.min(min, distance);
        }
        previous=node.val;
        inOrder(node.right);
    }
}//这道题类似530.中序遍历，求相邻值的绝对差值
