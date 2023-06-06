import java.util.HashMap;

public class P1814CountnicePairs3 {
    public int countNicePairs(int[]nums){
        long pairs=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            int rev=reverse(nums[i]);
            int subtraction=nums[i]-rev;
            map.put(subtraction, map.getOrDefault(subtraction,0)+1); 
        }
        for(long value:map.values()){
            pairs=(pairs + value*(value-1)/2) % 1000000007;//题目中Since that number can be too large, return it modulo 109 + 7.
        }
        return (int)pairs;//long变成int
    }
    private int reverse(int num){//求一个数的reverse
        int rev=0;
        while(num!=0){
            int remain=num%10;
            rev=rev*10+remain;
            num/=10;
        }
        return rev;
    }
    //根据nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])->nums[i]-rev(nums[i])==nums[j]-rev(nums[j])
    //所以求出一共出现来多少次nums[i]-rev(nums[i])这个结果，然后利用N*(N-1)/2就可以求出对数
}
