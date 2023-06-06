import java.util.ArrayList;

public class P0235AncestorOfaBST {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        ArrayList<TreeNode> pathP=getPass(root,p);
        ArrayList<TreeNode>pathQ=getPass(root,q);
        TreeNode ancestor=null;
        for(int i=0;i<pathP.size()&&i<pathQ.size();++i){
            if(pathP.get(i)==pathQ.get(i)){
                ancestor=pathP.get(i);
            }
            else{
                break;//在这里break确保了得出来的i是最lowest的最近的公共祖先
            }
        }
        return ancestor;
    }
    private ArrayList<TreeNode> getPass(TreeNode root,TreeNode target){
        ArrayList<TreeNode> pass=new ArrayList<>();
        while(root.val!=target.val){
            if(target.val>root.val){
                pass.add(root);
               root=root.right;
            }
            else if(target.val<root.val){
                pass.add(root);
                root=root.left;
            }
        }
        pass.add(root);
        return pass;
    }
    //先获得从root到P和Q的路径并存储在list里。然后找出两个list里最后的一个共同值。O(n)+S(n)
    public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){//O(n)+S(1)
        TreeNode ancestor=root;
        while(true){
            if(ancestor.val>p.val&&ancestor.val>q.val){
                ancestor=ancestor.left;
            }
            else if(ancestor.val<p.val&&ancestor.val<q.val){
                ancestor=ancestor.right;
            }
            else{//p<=val<=q(p<val<q||p=val<q P在左下角||p<val=q Q在右下角)
                break;
            }
        }
        return ancestor;
    }
}
