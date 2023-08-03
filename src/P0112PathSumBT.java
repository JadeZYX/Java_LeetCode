public class P0112PathSumBT {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;// 如果这棵树不存在
        if(root.left == null && root.right == null) return root.val == targetSum;
        boolean leftSub = hasPathSum(root.left,targetSum - root.val);
        boolean rightSub = hasPathSum(root.right,targetSum - root.val);
        return leftSub || rightSub;
    }


    boolean isValid = false;//只要有一条path符合条件就形，所以这里布尔值初始值是false
    int targetSum;
    public boolean hasPathSum1(TreeNode root, int targetSum) {
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


    boolean res = false;
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        //自上而下的做法，将差额传入下一层，判断到达叶子节点时候是否是0
        if(root == null) return false;
        helper(root,targetSum);
        return res;
    }
    void helper(TreeNode node, int target){
        if(node == null) return;
        target -= node.val;//只要node不是null，减去它的值
        if (node.left == null && node.right == null && target == 0) {
                res = true;
                return;
        }
        helper(node.left,target);
        helper(node.right,target);
    }
}
