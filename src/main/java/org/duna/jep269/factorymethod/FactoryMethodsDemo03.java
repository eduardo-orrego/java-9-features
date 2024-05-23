package org.duna.jep269.factorymethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Product {
  String name;
  double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

}

public class FactoryMethodsDemo03 {
  public static void main(String[] args) {
    List<Product> productList = Arrays.asList(
      new Product("smartphone", 555.00),
      new Product("tablet", 777.00),
      new Product("laptop", 999.00)
    );

    BinaryOperator<Double> sumPrices = Double::sum;
    Map<String, Double> totalPricesMap = productList.stream()
      .collect(Collectors.toMap(Product::getName, Product::getPrice, sumPrices));
    System.out.println(totalPricesMap);
  }
}
