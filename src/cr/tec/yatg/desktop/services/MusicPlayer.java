package cr.tec.yatg.desktop.services;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

/**
 * Created by joseph on 10/8/16.
 */
public class MusicPlayer {
	static MediaPlayer actual;
	private static MusicPlayer ourInstance = new MusicPlayer();

	private MusicPlayer() {
	}

	public static void play(String path) {
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer actual = new MediaPlayer(media);
		actual.setOnEndOfMedia(() -> actual.seek(Duration.ZERO));
		actual.play();
	}
}
