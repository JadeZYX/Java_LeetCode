public class P0744_char {
    public char nextGreatestLetter1(char[]letters,char target){  
         for(char chars: letters){
             if (chars>target){ //根据电脑内部设置排序自动识别char类型的字母大小
                 return chars;
             }
         }
         return letters[0];
    }
    //上面是bf解法，注意题目说整个字母是wrap around，所以循环结束还没有比目标值大的，则返回数组的第一个元素，这样始26个字母连串起来。
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length-1;
       char res=letters[0];
        while(left<=right){
            int mid=left+(right-left)/2;
            if(letters[mid]<=target){
                left=mid+1;
            }
            else{
                res=letters[mid];
                right=mid-1;
            }
        }
        return res;
    }
    
    public char nextGreatestLetter2(char[]letters,char target){
        boolean[] exist=new boolean[26];
        for(char c:letters){
            exist[c-'a']=true;
        }
        while(true){
            target++;
            if(target>'z'){
                target='a'; //这样使a-z再到a成为一个round
            }
            if(exist[target-'a']){
                return target;
            }
        }
    }
    //将数组里出现的字母以布尔值的形式出现在新的数组里，新的数组初始值是false。然后查看目标值++后是否在新的数组里。
    
    public char nextGreatestLetter3(char[]letters,char target){
        int left=0; 
        int right=letters.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(letters[mid]>target){
                right=mid-1;
            }
            else{ //letters[mid]<=target因为是有序数组且要找大于目标值的第一个
                left=mid+1;  //所以若letters[mid]和目标值相等的时候应该left右移动
            }
        }
        return letters[left%(letters.length)];
    }  //若目标值小从而不断左移查找，其实就是当left大于right时返回left。但是若目标值是z，此时left要不断的右移，若left大到超出right也就是length，则要通过取模来取到数组第一个值
    
    //binary search方法，因为字母a-z再到a-z是连接起来的，所以如果目标值是最后的字母z，则应返回再次从a开始的某个char，这就需要用modulo模数使之round起来
}  //若a<b,则a%b=a,a/b=0;  a%b=a-(a/b)*b 正负取绝于第一个数

/*
        P0744_char p744=new P0744_char();
        System.out.println(p744.nextGreatestLetter3(new char[]{'c','f','j'}, 'a'));
        System.out.println(p744.nextGreatestLetter3(new char[]{'c','f','j'}, 'c'));
        System.out.println(p744.nextGreatestLetter3(new char[]{'c','f','j'}, 'z'));
*/