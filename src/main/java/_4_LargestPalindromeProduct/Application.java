package _4_LargestPalindromeProduct;

/*
A palindromic number reads the same both ways. The largest Palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest Palindrome made from the product of two 3-digit numbers.

906609
*/

import java.util.stream.IntStream;

public class Application {

    private static long oldJava8Duration;
    private static long java8Duration;

    public static void main(String[] args) {
        java8Stream();
        yeOldeJava();
        findFastest();
    }

    private static void java8Stream() {
        long start = System.currentTimeMillis();
        final int[] count = {0};
        final int[] highestCurrentPalindrome = {0};

        Palindrome palindrome = new Palindrome();

        IntStream.rangeClosed(100, 999).parallel()
                .forEach(x -> IntStream.rangeClosed(100, 999).parallel()
                        .forEach(p -> {
                            final int c = x * p;
                            if (palindrome.isPalindrome(c)) {
                                System.out.println(c);
                                if (c > highestCurrentPalindrome[0]) {
                                    highestCurrentPalindrome[0] = c;
                                }
                                count[0]++;
                            }
                        }));

        long end = System.currentTimeMillis();
        java8Duration = end - start;

        System.out.println("\n" + count[0] + " palindromes found");
        System.out.println(highestCurrentPalindrome[0] + " is the highest palindrome using the product of two three-digit numbers");
    }

    private static void yeOldeJava() {
        long start = System.currentTimeMillis();
        int a, b;
        int highestCurrentPalindrome = 0;
        int count = 0;
        Palindrome palindrome = new Palindrome();

        for (a = 100; a < 1000; a++) {
            for (b = 100; b < 1000; b++) {
                int c = a * b;
                if (palindrome.isPalindrome(c)) {
                    System.out.println(c);
                    if (c > highestCurrentPalindrome) {
                        highestCurrentPalindrome = c;
                    }
                    count++;
                }
            }
        }

        long end = System.currentTimeMillis();
        oldJava8Duration = end - start;

        System.out.println("\n" + count + " palindromes found");
        System.out.println(highestCurrentPalindrome + " is the highest palindrome using the product of two three-digit numbers");
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