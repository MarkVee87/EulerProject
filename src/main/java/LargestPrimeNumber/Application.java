package LargestPrimeNumber;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

itself and one
*/

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Application {

    public static void main(String[] args) {

        long number = 600851475143L;

        System.out.println("Primefactors of " + number + " are:");
        List<Long> list = primeFactors(number);
        list.forEach(System.out::println);
    }

    private static List<Long> primeFactors(long number) {

//         List<Long> factors = new ArrayList<>();
//         for (long i = 2; i <= number; i++) {
//             while (number % i == 0) {
//                 factors.add(i);
//                 number /= i;
//             }
//         }
//        return factors;


        List<Long> factors;
        factors = LongStream.range(2, number)
                .boxed()
                .filter(x -> number % x == 0)
                .collect(Collectors.toList());
        return factors;
    }


}