import java.util.HashSet;
public class P0575DistrubuteCandies {
    public int distributeCandies(int[]candyType){
       if(candyType.length==0) return 0;
       HashSet<Integer>set=new HashSet<>();
       for(int i=0;i<candyType.length;i++){
           set.add(candyType[i]);
       }
       return Math.min(set.size(), candyType.length/2);
    }
}//这道题目的关键是能会转换糖块的品种总数和半数糖块的关系。
//如果是糖块的种类数大于半数糖块的数目，则直接返回半数糖块数量。
//如果糖块的种类数小于等于半数糖块的数目，则返回种类数。
//所以二者取小值。
