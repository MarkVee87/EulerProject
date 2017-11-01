package _4_LargestPalindroneProduct;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void palindromeTest(){
        Palindrome palindrome = new Palindrome();

        Assert.assertEquals(false, palindrome.isPalindrome(1234));
        Assert.assertEquals(false, palindrome.isPalindrome(12342));
        Assert.assertEquals(true, palindrome.isPalindrome(12321));
        Assert.assertEquals(true, palindrome.isPalindrome(1221));
    }
}
