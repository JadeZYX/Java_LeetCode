public class P0011ContainerWithMostWater_2pointers {
    public int maxArea(int[]height){
        if(height.length==0)return 0;
        int left=0,right=height.length-1;
        int maxarea=Integer.MIN_VALUE;
        while(left<right){
            int width=Math.abs(left-right);
            int dep=Math.min(height[left], height[right]);
            int area=width*dep;
            if(area>maxarea){
                maxarea=area;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
    public int maxArea3(int[] height) {
        //get area: maxwidth (length between two lines)* maxheight(shorter one)
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(right>left){
           int width = Math.abs(left-right);
           int curheight = Math.min(height[right],height[left]);
           int currentArea = width*curheight;//求出当前面积
           maxArea = Math.max(currentArea,maxArea);//更新结果
           if(height[right]<height[left]){//移动指针
               right--;
           }
           else{
               left++;
           }
        }
        return maxArea;
    }
    public int maxArea1(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int leftPoint = 0;
        int rightPoint = height.length-1;
        while(leftPoint < rightPoint){
            if(height[leftPoint]< height[rightPoint]){
                int area = height[leftPoint]*(rightPoint - leftPoint);
                maxArea = Math.max(area,maxArea);
                leftPoint++;
            }
            else if(height[leftPoint]>height[rightPoint]){
                int area = height[rightPoint]*(rightPoint - leftPoint);
                maxArea = Math.max(area,maxArea);
                rightPoint--;
            }
            else{
                int area = height[rightPoint]*(rightPoint - leftPoint);
                maxArea = Math.max(area,maxArea);
                leftPoint++;
                rightPoint--;
            }
        }
        return maxArea;
    }
    public int maxArea2(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        //maxarea = height*(length between two lines)
        int left = 0;
        int right = height.length-1;
        while(left<right){
            if(height[left]<height[right]){
                //容器不能倾斜，所以要取较小高度值，宽度就是两者之间的距离
                maxArea = Math.max(maxArea,height[left]*(right-left));
                left++;//由于当前高度值小，所以移动此指针才有可能获取更大高度值
            }
            else{//如果右侧高度值小于左侧或者等于左侧的高度值，我们均可用右侧高度值参与运算，宽度就是二者距离
                maxArea = Math.max(maxArea,height[right]*(right-left));
                right--;
            }
        }
        return maxArea;
    }
}
/*
这道题目求融水最大量，就是求面积，maxlength * maxheight.怎么得到最大长度呢？它就是两个 lines之间的距离，
也就是right- left。怎么得到最大height呢？两个lines的高度不同，我们要取较小值作为calculate的值，因为不能slant the container.所以当左侧的line高度大时候，我们要取右侧的height，且右侧指针向左侧移动一位。当右侧的line的高度较高的时候，我们要取左侧的高度参加计算，同时左侧的inward移动
*/
