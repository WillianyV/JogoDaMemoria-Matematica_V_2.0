package view;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class PanelInicio extends JPanel {

	private boolean rodarPInico;
	private ImageIcon fundoInicioImagem;
	private JButton comecarButton;
	
	private JTextField nomeField;
	private ButtonGroup operacoesGroup, nivesGroup;
	private JRadioButton adicaoRButton, subtracaoRButton, multiplicacaoRButton, divisaoRButton,
						todasRButton,facilRButton, medioRButton, dificil;
	
	public PanelInicio(){
		setLayout(null);
		setIgnoreRepaint(true);
		
		rodarPInico = false;
		comecarButton = new JButton(new ImageIcon("Resource/Imagens/Interface/BOTOEScomecar.png"));
		fundoInicioImagem = new ImageIcon("Resource/Imagens/Interface/backg.png");
		
		nomeField = new JTextField(15);
		
		operacoesGroup = new ButtonGroup();
		nivesGroup = new ButtonGroup();
		
		todasRButton = new JRadioButton("Todas",true);
		adicaoRButton = new JRadioButton("Adição");
		subtracaoRButton = new JRadioButton("Subtração");
		multiplicacaoRButton = new JRadioButton("Multiplicação");
		divisaoRButton = new JRadioButton("Divisão");
		facilRButton = new JRadioButton("Facil",true);
		medioRButton = new JRadioButton("Médio");
		dificil= new JRadioButton("Difícil");
		
		
		add(nomeField).setBounds(450, 205,200, 30);
		add(todasRButton).setBounds(200, 300, 70, 30);
		add(adicaoRButton).setBounds(270, 300, 70, 30);
		add(subtracaoRButton).setBounds(340, 300, 100, 30);
		add(multiplicacaoRButton).setBounds(440, 300, 110, 30);
		add(divisaoRButton).setBounds(550, 300, 70, 30);
		operacoesGroup.add(todasRButton);
		operacoesGroup.add(adicaoRButton);
		operacoesGroup.add(subtracaoRButton);
		operacoesGroup.add(multiplicacaoRButton);
		operacoesGroup.add(divisaoRButton);
		add(facilRButton).setBounds(200, 410, 70, 30);
		add(medioRButton).setBounds(270, 410, 70, 30);
		add(dificil).setBounds(340, 410, 70, 30);
		nivesGroup.add(facilRButton);
		nivesGroup.add(medioRButton);
		nivesGroup.add(dificil);
		
		add(comecarButton).setBounds(660, 500, 150, 62);
		
		setVisible(false);
	}

	public JButton getComecarButton() {
		return comecarButton;
	}

	public boolean isRodarPInico() {
		return rodarPInico;
	}

	public void setRodarPInico(boolean rodarPInico) {
		this.rodarPInico = rodarPInico;
	}

	public ImageIcon getFundoInicioImagem() {
		return fundoInicioImagem;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public ButtonGroup getOperacoesGroup() {
		return operacoesGroup;
	}

	public ButtonGroup getNivesGroup() {
		return nivesGroup;
	}

	public JRadioButton getAdicaoRButton() {
		return adicaoRButton;
	}

	public JRadioButton getSubtracaoRButton() {
		return subtracaoRButton;
	}

	public JRadioButton getMultiplicacaoRButton() {
		return multiplicacaoRButton;
	}

	public JRadioButton getDivisaoRButton() {
		return divisaoRButton;
	}

	public JRadioButton getTodasRButton() {
		return todasRButton;
	}

	public JRadioButton getFacilRButton() {
		return facilRButton;
	}

	public JRadioButton getMedioRButton() {
		return medioRButton;
	}

	public JRadioButton getDificil() {
		return dificil;
	}
	
}
