import java.util.ArrayList;
import java.util.List;

public class P0257BinaryTreePaths {
    ArrayList<String> paths;
    public List<String> binaryTreePaths(TreeNode root){
        paths=new ArrayList<>();
        if(root==null)return paths;
        helpTreePath(root, "");
        return paths;
    }
    private void helpTreePath(TreeNode node,String path){
        if(node.left==null && node.right==null){
            paths.add(addPath(path, node.val));
            return;
        }
        String nextPath = addPath(path, node.val);
        if (node.left != null) helpTreePath(node.left, nextPath);
        if (node.right != null) helpTreePath(node.right, nextPath);
    }
    
    private String addPath(String path, int val) {
        String nextPath = path;
        if (nextPath == "") {
            nextPath = Integer.toString(val);
        }
        else {
            nextPath = nextPath + "->" + Integer.toString(val);
        }
        
        return nextPath;
    }
    /*
    ArrayList<String> paths;
    public List<String> binaryTreePaths(TreeNode root){
        paths=new ArrayList<>();
        if(root==null)return paths;
        if(root.left==null && root.right==null){
            paths.add(Integer.toString(root.val));
            return paths;
        }
        helpTreePath(root.left, Integer.toString(root.val));
        helpTreePath(root.right, Integer.toString(root.val));
        return paths;
    }
    private void helpTreePath(TreeNode node,String path){
        if (node == null) {
            return;
        }
        if(node.left==null && node.right==null){
            paths.add(path + "->" + Integer.toString(node.val));
            return;
        }

        String nextPath = path + "->" + Integer.toString(node.val);
        helpTreePath(node.left, nextPath);
        helpTreePath(node.right, nextPath);
    }
    */
}

