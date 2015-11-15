package com.hotmail.milenacararoo.rhspotter.controllers;



import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {
	/******************************************************************/
								/*MENU INICIAL*/
	/*Menu*/
	@FXML
	AnchorPane panelMenuInicial;
	
								/*ABRIR MENU INICIAL*/
	/*Bot�o*/
	@FXML
	AnchorPane btnAbrirMenuInicial;
	/*M�todo*/
	public void abrirMenuInicial(){
		/*Deixa o menu inicial visivel*/
		panelMenuInicial.setVisible(true);
		/*Desabilita cot�o de abrir menu inicial*/
		btnAbrirMenuInicial.setVisible(false);
	}
	
							/*FECHAR MENU INICIAL*/
	/*Bot�o*/
	@FXML
	AnchorPane btnFecharMenuInicial;
	/*M�todo*/
	public void fecharMenuInicial() {
		panelMenuInicial.setVisible(false);
		btnAbrirMenuInicial.setVisible(true);
	}
	/******************************************************************/
	/*-------------------------------------------------------------------------------------------------*/
								/*LANTERNA - ATIVAR E DESATIVAR*/
	/*Bot�o ativar*/
	@FXML
	Button btnAtivarLanterna;
	/*Bot�o desativar*/
	@FXML
	Button btnDesativarLanterna;
	/*M�todo ativar*/
	public void ativarLanterna(){
		btnDesativarLanterna.setVisible(true);
		btnAtivarLanterna.setVisible(false);
		//PARA ATIVAR A LANTERNA
	}
	/*M�todo desativar*/
	public void desativarLanterna(){
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		//PARA DESATIVAR A LANTERNA
	}
	/*-------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------*/
					/*C�MERA - ATIVAR E DESATIVAR*/
	/*Bot�o ativar*/
	@FXML
	Button btnAtivarCamera;
	/*Bot�o desativar*/
	@FXML
	Button btnDesativarCamera;
	/*M�todo ativar*/
	public void ativarCamera(){
	btnDesativarCamera.setVisible(true);
	btnAtivarCamera.setVisible(false);
	//PARA ATIVAR A C�MERA
	}
	/*M�todo desativar*/
	public void desativarCamera(){
	btnAtivarCamera.setVisible(true);
	btnDesativarCamera.setVisible(false);
	//PARA DESATIVAR A C�MERA
	}
	/*-------------------------------------------------------------------------------------------------*/
	/******************************************************************/
							/*MENU GALERIA*/
	/*Menu*/
	@FXML
	AnchorPane panelMenuGaleria;
	
							/*ABRIR MENU GALERIA*/
	/*Bot�o*/
	 @FXML
	 AnchorPane btnAbrirGaleria ;
	 /*M�todo*/
	public void abrirMenuGaleria(){
		panelMenuInicial.setVisible(false);
		panelMenuGaleria.setVisible(true);
	}
	
						/*FECHAR MENU GALERIA*/
	/*M�todo*/
	public void fecharMenuGaleria(){
		panelMenuGaleria.setVisible(false);
		panelMenuInicial.setVisible(true);
	}
	/******************************************************************/
	/******************************************************************/
					/*GALERIA - PANEL FOTOS E V�DEOS*/
	/*Panel fotos*/
	@FXML
	AnchorPane panelFotos;
	/*Panel videos*/
	@FXML
	AnchorPane panelVideos;
	
					/*ABRIR PANEL FOTOS*/
	/*Bot�o*/
	@FXML
	AnchorPane btnAbrirPanelFotos;
	/*M�todo*/
	public void abrirPanelFotos(){
		panelFotos.setVisible(true);
		panelVideos.setVisible(false);
	}

				/*ABRIR PANEL V�DEOS*/
	/*Bot�o*/
	@FXML
	AnchorPane btnAbrirPanelVideos;
	/*M�todo*/
	public void abrirPanelVideos(){
		panelVideos.setVisible(true);
		panelFotos.setVisible(false);
	}
	
	/******************************************************************/
	/*-------------------------------------------------------------------------------------------------*/
							/*IMAGEM - BOT�ES */
	
							/*VISUALIZA IMAGEM*/
	/*Bot�o*/
	@FXML
	Button btnVisualizaImagem;
	/*Panel*/
	@FXML
	AnchorPane panelVisualizaImagem;
	/*M�todo*/
	public void visualizaImagem(){
		panelVisualizaImagem.setVisible(true);
	}
						/*FECHAR VISUALIZA��O IMAGEM*/
		/*Bot�o*/
	@FXML
	AnchorPane btnFecharPanelImagem;
	/*M�todo*/
	public void fecharPanelImagem(){
		panelVisualizaImagem.setVisible(false);	
	}
					/*EXCLUI IMAGEM*/
	/*Bot�o*/
	@FXML
	Button btnExcluImagem;
	/*M�todo*/
	public void excluiImagem(){
		
	}
	/*-------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------*/
							/*V�DEOS - BOT�ES */

							/*VISUALIZA V�DEOS*/
	/*Bot�o*/
	@FXML
	Button btnVisualizaVideo;	
	/*Panel*/
	@FXML
	AnchorPane panelVisualizaVideo;
	/*M�todo*/
	public void visualizaVideo(){
		panelVisualizaVideo.setVisible(true);
	}	
						/*FECHAR VISUALIZA��O DE V�DEO*/
	/*Bot�o*/
	@FXML
	AnchorPane btnFecharPanelVideo;
	/*M�todo*/
	public void fecharPanelVideo(){
		panelVisualizaVideo.setVisible(false);
	}
							/*EXCLUI V�DEOS*/
	/*Bot�o*/
	@FXML
	Button btnExcluVideo;
	/*M�todo*/
	public void excluiVideo(){
	
	}
	/*-------------------------------------------------------------------------------------------------*/
	/******************************************************************/
							/*BOT�ES DE CONTROLE DO ROB�*/
	
								/*MOVE PARA FRENTE*/
	/*Bot�o*/
	@FXML
	Label btnMoveParaFrenteRobo;
	/*M�todo*/
	public void moveParaFrenteRobo(){
		
	}
							/*MOVE PARA TR�S*/
	/*Bot�o*/
	@FXML
	Label btnMoveParaTrasRobo;
	/*M�todo*/
	public void moveParaTrasRobo(){
		
	}
					
						/*GIRA PARA DIREITA*/
	/*Bot�o*/
	@FXML
	Label btnGiraParaDireitaRobo;
	/*M�todo*/
	public void giraParaDiretaRobo(){
		
	}
						/*GIRA PARA ESQUERDA*/
	/*Bot�o*/
	@FXML
	Label btnGiraParaEsquerdaRobo;
	/*M�todo*/
	public void giraParaEsquerdaRobo(){
		
	}
						/*PARA O ROB�*/
	/*Bot�o*/
	@FXML
	Label btnPararRobo;
	/*M�todo*/
	public void pararRobo(){
		
	}
	/******************************************************************/
								/*BOT�ES DE CONTROLE DA C�MERA*/
	
							/*MOVE PARA CIMA*/
	/*Bot�o*/
	@FXML
	Label btnMoveParaCimaCamera;
	/*M�todo*/
	public void moveParaCimaCamera(){
		
	}
							/*MOVE PARA BAIXO*/
	/*Bot�o*/
	@FXML
	Label btnMoveParaBaixoCamera;
	/*M�todo*/
	public void moveParaBaixoCamera(){
		
	}
	/******************************************************************/
							/*TIRAR FOTOS E GRAVAR V�DEOS*/
	/*Bot�o*/
	@FXML
	Label btnCapturaImagens;
	
								/*TIRA FOTO*/
	/*M�todo*/
	public void tiraFoto(){
		
	}
							/*GRAVA VIDEO*/
	/*M�todo*/
	public void gravaVideo(){
		
	}
	

						
}
