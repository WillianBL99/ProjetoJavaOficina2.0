/**
 * 
 */
package dao;

import view.JPanelVendasNovo;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelVendasNovo {
	
	// Classe de consulta de dados no banco de dados
	private JPanelVendasNovo jPanelVendasNovo;
	private ModuloConexao moduloConexao;
	
	public DaoJPanelVendasNovo(JPanelVendasNovo jPanelVendasNovo) {
		this.jPanelVendasNovo = jPanelVendasNovo;
	}
	
	
	/**
	 * M�todo void pesquisarPorMarca().
	 * Tem a fun��o de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorMarca() {
		boolean status;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// Recebe o codigo do produto
			String marca_produto = getjPanelVendasNovo().getjTFieldInserirProdutoDesc().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutosMarca(), marca_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjPanelVendasNovo().getjTableInserirProduto().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				status = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				status = false;
			}
			
			
		} catch(Exception e) {
			System.err.println("Erro ao setar o jtable de jPanelEstoque\n" + e);
			status = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return status;
	}
	
	/**
	 * M�todo void pesquisarPorCodigo().
	 * Tem a fun��o de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorCodigo() {
		boolean status;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// Recebe o codigo do produto
			String cod_produto = getjPanelVendasNovo().getjTFieldInserirProdutoDesc().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutoID(), cod_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjPanelVendasNovo().getjTableInserirProduto().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				status = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				status = false;
			}
			
			
		} catch(Exception e) {
			System.err.println("Erro ao setar o jtable de jPanelEstoque\n" + e);
			status = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return status;
	}
		
	/**
	 * M�todo void pesquisarPorCodigo().
	 * Tem a fun��o de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorDescricao() {
		boolean status;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// Recebe a descri��o do produto
			String desc_produto = getjPanelVendasNovo().getjTFieldInserirProdutoDesc().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutosDescricao(), desc_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				System.out.println("ta preenchendo");
				getjPanelVendasNovo().getjTableInserirProduto().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				status = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				status = false;
			}
			
			
		} catch(Exception e) {
			System.err.println("Erro ao setar o jtable de jPanelEstoque\n" + e);
			status = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return status;
	}
	
	
	// Metodos getters e setters
	
	
	private JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null) {
			jPanelVendasNovo = new JPanelVendasNovo();
		}
		return jPanelVendasNovo;
	}
	
	
	private ModuloConexao getmoduloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
}
