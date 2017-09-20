package lc222ak_assign1;

import lc222ak_assign1.*;

import java.util.Collections;

public class ArraysMain {
    public static void main() throws Error {
        sum();
        string();
        addN();
        reverse();
        replace();
        sort();
        subSequence();
        absDif();
    }

    private static void sum() {
        int[] arr = {1,2,3,4,5};
        System.out.println("Sum: " + Arrays.sum(arr));
    }

    private static void string() {
        int[] arr = {1,2,3,4,5};
        System.out.println("toString: " + Arrays.toString(arr));
    }

    private static void addN() {
        int[] arr = {1,2,3,4,5};
        int[] res = Arrays.addN(arr, 5);
        System.out.println("Add number: " + Arrays.toString(res));
    }

    private static void reverse() {
        int[] arr = {1,2,3,4,5};
        int[] res = Arrays.reverse(arr);
        System.out.println("Reverse: " + Arrays.toString(res));
    }

    private static void replace() {
        int[] arr = {1,2,3,4,5};
        Arrays.replaceAll(arr, 5, 7);
        System.out.println("Replace all: " + Arrays.toString(arr));
    }

    private static void sort() {
        int[] arr = {1,5,3,4,2};
        int[] res = Arrays.sort(arr);
        System.out.println("Sort array: " + Arrays.toString(res));
    }

    private static void subSequence() {
        int[] arr = {1,5,3,4,2};
        int[] sub = {5,3,4};
        boolean res = Arrays.hasSubsequence(arr, sub);
        System.out.println("Has sub sequence?: " + res);
    }

    private static void absDif() {
        int[] arr1 = {1,5,4,3,2,-5,10,-4};
        int[] arr2 = {1,1,1,1,1,1,1,1};
        int[] res = Arrays.absDif(arr1, arr2);
        System.out.println("Absolute difference: " + Arrays.toString(res));
    }

}
