public class P0392IsSubsequence {
    public boolean isSubsequence(String s, String t){//O（m+n)m是S的长度，n是t的长度
        int sPoint=0;
        int tPoint=0;
        while(sPoint<s.length()&&tPoint<t.length()){
            if(s.charAt(sPoint)==t.charAt(tPoint)){
                sPoint++;
            }  
            tPoint++;
        }
        if(sPoint==s.length()){//只有需要检查的string全部检查完毕时，它的值会等于长度
            return true;
        }
        return false;
    }
    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
        //P0392IsSubsequence p392=new P0392IsSubsequence();
       //System.out.println(p392.isSubsequence("axc", "ahbgdc"));
       //System.out.println(p392.isSubsequence("abc", "ahbgdc"));
       //System.out.println(p392.isSubsequence("a", ""));