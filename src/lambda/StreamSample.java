package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamSample {

  
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,3,5,8,2,10);
     
//    System.out.println(
//        list.stream()
//            .filter(e -> e > 3)
//            .filter(e -> e%2 == 0)
//            .map(e -> e*2)
//            .findFirst()
//        );
//    
    System.out.println(list.stream()
            .map(e -> e*2)
            .toArray()
        );
  }

}
