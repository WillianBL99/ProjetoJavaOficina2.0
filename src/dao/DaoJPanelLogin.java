package dao;

public class DaoJPanelLogin {
	
	// recebe o usuario e a senha e realiza a validação.
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
