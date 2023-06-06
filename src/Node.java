import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;// 成员变量
    public List<Node> neighbors;
    public Node left,right,next;
    Node() { // 空的构造函数
    }

    Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
