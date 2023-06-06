import java.util.HashMap;

public class P0290hashmap_WordPattern {
    public boolean wordPattern(String pattern,String s){
        HashMap<Character,String> map=new HashMap<>();
        String[] wordString=s.split(" ");
        if(pattern.length()!=wordString.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char p=pattern.charAt(i);
            String w=wordString[i];
            if(map.containsKey(p)){
                if(!map.get(p).equals(w)){  //不能写成map.get(p)!=w 因为string是复杂类型这里用==不能满足引用地址也相同
                    return false;
                }
            }
            else{
                if(map.containsValue(w)){
                    return false;
                }
                else{
                    map.put(p, w);
                }
            }
        }
        return true;
    }
}     //bijection一一映射的关系，既要check map里的Key，也要check map里的Value
        //P0290hashmap_WordPattern p290=new P0290hashmap_WordPattern();
        //System.out.println(p290.wordPattern("abba", "dog cat cat dog"));
