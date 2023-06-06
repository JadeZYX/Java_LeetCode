import java.util.HashMap;

public class P0383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine){
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }
        for(char letter:ransomNote.toCharArray()){
            if(!map.containsKey(letter)){
                return false;
            }
            else{
                if(map.get(letter)!=0){
                    map.put(letter, map.get(letter)-1);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean canConstruct1(String ransomNote, String magazine){//更优解法
        int[]char_mag=new int[26];
        for(char c:magazine.toCharArray()){
            char_mag[c-'a']++;
        }
        for(char note:ransomNote.toCharArray()){
            if(char_mag[note-'a']!=0){
                char_mag[note-'a']--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
       //P0383RansomNote p383=new P0383RansomNote();
       //System.out.println(p383.canConstruct("aa", "ab"));
