import java.util.HashMap;
public class P1512NumberOfGoodPairs {
    public int numIdenticalpairs(int[]nums){//BF解法，两重for循环，内层循环从i+1开始，防止重复
        int pairs=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;++j){
                if(nums[i]==nums[j]){
                    pairs++;
                }
            }
        }
        return pairs;
    }
    //用新创建的array统计出原数组里每个数出现的次数，然后利用n*(n-1)/2=可配成的对数来求结果
    public int numIdenticalpairs1(int[]nums){//S:O(1)+T:O(n)
        int pairsNumbers=0;
        int[]frequencies=new int[101];//题目里的限制条件 有个0，所以是101
        for(int i=0;i<nums.length;i++){
            frequencies[nums[i]]++;
        }
        for(int j=0;j<101;j++){
            if(frequencies[j]!=0){
                pairsNumbers=pairsNumbers+frequencies[j]*(frequencies[j]-1)/2;
            }
        }
        return pairsNumbers;
    }
    public int numIdenticalpairs2(int[]nums){//T:O(n)+S:O(n)
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();//统计每个元素出现的次数
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        for(int currentcount:map.values()){//取出map里所有的value值
            count+=currentcount*(currentcount-1)/2;//求每个value可配成的对数并累计相加
        }
        return count;
    }
}
      // P1512NumberOfGoodPairs p1512=new P1512NumberOfGoodPairs();
      // System.out.println(p1512.numIdenticalpairs2(new int[]{1,2,3,1,1,3})); 