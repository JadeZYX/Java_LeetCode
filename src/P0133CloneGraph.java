import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P0133CloneGraph {
    HashMap<Node, Node> graphMap = new HashMap<>();// 存原始的和copy的节点

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;// 节点不存在 指针指向null
        if (graphMap.containsKey(node)) {
            return graphMap.get(node);// 节点如果存在与map中，直接取出来用。避免重复copy
        }
        Node newHead = new Node(node.val);// map里没有的节点需要开出新的Node来
        graphMap.put(node, newHead);// 将目前已经克隆出的节点添加到map里，Key是原始节点，Value是对应的Copy节点
        for (Node nei : node.neighbors) {// 对节点的邻居们进行处理。也要check map里是否存在邻节点，避免重复操作
            newHead.neighbors.add(cloneGraph(nei));
        }
        return newHead;
    }

    public Node cloneGraph1(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);// 只添加value，不添加nei，但先初始化为空
        map.put(node, newNode);
        //  已经复制过的，但neighbor还没添加
        Queue<Node> queue = new LinkedList<>();// Queue为接口，linkedlist是类型；
        queue.offer(node);
        while (!queue.isEmpty()) {// 队列循环标准格式
            Node cur = queue.poll();// 将队列中的元素取出来进行下一步操作
            for (Node nei : cur.neighbors) {// 对当前poll出来元素的邻居们进行添加
                if (map.containsKey(nei)) {
                    map.get(cur).neighbors.add(map.get(nei));
                } else {
                    Node newNei = new Node(nei.val);
                    map.get(cur).neighbors.add(newNei);
                    map.put(nei, newNei);
                    queue.offer(nei);
                }
            }
        }
        return newNode;
    }
}
// Time Complexity: O(V + E)
// Space Complexity: O(V). Both Recursion Stack and HashMap will take O(V) space
// V = Number of nodes. E = Number of edges in the graph.