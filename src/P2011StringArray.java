import java.util.HashMap;

public class P2011StringArray {
    public int finalValueAfterOperations0(String[]operations){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("--X", -1);
        map.put("X--", -1);
        map.put("++X", 1);
        map.put("X++", 1);
        int res=1;
        for(int i=0;i<operations.length;i++){
            res=res+map.get(operations[i]);
        }
        return res;
    }
   public int finalValueAfterOperations(String[]operations){
        int sum=0;
        for(int i=0;i<operations.length;i++){//O(m) m代表string array的长度
            if(operations[i].contains("+")){ //O(1)n代表string的长度最长就是3  contain的字符串是固定的O(1)
                sum++;
            }
            else{
                sum--;
            }
        }
        return sum;
    }
    public int finalValueAfterOperations2(String[] operations) {
        int num=0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("++X")||operations[i].equals("X++")){
                num++;
            }
            else{
                num--;
            }
        }
        return num;
    }
}
// P2011StringArray p2011=new P2011StringArray();
// System.out.println(p2011.finalValueAfterOperations2(new String[]{"--X","X++","X++"}));