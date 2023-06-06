public class P0557ReverseWordsInString3 {
    public String reverseWords(String s){
        int len=s.length();
        if(len==1)return s;
        char[]letters=s.toCharArray();
        for(int i=0;i<len;i++){
            int firstindex=i;
            while(i<len && letters[i]!=' ') {
                i++;
            }
            int lastindex=i-1;//也就是空格的位置,
//当为原string结尾的时候，虽然没有空格，但是这时候i的值超出了长度而结束循环，所以结尾索引还是可以用i-1；
            while(firstindex<lastindex){//这里不能用！= 因为如果是偶数，则很可能随着first++,last--,两个值没有交集且first>last
                char temp= letters[firstindex];
                letters[firstindex]=letters[lastindex];
                letters[lastindex]=temp;
                firstindex++;
                lastindex--;
            }
        }
        return String.valueOf(letters);
    }
    public String reverseWords1(String s){
        String[]arr=s.split(" ");//使用空格符将原字符串转成string类型的array
        StringBuilder sb=new StringBuilder();
        for(String word:arr){//遍历数组里的每个单词
            for(int i=word.length()-1;i>=0;i--){
                sb.append(word.charAt(i));//将字母从后往前的加入到sb里
            }
            sb.append(" ");//每处理完一个单词记得添加空格符合
        }
        sb.deleteCharAt(sb.length()-1);//将最后一次添加在末尾的空格符合删除
        return sb.toString();
    }
}
/*
       P0557ReverseWordsInString3 p577=new P0557ReverseWordsInString3();
       System.out.println(p577.reverseWords("God Ding"));
*/
