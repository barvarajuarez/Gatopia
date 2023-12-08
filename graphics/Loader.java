package graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.IOException;

public class Loader {
    public static BufferedImage ImageLoader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading sound from path: " + path);
        }
        
        return null;
    }

    public static Clip loadSound(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Loader.class.getResourceAsStream(path)));
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading sound from path: " + path);
        }
    
        return null;
    }
    
}

