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
	 *  M�todo int getnumeroPreOrcamento().
	 *  Tem a fun��o de retornar o valor do or�amento seguinte.
	 *  Realiza uma busca no banco de dados e verifica o id do �ltimo
	 *  pr� or�amento ou or�amento final e soma 1 para cadastrar o proximo.
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
