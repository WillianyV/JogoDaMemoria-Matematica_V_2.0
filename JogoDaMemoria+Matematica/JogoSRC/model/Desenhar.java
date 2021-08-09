package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import view.Mensagem;
import view.TelaPrincipal;

public class Desenhar {	

	private static boolean cond = true;
	
	public static void desenharNaTela(TelaPrincipal tela){
		
		String cronometro = "";
		Font fonte = new Font("MV Boli",Font.BOLD,25);
		Color rosa = new Color(199,21,133);

		Graphics2D g2 = (Graphics2D) tela.getGraphics(); 	
		Graphics g = tela.getBuffer().getGraphics();
		g2.drawImage(tela.getBuffer(), 0, 0, null);

		if(tela.getpMenu().isRodar()){
			/*
			 * PANEL MENU
			 */			
			g.drawImage(tela.getpMenu().getMenuImageIcon().getImage(), 0, 0, null);
			tela.getpMenu().getJogar().repaint();
			tela.getpMenu().getCreditosButton().repaint();
			tela.getpMenu().getSair().repaint();
		}
		else if(tela.getpJogo().isRodarPJogo()){
			/*
			 * PANEL JOGO
			 */
			g.drawImage(tela.getpJogo().getBackImagem().getImage(),0,0,null);
			g.drawImage(tela.getpJogo().getxImage().getImage(), 880, 30, null);			

			try {
				g.setColor(rosa);
				g.setFont(fonte);
				g.drawString("Jogadas: "+ Jogador.getJogadasJogador1(),100 , 110);
				g.drawString(Jogador.getNomeJogador1(), 100, 70);
				g.setColor(Color.WHITE);
				g.drawString(Integer.toString(Jogador.getAcertosJogador1()), 150, 590);	
				if (cond){
					cronometro = Cronometro.getTempo(); 
				}
				g.drawString(cronometro, 800, 590);

			} catch (Exception e) {
				//Mensagem.mensagemExibir("Não foi possivel desenhar no jogo");
			}

			try {

				g.drawImage(tela.getpJogo().getCartasNojogo()[0].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[0].getCartasSprite().aparencia],
						100, 150, null);

				g.drawImage(tela.getpJogo().getCartasNojogo()[1].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[1].getCartasSprite().aparencia],
						310, 150, null);

				g.drawImage(tela.getpJogo().getCartasNojogo()[2].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[2].getCartasSprite().aparencia],
						520, 150, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[3].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[3].getCartasSprite().aparencia],
						730, 150, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[4].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[4].getCartasSprite().aparencia],
						100, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[5].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[5].getCartasSprite().aparencia],
						310, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[6].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[6].getCartasSprite().aparencia],
						520, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[7].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[7].getCartasSprite().aparencia],
						730, 350, null);

			} catch (Exception e) {
				//Mensagem.mensagemExibir("Não foi possivel desenhar no jogo");
			}	


		}
		else if (tela.getpQuestoes().isRodarPQuestoes()){
			/*
			 * PANEL QUESTÕES
			 */
			g.setFont(fonte);
			g.setColor(Color.WHITE);
			g.drawImage(tela.getpQuestoes().getpQuestoesImageIcon().getImage(), 0, 0, null);
			
			if(Jogo.getQuestaoRodada() == 1){
				g.drawString("1º RESPONDA A QUESTÃO ABAIXO:", 70, 90);
			}else if(Jogo.getQuestaoRodada() == 2){
				g.drawString("2º QUAL O NÚMERO QUE FALTA NA ", 70, 90);
				g.drawString("OPERAÇÃO ABAIXO?", 70, 120);
			}else if(Jogo.getQuestaoRodada() == 3){
				g.drawString("3º CLIQUE NO SINAL CORRETO.", 70, 90);
				
			}
			
			g.drawString(tela.getpQuestoes().getQuestoes().getPergunta(),400, 200);

			for(int i=0;i<4;i++){
				tela.getpQuestoes().getAlternativasButton().get(i).repaint();
			}

			g.drawImage(tela.getpQuestoes().getRespostas().get(0).getResposta().sprites[
			                tela.getpQuestoes().getRespostas().get(0).getResposta().aparencia], 
							tela.getpQuestoes().getRespostas().get(0).getPosX(), 
							tela.getpQuestoes().getRespostas().get(0).getPosY(), null);

			g.drawImage(tela.getpQuestoes().getRespostas().get(1).getResposta().sprites[
			                tela.getpQuestoes().getRespostas().get(1).getResposta().aparencia], 
							tela.getpQuestoes().getRespostas().get(1).getPosX(), 
							tela.getpQuestoes().getRespostas().get(1).getPosY(), null);
		}
		else if(tela.getpCredito().isRodarPCredito()){
			/*
			 * CREDITOS
			 */
			g.setFont(fonte);
			g.setColor(rosa);
			g.drawImage(tela.getpCredito().getbImagem().getImage(), 0, 0, null);
			g.drawString("Créditos", 420, 233);
			g.drawString("WILLIANY VERAS", 370, 280);
			g.drawString("M.P.O.O.", 410, 330);
			g.drawString("3º périodo de  B.S.I.", 350, 380);
			tela.getpCredito().getVoltarButton().repaint();
			tela.getpCredito().getSairPCButton().repaint();
			
		}
		else if(tela.getpInicio().isRodarPInico()){
			g.setFont(fonte);
			g.setColor(rosa);
			g.drawImage(tela.getpInicio().getFundoInicioImagem().getImage(),0,0,null);
			g.drawString("Digite o seu nome:", 200, 233);
			g.drawString("Escolhas as operações:", 200, 285);
			g.drawString("Escolhas os níveis das operações:", 200, 385);
			
			tela.getpInicio().getNomeField().repaint();
			tela.getpInicio().getTodasRButton().repaint();
			tela.getpInicio().getAdicaoRButton().repaint();
			tela.getpInicio().getSubtracaoRButton().repaint();
			tela.getpInicio().getMultiplicacaoRButton().repaint();
			tela.getpInicio().getDivisaoRButton().repaint();
			
			tela.getpInicio().getFacilRButton().repaint();
			tela.getpInicio().getMedioRButton().repaint();
			tela.getpInicio().getDificil().repaint();
			
			tela.getpInicio().getComecarButton().repaint();
		
			
		}else if(tela.getpFinalJogo().isRodarPFredito()){
			/*
			 * FINAL
			 */
			
			g.setFont(fonte);
			g.setColor(rosa);
			g.drawImage(tela.getpCredito().getbImagem().getImage(), 0, 0, null);
			g.drawString("Parabéns", 420, 233);
			g.drawString("Jogador: "+ Jogador.getNomeJogador1() , 340, 280);
			g.drawString("Acertos: " + Jogador.getAcertosJogador1(), 370, 330);
			g.drawString("Jogadas: " + Jogador.getJogadasJogador1(), 370, 380);
			g.drawString("Duração do Jogo: " + Jogo.getTempoFinal(), 310, 430);
			tela.getpFinalJogo().getSairPFButton().repaint();
		}
		
	}

	public static boolean isCond() {
		return cond;
	}

	public static void setCond(boolean cond) {
		Desenhar.cond = cond;
	}
	
	

}
