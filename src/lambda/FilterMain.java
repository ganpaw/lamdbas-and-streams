package lambda;

import java.util.Arrays;
import java.util.List;

public class FilterMain {

  public static boolean isEven(int number){
    return number % 2 == 0;
  }
  public static void main(String[] args) {

      List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
      
     int result = numbers.stream()
             .filter(number -> number >5)
             //.filter(number -> isEven(number)) // or below way of static method reference
             .filter(FilterMain::isEven)
             .filter(number -> number < 9)
             .filter(number -> number * 2 > 15)
             .findFirst()
             .get();
     
     System.out.println(result);
     
     
     int result2 = numbers.stream()
         .filter(FilterMain::isEven)
         .map(number -> number * 2)
         .reduce(0, (carry, number) -> carry + number);
     
     System.out.println(result2);

     int result1 = numbers.stream()
         .filter(number -> number % 2 == 0)
         .mapToInt(number -> number *2)
         .sum(); // specialized reduce operation

     System.out.println(result1);

  }

}
