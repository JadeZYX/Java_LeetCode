import java.util.LinkedList;
import java.util.Queue;

public class P0623AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root,int val,int depth){
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
          }
          Queue<TreeNode>queue=new LinkedList<>();
          queue.offer(root);
          int dep=1;
          while(!queue.isEmpty()){
              int levelsize=queue.size();
              while(levelsize!=0){
                  TreeNode popNode=queue.poll();
                  if(dep==depth-1){
                      TreeNode newleft=new TreeNode(val);
                      TreeNode newright=new TreeNode(val);
                      newleft.left=popNode.left;
                      newright.right=popNode.right;
                      popNode.left=newleft;
                      popNode.right=newright;
                      levelsize--;
                      continue;   
                  }
                  if(popNode.left!=null){
                      queue.offer(popNode.left);
                  }
                  if(popNode.right!=null){
                      queue.offer(popNode.right);
                  }
                  levelsize--;
              }
              dep++;
          }
          return root;
    }
}
