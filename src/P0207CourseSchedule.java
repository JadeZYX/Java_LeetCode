import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P0207CourseSchedule {
  public boolean canFinish(int numCourse, int[][]prerequisites){
    int[]indegree = new int[numCourse];//记录每节课的入度
    //key: course课程名称，再给出的prerequisite里就是先修的课程，index是1
    //value: list：出度，修完KEY可以修的课程， index是0
    //因为map里是构建有方向的图
    HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();
    /*
     for(int i=0;i<prerequisites.length;i++){
          int[] curarr = prerequisites[i];
          indegree[curarr[0]]++;
          if(!graph.containsKey(curarr[1])){
            graph.put(curarr[1],new ArrayList<Integer>());
          }
          graph.get(curarr[1]).add(curarr[0]);
        }
     */
    for(int i = 0;i<prerequisites.length;i++){
      int[]innerList = prerequisites[i];
      indegree[innerList[0]]++;//[4,1]先修1再修4，所以给课程4的入度+1，表示想要take4的limit
      //[4,1]修完第0门课才能修第4门课，所以有向图应该是从1指向4，key是1，value的list里添加4
      if(graph.containsKey(innerList[1])){
        graph.get(innerList[1]).add(innerList[0]);
      }
      else{
        graph.put(innerList[1],new ArrayList<>(Arrays.asList(innerList[0])));
      }
    }
    Queue<Integer>queue = new LinkedList<>();
    for(int i = 0;i<numCourse;i++){
      if(indegree[i]==0){
        queue.offer(i);//把入度是0的课程编号入对
      }
    }
    while(!queue.isEmpty()){
      int popE = queue.poll();//popE的入度是0，取出list查看它的出度，如[4,1],[2,1]就是我要修4和2就要先修1，现在finish了1，那4和2的入度就各减少1，如果2的入度减少后为0，就可以将2入对
      ArrayList<Integer>toTake = graph.get(popE);
      if(toTake!=null){//因为有些节点是0入度，没有list
        for(int i = 0;i<toTake.size();i++){
          indegree[toTake.get(i)]--;//list里取数据用get
          if(indegree[toTake.get(i)]==0){
            queue.offer(toTake.get(i));
          }
        }
      }
    }
    for(int i = 0;i<numCourse;i++){
      if(indegree[i]!=0){
        return false;
      }
    }
    return true;
  }
}
/*topological sorting(拓扑排序)：不断的将没有入边的节点加入答案，直到答案中包含所有的节点或者不存在没有入边的节点
没有入边，也就是它没有任何的先修课程要求，这样将一个节点加入答案中后，就可以移除它的所有出边，代表着它的相邻节点少了一门先修课程的要求
对于有向图，每个顶点有两个“度“，从该点出发的边数叫做”初度“ ，指向该点的边数叫做”入度“。
[[4,0],[4,1],[3,1],[3,2],[5,4],[5,3]] index是0代表to take, 1代表prerequisite
indegree[0,0,0,2,2,2]
HashMap
0     (4)->
1     (4)->(3)->
2     (3)->
4     (5)->
3     (5)->

时间复杂度: O(n+m)其中 n 为课程数，m 为先修课程的要求数。这就是对图进行广度优先搜索的时间复杂度。
空间复杂度: O(n+m)。题目中是以列表形式给出的先修课程关系，为了对图进行广度优先搜索，我们需要存储成邻接表的形式，空间复杂度为 O(n+m)。在广度优先搜索的过程中，我们需要最多 O(n)的队列空间（迭代）进行广度优先搜索。因此总空间复杂度为 O(n+m)。

*/