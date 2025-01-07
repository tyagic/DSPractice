package com.practice.main;

import com.practice.util.UtilityFunctions;

public class Runner {

    public static void main(String args [])
    {
        int arr1[] = new int[]  {1,3,5,7};
        int arr2[] = new int[]  {2,4,6,8,10};
      // MergeSort.printTwoSortedArray(arr1,arr2);

        /*
       int arr [] = {5,10,15,7,14};
       MergeSort.merge(arr,0,2,4);
       for(int i =0; i <arr.length;i++)
       {
           System.out.print(arr[i] + " ");
       }

         */
        /*
        int arr [] = {10,5,7,17,2,8};
        MergeSort.sort(arr);
        for(int i =0; i <arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }


        int arr3 [] = {2,5,5,9,13};
        int arr4 [] = {1,5,6,9};
        System.out.println("Input Arrays");
        for(int i=0;i<arr3.length ;i++)
        {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        for(int i=0;i<arr4.length ;i++)
        {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        System.out.println("Intersection of 2 sorted array");
        UtilityFunctions.intersectionOfTwoSortedArray(arr3,arr4);
        System.out.println();
        System.out.println("Union of 2 sorted array");
        UtilityFunctions.unionOfTwoSortedArray(arr3,arr4);
        System.out.println();
        int[] arr5 = {40,30,20,10};
        System.out.println("Input Array");
        for(int i=0;i<arr5.length ;i++)
        {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
        UtilityFunctions.printInversionInArray(arr5);
        System.out.println();
        System.out.println("Output Array");
        for(int i=0;i<arr5.length ;i++)
        {
            System.out.print(arr5[i] + " ");
        }


        int[] arr6 = {2,5,1,8,4,9,7};
        System.out.println();
        System.out.println("Input Array");
        for(int i=0;i<arr6.length ;i++)
        {
            System.out.print(arr6[i] + " ");
        }

        int newPivotIndex = UtilityFunctions.Partition(arr6,4);
        System.out.println();
        System.out.println("Output Array : PivotIndex"+newPivotIndex);
        for(int i=0;i<arr6.length ;i++)
        {
            System.out.print(arr6[i] + " ");
        }

         */
        /*
        int arr []  = {1,2,3,4,5};
        ArrayList<Integer> result = UtilityFunctions.subarraySum(arr,5,6);
        for(int num : result)
        {
            System.out.println(num);
        }

         */

        int[] arr6 = {2,3,1,8,4,9,7,5};
        System.out.println();
        System.out.println("Input Array");
        for(int i=0;i<arr6.length ;i++)
        {
            System.out.print(arr6[i] + " ");
        }

        System.out.println();
        /*
        int pivotIndex = 5;
        int low = 3;
        int high = arr6.length -1;

        System.out.println("Pivot Index : "+pivotIndex +" element : "+arr6[pivotIndex]+" low :" +low+" high: "+high);


        int newPivotIndex = UtilityFunctions.PartitionNaive(arr6,low,high,pivotIndex);

         */
        //int newPivotIndex = UtilityFunctions.lomutoPartition(arr6,0,arr6.length -1);
        int newPivotIndex = UtilityFunctions.hoarePartition(arr6,0,arr6.length -1);
        System.out.println();
        System.out.println("Output Array : New PivotIndex "+newPivotIndex + " : pivotValue arr["+newPivotIndex+"]="+arr6[newPivotIndex]);


        for(int i=0;i<arr6.length ;i++)
        {
            System.out.print(arr6[i] + " ");
        }
    }
}
