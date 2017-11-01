package _4_LargestPalindroneProduct;

/*
A palindromic number reads the same both ways. The largest Palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest Palindrome made from the product of two 3-digit numbers.
*/

import org.junit.Test;

public class Application {

    public static void main(String[] args) {

        long a, b;
        Palindrome palindrome = new Palindrome();

        for (a = 111; a < 1000L; a++) {
            for (b = 111; b < 1000L; b++) {
                long c = a * b;
                if (palindrome.isPalindrome(c)) {
                    System.out.println(c);
                }
            }
        }
    }

    @Test
    public void palindromeTest(){
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome(1234);
        palindrome.isPalindrome(12342);
        palindrome.isPalindrome(12321);
        palindrome.isPalindrome(1221);
    }
}