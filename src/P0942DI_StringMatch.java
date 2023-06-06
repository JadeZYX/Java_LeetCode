public class P0942DI_StringMatch {
    public int[]diStringMatch(String s){
        int[]res=new int[s.length()+1];
        int low=0;
        int high=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                res[i]=low;
                low++;
            }
            else {   //(s.charAt(i)=='D')
                res[i]=high;
                high--;
            }
        }
        res[s.length()]=low;//high  数组长度是N+1，所以最后一个单独处理
        return res;
    }
}
//这道题目可以用贪心算法。题目要求array的长度是string长度+1，且是从0～N之间的数。
//当char是I时候，下一个数要比当前数大，increase；当char是D时候，下一个数要比当前数小，decrease；
//所以当是I的时候尽量取最小的数，这样下一个数一定比最小数要大。
//相反当是D的时候我们尽量取最大的数，这样下一个数一定比当前数要小。
