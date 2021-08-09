package app;

import controller.ControladorDoJogo;
import model.BancoDeDados;
import view.TelaPrincipal;

public class App {
	public static void main(String[] args) {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		ControladorDoJogo jogo = new ControladorDoJogo(telaPrincipal);
		
		
	}
}
