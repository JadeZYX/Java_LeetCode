import java.util.ArrayList;
import java.util.List;

public class P0501FindModeInBST {
    List<Integer>list;
    public int[]findMode(TreeNode root){
        list=new ArrayList<>();
        traversal_inOrder(root);
        return Ans(list);
        
    }
    private int[]Ans(List<Integer>list){
        int maxcount=-1;
        int count=1;
        int previouInt=list.get(0);
        List<Integer>list1=new ArrayList<>();
        for(int i=1;i<list.size();i++){
           if(list.get(i)!=previouInt){
               if(count>maxcount){//这里count等于和大于属于两种情况必须是if，else
                   maxcount=count;
                   list1.clear();;
                   list1.add(previouInt);//因为更改结果是在这步进行，需要下一个数出来的时候决定怎么处理。
               }//所以数组里的最后一位数的下一位是溢出的，直接退出循环了。所以要循环结束后再对最后一个数进行单独处理
               else if(count==maxcount){
                   list1.add(previouInt);
               }
               count=1;
           }
           else if(list.get(i)==previouInt){
               count++;
           }
           previouInt=list.get(i);
        }

        if(count>maxcount){
            maxcount=count;
            list1.clear();;
            list1.add(previouInt);
        }
        else if(count==maxcount){
            list1.add(previouInt);
        }
        int[]ans=new int[list1.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list1.get(i);
        }
        return ans;
    }
    void traversal_inOrder(TreeNode node){
        if(node==null)return;
        traversal_inOrder(node.left);
        list.add(node.val);
        traversal_inOrder(node.right);
    }

    /*
    List<Integer> list;
    int maxCount = Integer.MIN_VALUE;
    int count = 0;
    int previous = Integer.MAX_VALUE;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        if (count > maxCount) {
            list.clear();
            list.add(previous);//add previous? add root.val??
        }
        else if (count == maxCount) {
            list.add(previous);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        handleValue(node.val);
        inOrder(node.right);
    }

    void handleValue(int val) {
        if (previous == Integer.MAX_VALUE) {//为什么对这个单独处理？？
            count = 1;
        }
        else {
            if (val != previous) {
                if (count > maxCount) {
                    list.clear();
                    maxCount = count;
                    list.add(previous);
                }
                else if (count == maxCount) {
                    list.add(previous);
                }
                count = 1;
            }
            else {
                count++;
            }
        }
        previous = val;
    }
    */
}
