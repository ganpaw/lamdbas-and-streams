package lambda;

import java.util.stream.Stream;

public class InfinteStreamMain {

  public static int compute (int k, int n){
    int result = 0 ;
    
    int index = k;
    int count = 0;
    
    while (count < n){
      if (index%2 == 0 && Math.sqrt(index) > 20){
        result += index *2;
        count++;
      }
      index++;
    }
    
    
    return result;
  }
  
  public static int computeUsingStreams (int k, int n){
    return Stream.iterate(k,  e-> e+1)      // unbound, lazy
                 .filter(e -> e%2 ==0)      // unbound, lazy
                 .filter(e -> Math.sqrt(e) > 20) // unbound, lazy (return Stream)
                 .mapToInt(e -> e*2) // unbound, lazy (return IntStream)
                 .limit(n) // sized/bounded, lazy (return IntStream)
                 .sum();    // eager - comes at the end, say lets get the work done... (returns int)
    
    // Look for return type of function if it is lazy or eager... 
  }
  public static void main(String[] args) {

      
     // System.out.println(Stream.iterate(100, e -> e+1));
      // output : java.util.stream.ReferencePipeline$Head@548c4f57
    
      // Given a number k, and a count n, find the total of double of n 
      // even number starting with k, where sqrt of each number is > 20
      
      int k = 121;
      int n = 51;
      System.out.println(compute(k, n));
      
      System.out.println(computeUsingStreams(k, n));
  }
  

}
