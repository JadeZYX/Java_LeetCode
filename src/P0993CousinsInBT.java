public class P0993CousinsInBT {
    /*
    int x, y;
    int xDep = 0, yDep = 1;
    boolean isSameParent = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        helper(root, 0);
        return xDep == yDep && !isSameParent;
    }

    void helper(TreeNode node, int dep) {
        if (isSameParent || node == null)
            return;
        if ((nodeEquals(node.left, this.x) && nodeEquals(node.right, this.y))
                || (nodeEquals(node.left, this.y) && nodeEquals(node.right, this.x))) {
            isSameParent = true;
            return;
        }

        dep++;
        if (node.val == this.x) {
            this.xDep = dep;
        } else if (node.val == this.y) {
            this.yDep = dep;
        }

        helper(node.left, dep);
        helper(node.right, dep);

    }

    boolean nodeEquals(TreeNode node, int val) {
        return node != null && node.val == val;
    }
    */
    int x,y;
    int xDep=0;
    int yDep=0;
    boolean sameParent=true;//开始假设x,y节点并不是同父节点
    public boolean isCousins(TreeNode root,int x,int y){//自上而下
        this.x=x;
        this.y=y;
        helper(root,0);
        return xDep==yDep&& sameParent;//我们这里需要返回的是假设成立，代表不是同父节点是成立的
    }
    void helper(TreeNode node,int dep){
         if(node==null)return;
         dep++;
         if(node.left!=null&&node.right!=null){
            if((node.left.val==x&&node.right.val==y)||(node.left.val==y&&node.right.val==x)){
                sameParent=false;//如果满足条件，开始假设的不是同父节点就不成立
                return;
            }
         }
         if(node.val==x){
             xDep=dep;
         }
         if(node.val==y){
             yDep=dep;
         }
        helper(node.left, dep);
        helper(node.right, dep);//这里传入的dep是简单类型
    }
}
