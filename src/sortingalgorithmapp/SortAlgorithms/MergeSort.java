/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp.SortAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import sortingalgorithmapp.BarObject;
import sortingalgorithmapp.ObjectDraw;
import sortingalgorithmapp.SortingAlgorithm;
import static sortingalgorithmapp.SortingAlgorithm.pause;

/**
 *
 * @author Exilation
 */
public class MergeSort extends SortingAlgorithm {
    
    static void merge(ArrayList<BarObject> arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
        // Create temp arrays
        var L = new ArrayList<BarObject>(Collections.nCopies(n1, new BarObject(0, 0, 0, 0, 0, 0)));
        var R = new ArrayList<BarObject>(Collections.nCopies(n2, new BarObject(0, 0, 0, 0, 0, 0)));
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) L.set(i, arr.get(l + i));
        for (int j = 0; j < n2; ++j) R.set(j, arr.get(m + 1 + j));
        
        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
        
        // Initial index of merged subarray array
        int k = l;
        
        while (i < n1 && j < n2) {
            arr.get(k).selected = true;
            pause(d);
            ObjectDraw.Refresh();
            if (L.get(i).value <= R.get(j).value) {
                pause(d);
                arr.get(k).selected = false;
                arr.set(k, L.get(i));
                i++;
            } else {
                pause(d);
                arr.get(k).selected = false;
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }
    
    static void mergeSort(ArrayList<BarObject> arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void sort(ArrayList<BarObject> arr, int n, int delay) {
        ObjectDraw.sortName = "Merge Sort";
        d = delay;
        mergeSort(arr, 0, n - 1);
        Validate(arr, n);
    }
}
