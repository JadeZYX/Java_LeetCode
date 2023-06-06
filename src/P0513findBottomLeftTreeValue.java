import java.util.LinkedList;
import java.util.Queue;

public class P0513findBottomLeftTreeValue {
    public int findBottomLeftValue0(TreeNode root){//BFS
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int res=root.val;
        while(!queue.isEmpty()){
            int sizeLev=queue.size();
            for(int i=0;i<sizeLev;i++){
                TreeNode popE=queue.poll();
                if(i==0){//先进先出，记录最先出来的，每一层其他的直接poll出去就好，不需要记录了
                    res=popE.val;
                }
                if(popE.left!=null){
                    queue.offer(popE.left);
                }
                if(popE.right!=null){
                    queue.offer(popE.right);
                } 
            }
        }
        return res;
    }
    //DFS遍历是借助于深度。先找最大深度，因为最大深度下第一个遍历到的节点就是最左边的节点
    int MaxDep;
    int leftMost;
    public int findBottomLeftValue(TreeNode root){//DFS
        MaxDep=0;
        leftMost=root.val;
        helper(root,0);
        return leftMost;
    }
    void helper(TreeNode node, int dep){
       if(node==null)return;
       dep++;
       if(node.left==null&&node.right==null){
         if(dep>MaxDep){
           MaxDep=dep;//最大深度下遍历出来的第一个节点就是最左边的
           leftMost=node.val;
         }
       }
       helper(node.left, dep);
       helper(node.right, dep);
    }
}
