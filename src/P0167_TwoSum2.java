import java.util.HashMap;
public class P0167_TwoSum2 {
    //two pointers
    public int[] twoSum2(int[]nums,int target){
        int[]res=new int[2];
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
               res[0]=left+1;
               res[1]=right+1;
               return res; //break;
            }
            if(nums[left]+nums[right]>target){
                right--;
            }
            else{
                left++;
            }
        }
        return null;
    }
    //hashmap
    public int[] twoSum2_1(int[]numbers,int target){
        int[] res=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey((target-numbers[i]))){
                res[0]=map.get(target-numbers[i])+1;
                res[1]=i+1;
                return res;
            }
            map.put(numbers[i],i);
        }
        return null;
    }
    //binary search
    public int[] twoSum_2(int[]numbers,int target){
        int[]res=new int[2];
        for(int i=0;i<numbers.length;i++){
            int pos=binarySearch(numbers,i+1,numbers.length-1,target-numbers[i]);
            if(pos!=-1){
                res[0]=i+1;
                res[1]=pos+1;
                return res;
            }
        }
        return null;
    }
    public int binarySearch(int[]numbers,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==numbers[mid]){
                return mid;
            }
            else if(numbers[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }
  
}
       //P0167_TwoSum2 p167=new P0167_TwoSum2();
        //System.out.println(p167.twoSum(new int[]{2,7,11,15},9));
