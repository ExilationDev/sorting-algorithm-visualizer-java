/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import java.util.ArrayList;
import sortingalgorithmapp.SortAlgorithms.*;

/**
 *
 * @author Exilation
 */
public class SortingAlgorithm {

    public static boolean isSorting = false;
    public static int d;

    public static void SortList(ArrayList<BarObject> arr, int delay) {
        int n = arr.size();
        isSorting = true;
        MergeSort.sort(arr, n, delay);
        isSorting = false;
    }

    public static void Validate(ArrayList<BarObject> arr, int n) {
        double sum = 3e5 * Math.ceil(400 / (double) n);
        for (var i = 0; i < n; i++) {
            arr.get(i).selected = true;
            pause((int) (sum));
            ObjectDraw.Refresh();
            pause((int) (sum));
            arr.get(i).selected = false;
            if (arr.get(i).value != i + 1) {
                break; // Check if the bars are correct. Otherwise, break the loop
            }
            arr.get(i).correct = true;
        }

        for (var bar : arr) {
            bar.correct = false;
        }
    }

    public static void pause(int delay) {
        long s = System.nanoTime();
        long t = s + delay;
        while (System.nanoTime() < t);
//        try {
//            Thread.sleep(0, delay);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
    }
}
