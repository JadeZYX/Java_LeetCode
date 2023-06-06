import java.util.HashMap;

public class P0070ClimbingStaris {
    int[] count;//全局变量
    public int climbStairs(int n) {//Time O(N)  space O(N)
        count = new int[n + 1];
        return calculateSteps(n);
    }
    
    public int calculateSteps(int n) {
        if(n == 1) return 1;
        if(n ==2) return 2;
        if(count[n] > 0)
            return count[n];
        count[n] = calculateSteps(n -1) +  calculateSteps(n - 2); 
        return count[n];
    }
    //hashmap method
    HashMap<Integer,Integer>map;
    public int climbStairs1(int n){
        map=new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return calculateSteps1(n);
    }
    public int calculateSteps1(int n){
        if(map.containsKey(n))return map.get(n);
        map.put(n, calculateSteps1(n-1)+calculateSteps1(n-2));
        return map.get(n);
    }
}
/*
       P0070ClimbingStaris p70=new P0070ClimbingStaris();
        System.out.println(p70.climbStairs(3));
解题思路：假如有N个台阶，则最后一步可以走两步，也可以走一步，如果走一步，前面就有N-1个台阶，假设这N-1个台阶一共有
A种走法，则从1到N一共就有A种走法（从N-1到N就只能走一步，所以就是A*1），同理如果走两步，前面就有N-2个台阶，假设这N-2个台阶有B种走法，则从1-N就有B种走法，
所以N个台阶一共就有A+B种走法，也就是f(n)=f(n-1)+f(n-2);
使用数组是为了避免递归中的重复计算，也就是memorization，数组的长度是N+1，所以对应的下标就是从0到N，且初始值都为0.当N等于
1，对应的count[1]=1，当N=2，对应的count[2]=2
*/
