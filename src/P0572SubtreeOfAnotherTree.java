public class P0572SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root,TreeNode subRoot){
        if(root==null&&subRoot==null)return true;
        if(root==null)return false;
        if(isSametree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }
    
    boolean isSametree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null)return true;
        if(node1==null||node2==null)return false;
        return isSametree(node1.left, node2.left)&&isSametree(node1.right, node2.right)&& node1.val==node2.val;
    }

}
