package com.softvision.programmingPractice;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysExercises {

    /*** 1. Write a Java program to sort a numeric array & a string array. Check and use available Arrays methods. ***/
    public static int[] sortPrimitiveArray(int[] array) {

        return Arrays.stream(array).sorted().toArray();

    }

    public static String[] sortStringArray(String[] array) {

        return Arrays.stream(array).sorted().toArray(String[]::new);
    }

    /*** 2. Write a Java program to find the common elements between two arrays (string values). Use two for loops to
    cover every element in the arrays. ***/
    public static void findCommonElements(String[] array1, String[] array2) {

        int i, j;
        LinkedList<String> commonElements = new LinkedList<>();

        for (i = 0; i < array1.length; ++i) {
            for (j = 0; j < array2.length; ++j) {
                if (array1[i].equals(array2[j])) {
                    commonElements.add(array1[i]);
                }
            }
        }

        commonElements.stream().distinct().forEach(System.out::println);
    }

     /*** 3. Write a Java program to convert an array to ArrayList. ***/
    public static ArrayList<Integer> convertToArrayList (int[] array) {
        return IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    /*** 4. Write a Java program to iterate through all elements in a array list and print them. ***/
    public static void printArrayList(ArrayList<?> arrayList) {

        for (var i : arrayList) {
            System.out.println(i);
        }
    }

    /*** 5. Write a Java program to reverse elements in an array list. Check available methods in Collections
     class. ***/
    public static void reverseArrayList(ArrayList<Integer> arrayList) {
        Collections.reverse(arrayList);
    }

    /*** 6. Write a Java program to empty an array list and write another program to test if the array list
     is empty. ***/
    public static void emptyArrayList(ArrayList<Integer> arrayList) {
        arrayList.clear();
    }

    public static boolean isArrayListEmpty(ArrayList<Integer> arrayList) {
        return arrayList.isEmpty();
    }

    /*** 7. First, generate 10 1-100 random numbers, then put them in an array. Put the numbers from the array greater
     than or equal to 10 into a list collection and print them to the console. ***/
    public static int[] generateRandomNumbers (int number, int lowBoundary, int highBoundary) {

        int i;
        int[] randomArray = new int[number];
        Random random = new Random();

        for (i = 0; i < number; ++i) {
            randomArray[i] = random.nextInt(highBoundary - lowBoundary) + lowBoundary;
        }

        return randomArray;
    }

    public static ArrayList<Integer> keepIfOnlyGreaterOrEqualThan(int[] array, int number) {
        return convertToArrayList(array).stream().filter(x -> x >= number).collect(Collectors
                                        .toCollection(ArrayList::new));
    }

    /*** 8. Write a application that allows the user to enter up to 20 integer grades into an array. Stop the loop by
     typing in ‐1. Your main method should call an Average method that returns the average of the grades. Use the
     DecimalFormat class to format the average to 2 decimal places. ***/
    public static ArrayList<Integer> readGrades() {

        ArrayList<Integer> grades = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int grade, gradesCount = 1;

        do {

            System.out.printf("Enter grade %d: ", gradesCount);
            grade = input.nextInt();

            if (grade == -1) {
                break;
            } else if (grade < 1 || grade > 10) {
                System.out.println("Invalid grade. It will not be taken into account.");
            } else {
                gradesCount++;
                grades.add(grade);
            }

        } while (gradesCount <= 20);

        return grades;
    }

    public static double arrayListAverage (ArrayList<Integer> arrayList) {
        return arrayList.stream().mapToInt(i -> i).average().orElse(0.0);
    }

    public static String formatWithTwoDecimals(double number) {
        String pattern = "##.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return decimalFormat.format(number);
    }

    /*** 9. Write a function that takes an arbitrary number of integers as arguments and returns a collection of them
     stored in reverse order. ***/
    public static  ArrayList<Integer> buildList(int... values) {

        int i;

        ArrayList<Integer> arrayList = new ArrayList<>(values.length);
        for (i = 0; i < values.length; ++i) {
            arrayList.add(i, values[i]);
        }

        Collections.reverse(arrayList);

        return  arrayList;
    }

    /*** 10. Write a Java program to swap every two adjacent nodes of a given linked list.
     Original Linked list: 10->20->30->40->50
     Expected Output: 20->10->40->30->50 ***/
    public static LinkedList<Integer> swapEveryTwoElements(LinkedList<Integer> list) {

        Integer aux;
        int i;

        for (i = 0; i < list.size() - 1; i+=2) {
            aux = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, aux);
        }

        return list;
    }

    /*** 11. Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
     the nodes of the first two lists.
     Input: 1->2->4  |  1->3->4
     Output: 1->1->2->3->4->4 ***/
    public static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        LinkedList<Integer> mergedList = new LinkedList<>();

        int index1 = 0, index2 = 0;
        Integer head1, head2;

        while (index1 < list1.size() && index2 < list2.size()) {
            head1 = list1.get(index1);
            head2 = list2.get(index2);
             if (head1 <= head2) {
                 mergedList.add(head1);
                 index1++;
             } else {
                 mergedList.add(head2);
                 index2++;
             }
        }

        if (index1 == list1.size()) {
            mergedList.addAll(list2.subList(index2, list2.size()));
        } else {
            mergedList.addAll(list1.subList(index1, list1.size()));
        }

        return  mergedList;
    }

    /*** 12. Make a Map that associates the following employee IDs with names. The point here is to associate keys
     with values, then retrieve values later based on keys. Test several valid and invalid ID’s and print the
     associated name. ***/
    public static void mapDemonstration() {

        HashMap<String, String> persons = new HashMap<>();
        // it would have been better to read the data from a file
        persons.put("a1234", "Adrian");
        persons.put("b4321", "Vlad");
        persons.put("c3241", "Mihai");
        persons.put("d1432", "Calin");
        persons.put("e2431", "Iulian");
        System.out.printf("Retrieve value using valid key: %s\n", persons.get("a1234"));
        System.out.printf("Retrieve value using valid key: %s\n", persons.get("e2431"));
        System.out.printf("Retrieve value using valid key: %s\n", persons.get("c3241"));
        System.out.printf("Retrieve value using invalid key: %s\n", persons.get("invalid_key"));
        System.out.printf("Retrieve value using invalid key: %s\n", persons.get("c 3241"));
        System.out.printf("Retrieve value using invalid key: %s\n", persons.get("C3241"));
    }

     /* others */

    public static void printPrimitiveArray (int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
