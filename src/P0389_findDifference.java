public class P0389_findDifference {
    public char findTheDifference(String s, String t) { // O(N)+O(1)
        int sumS = 0, sumT = 0;
        for (int i = 0; i < s.length(); i++) {
            sumS += s.charAt(i);// 将字符串里面的每个char求和。
        }
        for (int j = 0; j < t.length(); j++) {
            sumT += t.charAt(j);
        }
        return (char) (sumT - sumS);// 将int类型转换成char类型。 
    }

    public char findTheDifference2(String s, String t) { // O(N)+O(1)
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= (s.charAt(i));// res是int类型的，等号右边是
        }
        for (int j = 0; j < t.length(); j++) {
            res ^= (t.charAt(j));
        }
        return (char) res;
    }
    

}   
/*
        P0389_findDifference p389=new P0389_findDifference();
        System.out.println(p389.findTheDifference("abcd", "abcde"));
        System.out.println(p389.findTheDifference("", "y"));
        System.out.println(p389.findTheDifference("a", "aa"));
     */