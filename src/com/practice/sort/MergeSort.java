package com.practice.sort;

public class MergeSort {

    public static void printTwoSortedArray(int arr1[],int arr2[])
    {
        int i=0,j = 0;

        System.out.println("Sorted Numbers");
        while (i < arr1.length && j < arr2.length)
        {
            if(arr1[i] <= arr1[j])
            {
                System.out.print(arr1[i] + " ");
                i++;
            }
            else
            {
                System.out.print(arr2[j]+ " ");
                j++;
            }
        }

        while (i < arr1.length)
        {
            System.out.print(arr1[i] + " ");
            i++;

        }
        while (j < arr2.length)
        {
            System.out.print(arr2[j] + " ");
            j++;

        }
    }

    //assume low to mid are sorted, mid +1 to high is sorted
    //e.g {5,10,15,7,14} : low 0, mid =2, high = 4
    //output : {5,7,10,14,15}
    public static void merge(int [] arr,int low, int mid,int high)
    {
        int lcount = mid -low +1;
        int rcount = high - mid;
        int left [] = new int[lcount];
        int right [] = new int [rcount];

        System.out.println (" left");
        for(int i =0; i< lcount;i++)
        {
            left[i] = arr[i+low];
            System.out.print(left[i] + " ");
        }
        System.out.println();
        System.out.println (" right");
        for(int i=0;i<rcount;i++)
        {
            right[i] = arr[mid+1+i];
            System.out.print(right[i]+ " ");
        }

        int i=0;int j=0;int k=low;
        System.out.println();
        while (i < left.length && j < right.length)
        {
            if(left[i] <= right[j])
            {
                //System.out.print(left[i] + " ");
                arr[k]=left[i];
                i++;k++;
            }
            else
            {
                arr[k] = right[j];
                //System.out.print(right[j]+ " ");
                j++;k++;
            }
        }

        while (i < left.length)
        {
            arr[k] = left[i];
            //System.out.print(left[i] + " ");
            i++;k++;

        }
        while (j < right.length)
        {
            arr[k]=right[j];
           // System.out.print(right[j] + " ");
            j++;k++;

        }

        int x = low;
        System.out.println();
        System.out.println("Iteration output");
        while(x < k)
        {
            System.out.print(arr[x] + " ");
            x++;
        }
        System.out.println();
        System.out.println("----------");

    }

    public static void sort(int arr[])
    {
        int l = 0;
        int r = arr.length -1;

        for(int i =0; i< arr.length;i++)
        {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        mergeSort(arr,l,r);

    }
    private  static void mergeSort(int arr[],int l, int r)
    {
        if(r > l)
        {
            int mid = l + (r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
}
