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
	 * 											Tela realizando comunicação com o robô
	 * */
	@FXML AnchorPane panelRelizandoComunicacao;
	public void realizandoComunicacao(){
		panelRelizandoComunicacao.setVisible(true);
		panelErro.setVisible(false);
	}
	//														Tela erro na comunicação
	@FXML
	AnchorPane panelErro;
	public void erroComunicacao(){
		panelErro.setVisible(true);
		panelRelizandoComunicacao.setVisible(false);
	}
	//																Botão da tela de erro "Realizar Comunicação Novamente"
	@FXML Button btnTentarNovamente;
	public void realizarComunicacaoNovamente(){
		panelRelizandoComunicacao.setVisible(true);
		panelErro.setVisible(false);
		//Realiza comunicação novamente
		tentarConectar();
	}
	
	/*Método usado acima para conectar*/

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
	 * 													Panel câmera não conectada
	 */
	@FXML
	AnchorPane panelCameraDesconectada;
	public void cameraDesconectada(){
		//Panel camera desativada
		panelCameraDesconectada.setVisible(true);
		//Panel imagens fornecidas pela camêra desativado
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
	
	/* Botão */
	@FXML
	AnchorPane btnAbrirMenuInicial;
	/* Balão */
	@FXML
	AnchorPane balaoMenu;

	/* Método */
	public void abrirMenuInicial() {
		/* Deixa o menu inicial visivel */
		panelMenuInicial.setVisible(true);

		/* Desabilita cotão de abrir menu inicial */
		btnAbrirMenuInicial.setVisible(false);

		/* Desabilita o balão instrução do menu */
		balaoMenu.setVisible(false);
	}

	/**
	 *  									FECHAR MENU INICIAL 
	 *  */
	/* Botão */
	@FXML
	AnchorPane btnFecharMenuInicial;

	/* Método */
	public void fecharMenuInicial() {
		panelMenuInicial.setVisible(false);
		btnAbrirMenuInicial.setVisible(true);
	}

	/***********************************************************************/
	/* --------------------------------------------------------------------------------------------
	 * 					BOTÕES DE ATIVAR E DESATIVAR DO MENU INCIAL
	 ----------------------------------------------------------------------------------------------*/
	
	/*
	 * 									LANTERNA - ATIVAR E DESATIVAR
	 */
	/* Botão ativar */
	@FXML
	Button btnAtivarLanterna;
	/* Botão desativar */
	@FXML
	Button btnDesativarLanterna;

	/* Método ativar */
	public void ativarLanterna() {
		btnDesativarLanterna.setVisible(true);
		btnAtivarLanterna.setVisible(false);
		
		// PARA ATIVAR A LANTERNA
		RHSpotterController.RHSPOTTER.setLanterna(true);

	}

	/* Método desativar */
	public void desativarLanterna() {
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		
		// PARA DESATIVAR A LANTERNA
		RHSpotterController.RHSPOTTER.setLanterna(false);

	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 * 									CÂMERA - ATIVAR E DESATIVAR 
	 */
	/* Botão ativar */
	@FXML Button btnAtivarCamera;
	/* Botão desativar */
	@FXML Button btnDesativarCamera;
	/*Panel de aviso de envio de imagens desativada*/
	@FXML AnchorPane panelImagenDesativado;
	/*Panel para câmera desconctada*/
	@FXML AnchorPane panelCameraDesconectada;
	/* Método ativar */
	public void ativarCamera() {
		/*Interface botão*/

		btnDesativarCamera.setVisible(true);
		btnAtivarCamera.setVisible(false);

		// PARA ATIVAR A CÂMERA
		panelImagenDesativado.setVisible(false);
		panelCameraDesconectada.setVisible(true);
		//Mostra que a câmera esta esta conectada
		if(RHSpotterController.RHSPOTTER.getCamera() == null)
			JOptionPane.showMessageDialog(null, "Não foi possível se conectar a câmera do robô...",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		else
			panelImagenDesativado.getChildren().add(RHSpotterController.RHSPOTTER.getCamera().generatePanel());
	}
	
	/* Método desativar */
	public void desativarCamera() {
		btnAtivarCamera.setVisible(true);
		btnDesativarCamera.setVisible(false);

		// PARA DESATIVAR A CÂMERA
		if(RHSpotterController.RHSPOTTER.getCamera() == null)
			JOptionPane.showMessageDialog(null, "Não foi possível se conectar a câmera do robô...",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		else
			panelImagenDesativado.getChildren().add(RHSpotterController.RHSPOTTER.getCamera().generatePanel());
			

	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 *  									INSTRUÇÃO - ATIVAR E DESATIVAR 
	 */
	/* Botão ativar */
	@FXML
	Button btnAtivarInstrucao;
	/* Botão desativar */
	@FXML
	Button btnDesativarInstrucao;
	
	/**
	 * 										BALÕES DE INSTRUÇÃO
	 *  */
	/* Locomoção */
	@FXML
	AnchorPane balaoLocomocaoRobo;
	/* Câmera */
	@FXML
	AnchorPane balaoCamera;

	/* Método ativar */
	public void ativarInstrucao() {
		btnDesativarInstrucao.setVisible(true);
		btnAtivarInstrucao.setVisible(false);
		// PARA ATIVAR A INSTRUÇÃO
		balaoLocomocaoRobo.setVisible(true);
		balaoCamera.setVisible(true);
	}

	/* Método desativar */
	public void desativarInstrucao() {
		btnAtivarInstrucao.setVisible(true);
		btnDesativarInstrucao.setVisible(false);
		// PARA DESATIVAR A INSTRUÇÃO
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
	/* Botão */
	@FXML
	AnchorPane btnAbrirGaleria;

	/* Método */
	public void abrirMenuGaleria() {
		panelMenuInicial.setVisible(false);
		panelMenuGaleria.setVisible(true);
	}

	/**
	 * 							 FECHAR MENU GALERIA 
	 */
	/* Método */
	public void fecharMenuGaleria() {
		panelMenuGaleria.setVisible(false);
		panelMenuInicial.setVisible(true);
	}
	/**********************************************************************/
	/* --------------------------------------------------------------------------------------------
	 * 										SUBMENUS DO MENU GALERIA
	 ----------------------------------------------------------------------------------------------*/
	/**
	 * 								GALERIA - PANEL FOTOS E VÍDEOS
	*/
	/* Panel fotos */
	@FXML AnchorPane panelFotos;
	/* Panel videos */
	@FXML AnchorPane panelVideos;


	/**
	 * 									 ABRIR PANEL FOTOS 
	 */
	/* Botão */
	@FXML
	AnchorPane btnAbrirPanelFotos;

	/* Método */
	public void abrirPanelFotos() {
		panelFotos.setVisible(true);
		panelVideos.setVisible(false);
	}

	/**
	 * 											ABRIR PANEL VÍDEOS 
	 */
	/* Botão */
	@FXML
	AnchorPane btnAbrirPanelVideos;

	/* Método */
	public void abrirPanelVideos() {
		panelVideos.setVisible(true);
		panelFotos.setVisible(false);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										BOTÕES DE AÇÕES DE IMAGENS
	 ----------------------------------------------------------------------------------------------*/
	/**
	 *  											VISUALIZA IMAGEM 
	 */

	/* Botão */
	@FXML
	Button btnVisualizaImagem;
	/* Panel */
	@FXML
	AnchorPane panelVisualizaImagem;

	/* Método */
	public void visualizaImagem() {
		panelVisualizaImagem.setVisible(true);
	}

	/**
	 *  								FECHAR VISUALIZAÇÃO IMAGEM 
	* /
	/* Botão */
	@FXML
	AnchorPane btnFecharPanelImagem;

	public void fecharPanelImagem() {
		panelVisualizaImagem.setVisible(false);
	}

	/**
	 * 											 EXCLUI IMAGEM 
	 */
	/* Botão */
	@FXML
	Button btnExcluirImagem;
	/* Panel */
	@FXML
	AnchorPane panelExcluirImagem;

	/* Método */
	public void excluirImagem() {
		panelExcluirImagem.setVisible(true);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										PANEL EXCLUI IMAGEM - SIM OU NÃO
	 ----------------------------------------------------------------------------------------------*/
	/**
	 * 												SIM EXCLUIR IMAGEM
	 */
	/* Botão */
	@FXML
	Button btnExcluirImagemSim;

	/* Método */
	public void excluirImagemSim() {

	}

	/**
	 * 												NÃO EXCLUIR IMAGEM
	 */
	@FXML
	Button btnExcluirImagemNao;

	/* Método */
	public void excluirImagemNao() {
		panelExcluirImagem.setVisible(false);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										BOTÕES DE AÇÕES DE VÍDEOS
	 ----------------------------------------------------------------------------------------------*/

	/**
	 * 												VISUALIZA VÍDEOS 
	 */
	/* Botão */
	@FXML
	Button btnVisualizaVideo;
	/* Panel */
	@FXML AnchorPane panelVisualizaVideo;

	/* Método */
	public void visualizaVideo() {
		panelVisualizaVideo.setVisible(true);
	}

	/**
	 *  									FECHAR VISUALIZAÇÃO DE VÍDEO 
	 */
	/* Botão */
	@FXML AnchorPane btnFecharPanelVideo;

	/* Método */
	public void fecharPanelVideo() {
		panelVisualizaVideo.setVisible(false);
	}

	/**
	 * 													EXCLUI VÍDEOS 
	 */
	/* Botão */
	@FXML Button btnExcluirVideo;
	/* Panel */
	@FXML AnchorPane panelExcluirVideo;

	/* Método */
	public void excluirVideo() {
		panelExcluirVideo.setVisible(true);
	}
	/*-------------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------
	 * 										PANEL EXCLUI VÍDEO - SIM OU NÃO
	 ----------------------------------------------------------------------------------------------*/

	/**
	 * 														SIM EXCLUIR VÍDEO
	 */
	/* Botão */
	@FXML Button btnExcluirVideoSim;

	/* Método */
	public void excluirVideoSim() {

	}

	/*
	 * 													NÃO EXCLUIR VÍDEO
	 */
	@FXML Button btnExcluirVideoNao;


	/* Método */
	public void excluirVideoNao() {
		panelExcluirVideo.setVisible(false);
	}

	/*-------------------------------------------------------------------------------------------------*/

	/*********************************************************************************
	 *  									BOTÕES DE CONTROLE DO ROBÔ 
	 ***********************************************************************************/

	/**
	 * 												MOVE PARA FRENTE 
	 */
	/* Botão */
	@FXML Button btnMoveParaFrenteRobo;

	/* ON MOUSE PRESSED */
	public void moveParaFrentePressed() {
		RHSpotterController.RHSPOTTER.getMove().frente();

	}

	/**
	 * 													MOVE PARA TRÁS 
	 */
	/* Botão */
	@FXML Button btnMoveParaTrasRobo;

	/*ON MOUSE PRESSED */
	public void moveParaTrasPressed() {
		RHSpotterController.RHSPOTTER.getMove().atras();
	}
	

	/**
	 * 													GIRA PARA DIREITA 
	 */
	/* Botão */

	@FXML
	Label btnGiraParaDireitaRobo;

	/* Método */
	public void giraParaDiretaRobo() {
		RHSpotterController.RHSPOTTER.getMove().girarDireita();
	}

	/**
	 * 												GIRA PARA ESQUERDA 
	 */
	/* Botão */

	@FXML
	Label btnGiraParaEsquerdaRobo;

	/* Método */
	public void giraParaEsquerdaRobo() {
		RHSpotterController.RHSPOTTER.getMove().girarEsquerda();
	}

	/**
	 * 													PARAR O ROBÔ 
	 */
	/* Botão */

	@FXML
	Label btnPararRobo;

	/* Método */
	public void pararRobo() {
		RHSpotterController.RHSPOTTER.getMove().parar();
	}

	/******************************************************************/
	
	/***************************************************************************
	 * 								BOTÕES DE CONTROLE DA CÂMERA 
	 ***************************************************************************/

	/**
	 * 													MOVE PARA CIMA 
	 */
	/* Botão */
	@FXML Button btnMoveParaCimaCamera;

	/* ON MOUSE PRESSED */
	public void moveParaCimaPressed() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.paraCima();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A câmera esta desconectada", 
					"Problema com a câmera", JOptionPane.ERROR_MESSAGE);
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
					"A câmera esta desconectada", 
					"Problema com a câmera", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 												MOVE PARA BAIXO 
	 */
	/* Botão */
	@FXML Button btnMoveParaBaixoCamera;

	/* ON MOUSE PRESSED */
	public void moveParaBaixoPressed() {
		RHSpotter rhs = RHSpotterController.RHSPOTTER;
		Camera camera = rhs.getCamera();
		if(camera != null){
			camera.paraCima();
		}else{
			JOptionPane.showMessageDialog(null, 
					"A câmera esta desconectada", 
					"Problema com a câmera", JOptionPane.ERROR_MESSAGE);
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
					"A câmera esta desconectada", 
					"Problema com a câmera", JOptionPane.ERROR_MESSAGE);
		}

	}

	/******************************************************************/
	/*-----------------------------------------------------------------------------------
	 * 										TIRAR FOTOS E GRAVAR VÍDEOS 
	 -------------------------------------------------------------------------------------*/
	/* Botão */
	@FXML
	Label btnCapturaImagens;

	/**
	 * 													TIRA FOTO 
	 */
	/* Método */
	public void tiraFoto() {
		
	}

	/**
	 * 													GRAVA VIDEO 
	 */
	/* Método */
	public void gravaVideo() {

	}
	/*--------------------------------------------------------------------------------------------*/

}

