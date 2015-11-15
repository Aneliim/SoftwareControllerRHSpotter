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
	/*Botão*/
	@FXML
	AnchorPane btnAbrirMenuInicial;
	/*Método*/
	public void abrirMenuInicial(){
		/*Deixa o menu inicial visivel*/
		panelMenuInicial.setVisible(true);
		/*Desabilita cotão de abrir menu inicial*/
		btnAbrirMenuInicial.setVisible(false);
	}
	
							/*FECHAR MENU INICIAL*/
	/*Botão*/
	@FXML
	AnchorPane btnFecharMenuInicial;
	/*Método*/
	public void fecharMenuInicial() {
		panelMenuInicial.setVisible(false);
		btnAbrirMenuInicial.setVisible(true);
	}
	/******************************************************************/
	/*-------------------------------------------------------------------------------------------------*/
								/*LANTERNA - ATIVAR E DESATIVAR*/
	/*Botão ativar*/
	@FXML
	Button btnAtivarLanterna;
	/*Botão desativar*/
	@FXML
	Button btnDesativarLanterna;
	/*Método ativar*/
	public void ativarLanterna(){
		btnDesativarLanterna.setVisible(true);
		btnAtivarLanterna.setVisible(false);
		//PARA ATIVAR A LANTERNA
	}
	/*Método desativar*/
	public void desativarLanterna(){
		btnAtivarLanterna.setVisible(true);
		btnDesativarLanterna.setVisible(false);
		//PARA DESATIVAR A LANTERNA
	}
	/*-------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------*/
					/*CÂMERA - ATIVAR E DESATIVAR*/
	/*Botão ativar*/
	@FXML
	Button btnAtivarCamera;
	/*Botão desativar*/
	@FXML
	Button btnDesativarCamera;
	/*Método ativar*/
	public void ativarCamera(){
	btnDesativarCamera.setVisible(true);
	btnAtivarCamera.setVisible(false);
	//PARA ATIVAR A CÂMERA
	}
	/*Método desativar*/
	public void desativarCamera(){
	btnAtivarCamera.setVisible(true);
	btnDesativarCamera.setVisible(false);
	//PARA DESATIVAR A CÂMERA
	}
	/*-------------------------------------------------------------------------------------------------*/
	/******************************************************************/
							/*MENU GALERIA*/
	/*Menu*/
	@FXML
	AnchorPane panelMenuGaleria;
	
							/*ABRIR MENU GALERIA*/
	/*Botão*/
	 @FXML
	 AnchorPane btnAbrirGaleria ;
	 /*Método*/
	public void abrirMenuGaleria(){
		panelMenuInicial.setVisible(false);
		panelMenuGaleria.setVisible(true);
	}
	
						/*FECHAR MENU GALERIA*/
	/*Método*/
	public void fecharMenuGaleria(){
		panelMenuGaleria.setVisible(false);
		panelMenuInicial.setVisible(true);
	}
	/******************************************************************/
	/******************************************************************/
					/*GALERIA - PANEL FOTOS E VÍDEOS*/
	/*Panel fotos*/
	@FXML
	AnchorPane panelFotos;
	/*Panel videos*/
	@FXML
	AnchorPane panelVideos;
	
					/*ABRIR PANEL FOTOS*/
	/*Botão*/
	@FXML
	AnchorPane btnAbrirPanelFotos;
	/*Método*/
	public void abrirPanelFotos(){
		panelFotos.setVisible(true);
		panelVideos.setVisible(false);
	}

				/*ABRIR PANEL VÍDEOS*/
	/*Botão*/
	@FXML
	AnchorPane btnAbrirPanelVideos;
	/*Método*/
	public void abrirPanelVideos(){
		panelVideos.setVisible(true);
		panelFotos.setVisible(false);
	}
	
	/******************************************************************/
	/*-------------------------------------------------------------------------------------------------*/
							/*IMAGEM - BOTÕES */
	
							/*VISUALIZA IMAGEM*/
	/*Botão*/
	@FXML
	Button btnVisualizaImagem;
	/*Panel*/
	@FXML
	AnchorPane panelVisualizaImagem;
	/*Método*/
	public void visualizaImagem(){
		panelVisualizaImagem.setVisible(true);
	}
						/*FECHAR VISUALIZAÇÃO IMAGEM*/
		/*Botão*/
	@FXML
	AnchorPane btnFecharPanelImagem;
	/*Método*/
	public void fecharPanelImagem(){
		panelVisualizaImagem.setVisible(false);	
	}
					/*EXCLUI IMAGEM*/
	/*Botão*/
	@FXML
	Button btnExcluImagem;
	/*Método*/
	public void excluiImagem(){
		
	}
	/*-------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------*/
							/*VÍDEOS - BOTÕES */

							/*VISUALIZA VÍDEOS*/
	/*Botão*/
	@FXML
	Button btnVisualizaVideo;	
	/*Panel*/
	@FXML
	AnchorPane panelVisualizaVideo;
	/*Método*/
	public void visualizaVideo(){
		panelVisualizaVideo.setVisible(true);
	}	
						/*FECHAR VISUALIZAÇÃO DE VÍDEO*/
	/*Botão*/
	@FXML
	AnchorPane btnFecharPanelVideo;
	/*Método*/
	public void fecharPanelVideo(){
		panelVisualizaVideo.setVisible(false);
	}
							/*EXCLUI VÍDEOS*/
	/*Botão*/
	@FXML
	Button btnExcluVideo;
	/*Método*/
	public void excluiVideo(){
	
	}
	/*-------------------------------------------------------------------------------------------------*/
	/******************************************************************/
							/*BOTÕES DE CONTROLE DO ROBÔ*/
	
								/*MOVE PARA FRENTE*/
	/*Botão*/
	@FXML
	Label btnMoveParaFrenteRobo;
	/*Método*/
	public void moveParaFrenteRobo(){
		
	}
							/*MOVE PARA TRÁS*/
	/*Botão*/
	@FXML
	Label btnMoveParaTrasRobo;
	/*Método*/
	public void moveParaTrasRobo(){
		
	}
					
						/*GIRA PARA DIREITA*/
	/*Botão*/
	@FXML
	Label btnGiraParaDireitaRobo;
	/*Método*/
	public void giraParaDiretaRobo(){
		
	}
						/*GIRA PARA ESQUERDA*/
	/*Botão*/
	@FXML
	Label btnGiraParaEsquerdaRobo;
	/*Método*/
	public void giraParaEsquerdaRobo(){
		
	}
						/*PARA O ROBÔ*/
	/*Botão*/
	@FXML
	Label btnPararRobo;
	/*Método*/
	public void pararRobo(){
		
	}
	/******************************************************************/
								/*BOTÕES DE CONTROLE DA CÂMERA*/
	
							/*MOVE PARA CIMA*/
	/*Botão*/
	@FXML
	Label btnMoveParaCimaCamera;
	/*Método*/
	public void moveParaCimaCamera(){
		
	}
							/*MOVE PARA BAIXO*/
	/*Botão*/
	@FXML
	Label btnMoveParaBaixoCamera;
	/*Método*/
	public void moveParaBaixoCamera(){
		
	}
	/******************************************************************/
							/*TIRAR FOTOS E GRAVAR VÍDEOS*/
	/*Botão*/
	@FXML
	Label btnCapturaImagens;
	
								/*TIRA FOTO*/
	/*Método*/
	public void tiraFoto(){
		
	}
							/*GRAVA VIDEO*/
	/*Método*/
	public void gravaVideo(){
		
	}
	

						
}
