public class P0938RangeSumOfBST {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    public void helper(TreeNode root, int low, int high) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
    }

    public void helper1(TreeNode root, int low, int high) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            rangeSumBST(root.left, low, high);
        } else {//root.val<low
            rangeSumBST(root.right, low, high);
        }
    }
}
