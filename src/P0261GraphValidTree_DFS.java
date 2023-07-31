import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class P0261GraphValidTree_DFS {
/* description
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of     nodes), write a function to check whether these edges make up a valid tree.
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]       Output: true
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] Output: false
 */
  public boolean validTree1(int n, int[][]edges){
    if(n == 1) return true;
    if(n - 1 != edges.length) return false;
    HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();
   for(int i = 0;i<edges.length;i++){//create undirected graph
       int node1 = edges[i][0];
       int node2 = edges[i][1];
       if(!graph.containsKey(node1)){
        graph.put(node1, new ArrayList<Integer>());
       }
       graph.get(node1).add(node2);
       if(!graph.containsKey(node2)){
        graph.put(node2,new ArrayList<>());
       }
       graph.get(node2).add(node1);
   }
   boolean[]visited = new boolean[n];
   //valid tree会是一个整体，所以从0开始遍历。如果不是一个整体，则visited数组就会有false存在。
   if(!DFS(graph, visited, 0, -1)){
      return false;
   }
   for(boolean res:visited){
    if(res == false){
      return false;
    }
   }
   return true;
  }
  private boolean DFS(HashMap<Integer,ArrayList<Integer>>graph,boolean[]visited,int curNode,int parentNode){
    if(!graph.containsKey(curNode)){
      return false;//如果是多个component并非一个整体，则当前节点是独立存在于tree之外的
    }

    if(visited[curNode]){
      return false;
    }
    visited[curNode]=true;
    ArrayList<Integer>neighbours = graph.get(curNode);//把当前节点的邻居提取出来
    for(int i = 0;i<neighbours.size();i++){
      if(neighbours.get(i)==parentNode){
        continue;
      }
      if(!DFS(graph,visited,neighbours.get(i),curNode)){
        return false;//如果遇到false的结果直接返回
      }
    }
    return true;
  }
//hashmap + hashset 做法
  public boolean validTree(int n, int[][]edges){
    if(n-1 != edges.length) return false;
    if(n == 1) return true;
    //create graph
    HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();
    for(int i = 0;i<edges.length;i++){
      if(!graph.containsKey(edges[i][0])){
        graph.put(edges[i][0], new ArrayList<>());
      }
      graph.get(edges[i][0]).add(edges[i][1]);
      if(!graph.containsKey(edges[i][1])){
        graph.put(edges[i][1],new ArrayList<>());
      }
      graph.get(edges[i][1]).add(edges[i][0]);
    }
    HashSet<Integer>visited = new HashSet<>();
    boolean res = helper(graph,visited,0,-1);
    if(!res){
      return false;
    }
    return visited.size() == n;//如果不是一棵树，则set的size会小于节点
  }

  private boolean helper(HashMap<Integer,ArrayList<Integer>>graph,HashSet<Integer>visited,int curNode,int parentNode){
    if(!graph.containsKey(curNode)){//如果不是一个整体的component
      return false;
    }
    if(visited.contains(curNode)){
      return false;
    }
    visited.add(curNode);
    ArrayList<Integer>children = graph.get(curNode);
    for(int i = 0;i<children.size();i++){
      if(children.get(i)==parentNode)continue;
      boolean res = helper(graph, visited, children.get(i),curNode);
      if(!res){
        return false;
      }
    }
    return true;
  }

}
/*
  valid树要满足：1）节点数-1是边数edge  2）一个整体component  3）无环
  所以如果用并查集做，两个节点有共同的parent，但还是相连状态，那就不对了
  第二个例子
  0  --- 1 像 0会指向1 但是1 也会指向0，这种不算是有环cycle
  若 0-1-2-3-1,之后1右指向2-3-1这种是有环的。
  现在需要解决如何避免 0-1这种会返回false
  helper(graph,visited,0,-1)，set 为空。当前节点0，假设父节点是-1，进入辅函数，hashset里添加0.0的children是【1】
  --->helper(graph,visited,1,0),set里添加1，然后是取出1的孩子[0，2，3，4]，0跳过
  ---->helper(graph,visited,2,1) visited里添加2，取出2的孩子[1,3] 1跳过
  ------>helper(graph,visited,3,2) visited里添加3,取出3的孩子[1,2],由于1已经visited了，所以false

 */