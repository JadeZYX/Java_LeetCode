
public class P1920_ArrayEasy {
    public int[] buildArray0(int[]nums){
        int[]ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }

}
