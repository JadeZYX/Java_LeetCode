public class P0098ValidateBinarySearchTree {

  public boolean isValidBST0(TreeNode root) { //时间O(n)每个节点访问一次 + 空间O(h) 递归的深度
    return isValidHelper0(root,Long.MIN_VALUE,Long.MAX_VALUE);//因为constraints，不能用int
    //否则当root节点是2的31次幂-1的时候结果有误
 }

 private boolean isValidHelper0(TreeNode node,long min, long max){
     if(node == null) return true; //如果根节点不存在返回tree
     if(node.val >= max) return false;
     if(node.val <= min) return false;
     return isValidHelper0(node.left,min,node.val) && isValidHelper0(node.right, node.val, max);
 }



  public boolean isValidBST(TreeNode root){//时间O(n)每个节点访问一次 + 空间O(h) 递归的深度
    return isValidHelper(root,null,null);//根据限制条件constraints,null节点代表无穷大
  }

  private boolean isValidHelper(TreeNode node, TreeNode minNode, TreeNode maxNode){
    if(node == null) return true;//if not node, then true
    if(maxNode != null && node.val >= maxNode.val) return false;//需判断maxNode不为空，因为传入的是Null
    if(minNode != null && node.val <= minNode.val) return false;
   // if(node.left == null && node.right == null) return true; 这行可不要
    return isValidHelper(node.left,minNode,node) && isValidHelper(node.right, node, maxNode);
  }

  boolean isValid = true;
    public boolean isValidBST2(TreeNode root) {
        //不能只判断每个subtree的左右子树比它的parent节点一个大，一个小
        //同时左子树的每个节点都要比root节点小，且右子树的每个节点都要比它的root节点大
        //所以检查每一个节点是否在合法的取值范围内，每个节点都有个最大值最小值
        validHelper(root,null,null);
        return isValid;
    }
    void validHelper(TreeNode node, TreeNode minNode, TreeNode maxNode){
        if(node == null) return;
        if(minNode != null && node.val <= minNode.val){
                isValid = false;
                return;
        }
        if(maxNode != null && node.val >= maxNode.val){
            isValid = false;
            return;
        }
        validHelper(node.left,minNode,node);
        validHelper(node.right,node,maxNode);
    }


}
/* 这道题目的陷阱在于不能只简单的用这个代码
        if(root == null) return true;
        if(root.left != null && root.val <=root.left.val) return false;
        if(root.right != null && root.val >=root.right.val) return false;
        if(root.left == null && root.right == null) return true;
        return isValidBST(root.left) && isValidBST(root.right);

因为这样只能判断每个独立的小subtree是否满足，不能确保整棵大树
满足BST的条件，它要求的是整棵大树的left subtree都要比root要小，而整棵大树的right subtree都要比root大。
       5
      / \
     3   7
        / \
       4   8  这里虽然单独看7，4，8这颗小树是BST，但是4节点仅仅是小于7这个subtree的root节点，它没有满足
               要大于root 5 大树的根节点。所以只用下面的代码就会出错

正确解释
             a (root) （Integer.MIN_VALUE, Integer.MAX_VALUE)
        <a  /  \  >a
           /    \
         L        R
     L的范围是 (Integer.MIN_VALUE, a)
     R的范围是(a,Integer.MAX_VALUE)
     Property of a binary search tree : 1) root.val > all values in L
                                        2) root.val < all values in R
                                        3) Inorder traversal, values are sorted


    假如有这么一棵树  5
                  /  \
                 3    7
                     / \
                    4   8
    递归走法 isValidH(5,null,null)->isValidH(3,null,5)返回true && isValidH(7,5,null)
        isValidH(4,5,7) 返回false && isValidH(8,7,null)


   example 2 的 递归走法
    1)isValidH(5,null,null)-> 2)isValidH(1,null,5) && 3)isValidH(4,5,null)
    2）可以返回true。 3）继续走， 4作为5节点的右子树节点，最小值必须要大于root节点5这个值，最大是无穷大，所以23行直接返回false给 3）
    此时5的left返回true,5的right返回false，则返回给1）的结果是false
*/