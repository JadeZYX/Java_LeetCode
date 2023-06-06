public class P0654maximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[]nums){
        return help(nums, 0, nums.length-1);
    }
    private TreeNode help(int[]nums,int left,int right){//最差N*N
        if(left>right)return null;
        int max=MaxIndex(nums, left, right);
        TreeNode root=new TreeNode(nums[max]);//create new node
        root.left=help(nums, left, max-1);
        root.right=help(nums, max+1, right);
        return root;
    }

    private int MaxIndex(int[]nums,int left, int right){//求最大索引位置 O(N)+S(1)
        int maxindex=left;
        for(int i=left+1;i<=right;i++){
           if(nums[i]>nums[maxindex]){
               maxindex=i;
           }
        }
        return maxindex;
    }
}
