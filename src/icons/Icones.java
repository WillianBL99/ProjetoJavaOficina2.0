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
	
	private static String addCompra;
	private static String buscarCompra;
	private static String filtrar;
	private static String imprimir;
	private static String apagar;
	private static String salvar;
	
	
	
	
	public static String getSalvar() {
		if(salvar == null){
			salvar = ("/icons/save.png");
	
		}
		return salvar;
	}

	public static String getAddCompra() {
		if(addCompra == null){
			addCompra = ("/icons/cart-add-wht-96.png");
	
		}
		return addCompra;
	}

	public static String getBuscarCompra() {
		if(buscarCompra == null){
			buscarCompra = ("/icons/cart-search-wht-96.png");
	
		}
		return buscarCompra;
	}

	public static String getFiltrar() {
		if(filtrar == null){
			filtrar = ("/icons/filter-wht-100.png");
	
		}
		return filtrar;
	}

	public static String getImprimir() {
		if(imprimir == null){
			imprimir = ("/icons/printer-wht-100.png");
	
		}
		return imprimir;
	}

	public static String getApagar() {
		if(apagar == null){
			apagar = ("/icons/trash-can-wht-384.png");
	
		}
		return apagar;
	}

	public static String getUser() {
		if(user == null) {					
			user = ("/icons/user.png");
		}
		return user;		
	}
    
	public static String getHome() {
		if(home == null) {					
			home = ("/icons/home-wht-348.png");
		}
		return home;		
	}
	
	
	public static String getOS() {
		if(OS == null) {					
			OS = ("/icons/order-96.png");
		}
		return OS;
	}

	
	public static String getVendas() {
		if(vendas == null) {					
			vendas = ("/icons/buy-96.png");
		}
		return vendas;
	}

	
	public static String getOrcamento() {
		if(orcamento == null) {					
			orcamento = ("/icons/order-sell-96.png");
		}
		return orcamento;
	}

	
	public static String getVeiculos() {
		if(veiculos == null) {					
			veiculos = ("/icons/car-90.png");
		}
		return veiculos;
	}

	
	public static String getClientes() {
		if(clientes == null) {					
			clientes = ("/icons/users-90.png");
		}
		return clientes;
	}

	
	public static String getUsuarios() {
		if(usuarios == null) {					
			usuarios = ("/icons/user-480.png");
		}
		return usuarios;
	}

	
	public static String getEstoque() {
		if(estoque == null) {					
			estoque = ("/icons/cabinet-90.png");
		}
		return estoque;
	}

	
	public static String getConfiguracao() {
		if(configuracao == null) {					
			configuracao = ("/icons/settings-144.png");
		}
		return configuracao;
	}


	
	
	
	
	
}
