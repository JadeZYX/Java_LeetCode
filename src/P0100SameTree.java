import java.util.ArrayList;

public class P0100SameTree {
    public boolean isSameTree0(TreeNode p, TreeNode q){
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        PreTraversal(p, arr1);
        PreTraversal(q, arr2);

        if (arr1.size() != arr2.size()) {
            return false;
        }

        for(int i=0;i<arr1.size();i++){
            if(!arr1.get(i).equals(arr2.get(i))){//这里只能用equal方法，不能用==。因为==是比较引用地址的，而equals用于比较值是否一致
                return false;
            }
        }
        return true;
    }

    public void PreTraversal(TreeNode p, ArrayList<Integer> arr){
        if (p == null) {
            arr.add(Integer.MIN_VALUE); //Null的节点需要添加
            return;
        }

        arr.add(p.val);
        PreTraversal(p.left, arr);
        PreTraversal(p.right, arr);
    }
    public boolean isSameTree(TreeNode p,TreeNode q){
         //两棵树是否一致，可以查看两棵树以当前node为root的subtree是否一样
         //左右子树都为true才返回最终结果true
        if(p==null&&q==null)return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }


}
/*
        P0100SameTree p100=new P0100SameTree();
        BinarySearchTree bst1=new BinarySearchTree();
        bst1.batchInsert(new int[]{1,2,3});
        BinarySearchTree bst2=new BinarySearchTree();
        bst2.batchInsert(new int[]{1,2,3});
        System.out.println(p100.isSameTree(bst1.root,bst2.root));
*/