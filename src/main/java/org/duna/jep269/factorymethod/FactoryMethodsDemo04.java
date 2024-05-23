package org.duna.jep269.factorymethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FactoryMethodsDemo04 {
  public static void main(String[] args) {
    List<String> wordList = Arrays.asList("Patricia", "Carlos", "Consuelo", "Ulises", "Irene");
    Map<Character, List<String>> wordForCharacter = wordList.stream()
      .collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.toList()));
    System.out.println(wordForCharacter);
  }
}
