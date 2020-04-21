package com.company;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static int[] mergeKSortedArray(int[][] arr) {
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
        int total=0;

        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }

        int m=0;
        int result[] = new int[total];

        while(!queue.isEmpty()){
            ArrayContainer ac = queue.poll();
            result[m++]=ac.arr[ac.index];

            if(ac.index < ac.arr.length-1){
                queue.add(new ArrayContainer(ac.arr, ac.index+1));
            }
        }

        return result;
    }

        public void sort(int arr[])
        {
            int n = arr.length;

            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            for (int i=n-1; i>=0; i--)
            {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
        }

        void heapify(int arr[], int n, int i)
        {
            int largest = i;
            int l = 2*i + 1;
            int r = 2*i + 2;

            if (l < n && arr[l] > arr[largest])
                largest = l;

            if (r < n && arr[r] > arr[largest])
                largest = r;

            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify(arr, n, largest);
            }
        }

        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }

        public static void main(String args[])
        {
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value of n: ");
            n = sc.nextInt();
            int arr1[] = new int[n];
            for(int i = 0; i < arr1.length; i++) {
                arr1[i] = (int)(Math.random()*100+1);
            }
            System.out.println("Random array:");
            printArray(arr1);
            Main ob = new Main();
            ob.sort(arr1);

            System.out.println("Sorted array:");
            printArray(arr1);

            int arr2[] = new int[n];
            for(int i = 0; i < arr2.length; i++) {
                arr2[i] = (int)(Math.random()*100+1);
            }
            System.out.println("Random array:");
            printArray(arr2);
            ob.sort(arr2);

            System.out.println("Sorted array:");
            printArray(arr2);

            int arr3[] = new int[n];
            for(int i = 0; i < arr3.length; i++) {
                arr3[i] = (int)(Math.random()*100+1);
            }
            System.out.println("Random array:");
            printArray(arr3);
            ob.sort(arr3);

            System.out.println("Sorted array:");
            printArray(arr3);


            int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
            System.out.println(Arrays.toString(result));


        }    }

class ArrayContainer implements Comparable<ArrayContainer> {
    int[] arr;
    int index;

    public ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}