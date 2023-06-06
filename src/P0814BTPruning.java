public class P0814BTPruning {
    public TreeNode pruneTree(TreeNode root){
        if (!containOne(root)) {
            return null;
        }

        return root;
    }

    boolean containOne(TreeNode node){//是否含有1
        if(node==null)return false;
        boolean left_contain=containOne(node.left);//check左右subtree是否含有1
        boolean right_contain=containOne(node.right);
        if(!left_contain){//If the left subtree does not contain a 1, prune the subtree.
            node.left=null;
        }
        if(!right_contain){
            node.right=null;
        }
        return node.val==1||left_contain||right_contain;
    } // Return true if the current node, its left or right subtree contains a 1.
    public TreeNode pruneTree1(TreeNode root){
        if(containAllZero(root)){
            return null;
        }
        return root;
    }
    boolean containAllZero(TreeNode node){
        if(node==null)return true;
        boolean Lsubtree=containAllZero(node.left);
        boolean Rsubtree=containAllZero(node.right);
        if(Lsubtree){
            node.left=null;
        }
        if(Rsubtree){
            node.right=null;
        }
        return node.val==0&&Lsubtree&&Rsubtree;
    }
}
