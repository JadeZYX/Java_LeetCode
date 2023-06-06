public class P0112PathSumBT {
    boolean isValid = false;//只要有一条path符合条件就形，所以这里布尔值初始值是false
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum=targetSum;
        sumOfTree(root, 0);
        return isValid;
    }
    private void sumOfTree(TreeNode root, int sum) {
       if(root==null) return;
       sum+=root.val;
       if(root.left==null&&root.right==null){
           if(sum==targetSum){
               isValid=true;
           }
           return;
       }
       sumOfTree(root.left, sum);
       sumOfTree(root.right, sum);
    }
}
