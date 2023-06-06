public class P0701InsertIntoABST {
    public TreeNode insertIntoBST0(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        helper(root,val);
        return root;
    }
    void helper(TreeNode node,int val){
       if(node.left==null&&node.val>val){
          node.left=new TreeNode(val);
          return;
       }
       if(node.right==null&&node.val<val){
           node.right=new TreeNode(val);
           return;
       }
        if(node.val<val){
            helper(node.right, val);
        }
        if(node.val>val){
            helper(node.left, val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }
        else{
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}//根据值来确定该往左走还是该往右走，然后看该插入到左还是右。
