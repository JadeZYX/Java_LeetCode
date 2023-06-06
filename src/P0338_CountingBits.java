public class P0338_CountingBits {
    public int[] countBits0(int n){
        int[]ans=new int[n+1];
        for(int i=0;i<=n;i++){//时间复杂度最差是32*N
            int sum=0;
            int j=i;//开出变量j以进行下面的位移操作。如果不设定此变量，直接用i，会改变while循环后ans[i]中i的值
            while(j!=0){
                int last=j&1;
                if(last==1){
                    sum++;
                }
                j>>=1;
            }
            ans[i]=sum;
        }
        return ans;
    }
    public int[] countBits(int n){
        int[]ans=new int[n+1];
        for(int i=0;i<=n;i++){
            int count=0;
            int j=i;
            while(j!=0){ //循环条件
                j&=(j-1);//汉明距离的运用
                count++; //记录进行了几轮
            }
            ans[i]=count;
        }
        return ans;
    }
}
/*
        P0338_CountingBits p338=new P0338_CountingBits();
        int[] result1=p338.countBits(5);
        int[]result=p338.countBits(2);
        for(int i : result){
            System.out.print(i+"");
        }
        System.out.println();
        for(int j:result1){
            System.out.print(j+" ");
        }
*/