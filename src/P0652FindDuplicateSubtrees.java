import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P0652FindDuplicateSubtrees {
    ArrayList<TreeNode>ans;
    HashMap<String,Integer>count;
    public List<TreeNode>findDuplicateSubtrees(TreeNode root){
         ans=new ArrayList<>();
         count=new HashMap<>();
         Serialize(root);
         return ans;
    }
    private String Serialize(TreeNode root){
      if(root==null)return "#";
      String serialize=root.val+","+Serialize(root.left)+","+Serialize(root.right);
      count.put(serialize, count.getOrDefault(serialize, 0)+1);
      if(count.get(serialize)==2){//因为是递归函数，所以一旦出现2次的子序列就立刻加入到答案里。
         ans.add(root);
      }
      return serialize;
    }
}
//求每个subtree的序列化号就是当前子树的root以及它的左右节点