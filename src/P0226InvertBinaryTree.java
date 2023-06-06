public class P0226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
/*
        P0226InvertBinaryTree p226=new P0226InvertBinaryTree();
        BinaryTree bt=new BinaryTree(new Integer[]{4,2,7,1,3,6,9});
        BinaryTree bt1=new BinaryTree(new Integer[]{2,1,3});
        BinaryTree bt2=new BinaryTree(new Integer[]{});
        BinaryTree.printTree(p226.invertTree(bt.root));
        System.out.println();
*/