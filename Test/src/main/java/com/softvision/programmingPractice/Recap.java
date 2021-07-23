package com.softvision.programmingPractice;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Recap {
    /*
    - Write a program called CheckOddEven which prints "Odd Number" if the int variable “number” is odd, or “Even Number”
    otherwise. The program shall always print “bye!” before exiting.

    - Write a program called SumAverageInt to produce the sum of 1, 2, 3, ..., to 100. Also compute and display the
    average.

    - Write a program to check if a given string has all unique characters. Return the result as a boolean value.

    - Write a program called SumProductMinMax that prompts user for three integers. The program shall read the inputs as
    int; compute the sum, product, minimum and maximum of the three integers; and print the results.

    - Write a program that prompts user for a positive integer. The program shall read the input as int; and print the
    "reverse" of the input integer. (input: 12345 reverse: 54321)

    - Write a program called CountVowelsDigits, which prompts the user for a String, counts the number of vowels
    (a, e, i, o, u, A, E, I, O, U) and digits (0-9) contained in the string, and prints the counts.

    - Write a program to insert an element (specific position) into an array.

    - Write a program to remove all occurrences of a specified value in a given array of integers and return the new
    array. There can be duplicates in the array.

    - Write a program to sort an array of given integers using the Bubble sorting Algorithm. The principle of bubble
    sort is to scan the elements from left-to-right, and whenever two adjacent elements are out-of-order, they are
    swapped.

    - Write a program to compute the average value of an array of integers except the largest and smallest values.

Deadline: Wednesday June 9, 12:00
*/

    public static void checkOddEven(int number) {

        if (number % 2 == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }

        System.out.println("bye!");
    }

    // I did not wanted to hardcode the method for maxNumber == 100
    public static void sumAverageInt(int maxNumber) {

        // compute the sum 1 + 2 + ... + maxNumber
        System.out.println(maxNumber * (maxNumber + 1) / 2);
        System.out.println((double) maxNumber / 2);
    }

    public static boolean hasAllUniqueChars(String s) {

        return s.length() == s.chars().asDoubleStream().distinct().count();
    }

    public static void sumProductMinMax() {

        int first, second, third;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        first = input.nextInt();

        System.out.println("Enter the second number: ");
        second = input.nextInt();

        System.out.println("Enter the third number: ");
        third = input.nextInt();

        System.out.printf("The sum: %d\n", first + second + third);
        System.out.printf("The product: %d\n", first * second * third);
        System.out.printf("Minimum: %d\n", Math.min(Math.min(first, second), third));
        System.out.printf("Maximum: %d\n", Math.max(Math.max(first, second), third));
    }

    public static int reverseInteger() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = input.nextInt();

        int reversed = 0;
        int numberCopy = number;
        int tens = 1;

        while (numberCopy > 0) {
            tens *= 10;
            numberCopy = numberCopy / 10;
        }

        tens /= 10;

        while (number > 0) {
            reversed += (number % 10) * tens;
            tens /= 10;
            number /= 10;
        }

        return reversed;
    }

    public static int[] removeOccurence(int[] array, int toEliminate) {

        return Arrays.stream(array).filter(i -> i != toEliminate).toArray();
    }

    public static void countVowelsDigits() {

        Scanner input = new Scanner(System.in);
        System.out.println("Write your string: ");
        String s = input.nextLine().toLowerCase(Locale.ROOT);

        int vowels = 0;
        int digits = 0;
        String allVowels = "aeiou";

        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                digits++;
            } else if (allVowels.contains("" + s.charAt(i))) {
                vowels++;
            }
        }

        System.out.printf("Number of vowels: %d\n", vowels);
        System.out.printf("Number of digits: %d\n", digits);

    }

    public static int[] addArrayElementOnPosition(int[] array, int position, int value) {

        int i, arrayLength = array.length;
        if (position > arrayLength || position < 0) {
            System.out.println("Invalid position");
            return array;
        }

        int[] newArray = new int[arrayLength + 1];

        for (i = 0; i < position; ++i) {
            newArray[i] = array[i];
        }

        newArray[position] = value;

        for (i = position + 1; i < newArray.length; ++i) {
            newArray[i] = array[i - 1];
        }

        return newArray;
    }

    public static double averageWithoutMinMax(int[] array) {

        int max = array[0];
        int min = array[0];
        int sum = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }

            sum += array[i];
        }

        System.out.println(min);
        System.out.println(max);


        return ((double) sum - min - max) / (array.length - 2);
    }

    public static int[] bubbleSort(int[] array) {

        int i, aux;
        boolean swapped;

        do {
            swapped = false;
            for (i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    swapped = true;
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                }
            }

        } while (swapped);

        return array;
    }
}
