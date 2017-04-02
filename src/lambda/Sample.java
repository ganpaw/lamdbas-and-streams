package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Sample {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    
//    for (int e: list){
//      System.out.println(e);
//    }
    
      // Generates a new class
//      list.forEach(new Consumer<Integer>(){
//        @Override
//        public void accept(Integer value) {
//          System.out.println(value);
//          
//        }
//      });
      

//      list.forEach((Integer value) -> System.out.println(value));
    
//      list.forEach((value) -> System.out.print(value+","));
      
//        list.forEach(value -> System.out.print(value+","));
    
        list.forEach(System.out::println);
        
//        List<Integer> cloneList = new ArrayList<Integer>();
//        list.forEach(cloneList::add);
//        cloneList.forEach(System.out::println);
  }

}
