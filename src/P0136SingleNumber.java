import java.util.Arrays;
import java.util.HashSet;

public class P0136SingleNumber {
    public int singgleNumber0(int[]nums){
        Arrays.sort(nums);//排序
        int i=0;
        while(i<nums.length-1){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            else{
                i=i+2;
            }
        }
        return nums[i];
    }
    public int singgleNumber(int[]nums){
        int ans=0;
        for(int n:nums){
            ans^=n;
        }
        return ans;
    }
    public int singleNumber(int[] nums) {//用set做
        HashSet<Integer>set=new HashSet<>();
        /*
         for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }
            else{
                set.add(i);
            }
        }
        */
          for(int i=0;i<nums.length;i++){
              if(set.contains(nums[i])){
                  set.remove(nums[i]);
              }
              else{
                  set.add(nums[i]);
              }
          }
          /*
            Iterator<Integer>ite=set.iterator();
        while(ite.hasNext()){
            return ite.next();
        }
          */
          for(int n:set){
              return n;
          }
          return -1;
      }
    //XOR的意思是位异或运算。相同为0，不同为1，所以数组里的数不断的进行位异或，相同的抵消，最后结果就是唯一出现的无法抵消的数。
}
/*
      P0136SingleNumber p136=new P0136SingleNumber();
       System.out.println(p136.singgleNumber(new int[]{2,2,1}));
       System.out.println(p136.singgleNumber(new int[]{4,1,2,1,2}));
       System.out.println(p136.singgleNumber(new int[]{1}));
*/