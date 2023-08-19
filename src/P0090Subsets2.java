import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0090Subsets2 {
  List<List<Integer>>ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        if(nums.length ==0 || nums == null) return ans;
        Arrays.sort(nums);//必须sort辅助去重
        backtrack(new ArrayList<>(),nums,0);
        return ans;
    }
    public void backtrack(List<Integer>templist,int[]nums,int start){
        ans.add(new ArrayList<>(templist));
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;// 去重
            templist.add(nums[i]);
            backtrack(templist,nums,i+1);
            templist.remove(templist.size()-1);
        }
    }
}
/*
 Time complexity will be O(2^n * n)
 two to the power of n times n
because every element have two choices either pick or not pick.
 and n extra because we are using a while loop inside the recursive function which will add n time complexity.
 */