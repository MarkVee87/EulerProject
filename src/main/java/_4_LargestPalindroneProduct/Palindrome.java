package _4_LargestPalindroneProduct;

import java.util.Objects;

class Palindrome {

    Palindrome() {
    }

    boolean isPalindrome(long c) {

        int i = String.valueOf(c).length();
        String value = String.valueOf(c);
        String splitter;
        String[] split;

        if (i % 2 == 0) {
            int mid = value.length() / 2;
            String[] parts = {value.substring(0, mid),value.substring(mid)};
            return checkSides(parts, c);
        } else {
            splitter = String.valueOf(value.charAt(i / 2));
            split = value.split(splitter);
            return checkSides(split, c);
        }
    }

    private boolean checkSides(String[] parts, long c){
        if (Objects.equals(parts[0], new StringBuilder(parts[1]).reverse().toString())) {
            System.out.println(c + " is a Palindrome");
            return true;
        } else {
            System.out.println(c + " is not a Palindrome");
            return false;
        }
    }

}
