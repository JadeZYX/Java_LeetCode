public class P1929ConcatenationArray {
    public int[]getConcatenation(int[]nums){
        int[]res=new int[nums.length*2];
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            res[i]=nums[i];
            res[i+len]=nums[i];
        }
        return res;
    }
    public int[] getConcatenation1(int[] nums) {
        int[]ans=new int[nums.length*2];
        int left=0;
        int right=nums.length;
        while(left<nums.length&&right<ans.length){
            ans[left]=nums[left];
            ans[right]=ans[left];
            left++;
            right++;
        }
        return ans;
    }
}
/*
       P1929ConcatenationArray p1929=new P1929ConcatenationArray();
       int[]res=p1929.getConcatenation(new int[]{1,3,2,1});
       for(int i:res){
           System.out.print(i+" ");
       }
*/
