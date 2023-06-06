import java.util.HashSet;
public class P0653TwoSum_BST {
    //方法1
    HashSet<Integer>set=new HashSet<>();
    public boolean findTarget(TreeNode root,int k){
        if(root==null)return false;
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k)||findTarget(root.right, k);
    }
}

