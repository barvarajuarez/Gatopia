package graphics;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(Clip clip){
        this.clip = clip;
    }

    public void infiniteLoop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    public void Play(int frames){
        if(clip != null) {
            clip.setFramePosition(frames);
            clip.start();
        }
    }


    public void setVolume(double volume) {
        if (clip != null) {
            // Obtener el control de volumen
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Ajustar el volumen (-80.0f es el valor mínimo, 6.0f es el valor máximo)
            //o yo estoy muy sorda idk
            float adjustedVolume = (float) (Math.log10(volume) * 20.0);
            gainControl.setValue(adjustedVolume);
        }
    }

    public void stopPlayback() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
