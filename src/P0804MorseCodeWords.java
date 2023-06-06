import java.util.HashMap;
import java.util.HashSet;

public class P0804MorseCodeWords {
    public int uniqueMorseRepresentations(String[]words){
        String[] code=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....",
                       "..",".---","-.-",".-..","--","-.","---",".--.",
                       "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character,String>map=new HashMap<>();
        HashSet<String> set =new HashSet<>();
        int i=0;
        for(String s:code){
            map.put((char)(97+i), s);
            i++;
        }
        for(String word:words){
            StringBuilder sb=new StringBuilder();
            for(char letter:word.toCharArray()){
                sb.append(map.get(letter));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    //将从a-z对应的摩斯码添加到hashmap中，然后遍历数组里的元素，将每个单词转成对应的摩斯码并添加到hashset里
    //因为hashset里不储存重复元素，所以返回hashset的size即可
    public int uniqueMorseRepresentations1(String[]words){//T:O(m*n) S:O(N)
        String[] code=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....",
                       "..",".---","-.-",".-..","--","-.","---",".--.",
                       "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String>set=new HashSet<>();
        for(String word:words){
            StringBuilder sb=new StringBuilder();
            for(char letter:word.toCharArray()){
                sb.append(code[letter-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}//遍历array里的元素，利用String code 根据字母的位置,将每个单词转成对应的摩斯码并添加到hashset里 
