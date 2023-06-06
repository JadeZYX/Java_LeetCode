public class P0404SumOfLeftLeavesInBST {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root){
        if(root==null)return sum;
        traversal(root.left, true);
        traversal(root.right, false);
        return sum;
    }
    private void traversal(TreeNode node, boolean isLeft){
        if(node==null) return;
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
            return;
        }
        traversal(node.left, true);
        traversal(node.right, false);
    }
}
