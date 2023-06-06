public class P1662StringArrays_Equivalent {
    public boolean arrayStringsAreEqual(String[]word1,String[]word2){
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(String word_1:word1){
            sb1.append(word_1.toCharArray());
        }
        for(String word_2:word2){
            sb2.append(word_2.toCharArray());
        }
        return sb1.toString().equals(sb2.toString());
        //==是查看存储地址是否一致，而equals方法是看值是否一致
    }
}
//P1662StringArrays_Equivalent p1662=new P1662StringArrays_Equivalent();
//System.out.println(p1662.arrayStringsAreEqual(new String[]{"ab","c"}, new String[]{"a","bc"}));
