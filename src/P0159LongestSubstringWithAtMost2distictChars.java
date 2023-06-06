import java.util.HashMap;

public class P0159LongestSubstringWithAtMost2distictChars {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        HashMap<Character,Integer>map=new HashMap<>();
        int fast=0,slow=0;
        int maxlen=0;
        while(fast<s.length()){
            char ch=s.charAt(fast);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size()<=2){
              maxlen=Math.max(maxlen, fast-slow+1);
            }
            else{//map.size>2
               while(slow<=fast&&map.size()>2){
                   char c=s.charAt(slow);
                   map.put(c, map.get(c)-1);
                   if(map.get(c)==0){
                       map.remove(c);
                   }
                   slow++;
               }
            }
            fast++;
        }
        return maxlen;
    }
}
