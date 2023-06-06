
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[]strs){
       if (strs == null || strs.length == 0) {
           return new ArrayList<>();
       }
        Map<String, List<String>> map = new HashMap<>(); // O(N)
        for (String s : strs) { // n * logn
            char[] ca = new char[26];//元素是以‘1’这种
            for (char c : s.toCharArray()) {//字符串转成数组  // 100
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);//呈现出来都是“” asc2值
            if (!map.containsKey(keyStr)) {  // logn
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new LinkedList<>(map.values());
    }
    public List<List<String>> groupAnagrams0(String[]strs){
        List<List<String>> array=new ArrayList<>();
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        if(strs==null||strs.length==0){
            return array;
        }
        for(String s:strs){ //提取数组里的每一个字符串元素
            char[] charS=s.toCharArray();//将元素转成char类型的数组
            Arrays.sort(charS);//对char类型对数组按照字母顺序进行排序
            String keyString=String.valueOf(charS);//排序后转成关键词
            if(!map.containsKey(keyString)){
                map.put(keyString, new ArrayList<>());
            }
            map.get(keyString).add(s);//get针对map取value值，而add针对arraylist进行添加元素
        }
        return new ArrayList<>(map.values());//map.values作为参数
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>>res = new ArrayList<>();
        if(strs.length <=0){
            return res;
        }
        HashMap<String,List<String>>map = new HashMap<>();
        for(String s:strs){
            char[]chars = s.toCharArray();
            Arrays.sort(chars);
            String standardWord = Arrays.toString(chars);
            if(!map.containsKey(standardWord)){
                map.put(standardWord,new ArrayList<String>());
            }
            map.get(standardWord).add(s);
        }
        //retrive all the values of the standard word, and add them to the result list
        for(List<String>list:map.values()){
            res.add(list);
        }
        return res;
    }
}
/*
        P0049GroupAnagrams p49=new P0049GroupAnagrams();
        System.out.println(p49.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(p49.groupAnagrams(new String[]{""}));
        System.out.println(p49.groupAnagrams(new String[]{"a"})); */
