public class P0461hammingdistance {
    public int hammingDistance(int x,int y){
        int num=x^y;//先用位异或求出两个数不同的位置。位异或：相同为0，不同为1
        int sum=0;
        while(num!=0){
            num&=(num-1);//汉明距离求1的个数；
            sum++;
        }
        return sum;
    }
}
/*
        P0461hammingdistance p461=new P0461hammingdistance();
        System.out.println(p461.hammingDistance(1, 4));
        System.out.println(p461.hammingDistance(3, 1));
*/