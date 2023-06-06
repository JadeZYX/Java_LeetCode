public class BinaryTree {
    public TreeNode root;// 成员变量

    protected BinaryTree() {

    }

    public BinaryTree(Integer[] nums) {
        root = createNode(0, nums);
    }

    private TreeNode createNode(int n, Integer[] nums) {
        if (n >= nums.length || nums[n] == null) {
            return null;
        }

        TreeNode node = new TreeNode(nums[n].intValue());
        node.left = createNode(2 * n + 1, nums);
        node.right = createNode(2 * n + 2, nums);
        return node;
    }

    public void print() {
        printTree(root);
        System.out.println();
    }

    public void printPre() {
        PreOrder(root);
        System.out.println();
        ;
    }

    public void printPost() {
        PostOrder(root);
        System.out.println();
    }

    static void printTree(TreeNode node) {// in-order Traversal
        if (node == null)
            return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public void PreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    private static void PostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.val + " ");
    }
}
