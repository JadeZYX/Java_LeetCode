import java.util.ArrayList;
import java.util.List;

public class P0144PreorderTraversal {
    ArrayList<Integer>list;
    public List<Integer>preorderTraversal(TreeNode root){
        list=new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root);
        return list;
    }
    void helper(TreeNode root){
       if(root==null)return;
        list.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
