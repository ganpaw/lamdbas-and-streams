package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ImerativeToDeclarativeStyle {

  public static void main(String[] args) {
    
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    
    //list.forEach(System.out::println);
    
    // Stream is a fancy iterator and provides number of useful functions
    // 1. map

        list.parallelStream()
        .map(e -> e+1)        
        .forEach(System.out::println);
    
  }

}
