public class P1315sumOfNodesWithEvenValuedGrandparentInBT {
    //方法1
    int sum=0;
    public int sumEvenGrandparent1(TreeNode root){//O(n)+S(1)
        helpGetSum(root);
        return sum;
    }
    void helpGetSum(TreeNode node){
        if(node==null) return;
        if(node.val%2==0){
            if(node.left!=null){
                if(node.left.left!=null){
                    sum+=node.left.left.val;
                }
                if(node.left.right!=null){
                    sum+=node.left.right.val;
                }
            }
            if(node.right!=null){
                if(node.right.left!=null){
                    sum+=node.right.left.val;
                }
                if(node.right.right!=null){
                    sum+=node.right.right.val;
                }
            }
        }
        helpGetSum(node.left);
        helpGetSum(node.right);
    }
    //方法2
    int Sum=0;
    public int sumEvenGrandparent(TreeNode root){
        GetSum(root,null, null);
        return Sum;
    }
    void GetSum(TreeNode node,TreeNode parent, TreeNode grandpatrent){//通过传入的参数解题
        if(node==null)return;
        if(grandpatrent!=null && grandpatrent.val%2==0){
            Sum+=node.val;
        }
        GetSum(node.left, node, parent);//原来node的位置变成了node.left,parent->node,grandparent->parent
        GetSum(node.right, node, parent);
    }
}
