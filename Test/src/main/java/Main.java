import com.softvision.programmingPractice.oopPractice.Employee;
import com.softvision.programmingPractice.oopPractice.addressExercise.Address;
import com.softvision.programmingPractice.oopPractice.addressExercise.Person;

import java.util.HashMap;

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

//        int[] primitiveArray = IntStream.of(4, 3, 2, 1, 0).toArray();
//        ArrayList<String> stringArrayList = new ArrayList<>();
//        stringArrayList.add("ana");
//        stringArrayList.add("are");
//        stringArrayList.add("mere");
//        printArrayList(stringArrayList);
//        ArrayList<Double> doubleArrayList = new ArrayList<>();
//        doubleArrayList.add(new Double("200000000000000000"));
//        doubleArrayList.add(new Double("1.123466786544677"));
//        printArrayList(doubleArrayList);

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

//        // 10
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.add(1);
//        list1.add(4);
//        list1.add(5);
//        LinkedList<Integer> list2 = new LinkedList<>();
//        list2.add(2);
//        list2.add(3);
//        list2.add(6);
//        list2.add(7);
//
//        LinkedList<Integer> linkedList = swapEveryTwoElements(list2);
//        Iterator<Integer> listIterator = linkedList.iterator();
//        listIterator.forEachRemaining(x -> System.out.println(x));

        // 11
//        LinkedList<Integer> linkedList = mergeSortedLists(list1, list2);
//        Iterator<Integer> listIterator = linkedList.iterator();
//        listIterator.forEachRemaining(x -> System.out.println(x));

        // 12
//        mapDemonstration();

//        Employee bob = new Employee("Bob", "Smith", 4500.5);
//        Employee alice = new Employee("Alice", "Brown", 6200.0);
//
//        bob.displayYearlySalary();
//        alice.displayYearlySalary();
//
//        bob.applyRaise(10);
//        alice.applyRaise(10);
//
//        bob.displayYearlySalary();
//        alice.displayYearlySalary();

        Address address1 = new Address("Street 1", 1);
        Person person1 = new Person("Bob Smith", 30, address1);

        HashMap<Person, Integer> personHashMap = new HashMap<>();
        personHashMap.put(person1, 1);

        System.out.println(personHashMap.get(person1));

        Person person2 = new Person("Bob Smith", 30, address1);

        personHashMap.put(person2, 2);

        System.out.println(personHashMap.get(person2));

    }
}
