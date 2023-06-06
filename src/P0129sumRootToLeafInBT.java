public class P0129sumRootToLeafInBT {
    int total;
    public int sumNumbers(TreeNode root){
        total=0;
        if(root==null)return total;
        preorder(root,0);
        return total;
    }
    void preorder(TreeNode node,int cur){
        if(node==null) return;
        cur=cur*10+node.val;
        if(node.left==null&&node.right==null){
            total+=cur;
        }
        preorder(node.left, cur);
        preorder(node.right, cur);
    }
}
