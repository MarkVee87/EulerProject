package Multiples3and5;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        int limit = 1000;
        for (int i = 1; i < limit; i++) {
            if ((i % 3) == 0 || (i % 5) == 0) {
                integers.add(i);
            }
        }
        int j = integers.stream().mapToInt(i -> i).sum();
        System.out.println(j);
    }
}
