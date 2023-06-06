public class P0075SortColors {
    public void sortColors(int[]nums){//单向指针 记录
        int ptr=0;
        for (int i=0;i<nums.length;i++){//将0换到前面
            if(nums[i]==0){
                nums[i]=nums[ptr];
                nums[ptr]=0;
                ptr++;
            }
        }
        for(int j=ptr;j<nums.length;j++){//将1换到0的后面
            if(nums[j]==1){
                nums[j]=nums[ptr];
                nums[ptr]=1;
                ptr++;
            }
        }
    }
    public void sortColors1(int[]nums){//双向指针，以0和2为主要操作对象
        int ptr1=0, ptr2=nums.length-1;
        int index=0;
        while(index<=ptr2){
            if(nums[index]==0){
                nums[index]=nums[ptr1];
                nums[ptr1]=0;
                ptr1++;
            }
            if(nums[index]==2){
                nums[index]=nums[ptr2];
                nums[ptr2]=2;
                ptr2--;
                index--;//！！上面index所代表的数与末尾指针交换后需要重新check
            }
            index++;//如果为1，也要++；
        }
    }
}
//题目需要对0，1，2进行有序排序，因为0代表红色，1代表白，2代表蓝色。所以可以先把所有的0先提取出放到最前面，然后提取1.