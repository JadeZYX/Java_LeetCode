
public class P0104MaximumDepthOfBTree {
    int maxdepth=0;
    public int maxDepth1(TreeNode root){
        helpmaxDepth(root, 0);
        return maxdepth;
    }
    private void helpmaxDepth(TreeNode root, int depth){
        if(root==null){
            maxdepth=Math.max(maxdepth, depth);
            return;
        }
        helpmaxDepth(root.left, depth+1);
        helpmaxDepth(root.right, depth+1);
    }
    public int maxDepth(TreeNode root){//自下而上
        if(root==null)return 0;
        int leftSubtree=maxDepth(root.left);
        int rightSubtree=maxDepth(root.right);
        return Math.max(leftSubtree, rightSubtree)+1;
    }
    int maxdep=Integer.MIN_VALUE;
    public int maxDep2(TreeNode root){
        if(root==null)return 0;
        helpmaxDepth2(root, 1);//传入1
        return maxdep;
    }
   private void helpmaxDepth2(TreeNode node, int dep){////传入参数是当前节点的深度
       if(node==null){
           return;
       }//当为叶节点的时候进行对比且更新全局变量，且node==null返回，所以传入的dep是当前node的深度
       if(node.left==null&&node.right==null){
           maxdep=Math.max(maxdep, dep);
           return;
       }
       helpmaxDepth2(node.left, dep+1);
       helpmaxDepth2(node.right, dep+1);
   }
}  
/*
求一棵树的最大深度，也就是求其左subtree的深度和右subtree的深度，然后取左右深度的较大值+1，这里的加1指本身的跟节点
而求左右subtree的深度这个可以用递归。
这是一种自下而上的做法，也就是需要知道最下面的一层结果，然后不断的用递归从而得出最上面的结果。
//自上而下求max深度  设置一个全局变量用来记录最大深度。辅助函数里从上到下记录深度，遍历每个节点，且将当前的深度返回给下一层
下一层如果存在节点就+1，如果为空节点就不需要+1，所以进入辅助函数的值是0开始。如果跟节点存在就+1，然后遍历leftchild。
*/