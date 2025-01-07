package com.practice.util;

import java.util.ArrayList;

public class UtilityFunctions {

    public static void intersectionOfTwoSortedArray(int[] arr1, int arr2[]) {
        int i = 0;
        int j = 0;
        //int duplicate = -1;

        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] == arr2[j]) {
                //match found
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static void unionOfTwoSortedArray(int[] arr1, int arr2[]) {
        int i = 0;
        int j = 0;
        //  int duplicate = -1;

        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr1[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            } else if (arr1[i] == arr2[j]) {
                //match found
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }

        }


        while (i < arr1.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            System.out.print(arr1[i] + " ");
            i++;
        }

        while (j < arr2.length) {
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            System.out.print(arr2[j] + " ");
            j++;
        }

    }


    public static void printInversionInArray(int arr[]) {
        System.out.println("No of inversion =" + countInversion(arr, 0, arr.length - 1));
    }

    private static int countInversion(int arr[], int l, int r) {
        int inversionCount = 0;

        if (r > l) {
            int mid = l + (r - l) / 2;
            inversionCount += countInversion(arr, l, mid);
            inversionCount += countInversion(arr, mid + 1, r);

            inversionCount = inversionCount + getInversionCount(arr, l, r, mid);

        }
        return inversionCount;

    }

    private static int getInversionCount(int[] arr, int l, int r, int mid) {
        // Populate left and right array using l , mid and r
        int lcount = mid - l + 1;
        int rcount = r - mid;

        int left[] = new int[lcount];
        int right[] = new int[rcount];

        System.out.println();
        System.out.println("Left Array");
        for (int i = 0; i < lcount; i++) {
            left[i] = arr[i + l];
            System.out.print(left[i] + " ");
        }
        System.out.println();
        System.out.println("Right Array");
        for (int i = 0; i < rcount; i++) {
            right[i] = arr[mid + 1 + i];
            System.out.print(right[i] + " ");
        }

        // now calculate inversion during merging
        int i = 0, j = 0, k = l;
        System.out.println();
        int inversionCount = 0;
        while (i < lcount && j < rcount) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            }
            //inversion condition
            else {
                inversionCount = inversionCount + lcount - i;
                System.out.println();
                System.out.println("inversionCount=" + inversionCount);
                for (int m = 0; m < lcount - i; m++) {
                    System.out.print("(" + left[i + m] + "," + right[j] + ") ");
                }
                arr[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < lcount) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < rcount) {
            arr[k] = right[j];
            k++;
            j++;
        }
        return inversionCount;
    }


    public static int Partition(int[] arr, int pivotIndex) {
        if (pivotIndex > arr.length - 1)
            return -1;

        int val = arr[pivotIndex - 1];
        int l = 0;
        int r = arr.length - 1;
        int k = 0;
        int[] temp = new int[arr.length];

        System.out.println("Value at index " + pivotIndex + " = " + val);
        //smaller copy to temp
        for (int i = 0; i <= r; i++) {
            if (arr[i] < val) {
                temp[k] = arr[i];
                k++;
            }
        }

        //Equal copy to temp
        for (int i = 0; i <= r; i++) {
            if (arr[i] == val) {
                temp[k] = arr[i];
                pivotIndex = k + 1;
                k++;
            }
        }

        //Greater copy to pivot  right
        for (int i = 0; i <= r; i++) {
            if (arr[i] > val) {
                temp[k] = arr[i];
                k++;
            }
        }
        //Copy temp to arr
        for (int i = 0; i <= r; i++) {
            arr[i] = temp[i];
        }

        return pivotIndex;

    }


    public static int PartitionNaive(int[] arr,int low,int high, int pivotIndex) {
        if (pivotIndex > arr.length - 1 ||  pivotIndex < low || pivotIndex > high) {
            System.out.println("Invalid pivot");
            return -1;
        }

        int val = arr[pivotIndex];

        int[] temp = new int[high -low + 1];
        int index = 0;

        System.out.println("Value at index " + pivotIndex + " = " + val);
        //smaller copy to temp
        for (int i = low; i <= high; i++) {
            if (arr[i] < val) {
                temp[index] = arr[i];
                index++;
            }
        }

        //Equal copy to temp
        for (int i = low; i <= high; i++)  {
            if (arr[i] == val) {
                temp[index] = arr[i];
                pivotIndex = i+1;
                index++;
            }
        }

        //Greater copy to pivot  right
        for (int i = low; i <= high; i++)  {
            if (arr[i] > val) {
                temp[index] = arr[i];
                index++;
            }
        }
        //Copy temp to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }

        return pivotIndex;

    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int start = 0;
        int last = 0;
        boolean flag = false;
        int currsum = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        //iterating over the array.
        for (int i = 0; i < n; i++) {
            //storing sum upto current element.
            currsum += arr[i];

            //checking if current sum is greater than or equal to given number.
            if (currsum >= s) {
                last = i;
                //we start from starting index till current index and do the
                //excluding part while s(given number) < currsum.
                while (s < currsum && start < last) {
                    //subtracting the element from left i.e., arr[start]
                    currsum -= arr[start];
                    ++start;
                }

                //now if current sum becomes equal to given number, we store
                //the starting and ending index for the subarray.
                if (currsum == s) {
                    res.add(start + 1);
                    res.add(last + 1);

                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag == false) {
            res.add(-1);
        }
        //returning the result.
        return res;
    }


    public static int lomutoPartition(int arr[], int low, int high)
    {
        int pivotIndex = -1;

        int i = low -1;
        int lastIndex = high;
        int pivot = arr[high];

        for(int j = low; j<= lastIndex -1 ; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                int temp  = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

            i++;
            int temp = pivot;
            pivot = arr[i];
            arr[i] = temp;


        pivotIndex = i;
        return pivotIndex;
    }

    public static int hoarePartition(int arr[], int low , int high)
    {
        int pivot = arr[low];

        int i  = 0;
        int j = high ;


        while(i < j)
        {
            while(arr[i] < pivot)
            {
                i++;
            }

            while (arr[j] > pivot)
            {
                --j;
            }

            if(i > j)
                return j;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

        }

        return j;
    }
}
