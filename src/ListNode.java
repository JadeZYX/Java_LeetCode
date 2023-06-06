import java.util.List;
/**
 * Definition for singly-linked list.
 */
public class ListNode { // list 是链表，listnode是节点，节点里包含值和指针
    public int val;// 成员变量
    public ListNode next;// 指针
    public ListNode random;
    public List<ListNode> neighbors;

    ListNode() { // 空的构造函数
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] nums) {
        this.val = nums[0]; // ListNode head=new ListNode(nums[0]);
        ListNode p = this;// 指针 ListNode p=head;
        for (int i = 1; i < nums.length; ++i) {
            p.next = new ListNode(nums[i]);//开出新的下一个节点
            p = p.next;// pointer 改变指针
        }
    }
    public void printListNode() {  //这里的print在类下，所以没有传入参数，但其实下一行this就代表里引用自己。
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
//链表属于复杂数据类型，p=p.next或p.next=p.next.next，这里等号右侧不是赋值给左侧。
//复杂类型里等号左右两侧都是存储位置，所以是等号左侧都引用等号右侧的存储位置。
