public class P0530MinimumAbsoluteDifferenceInBST {
    int previous=-1;
    int minAb=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
       inOrder(root);
        return minAb;
    }
    void inOrder(TreeNode node){
        if(node==null)return;
        inOrder(node.left);
        if(previous!=-1){//如果previous等于-1，说明是跟节点，此时没有绝对差值
            int ab=Math.abs(node.val-previous);
            minAb=Math.min(minAb, ab);
        }
        previous=node.val;//上面用完了之前存储的previous，参与过了运算，现在更新当前的节点为previous以用于下次计算
        inOrder(node.right);
    }
}//题目要求任意两个节点的最小绝对值差。因为是BST，所以按照中序遍历就是从小到大的顺序。所以相邻的两个数就有可能成为
//最小绝对值差。设置两个全局变量，一个是最小绝对值，一个是当前节点的前一个节点。（保存前一个节点来求差值）。
