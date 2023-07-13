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
用位异或，相同为0，不同为1的原则可以得到一个新的二进制数，对应位置上不同会显示1
两个字符串的汉明距离等于它们的异或结果的汉明权重
这是因为两个等长字符串的异或运算将产生一个新的字符串，其中每个位都表示两个输入字符串在该位置上的差异。这个新字符串的汉明权重就是两个原始字符串的汉明距离。
        P0461hammingdistance p461=new P0461hammingdistance();
        System.out.println(p461.hammingDistance(1, 4));
        System.out.println(p461.hammingDistance(3, 1));
*/