public class P0821ShortestDistancetoAChar {
    public int[]shortestToChar(String s,char c){
        int[]output=new int[s.length()];
        int charPos=-(s.length());
        //int charPos=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                charPos=i;
            }
            output[i]=i-charPos;
        }
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)==c){
                charPos=j;
            }
            output[j]=Math.min(output[j], Math.abs(j-charPos));
        }
        return output;
    }
}
//P0821ShortestDistancetoAChar p821=new P0821ShortestDistancetoAChar();
//System.out.println(p821.shortestToChar("loveleetcode", 'e'));
