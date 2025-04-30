package org.example;

import java.lang.reflect.Array;
import java.util.*;

// Me45hu8l
public class Test {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0};
//        System.out.println(findMaxConsecutiveOnes(nums));
//
//        String input = "Me45hu8l63Th4a0k5ar1";
//        separateNumbersAndCharacters(input);
//
//        String input = "M2eh23ul";
//        String output = "MMehhhul";
//        stringManipulation(input);
//
//        int[] arr = {7,6,4,3,1};
//        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = { 1};
//        int[] arr = {2, 4, 1};
//        int[] arr = {12,14,2,1,18};
//        int[] arr = {1,2};
//        findMaxProfit(arr);
//
//        System.out.println(cheNumberIsPrime());
//
//        findFactorialNumber();
//
//        System.out.println(checkForPalindrome());
//
//        fibonacci();
//
//        largestAndSmallestInArray();
//        findVowelInString();
//        swapNumbers();
//        sortAnArray();
//        removeDuplicates();
//        secondLargestElement();
//        reverseString();
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        // Sum of all numbers using reduce()
//        int sum = numbers.stream()
//                .reduce(0, (a, b) -> a + b);
//        System.out.println(sum);
//
//        findFirstNonRepeatingCHar();
//        findFirstRepeatingChar();
//        removeDuplicateCharacter();
//
//        System.out.println(anagramOrNot());
//        mostFrequencyInString();
//        streamExamples();
//
//        String str = "Hi Hello.";
//        str=str.replaceAll(" ", "%20");
//        System.out.println(str);
//
//        System.out.println(checkTwoStringAreRotationOfEachOther());
//
//        //aabcccccaaa → a2b1c5a3
//        String input = "aabcccccaaa";
//        System.out.println(compressString(input));
//        System.out.println(checkIfStringHasAllUniqueChar());
//
//        input = 21543
//        output = 34512
//        reverseArrayTwoTimes();
//
//        findAllSubString();
//        findMaxAndMinInArray();
//        reverseArray();
//        System.out.println(sumOfElementsInArray());
//        copyAllElementOfArray();
//        removeDuplicateFromSortedArray();
//        findFirstDuplicateInArray();
//
//
//        Map<String, ?> map =new HashMap<String, ?>();
//        map.put("abc","bcd" );
//
//        Map<String, List<?>> abc= new HashMap<String, List<?>>();
//
//        abc.put("a", new ArrayList<Integer>(Arrays.asList(2,4)));
//
//
//        System.out.println(checkIfTwoArrAreEqual());
//
//        findFrequencyOfAllElementInArray();
//        rearrangeArray();
        findMissingNumberInFirsNNaturalNumber();

    }

    private static String compressString(String str) {
        if (str == null || str.isEmpty()) return str;

        // Convert the input string to a char array for direct manipulation
        char[] chars = str.toCharArray();
        int n = chars.length;
        StringBuilder compressed = new StringBuilder();

        // Traverse the string and compress it
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                compressed.append(chars[i - 1]).append(count);
                count = 1;
            }
        }

        // Append the last character and count
        compressed.append(chars[n - 1]).append(count);

        // If the compressed string is longer than the original, return the original
        return compressed.length() < n ? compressed.toString() : str;
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }


    private static void separateNumbersAndCharacters(String input) {
        char[] charString = input.toCharArray();
        System.out.println(charString);
        StringBuilder resultString = new StringBuilder();
        StringBuilder resultNumbers = new StringBuilder();
        for (int i = 0; i < charString.length; i++) {
            if (!Character.isAlphabetic(charString[i])) {
                resultNumbers.append(Character.getNumericValue(charString[i]));
            } else {
                resultString.append(charString[i]);
            }
        }
        System.out.println("Characters :" + resultString);
        System.out.println("Numbers : " + resultNumbers);
    }

    private static void stringManipulation(String input) {
        char[] inputArr = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputArr.length; i++) {
            if (Character.isAlphabetic(inputArr[i])) {
                result.append(inputArr[i]);
            }
            if (i + 1 < inputArr.length && Character.isDigit(inputArr[i + 1])) {
                if (i + 2 < inputArr.length && Character.isDigit(inputArr[i + 2])) {
                    String rep = String.valueOf(Character.getNumericValue((inputArr[i + 1])) + String.valueOf(Character.getNumericValue(inputArr[i + 2])));
                    for (int j = 0; j < Integer.valueOf(rep) - 1; j++) {
                        if (Character.isAlphabetic(inputArr[i])) {
                            result.append(inputArr[i]);
                        }
                    }
                } else {
                    for (int j = 0; j < Character.getNumericValue(inputArr[i + 1]) - 1; j++) {
                        if (Character.isAlphabetic(inputArr[i]))
                            result.append(inputArr[i]);
                    }
                }
            }
        }
        System.out.println(result);
    }

    /*Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
    /*public int maxProfit(int[] arr) {
        int buyDay = 0;
        int sellDay = arr.length-1;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                buyDay = i;
                continue;
            }
            if (arr[buyDay] > arr[i]) {
                buyDay = i;
            }
            if (arr[buyDay] < arr[i]) {
                if(arr[i]>arr[sellDay])
                    sellDay = i;
            }
            if(arr[sellDay]<arr[i]){
                sellDay = i;
            }
        }

        if(sellDay-buyDay>0){
            return arr[sellDay]-arr[buyDay];
        }else{
            return 0;
        }
    }*/
    // {2,4,1}
    private static int findMaxProfit(int[] arr) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (arr[right] > arr[left]) {
                int profit = arr[right] - arr[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }
        System.out.println(maxProfit);
        return maxProfit;
    }

    private static boolean cheNumberIsPrime() {
        int x = 1312;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void reverseString() {
        String input = "Hello ! Developer";
        char[] inputArr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char i : inputArr) {
            stack.push(i);
        }
        int counter = inputArr.length;
        StringBuilder outputString = new StringBuilder();
        while (counter > 0) {
            outputString.append(stack.pop());
            counter--;
        }
        System.out.println(outputString);

        StringBuilder stringBuilder = new StringBuilder(input);
        System.out.println(stringBuilder.reverse().toString());
    }

    private static void findFactorialNumber() {
        int input = 5;
        long result = 1;
        for (int i = 1; i <= input; i++) {
            result = result * i;
        }
        System.out.println(result);
    }

    private static boolean checkForPalindrome() {
        String value = "15251".toLowerCase();
        char[] valueArray = value.toCharArray();
        int left = 0;
        int right = valueArray.length - 1;
        boolean result = true;
        while (left < right) {
            if (valueArray[left] == valueArray[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return result;
    }

    private static void fibonacci() {
        int number = 10;
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            System.out.print(" " + (fibonacciSum(i)));
            sum = sum + fibonacciSum(i);
        }
        System.out.println();
        System.out.println(sum);
    }

    private static int fibonacciSum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciSum(n - 1) + fibonacciSum(n - 2);
    }

    private static void largestAndSmallestInArray() {
        int[] arr = {2, 4, 1, 67, 5, 4, 8, 3};
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        System.out.println("Max : " + max + " Min : " + min);
    }

    private static void findVowelInString() {
        String input = "Hello Hi my name is rahul";
        input = input.toLowerCase();
        String[] stringList1 = input.split("");
        List<String> vowelList = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        List<String> outputList = new ArrayList<>();
        for (String str : stringList1) {
            if (vowelList.contains(str)) {
                outputList.add(str);
            }
        }
        System.out.println(outputList);
    }

    private static void swapNumbers() {
        int firstNumber = 24;
        int secondNumber = 89;
        System.out.println("First Number : " + firstNumber + " Second Number : " + secondNumber);

        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;

        System.out.println("First Number : " + firstNumber + " Second Number : " + secondNumber);
    }

    private static int[] sortAnArray(int[] arr) {
//        int[] arr = {45, 7, 15, 4, 96, 8, 32, 4};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        return arr;
    }

    private static void removeDuplicates() {
        int[] arr = {45, 8, 25, 14, 63, 14, 1, 5, 52}; // 45 8 25 14 63 1 5 52
//        int[] arr={45,8,25,14,63,45,14,1,5,52}; // 45 8 25 14 63 1 5 52

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void findFirstNonRepeatingCHar() {
        String input = "Hello World.";
        input = input.toLowerCase();
        input = input.replace(" ", "");
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : inputArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            if (c.getValue() == 1) {
                System.out.println(c);
                break;
            }
        }
    }

    private static void findFirstRepeatingChar() {
        String input = "Hello hi".toLowerCase().replace(" ", "");
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char r : inputArr) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.println(c);
                break;
            }
        }
    }

    private static void removeDuplicateCharacter() {
        String input = "Hello hi".toLowerCase().replace(" ", "");
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder output = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char i : inputArr) {
            if (!set.contains(i)) {
                set.add(i);
                output.append(i);
            }
        }
        System.out.println(output);
    }

    private static boolean anagramOrNot() {
        String str1 = "listen";
        String str2 = "silent";

        if (str1.length() != str2.length())
            return false;

        char[] str1Arr = str1.toCharArray();

        for (char i : str1Arr) {
            if (!str2.contains(String.valueOf(i))) {
                return false;
            }
        }

        return true;
    }

    private static void mostFrequencyInString() {
        String str = "Hello";
        char[] strArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : strArr) {
            if (str.contains(String.valueOf(c))) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        int max = 0;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > max) {
                max = entry.getValue();
                resultMap.replace(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void streamExamples() {
        List<String> list = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie", "Anil", "Nayana");
        List<String> result = list.stream().map(x -> x.toLowerCase())
                .filter(x -> x.contains(String.valueOf('n'))).toList();
        for (String s : result) {
            System.out.println(s);
        }

    }

    private static boolean checkTwoStringAreRotationOfEachOther() {
        String str1 = "abcdc";
        String str2 = "dcabc";

        String result = str1 + str2;
        if (str1.length() != str2.length())
            return false;
        if (result.contains(str2))
            return true;
        return false;
    }

    private static boolean checkIfStringHasAllUniqueChar() {
        String str = "abcdefghijk lm nop".toLowerCase().replace(" ", "");
        char[] strArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : strArr) {
            if (str.contains(String.valueOf(c))) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                return false;
        }
        return true;
    }

    private static void findAllSubString() {
        String str = "Hi Hello how are you";
        Map<Integer, String> map = new HashMap<>();
        int count = 1;

        char[] strArr = str.toCharArray();
        System.out.println("Input String : " + String.valueOf(strArr));
        StringBuilder resString = new StringBuilder();
        for (char c : strArr) {
            if (c != ' ') {
                resString.append(c);
            } else {
                map.put(count, resString.toString());
                count++;
                resString = new StringBuilder();
            }
        }
        map.put(count, resString.toString());

        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }
    }


    private static void reverseArrayTwoTimes() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int size = arr.length;

        reverArr(0, 1, arr);
        reverArr(2, size - 1, arr);
        reverArr(0, size - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverArr(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private static void findMaxAndMinInArray() {
        int[] arr = {4, 23, 7, 55, 90, 2, 7};
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void reverseArray() {
        int[] arr = {2, 4, 7, 4, 9, 5, 0, 1, 6};
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int sumOfElementsInArray() {
        int[] arr = {2, 4, 7, 4, 9, 5, 0, 1, 6};
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        return sum;
    }

    private static void secondLargestElement() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52};
        sortAnArray(arr);
        System.out.println(arr[arr.length - 2]);

        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < max && arr[i] > secondMax)
                secondMax = arr[i];
        }
        System.out.println("First : " + max + " Second : " + secondMax);

    }

    private static void copyAllElementOfArray() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52};

        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    private static void removeDuplicateFromSortedArray() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52};
        sortAnArray(arr);
//        int[] array = Arrays.stream(arr).distinct().toArray();
//        System.out.println(Arrays.toString(array));

        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                continue;
            } else {
                arr2[i] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }

    private static void findFirstDuplicateInArray() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52, 45};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }


    private static boolean checkIfTwoArrAreEqual() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52, 45};
        int[] arr2 = {45, 8, 25, 14, 63, 91, 14, 1, 5, 52, 45};

        if (arr.length != arr2.length)
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i])
                return false;
        }
        return true;
    }

    //Find the frequency of each element in an array.
    private static void findFrequencyOfAllElementInArray() {
        int[] arr = {45, 8, 25, 14, 63, 91, 14, 1, 8, 25, 45};
        Map<Integer, Integer> resuMap = new LinkedHashMap<>();
        for (int j : arr) {
            resuMap.put(j, resuMap.getOrDefault(j, 0) + 1);
        }
        System.out.println(resuMap);
    }

    //Rearrange the array so that arr[i] = i (or -1 if not present).
    private static void rearrangeArray() {
        int[] arr = {3, 4, 2, 5, 0, 1};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void findMissingNumberInFirsNNaturalNumber(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,13);
        int n = list.get(list.size()-1);
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=n;i++){
            if(!list.contains(i))
                result.add(i);
        }
        System.out.println(result);
    }

}









