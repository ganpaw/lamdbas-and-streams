package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamPerformanceMain {

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,15);
    
    System.out.println(
        numbers.stream()
               .filter(number -> isGT3(number))
               .filter(number -> isEven(number))
               .map(number -> doubleIt(number))
               .findFirst());
    
    
  }
  
  public static boolean isGT3(int number){
    System.out.println("isGT3 :"+number);
    return number > 3;
  }
  
  public static boolean isEven(int number){
    System.out.println("isEven :"+number);
    return number % 2 ==0;
  }
  
  public static int doubleIt(int number){
    System.out.println("doubleIt :"+number);
    return number * 2;
  }

}
