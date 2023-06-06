public class P998maximumBinaryTree2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val){
        if(val>root.val){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        help(root, val);
        return root;
    }
    private void help(TreeNode node,int val){
        if(node.right==null){
            TreeNode newNode=new TreeNode(val);
            node.right=newNode;
            return;
        }
        if(val>node.right.val){
              TreeNode newNode=new TreeNode(val);
              newNode.left=node.right;
              node.right=newNode;
              return;
        }
        help(node.right, val);
    }
}//因为是append到数组里，所以会放到最后，所以添加到值应该放到右subtree且只能拥有leftsubtree
