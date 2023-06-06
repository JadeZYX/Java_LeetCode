import java.util.HashMap;

public class P1137TribonacciNumber {
    int[]value;
    public int tribonacci0(int n){
        value=new int[n+1];
        return helpTribonacci0(n);

    }
    public int helpTribonacci0(int n){
        if(n==0)return 0;
        if(n==1||n==2)return 1;
        if(value[n]>1)return value[n];
        value[n]=helpTribonacci0(n-1)+helpTribonacci0(n-2)+helpTribonacci0(n-3);
        return value[n];
    }
    //hashmap做法
    HashMap<Integer,Integer>map;
    public int tribonacci(int n){
        map=new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        return helpTribonacci(n);
    }
    public int helpTribonacci(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        map.put(n, helpTribonacci(n-1)+helpTribonacci(n-2)+helpTribonacci(n-3));
        return map.get(n);
    }
}
/*
        P1137TribonacciNumber p1137=new P1137TribonacciNumber();
        System.out.println(p1137.tribonacci(2));
        System.out.println(p1137.tribonacci(3));
        System.out.println(p1137.tribonacci(4));
        System.out.println(p1137.tribonacci(25));
*/