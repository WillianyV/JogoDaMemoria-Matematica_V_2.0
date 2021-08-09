package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelFinalJogo extends JPanel{

	private boolean rodarPF;
	private ImageIcon fundoImagem;
	private JButton  sairPFButton;
	
	
	public PanelFinalJogo(){
		setLayout(null);
		setIgnoreRepaint(true);
		setVisible(false);
		rodarPF = false;
		
		sairPFButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTAOsair.png"));
		fundoImagem = new ImageIcon("Resource/Imagens/Interface/backg.png");

		add(sairPFButton).setBounds(400, 500, 150, 62);
	}

	public boolean isRodarPFredito() {
		return rodarPF;
	}

	public void setRodarPFredito(boolean rodarPFredito) {
		this.rodarPF = rodarPFredito;
	}

	public ImageIcon getFundoImagem() {
		return fundoImagem;
	}

	public void setFundoImagem(ImageIcon fundoImagem) {
		this.fundoImagem = fundoImagem;
	}

	public JButton getSairPFButton() {
		return sairPFButton;
	}

	public void setSairPFButton(JButton sairPFButton) {
		this.sairPFButton = sairPFButton;
	}

}
