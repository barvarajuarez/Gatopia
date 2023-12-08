package graphics;


//hilo para ejecutar la música de fondo
public class MusicPlayer implements Runnable {
    private AudioPlayer Ost;
    private boolean isPlaying = true;

    public MusicPlayer(AudioPlayer ost) {
        this.Ost = ost;
    }

    @Override
    public void run() {
        Ost.infiniteLoop();
    }

    public void stop() {
        if (isPlaying) {
            Ost.stopPlayback();
        } 
        isPlaying = false;
    }
    
}