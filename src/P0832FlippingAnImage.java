public class P0832FlippingAnImage {
    public int[][] flipAndInvertImage0(int[][] image) {
        for(int i=0;i<image.length;i++){
            int left=0;
            int right=image[i].length-1;
            while(left<=right){
                   if(image[i][left]==image[i][right]){
                    image[i][left]=1-image[i][left];
                    image[i][right]=image[i][left];
                   }
                left++;
                right--;
            }
        }
         return image;
      }

    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
                reverse(image[i]);
                swap(image[i]);
        }
        return image;
    }
    private int[] reverse(int[]nums){
       int left=0,right=nums.length-1;
       while(left<=right){
           int temp=nums[left];
           nums[left]=nums[right];
           nums[right]=temp;
           left++;
           right--;
       }
        return nums;
    }
    private int[] swap(int[]nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
        return nums;
    }
    //方法2
    public int[][] flipAndInvertImage1(int[][] image) {
        for(int i=0;i<image.length;i++){
             reverse1(image[i]);
         }
         return image;
     }
     private int[] reverse1(int[]nums){
        int left=0,right=nums.length-1;
        while(left<=right){
            nums[left] = 1 - nums[left];//因为只有1和0，所以用这种方法互换
            if (left != right) nums[right] = 1 - nums[right];
            // swap
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
         return nums;
     }   
}
//P0832FlippingAnImage p832=new P0832FlippingAnImage();
//System.out.println(p832.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));