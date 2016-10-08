package cr.tec.yatg.desktop.services;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Created by joseph on 10/8/16.
 */
public class MusicPlayer {
	private static MusicPlayer ourInstance = new MusicPlayer();
	MediaPlayer actual;

	private MusicPlayer() {
	}

	public static MusicPlayer getInstance() {
		return ourInstance;
	}

	public void play(String path) {
		if (actual != null) {
			actual.stop();
			actual = null;
		}
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer actual = new MediaPlayer(media);
		//actual.setOnEndOfMedia(() -> actual.seek(Duration.ZERO));
		actual.play();
	}
}
