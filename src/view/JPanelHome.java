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
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JLabel jLabelHoras;
	private JLabel jLabelLogo;
	
	
	//** Fim declaração de variáveis **
	
	public JPanelHome() {
		this.getJPanelHome();
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
	
	//** Início métodos adição de componentes **
	
	public void addCompJPanelHome(){
		this.getJPanelHome().add(getjLabelLogo());
		this.getjLabelLogo().setLocation(112, 163);

		this.getJPanelHome().add(getjLabelHoras());
		this.getjLabelHoras().setLocation(815, 1);
	}
	
	
	//** Fim métodos adição de componentes **
	
	//** Início métodos da classe **
	
	
	
	//** Fim métodos da classe **
	

}
