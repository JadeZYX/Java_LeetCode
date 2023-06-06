public class p0792numberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[]words){
        int count=0;
        for(String word:words){
            if(isSubsequence(word,s)){
                count++;
            }
        }
        return count;  
    }
    boolean isSubsequence(String word,String s){
        int point1=0;
        int point2=0;
       while(point1<word.length()&&point2<s.length()){
            if(word.charAt(point1)==s.charAt(point2)){
                point1++;
                point2++;
            }
            else{
                point2++; 
            }
       }
       return point1==word.length();
    }
}
// p0792numberOfMatchingSubsequences p792=new p0792numberOfMatchingSubsequences();
//System.out.println(p792.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));