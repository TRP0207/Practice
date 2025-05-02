package org.example;

public class TwoPointersPattern {
    public static void main(String[] args) {
        System.out.println(findSumOfTwo());
    }

    private static boolean findSumOfTwo() {
        int target = 91;
        int[] arr = {1, 3, 4, 6, 7, 9, 12, 13, 34};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                return true;
            else if (sum > target)
                right--;
            else
                left++;
        }
        return false;
    }
}
