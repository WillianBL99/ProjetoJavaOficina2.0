package dao;

public class DaoJPanelLogin {
	
	public boolean confLoginSenha(String usuario, String senha) {
		
		try {
			if(usuario.equals("") && senha.equals( ""))
				return true;
		} catch (Exception e) {
			System.out.println("congLoginSenha. Erro");
		}
		
		return false;
	}

}
