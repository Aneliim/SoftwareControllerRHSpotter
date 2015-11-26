package com.hotmail.milenacararoo.rhspotter;

import java.net.URL;

import br.com.spotdev.robotcontroller.Comunicacao;
import br.com.spotdev.robotcontroller.RHSpotter;
import br.com.spotdev.robotcontroller.communication.RequestCallback;
import br.com.spotdev.robotcontroller.communication.exceptions.ConnectionException;
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
		Comunicacao comunicacao = new Comunicacao("COM8");
		// abre o painel de carregamento para se coenctar no robo
		try {
			comunicacao.iniciar(new RequestCallback() {
				
				@Override
				public void success(RHSpotter rhspotter) {
					// TODO Auto-generated method stub
					// aqui chama quando conecta
					// conectado com sucesso, pode fechar o painel
				}
				
				@Override
				public void error(String mensagem) {
					// TODO Auto-generated method stub
					// Aqui chama quando qu você não se conecta com o robo
					// erro ao se conectar, omostrar mensagem
					System.out.println(mensagem);
				}
			} );
		} catch (ConnectionException e) {
			// Aqui e chamado quando voce não consegue conectar o modulo no seu computador direito
			e.printStackTrace();
		}
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


