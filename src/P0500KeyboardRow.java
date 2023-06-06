import java.util.ArrayList;
import java.util.HashMap;
public class P0500KeyboardRow {
    //用hashmap
    public String[] findWords0(String[]words){
        ArrayList<String> res=new ArrayList<>();
        String[] s = new String[] {"qwertyuiop","asdfghjkl", "zxcvbnm"};
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            for (char c : s[i].toCharArray()) {//string.toCharArray()
                map.put(c, i);
            }
        }
        for(int i=0;i<words.length;i++){
            boolean isValid=true;//判定是否存在可以借助于布尔类型的变量
            int pos=map.get(Character.toLowerCase(words[i].charAt(0)));
            for(int j=1;j<words[i].length();j++){
                char ch=Character.toLowerCase(words[i].charAt(j));//将char类型的大写转成小写
                if(map.get(ch)!=pos){
                    isValid=false;
                    break;
                }
            }
            if(isValid){
                res.add(words[i]);
            }
        }
        String[] str=new String[res.size()];
        int k=0;
        for(String word:res){//将array list转成array
            str[k]=word;
            k++;
        }
        return str;
    }
    //使用array的做法，创建一个代表26个字母的array，里面存储每个字母对应的行数
    public String[]findWords(String[]words){
        String[]letters=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        int[]rows=new int[26];
        ArrayList<String> res=new ArrayList<>(words.length);
        for(int i=0;i<letters.length;++i){
            for(char ch:letters[i].toCharArray()){
                rows[ch-'a']=i+1;
            }
        }
        for(int j=0;j<words.length;++j){
            int firstLetterRow=rows[Character.toLowerCase(words[j].charAt(0))-'a'];//记得把必要的大写字母先变成小写，然后找到其对应的row
            boolean isValid=true;
            for(int k=1;k<words[j].length();++k){
                if(rows[Character.toLowerCase(words[j].charAt(k))-'a']!=firstLetterRow){
                    isValid=false;
                    break;
                }
            }
            if(isValid) res.add(words[j]);
        }
        String[]arr=new String[res.size()];
        int count=0;
        for(String word:res){
            arr[count]=word;
            ++count;
        }
        return arr;
    }
}
/*
        P0500KeyboardRow p500=new P0500KeyboardRow();
        String[]res=p500.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        for(String s:res){
            System.out.print(s+" ");
        }
*/
