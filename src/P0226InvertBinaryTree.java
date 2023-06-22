public class P0226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        /**** 前序位置 ****/
    // 用「遍历」的思维模式解决 遍历每个节点，让每个节点的左右子节点颠倒过来就行了。
    //每一个节点需要做的事就是交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 遍历框架，去遍历左右子树的节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
     //用「分解问题」的思维模式解决 . 可以用 invertTree(x.left) 先把 x 的左子树翻转，再用 invertTree(x.right) 把 x 的右子树翻转，最后把 x 的左右子树交换，这恰好完成了以 x 为根的整棵二叉树的翻转，即完成了 invertTree(x) 的定义。
        if(root == null){
            return root;
        }
       TreeNode leftnew = invertTree(root.left);
       TreeNode rightnew = invertTree(root.right);
       root.left = rightnew;
       root.right = leftnew;
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