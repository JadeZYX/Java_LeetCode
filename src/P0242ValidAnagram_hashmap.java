import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class P0242ValidAnagram_hashmap {
    public boolean isAnagram0(String s,String t){
        if(s.length()!=t.length()){ //若长度不等则返回错误
            return false;
        }
        HashMap<Character,Integer> smap=new HashMap<Character,Integer>();//创建声明
        for(int i=0;i<s.length();i++){ //统计第一个字符串里每个字母的个数 string类型不能用for(char c :s)这种写法是错误的，只能用于array里
            if(smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i), smap.get(s.charAt(i))+1);
                //smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            }
            else{
                smap.put(s.charAt(i), 1);
            }
        }
        for(int j=0;j<t.length();j++){//在第二个字符串将重复的字母减少其个数
            if(smap.containsKey(t.charAt(j))){
                smap.put(t.charAt(j), smap.get(t.charAt(j))-1);
            }
        }
        Collection<Integer> values=smap.values();//收集所有的值，查看是否是0
        for(int value:values){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram1(String s, String t){
        if(s.length()!=t.length()){//若两字符串长度不等则错误
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0 )+1);//统计第一个字符串里每个字母的个数
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)-1);//统计第二个字符串里字母和第一个字符串里字母的关系，若存在减1，若不存在则为默认值0
        }
        for(char letter:map.keySet()){//便利所有的Key
           if(map.get(letter)!=0){//找出Key对应的value，看是否是0
               return false;
           }
        }
        return true;
    }
    public boolean isAnagram(String s, String t){
        int[] alphabet=new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'a']++;
            alphabet[t.charAt(i)-'a']--;
        }
        for(int j:alphabet){
            if(j!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[] charS=s.toCharArray();////将字符串转换成char类型的数组
        Arrays.sort(charS);//按照字典字母顺序进行排序
        char[] charT=t.toCharArray();
        Arrays.sort(charT);
        for(int i=0;i<charS.length;i++){
            if(charS[i]!=charT[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        //check length 如果长度不一致，肯定是false
        if(s.length()!= t.length())return false;
        //确保长度一致，再统计出彼此每个单词的出现频率，再去查看频率是否一致
        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j = 0;j<t.length();j++){
            map2.put(t.charAt(j),map2.getOrDefault(t.charAt(j),0)+1);
        }
        for(Character c:map1.keySet()){
            if(!map2.containsKey(c) || map1.get(c)!= map2.get(c)){//注意条件语句用且
                return false;
            }
        }
        return true;
    }
}

/*
       P0242ValidAnagram_hashmap p242=new P0242ValidAnagram_hashmap();
       System.out.println(p242.isAnagram("cat", "rat"));
       System.out.println(p242.isAnagram("anagram", "nagaram"));
       System.out.println(p242.isAnagram("a", "ab"));


第一种方法hashmap
这道题目的trick在于求出第一个字符串每个字母的个数，并存入hashmap里，然后第二个字符串中存在的字母在hashmap里减去。
若hashmap里的value都为0，说明true，否则是false。
第二种方法开出能存储26个字母的数组且默认值都是0.第一个字符串里char类型的字母转换成对应的int类型，找到对应数组的位置并++。
第二个字符串里的字母转成int类型找到在数组里的对应位置并进行- -，这样一加一减的进行抵消。若表示26个字母的数组的元素全为0，则true。否则为false。
*/