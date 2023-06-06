public class P0278firstBadVersion {
    public int firstBadVersion(int n){
        int left=1;
        //int right=n;
        // while(left<=right){  //最优解是 left<right   right=mid
            //因为n已经是坏版本了，目标是找之前的坏版本，所以左闭右开
        //     int mid=left+(right-left)/2;
        //     if(isBadVersion(mid)){
        //         right=mid-1;
        //     }
        //     else{
        //         left=mid+1;
        //     }
        // }
        return left;
    }
}
//API（Application Programming Interface，应用程序接口）是一些预先定义的接口（如函数、HTTP接口），
//或指软件系统不同组成部分衔接的约定。