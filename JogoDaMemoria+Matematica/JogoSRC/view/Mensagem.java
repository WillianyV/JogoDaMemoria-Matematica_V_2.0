package view;

import javax.swing.JOptionPane;

import model.Cronometro;
import model.Jogador;
import model.Jogo;

public class Mensagem {
	public static void mensagemExibir(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
