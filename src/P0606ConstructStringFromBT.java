public class P0606ConstructStringFromBT {
    public String tree2str(TreeNode root){
        String str = String.valueOf(root.val);
        if (root.left == null && root.right != null) {
            str += "()" + "(" + tree2str(root.right) + ")";
        }
        else if (root.left != null && root.right == null) {
            str += "(" + tree2str(root.left) + ")";
        }
        else if (root.left == null && root.right == null) {
            
        }
        else {
            str += "(" + tree2str(root.left) + ")";
            str += "(" + tree2str(root.right) + ")";
        }
        
        return str;
    }
}
