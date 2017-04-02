package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPatternMain {

  public static int totalValue(List<Integer> values, Predicate<Integer> selector){
    int total=0;
    
    for (int e: values){
      if (selector.test(e)) total+=e;
    }
    return total;
  }
  
  /**
   * Passing Lambda expression as Predicate
   * @param values
   * @param predicate
   * @return
   */
  public static int betterTotalValue(List<Integer> values, Predicate<Integer> predicate){

    return values.stream()
                 .filter(predicate)
                 .reduce(0, (c,e) -> c+e);
  }
  
  
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    
    
    System.out.println(betterTotalValue(list, e -> true));
    System.out.println(betterTotalValue(list, e -> e%2 == 0));
    System.out.println(betterTotalValue(list, e -> e%2 != 0));
    
  }

}
