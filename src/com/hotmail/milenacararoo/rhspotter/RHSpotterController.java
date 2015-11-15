package com.hotmail.milenacararoo.rhspotter;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RHSpotterController extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		
		URL arquivoFXML = getClass().getResource( "./fxml/home.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		palco.setScene(new Scene(fxmlParent, 1000, 600));
		palco.setTitle("RHSpotter Controller");
		palco.show();	
	}
}


