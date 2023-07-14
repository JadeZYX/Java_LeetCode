
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P0133CloneGraph {
    public class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node(int val, ArrayList<Node> nei) {
            this.val = val;
            this.neighbors = nei;
        }
    }

    HashMap<Node, Node> graphMap = new HashMap<>();// 存原始的和copy的节点

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;// 节点不存在 指针指向null
        if (graphMap.containsKey(node)) {
            return graphMap.get(node);// 节点如果存在与map中，直接取出来用。避免重复copy
        }
        Node newHead = new Node(node.val, new ArrayList<>());// map里没有的节点需要开出新的Node来
        graphMap.put(node, newHead);// 将目前已经克隆出的节点添加到map里，Key是原始节点，Value是对应的Copy节点
        for (Node nei : node.neighbors) {// 对节点的邻居们进行处理。也要check map里是否存在邻节点，避免重复操作
            newHead.neighbors.add(cloneGraph(nei));
            // 如果节点之前copy过，直接返回map里取出来的值
        }
        return newHead;
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph2(Node node) {// 这个模版更好理解
        if (node == null)
            return null;
        return dfs(node);// 题目给出起点就是一个节点，所以返回clone的起点即可。
    }

    Node dfs(Node node) {
        // node节点已经被访问过了,直接从哈希表hash中取出对应的克隆节点返回。
        if (map.containsKey(node))
            return map.get(node);
        Node clone = new Node(node.val, new ArrayList<>()); // 克隆节点
        map.put(node, clone); // 建立源节点到克隆节点的映射
        for (Node ver : node.neighbors) // 克隆边
        {
            clone.neighbors.add(dfs(ver));// 递归的返回值直接添加到list里面
        }
        return clone;
    }

    public Node cloneGraphBFS(Node node) {// BFS做法
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cloneNode = new Node(node.val, new ArrayList<>());// 克隆节点，邻居先不关注
        Queue<Node> queue = new LinkedList<>();
        map.put(node, cloneNode);
        queue.offer(node);// 第一个节点肯定要添加进去
        while (!queue.isEmpty()) {
            Node popE = queue.poll();
            // 查看邻居节点
            for (Node nei : popE.neighbors) {
                if (!map.containsKey(nei)) {
                    Node newNode = new Node(nei.val, new ArrayList<>());
                    map.put(nei, newNode);
                    queue.offer(nei);
                }
                map.get(popE).neighbors.add(map.get(nei));// 必须用map取出对应的克隆节点
            }
        }
        return cloneNode;
    }

    public Node cloneGraph1(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());// 只添加value，不添加nei，但先初始化为空
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
                    Node newNei = new Node(nei.val, new ArrayList<>());
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
/*
 * 题目给出的仅有一个开始起点。我们需要做的是通过这个节点把整个图还原做copy。所以先copy当前节点，然后取访问当前节点的邻居，
 * 如果它的邻居已经做过copy，则直接使用，如果不存在map里，则做copy并mark在map里，避免重复copy。比如我们已经做过节点1的copy，
 * 访问到节点2的时候，发现它的邻居是1，如果没有map的辅助，会重新在创建一个新的节点1.但因为借助于map，我们知道节点1已经被copy过，
 * 所以直接使用就好，把这个节点添加到节点2的邻居节点里。
 */