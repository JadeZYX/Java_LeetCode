import java.util.HashMap;

public class P0509FibonacciNumber {
    int[]res;
    public int fib0(int n){
       res=new int[n+1];
       return helpFib0(n); 
    }
    public int helpFib0(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(res[n]>1) return res[n];
        res[n]=helpFib0(n-1)+helpFib0(n-2);
        return res[n];
    }
//使用hashmap在理解上比array简单直接一些
    HashMap<Integer,Integer>map;
    public int fib(int n){
        map=new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return helpFib(n);
    }
    public int helpFib(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        map.put(n, helpFib(n-1)+helpFib(n-2));
        return map.get(n);
    }
}
/*
        P0509FibonacciNumber p509=new P0509FibonacciNumber();
        System.out.println(p509.fib(4));
*/
