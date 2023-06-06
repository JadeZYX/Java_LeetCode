import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P0103BTZigzagLevelOrderTraversal {
    public List<List<Integer>>zigzagLevleOrder(TreeNode root){
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            level++;
            List<Integer>anslevle=new ArrayList<>();
            int levelSize=queue.size();
            while(levelSize!=0){
                TreeNode popNode=queue.poll();
                if(level%2!=0){//单层的时候直接添加到结尾
                    anslevle.add(popNode.val);
                }
                else if(level%2==0){
                    anslevle.add(0,popNode.val);//双层的时候从前面开始添加
                }
                if(popNode.left!=null){
                    queue.offer(popNode.left);
                }
                if(popNode.right!=null){
                    queue.offer(popNode.right);
                }
                levelSize--;
            }
            ans.add(anslevle);
        }
        return ans;
    }
}
