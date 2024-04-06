package project.bomberman;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    private Clip clip;
    File sound = new File(Game.RESOURCES_PREFIX + "bomberman-theme.wav");

    public void playSound() {
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopSound() {
        try{
            clip.stop();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
