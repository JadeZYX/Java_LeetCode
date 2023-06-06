import java.util.ArrayList;
import java.util.List;
public class P0155MyStack {
    private List<Integer> list;
    private List<Integer> minList;
    //private int min=Integer.MAX_VALUE;
    public P0155MyStack () {
        list = new ArrayList<>();
        minList=new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        if (minList.isEmpty()) minList.add(val);
        else minList.add(Math.min(getMin(), val));
    }

    public void pop() {
      list.remove(list.size()-1);
      minList.remove(minList.size()-1);
    }

    public int top() {
       return list.get(list.size()-1);
    }

    public int getMin() {
       return minList.get(minList.size()-1);
    }
}
