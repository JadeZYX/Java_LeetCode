import java.util.ArrayList;
import java.util.List;

public class P0145BinaryTreePostorderTraversal {
    ArrayList<Integer>list;
    public List<Integer>postorderTraversal(TreeNode root){
        list=new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root);
        return list;
    }
    void helper(TreeNode node){
        if(node ==null)return;
        helper(node.left);
        helper(node.right);
        list.add(node.val);
    }
}
