package model;

import view.Mensagem;

public class Objetos {

	private Sprite resposta;
	private int posX = 800,posY = 70;

	public Objetos(Sprite resposta) {
		this.resposta = resposta;
	}

	public void animar(){
		for(int j=0; j <5;j++){
			try {
				Thread.sleep(100);
				resposta.aparencia++;
			} catch (Exception e) {
				Mensagem.mensagemExibir("Não foi possivel exibir o sprite");
			}

		}
	}

	public Sprite getResposta() {
		return resposta;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	
}
