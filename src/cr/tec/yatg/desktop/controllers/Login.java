package cr.tec.yatg.desktop.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.regex.Pattern;

/**
 * Main GUI controller
 * Created by daniel on 1/10/16.
 */

public class Login {
	private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	String playerUsername;
	String playerIp;
	String checkPort;
	int playerPort;
	@FXML
	private Button loginButton;
	@FXML
	private TextField getUsername;
	@FXML
	private TextField getIp;
	@FXML
	private TextField getPort;

	private static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private static boolean validIp(final String ip) {
		return PATTERN.matcher(ip).matches();
	}

	@FXML
	private void pressLogin() {
		try {
			checkPort = getPort.getText().trim();
			playerUsername = getUsername.getText().trim();
			playerIp = getIp.getText().trim();


			if (playerIp.length() != 0 && checkPort.length() != 0 && playerUsername.length() != 0 && isNumeric(checkPort) && validIp(playerIp)) {
				try {
					playerPort = Integer.parseInt(checkPort);
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR:");
					alert.setHeaderText("Please fill the required data");
					alert.setContentText("Example: \n	Username: HailHarambe69 \n	IP: 292.168.1.2 \n	Port: 9697 ");
					alert.showAndWait();
				}
				if (0 <= playerPort & playerPort <= 9999) {
					System.out.println("Entered Username: " + getUsername.getText());
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/views/main.fxml"));
					Parent mainScreen = fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle("Yet Another Tron Game");
					stage.setResizable(false);
					stage.setScene(new Scene(mainScreen));

					Stage mainStage = (Stage) loginButton.getScene().getWindow();
					mainStage.close();

					stage.setOnCloseRequest(e -> {
						Platform.exit();
						System.exit(0);
					});
					stage.show();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR:");
					alert.setHeaderText("Please checkout the port");
					alert.setContentText("Insert a port between 0 and 9999");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR:");
				alert.setHeaderText("Please fill the required data");
				alert.setContentText("Example: \n	Username: HailHarambe69 \n	IP: 292.168.1.2 \n	Port: 9697 ");
				alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
