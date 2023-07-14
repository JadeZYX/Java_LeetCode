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
A种走法，则从1到N一共就有A种走法（从N-1到N就只能走一步，所以就是A*1），同理如果走两步，前面就有N-2个台阶，假设这N-2个台阶有B种走法，则从1-N就有B种走法，所以N个台阶一共就有A+B种走法，也就是f(n)=f(n-1)+f(n-2);
使用数组是为了避免递归中的重复计算，也就是memorization，数组的长度是N+1，所以对应的下标就是从0到N，且初始值都为0.当N等于1，对应的count[1]=1，当N=2，对应的count[2]=2

当我们要爬到第 x 级台阶时，可以考虑最后一步的情况。最后一步可以是从第 x-1 级台阶跨一步到达第 x 级，或者从第 x-2 级台阶跨两步到达第 x 级。因为爬楼梯的方式只有这两种，所以到达第 x 级的方法数等于到达第 x-1 级的方法数加上到达第 x-2 级的方法数。我们可以定义一个状态数组 dp，其中 dp[i] 表示爬到第 i 级台阶的方法数。根据上述思路，可以得到状态转移方程：
dp[x] = dp[x-1] + dp[x-2]
根据初始条件，可以设置 dp[1] = 1 和 dp[2] = 2，因为爬到第一级台阶只有一种方法，爬到第二级台阶有两种方法（一步一步爬或者一次跨两步）。
通过计算 dp[x] 的方式，我们可以逐步计算出爬到第 x 级台阶的方法数，直到达到目标台阶的位置。
*/