package com.hotmail.milenacararoo.rhspotter.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {
	/**---------------------------------------------------------------------------------------------
	 * 											Tela realizando comunicação com o robô
	 * */
	@FXML
	AnchorPane panelRelizandoComunicacao;
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
	@FXML
	//																Botão da tela de erro "Realizar Comunicação Novamente"
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
	}

	/* Método desativar */
	public void desativarLanterna() {
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		// PARA DESATIVAR A LANTERNA
	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 * 									CÂMERA - ATIVAR E DESATIVAR 
	 */
	/* Botão ativar */
	@FXML
	Button btnAtivarCamera;
	/* Botão desativar */
	@FXML
	Button btnDesativarCamera;
	/* Componente que mostra a imagem da câmera */
	@FXML
	ImageView imagemFundo;
	@FXML
	AnchorPane panelImagenDesativado;

	/* Método ativar */
	public void ativarCamera() {
		btnDesativarCamera.setVisible(true);
		btnAtivarCamera.setVisible(false);

		// PARA ATIVAR A CÂMERA
		imagemFundo.setVisible(true);
		panelImagenDesativado.setVisible(false);
	}

	/* Método desativar */
	public void desativarCamera() {
		btnAtivarCamera.setVisible(true);
		btnDesativarCamera.setVisible(false);

		// PARA DESATIVAR A CÂMERA
		imagemFundo.setVisible(false);
		panelImagenDesativado.setVisible(true);

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
	@FXML
	AnchorPane panelFotos;
	/* Panel videos */
	@FXML
	AnchorPane panelVideos;

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
	@FXML
	AnchorPane panelVisualizaVideo;

	/* Método */
	public void visualizaVideo() {
		panelVisualizaVideo.setVisible(true);
	}

	/**
	 *  									FECHAR VISUALIZAÇÃO DE VÍDEO 
	 */
	/* Botão */
	@FXML
	AnchorPane btnFecharPanelVideo;

	/* Método */
	public void fecharPanelVideo() {
		panelVisualizaVideo.setVisible(false);
	}

	/**
	 * 													EXCLUI VÍDEOS 
	 */
	/* Botão */
	@FXML
	Button btnExcluirVideo;
	/* Panel */
	@FXML
	AnchorPane panelExcluirVideo;

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
	@FXML
	Button btnExcluirVideoSim;

	/* Método */
	public void excluirVideoSim() {

	}

	/*
	 * 													NÃO EXCLUIR VÍDEO
	 */
	@FXML
	Button btnExcluirVideoNao;

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
	@FXML
	Label btnMoveParaFrenteRobo;

	/* Método */
	public void moveParaFrenteRobo() {

	}

	/**
	 * 													MOVE PARA TRÁS 
	 */
	/* Botão */
	@FXML
	Label btnMoveParaTrasRobo;

	/* Método */
	public void moveParaTrasRobo() {

	}

	/**
	 * 													GIRA PARA DIREITA 
	 */
	/* Botão */
	@FXML
	Label btnGiraParaDireitaRobo;

	/* Método */
	public void giraParaDiretaRobo() {

	}

	/**
	 * 												GIRA PARA ESQUERDA 
	 */
	/* Botão */
	@FXML
	Label btnGiraParaEsquerdaRobo;

	/* Método */
	public void giraParaEsquerdaRobo() {

	}

	/**
	 * 													PARAR O ROBÔ 
	 */
	/* Botão */
	@FXML
	Label btnPararRobo;

	/* Método */
	public void pararRobo() {

	}

	/******************************************************************/
	
	/***************************************************************************
	 * 								BOTÕES DE CONTROLE DA CÂMERA 
	 ***************************************************************************/

	/**
	 * 													MOVE PARA CIMA 
	 */
	/* Botão */
	@FXML
	Label btnMoveParaCimaCamera;

	/* Método */
	public void moveParaCimaCamera() {

	}

	/**
	 * 												MOVE PARA BAIXO 
	 */
	/* Botão */
	@FXML
	Label btnMoveParaBaixoCamera;

	/* Método */
	public void moveParaBaixoCamera() {

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
/*************************************************************************************************
 *************************************************************************************************/
	/******************************************************************************************
	 * 															LISTENER - TECLADO
	 *******************************************************************************************/
	
	/**
	 * 														MOVER ROBÔ
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
		 * 														MOVE CÂMERA
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
