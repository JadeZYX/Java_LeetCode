import java.util.ArrayList;

public class P1290_linkedlist_decimal {
    public int getDecimalValue0(ListNode head){
        int res=0;
        int multi=1;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        ListNode cur=head;
        while(cur!=null){
            arr.add(cur.val);
            cur=cur.next;
        }
        for(var i=arr.size()-1;i>=0;i--){ //二进制转10进制
            res=res+arr.get(i)*multi;//取array list里元素的方法是用get
            multi*=2;//！！
        }
        return res;
    }
    public int getDecimalValue(ListNode head){
        int result=0;
        ListNode p=head;
        while(p!=null){
            result=result*2+p.val;//!!十进制：res=res*10+num;
            p=p.next;
        }
        return result;
    }
}
/*
    P1290_linkedlist_decimal p1290=new P1290_linkedlist_decimal();
    System.out.println(p1290.getDecimalValue(new ListNode(new int[]{1,0,1})));
*/
