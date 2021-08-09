package model;

import java.util.ArrayList;

import view.Mensagem;
import view.TelaPrincipal;

public class Jogo {

	private static boolean verificar = true;
	private static int cartasCertas;
	private static int questaoRodada = 1;
	private static boolean finalJogo;
	private static int dificuldade;
	private static String endereco, tempoFinal;
	private static boolean adicao,sub,mult,div;
	
	
	private static ArrayList<Integer>cartasSelecionadas = new ArrayList<Integer>();

	private static TelaPrincipal tela;

	public static boolean verificarCartas(int pos){

		if(cartasSelecionadas.size() < 2){
			cartasSelecionadas.add(pos);
		}else{
			return false;
		}

		if(cartasSelecionadas.size() == 2){
			if (compararCartas()){
				tela.getpJogo().setVisible(false);
				tela.getpJogo().setRodarPJogo(false);

				tela.getpQuestoes().setQuestoes(BancoDeDados.gerarQuestoes(tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(0)].getTipoDaCarta()));
				tela.getpQuestoes().alternativas();
				tela.getpQuestoes().setVisible(true);
				tela.getpQuestoes().setRodarPQuestoes(true);

			}else{				
				for (int i=0; i<2; i++){
					tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(i)].desvirar();
				}
				cartasSelecionadas.clear();
			}
			Jogador.setJogadasJogador1(Jogador.getJogadasJogador1() + 1);
		}			
		return true;
	}

	public static boolean compararCartas(){
		if (tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(0)].getTipoDaCarta().equals
				(tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(1)].getTipoDaCarta())){
			return true;
		}
		return false;	
	}

	public static void compararRespostas(int numQuestao, String respostaJogador){

		if(BancoDeDados.leitor(3, numQuestao,dificuldade).equals(respostaJogador)){
			Sons.tocar("Resource/Audios/Vitoria.wav");
			tela.getpQuestoes().getRespostas().get(0).animar();
			
			Jogador.setAcertosJogador1(Jogador.getAcertosJogador1() + 1);
			 
			verificar = false;
			 
			tela.getpQuestoes().getRespostas().get(0).getResposta().aparencia=0;
			
		}else{
			Sons.tocar("Resource/Audios/Errado.wav");
			tela.getpQuestoes().getRespostas().get(1).animar();
		}
		
		tela.getpQuestoes().getRespostas().get(1).getResposta().aparencia=0;
		
		if(questaoRodada<3){
			questaoRodada++;
			tela.getpQuestoes().setQuestoes(BancoDeDados.gerarQuestoes(tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(0)].getTipoDaCarta()));
			tela.getpQuestoes().alternativas();
			
		}else{
			questaoRodada = 1;
			tela.getpQuestoes().voltarTelaJogo();
		
		
			if(verificar){
				for (int i=0; i<2; i++){
					tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(i)].desvirar();
				}
			}else{
				cartasCertas++;
			}
			cartasSelecionadas.clear();
		}
		
		if (cartasCertas == 4){
			finalJogo = true;
		}
	}

	public static void iniciarJogo(){

		tela.getpInicio().setVisible(false);
		tela.getpInicio().setRodarPInico(false);
		
		Jogador.setAcertosJogador1(0);
		Jogador.setJogadasJogador1(0);
		tela.getpJogo().setVisible(true);
		BancoDeDados.inicializarArrayList();
		tela.getpJogo().setCartasNojogo(BancoDeDados.cartasJogo());				
		tela.getpJogo().setRodarPJogo(true);
		try {
			Thread.sleep(2000);			
			for(int i = 0; i < 8; i++){
				tela.getpJogo().getCartasNojogo()[i].desvirar();
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		Cronometro.iniciar();
		
	}

	public static void setTela(TelaPrincipal tela) {
		Jogo.tela = tela;
	}

	public static ArrayList<Integer> getCartasSelecionadas() {
		return cartasSelecionadas;
	}

	public static int getDificuldade() {
		return dificuldade;
	}

	public static void setDificuldade(int dificuldade) {
		Jogo.dificuldade = dificuldade;
	}

	public static String getEndereco() {
		return endereco;
	}

	public static void setEndereco(String endereco) {
		Jogo.endereco = endereco;
	}

	public static boolean isAdicao() {
		return adicao;
	}

	public static void setAdicao(boolean adicao) {
		Jogo.adicao = adicao;
	}

	public static boolean isSub() {
		return sub;
	}

	public static void setSub(boolean sub) {
		Jogo.sub = sub;
	}

	public static boolean isMult() {
		return mult;
	}

	public static void setMult(boolean mult) {
		Jogo.mult = mult;
	}

	public static boolean isDiv() {
		return div;
	}

	public static void setDiv(boolean div) {
		Jogo.div = div;
	}

	public static boolean isFinalJogo() {
		return finalJogo;
	}

	public static void setFinalJogo(boolean finalJogo) {
		Jogo.finalJogo = finalJogo;
	}

	public static String getTempoFinal() {
		return tempoFinal;
	}

	public static void setTempoFinal(String tempoFinal) {
		Jogo.tempoFinal = tempoFinal;
	}

	public static int getQuestaoRodada() {
		return questaoRodada;
	}

	public static void setQuestaoRodada(int questaoRodada) {
		Jogo.questaoRodada = questaoRodada;
	}	
	
}
