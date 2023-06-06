import java.util.HashMap;

public class P771JewelsAndStones {
    public int numJewelsInStones(String jewels,String stones){//BF T:o(n*n)  S:O(n)
        int sum=0;
        for(int i=0;i<jewels.length();++i){
            for(int j=0;j<stones.length();++j){
                if(stones.charAt(j)==jewels.charAt(i)){
                    sum++;
                }
            }
        }
        return sum;
    }
    public int numJewelsInStones1(String jewels, String stones){//最优解
        int sum=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char letter:jewels.toCharArray()){//将所有的类型添加到map里的Key，而Value为0
            map.put(letter, 0);
        }
        for(int i=0;i<stones.length();++i){//统计每种type有多少个
            if(map.containsKey(stones.charAt(i))){
                map.put(stones.charAt(i), map.get(stones.charAt(i))+1);
            }
        }
        for(int val:map.values()){//将map里的value提取出来并加一起得到总数
            sum+=val;
        }
        return sum;
    }
    public int numJewelsInStones2(String jewels,String stones){
        int sum=0;
        for(int i=0;i<stones.length();i++){
            if(jewels.indexOf(stones.charAt(i))!= -1){
                sum++;
            }
        }
        return sum;
    }
}
