package DeadLockAndRetry;

import java.net.StandardSocketOptions;
import java.util.Date;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (num) -> {
            boolean b = num%2 ==0;
            return b;
        };

        Predicate<String> isUpperCase = (str) -> {
            for(char c : str.toCharArray()){
                if(c>='A' && c<='Z'){
                    continue;
                }
                else{
                    return false;
                }
            }
            return true;
        };
        System.out.println(isUpperCase.test("ANSH"));
        System.out.println(isUpperCase.test("ansh"));

        Predicate<Integer> isPrime = (num) -> {
            for(int i=2; i<num/2; i++){
                if(num%i==0){
                    return false;
                }
            }
            return true;
        };
        System.out.println(isPrime.test(3));
        System.out.println(isPrime.test(6));

        Predicate<Integer> isPower2 = (num) -> {
           int ans = num & (num-1);
           return ans==0;
        };

        System.out.println(isPower2.test(4));
        System.out.println((isPower2.test(6)));

        Predicate<Integer> isPass = (num)-> {
            if(num>33){
                return true;
            }
            else{
                return false;
            }
        };

        System.out.println(isPass.test(40));
        System.out.println(isPass.test(20));


        Consumer<Double> isPassed = (num) -> {
          if(num<10){
              System.out.println("Extreme Fail");
          }
          else if(num<30){
              System.out.println("Fail");
          }
          else if (num<50) {
              System.out.println("Just Pass");

          }
          else {
              System.out.println("Pass");
          }
        };
        isPassed.accept(43.0);


        Supplier<String> date = () -> {
            Date ans = new Date();
            return (ans.getDate() + "/" + ans.getMonth()+ "/"+ ans.getYear());
        };
        System.out.println(date.get());




    }
}
