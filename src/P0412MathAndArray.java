import java.util.ArrayList;
import java.util.List;

public class P0412MathAndArray {
    public List<String> fizzBuzz(int n){
        ArrayList<String> list=new ArrayList<>(n);//指定长度
        for(int i=1;i<=n;i++){
           if(i%3==0&&i%5==0){
               list.add("FizzBuzz");
           }
           else if(i%3==0){
               list.add("Fizz");
           }
           else if(i%5==0){
               list.add("Buzz");
           }
           else{
               list.add(Integer.toString(i));
           }
        }
        return list;
    }
}/*
       P0412MathAndArray p412=new P0412MathAndArray();
        System.out.println(p412.fizzBuzz(3));
*/
