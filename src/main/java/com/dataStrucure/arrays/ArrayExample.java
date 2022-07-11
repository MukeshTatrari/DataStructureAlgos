package com.dataStrucure.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayExample {

    public static void main(String args[]) {
        int arr[] = new int[]{41, 7, 8, 9, 19, 25, 87};
        ArrayExample arrayExample = new ArrayExample();
        int data[] = arrayExample.reverse(arr);
        arrayExample.print(data);
        int min = arrayExample.findMin(data);
        System.out.println("minimum :::::: " + min);
        int secondMax = arrayExample.findSecondMax(data);
        System.out.println("second max " + secondMax);
        int[] arrayWithZero = new int[]{1, 0, 0, 0, 7, 9};
        arrayExample.moveZerosAtLast(arrayWithZero);
        arrayExample.print(arrayWithZero);
        System.out.println("length " + arrayWithZero.length);
        int arr1[] = arrayExample.resize(arrayWithZero, arrayWithZero.length * 4);
        System.out.println("length after  " + arr1.length);
        int data1 = arrayExample.findMissingNumber(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10});
        System.out.println("data1  " + data1);

        System.out.println("is palindrome ::: " + arrayExample.checkPalindrom(new String[]{"m", "p", "d", "a", "m"}));
        int[] twoSum = arrayExample.twoSumProblem(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}, 8);
        arrayExample.print(twoSum);
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
        for (int i = 0; i < arr.length - 1; i++) {
            sum = sum + arr[i];
        }
        return naturalSum - sum;
    }

    public boolean checkPalindrom(String[] arr) {
        int end = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
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
        for (int i = 0; i < arr.length - 1; i++) {
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

        return merged;
    }
}
