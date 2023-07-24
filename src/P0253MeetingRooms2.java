import java.util.Arrays;
import java.util.PriorityQueue;

public class P0253MeetingRooms2 {
  /* 题目描述
  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
  Input: [[0, 30],[5, 10],[15, 20]]        Output: 2
  Input: [[7,10],[2,4]]                    Output: 1
  使用最少的room数量举行所有的会议
   */
  public int minMeetingRooms(int[][]intervals){//O(nlogn)时间 + O(n)空间
    Arrays.sort(intervals,(int[]a,int[]b)->a[0]-b[0]);//按照会议的开始时间排序
    PriorityQueue<Integer>minHeap = new PriorityQueue<>((a,b)->a-b);//按照ascend顺序
    minHeap.offer(intervals[0][1]);// 排序好的第一个会议的结束时间加入优先队列
    for(int i = 1;i<intervals.length;i++){
      //比较当前会议的开始时间和最小堆的第一个元素结束时间
      //1)如果当前遍历的会议开始时间晚于最小堆里第一个元素的结束时间，则说明不需要增加房间，但要把原存在堆里的结束时间删除并更新成当前会议的结束时间
      if(intervals[i][0]>=minHeap.peek()){
        minHeap.poll();
        minHeap.offer(intervals[i][1]);
      }
      //2)堆里最早的结束时间大于当前会议的开始时间，就是需要开出新房间,所以把当前会议的结束时间添加入堆
      else{
        minHeap.offer(intervals[i][1]);
      }
    }
    return minHeap.size();//每开新的房间就会把结束时间添加到堆，即使不需要开出新房间也是把原来的结束时间抹掉并更新，所以堆的大小就是房间的数量
  }
}
/*
 Java中的PriorityQueue类实际上是在堆上实现的。它使用堆来维护队列中元素的顺序，以便在插入和删除元素时能够高效地找到具有最高优先级的元素。优先队列使用堆数据结构来实现其优先级队列的特性，因为堆可以保证在O(log n)时间复杂度内找到最大或最小元素，这样就能够高效地处理优先级。
 例子
 [[1,4],[5,9],[3,4],[2,8],[5,7]]
 首先sort成[[1,4],[2,8],[3,4],[5,9],[5,7]], 优先队列里先添加第一场会议的结束时间4.
 第二场会议开始时间是2点，早于4点，所以需要开出新房间，优先队列里是(4,8)
 第三场会议开始时间是3点，早于优先队列里第一个最早结束时间4点，所以开出新房间，优先队列里是(4,4,8)
 第四场会议开始时间是5点，可以使用4点结束的房间，所以删除优先队列的那个四点，添加会议结束时间9点，优先队列(4,8,9)
 第五场会议开始时间是5点，结束7点，可以使用优先对首四点结束的会议室，删除4，添加7，优先队列变成(7,8,9)
遍历结束，所以最后只需要开出三个房间即可
 */