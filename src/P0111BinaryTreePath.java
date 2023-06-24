

public class P0111BinaryTreePath {
    public int minDepth(TreeNode root){
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



    /*
    这道题目的难点在于需要考虑的是找到没有左右children的Leaf，所以对于只存在一个child的情况需要单独处理。
    //若left child不存在或者是right child不存在，不能返回min，因为这时候root是有一个right child的，
    不符合题目要求的Leaf is a node with no children。所以要返回右subtree的最大值了
    private int minDepth1(TreeNode root){
        if(root==null)return 0;
        if(root.left!=null&&root.right!=null){
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }
        else{
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }
    }
    */
}
