import java.util.ArrayList;
import java.util.HashMap;

public class P0323NumberOfConnectedComponents {
  /* problem description
  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
  Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]        output: 2
     0          3
     |          |
     1 --- 2    4
  Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]      output:1
     0           4
     |           |
     1 --- 2 --- 3
   */
  public int countComponents(int n, int[][]edges){//O(m+n)m是节点个数，n是边
    int res = 0;
    //using hashmap to create graph, key is the node, value is neighbours
    HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();
    for(int i = 0;i<edges.length;i++){
      int node1 = edges[i][0];
      int node2 = edges[i][1];
      if(!graph.containsKey(node1)){
        graph.put(node1, new ArrayList<Integer>());
      }
      graph.get(node1).add(node2);
      if(!graph.containsKey(node2)){
        graph.put(node2, new ArrayList<>());
      }
      graph.get(node2).add(node1);
    }
    boolean[]visited = new boolean[n];//已经访问过的节点mark下
    for(int i = 0;i<n;i++){
      if(!visited[i]){
        res++;
        DFS(graph,visited,i);
      }
    }
    return res;
  }
  void DFS(HashMap<Integer,ArrayList<Integer>>graph,boolean[]visited,int node){
    if(visited[node])return;//如果节点已经被访问过，直接返回
    visited[node] = true;
    ArrayList<Integer>neighbours = graph.get(node);
    for(int i = 0;i<neighbours.size();i++){
      DFS(graph,visited,neighbours.get(i));
    }
  }
}
/*
 需要创建一个graph，
 DFS:一共N个Nodes，所以开出N个区间，DFS访问相邻节点且mark一下此节点已经被访问过。
 */