package icons;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Icones {
	
	private static ImageIcon home;
	private static ImageIcon estoque; 
	private static ImageIcon vender;
	private static ImageIcon vendas;
	private static ImageIcon configuracao;

	
	
	public static ImageIcon getHome(JPanel jPanel) {
		if(home == null) {
			home = new ImageIcon(jPanel.getClass().getResource("/icons/home-48.png"));
		}
		return home;
	}
	
	
	public static ImageIcon getEstoque(JPanel jPanel) {
		if(estoque == null) {
			estoque = new ImageIcon(jPanel.getClass().getResource("/icons/filing-cabinet-48.png"));
		}
		return estoque;
	}
	
	
	public static ImageIcon getVender(JPanel jPanel) {
		if(vender == null) {
			vender = new ImageIcon(jPanel.getClass().getResource("/icons/icons8-sell-48.png"));
		}
		return vender;
	}
	
	
	public static ImageIcon getVendas(JPanel jPanel) {
		if(vendas == null) {
			vendas = new ImageIcon(jPanel.getClass().getResource("/icons/accounting-30.png"));
		}
		return vendas;
	}
	
	
	public static ImageIcon getConfiguracao(JPanel jPanel) {
		if(configuracao == null) {
			configuracao = new ImageIcon(jPanel.getClass().getResource("/icons/settings-50.png"));
		}
		return configuracao;
	}
}
