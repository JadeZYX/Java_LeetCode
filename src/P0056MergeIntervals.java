import java.util.ArrayList;
import java.util.Arrays;

public class P0056MergeIntervals {
  public int[][]merge(int[][]intervals){//TO(nlogN)+SO(n)
    //corner case
    if(intervals==null || intervals.length<=1){
      return intervals;
    }
    ArrayList<int[]>list = new ArrayList<>();//因为要返回二维数组，无法确认空间，所以用list更灵活
    Arrays.sort(intervals,((int[]a,int[]b) ->(a[0]-b[0])));//注意括号Arrays.sort(arr,((a,b)->(a-b)))
    list.add(intervals[0]);//先把第一个加进去
    for(int i = 1;i<intervals.length;i++){
      int[]lastArr = list.get(list.size()-1);// 取出最后一个
      if(lastArr[1]>=intervals[i][0]){//[1,3],[2,6]二者有重合，可以合并成[1,6]所以取较大者
        lastArr[1] = Math.max(lastArr[1], intervals[i][1]);
      }
      else{
        list.add(intervals[i]);
      }
    }
    return list.toArray(new int[list.size()][2]);//把list转换成array
  }
}
