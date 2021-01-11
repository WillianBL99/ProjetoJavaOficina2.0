package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cores;
import model.SetSizeIcon;

public class JPanelHome extends JPanel{
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private JLabel jLabelHoras;
	private JLabel jLabelLogo;
	
	
	//** Fim declaração de variáveis **
	
	public JPanelHome() {
		this.addCompJPanelHome();
	}
	
	//** Início getters JPanels **
	
	public JPanelHome getJPanelHome() {
		this.setLayout(null);
		this.setSize(new Dimension(1030,674));
		this.setBackground(Cores.cinza4);
		this.setVisible(true);
	
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JButon **
	
	
	
	//** Fim getters JButon **
	
	//** Início getters JLabel **
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
	
	//** Início métodos adição de componentes **
	
	public void addCompJPanelHome(){
		this.getJPanelHome().add(getjLabelLogo());
		this.getjLabelLogo().setLocation(112, 163);
	}
	
	
	//** Fim métodos adição de componentes **
	
	//** Início métodos da classe **
	
	
	
	//** Fim métodos da classe **
	

}
