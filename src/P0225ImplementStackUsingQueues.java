import java.util.LinkedList;
import java.util.Queue;
public class P0225ImplementStackUsingQueues {
     //第一种方法是使用2个queue
     public Queue<Integer>q1;
     public Queue<Integer>q2;
     public P0225ImplementStackUsingQueues(){
        this.q1=new LinkedList<>();
        this.q2=new LinkedList<>();
    }
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }
    public int pop(){
        
        return q1.poll();
    }
    public int top(){
        return q1.peek();
    }
    public boolean empty(){
        return q1.isEmpty();
    }

    /*第二种方法是使用1个queue
    public Queue<Integer>queue;
    public P0225ImplementStackUsingQueues(){
        this.queue=new LinkedList<>();
    }
    public void push(int x){//stack里push是入栈，所以queue里要入队。
       queue.offer(x);
       for(int i=0;i<queue.size()-1;i++) {//for循环确保队列进行删除操作时候不为空
           queue.add(queue.poll());
       }
    }
    public int pop(){//stack 里的pop是出栈，所以queue里要poll
       return queue.poll();
    }
    public int top(){
       return queue.peek();
    }
    public boolean empty(){
       return queue.isEmpty();
    }
    */
}
