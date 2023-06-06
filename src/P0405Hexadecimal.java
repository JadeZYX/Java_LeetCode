public class P0405Hexadecimal {
    public String toHex(int num){
        char[]hex={'0','1','2','3','4','5','6','7','8','9',
                    'a','b','c','d','e','f'};//java里语法要求使用花括号
        StringBuilder sb=new StringBuilder();
        if(num==0){
            return "0";
        }
        int count=0;
        while(num!=0&&count++<8){
            char res=hex[num & 0xf];
            //res = hex[(num & 15)]; //也可这样写。因为16进制最大可以表示15
            sb.append(res);
            num>>>=4;
        }
        return sb.reverse().toString();
    } //stringbuilder传入的参数使用toString()功能转换成字符串；

    public String toHex1(int num) {
        int count=0;
        if(num==0)return "0";
        char[]chart={'0','1','2','3','4','5','6','7',
                   '8','9','a','b','c','d','e','f'};
        String res="";
        while(num!=0&&count<8){
            int last=num&15;
            res=chart[last]+res;
            count++;
            num>>=4;//>>>和>>区别
        }
        return res;
    }
}
    //   P0405Hexadecimal p405=new P0405Hexadecimal();
    //   System.out.println(p405.toHex(26));
    //   System.out.println(p405.toHex(-1));

//16进制的取值范围数0～15，也就是0～9+a~f，最大值f对应的二进制是1111，也就是说四位的二进制数可以用一位16进制的某个字符表示，
//所以是分成4组，求出末尾的4位对应的数后再右位移4位。
//题目限制条件是数字是32位整形，4个一组，所以有8组。因为如果是负数，随着不断右移，左边会一直补充1111，
//这样子数不会变成0.所以限制一共8次
////计算机内用二进制的表现形式与oxf16进制的表现形式进行位与，求出的数再按照上面的char表找出对应的16进制表达方式