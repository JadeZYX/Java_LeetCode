import java.util.ArrayList;
import java.util.List;

public class P0113pathSum2BT {
    List<List<Integer>>ans=new ArrayList<>();
    int Tsum;
    public List<List<Integer>>pathSum(TreeNode root,int targetSum){
        this.Tsum=targetSum;
        List<Integer>paths=new ArrayList<>();
        helpPath(root,0,paths);
        return ans;
    }
    void helpPath(TreeNode node, int sum, List<Integer>path){
        if(node==null) return;
        sum+=node.val;
        path.add(node.val);
        if(node.left==null&&node.right==null){
            if(sum==Tsum){
             ans.add(new ArrayList<>(path));//copy出来的list，对原结果没有影响
            }
            path.remove(path.size()-1);
            return;
        }
        helpPath(node.left, sum,path);
        helpPath(node.right, sum,path);
        path.remove(path.size()-1);//返回之前要把刚添加的节点值给删除
    }
}
