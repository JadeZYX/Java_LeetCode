import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P0102BTLevelOrderTraversal {
    public List<List<Integer>>levelOrder(TreeNode root){
        List<List<Integer>>anslist=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();//这里不能用array list
        if(root==null)return anslist;
        queue.offer(root);
        while(!queue.isEmpty()){
            int sizeLevel=queue.size();//统计每层节点个数
            List<Integer>ansLevel=new ArrayList<>();
            while(sizeLevel!=0){
                TreeNode pollNode=queue.poll();//删除当前层的所有节点
                ansLevel.add(pollNode.val);
                if(pollNode.left!=null){
                    queue.offer(pollNode.left);
                }
                if(pollNode.right!=null){
                    queue.offer(pollNode.right);
                }
                sizeLevel--;
            }
            anslist.add(ansLevel);
        }
        return anslist;
    }
}
