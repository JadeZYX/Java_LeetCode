

public class P0111BinaryTreePath {
    public int minDepth(TreeNode root){//自下而上做法
        if(root==null)return 0;
        if(root.left==null){
           return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return (Math.min(minDepth(root.left), minDepth(root.right)))+1;
    }
    //自上而下的做法，假定最小值
    int mindep=Integer.MAX_VALUE;
    public int minDepth1(TreeNode root){
        if(root==null)return 0;
        helpMin(root, 1);
        return mindep;
    }
    private void helpMin(TreeNode node, int depth){
        if(node.left==null&node.right==null){
            mindep=Math.min(mindep, depth);
            return;
        }
        if(node.left!=null){
            helpMin(node.left, depth+1);
        }
        if(node.right!=null){
            helpMin(node.right, depth+1);
        }
    }

    int minDep = Integer.MAX_VALUE;
    public int minDepth2(TreeNode root) {//自上而下
        //必须在叶子节点返回结果
        if(root == null) return 0;
        helper(root,0);
        return minDep;
    }
    private void helper(TreeNode node, int curDep){
        if(node == null) return;
        if(node.left == null && node.right == null){
            minDep = Math.min(curDep+1, minDep);//curDep+当前抵达的叶子节点
        }
        curDep++;//非叶子节点非null节点
        if(node.left != null){
            helper(node.left,curDep);
        }
        if(node.right != null){
            helper(node.right,curDep);
        }
    }

    /*
    这道题目的难点在于需要考虑的是找到没有左右children的Leaf，所以对于只存在一个child的情况需要单独处理。
    //若left child不存在或者是right child不存在，不能返回min，因为这时候root是有一个right child的，
    不符合题目要求的Leaf is a node with no children。所以要返回右subtree的最大值了
这道题与104求最大深度类似，但不能用求最大深度的做法来做。
本题求最小深度，我们可以划分成子问题求左右子树的最小深度。
      3                      3
     /  \                   / \
    9   20                 9  20
        / \               /   / \
      15   7             10  15  7
这里最小深度是2，9 是叶子节点           这里应该返回3，但如果用104的办法则会返回2，因为9的右子树为0
所以这道题的一个trick的地方是一定要到达叶子节点更新最小深度

    */
}
