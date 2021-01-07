package icons;


import javax.swing.JPanel;

public class Icones {
	
	
	private static String user;
	private static String home;
	private static String OS;
	private static String vendas;
	private static String orcamento;
	private static String veiculos;
	private static String clientes;
	private static String usuarios;
	private static String estoque;
	private static String configuracao;
	
	
	public static String getUser(JPanel jPanel) {
		if(user == null) {					
			user = ("/icons/user.png");
		}
		return user;		
	}
    
	public static String getHome(JPanel jPanel) {
		if(home == null) {					
			home = ("/icons/home-wht-348.png");
		}
		return home;		
	}
	
	
	public static String getOS(JPanel jPanel) {
		if(OS == null) {					
			OS = ("/icons/order-96.png");
		}
		return OS;
	}

	
	public static String getVendas(JPanel jPanel) {
		if(vendas == null) {					
			vendas = ("/icons/buy-96.png");
		}
		return vendas;
	}

	
	public static String getOrcamento(JPanel jPanel) {
		if(orcamento == null) {					
			orcamento = ("/icons/order-sell-96.png");
		}
		return orcamento;
	}

	
	public static String getVeiculos(JPanel jPanel) {
		if(veiculos == null) {					
			veiculos = ("/icons/car-90.png");
		}
		return veiculos;
	}

	
	public static String getClientes(JPanel jPanel) {
		if(clientes == null) {					
			clientes = ("/icons/users-90.png");
		}
		return clientes;
	}

	
	public static String getUsuarios(JPanel jPanel) {
		if(usuarios == null) {					
			usuarios = ("/icons/user-480.png");
		}
		return usuarios;
	}

	
	public static String getEstoque(JPanel jPanel) {
		if(estoque == null) {					
			estoque = ("/icons/cabinet-90.png");
		}
		return estoque;
	}

	
	public static String getConfiguracao(JPanel jPanel) {
		if(configuracao == null) {					
			configuracao = ("/icons/settings-144.png");
		}
		return configuracao;
	}
	
	
	
	
	
}
