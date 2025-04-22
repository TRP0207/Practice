package com.user_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Me45hu8l
public class Test {
    public static void main(String[] args) {
//        int[] nums = {1,1,0,1,1,1,0,0,1,1,1,1,0};
//        System.out.println(findMaxConsecutiveOnes(nums));

        /*String input = "Me45hu8l63Th4a0k5ar1";
        separateNumbersAndCharacters(input);*/

        String input = "sha2ll11u";
        String output = "MMehhhul";
        stringManipulation(input);
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                max = count;
                count = 0;
            }
        }
        return max > count ? max : count;
    }


    static void separateNumbersAndCharacters(String input) {
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

    static void stringManipulation(String input) {
        char[] inputArr = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputArr.length; i++) {
            if(Character.isAlphabetic(inputArr[i])){
                result.append(inputArr[i]);
            }
            if (i + 1 < inputArr.length && Character.isDigit(inputArr[i + 1])) {
                if(i+2<inputArr.length && Character.isDigit(inputArr[i+2])){
                    String rep = String.valueOf(Character.getNumericValue((inputArr[i + 1]))+String.valueOf(Character.getNumericValue(inputArr[i + 2])));
                    for (int j = 0; j < Integer.valueOf(rep)- 1; j++) {
                        if(Character.isAlphabetic(inputArr[i])){
                            result.append(inputArr[i]);
                        }
                    }
                }else {
                    for (int j = 0; j < Character.getNumericValue(inputArr[i + 1]) - 1; j++) {
                        if(Character.isAlphabetic(inputArr[i]))
                            result.append(inputArr[i]);
                    }
                }

            }

        }
        System.out.println(result);
    }
}