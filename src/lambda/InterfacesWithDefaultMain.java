package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

interface A{
  default public void display(){
    System.out.println("A::display");
  }
  default public void execute(){
    System.out.println("A::execute");
  }
}

interface B extends A{
  default public void display(){
    System.out.println("B::display");
  }
}

interface C {
  default public void execute(){
    System.out.println("C::execute");
  }
}

class X {
  public void display(){
    System.out.println("X::display");
  }
}

class Y extends X implements B, C{
  public void execute(){
    System.out.println("Y::execute");
    C.super.execute();
  }
}

public class InterfacesWithDefaultMain {

  public static void main(String[] args) {
  
      Y y = new Y();
      y.display();
      y.execute();
  }

}
