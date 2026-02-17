/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingalgorithmapp;

import java.io.File;
import javax.sound.sampled.*;


/**
 *
 * @author Exilation
 */
public class SoundEffect {
    
    Clip clip;
    
    private AudioFormat getOutFormat(AudioFormat inFormat, int pitch, int n) {
        int ch = inFormat.getChannels();
        float rate = inFormat.getSampleRate();  
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 1300 + (pitch*1350)/n, 16, ch, ch * 2, rate,
            inFormat.isBigEndian());
    }
    
    public void setFile(String soundFileName, int pitch, int n) {
        try {
            File file = new File(soundFileName);
            AudioInputStream s = AudioSystem.getAudioInputStream(file);
            AudioFormat inFormat = getOutFormat(s.getFormat(), pitch, n);
            AudioInputStream sound = AudioSystem.getAudioInputStream(inFormat, s);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            
        }
    }
    
    public void play() {
        if (!clip.isActive()) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
}
