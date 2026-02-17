/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import javax.swing.*;
import java.awt.*;

public class ObjectDraw extends JPanel implements Runnable {
    
    public static ObjectDraw instance;
            
    int FPS = 60;
    Thread gameThread;
    
    BarList barList;
    KeyHandler KeyH;
    
    public static String sortName = "nil";
    public static int numOfArr = 0;
    public static int delay = 0;
    
    public ObjectDraw(KeyHandler kh, int w, int h) {
        barList = new BarList(512, w, h);
        numOfArr = barList.list.size();
        this.setBackground(Color.BLACK);
        instance = this;
        KeyH = kh;
        ObjectDraw.Refresh();
        
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long LastTime = System.nanoTime();
        long CurrentTime;
        long Timer = 0;
        int DrawCount = 0;
        
        while(gameThread != null) {     
            CurrentTime = System.nanoTime();
            
            delta += (CurrentTime - LastTime) / drawInterval;
            Timer += (CurrentTime - LastTime);
            LastTime = CurrentTime;
            
            if(delta > 0) {
                update();
                delta--;
                DrawCount++;         
            }
            if(Timer >= 1000000000) {
                System.out.println("FPS: " + DrawCount);
                DrawCount = 0;
                Timer = 0;
            }
        }
    }
    
    void update() {
        instance.repaint();
        //instance.revalidate();
        //instance.Refresh();
        //barList.UpdateList();
        barList.UpdateInputs(KeyH);
    }
    
    public static void Refresh() {
        instance.repaint();
        //instance.revalidate();
        BarList.UpdateList();
        SortingAlgorithmApp.UpdateLabel(sortName, numOfArr, BarList.sortDelay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        barList.DrawBars(g);
    }
}
