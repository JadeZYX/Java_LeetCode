import java.util.HashMap;

public class P2001NumberOfParis2 {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();// 统计出每个矩形的宽高ratio和其ratio出现的次数
        for (int[] temp : rectangles) { // 二维数组，所以类型是int[]
            double ratio = (double) temp[0] / (double) temp[1];
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        long result = 0;// 因为题目要求返回此类型的，所以pairsNumber也是long类型才能统一进行计算操作
        for (long pairsNumber : map.values()) {// 把ratio出现的次数取出来并计算可以配成的对数n*(n-1)/2;
            result = result + ((pairsNumber * (pairsNumber - 1)) / 2);
        } 
        return result;
    }

  //long代表64位整数                     整型是一种数据类型，int 32,int 64
    public long interchangeableRectangles1(int[][] rectangles) {//含有指数，暴力解法会超时
        long result = 0;
        for (int i = 0; i < rectangles.length - 1; i++) {
            double ratio = ((double)rectangles[i][0]) / rectangles[i][1];//因为从左往右运算，所以将第一个数转为double类型即可。
            for (int j = i + 1; j < rectangles.length; ++j) {
                double Ratio = 1.0 * rectangles[j][0] / rectangles[j][1];//用1.0* 可以将数转为double类型
                if (ratio == Ratio)
                    result++;
            }
        }
        return result;
    }
    //P2001NumberOfParis2 p2001=new P2001NumberOfParis2();
   // System.out.println(p2001.interchangeableRectangles1(new int[][]{{4,5},{7,8}}));
}
