
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	
	public static synchronized void playSound(final String url) {
		
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        Main.class.getResourceAsStream( url));
		        clip.open(inputStream);
		        FloatControl volume= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		        volume.setValue(-10);//volume control
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    
		    }
		  }).start();
		}
	
	
}

