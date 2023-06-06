public class P1342NumberOfStepstoReduceTo0 {
    public int numberOfSteps(int num){
        int count=0;
        while(num!=0){
           if(num%2==0){
               num/=2;
           }
           else{
               num--;
           }
           count++;
        }
        return count;
    }
    public int numberOfsteps1(int num){//RECURSION METHOD
        if(num==0)return 0;
        else if(num%2==0){
            return(numberOfsteps(num/2)+1);
        }
        else{
            return numberOfsteps(num-1)+1;
        }
    }
    public int numberOfSteps1(int num) {
        int step = 0;
       while (num != 0) {
           step++;
           if ((num & 1) == 1) {
               num--;
           }
           else {
               num = num >> 1;//相当于除以2
           }
       }
        
        return step;
    }
    public int numberOfsteps(int num){
        int step=0;
        while(num!=0){
            if((num&1)==0){
               num=num>>1;
            }
            else{
                num--;
            }
            step++;
        }
        return step;
    }
}
