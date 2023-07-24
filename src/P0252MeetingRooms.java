import java.util.Arrays;

public class P0252MeetingRooms {
  /*  description
  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
  Input: [[0,30],[5,10],[15,20]]
  Output: false
  Input: [[7,10],[2,4]]
  Output: true
  可以参加所有会议的前提是没有重叠区间
   */
  public boolean canAttendMeetings(int[][]intervals){
    //corner case
    if(intervals.length == 0) return true;
    Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    for(int i = 0;i<intervals.length-1;i++){//避免溢出
      if(intervals[i][1]>intervals[i+1][0]){//overlapping so return false
        return false;
      }
    }
    return true;
  }
}
