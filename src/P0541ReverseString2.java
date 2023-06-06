public class P0541ReverseString2 {
    public String reverseStr(String s, int k){
        char[] schars=s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            reverse(schars, i, Math.min(i+k-1, s.length()-1));
        }
        return new String(schars);
        //return String.valueOf(char[]schars);

        // Object
        // toString() -> address + type
        // ClassA extends Object
        // ClassA a = new ClassA()
        // a.toString() --> Object.toString()
        // StringBuilder, override toString()
    }
    /*
这道题是整体操作的，所以如果要处理的位置，也就是i+k-1>s.length()-1,则会溢出，我们取到s.length()-1即可，否则就是i+k-1;
可以先把string类型转成char类型的数组，然后用双向指针进行交换

    */
    public void reverse(char[]chars,int from,int to){
        while(from<to){
           char temp=chars[from];
           chars[from]=chars[to];
           chars[to]=temp;
           from++;
           to--;
        }
    }
}
        //P0541ReverseString2 p541=new P0541ReverseString2();
        //System.out.println(p541.reverseStr("abcdefg", 2));
