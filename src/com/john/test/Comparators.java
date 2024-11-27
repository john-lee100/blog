package com.john.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.john.model.bo.CommonCity;

public class Comparators {
  public static void main(String[] args) {
    eventSort();
    doubleSort();
  }

  public static void eventSort() {
    List<CommonCity> city = Arrays.asList(new CommonCity(100), new CommonCity(102), new CommonCity(70));
    city.sort(Comparator.comparing(CommonCity::getId).reversed());
    city.stream().sorted(Comparator.comparingInt(CommonCity::getId).reversed());
  }

  public static void doubleSort() {
    List<Double> dou = Arrays.asList(7d, 2d, 5d, 6d, 9d);
    Collections.sort(dou, Collections.reverseOrder());
    Collections.sort(dou, new Comparator<Double>() {
      public int compare(Double o1, Double o2) {
        return Double.compare(o2, o1);
      }
    });
  }

}
