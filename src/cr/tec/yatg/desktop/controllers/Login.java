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

/**
 * Main GUI controller
 * Created by daniel on 1/10/16.
 */

public class Login {
	@FXML
	private Button loginButton;
	
	@FXML
	private TextField getUsername;
	
	@FXML
	private TextField getIp;
	
	@FXML
	private TextField getPort;
	
	String playerUsername;
	
	String playerIp;
	
	String checkPort;

	int playerPort;
	@FXML 
	private void pressLogin(){
		try {
			checkPort = getPort.getText();
            playerUsername=getUsername.getText();
			playerIp=getIp.getText();
			if (checkPort != "" & playerUsername !="" & playerIp !=""){
				playerPort = Integer.parseInt(checkPort);
				if (0 <= playerPort & playerPort <= 9999){
					System.out.println("Entered Username: "+getUsername.getText());
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
			
	
			
				}
				} }catch (Exception e) {
			e.printStackTrace();
		}
	}
}
