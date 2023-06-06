
public class P0236lowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        if(root==p||root==q){//此时root就是P或者是Q，所以直接返回root。
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null) return root;//left and right are all exist,so the father node is there ancestor
        else if(left==null){
            return right;
        }
        else{
            return left;
        } 
    }
}//题目要求求P和Q的最近公共父节点，我们可以traverse整棵树来找目标节点。一旦找到就返回，然后看目标节点的位置。
//如果目标节点存在于左右subtrees，则返回左右子树的跟节点，如果存在于一侧，则返回那一侧最先找到的那个目标值。
