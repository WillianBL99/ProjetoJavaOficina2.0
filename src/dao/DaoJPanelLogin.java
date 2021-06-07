package dao;

public class DaoJPanelLogin {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	
	// Comando sql para validação do login. Os "?" serão substituidos por valores específicos
	private String sql = "select * from tb_usuarios where usuario =? and senha =?";
	
	
	/*
	 *  recebe o usuario e a senha e realiza a validação.
	 *  se retornar 0, a houve erro na consulta do BD
	 *  se retornar 1, a consulta foi realizada e os valores foram encontrados
	 *  se retornar 2, a consulta foi realizada e o(s) valor(es) não foram encontrados
	 */
	public int loginSenha(String usuario, String senha) {
		
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(sql, new String[]{usuario, senha});
			
			// Se os valores forem encontrados
			if(getModuloConexao().getResultSet().next()) {
				// O usuário e senha foram encontrados no banco de dados
				return 1;
			} else {
				return 2;
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao consultar banco de dados.\n" + e);
			return 0;
		}
	}
	

	// Metodos getters e setters
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}
	
	


}
