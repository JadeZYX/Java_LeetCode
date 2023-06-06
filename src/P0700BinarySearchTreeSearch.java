public class P0700BinarySearchTreeSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == val) {
                return p;
            } else if (val < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return null;
    }

    public void helper(TreeNode root, int val) {
        if (root == null)
            return;
        if (root.val == val) {
            target = root;
            return;
        } else if (root.val > val) {
            helper(root.left, val);
        } else {
            helper(root.right, val);
        }
    }

    TreeNode target;

    public TreeNode searchBST1(TreeNode root, int val) {
        helper(root, val);
        return target;
    }
}
