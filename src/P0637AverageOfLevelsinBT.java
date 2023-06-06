import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P0637AverageOfLevelsinBT {
    public List<Double>averageOfLevels(TreeNode root){
        List<Double>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        double level_sum;
        while(!queue.isEmpty()){
            level_sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){//确保每层的每个节点都遍历到
                TreeNode current_node=queue.poll();
                level_sum+=current_node.val;//求每层的和
                if(current_node.left!=null){
                    queue.offer(current_node.left);
                }
                if(current_node.right!=null){
                    queue.offer(current_node.right);
                }
            }
            double level_avg=level_sum/size;//求每层的平均值
            ans.add(level_avg);
        }
        return ans;
    }  
}
