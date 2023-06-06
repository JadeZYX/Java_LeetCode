import java.util.PriorityQueue;

public class P0215KthlargestElementInArray {
    public int findKthLargest(int[]nums,int k){
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        for(int j=0;j<k;j++){
            pq.poll();
        }
        return pq.peek();
    }
}
