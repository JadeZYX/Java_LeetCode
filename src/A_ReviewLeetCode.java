
import java.util.ArrayList;
import java.util.List;

public class A_ReviewLeetCode {
    ArrayList<Integer>list;
    public List<Integer>inorderTraversal(TreeNode root){//traversal tree
        list=new ArrayList<>();
        if(root==null){
           return list;
       }
       helper(root);
       return list;
    }
    private void helper(TreeNode node){
       if(node==null)return;
        helper(node.left);
       list.add(node.val);
       helper(node.right);
    }
    //same tree
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
    //symmetric tree 
    public boolean isSymmetricTree(TreeNode p){
        if(p==null) return true;
        return helper(p.left,p.right);//left subtree and right subtree
    }
    private boolean helper(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return helper(p.left,q.right)&&helper(p.right, q.left);
    }
    //Merge two binary trees
    ////merge trees可以对第一棵树进行操作，如果root存在，则对跟节点以及第一棵树的leftchild
    //和right child进行merge递归操作即可。
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null)return null;
        if(root1==null && root2!=null) return root2;
        if(root1!=null && root2==null) return root1;
        root1.val=root1.val+root2.val;
        root1.left=mergeTrees(root1.left, root2.left);
        root1.right=mergeTrees(root1.right, root2.right);
        return root1;
    }
    //max depth of binary Tree ==root-leaf distance 
    //求一棵树的最大深度，也就是求跟节点到叶节点的距离，也就是最大高度。（左subtree和右subtree取高值）
    public int maxDepth(TreeNode root){//自下而上
        if(root==null)return 0;
        int a=maxDepth(root.left);
        int b=maxDepth(root.right);
        return Math.max(a, b)+1;
    }
    //自上而下求max深度
    //设置一个全局变量用来记录最大深度。辅助函数里从上到下记录深度，遍历每个节点，且将当前的深度返回给下一层
    //下一层如果存在节点就+1，如果为空节点就不需要+1，所以进入辅助函数的值是0开始。如果跟节点存在就+1，然后遍历leftchild。
    int Maxdep=Integer.MIN_VALUE;
    public int maxDepth0(TreeNode root){
        helpDepth1(root,0);
        return Maxdep; 
    }
    private void helpDepth1(TreeNode node,int Dep){
        if(node==null){
            Maxdep=Math.max(Maxdep, Dep);
            return;
        }
        helpDepth1(node.right, Dep+1);
        helpDepth1(node.left, Dep+1);
    }

    int maxdep=0;
    public int maxDepth1(TreeNode root){
        if (root == null) {
            return 0;
        }
       helperDepth(root,1);//传入参数为1
       return maxdep;
    }
    private void helperDepth(TreeNode node, int dep){//传入参数是当前节点的深度
        if (node == null) {
            return;
        }
       //当为叶节点的时候进行对比且更新全局变量，且node==null返回，所以传入的dep是当前node的深度
        if(node.left==null && node.right == null){
           maxdep=Math.max(dep, maxdep);
           return;
        }
        helperDepth(node.left, dep+1);
        helperDepth(node.right, dep+1);
    }

    //banlanced binary Tree
    boolean isValid=true;
    public boolean isBalanced(TreeNode root){
        helpBalance(root);
        return isValid;
    }
    private int helpBalance(TreeNode node){
        if(node==null) return 0;
        int Hl=helpBalance(node.left);
        int Hr=helpBalance(node.right);
        if(Math.abs(Hl-Hr)>1){
            isValid=false;
        }
        return Math.max(Hl, Hr)+1;
    }
    //minimum depth of binary tree 只能用自上而下
    // 假设一个全局变量记录最小值，这个全局变量需要返回，则需要一个辅助函数。需要将当前的深度返回给下一层，所以引用一个变量
    int mindep=Integer.MAX_VALUE;
    public int minDepth(TreeNode root){
        if(root==null)return 0;
        helpeDep(root, 1);
        return mindep;
    }
    private void helpeDep(TreeNode node, int dep){//
        if(node==null)return;
        if(node.left==null&&node.right==null){
            mindep=Math.min(mindep, dep);
            return;
        }
        helpeDep(node.left, dep+1);
        helpeDep(node.right, dep+1);
    }
    public void helpeDep1(TreeNode node,int dep){//32
        if(node.left==null&&node.right==null){
            mindep=Math.min(mindep, dep);
            return;
        }
        if(node.left!=null){
            helpeDep1(node.left, dep+1);
        }
        if(node.right!=null){
            helpeDep1(node.right, dep+1);
        }
    }
    //invert binary tree
    public TreeNode invertTree(TreeNode root) {//自下而上
       if(root==null)return null;
       TreeNode temp=root.left;
       root.left=root.right;
       root.right=temp;
       invertTree(root.left);
       invertTree(root.right);
       return root;
    }//node节点存在，即使node.left==null也不会报错，它表示node的左指向了空
    public TreeNode invertTree1(TreeNode root){
        helpinvert(root);
        return root;
    }
    private void helpinvert(TreeNode node){
        if(node==null)return;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        helpinvert(node.left);
        helpinvert(node.right);
    }

}
