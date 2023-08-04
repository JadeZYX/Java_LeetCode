import java.util.PriorityQueue;

public class P0230KthSmallestElementInBST {
    int count;
    int target;
    int ans;
    //ans , count 作为变量需要设置成全局变量，而K是恒定的可以作为参数传递下去，也可以作成全局变量
    //简单类型的是copy，所以K不管到左子树还是右子树都是copy出一份恒定的值。而ans和count则每次都是开辟新空间，且左右子树的值也许不能相互通知变成一样的值
    public int kthSmallest(TreeNode root,int k){//in order做法最佳
        this.target=k;
        count=0;
         inOrder(root);
         return ans;
    }
    void inOrder(TreeNode node){
        if(node==null)return;
        inOrder(node.left);
        count++;
        if(count==target){
            ans=node.val;
        }
        inOrder(node.right);
    }

    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<TreeNode>queue = new PriorityQueue<>((a,b)->(a.val-b.val));//从小到大排序
        int res = -1;
        if(root == null) return res;
        preorder(root,queue);
        int count = 0;
        while(count < k ){
          TreeNode node = queue.poll();//出队列
          res = node.val;
          count++;
        }
        return res;
     }

     private void preorder(TreeNode node,PriorityQueue<TreeNode>queue){
         if(node == null)return;
         queue.offer(node);//进入优先队列
         preorder(node.left, queue);
         preorder(node.right, queue);
     }

    //  P0230KthSmallestElementInBST p230 = new P0230KthSmallestElementInBST();
    //  BinarySearchTree bt = new BinarySearchTree(new int[]{3,1,4,2});
    //  System.out.println(p230.kthSmallest(bt.root, 1));
}
