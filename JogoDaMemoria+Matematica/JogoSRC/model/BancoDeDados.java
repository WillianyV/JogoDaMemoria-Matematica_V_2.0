package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import view.Mensagem;
import view.PanelInicio;
import view.TelaPrincipal;


public class BancoDeDados {

	private static ArrayList<Cartas>bancoDeCartas = new ArrayList<>();
	private static ArrayList<Integer>cartasUsadas = new ArrayList<>();
	private static ArrayList<Integer> perguntasFeitas = new ArrayList<>();
	private static Random aleatorio = new Random();

	//METODOS PERSONALIZADOS
	public static void inicializarArrayList(){
		for(int i = 1; i < 9;i++){
			bancoDeCartas.add(new Cartas(leitura(i)));
		}
	}

	public static Cartas[] cartasJogo() {

		int carta;
		Cartas[] cartasNojogo = new Cartas[8];

		int i = 0;
		while(cartasUsadas.size() < 8){

			carta = aleatorio.nextInt(8);
			if(verificar(carta)){
				cartasNojogo[i] = bancoDeCartas.get(carta);
				i++; 
				cartasUsadas.add(carta);
			}
		}

		return cartasNojogo;
	}

	public static String leitura(int nLinha){
		FileReader ler;
		String lido = "";
		int i=0;

		try {
			ler = new FileReader(Jogo.getEndereco());
			BufferedReader br = new BufferedReader(ler);
			while(i < nLinha){
				try {
					lido = br.readLine();
					i++;
				} catch (IOException e) {
					Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
				}
			}
		} catch (FileNotFoundException e) {	
			Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
		}

		return lido;
	}

	public static boolean verificar(int carta){
		for(int i: cartasUsadas){
			if (i == carta){
				return false;
			}
		}
		return true;
	}

	public static Questoes gerarQuestoes(String tipoQuestao){

		String lido;
		int numPergunta = gerarNumeroPergunta(tipoQuestao) ;
		lido = leitor(2,numPergunta,Jogo.getDificuldade());

		return new Questoes(lido, fornecerAlternativas(numPergunta), numPergunta);
	}

	public static String[] fornecerAlternativas(int numQuestao){
		ArrayList<String> alt = new ArrayList<>();		
		String[] alternativas = new String[4];
		int j=0;

		int resposta = aleatorio.nextInt(3);
		alternativas[resposta] = leitor(3, numQuestao,Jogo.getDificuldade());
		alt.add(leitor(1, 3*(numQuestao-1)+1,Jogo.getDificuldade()));
		alt.add(leitor(1, 3*(numQuestao-1)+2,Jogo.getDificuldade()));
		alt.add(leitor(1, 3*(numQuestao-1)+3,Jogo.getDificuldade()));

		for(int i=0; i<4;i++){
			if(i != resposta){
				alternativas[i] = alt.get(j);
				j++;
			}
		}
		return alternativas;

	}

	public static String leitor(int arquivo, int nLinha, int dificuldade){
		String endArquivo = "";
		String lido = "";
		int i =0;

		switch (arquivo) {
		case 1: 
			if(dificuldade == 1){
				endArquivo = "Resource/ArquivosTxt/NivelFacilAlternativas.txt";
			}else if(dificuldade == 2){
				endArquivo = "Resource/ArquivosTxt/NivelMedioAlternativas.txt";
			}else{
				endArquivo = "Resource/ArquivosTxt/NivelDificilAlternativas.txt";
			}

			break;
		case 2: 
			if(dificuldade == 1){
				endArquivo = "Resource/ArquivosTxt/nivelFacil.txt";
			}else if(dificuldade == 2){
				endArquivo = "Resource/ArquivosTxt/nivelMedio.txt";
			}else{
				endArquivo = "Resource/ArquivosTxt/nivelDificil.txt";
			}
			break;
		case 3: 
			if(dificuldade == 1){
				endArquivo = "Resource/ArquivosTxt/NivelFacilRespostas.txt";
			}else if(dificuldade == 2){
				endArquivo = "Resource/ArquivosTxt/NivelMedioRespostas.txt";
			}else{
				endArquivo = "Resource/ArquivosTxt/NivelDificilRespostas.txt";
			}

			break;

		}
		FileReader ler;
		try {
			ler = new FileReader(endArquivo);
			BufferedReader br = new BufferedReader(ler);
			while(i < nLinha){
				lido = br.readLine();
				i++;
			}
		} catch (Exception e1) {
			Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
		}		

		return lido;

	}

	public static int gerarNumeroPergunta(String tipoQuestao){
		int numQuestao = 0;
		int i = 0;
		while (i == 0){
			numQuestao = 60 *(Jogo.getQuestaoRodada()-1) + aleatorio.nextInt(59)+1;

			
			
			if( verificarPerguntasFeitas(numQuestao)){
				
				if(Jogo.isAdicao()){
					tipoQuestao = "+";
				}else if (Jogo.isSub()){
					tipoQuestao = "-";
				}else if(Jogo.isMult()){
					tipoQuestao = "x";
				}else if(Jogo.isDiv()){
					tipoQuestao = "/";
				}

				if(tipoQuestao.equals("/")){

					if(numQuestao >= 46 && numQuestao <= 60 || numQuestao >= 106 && numQuestao <= 120 
							|| numQuestao >= 166 && numQuestao <= 180){
						i=1;
					}
				}
				if(tipoQuestao.equals("+")){
					if(numQuestao >= 1 && numQuestao <= 15 || numQuestao >= 61 && numQuestao <= 75 
							|| numQuestao >= 121 && numQuestao <= 135){
						i=1;
					}
				}
				if(tipoQuestao.equals("-")){
					if(numQuestao >= 16 && numQuestao <= 30 || numQuestao >= 76 && numQuestao <= 90 
							|| numQuestao >= 136 && numQuestao <= 150){
						i=1;
					}
				}
				if(tipoQuestao.equals("x")){
					if(numQuestao >= 31 && numQuestao <= 45 || numQuestao >= 91 && numQuestao <= 105 
							|| numQuestao >= 151 && numQuestao <= 165){
						i=1;
					}
				}

				perguntasFeitas.add(numQuestao);
			}	
		}
		return numQuestao;
	}

	public static boolean verificarPerguntasFeitas(int numQuestao){
		for(int perguntas : perguntasFeitas){
			if(perguntas == numQuestao){
			
				return false;
			}
		}
		return true;		
	}

	public static ArrayList<Integer> getCartasUsadas() {
		return cartasUsadas;
	}


	public static  ArrayList<Cartas>getBancoDeCartas(){
		return bancoDeCartas; 
	}

}
