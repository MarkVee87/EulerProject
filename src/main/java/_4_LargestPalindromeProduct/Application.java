package _4_LargestPalindromeProduct;

/*
A palindromic number reads the same both ways. The largest Palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest Palindrome made from the product of two 3-digit numbers.

906609
*/

import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {

        yeOldeJava();

        java8Stream();
    }

    private static void yeOldeJava(){
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
        System.out.println(count + " palindromes found");
        System.out.println(highestCurrentPalindrome + " is the highest palindrome using the product of two three-digit numbers");
    }

    private static void java8Stream(){
        final int[] count = {0};
        final int[] highestCurrentPalindrome = {0};

        Palindrome palindrome = new Palindrome();

        IntStream.rangeClosed(100, 999)
                .forEach(x -> IntStream.rangeClosed(100, 999)
                        .forEach(
                                p -> {
                                    final int c = x * p;
                                    if (palindrome.isPalindrome(c)) {
                                        System.out.println(c);
                                        if (c > highestCurrentPalindrome[0]) {
                                            highestCurrentPalindrome[0] = c;
                                        }
                                        count[0]++;
                                    }
                                }));

        System.out.println(count[0] + " palindromes found");
        System.out.println(highestCurrentPalindrome[0] + " is the highest palindrome using the product of two three-digit numbers");
    }
}