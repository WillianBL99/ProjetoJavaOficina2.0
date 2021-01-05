package icons;

import java.awt.Image;

import javax.swing.JPanel;

public class Icones {
	
	
	
	private static String home;
	private static String estoque; 
	private static String vender;
	private static String vendas;
	private static String configuracao;    
    
	public static String getHome(JPanel jPanel) {
		if(home == null) {			
			
			home = ("/icons/home-wht-348.png");
		}
		return home;		
	}
	
	
	public static String getEstoque(JPanel jPanel) {
		if(estoque == null) {
			estoque = ("/icons/filing-cabinet-48.png");
		}
		return estoque;
	}
	
	
	public static String getVender(JPanel jPanel) {
		if(vender == null) {
			vender = ("/icons/icons8-sell-48.png");
		}
		return vender;
	}
	
	
	public static String getVendas(JPanel jPanel) {
		if(vendas == null) {
			vendas = ("/icons/accounting-30.png");
		}
		return vendas;
	}
	
	
	public static String getConfiguracao(JPanel jPanel) {
		if(configuracao == null) {
			configuracao = ("/icons/settings-50.png");
		}
		return configuracao;
	}
	
	
	
}
