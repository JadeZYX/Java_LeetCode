public class P0669TrimBST {
    public TreeNode trimBST(TreeNode root,int low,int high){
        if(root==null)return null;
        if(root.val>high){//如果比Max大，则只需要查看左subtree
            return trimBST(root.left, low, high);
        }
        if(root.val<low){//如果比min小，则只需要看右subtree
            return trimBST(root.right, low, high);
        }
        root.left=trimBST(root.left, low, high);//如果符合要求，继续看它的左
        root.right=trimBST(root.right, low, high);
        return root;//最后返回
    }

}
