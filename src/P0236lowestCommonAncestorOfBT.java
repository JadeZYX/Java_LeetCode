
public class P0236lowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        if(root==p||root==q){//此时root就是P或者是Q，所以直接返回root。
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null) return root;//left and right are all exist,so the father node is there ancestor
        else if(left==null){
            return right;
        }
        else{
            return left;
        }
    }
}//题目要求求P和Q的最近公共父节点，我们可以traverse整棵树来找目标节点。一旦找到就返回，然后看目标节点的位置。
//如果目标节点存在于左右subtrees，则返回左右子树的跟节点，如果存在于一侧，则返回那一侧最先找到的那个目标值。
/*
这道题的思考入口是p,q所在的位置，如果落在不同的左右子树上，比如6，8.从3节点开始同时找p,q，
在它的left找到了p,不需要再继续找q,一层层的返回最上层。然后在3的right subtree找到了8，返回。
因为得到的left 和 right都存在，所以返回root 节点 3 作为 ancestor。
如果p,q都落在left subtree上，比如 5，4.从3开始先递归左侧搜索，找到了5直接返回，3的right subtree
会返回null，所以取了左侧返回的5.
如果p = 6,q=4, 需要返回的是root 5， 因为6，4 是5为root树的左右两个子树的节点
LCA(3,6,4) 右子树肯定返回的是NULL。需要递归反复调用的是左子树
LCA(5,6,4)->LCA(5.left,6,4)即（6，6，4）找到6，不需要再继续往左下角搜索，
返回给参数5.left 节点6作为左支搜索结果。->LCA(5.right,6,4)即(2,6,4)->LCA(2.left,6,4)->LCA(7.left,6,4)return Null给上一层作为7的left的结果。
->LCA(7.right,6,4) return NULL给2的左子树，再
查看LCA(2.right,6,4)->return 4 作为2的right的查询结果。此时节点2一个NULL，一个4，取4 返回给上层
5的right subtree的搜索结果。由于5的左侧是6，右侧是4，所以返回5给上层的3.此时节点3的左侧返回3，右侧Null，所以取5.
*/