package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.MusicPlayer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main GUI controller
 * Created by daniel on 29/09/16.
 */
public class Splash {

	@FXML
	Button playButton;

	@FXML 
	private void pressPlay() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/views/login.fxml"));
			Parent mainScreen = fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Yet Another Tron Game");
			stage.setResizable(false);
			stage.setScene(new Scene(mainScreen));

			Stage mainStage = (Stage) playButton.getScene().getWindow();
			mainStage.close();

			stage.setOnCloseRequest(e -> {
				Platform.exit();
				System.exit(0);
			});
			stage.show();
			MusicPlayer.play("src/cr/tec/yatg/desktop/resources/music/title.mp3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
