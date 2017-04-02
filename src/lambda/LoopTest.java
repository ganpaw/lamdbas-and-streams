package lambda;

import java.util.stream.IntStream;

public class LoopTest {

  public static void main(String[] args) {

    IntStream.rangeClosed(0, 100)
             .forEach(System.out::println);
  }

}
