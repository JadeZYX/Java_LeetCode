import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P0515FindLargestValueInEachRowBT {
    public List<Integer>largestValues(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int largestValue=Integer.MIN_VALUE;//记录最大值
            int Qsize=queue.size();//记录当前队列的大小
            while(Qsize!=0){
                TreeNode popNode=queue.poll();
                Qsize--;
                int popVal=popNode.val;
                if(popVal>largestValue){
                    largestValue=popVal;
                }
                if(popNode.left!=null){
                    queue.offer(popNode.left);
                }
                if(popNode.right!=null){
                    queue.offer(popNode.right);
                }
            }
            ans.add(largestValue);// 将每一层求出来的Max添加到答案里
        }
        return ans;
    }
}
