package a08_avoid_shared_mutability;

import java.util.*;
import java.util.function.Consumer;
import static java.util.stream.Collectors.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //double the even values and put that into a list.
    
    //wrong way to do this.
    List<Integer> doubleOfEven = new ArrayList<>();

    numbers.stream()
           .filter(e -> e % 2 == 0)
           .map(e -> e * 2)
           .forEach(e -> doubleOfEven.add(e));
    //mutability is OK, sharing is nice, shared mutability is devils work
    
    //friends don't let friends do shared mutation.
    
    System.out.println(doubleOfEven); //Don't do this.
    
    List<Integer> doubleOfEven2 =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .map(e -> e * 2)
             .collect(toList());
    System.out.println(doubleOfEven2);
    
    
    List<Double> doubleList = 
        numbers.stream()
               .filter(value -> value > 2)
               .distinct()
               .map(e -> e*5.2)
               .collect(toList());
    
    doubleList.forEach(System.out::println);
    
    
    Set<String> set = 
        numbers.stream()
               .distinct()
               .filter(value -> value > 2)               
               .map(String::valueOf)
               .collect(toSet());
    
    set.forEach(System.out::println);
               
    
    
  }
}