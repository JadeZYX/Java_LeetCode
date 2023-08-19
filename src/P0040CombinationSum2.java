import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P0040CombinationSum2 {
  List<List<Integer>>ans;
  public List<List<Integer>> combinationSum2(int[]candidates, int target){
    ans = new ArrayList();
    if(candidates == null || candidates.length ==0) return ans;
    Arrays.sort(candidates);
    backtracking(new ArrayList<Integer>(),candidates,target,0);
    return ans;
  }

  public void backtracking(List<Integer>tempList,int[]nums, int remain, int start){
    //回溯的写法：boundary， valid result, forloop
    if(remain <0) return;
    else if(remain == 0){
      ans.add(new ArrayList<>(tempList));
      return;
    }
    else{
      for(int i = start;i<nums.length;i++){
        if(i>start && nums[i]==nums[i-1])continue;
        tempList.add(nums[i]);
        backtracking(tempList, nums, remain-nums[i],i+1);
        tempList.remove(tempList.size()-1);
      }
    }
  }
}
/*
 Time complexity will be O(2^n * n)
 two to the power of n times n
because every element have two choices either pick or not pick.
 and n extra because we are using a while loop inside the recursive function which will add n time complexity.
 */

