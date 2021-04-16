package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

@SuppressWarnings("serial")
public class JPanelHome extends JPanel{
	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // t�tulo que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JLabel jLabelHoras;
	private JLabel jLabelLogo;
	
	
	//** Fim declara��o de vari�veis **
	
	public JPanelHome() {
		this.getJPanelHome();
		this.addCompJPanelHome();
	}
	
	//** In�cio getters JPanels **
	
	public JPanelHome getJPanelHome() {
		this.setLayout(null);
		this.setSize(new Dimension(1030,674));
		this.setBackground(Cores.cinza4);
		this.setVisible(true);
	
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** In�cio getters JButon **
	
	
	
	//** Fim getters JButon **
	
	//** In�cio getters JLabel **
	
	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Home";	
		}
		return tituloDescricaoTela;
	}
	
	public JLabel getjLabelHoras() {
		if(jLabelHoras == null) {
			jLabelHoras = new JLabel();
			jLabelHoras.setFont(Fontes.fontJLabelBold4);
			jLabelHoras.setText("20:40");
			jLabelHoras.setForeground(Cores.azul1);
			jLabelHoras.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelHoras.setBorder(null);
			jLabelHoras.setSize(200,98);
		}
		return jLabelHoras;
	}
	
	
	public JLabel getjLabelLogo() {
		if(jLabelLogo == null) {
			jLabelLogo = new JLabel();
			jLabelLogo.setSize(807, 454);
			setSizeIcon.redimencionaImagem(jLabelLogo, "/images/logo.png");
		}
		return jLabelLogo;
	}

	//** Fim getters JLabel **
	
	//** In�cio m�todos adi��o de componentes **
	
	public void addCompJPanelHome(){
		this.getJPanelHome().add(getjLabelLogo());
		this.getjLabelLogo().setLocation(112, 163);

		this.getJPanelHome().add(getjLabelHoras());
		this.getjLabelHoras().setLocation(815, 1);
	}
	
	
	//** Fim m�todos adi��o de componentes **
	
	//** In�cio m�todos da classe **
	
	
	
	//** Fim m�todos da classe **
	

}
