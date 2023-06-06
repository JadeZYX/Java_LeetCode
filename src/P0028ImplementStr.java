public class P0028ImplementStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        int len=needle.length();
        int Lpoint=0;
        int Rpoint=len;
        while(Lpoint<haystack.length()&&Rpoint<=haystack.length()){//substring里右开，所以如果要取到最后一位，要等于
            if(haystack.substring(Lpoint,Rpoint).equals(needle)){//java里string不能用==进行比较
                return Lpoint;
            }
            else{
                Lpoint++;
                Rpoint=Lpoint+len;
                
            }
        }
        return -1;
    }
}
//corner case：只要needle是空字符串，则返回0.若两个都为空，则返回0.若第一个为空，needle不为空，则-1.
// P0028ImplementStr p28=new P0028ImplementStr();
// System.out.println(p28.strStr("a", "a"));