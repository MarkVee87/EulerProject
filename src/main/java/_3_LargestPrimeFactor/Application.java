package _3_LargestPrimeFactor;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

answer: 6857
*/

import java.util.stream.LongStream;

public class Application {

    public static void main(String[] args) {
        long number = 600851475143L;
//        System.out.println("Largest prime factor of " + number + " is: " + yeOldeJava(number));
        System.out.println("Largest prime factor of " + number + " is: " + primeFactors(number));
//        System.out.println("Largest prime factor of " + number + " is: " + java8Stream(number));
    }

    private static long java8Stream(final long number) {
        final long[] largestPrimeFactor = {0};
        LongStream.range(2, number)
                .filter(value -> number % value == 0)
                .forEach(value -> largestPrimeFactor[0] = value);

        return largestPrimeFactor[0];
    }

    private static Long primeFactors(long n) {

        long highestPrimeFactor = LongStream.range(2, n)
                .filter(i -> n % i == 0)
                .reduce((i, j) -> findHighest(i, j))
                .orElse(0);

        System.out.println(highestPrimeFactor);
        return highestPrimeFactor;
    }

    private static long findHighest(long i, long j) {
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }

    private static long yeOldeJava(long number) {
        long largestPrimeFactor = 0;
        for (long i = 2; i <= number; i++) {
            while (number % i == 0) {
                largestPrimeFactor = number;
                number /= i;
            }
        }
        return largestPrimeFactor;
    }
}