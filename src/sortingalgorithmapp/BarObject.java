/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import java.awt.*;

/**
 *
 * @author Exilation
 */
public class BarObject {
    
    double width;
    double height;
    double x;
    double y;
    
    public int value;
    public boolean selected = false;
    public boolean correct = false;
    
    SoundEffect se = new SoundEffect();
    public int n;
    
    public BarObject(double w, double h, double x, double y, int value, int n) {
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        this.n = n;
        
        this.value = value;
        se.setFile(".//res//bip3.wav", value, n);
        
        // System.out.printf("x: %1$d, y: %2$d, width: %3$d, height: %4$d\n", (int)Math.ceil(x), (int)Math.ceil(y), (int)width, (int)height);
    }
    
    public void SetPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        if (selected) {
            g.setColor(Color.RED);
            se.play();
        }
        else if (correct) g.setColor(Color.GREEN);
        else g.setColor(Color.WHITE);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.fillRect((int)Math.ceil(x), (int)Math.ceil(y+height), (int)width, -1*(int)height);
        //System.out.printf("x: %1$d, y: %2$d, width: %3$d, height: %4$d\n", (int)Math.ceil(x), (int)Math.ceil(y), (int)width, (int)height);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
