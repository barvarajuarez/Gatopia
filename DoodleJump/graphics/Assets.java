package graphics;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

public class Assets {
    public static BufferedImage doodle;
    public static BufferedImage doodle2;
    public static BufferedImage background0;
    public static BufferedImage background1;
    public static BufferedImage background2;
    public static BufferedImage background3;
    public static BufferedImage CharacterSelect;
    public static BufferedImage platform;
    public static BufferedImage platform2;
    public static BufferedImage buttonOut;
    public static BufferedImage buttonIn;
    public static BufferedImage tittle;
    public static BufferedImage[] bango = new BufferedImage[10];


    public static Clip BackgroundMusic;
    public static Clip GameplayMusic;
    public static Clip Jump;
    public static Clip Falling; //for ya
    public static Clip Click;
    public static Clip select; //round 1 fight haduken  


    //se llama cuando el juego arranca
    public static void init(){
        //Image
        doodle = Loader.ImageLoader("Sprites/doodle.png");
        doodle2 = Loader.ImageLoader("Sprites/doodle2.png");
        background0 = Loader.ImageLoader("Sprites/background0.png");
        background1 = Loader.ImageLoader("Sprites/background1.png");
        background2 = Loader.ImageLoader("Sprites/background2.png");
        background3 = Loader.ImageLoader("Sprites/background3.png");
        platform = Loader.ImageLoader("Sprites/platform.png");
        platform2 = Loader.ImageLoader("Sprites/platform2.png");
        buttonIn = Loader.ImageLoader("Sprites/blue_button13.png");
        buttonOut = Loader.ImageLoader("Sprites/blue_button00.png");
        CharacterSelect = Loader.ImageLoader("Sprites/SelectChar.png");
        tittle = Loader.ImageLoader("Sprites/title.png");
        
        for(int i = 0; i <= 9; i++){
            String num = "Sprites/" + i +".png";
            bango[i] = Loader.ImageLoader(num);
        }

        //sound
        GameplayMusic = Loader.loadSound("Audio/gameplay.wav");
        Jump = Loader.loadSound("Audio/salto.wav");
        Falling = Loader.loadSound("Audio/falling.wav");
        BackgroundMusic = Loader.loadSound("Audio/menu.wav");
        select = Loader.loadSound("Audio/select.wav");
    }
    
}
