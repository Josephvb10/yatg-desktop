package cr.tec.yatg.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("resources/views/login.fxml"));
		primaryStage.setTitle("YATG 1.0");
		primaryStage.setScene(new Scene(root, 880, 680));
		primaryStage.setResizable(false);
		primaryStage.show();
		//MusicPlayer.getInstance().play("src/cr/tec/yatg/desktop/resources/music/starman.mp3");


	}
}

