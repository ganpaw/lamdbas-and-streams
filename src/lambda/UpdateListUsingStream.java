package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class UpdateListUsingStream {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
    
    
    // Bad way
    List<Integer> doubleOfEven = new ArrayList<Integer>();
    numbers.stream()
           .filter(number -> number % 2 == 0)
           .map(number -> number * 2)
           .forEach(number -> doubleOfEven.add(number));
    
    System.out.println(doubleOfEven);
    
    // mutability is OK, sharing is nice, shared mutability is devils work
    // because it creates race conditions...
    
    // Good way
    List<Integer> doubleOfEven2 = 
        numbers.stream()
               .filter(number -> number % 2 ==0)
               .map(number -> number * 2)
               .collect(toList());// special reduce 
    
    System.out.println(doubleOfEven2);

    // let us say we need a set (remove duplicates)
    Set<Integer> set1 = 
        numbers.stream()
               .filter(number -> number % 2 ==0)
               .map(number -> number * 2)
               .collect(toSet());// special reduce 
    
    System.out.println(set1);

    
    // Create map ==========================================
    List<Person> persons = Arrays.asList(
            new Person("Pawan", Gender.MALE, 38),
            new Person("Ranbir", Gender.MALE, 6),
            new Person("Preeti", Gender.FEMALE, 36),
            new Person("Raavi",Gender.FEMALE, 0)
        );
    
    Map<String, Person> mapOfPersons = 
        persons.stream()
               .collect(toMap(
                   Person::getName ,
                   person -> person
                   ));
    

    System.out.println(mapOfPersons);
    
    
    // GroupBy ==========================================
    List<Person> people = Arrays.asList(
        new Person("Pawan", Gender.MALE, 39),
        new Person("Manav", Gender.FEMALE, 35),
        new Person("Aana", Gender.FEMALE, 36),
        new Person("Joji",Gender.MALE, 34),
        new Person("Pawan", Gender.FEMALE, 58)
    );

    // Given a list of people, create a map where their name is key and value is all the persons with that name
    System.out.println(
        people.stream()
              .collect(groupingBy(Person::getName)));
    
    
    // Given a list of people, create a map where their name is key and value is all the ages with that name        
    System.out.println(
        people.stream()
              .collect(groupingBy(Person::getName, 
                  mapping(Person::getAge , toList()))));
    
    
  }
}
enum Gender { MALE, FEMALE}

class Person {
  private String name;
  private Gender gender;
  private int age;
  
  Person(String name, Gender gender, int age){
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
}