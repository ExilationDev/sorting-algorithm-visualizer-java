/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp.SortAlgorithms;

import java.util.ArrayList;
import sortingalgorithmapp.BarObject;
import sortingalgorithmapp.ObjectDraw;
import sortingalgorithmapp.SortingAlgorithm;

/**
 *
 * @author Exilation
 */
public class QuickSort extends SortingAlgorithm {
    static void swap(ArrayList<BarObject> arr, int i, int j)
    {
        BarObject temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        arr.get(i).selected = true;
        arr.get(j).selected = true;
    }
    
    static int partition(ArrayList<BarObject> arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr.get(high).value;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            arr.get(j).selected = true;
            pause(d);
            ObjectDraw.Refresh();
            if (arr.get(j).value < pivot) {
                i++;
                swap(arr, i, j);
            }
            pause(d);
            if (i >= 0) arr.get(i).selected = false;
            arr.get(j).selected = false;
        }
        swap(arr, i + 1, high);
        arr.get(i+1).selected = false;
        arr.get(high).selected = false;
        return (i + 1);
    }
    
    public static void quicksort(ArrayList<BarObject> arr, int low, int high) {
        
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    
    public static void sort(ArrayList<BarObject> arr, int n, int delay) {
        ObjectDraw.sortName = "Quick Sort";
        d = delay;
        quicksort(arr, 0, n-1);
        
        // Validate Sorted Array
        Validate(arr, n);
    }
}
