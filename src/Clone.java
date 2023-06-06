import java.util.HashMap;

public class Clone {
    public TreeNode clone(TreeNode root) {//克隆Tree
        if(root==null)return null;
        TreeNode node=new TreeNode(root.val);
        node.left=clone(root.left);
        node.right=clone(root.right);
        return node;
    }

    public ListNode copyListNode(ListNode head){//克隆List，LinkedList
        if(head==null) return null;
        ListNode node=new ListNode(head.val);
        node.next=copyListNode(head.next);
        return node;
    }
    HashMap<ListNode,ListNode> graphMap=new HashMap<>();//存原始的和copy的节点
    public ListNode cloneGraph(ListNode node){//克隆图
        if(node==null)return null;//节点不存在 指针指向null
        if(graphMap.containsKey(node)){
           return graphMap.get(node);//节点如果存在与map中，直接取出来用。避免重复copy
        }
        ListNode newHead=new ListNode(node.val);//map里没有的节点需要开出新的Node来
        graphMap.put(node, newHead);//将目前已经克隆出的节点添加到map里，Key是原始节点，Value是对应的Copy节点
        for(ListNode nei:node.neighbors){//对节点的邻居们进行处理。也要check map里是否存在邻节点，避免重复操作
            newHead.neighbors.add(cloneGraph(nei));
        }
        return newHead;
    }
}
