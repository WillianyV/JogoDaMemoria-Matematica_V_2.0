package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	private JButton jogarButton, sairButton,creditosButton;
	private ImageIcon menuImageIcon;
	private boolean rodar;

	public PanelMenu(){
		setLayout(null);
		rodar = true; 
		
		jogarButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTAOjogar.png"));
		sairButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTAOsair.png"));
		creditosButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTOEScreditos.png"));
		menuImageIcon = new ImageIcon("Resource/Imagens/Interface/INICIO.png");
		
		add(jogarButton).setBounds(400, 330, 150, 62);
		add(creditosButton).setBounds(400, 400, 150, 62);
		add(sairButton).setBounds(400, 470, 150, 61);

		setVisible(true);
	}

	//METODOS ACESSORES
	public JButton getJogar() {
		return jogarButton;
	}

	public JButton getSair() {
		return sairButton;
	}

	public boolean isRodar() {
		return rodar;
	}

	public void setRodar(boolean rodar) {
		this.rodar = rodar;
	}

	public ImageIcon getMenuImageIcon() {
		return menuImageIcon;
	}

	public void setMenuImageIcon(ImageIcon menuImageIcon) {
		this.menuImageIcon = menuImageIcon;
	}

	public JButton getCreditosButton() {
		return creditosButton;
	}
}
