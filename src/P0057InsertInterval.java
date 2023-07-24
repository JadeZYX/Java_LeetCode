
import java.util.ArrayList;
import java.util.Arrays;

public class P0057InsertInterval {
  public int[][]insert(int[][]intervals,int[]newInterval){//O(n)
    ArrayList<int[]>list = new ArrayList<>();
    int i = 0;
    //不存在重叠部分
    while(i<intervals.length){
      if(intervals[i][1]<newInterval[0]){//[1,2]和[4,8]这种，4>2不会存在overlap,可直接加到结果集合
        list.addAll(Arrays.asList(intervals[i]));
        i++;
      }
      //因为需要merge重叠部分得到一个集合，所以不能用if，else语句全写在一起
    }
    //现在看重叠部分，如果没重叠，不断overlap之后则intervals[i][0]<newInterval[1],所以反向考虑就是当intervals[i][0]>=newIntervals[1]的时候就会重叠
    while(i<intervals.length){
      if(intervals[i][0]<=newInterval[1]){
        newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
        newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
        i++;
      }
    }
    list.addAll(Arrays.asList(newInterval));
    //把剩下的没有overlap部分添加进结果集
    while(i<intervals.length){
      list.addAll(Arrays.asList(intervals[i]));
      i++;
    }
    //题目要求返回二维数组，所以转换
    int[][]res = new int[list.size()][2];
    for(int j = 0;j<list.size();j++){
      res[j][0] = list.get(j)[0];
      res[j][1] = list.get(j)[1];
    }
    return res;
  }
}
/*
        P0057InsertInterval p57 = new P0057InsertInterval();
        System.out.println(p57.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5}));
不能写成这种，会进入死循环，因为虽然不满足if语句，但i始终没有改变，所以死循环
   while(i<intervals.length){
      if(intervals[i][1]<newInterval[0]){
        list.addAll(Arrays.asList(intervals[i]));
        i++;
      }
    }
|  ?  !  ?|    !  #        #
---------------------------------
0  1  2  3  4  5  6  7  8  9  10
上面的区间有[0,3],[1,3],[2,5],[6,9]
overlap的区间[0,3]和[1,3][2,5]合并成[0,5]所以overlap的部分要逆向思维，因为start和end有多种可能性
*/