import java.util.ArrayList;
import java.util.HashMap;

public class P0261GraphValidTree_DFS {
/* description
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of     nodes), write a function to check whether these edges make up a valid tree.
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]       Output: true
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] Output: false
 */
  public boolean validTree(int n, int[][]edges){
    if(n == 1) return true;
    HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();

  }
}
/*
  valid树要满足：1）节点数-1是边数edge  2）一个整体component  3）无环
  所以如果用并查集做，两个节点有共同的parent，但还是相连状态，那就不对了
 */