import java.util.PriorityQueue;

public class P0703KthLargestElementInStream {
    PriorityQueue<Integer>pq;
    int k;
    public P0703KthLargestElementInStream(int k,int[]nums){
        this.k=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            while(pq.size()>k){
                pq.poll();
            }
        }
    }
    public int add(int val){
        pq.offer(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }

}
