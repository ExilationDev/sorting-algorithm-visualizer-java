/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp.SortAlgorithms;

import java.util.ArrayList;
import sortingalgorithmapp.BarObject;
import sortingalgorithmapp.ObjectDraw;
import static sortingalgorithmapp.SortingAlgorithm.*;

/**
 *
 * @author Exilation
 */
public class BogoSort {
    static boolean isSorted(ArrayList<BarObject> arr, int n) {
	for(int x = 0; x < n - 1; ++x) {
            arr.get(x).selected = true;
            pause(d);
            ObjectDraw.Refresh();
            pause(d);
            arr.get(x).selected = false;
            if(arr.get(x).value > arr.get(x+1).value) {
                return false;
            }
	}
	return true;
    }
    static void shuffle(ArrayList<BarObject> arr, int n) {
        for(int x = 0; x < n; ++x) {
		int index1 = (int) (Math.random() * n);
                int index2 = (int) (Math.random() * n);
                arr.get(index1).selected = true;
                arr.get(index2).selected = true;
                pause(d);
                ObjectDraw.Refresh();
                pause(d);
                arr.get(index1).selected = false;
                arr.get(index2).selected = false;
		var a = arr.get(index1);
		arr.set(index1, arr.get(index2));
		arr.set(index2, a);
	}
    }
    static void bogosort(ArrayList<BarObject> arr, int n) {
        while (!isSorted(arr, n)) {
            shuffle(arr, n);
        }
    }
    public static void sort(ArrayList<BarObject> arr, int n, int delay) {
        ObjectDraw.sortName = "Bogo Sort";
        d = delay;
        bogosort(arr, n);
        
        // Validate Sorted Array
        Validate(arr, n);
    }
}
