package real;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		try {
			soundMap.put("buy_sound", new Sound("res/sounds/switch25.ogg"));
			soundMap.put("buy_denied", new Sound("res/sounds/buy_denied.ogg"));
			soundMap.put("exam_sound", new Sound("res/sounds/exam_sound.ogg"));


			musicMap.put("music", new Music("res/sounds/backgroundMusic.ogg"));

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
}
