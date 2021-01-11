package dao;

public class DaoJPanelLogin {
	
	public boolean confLoginSenha(String usuario, String senha) {
		
		try {
			if(usuario.equals("uilian") && senha.equals( "654987"))
				return true;
		} catch (Exception e) {
			System.out.println("congLoginSenha. Erro");
		}
		
		return false;
	}

}
