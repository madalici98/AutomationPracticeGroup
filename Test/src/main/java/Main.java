import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

import static com.softvision.automationPractice.ArraysExercises.*;

public class Main {

    public static void main(String[] args) {

        //checkOddEven(10);
        //sumAverageInt(101);
        //System.out.println(hasAllUniqueChars("oaie1233"));
        //sumProductMinMax();
        //System.out.println(reverseInteger());

//        int[] array = IntStream.of(1, 2, 3, 4, 5, 6, 6, 7, 8).toArray();
//        int[] newArray = removeOccurence(array, 6);
//        for (int i: newArray) {
//            System.out.println(i);
//        }

//        int[] array = IntStream.of(1, 2, 3, 4, 5, 6, 6, 7, 8).toArray();
//        System.out.println(averageWithoutMinMax(array));

//        int[] array = IntStream.of(1, 2, 3, 4, 5, 6, 6, 7, 8).toArray();
//        int[] newArray = addArrayElementOnPosition(array, 7, 66);
//        for (int i: newArray) {
//            System.out.println(i);
//        }

//        int[] array = IntStream.of(4, 3, 2, 1, 0).toArray();
//        int[] newArray = bubbleSort(array);
//        for (int i: newArray) {
//            System.out.println(i);
//        }

        //countVowelsDigits();

        /*********************************** Arrays ********************************************/

        int[] primitiveArray = IntStream.of(4, 3, 2, 1, 0).toArray();

        // 1
//        int[] sortedArray = sortPrimitiveArray(primitiveArray);
//        printPrimitiveArray(sortedArray);
//
//        String[] stringArray = new String[] {"zebra", "banan", "banana", "Ana", "an", "112"};
//        String[] sortedStringArray = sortStringArray(stringArray);
//        for (String s: sortedStringArray) {
//            System.out.println(s);
//        }

        // 2
//        String[] stringArray1 = new String[] {"zebra", "banan", "banana", "Ana", "an", "112", "112"};
//        String[] stringArray2 = new String[] {"common", "uncommon", "banana", "break", "screen", "112"};
//        findCommonElements(stringArray1, stringArray2);

        // 3
//        System.out.println(primitiveArray.getClass());
//        ArrayList<Integer> arrayList = convertToArrayList(primitiveArray);
//        System.out.println(arrayList.getClass());

        // 4, 5
//        reverseArrayList(arrayList);
//        printArrayList(arrayList);


        // 6
//        emptyArrayList(arrayList);
//        System.out.println(isArrayListEmpty(arrayList));

        // 7
//        int[] randomNumbers = generateRandomNumbers(10, 1, 100);
//        printPrimitiveArray(randomNumbers);
//        ArrayList<Integer> filteredNumbers = keepIfOnlyGreaterOrEqualThan(randomNumbers, 10);
//        printArrayList(filteredNumbers);

        // 8
//        ArrayList<Integer> grades = readGrades();
//        System.out.printf("The grade average is %s", formatWithTwoDecimals(arrayListAverage(grades)));

        // 9
//        arrayList = buildList(7,4,4,4,4,4,4,4,5,6,7,8);
//        printArrayList(arrayList);

        // 10
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(3);
        list2.add(6);
        list2.add(7);

        LinkedList<Integer> linkedList = swapEveryTwoElements(list2);
        Iterator<Integer> listIterator = linkedList.iterator();
        listIterator.forEachRemaining(x -> System.out.println(x));

        // 11
//        LinkedList<Integer> linkedList = mergeSortedLists(list1, list2);
//        Iterator<Integer> listIterator = linkedList.iterator();
//        listIterator.forEachRemaining(x -> System.out.println(x));

        // 12
//        mapDemonstration();

    }
}
