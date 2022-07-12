package com.dataStrucure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayExample {

    public static void main(String args[]) {
        int arr[] = new int[]{41, 7, 8, 9, 19, 25, 87};
        ArrayExample arrayExample = new ArrayExample();
//        int data[] = arrayExample.reverse(arr);
//        arrayExample.print(data);
//        int min = arrayExample.findMin(data);
//        System.out.println("minimum :::::: " + min);
//        int secondMax = arrayExample.findSecondMax(data);
//        System.out.println("second max " + secondMax);
//        int[] arrayWithZero = new int[]{1, 0, 0, 0, 7, 9};
//        arrayExample.moveZerosAtLast(arrayWithZero);
//        arrayExample.print(arrayWithZero);
//        System.out.println("length " + arrayWithZero.length);
//        int arr1[] = arrayExample.resize(arrayWithZero, arrayWithZero.length * 4);
//        System.out.println("length after  " + arr1.length);
//        int data1 = arrayExample.findMissingNumber(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10});
//        System.out.println("data1  " + data1);
//
//        System.out.println("is palindrome ::: " + arrayExample.checkPalindrom(new String[]{"m", "p", "d", "a", "m"}));
//        int[] twoSum = arrayExample.twoSumProblem1(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}, 8);
//        arrayExample.print(twoSum);
//
//        int[] merged = arrayExample.mergeTwoSortedArray(new int[]{2, 8, 9, 15}, new int[]{1, 5, 6, 8, 19, 24});
//        System.out.println("merged array ::: ");
//        arrayExample.print(merged);

//        int max = arrayExample.findMaxOfSubArrays(new int[]{4, 3, -2, 6, -12, 7, -1, 6});
//        System.out.println("max of sub array ::: " + max);
        int[] arr3 = new int[]{-4, -5, 6, 7, 8, -9, -3, 10};
        arr3= arrayExample.sortedSquareArray(arr3);
        arrayExample.print(arr3);
    }


    public int[] reverse(int arr[]) {
        int array[] = new int[arr.length];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            array[count] = arr[i];
            count++;
        }

        return array;
    }

    public void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
        System.out.println();
    }

    public int findMin(int arr[]) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int findSecondMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    private void moveZerosAtLast(int arr[]) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public int findMissingNumber(int arr[]) {
        int naturalSum = (arr.length) * (arr.length + 1) / 2;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return naturalSum - sum;
    }

    public boolean checkPalindrom(String[] arr) {
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[end]) {
                return false;
            }
            end--;
        }
        return true;
    }

    public int[] twoSumProblem(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - arr[i]);
            }
        }

        return result;
    }

    public int[] mergeTwoSortedArray(int arr[], int arr1[]) {
        int[] merged = new int[arr.length + arr1.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < arr1.length) {
            if (arr[i] < arr1[j]) {
                merged[k] = arr[i];
                i++;
            } else {
                merged[k] = arr1[j];
                j++;
            }
            k++;
        }
        while (i < arr.length) {
            merged[k] = arr[i];
            i++;
            k++;
        }
        while (j < arr1.length) {
            merged[k] = arr1[j];
            j++;
            k++;
        }

        return merged;
    }

    public int[] twoSumProblem1(int arr[], int target) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                result[0] = i;
                result[1] = j;
                return result;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public int findMaxOfSubArrays(int[] arr) {
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax = currentMax + arr[i];
            if (currentMax < arr[i]) {
                currentMax = arr[i];
            }
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }

    public void squareArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int square = arr[i] * arr[i];
            arr[i] = square;
        }
    }

    public int[] sortedSquareArray(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int k = 0; k <n; k++) {
            if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }
}
