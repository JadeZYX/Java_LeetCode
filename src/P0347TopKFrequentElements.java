import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class P0347TopKFrequentElements {
    public int[]topKFrequent(int[]nums,int k){
        HashMap<Integer,Integer>frequence=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            frequence.put(num, frequence.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Entry<Integer, Integer>>qp=new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
        for(Entry<Integer, Integer> value:frequence.entrySet()){
            qp.offer(value);
        }
        int[] res=new int[k];
        int j=0;
        for(int i=0;i<k;i++){
            Entry<Integer,Integer> popE=qp.poll();
            res[j]=popE.getKey();
            j++;
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {//naive solution
        //k是几，array的长度就是多少
        int[]res = new int[k];
        //count the frequency of each word using a hash map.
        //flatten the hash map to an array of word conuts.
        //Sort the word counts by descending frequency.
        //output the first K words
        HashMap<Integer,Integer>map = new HashMap<>();
       for(int n:nums){
           map.put(n,map.getOrDefault(n,0)+1);
       }
       List<Integer>list = new ArrayList<>(map.keySet());//添加key且从大到小排序b-a
       Collections.sort(list,(a,b)->map.get(b)-map.get(a));
      int index = 0;
      for(Integer m:list){
        if(index<k){
            res[index]=m;
            index++;
        }else{//可提前结束
            break;
        }
      }
      return res;
    }
}
/*
P0347TopKFrequentElements p347 = new P0347TopKFrequentElements();
        System.out.println(p347.topKFrequent1(new int[]{1,1,1,2,2,3},2));
 *
 */