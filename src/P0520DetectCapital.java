
public class P0520DetectCapital {
    public boolean detectCapitalUse(String word){
        String sub= word.substring(1, word.length());
        if (word.toUpperCase().equals(word)){
            return true;
        }
        else if (word.toLowerCase().equals(word)){
            return true;
        }
        else if(sub.equals(sub.toLowerCase())){//首字母大小写都可以，但是后面的必须是小写 不能用== 因为==是引用地址
            return true;
        }
        else{
            return false;
        }
    }
    public boolean detectCapitalUse1(String word){//根据大小写字母的个数来解题
        int countCapital=0;
        int countLower=0;
        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)) countLower++;
            if(Character.isUpperCase(ch)) countCapital++;
        }
        if(countCapital==word.length()) return true;
        if(countLower==word.length()) return true;
        if(countLower==word.length()-1 && (Character.isUpperCase(word.charAt(0)))){
            return true;
        }
        return false;
    }
}
       //P0520DetectCapital p520=new P0520DetectCapital();
       //System.out.println(p520.detectCapitalUse("Google"));
