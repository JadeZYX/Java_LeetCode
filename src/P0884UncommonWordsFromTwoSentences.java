import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

public class P0884UncommonWordsFromTwoSentences {
    public String[]uncommonFromSentences(String s1, String s2){
       HashMap<String,Integer>map=new HashMap<>();
       ArrayList<String>list=new ArrayList<>();
        for(String wordS1:s1.split(" ")){//string字符串转变成string类型的array，以空格作为切分
            map.put(wordS1, map.getOrDefault(wordS1, 0)+1);
        }
        for(String wordS2:s2.split(" ")){
            map.put(wordS2, map.getOrDefault(wordS2, 0)+1);
        }
        for(String word:map.keySet()){//方法1，用keySet将所有的字符串取出，效率上比Map.Entry快
            if(map.get(word)==1){//逐一去get对应字符串的value
                list.add(word);
            }
        }
        /*
        for(Map.Entry<String,Integer>entry:map.entrySet()){
              if(entry.getValue()==1){
                 list.add(entry.getKey());
              }
        }
        */
        return list.toArray(new String[list.size()]);//arraylist->array
    }
}
