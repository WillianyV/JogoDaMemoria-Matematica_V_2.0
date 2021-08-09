package view;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class TelaPrincipal extends JFrame{
	
	public static int altura = 601;
	public static int largura = 960;
	
	private PanelJogo pJogo;
	private PanelMenu pMenu;
	private PanelQuestoes pQuestoes;
	private PanelInicio pInicio;
	private PanelCredito pCredito;
	private PanelFinalJogo pFinalJogo;
	private BufferedImage buffer;
	
	//METODO CONSTRUTOR
	public TelaPrincipal(){
		setSize(largura,altura);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//nao tem para que
		setLayout(null);
		setUndecorated(true);//Desativando Bordas JFrame
		
		pMenu = new PanelMenu();
		pJogo = new PanelJogo();
		pQuestoes = new PanelQuestoes(this);
		buffer = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		
		pInicio= new PanelInicio();
		pCredito = new PanelCredito();
		pFinalJogo = new PanelFinalJogo();
		
		add(pMenu).setBounds(0, 0, largura, altura);
		add(pJogo).setBounds(0, 0, largura, altura);
		add(pQuestoes).setBounds(0, 0, largura, altura);
		add(pInicio).setBounds(0, 0, largura, altura);
		add(pCredito).setBounds(0, 0, largura, altura);
		add(pFinalJogo).setBounds(0, 0, largura, altura);
		
		setVisible(true);
	}
	
	//METODOS ACESSORES
	public PanelJogo getpJogo() {
		return pJogo;
	}

	public void setpJogo(PanelJogo pJogo) {
		this.pJogo = pJogo;
	}

	public PanelMenu getpMenu() {
		return pMenu;
	}

	public void setpMenu(PanelMenu pMenu) {
		this.pMenu = pMenu;
	}

	public PanelQuestoes getpQuestoes() {
		return pQuestoes;
	}

	public void setpQuestoes(PanelQuestoes pQuestoes) {
		this.pQuestoes = pQuestoes;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}

	public PanelInicio getpInicio() {
		return pInicio;
	}

	public void setpInicio(PanelInicio pInicio) {
		this.pInicio = pInicio;
	}

	public PanelCredito getpCredito() {
		return pCredito;
	}

	public void setpCredito(PanelCredito pCredito) {
		this.pCredito = pCredito;
	}

	public PanelFinalJogo getpFinalJogo() {
		return pFinalJogo;
	}

	public void setpFinalJogo(PanelFinalJogo pFinalJogo) {
		this.pFinalJogo = pFinalJogo;
	}
}
