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
public class BubbleSort extends SortingAlgorithm {
    public static void sort(ArrayList<BarObject> arr, int n, int delay) {
        ObjectDraw.sortName = "Bubble Sort";
        
        BarObject temp;
        boolean swapped;
        for (var i = 0; i < n - 1; i++) {
            swapped = false;
            for (var j = 1; j < n - i; j++) {
                arr.get(j-1).selected = true;
                arr.get(j).selected = true;
                
                pause(delay);
                ObjectDraw.Refresh();
                
                if (arr.get(j-1).value > arr.get(j).value) {
                    temp = arr.get(j-1);
                    arr.set(j-1, arr.get(j));
                    arr.set(j, temp);
                    swapped = true;
                }
                
                pause(delay);
                
                arr.get(j-1).selected = false;
                arr.get(j).selected = false;
            }
            if (swapped == false)
                break;
        }
        
        // Validate Sorted Array
        Validate(arr, n);
    }
}
