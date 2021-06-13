package dao;

public class DaoJPanelLogin {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	
	
	/*
	 *  recebe o usuario e a senha e realiza a valida��o.
	 *  se retornar 0, a houve erro na consulta do BD
	 *  se retornar 1, a consulta foi realizada e os valores foram encontrados
	 *  se retornar 2, a consulta foi realizada e o(s) valor(es) n�o foram encontrados
	 */
	public int loginSenha(String usuario, String senha) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getvalidarLogin(), usuario, senha);
			
			// Se os valores forem encontrados
			if(getModuloConexao().getResultSet().next()) {
				// O usu�rio e senha foram encontrados no banco de dados
				getModuloConexao().closeConnection();
				return 1;
			} else {
				// n�o foram encontrado os valores
				getModuloConexao().closeConnection();
				return 2;
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao consultar banco de dados.\n" + e);
			getModuloConexao().closeConnection();
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
