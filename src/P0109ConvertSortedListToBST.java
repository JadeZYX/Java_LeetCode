public class P0109ConvertSortedListToBST {
    public TreeNode sortedlistToBST(ListNode head){
        return help(head,null);
    }
    private TreeNode help(ListNode start,ListNode end){
        if(start==end)return null;
        ListNode fast=start,slow=start;
        while(fast!=end&&fast.next!=end){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=help(start,slow);
        root.right=help(slow.next, end);
        return root;
    }
    

}
