public class P1351_binarysearch {
    //bf解法
    public int countNegatives0(int[][]grid){
        int count=0;
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(grid[m][n]<0){
                    count++;
                }
            }
        }
        return count;
    }
    //binary search:查找出第一个小于0的数也就是left列数，在用总列-查找出来第一个小于0所在的列，得出的就是小于0的个数
    public int countNegatives(int[][]grid){
        int count=0;
        for(int i=0;i<grid.length;i++){
                int left=0,right=grid[i].length-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(grid[i][mid]>=0){
                        left=mid+1;
                    }
                    else{
                       right=mid-1;
                    }
                }
                count=count+(grid[0].length-left); 
        }
        return count;
    }
}
/*
P1351_binarysearch p1351=new P1351_binarysearch();
System.out.println(p1351.countNegatives(new int[][]{{1,-1},{-1,-1}}));
System.out.println(p1351.countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
System.out.println(p1351.countNegatives(new int[][]{{3,2}}));
*/
