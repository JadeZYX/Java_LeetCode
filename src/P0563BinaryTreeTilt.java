public class P0563BinaryTreeTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
