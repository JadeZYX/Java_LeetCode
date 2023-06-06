
import java.util.Stack;

public class P0114FlattenBTToLinkedList {
    public void flatten0(TreeNode root){
        flat(root);   
    }
    //transform the subtree(with node as a root) to a linked list,and return the tail of the linkedlist
    TreeNode flat(TreeNode node){
        if(node==null)return null;
        TreeNode leftTail=flat(node.left);//head is node.left
        TreeNode rightTail=flat(node.right);//head is node.right
        if(leftTail==null&&rightTail==null){
            node.left=null;
            node.right=null;
            return node;
        }
        else if(leftTail==null){//only has right list
            node.left=null;
            return rightTail;
        }
        else if(rightTail==null){//only has left list
            node.right=node.left;
            node.left=null;
            return leftTail;
        }
        else{//has both left and right list
            leftTail.right=node.right;
            node.right=node.left;
            node.left=null;
            return rightTail;
        }
    }
    //stack做法
    public void flatten(TreeNode root){
        if (root == null)   return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {             
            TreeNode cur = stack.pop();
           if(cur.right!=null) stack.push(cur.right);
           if(cur.left!=null) stack.push(cur.left);
            if (!stack.isEmpty()) cur.right = stack.peek();
            cur.left = null; 
        }
    }
}
