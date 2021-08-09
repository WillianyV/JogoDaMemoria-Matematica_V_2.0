package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCredito  extends JPanel{

	private boolean rodarPCredito;
	private ImageIcon bImagem;
	private JButton voltarButton, sairPCButton;

	public PanelCredito(){
		setLayout(null);
		setIgnoreRepaint(true);
		setVisible(false);
		rodarPCredito = false;

		sairPCButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTAOsair.png"));
		voltarButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTAOvoltar.png"));
		bImagem = new ImageIcon("Resource/Imagens/Interface/backg.png");

		add(voltarButton).setBounds(400, 400, 150, 61);
		add(sairPCButton).setBounds(400, 470, 150, 62);
	}

	//METODOS ACESSORES
	public boolean isRodarPCredito() {
		return rodarPCredito;
	}

	public void setRodarPCredito(boolean rodarPCredito) {
		this.rodarPCredito = rodarPCredito;
	}

	public ImageIcon getbImagem() {
		return bImagem;
	}

	public void setbImagem(ImageIcon bImagem) {
		this.bImagem = bImagem;
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}

	public JButton getSairPCButton() {
		return sairPCButton;
	}

	public void setSairPCButton(JButton sairPCButton) {
		this.sairPCButton = sairPCButton;
	}

}
