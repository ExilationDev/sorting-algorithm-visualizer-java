/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import java.awt.*;
import java.util.ArrayList;

public class BarList {
    
    public static ArrayList<BarObject> list = new ArrayList<>();
    
    static int w;
    static int h;
    static int xOff = 40;
    static int yOff = -20;
    
    public static int sortDelay = 0;
    
    public BarList(int n, int w, int h) {
        this.w = w;
        this.h = h;
        // Start Adding Bars
        for (var i = 1; i <= n; i++) {
            BarObject bar = new BarObject(
                    (int)Math.ceil((w - 100)/(double)n),
                    -i * (h-200)/n,
                    (i-1) * (w - 100)/n + xOff,
                    (h - 60) + yOff,
                    i,
                    n
            );
            list.add(bar);
        }
        //list.get(50).selected = true;
    }
    
    public static void UpdateList() {
        var n = list.size();
        for (var i = 1; i <= n; i++) {
            list.get(i-1).SetPosition((i-1) * (w - 100)/n + xOff, (h - 60) + yOff);
        }
    }
    
    void Shuffle() {
        sortDelay = 10000000;
        ShuffleAlgorithm.ShuffleList(list, sortDelay);
    }
    
    void Sort() {
        sortDelay = 10000000;
        SortingAlgorithm.SortList(list, sortDelay);
    }
    
    public void UpdateInputs(KeyHandler kh) {
        if (kh.QPressed && !ShuffleAlgorithm.isShuffling && !SortingAlgorithm.isSorting){
            Shuffle();
        } else if (kh.WPressed && !ShuffleAlgorithm.isShuffling && !SortingAlgorithm.isSorting) {
            Sort();
        }
    }
    
    public void DrawBars(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        //g2d.fillRect(20, 20, 5, 5);
        for (var i = 0; i < list.size(); i++){
            list.get(i).draw((Graphics2D)g);
        }
    }
}
