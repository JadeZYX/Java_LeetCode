import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P0852PeakIndexInMoutain {
    public int peakIndexInMountainArray(int[] arr) {
       List<Integer>list=Arrays.stream(arr).boxed().collect(Collectors.toList());
     //int[] arrCopy = list.stream().mapToInt(Integer::intValue).toArray();
       list.add(0, 0);
       list.add(0);
       Integer[]newarr=new Integer[list.size()];
       newarr=list.toArray(newarr);
        // 防止mid-1 mid+1溢出，所以我们在头尾加了0.因为区间范围是1～len-2，所以不改变结果
       int left=1;
       int right=newarr.length-2;
       while(left<=right){
           int mid=left+(right-left)/2;
           if(newarr[mid]>newarr[mid+1]&&newarr[mid]>newarr[mid-1]){
               return mid-1;//因为开头结尾添加两个0，整体右移了一位，所以要mid-1才是原来的索引
           }
          if(newarr[mid]<newarr[mid+1]){
               left=mid+1;
           }
          if(newarr[mid]<newarr[mid-1]){
               right=mid-1;
           }
       }
       return -1;
    }
    public int peakIndexInMountainArray0(int[] arr) {//最优optimal solution//有题解
        int left=0;
         int right=arr.length-1;
         while(left<right){//左闭右开防止mid+1溢出，所以下面的right是mid
             int mid=left+(right-left)/2;
             if(arr[mid]>arr[mid+1]){//下坡，继续左查找
                 right=mid;
             }
             if(arr[mid]<arr[mid+1]){//上坡 继续右查找
                 left=mid+1;
             }
         }
         return left;//return right也可以
     }
    public int peakIndexInMountainArray1(int[] arr) {//BF做法
        int max=Integer.MIN_VALUE;
         int index=-1;
         for(int i=0;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
                 index=i;
             }
         }
        return index;
     }
}
