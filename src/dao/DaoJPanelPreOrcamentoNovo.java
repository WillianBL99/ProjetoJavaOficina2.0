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
	 *  Método int getnumeroPreOrcamento().
	 *  Tem a função de retornar o valor do orçamento seguinte.
	 *  Realiza uma busca no banco de dados e verifica o id do último
	 *  pré orçamento ou orçamento final e soma 1 para cadastrar o proximo.
	 */
	public int getnumeroPreOrcamento() {
		
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarNumeroPreOrcamento());
			
			// Next() seleciona coloca o cursor na primeira linha
			getModuloConexao().getResultSet().next();
			// retorna o numero do preorcamento e soma 1 para criar novo numero
			numeroPreOrcamento = getModuloConexao().getResultSet().getInt(1) + 1;

			return numeroPreOrcamento;
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtextfield numero do pre orçamento\n" + e);
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
