import java.util.ArrayList;

public class P1389CreateTargetArrayInGivenOrder {
    public int[] createTargetArray(int[]nums,int[]index){
        ArrayList<Integer> list=new ArrayList<>(nums.length);
        for(int i=0;i<index.length;++i){
            list.add(index[i], nums[i]);//list的添加法：在哪个位置插入进哪个元素，其他元素自动后移
        }
        // return target.stream().mapToInt(Integer::intValue).toArray();
        int[]res=new int[list.size()];
        int k=0;
        for(int num:list){
            res[k]=num;
            k++;
        }
        return res; 
    }
    //0 <= index[i] <= i 要有效利用这个限定条件 👇方法
    public int[]createTargetArray1(int[]nums,int[]index){
        int[]res=new int[index.length];
        for(int i=0;i<res.length;i++){
    //index[i]!=i说明要插入的位置在当前i的前面,因此要移动元素。需要移动的范围是index[i]~i，前一个位置的元素要移动到当前的i上
            if(index[i]!=i){
                int temp=i;//记录当前i的位置，下面i不断的要--，如果不用变量记录，则会影响下一轮进入loop i的值
                while(temp>index[i]){//空出要插入的位置，所以不能取等号
                    res[temp]=res[temp-1];
                    temp--;
                }
                res[index[i]]=nums[i];//当前是temp和index[i]位置相同，也就是要插入的位置
            }
            else{//当i==index[i]的时候，说明是按顺序插入的，可以直接插入
                res[i]=nums[i];
            }
        }
        return res;
    }
}
/*
       P1389CreateTargetArrayInGivenOrder p1389=new P1389CreateTargetArrayInGivenOrder();
       int[]res=p1389.createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1});
       for(int i:res){
           System.out.print(i);
       }
       System.out.println(" ");
*/
