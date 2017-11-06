package _1_Multiples3and5;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

233168
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

    private static long oldJava8Duration;
    private static long java8Duration;

    public static void main(String[] args) {
        yeOldeJava();
        java8Stream();
        findFastest();
    }

    private static void java8Stream() {
        long start = System.currentTimeMillis();

        List<Integer> integers = new ArrayList<>();
        int limit = 1000;

        IntStream.range(1, limit).forEach(value -> {
            if ((value % 3) == 0 || (value % 5 == 0)) {
                integers.add(value);
            }
        });

        int j = integers.stream().mapToInt(i -> i).sum();
        System.out.println(j);
        long end = System.currentTimeMillis();
        java8Duration = end - start;
    }

    private static void yeOldeJava() {
        long start = System.currentTimeMillis();

        List<Integer> integers = new ArrayList<>();
        int limit = 1000;
        for (int value = 1; value < limit; value++) {
            if ((value % 3) == 0 || (value % 5) == 0) {
                integers.add(value);
            }
        }
        int j = integers.stream().mapToInt(i -> i).sum();
        System.out.println(j);
        long end = System.currentTimeMillis();
        oldJava8Duration = end - start;
    }

    private static void findFastest() {

        System.out.println("\n" + "Pre-Java8 time (ms): " + oldJava8Duration);
        System.out.println("Java8 time (ms) " + java8Duration);
        long diff, percentDiff;

        if (oldJava8Duration > java8Duration) {
            diff = oldJava8Duration - java8Duration;
            percentDiff = (long) ((float) oldJava8Duration / java8Duration) * 100;
            System.out.println("Java8 method was faster by " + diff + "ms, " + percentDiff + "%");
        } else {
            diff = java8Duration - oldJava8Duration;
            percentDiff = (long) (((float) java8Duration / oldJava8Duration) * 100);
            System.out.println("Pre-Java8 method was faster by " + diff + "ms, " + percentDiff + "%");
        }
    }
}