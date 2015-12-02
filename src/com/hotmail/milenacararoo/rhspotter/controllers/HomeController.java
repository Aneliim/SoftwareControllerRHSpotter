package com.hotmail.milenacararoo.rhspotter.controllers;

import javax.swing.JOptionPane;

import com.hotmail.milenacararoo.rhspotter.RHSpotterController;
import com.mechani.robotcontroller.Comunicacao;
import com.mechani.robotcontroller.RHSpotter;
import com.mechani.robotcontroller.communication.RequestCallback;
import com.mechani.robotcontroller.communication.exceptions.ConnectionException;
import com.mechani.robotcontroller.communication.exceptions.RequestException;
import com.mechani.robotcontroller.communication.exceptions.RobotError;
import com.mechani.robotcontroller.tools.Camera;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {
	/**
	 * 												SELECIONAR PORTA COM
	 */
	//Janela que possui a combobox
	@FXML AnchorPane panelSelecionarPorta;
	//Combobox para escolher a porta
	@FXML ComboBox comboBoxSelecionePorta;
	
	/**---------------------------------------------------------------------------------------------
	 * 											Tela realizando comunica��o com o rob�
	 * */
	@FXML AnchorPane panelRelizandoComunicacao;
	public void realizandoComunicacao(){
		panelRelizandoComunicacao.setVisible(true);
		panelErro.setVisible(false);
	}
	//														Tela erro na comunica��o
	@FXML
	AnchorPane panelErro;
	public void erroComunicacao(){
		panelErro.setVisible(true);
		panelRelizandoComunicacao.setVisible(false);
	}
	//																Bot�o da tela de erro "Realizar Comunica��o Novamente"
	@FXML Button btnTentarNovamente;
	public void realizarComunicacaoNovamente(){
		panelRelizandoComunicacao.setVisible(true);
		panelErro.setVisible(false);
		//Realiza comunica��o novamente
		tentarConectar();
	}
	
	/*M�todo usado acima para conectar*/

	public void tentarConectar(){
		HomeController home = this;
		new Thread(new Runnable() {
		
			@Override
			public void run() {
				Comunicacao comunicacao = new Comunicacao();
				// abre o painel de carregamento para se conectar no robo

				try {
					comunicacao.iniciar(new RequestCallback() {
						
						@Override
						public void success(RHSpotter rhspotter) {
		
							RHSpotterController.RHSPOTTER = rhspotter;
							Platform.runLater(()->panelRelizandoComunicacao.setVisible(false));

						}
						
						@Override
						public void error(String message, RobotError error) {

							if(error == RobotError.ROBOT_CONNECTION){
								
								Platform.runLater(()->home.erroComunicacao());
									
							}
						}
					});
				} catch (ConnectionException e) {
					e.printStackTrace();
					comunicacao.getPorta().closePort();
					
					Platform.runLater(()->home.erroComunicacao());
				}
			}
		}).start();
	}
	
	//-----------------------------------------------------------------------------------------------
	/**
	 * 													Panel c�mera n�o conectada
	 */
	@FXML
	AnchorPane panelCameraDesconectada;
	public void cameraDesconectada(){
		//Panel camera desativada
		panelCameraDesconectada.setVisible(true);
		//Panel imagens fornecidas pela cam�ra desativado
		panelImagenDesativado.setVisible(false);
		
	}
	/**********************************************************************
	 * 										MENU INICIAL
	 ***********************************************************************/
						
	/*Menu*/
	@FXML
	AnchorPane panelMenuInicial;
	
	/**
	 * 								ABRIR MENU INICIAL
	 */
	
	/* Bot�o */
	@FXML
	AnchorPane btnAbrirMenuInicial;
	/* Bal�o */
	@FXML
	AnchorPane balaoMenu;

	/* M�todo */
	public void abrirMenuInicial() {
		/* Deixa o menu inicial visivel */
		panelMenuInicial.setVisible(true);

		/* Desabilita cot�o de abrir menu inicial */
		btnAbrirMenuInicial.setVisible(false);

		/* Desabilita o bal�o instru��o do menu */
		balaoMenu.setVisible(false);
	}

	/**
	 *  									FECHAR MENU INICIAL 
	 *  */
	/* Bot�o */
	@FXML
	AnchorPane btnFecharMenuInicial;

	/* M�todo */
	public void fecharMenuInicial() {
		panelMenuInicial.setVisible(false);
		btnAbrirMenuInicial.setVisible(true);
	}

	/***********************************************************************/
	/* --------------------------------------------------------------------------------------------
	 * 					BOT�ES DE ATIVAR E DESATIVAR DO MENU INCIAL
	 ----------------------------------------------------------------------------------------------*/
	
	/*
	 * 									LANTERNA - ATIVAR E DESATIVAR
	 */
	/* Bot�o ativar */
	@FXML
	Button btnAtivarLanterna;
	/* Bot�o desativar */
	@FXML
	Button btnDesativarLanterna;

	/* M�todo ativar */
	public void ativarLanterna() {
		btnDesativarLanterna.setVisible(true);
		btnAtivarLanterna.setVisible(false);
		
		// PARA ATIVAR A LANTERNA
		RHSpotterController.RHSPOTTER.setLanterna(true);

	}

	/* M�todo desativar */
	public void desativarLanterna() {
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		
		// PARA DESATIVAR A LANTERNA
		RHSpotterController.RHSPOTTER.setLanterna(false);

	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 * 									C�MERA - ATIVAR E DESATIVAR 
	 */
	/* Bot�o ativar */
	@FXML Button btnAtivarCamera;
	/* Bot�o desativar */
	@FXML Button btnDesativarCamera;
	/*Panel de aviso de envio de imagens desativada*/
	@FXML AnchorPane panelImagenDesativado;
	/*Panel para c�mera desconctada*/
	@FXML AnchorPane panelCameraDesconectada;
	/* M�todo ativar */
	public void ativarCamera() {
		/*Interface bot�o*/

		btnDesativarCamera.setVisible(true);
		btnAtivarCamera.setVisible(false);

		// PARA ATIVAR A C�MERA
		panelImagenDesativado.setVisible(false);
		panelCameraDesconectada.setVisible(true);
		//Mostra que a c�mera esta esta conectada
		if(RHSpotterController.RHSPOTTER.getCamera() == null)
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel se conectar a c�mera do rob�...",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		else
			panelImagenDesativado.getChildren().add(RHSpotterController.RHSPOTTER.getCamera().generatePanel());
	}
	
	/* M�todo desativar */
	public void desativarCamera() {
		btnAtivarCamera.setVisible(true);
		btnDesativarCamera.setVisible(false);

		// PARA DESATIVAR A C�MERA
		if(RHSpotterController.RHSPOTTER.getCamera() == null)
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel se conectar a c�mera do rob�...",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		else
			panelImagenDesativado.getChildren().add(RHSpotterController.RHSPOTTER.getCamera().generatePanel());
			

	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 *  									INSTRU��O - ATIVAR E DESATIVAR 
	 */
	/* Bot�o ativar */
	@FXML
	Button btnAtivarInstrucao;
	/* Bot�o desativar */
	@FXML
	Button btnDesativarInstrucao;
	
	/**
	 * 										BAL�ES DE INSTRU��O
	 *  */
	/* Locomo��o */
	@FXML
	AnchorPane balaoLocomocaoRobo;
	/* C�mera */
	@FXML
	AnchorPane balaoCamera;

	/* M�todo ativar */
	public void ativarInstrucao() {
		btnDesativarInstrucao.setVisible(true);
		btnAtivarInstrucao.setVisible(false);
		// PARA ATIVAR A INSTRU��O
		balaoLocomocaoRobo.setVisible(true);
		balaoCamera.setVisible(true);
	}

	/* M�todo desativar */
	public void desativarInstrucao() {
		btnAtivarInstrucao.setVisible(true);
		btnDesativarInstrucao.setVisible(false);
		// PARA DESATIVAR A INSTRU��O
		balaoLocomocaoRobo.setVisible(false);
		balaoCamera.setVisible(false);
		balaoMenu.setVisible(false);
	}

	/*-------------------------------------------------------------------------------------------------*/
	/**********************************************************************
	 * 										MENU GALERIA
	 ***********************************************************************/
	/* Menu */
	@FXML
	AnchorPane panelMenuGaleria;

	/**
	 *  							ABRIR MENU GALERIA 
	 */
	/* Bot�o */
	@FXML
	AnchorPane btnAbrirGaleria;

	/* M�todo */
	public void abrirMenuGaleria() {
		panelMenuInicial.setVisible(false);
		panelMenuGaleria.setVisible(true);
	}

	/**
	 * 							 FECHAR MENU GALERIA 
	 */
	/* M�todo */
	public void fecharMenuGaleria() {
		panelMenuGaleria.setVisible(false);
		panelMenuInicial.setVisible(true);
	}
	/**********************************************************************/
	/* --------------------------------------------------------------------------------------------
	 * 										SUBMENUS DO MENU GALERIA
	 ----------------------------------------------------------------------------------------------*/
	/**
	 * 								GALERIA - PANEL FOTOS E V�DEOS
	*/
	/* Panel fotos */
	@FXML AnchorPane panelFotos;
	/* Panel videos */
	@FXML AnchorPane panelVideos;


	/**
	 * 									 ABRIR PANEL FOTOS 
	 */
	/* Bot�o */
	@FXML
	AnchorPane btnAbrirPanelFotos;

	/* M�todo */
	public void abrirPanelFotos() {
		panelFotos.setVisible(true);
		panelVideos.setVisible(false);
	}

	/**
	 * 											ABRIR PANEL V�DEOS 
	 */
	/* Bot�o */
	@FXML
	AnchorPane btnAbrirPanelVideos;

	/* M�todo */
	public void abrirPanelVideos() {
		panelVideos.setVisible(true);
		panelFotos.setVisible(false);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										BOT�ES DE A��ES DE IMAGENS
	 ----------------------------------------------------------------------------------------------*/
	/**
	 *  											VISUALIZA IMAGEM 
	 */

	/* Bot�o */
	@FXML
	Button btnVisualizaImagem;
	/* Panel */
	@FXML
	AnchorPane panelVisualizaImagem;

	/* M�todo */
	public void visualizaImagem() {
		panelVisualizaImagem.setVisible(true);
	}

	/**
	 *  								FECHAR VISUALIZA��O IMAGEM 
	* /
	/* Bot�o */
	@FXML
	AnchorPane btnFecharPanelImagem;

	public void fecharPanelImagem() {
		panelVisualizaImagem.setVisible(false);
	}

	/**
	 * 											 EXCLUI IMAGEM 
	 */
	/* Bot�o */
	@FXML
	Button btnExcluirImagem;
	/* Panel */
	@FXML
	AnchorPane panelExcluirImagem;

	/* M�todo */
	public void excluirImagem() {
		panelExcluirImagem.setVisible(true);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										PANEL EXCLUI IMAGEM - SIM OU N�O
	 ----------------------------------------------------------------------------------------------*/
	/**
	 * 												SIM EXCLUIR IMAGEM
	 */
	/* Bot�o */
	@FXML
	Button btnExcluirImagemSim;

	/* M�todo */
	public void excluirImagemSim() {

	}

	/**
	 * 												N�O EXCLUIR IMAGEM
	 */
	@FXML
	Button btnExcluirImagemNao;

	/* M�todo */
	public void excluirImagemNao() {
		panelExcluirImagem.setVisible(false);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										BOT�ES DE A��ES DE V�DEOS
	 ----------------------------------------------------------------------------------------------*/

	/**
	 * 												VISUALIZA V�DEOS 
	 */
	/* Bot�o */
	@FXML
	Button btnVisualizaVideo;
	/* Panel */
	@FXML AnchorPane panelVisualizaVideo;

	/* M�todo */
	public void visualizaVideo() {
		panelVisualizaVideo.setVisible(true);
	}

	/**
	 *  									FECHAR VISUALIZA��O DE V�DEO 
	 */
	/* Bot�o */
	@FXML AnchorPane btnFecharPanelVideo;

	/* M�todo */
	public void fecharPanelVideo() {
		panelVisualizaVideo.setVisible(false);
	}

	/**
	 * 													EXCLUI V�DEOS 
	 */
	/* Bot�o */
	@FXML Button btnExcluirVideo;
	/* Panel */
	@FXML AnchorPane panelExcluirVideo;

	/* M�todo */
	public void excluirVideo() {
		panelExcluirVideo.setVisible(true);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										PANEL EXCLUI V�DEO - SIM OU N�O
	 ----------------------------------------------------------------------------------------------*/

	/**
	 * 														SIM EXCLUIR V�DEO
	 */
	/* Bot�o */
	@FXML Button btnExcluirVideoSim;

	/* M�todo */
	public void excluirVideoSim() {

	}

	/*
	 * 													N�O EXCLUIR V�DEO
	 */
	@FXML Button btnExcluirVideoNao;


	/* M�todo */
	public void excluirVideoNao() {
		panelExcluirVideo.setVisible(false);
	}

	/*-------------------------------------------------------------------------------------------------*/

	/*********************************************************************************
	 *  									BOT�ES DE CONTROLE DO ROB� 
	 ***********************************************************************************/

	/**
	 * 												MOVE PARA FRENTE 
	 */
	/* Bot�o */
	@FXML Button btnMoveParaFrenteRobo;

	/* ON MOUSE PRESSED */
	public void moveParaFrentePressed() {
		RHSpotterController.RHSPOTTER.getMove().frente();

	}

	/**
	 * 													MOVE PARA TR�S 
	 */
	/* Bot�o */
	@FXML Button btnMoveParaTrasRobo;

	/*ON MOUSE PRESSED */
	public void moveParaTrasPressed() {
		RHSpotterController.RHSPOTTER.getMove().atras();
	}
	

	/**
	 * 													GIRA PARA DIREITA 
	 */
	/* Bot�o */

	@FXML
	Label btnGiraParaDireitaRobo;

	/* M�todo */
	public void giraParaDiretaRobo() {
		RHSpotterController.RHSPOTTER.getMove().girarDireita();
	}

	/**
	 * 												GIRA PARA ESQUERDA 
	 */
	/* Bot�o */

	@FXML
	Label btnGiraParaEsquerdaRobo;

	/* M�todo */
	public void giraParaEsquerdaRobo() {
		RHSpotterController.RHSPOTTER.getMove().girarEsquerda();
	}

	/**
	 * 													PARAR O ROB� 
	 */
	/* Bot�o */

	@FXML
	Label btnPararRobo;

	/* M�todo */
	public void pararRobo() {
		RHSpotterController.RHSPOTTER.getMove().parar();
	}

	/******************************************************************/
	
	/***************************************************************************
	 * 								BOT�ES DE CONTROLE DA C�MERA 
	 ***************************************************************************/

	/**
	 * 													MOVE PARA CIMA 
	 */
	/* Bot�o */
	@FXML Button btnMoveParaCimaCamera;

	/* ON MOUSE PRESSED */
	public void moveParaCimaPressed() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.paraCima();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A c�mera esta desconectada", 
					"Problema com a c�mera", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*ON MOUSE RELEASED*/
	public void moveParaCimaReleased() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.parar();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A c�mera esta desconectada", 
					"Problema com a c�mera", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 												MOVE PARA BAIXO 
	 */
	/* Bot�o */
	@FXML Button btnMoveParaBaixoCamera;

	/* ON MOUSE PRESSED */
	public void moveParaBaixoPressed() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.paraCima();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A c�mera esta desconectada", 
					"Problema com a c�mera", JOptionPane.ERROR_MESSAGE);
		}	
	}
	/*ON MOUSE RELEASED*/
	public void moveParaBaixoReleased() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.parar();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A c�mera esta desconectada", 
					"Problema com a c�mera", JOptionPane.ERROR_MESSAGE);
		}

	}

	/******************************************************************/
	/*-----------------------------------------------------------------------------------
	 * 										TIRAR FOTOS E GRAVAR V�DEOS 
	 -------------------------------------------------------------------------------------*/
	/* Bot�o */
	@FXML
	Label btnCapturaImagens;

	/**
	 * 													TIRA FOTO 
	 */
	/* M�todo */
	public void tiraFoto() {
		
	}

	/**
	 * 													GRAVA VIDEO 
	 */
	/* M�todo */
	public void gravaVideo() {

	}
	/*--------------------------------------------------------------------------------------------*/

}

