import java.util.Arrays;

public class P0435NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][]intervals){
    //corner case
   if(intervals.length==0 || intervals[0].length == 0) return 0;
   Arrays.sort(intervals,(a,b)->a[0]-b[0]);//nlogn
   int counter = 0;
   int[]prevInterval = intervals[0];//中途会删除重叠区间，所以要记录前一个区间，以便和后面adjacent区间比较
   for(int i = 1;i<intervals.length;i++){
    if(prevInterval[1]>intervals[i][0]){//先判断是否存在overlapping
      counter++;
      //删除end值较大的区间并更改prevInterval
      if(prevInterval[1]>intervals[i][1]){//删除原来的前区间且更新区间
        prevInterval = intervals[i];
      }
    }
    else{//没有重叠部分之间更新前区间为当前遍历到的区间
      prevInterval = intervals[i];
    }
   }

   return counter;
  }
}
/*
 题目要求删除最少的区间使intervals里面没有重叠区间。
 例子1
 [[1,3],[2,4],[3,5]] 若使整个区间都没有重叠部分，第一种方案是删除[1,3]则还需要删除剩下两个区间的其中一个才能满足条件，总数是2.第二种方案是删除[2,4],剩下两个区间是不重叠的，属于最佳方案。第三种是删除[3,5]和[1,3]或者[2,4]
 例子2
 [[1,5],[2,3],[4,5]]这里删除[1,5]这一个区间是最佳答案
 所以先sort整个2d数组，然后找到重叠区域，删除end值较大的那个
  */