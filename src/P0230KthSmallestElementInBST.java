public class P0230KthSmallestElementInBST {
    int count;
    int target;
    int ans;
    public int kthSmallest(TreeNode root,int k){
        this.target=k;
        count=0;
         inOrder(root);
         return ans;
    }
    void inOrder(TreeNode node){
        if(node==null)return;
        inOrder(node.left);
        count++;
        if(count==target){
            ans=node.val;
        }
        inOrder(node.right);
    }
}
