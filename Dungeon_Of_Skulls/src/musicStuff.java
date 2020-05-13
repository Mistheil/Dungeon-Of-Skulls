import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class musicStuff {
	void playMusic (String musicLocation) {  //To Open Audio to the code
		try {
			File musicPath = new File (musicLocation);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {System.out.println("Can't find file");}
		}
		catch (Exception ex) {ex.printStackTrace();}
	}

}
