package com.hotmail.milenacararoo.rhspotter.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {
	/**---------------------------------------------------------------------------------------------
	 * 											Tela realizando comunica��o com o rob�
	 * */
	@FXML
	AnchorPane panelRelizandoComunicacao;
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
	@FXML
	//																Bot�o da tela de erro "Realizar Comunica��o Novamente"
	Button btnTentarNovamente;
	public void realizarComunicacaoNovamente(){
		panelRelizandoComunicacao.setVisible(true);
		panelErro.setVisible(false);
	}
	//-----------------------------------------------------------------------------------------------
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
	}

	/* M�todo desativar */
	public void desativarLanterna() {
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		// PARA DESATIVAR A LANTERNA
	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 * 									C�MERA - ATIVAR E DESATIVAR 
	 */
	/* Bot�o ativar */
	@FXML
	Button btnAtivarCamera;
	/* Bot�o desativar */
	@FXML
	Button btnDesativarCamera;
	/* Componente que mostra a imagem da c�mera */
	@FXML
	ImageView imagemFundo;
	@FXML
	AnchorPane panelImagenDesativado;

	/* M�todo ativar */
	public void ativarCamera() {
		btnDesativarCamera.setVisible(true);
		btnAtivarCamera.setVisible(false);

		// PARA ATIVAR A C�MERA
		imagemFundo.setVisible(true);
		panelImagenDesativado.setVisible(false);
	}

	/* M�todo desativar */
	public void desativarCamera() {
		btnAtivarCamera.setVisible(true);
		btnDesativarCamera.setVisible(false);

		// PARA DESATIVAR A C�MERA
		imagemFundo.setVisible(false);
		panelImagenDesativado.setVisible(true);

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
	@FXML
	AnchorPane panelFotos;
	/* Panel videos */
	@FXML
	AnchorPane panelVideos;

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
	@FXML
	AnchorPane panelVisualizaVideo;

	/* M�todo */
	public void visualizaVideo() {
		panelVisualizaVideo.setVisible(true);
	}

	/**
	 *  									FECHAR VISUALIZA��O DE V�DEO 
	 */
	/* Bot�o */
	@FXML
	AnchorPane btnFecharPanelVideo;

	/* M�todo */
	public void fecharPanelVideo() {
		panelVisualizaVideo.setVisible(false);
	}

	/**
	 * 													EXCLUI V�DEOS 
	 */
	/* Bot�o */
	@FXML
	Button btnExcluirVideo;
	/* Panel */
	@FXML
	AnchorPane panelExcluirVideo;

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
	@FXML
	Button btnExcluirVideoSim;

	/* M�todo */
	public void excluirVideoSim() {

	}

	/*
	 * 													N�O EXCLUIR V�DEO
	 */
	@FXML
	Button btnExcluirVideoNao;

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
	@FXML
	Label btnMoveParaFrenteRobo;

	/* M�todo */
	public void moveParaFrenteRobo() {

	}

	/**
	 * 													MOVE PARA TR�S 
	 */
	/* Bot�o */
	@FXML
	Label btnMoveParaTrasRobo;

	/* M�todo */
	public void moveParaTrasRobo() {

	}

	/**
	 * 													GIRA PARA DIREITA 
	 */
	/* Bot�o */
	@FXML
	Label btnGiraParaDireitaRobo;

	/* M�todo */
	public void giraParaDiretaRobo() {

	}

	/**
	 * 												GIRA PARA ESQUERDA 
	 */
	/* Bot�o */
	@FXML
	Label btnGiraParaEsquerdaRobo;

	/* M�todo */
	public void giraParaEsquerdaRobo() {

	}

	/**
	 * 													PARAR O ROB� 
	 */
	/* Bot�o */
	@FXML
	Label btnPararRobo;

	/* M�todo */
	public void pararRobo() {

	}

	/******************************************************************/
	
	/***************************************************************************
	 * 								BOT�ES DE CONTROLE DA C�MERA 
	 ***************************************************************************/

	/**
	 * 													MOVE PARA CIMA 
	 */
	/* Bot�o */
	@FXML
	Label btnMoveParaCimaCamera;

	/* M�todo */
	public void moveParaCimaCamera() {

	}

	/**
	 * 												MOVE PARA BAIXO 
	 */
	/* Bot�o */
	@FXML
	Label btnMoveParaBaixoCamera;

	/* M�todo */
	public void moveParaBaixoCamera() {

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
/*************************************************************************************************
 *************************************************************************************************/
	/******************************************************************************************
	 * 															LISTENER - TECLADO
	 *******************************************************************************************/
	
	/**
	 * 														MOVER ROB�
	 */
	//btnMoveParaFrenteRobo
		public void moveParaFrentePressed(){ 
			
		} 
		public void moveParaFrenterReleased(){ 
			
		} 
		public void moveParaFrenteTyped(){ 
			
		} 
		
	//btnGiraParaDireitaRobo
		public void giraParaDireitaPressed(){ 
			
		} 
		public void giraParaDireitaReleased(){ 
			
		} 
		public void giraParaDireitaTyped(){ 
			
		} 
		
		//btnMoveParaTrasRobo
		public void moveParaTrasPressed(){ 
			
		} 
		public void moveParaTrasReleased(){ 
			
		} 
		public void moveParaTrasTyped(){ 
			
		} 
		
		//btnGiraParaEsquerdaRobo
		public void giraParaEsquerdaPressed(){ 
			
		} 
		public void giraParaEsquerdaReleased(){ 
			
		} 
		public void giraParaEsquerdaTyped(){ 
			
		} 
		
		//btnPararRobo
		public void btnPararPressed(){ 
			
		} 
		public void btnPararReleased(){ 
			
		} 
		public void btnPararTyped(){ 
			
		} 
		
		/**
		 * 														MOVE C�MERA
		 */
		
		//btnMoveParaCimaCamera
		public void moveParaCimaPressed(){ 
			
		}
		public void moveParaCimaReleased(){ 
			
		} 
		public void moveParaCimaTyped(){ 
			
		}

		//btnMoveParaBaixoCamera
		public void moveParaBaixoPressed(){ 
			
		}
		public void moveParaBaixoReleased(){ 
			
		} 
		public void moveParaBaixoTyped(){ 
			
		}
		
		//btnCapturaImagens
		public void capturaImagensPressed(){ 
			
		}
		public void capturaImagensReleased(){ 
			
		} 
		public void capturaImagensTyped(){ 
			
		}
}
