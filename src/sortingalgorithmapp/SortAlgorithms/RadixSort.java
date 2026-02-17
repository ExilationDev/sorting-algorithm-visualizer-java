/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp.SortAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import sortingalgorithmapp.BarObject;
import sortingalgorithmapp.ObjectDraw;
import sortingalgorithmapp.SortingAlgorithm;

/**
 *
 * @author Exilation
 */
public class RadixSort extends SortingAlgorithm {
    
    static int getMax(ArrayList<BarObject> arr, int n)
    {
        int mx = arr.get(0).value;
        for (int i = 1; i < n; i++)
            if (arr.get(i).value > mx)
                mx = arr.get(i).value;
        return mx;
    }
    
    static void countSort(ArrayList<BarObject> arr, int n, int exp)
    {
        
        var output = new ArrayList<BarObject>(Collections.nCopies(n, new BarObject(0, 0, 0, 0, 0, 0)));
        int i;
        
        var count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr.get(i).value / exp) % 10]++;
            //count.get((arr.get(i).value / exp) % 10).value++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        
        //System.out.println((arr.get(i).value / exp) % 10);
        // Build the output array
        for (i = n-1; i >= 0; i--) {
            //System.out.println(count[(arr.get(i).value / exp) % 10] - 1);
            output.set(count[(arr.get(i).value / exp) % 10] - 1, arr.get(i));
            count[(arr.get(i).value / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++) {
            arr.get(i).selected = true;
            pause(d);
            ObjectDraw.Refresh();
            
            pause(d);
            arr.get(i).selected = false;
            arr.set(i, output.get(i));
        }
    }
    
    static void radixsort(ArrayList<BarObject> arr, int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }
    
    public static void sort(ArrayList<BarObject> arr, int n, int delay) {
        ObjectDraw.sortName = "LSD Radix Sort";
        d = delay;
        radixsort(arr, n);
        
        // Validate Sorted Array
        Validate(arr, n);
    }
}
