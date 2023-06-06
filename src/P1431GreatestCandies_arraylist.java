import java.util.ArrayList;
import java.util.List;
public class P1431GreatestCandies_arraylist {
    public List<Boolean> kidsWithCandies(int[]candies, int extraCandies){
        ArrayList<Boolean>res=new ArrayList<>(candies.length);
        int max=candies[1];
        for(int i:candies){
            max=Math.max(max, i);
        }
        for(int i=0;i<candies.length;i++){
            res.add(candies[i]+extraCandies>=max);
        }
        return res;
    }
}
/*
        P1431GreatestCandies_arraylist p1431=new P1431GreatestCandies_arraylist();
        List<Boolean> res=p1431.kidsWithCandies(new int[]{2,3,5,1,3}, 3);
        for(boolean ans:res){
            System.out.print(ans+" ");
        }
*/