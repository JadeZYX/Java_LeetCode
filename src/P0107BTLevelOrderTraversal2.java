import java.util.ArrayList;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P0107BTLevelOrderTraversal2 {
    public List<List<Integer>>levelOrderBottom(TreeNode root){
        List<List<Integer>>ans=new LinkedList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        Stack<List<Integer>>buffer=new Stack<>();
        if(root==null)return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int sizeLevel=queue.size();
            List<Integer>levelAns=new ArrayList<>();
            while(sizeLevel!=0){
                TreeNode popNode=queue.poll();
                levelAns.add(popNode.val);
                sizeLevel--;
                if(popNode.left!=null){
                    queue.offer(popNode.left);
                }
                if(popNode.right!=null){
                    queue.offer(popNode.right);
                }
            }
            //ans.add(0,levelAns);//第三种方法，每次都从0的位置开始添加
           // ans.add(levelAns);第一种方法
            buffer.push(levelAns);
        }
        while(!buffer.isEmpty()){
            ans.add(buffer.pop());
        }
        //Collections.reverse(ans);第一种方法是使用了内置method将内部元素倒置
        //第二种办法是使用stack
        
        return ans;
    }
}
