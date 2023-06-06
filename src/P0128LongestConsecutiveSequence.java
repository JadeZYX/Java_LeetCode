import java.util.HashMap;

public class P0128LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    if(nums.length ==0 || nums ==null) return 0;
       int maxLen = Integer.MIN_VALUE;
       //in map key is the element, value is as a mark, and set all as 1
       HashMap<Integer,Integer>map = new HashMap<>();
       for(int n: nums){
           if(map.containsKey(n)){
               continue;
           }
           map.put(n,1);
       }
       for(int i = 0;i<nums.length;i++){
           if(map.get(nums[i])!= 0){
               int len = 1;
               map.put(nums[i],0);
               int upperNumber = nums[i]+1;
               int lowerNumber = nums[i]-1;
               while(map.containsKey(upperNumber)){
                   len++;
                   map.put(upperNumber,0);
                   upperNumber++;
               }
               while(map.containsKey(lowerNumber)){
                   len++;
                   map.put(lowerNumber,0);
                   lowerNumber--;
               }
           maxLen = Math.max(maxLen,len);
           }
       }
       return maxLen;
    }
}
/*
 * P0128LongestConsecutiveSequence p128 = new P0128LongestConsecutiveSequence();
  System.out.println(p128.longestConsecutive(new int[]{100,4,200,1,3,2}));

 */