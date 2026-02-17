/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Exilation
 */
public class ShuffleAlgorithm {

    public static boolean isShuffling = false;

    public static void ShuffleList(ArrayList<BarObject> arr, int delay) {
        ObjectDraw.sortName = "Fisher-Yates Shuffle";
        int n = arr.size();
        isShuffling = true;
        randomize(arr, n, delay);
        isShuffling = false;
    }

    static void randomize(ArrayList<BarObject> arr, int n, int delay) {
        // Creating a object for Random class
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int j = r.nextInt(i + 1);
            BarObject temp = arr.get(i);

            arr.get(i).selected = true;
            arr.get(j).selected = true;

            pause(delay);
            ObjectDraw.Refresh();

            arr.set(i, arr.get(j));
            arr.set(j, temp);

            pause(delay);
            ObjectDraw.Refresh();

            arr.get(i).selected = false;
            arr.get(j).selected = false;
        }
    }

    static void pause(int delay) {
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
