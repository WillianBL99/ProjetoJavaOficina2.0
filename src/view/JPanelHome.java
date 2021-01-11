package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cores;
import model.SetSizeIcon;

public class JPanelHome extends JPanel{
	
	//** In�cio declara��o de vari�veis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JLabel jLabelHoras;
	private JLabel jLabelLogo;
	
	
	//** Fim declara��o de vari�veis **
	
	public JPanelHome() {
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
	public JLabel getjLabelHoras() {
		if(jLabelHoras == null) {
			jLabelHoras = new JLabel();
			jLabelHoras.setSize(807, 454);
			setSizeIcon.redimencionaImagem(jLabelHoras, "/images/logo.png");
		}
		return jLabelHoras;
	}
	
	
	public JLabel getjLabelLogo() {
		return jLabelLogo;
	}

	//** Fim getters JLabel **
	
	//** In�cio m�todos adi��o de componentes **
	
	public void addCompJPanelHome(){
		this.getJPanelHome().add(getjLabelLogo());
		this.getjLabelLogo().setLocation(112, 163);
	}
	
	
	//** Fim m�todos adi��o de componentes **
	
	//** In�cio m�todos da classe **
	
	
	
	//** Fim m�todos da classe **
	

}
