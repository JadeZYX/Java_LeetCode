import java.util.ArrayList;
import java.util.List;

public class P0113pathSum2BT {
    List<List<Integer>>ans=new ArrayList<>();
    int Tsum;
    public List<List<Integer>>pathSum(TreeNode root,int targetSum){//加法 backtracking
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
        }
        helpPath(node.left, sum,path);
        helpPath(node.right, sum,path);
        path.remove(path.size()-1);//返回之前要把刚添加的节点值给删除
        //比如传入节点4后，也调用了4的left subtree和right subtree后就可以删除节点4，这样path里面就只剩下节点5，继续5的right subtree的遍历
    }


    public List<List<Integer>>pathSum1(TreeNode root,int targetSum){//减法
        List<List<Integer>>list = new ArrayList<>();
        if(root == null) return list;
        pathSumHelper(root,targetSum,new ArrayList<Integer>(),list);
        return list;
    }
    private void pathSumHelper(TreeNode node, int target, List<Integer>path,List<List<Integer>>paths){
        path.add(node.val);//因为已经判定过传入的Node不为NULL
        if(node.left ==null && node.right == null && node.val == target){
            paths.add(new ArrayList<>(path));
        }
       if(node.left != null){
            pathSumHelper(node.left, target-node.val, path, paths);
        }
        if(node.right != null){
            pathSumHelper(node.right, target-node.val, path, paths);
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>>list = new ArrayList<>();
        if(root == null) return list;
        helper(root, targetSum, list, new ArrayList<>());
        return list;
    }
    void helper(TreeNode node, int target,List<List<Integer>>list,ArrayList<Integer>path){
        if(node == null) return;
            path.add(node.val);
            target-=node.val;
        if(node.left == null && node.right == null && target ==0){
            list.add(new ArrayList<>(path));
        }
        helper(node.left,target,list,path);
        helper(node.right,target,list,path);
        path.remove(path.size()-1);
    }


}
