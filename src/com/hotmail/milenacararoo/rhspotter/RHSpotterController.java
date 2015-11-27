package com.hotmail.milenacararoo.rhspotter;

import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.hotmail.milenacararoo.rhspotter.controllers.HomeController;
import com.mechani.robotcontroller.Comunicacao;
import com.mechani.robotcontroller.RHSpotter;
import com.mechani.robotcontroller.communication.RequestCallback;
import com.mechani.robotcontroller.communication.exceptions.ConnectionException;
import com.mechani.robotcontroller.communication.exceptions.RobotError;








/*-----------------------------------------*/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RHSpotterController extends Application {

	public static RHSpotter RHSPOTTER = null;
	
	/**
	 *  MÉTODO MAIN
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		Application.launch(RHSpotterController.class);
	}

	@Override
	public void start(Stage palco) throws Exception {
		
		URL arquivoFXML = getClass().getResource( "./fxml/home.fxml");
		FXMLLoader loader = new FXMLLoader(arquivoFXML);
		Parent fxmlParent = (Parent)loader.load();
		
		/*Adicionando icon a janela*/
		palco.getIcons().add(new Image("/com/hotmail/milenacararoo/rhspotter/fxml/icon.png"));
		
		palco.setScene(new Scene(fxmlParent, 905, 533));
		palco.setTitle("Controller RHSpotter");
		palco.show();	
		
		HomeController controller = loader.getController();		
		controller.tentarConectar();
			
	}
		
	
}


