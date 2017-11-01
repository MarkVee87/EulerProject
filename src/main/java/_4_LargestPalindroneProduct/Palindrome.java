package _4_LargestPalindroneProduct;

import java.util.Objects;

class Palindrome {

    Palindrome() {
    }

    boolean isPalindrome(int c) {
        int i = String.valueOf(c).length();
        String value = String.valueOf(c);
        int mid = value.length() / 2;

        if (i % 2 == 0) {
            String[] parts = {value.substring(0, mid),value.substring(mid)};
            return checkSides(parts);
        } else {
            String[] parts = {value.substring(0, mid + 1),value.substring(mid)};
            return checkSides(parts);
        }
    }

    private boolean checkSides(String[] parts){
        return Objects.equals(parts[0], new StringBuilder(parts[1]).reverse().toString());
    }

}
