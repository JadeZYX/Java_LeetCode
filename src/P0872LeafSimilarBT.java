import java.util.ArrayList;

public class P0872LeafSimilarBT {
    ArrayList<Integer>list1;
    ArrayList<Integer>list2;
    public boolean leafSimilar(TreeNode root1,TreeNode root2){
       list1=new ArrayList<>();
       list2=new ArrayList<>();
       getLeafValues(root1,list1);
       getLeafValues(root2,list2);
       return list1.equals(list2);//第一种写法

       /*第二种写法 
       if(list1.size()!=list2.size()){
           return false;
       }
       for(int i=0;i<list1.size();i++){
           if(list1.get(i)!=list2.get(i)){
               return false;
           }
       }
        return true;
    */
    }
    void getLeafValues(TreeNode node,ArrayList<Integer>list){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            list.add(node.val);
        }
        getLeafValues(node.left,list);
        getLeafValues(node.right,list);
    }
}
