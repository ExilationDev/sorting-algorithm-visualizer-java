/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortingalgorithmapp;

import javax.swing.*;
import java.awt.*;

public class SortingAlgorithmApp {
    
    static KeyHandler kh = new KeyHandler();
    static JLabel sortName = new JLabel("Bubble Sort");
    static JLabel sortStats = new JLabel();
    
    public static void main(String[] args) {
        SetUp("Sorting Algorithm Visualizer by ExilationDev", 1280, 720);
        System.out.println("init");
    }
    
    public static void SetUp(String appName, int w, int h) {
        JFrame frame = new JFrame(appName);
        frame.setSize(w, h);
        
        frame.addKeyListener(kh);
        
        ObjectDraw panel = new ObjectDraw(kh, w, h);
        panel.setLayout(null);
        
        sortName.setFont(new Font("Courier New", Font.BOLD, 22));
        sortName.setForeground(Color.white);
        sortName.setHorizontalAlignment(SwingConstants.LEFT);
        sortName.setBounds(40, frame.getHeight() - 85, 450, 40);
        
        sortStats.setFont(new Font("Courier New", Font.BOLD, 12));
        sortStats.setForeground(Color.white);
        sortStats.setHorizontalAlignment(SwingConstants.RIGHT);
        sortStats.setBounds(frame.getWidth() - 510, frame.getHeight() - 85, 450, 40);
        
        panel.add(sortName);
        panel.add(sortStats);
        
        frame.add(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void UpdateLabel(String name, int arrSize, int delay) {
        sortName.setText(name);
        sortStats.setText(String.format("<html><body><p style=\"text-align:right;\">Array Size: %s<br>Sort Delay: %2$sms</p></body></html>", arrSize, delay / 1E6));
    }
}
