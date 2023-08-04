import java.util.ArrayList;
import java.util.List;


public class P0235AncestorOfaBST {
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {// 递归
        if (root == null || root == p || root == q)
            return root;
        // if(root.val>p.val && root.val<q.val) return root; return语句中包含这种情况
        // if(root.val<p.val && root.val>q.val) return root;
        // 如果q,p都比所处的跟节点值小，则需要在左子树查找
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果q,p都比所处的跟节点的值大，则需要在右子树查找
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;// p,q不管谁大谁小，但只要位于root的左右子树上，则都应该返回root
        // 如果一个比parent.val大，一个比parent.val小，则说明在两侧，直接返回parent节点
    }
    /*
     * 因为是BST，站在传入的节点上(以6为例子)，如果p,q一个节点大，一个比节点小，则说明p,q在6的两侧子树上，当前就是LCA。（比如 example
     * 1）
     * 如果p,q都比传入的节点小，则递归函数搜索的时候只要搜节点的左子树 （example 2）
     * 如果pq都比传入的节点大，则递归搜索右子树
     * 如果q,p任意一个值等于传入的节点，则之间返回当前传入的节点即可
     * example2 分析： 2，4小于6，则调用递归函数走左侧，这时候传入的参数2正好是P，直接返回2即可。不需再找6
     * 若p=3,q=5，则首先递归函数走左侧子树，传入2，3和5大于2，则递归函数走2的右子树即传入4，此时3和5位于4为root的两侧，则返回4，
     * 一层层的像上传递4，直到第一层开始递归函数的位置
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 先获得从root到P和Q的路径并存储在list里。然后找出两个list里最后的一个共同值。O(n)+S(n)
        ArrayList<TreeNode> pathP = getPass(root, p);
        ArrayList<TreeNode> pathQ = getPass(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); ++i) {
            if (pathP.get(i) == pathQ.get(i)) {
                ancestor = pathP.get(i);
            } else {
                break;// 在这里break确保了得出来的i是最lowest的最近的公共祖先
            } // 比如[6,2],[6,2,4]先是6为ancestor，再2更新成ancestor，也就是最后一个一样的值
              // 比如[6,2],[6,8]先是6.然后2和8值不一样，说明出现分叉路经，所以终止循环
        }
        return ancestor;
    }

    private ArrayList<TreeNode> getPass(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> pass = new ArrayList<>();
        while (root.val != target.val) {
            if (target.val > root.val) {
                pass.add(root);
                root = root.right;
            } else if (target.val < root.val) {
                pass.add(root);
                root = root.left;
            }
        }
        pass.add(root);
        return pass;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {// O(n)+S(1)
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {// p<=val<=q(p<val<q||p=val<q P在左下角||p<val=q Q在右下角)
                break;
            }
        }
        return ancestor;
    }
}
