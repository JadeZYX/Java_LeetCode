
public class P0617MergeBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
/*
      //merge trees可以对第一棵树进行操作，如果root存在，则对跟节点以及第一棵树的leftchild和
      right child进行merge递归操作即可。
       P0617MergeBinaryTrees p617 = new P0617MergeBinaryTrees();
        BinaryTree bt1 = new BinaryTree(new Integer[] { 1, 3, 2, 5 });
        BinaryTree bt2 = new BinaryTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });
        BT_TreeNode merge = p617.mergeTrees(bt1.root, bt2.root);
        BinaryTree.printTree(merge);
*/
