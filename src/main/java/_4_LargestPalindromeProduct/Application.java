package _4_LargestPalindromeProduct;

/*
A palindromic number reads the same both ways. The largest Palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest Palindrome made from the product of two 3-digit numbers.

906609
*/

public class Application {

    public static void main(String[] args) {

        int count = 0;
        int highestCurrentPalindrome = 0;

        int a, b, c;
        Palindrome palindrome = new Palindrome();

        for (a = 100; a < 1000; a++) {
            for (b = 100; b < 1000; b++) {
                c = a * b;
                if (palindrome.isPalindrome(c)) {
                    System.out.println(c);
                    if(c > highestCurrentPalindrome){
                        highestCurrentPalindrome = c;
                    }
                    count++;
                }
            }
        }
        System.out.println(count + " palindromes found");
        System.out.println(highestCurrentPalindrome + " is the highest palindrome using the product of two three-digit numbers");
    }
}