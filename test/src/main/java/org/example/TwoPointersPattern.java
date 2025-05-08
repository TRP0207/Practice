package org.example;

import java.util.Arrays;

public class TwoPointersPattern {
    public static void main(String[] args) {

        //find sum of two element is target number or not
//        System.out.println(findSumOfTwo());
        moveAllZeroToEnd();
    }

    private static boolean findSumOfTwo() {
        int target = 25;
        int[] arr = {1, 3, 4, 6, 7, 9, 12, 13, 34};
        int left = 0;
        int right = arr.length - 1;
        int no1 = -1;
        int no2 = -1;
        boolean result = false;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                no1 = arr[left];
                no2 = arr[right];
                result = true;
                break;
            } else if (sum > target)
                right--;
            else
                left++;
        }
        if (result)
            System.out.println("no 1 : " + no1 + " And No 2 : " + no2);
        else
            System.out.println("element not found");
        return result;
    }


    private static void moveAllZeroToEnd() {
        int[] nums = {1, 0, 3, 4, 0, 7, 0, 0, 9, 12, 0};
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap only if left and right are different
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
