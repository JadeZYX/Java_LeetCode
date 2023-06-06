import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P0199BinaryTreeRightSideView_BFS {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<>();//存储结果
        Queue<TreeNode>queue=new LinkedList<>();//初始化对
        if(root==null)return list;//跟节点为空直接返回空list
        queue.offer(root);//不为空则添加root和null null作为层结束标志
        queue.offer(null);
        TreeNode prev=null;
        while(!queue.isEmpty()){//循环条件
            TreeNode top=queue.poll();//变量top来记录删除的节点 先进先出原则
            if(top!=null){//如果删除元素不是null，说明当前层还没有结束
                prev=top;
                if(top.left!=null)   queue.offer(top.left);
                if(top.right!=null)  queue.offer(top.right);
            }
            else{//top==null当前层结束。将记录的null的前一个prev添加到列表
                list.add(prev.val);
                if(!queue.isEmpty()){//若queue里还有元素添加null来区分层
                    queue.offer(null);
                }
            } 
        }
        return list;
    }
    
    
    
    public List<Integer>rightSideView1(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue= new LinkedList<>();//队列的初始化 开头的Queue是接口，TreeNode是类型 链表是表现形式
        queue.add(root);
        queue.add(null);//添加null表示当前曾结束
        TreeNode prev=null;
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();//删除最队列最前面的元素
            if(top==null){//说明是当前层的最后一个
                result.add(prev.val);//添加null前面的值
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            prev=top;
            if(top.left!=null) queue.add(top.left);
            if(top.right!=null) queue.add(top.right);
        }
        return result;
    }
    
}
