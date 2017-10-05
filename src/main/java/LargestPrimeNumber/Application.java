package LargestPrimeNumber;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

itself and one
*/


import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        long number = 600851475143L;

        System.out.println("Primefactors of " + number);
        for (Integer integer : primeFactors(number)) {
            System.out.println(integer);
        }
    }

    private static List<Integer> primeFactors(long number) {
        long n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}