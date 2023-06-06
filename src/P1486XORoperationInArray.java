public class P1486XORoperationInArray {
    public int xorOperation(int n,int start){
        int ans=0;
        for(int i=0;i<n;i++){
            ans^=(start+i*2);
        }
        return ans;
    }
    //O(n)时间 用一重循环对n个数字进行异或    O(1)这里只用了常量级别对辅助空间

    public int xorOperation1(int n,int start){ //O(n)
        int[]nums=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            nums[i]=start+2*i;
            res^=nums[i];
        }
        return res;
    }
}
/*
        P1486XORoperationInArray p1486=new P1486XORoperationInArray();
        System.out.println(p1486.xorOperation(5, 0));
        System.out.println(p1486.xorOperation(4, 3));
        System.out.println(p1486.xorOperation(1, 7));
        System.out.println(p1486.xorOperation(10, 5));
*/