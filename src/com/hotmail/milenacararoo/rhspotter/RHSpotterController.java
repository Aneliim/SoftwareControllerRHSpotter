package com.hotmail.milenacararoo.rhspotter;

import java.net.URL;

//import br.com.spotdev.robotcontroller.Comunicacao;
//import br.com.spotdev.robotcontroller.RHSpotter;
//import br.com.spotdev.robotcontroller.communication.RequestCallback;
//import br.com.spotdev.robotcontroller.communication.exceptions.ConnectionException;
/*-----------------------------------------*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RHSpotterController extends Application {

	/**
	 *  MÉTODO MAIN
	 */
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		
		URL arquivoFXML = getClass().getResource( "./fxml/home.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		
		/*Adicionando icon a janela*/
		palco.getIcons().add(new Image("/com/hotmail/milenacararoo/rhspotter/fxml/icon.png"));
;		
		palco.setScene(new Scene(fxmlParent, 905, 533));
		palco.setTitle("Controller RHSpotter");
		palco.show();	
	}
}


