import java.util.ArrayList;
import java.util.List;
public class P0078Subsets {
  List<List<Integer>>ans;
  public List<List<Integer>>subsets(int[]nums){//O(2^n*n)two to powerof n timsn
    ans = new ArrayList();
    if(nums.length == 0 || nums==null) return ans;
    backtrack(new ArrayList<>(),nums,0);
    return ans;

  }
  public void backtrack(List<Integer>tempList,int[]nums,int start){
    ans.add(new ArrayList<>(tempList));
    for(int i = start; i<nums.length;i++){
      tempList.add(nums[i]);
      backtrack(tempList, nums, i+1);
      tempList.remove(tempList.size()-1);
    }
  }
}
/*
 Time complexity will be O(2^n * n)
 two to the power of n times n
because every element have two choices either pick or not pick.
 and n extra because we are using a while loop inside the recursive function which will add n time complexity.
 */