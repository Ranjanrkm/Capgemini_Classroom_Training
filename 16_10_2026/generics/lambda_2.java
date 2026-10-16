/*
Problem Statement:
    Calculate the square of a number and then double the result.

Input:
    5

Output:
    Square: 25
    Square and doubled: 50
*/

import java.util.function.Function;

public class lambda_2 {
    public static void main(String[] args) {

        // Function 1: Calculate square
        Function<Integer, Integer> square = n -> n * n;

        // Function 2: Double the number
        Function<Integer, Integer> doubleNumber = n -> n * 2;

        // Chain both functions
        Function<Integer, Integer> result =
                square.andThen(doubleNumber);

        // Display results
        System.out.println("Square: " + square.apply(5));
        System.out.println("Square and doubled: " + result.apply(5));
    }
}