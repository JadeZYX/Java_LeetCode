
public class P0088_mergeSortedArray {
     public void merge0(int[]nums1,int m,int[]nums2,int n){
        int index1=m-1,index2=n-1,index3=m+n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[index3]=nums1[index1];
                index3--;
                index1--;
            }
            else{
                nums1[index3]=nums2[index2];
                index3--;
                index2--;
            }
            //nums1[index3--]=nums1[index1]>nums2[index2]?nums1[index--]:nums2[index2--]
        }
        while(index2>=0){
            nums1[index3]=nums2[index2];
            index3--;
            index2--;
        }
     }
    public void merge2(int[]nums1,int m,int[]nums2,int n){
        int[] mergearr=new int[m+n];
        int index1=0,index2=0,index3=0;
        // O(N) 线性, O(N^2) 平方, O(logN)
        // O(N) -> O(2(m+n))
        while(index1<m&&index2<n){
             if(nums1[index1]>nums2[index2]){
                mergearr[index3]=nums2[index2];
                index3++;
                index2++;
             }
             else if(nums1[index1]<=nums2[index2]){
                 mergearr[index3]=nums1[index1];
                 index3++;
                 index1++;
             }
            //mergearr[index3++]=nums1[index1]>nums2[index2]?nums2[index2++]:nums1[index1++];
        }
        while(index1<m){
            mergearr[index3]=nums1[index1];
            index3++;
            index1++;
        }
        while(index2<n){
            mergearr[index3++]=nums2[index2++];
        }
        for(int i=0;i<m+n;i++){
            nums1[i]=mergearr[i];
        }
    }
 
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // O(N)
        for (int i = 0; i < n; i++) { // 将第二个数组的元素添加到第一个
            nums1[m + i] = nums2[i];
        }
        //Arrays.sort(nums1);//排序
        // O(N^2)
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < m + n - 1 - i; j++) {// 对第一个元素进行排序
                if (nums1[j] > nums1[j + 1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                }
            }
        }

        // O(N^2 + N) -> O(N(N+1)) -> O(N^2)
    }
    public void merge(int[]nums1,int m,int[]nums2,int n){ //recursion递归方法
        if(n==0) {
            return;
         }
        if(m==0) {
           nums1[n-1]=nums2[n-1];
           n=n-1;
           merge(nums1,m,nums2,n);
       }
        else if(nums1[m-1]>nums2[n-1]) {
             nums1[m+n-1]=nums1[m-1];
              m--;
             merge(nums1,m,nums2,n);
       }
        else {//nums1[m-1]<=nums2[n-1]
           nums1[m+n-1]=nums2[n-1];
           n--;
           merge(nums1,m,nums2,n);
      }
    }
    
}
//优先级：O(logN)->O(N)->O(N*logN)->O(N^2)
/*
        P0088_mergeSortedArray p88=new P0088_mergeSortedArray();
        //int[]nums1=new int[]{4,5,6,0,0,0};
        int[]nums2=new int[]{1,2,3};
        int[]nums3=new int[]{7,8,9,0,0,0};
        p88.merge(nums3, 3, nums2, 3);
        for(int i:nums3){
            System.out.print(i);
        } 
        */     