public class P0014LongestCommonPrefix {
    public String longestCommonPrefix(String[]strs){//复杂度O(N)
        if(strs.length==0)return "";
        String prefix=strs[0];//假设第一个单词是前缀，不断缩小
        for(int i=1;i<strs.length;i++){
            while(prefix.length() > 0 && strs[i].indexOf(prefix)!=0){//O(1)string的最大长度是200
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
    public String longestCommonPrefix1(String[]strs){
        if(strs.length==0||strs==null) return "";
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=ch){
                 //长度要小于index在0位置上的单词长度   
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];//若只有一个单词的情况下无法进入第二个循环
    }
    public String longestCommonPrefix2(String[] strs) {//O(m*n) m代表单词长度，n代表数组长度
        if(strs.length==0)return "";
        String shortest=shortestWord(strs);
        for(int i=0;i<shortest.length();i++){
            char ch=shortest.charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=ch){
                    return shortest.substring(0,i);
                }
            }
        }
        return shortest;
    }
    String shortestWord(String[]strs){//O(N)
        String res="";
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
                res=strs[i];
            }
        }
         return res;
    }
}
//P0014LongestCommonPrefix p14=new P0014LongestCommonPrefix();
//System.out.println(p14.longestCommonPrefix(new String[]{"dog","racecar","car"}));