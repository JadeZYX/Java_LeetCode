import java.util.HashSet;

public class P1684hashmapString {
    public int countConststentString(String allowed,String[]words){
        int count=0;
        int[]arr=new int [26];
        for(int i=0;i<allowed.length();i++){//将allow里面的char添加到arr里，使其字母对应位置的元素为1
            arr[allowed.charAt(i)-'a']++;
        }
        for(int i=0;i<words.length;i++){
            boolean isValid=true;
            for(int j=0;j<words[i].length();j++){
                if(arr[words[i].charAt(j)-'a']==0){
//查找words数组里的每个元素是否符合要求，也就是char对应数组里的元素是不是1，如果是，符合要求，否则为false
                    isValid=false;
                    break;
                }
            }
            if(isValid) count++;
        }
        return count;
    }
    public int countConststentString1(String allowed,String[]words){
        int count=0;
        HashSet<Character>set=new HashSet<>();//符合字母要求的set集合
        for(char letters:allowed.toCharArray()){
            set.add(letters);
        }
        for(String word:words){
            boolean isValid=true;//记录结果
            for(int i=0;i<word.length();i++){
                if(!set.contains(word.charAt(i))){
                    isValid=false;
                    break;
                }
            }
            if(isValid) count++;
        }
        return count;
    }
}
/*
P1684hashmapString p1684=new P1684hashmapString();
System.out.println(p1684.countConststentString("ab", new String[]{"ad","bd","aaab","baa","badab"}));
*/
