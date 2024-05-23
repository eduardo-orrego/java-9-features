package org.duna.jep269.factorymethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
  String name;
  Integer dni;

  public Person(String name, Integer dni) {
    this.name = name;
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public Integer getDni() {
    return dni;
  }

}

public class FactoryMethodsDemo02 {

  public static void main(String[] args) {
    List<Person> personList = Arrays.asList(
      new Person("Carlos", 43568978),
      new Person("Eduardo", 47859658)
    );

    Map<String, Integer> productsMap = personList.stream()
      .collect(Collectors.toMap(Person::getName, Person::getDni));
    System.out.println(productsMap);
  }

}
