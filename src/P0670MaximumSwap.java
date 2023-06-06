public class P0670MaximumSwap {
    public int maximumSwap0(int num) {
        char[]char_num=String.valueOf(num).toCharArray();
       for(int i=0;i<char_num.length;i++){
           int j=char_num.length-1;
           int max=i;//记录最大索引位置
           while(j>i){
               if(char_num[max]<char_num[j]){
                   max = j;
               }
               j--;
           }
           if(max!=i){
               char temp = char_num[max];
               char_num[max]=char_num[i];
               char_num[i]=temp;
               return Integer.valueOf(String.valueOf(char_num));
           }
       }
       return num;
   }
   public int maxmumSwap1(int num){
        char[]chars=String.valueOf(num).toCharArray();
        int len=chars.length;
        int maxpos=len-1;
        int swap0=-1;
        int swap1=-1;
        for(int i=len-2;i>=0;i--){
           if(chars[i]>chars[maxpos]){
                maxpos=i;
            }
            else if(chars[i]<chars[maxpos]){
                swap0=i; 
                swap1=maxpos;
            }
        }
        if(swap1==-1){
            return num;
        }
        char temp=chars[swap0];
        chars[swap0]=chars[swap1];
        chars[swap1]=temp;
        return Integer.valueOf(String.valueOf(chars));
    }
    //优先找到最大值，假设最大值开始在末尾的位置，然后往前面扫，一旦出现最大值就更改最大值的位置。
    //如果扫到的值比假设的最大值要小，则记录为需要交换位置的index，同时记录下出现的最大值的位置。
    //找到最大值的位置和找到最左面的比最大值小的那个位置，然后进行交换。
}
/*
       P0670MaximumSwap p670=new P0670MaximumSwap();
       System.out.println(p670.maxmumSwap1(2736));
       System.out.println(p670.maxmumSwap1(10));
*/