import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;

public class P0692TopKFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {//T:O(nlogn) + S:O(n)
    List<String>res = new ArrayList<>();
    //map least->most
    HashMap<String, Integer> map = new HashMap<>();
    for(String s: words){
        map.put(s,map.getOrDefault(s,0)+1);
    }
    //create minheap to store strings, size should be = k
    PriorityQueue<String>queue = new PriorityQueue<>((a,b)->{
        if(map.get(a)!=map.get(b)){
            return map.get(a)-map.get(b);//从小到大的顺序
        }
        else{
            return b.compareTo(a);//从大到小的顺序
        }
    });
    for(String s:map.keySet()){//map里取values用map.values()
        queue.offer(s);
        if(queue.size()>k){
            queue.poll();//把频率最小的给去除，使minheap里始终是K的size
        }
    }
    //get all strings from queue and reverse them
    while(!queue.isEmpty()){
        res.add(queue.poll());
    }
    Collections.reverse(res);
    return res;
}


  public List<String> topKFrequent1(String[] words, int k) {
    List<String> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();// 单词和出现的频率
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);// 注意写法getOrDefault(key,value)
    }
    PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {// 因为有if else所以要有花括号
      if (map.get(a) != map.get(b)) {// 若频率不等则按照频率大->小来排序
        return map.get(b) - map.get(a);
      } else {// 若频率一致则按照字母顺序来 小->大
        return a.compareTo(b);
      }
    });
    // add word to queue
    for (String word : map.keySet()) {// 把map里面的key入队
      queue.offer(word);
    }
    int count = 0;
    while (!queue.isEmpty() && count < k) {
      String popE = queue.poll();
      res.add(popE);
      count++;
    }
    return res;
  }
}
