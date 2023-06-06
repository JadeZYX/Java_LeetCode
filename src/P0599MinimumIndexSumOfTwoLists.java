import java.util.ArrayList;
import java.util.HashMap;

public class P0599MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[]list1,String[]list2){
        ArrayList<String> finalList=new ArrayList<>(list1.length);
        HashMap<String,Integer> map2=new HashMap<>(list2.length);//将list2的元素添加到hashmap里方便查询和求下标
        for(int i=0;i<list2.length;++i){
            map2.put(list2[i], i);
        }
        int minSumIndex=Integer.MAX_VALUE;//求最小值，所以当前假设最大值为最小值，通过后面的运算再更改最小值
        for(int j=0;j<list1.length;++j){
            if(map2.containsKey(list1[j])){
                if(j+map2.get(list1[j])<minSumIndex){//如果求到下标和更小的，将之前的array list清空并添加当前的元素
                    minSumIndex=j+map2.get(list1[j]);
                    finalList.clear();
                    finalList.add(list1[j]);
                }
                else if(j+map2.get(list1[j])==minSumIndex){//若新求到的下标和与最小值相等则直接添加
                    finalList.add(list1[j]);
                }
            }
        }
        String[]res=new String[finalList.size()];
        int k=0;
        for(String ans:finalList){//将array list转成题目要求返回的array
            res[k]=ans;
            k++;
        }
        return res;
    }
}
/*
        P0599MinimumIndexSumOfTwoLists p599=new P0599MinimumIndexSumOfTwoLists();
        String[] res=p599.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, 
                                         new String[]{"KNN","KFC","Burger King","Tapioca Express","Shogun"});
        for(String s:res){
            System.out.print(s+", ");
        }
*/
