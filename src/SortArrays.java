public class  SortArrays {
    //bubble排序是比较两个相邻的数，最大的数也就会不断后移动到最后冒泡。两层for循环。时间复杂度O（N*N）
    public int[] bubbleSort(int[]nums){
        for(int i=nums.length-1;i>0;i--){///外层循环表需要便利的数组元素的个数，由于最大值的不断冒泡固定并不断的递减
            for(int j=0;j<i;j++){//内层循环是从0开始到i-1结束，此过程把相邻两个元素的较大值不断后移并固定在最后一位
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];//因为这里比较的是j和j+1,所以j只需到i-1即可
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
    //选择排序是假设当前的数是最小的数，for循环查找若比假定的数更小，则更换索引和两个数的位置
    public int[] selectSort(int[]nums){//O(n*n)
        for(int i=0;i<nums.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex=j;
                }
            }
            this.swap(nums, i,minIndex);
        }
        return nums;
    }
    private void swap(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }









    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // merge
        int[] temp = new int[right - left + 1];
        int i1 = left, i2 = mid + 1, i = 0;
        while (i1 <= left && i2 <= right) {
            if (nums[i1] < nums[i2]) {
                temp[i] = nums[i1];
                i1++;
            }
            else {
                temp[i] = nums[i2];
                i2++;
            }

            i++;
        }

        while (i1 <= left) {
            temp[i] = nums[i1];
            i1++;
            i++;
        }

        while (i2 <= right) {
            temp[i] = nums[i2];
            i2++;
            i++;
        }

        // end of merge

        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
