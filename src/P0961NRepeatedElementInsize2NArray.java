import java.util.HashMap;

public class P0961NRepeatedElementInsize2NArray {//效率太低
    public int repeatedNTimes(int[]nums){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) == 2) {
                //因为长度是2*N，有N+1个不同的数，其中有N个重复的数。
                //所以这2N里，去掉N个重复的，也就是1个数，剩下N个是不重复的
                //所以只要保证同一个数出现2次即可
                return num;
            }
        }
        return -1;
    }

}
