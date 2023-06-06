import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P0451SortCharsByFrequency {
    public String frequencySort(String s){
        HashMap<Character,Integer>map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char letters:s.toCharArray()){
            map.put(letters, map.getOrDefault(letters, 0)+1);
        } 
        PriorityQueue<Map.Entry<Character,Integer>>pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> pair=pq.poll();//pair 的类型是Map.Entry成对的
            for(int i=0;i<pair.getValue();i++){
                sb.append(pair.getKey());//getKey() getValue()都是来自poll出来都那对
            } 
        }
        return sb.toString();
    }
}
