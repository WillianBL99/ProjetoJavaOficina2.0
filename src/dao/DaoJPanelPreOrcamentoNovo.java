/**
 * 
 */
package dao;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelPreOrcamentoNovo {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	
	private int numeroPreOrcamento;
	
	/*
	 *  recebe o usuario e a senha e realiza a valida��o.
	 *  se retornar 0, a houve erro na consulta do BD
	 *  se retornar 1, a consulta foi realizada e os valores foram encontrados
	 *  se retornar 2, a consulta foi realizada e o(s) valor(es) n�o foram encontrados
	 */
	/*public int loginSenha(String usuario, String senha) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(sql, new String[]{usuario, senha});
			
			// Se os valores forem encontrados
			if(getModuloConexao().getResultSet().next()) {
				// O usu�rio e senha foram encontrados no banco de dados
				return 1;
			} else {
				return 2;
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao consultar banco de dados.\n" + e);
			return 0;
		}
	}*/
	
	/*
	 *  recebe o usuario e a senha e realiza a valida��o.
	 *  se retornar 0, a houve erro na consulta do BD
	 *  se retornar 1, a consulta foi realizada e os valores foram encontrados
	 *  se retornar 2, a consulta foi realizada e o(s) valor(es) n�o foram encontrados
	 */
	public int getnumeroPreOrcamento() {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarNumeroPreOrcamento());
			
			// Next() seleciona coloca o cursor na primeira linha
			getModuloConexao().getResultSet().next();
			// retorna o numero do preorcamento e soma 1 para criar novo numero
			numeroPreOrcamento = getModuloConexao().getResultSet().getInt(1) + 1;
			
			return numeroPreOrcamento;
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtextfield numero do pre or�amento\n" + e);
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
