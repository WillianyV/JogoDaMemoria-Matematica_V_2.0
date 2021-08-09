package view;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Objetos;
import model.Questoes;
import model.Sprite;

public class PanelQuestoes extends JPanel {

	private ArrayList<JButton> alternativasButton = new ArrayList<JButton>(); 
	private ArrayList<Objetos> respostas = new ArrayList<Objetos>();
	
	private boolean rodarPQuestoes;
	private ImageIcon pQuestoesImageIcon;
	private TelaPrincipal telaPrincipal;	
	private Questoes questoes;

	public PanelQuestoes(TelaPrincipal telaPrincipal){
		setLayout(null);
		setIgnoreRepaint(true);
		setVisible(false);

		this.telaPrincipal = telaPrincipal;
		rodarPQuestoes = false;
		pQuestoesImageIcon = new ImageIcon("Resource/Imagens/Interface/pquestoes.png");

		try {
			respostas.add(new Objetos(new Sprite("Resource/Imagens/Interface/SpriteCorreto.png", 0, 135, 137, 6, 1, 650, 120)));
			respostas.add(new Objetos(new Sprite("Resource/Imagens/Interface/SpriteErrado.png", 0, 135, 137, 6, 1, 650, 120)));
		} catch (IOException e) {
			Mensagem.mensagemExibir("Erro a criar o sprite");
		}
		

		for(int i=0; i<4; i++){
			alternativasButton.add(new JButton());
			alternativasButton.get(i).setBackground(Color.WHITE);
			alternativasButton.get(i).setFont(new Font("Arial",Font.BOLD,14));
		}
		
		add(alternativasButton.get(0)).setBounds(200, 260, 100, 40);
		add(alternativasButton.get(1)).setBounds(350, 260, 100, 40);
		add(alternativasButton.get(2)).setBounds(500, 260, 100, 40);
		add(alternativasButton.get(3)).setBounds(650, 260, 100, 40);
	}

	//METODOS PERSONALIZADOS
	public void alternativas(){
		for(int i=0; i<4; i++){
			alternativasButton.get(i).setText(questoes.getAlternativas()[i]);
		}
	}
	 public void voltarTelaJogo(){
			telaPrincipal.getpJogo().setVisible(true);				
			telaPrincipal.getpJogo().setRodarPJogo(true);
	 }

	
	//METODOS ACESSORES
	public boolean isRodarPQuestoes() {
		return rodarPQuestoes;
	}

	public void setRodarPQuestoes(boolean rodarPQuestoes) {
		this.rodarPQuestoes = rodarPQuestoes;
	}

	public ImageIcon getpQuestoesImageIcon() {
		return pQuestoesImageIcon;
	}

	public void setpQuestoesImageIcon(ImageIcon pQuestoesImageIcon) {
		this.pQuestoesImageIcon = pQuestoesImageIcon;
	}

	public ArrayList<JButton> getAlternativasButton() {
		return alternativasButton;
	}

	public void setAlternativasButton(ArrayList<JButton> alternativasButton) {
		this.alternativasButton = alternativasButton;
	}

	public Questoes getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}

	public ArrayList<Objetos> getRespostas() {
		return respostas;
	}
	
	
}
