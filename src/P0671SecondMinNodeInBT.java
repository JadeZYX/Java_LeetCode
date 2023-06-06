import java.util.HashSet;

public class P0671SecondMinNodeInBT {
    //第一种方法 //时间复杂度O(N)+空间复杂度O(N)
    HashSet<Integer>nums;
    public int findSecondMinimumValue0(TreeNode root){
        nums=new HashSet<>();
        preorder(root);
        if(nums.size()<2){
            return -1;
        }
        int min=Integer.MAX_VALUE;
        int secMin=Integer.MAX_VALUE;
        for(int i:nums){
            if(i<min){
                secMin=min;
                min=i;
            }
            else if (i < secMin){
                secMin=i;
            }
        }
        return secMin;
    }
    void preorder(TreeNode root){
        if(root==null)return;
        nums.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
//第二种方法
    int ans=-1;
    public int findSecondMinimumValue1(TreeNode root){
         dfs(root,root.val);
        return ans;
    }
    void dfs(TreeNode root, int cur){
        if(root==null) return;
        if(root.val!=cur){
            if(ans==-1){//判断是否是第一次赋值
                ans=root.val;
            }
            else{
                ans=Math.min(ans,root.val);
                return;
            }
        }
        dfs(root.left,cur);
        dfs(root.right,cur);
    }
//第三种方法 时间复杂度O（N）+空间复杂度O（1）
    int firstmin;
    int secondmin=-1;
    public int findSecondMinimumValue(TreeNode root){
        if(root==null)return -1;
        firstmin=root.val;//如果跟节点存在，则跟节点就是整棵树最小值
        traversal(root);
        return secondmin;
    }
    void traversal(TreeNode node){
        if(node==null)return;
        if(node.val>firstmin){
            if(secondmin==-1||secondmin>node.val){
                //若此时还等于-1，则是第一次更新值。若不是第一次更新，则看记录的secmin和当前的值谁更小
                secondmin=node.val;
            }  
        }
        traversal(node.left);
        traversal(node.right);
    }
}
//根据题意，root.val = min(root.left.val, root.right.val)  最小值会不断向上传递，最终跟节点必然是全局最小值。
//如果是所有值都和跟节点都值一样，那也不存在secMin，需要返回-1，所以初始值是-1；
//只要含有除了跟节点值以外的值，下一次遍历的第一个不等于跟节点的值就是secMin。在这之后的节点都是取最小值了。