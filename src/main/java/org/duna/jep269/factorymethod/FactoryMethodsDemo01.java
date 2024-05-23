package org.duna.jep269.factorymethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethodsDemo01 {
  public static void main(String[] args) {

    System.out.println("Java 8 - Creating an immutable set of strings");
    Set<String> setNames = new HashSet<>();
    setNames.add("Carlos");
    setNames.add("Eduardo");
    setNames = Collections.unmodifiableSet(setNames);
    System.out.println(setNames);

    System.out.println("Java 9 - Using the of() factory method of the Set interface");
    Set<String> setNames2 = Set.of("Carlos", "Eduardo");
    System.out.println(setNames2);

    System.out.println("Java 8 - Creating an immutable list of strings");
    List<String> listNames = new ArrayList<>();
    listNames.add("Luis");
    listNames.add("Miguel");
    listNames = Collections.unmodifiableList(listNames);
    System.out.println(listNames);

    System.out.println("Java 9 - Using the of() factory method of the Set interface");
    List<String> listNames2 = List.of("Luis", "Miguel");
    System.out.println(listNames2);

    System.out.println("Java 8 - Creating an immutable map");
    Map<Integer, String> mapPerson = new HashMap<>();
    mapPerson.put(43302023, "Patricia");
    mapPerson.put(44236584, "Geraldine");
    mapPerson = Collections.unmodifiableMap(mapPerson);
    System.out.println(mapPerson);

    System.out.println("Java 9 - Using the ofEntries() and Entry() factory methods " +
      "of the Map interface");
    Map<Integer, String> mapPerson2 = Map.ofEntries(
      Map.entry(43302023, "Patricia"),
      Map.entry(44236584, "Geraldine"));
    System.out.println(mapPerson2);

  }
}
