/**
 * 
 */
package dao;

import view.JPanelEstoque;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelEstoque {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	private JPanelEstoque jPanelEstoque;
	
	public DaoJPanelEstoque(JPanelEstoque jPanelEstoque) {
		this.jPanelEstoque = jPanelEstoque;
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
			String marca_produto = getjPanelEstoque().getjTFieldBuscarPor().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosMarca(), marca_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjPanelEstoque().getjTableEstoque().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				configurarJTable();
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
			String cod_produto = getjPanelEstoque().getjTFieldBuscarPor().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosCodigo(), cod_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjPanelEstoque().getjTableEstoque().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				configurarJTable();
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
			String desc_produto = getjPanelEstoque().getjTFieldBuscarPor().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosDescricao(), desc_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				System.out.println("ta preenchendo");
				getjPanelEstoque().getjTableEstoque().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										 "C�digo",
										 "Descri��o",
										 "Marca",
										 "Quantidade",
										 "Pre�o"));
				configurarJTable();
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
		 * M�todo void getListaProduotos().
		 * Tem a fun��o de preencher a table depois de executar uma query
		 * @return boolean status
		 * false - Se a consulta n�o retornar nenhuma linha
		 * true - Se a consulta retornar linhas
		 */
		public boolean atualizarTabelaProdutos() {
			boolean status;
			// Tratamento de exce��es no momento de consulta do banco de dados
			try {
				// As linhas abaixo realizam a consulta de dados do banco de dados
				getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutos());
				
				// Verifica se foi retornado algum valor do banco de dados
				if(!getModuloConexao().resultSetIsEmpty()) {
					// Realiza o preenchimento da tabela de jdialogprocurarcliente
					getjPanelEstoque().getjTableEstoque().
							setModel(new PreencherTabela().
									preencher(getModuloConexao().getResultSet(),
											 "C�digo",
											 "Descri��o",
											 "Marca",
											 "Quantidade",
											 "Pre�o"));
					configurarJTable();
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
	 * M�todo void deletarProduto().
	 * Tem a fun��o de deletar um produto de acordo com o id
	 * @return boolean status
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean deletarProduto(String id) {
		boolean status;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// usando o m�todo executeUpdate da classe Cadastrar para excluir linha de tabela
			if(new Cadastrar().executeUpdate(ComandosSQL.getdeletarProduto(), id)) {
				configurarJTable();
				status = true;
			} else {
				status = false;
			}
		} catch(Exception e) {
			System.err.println("Erro ao deletar produto daoJpanelEstoque" + e);
			status = false; 
		}		
		return status;
	}

	// Metodos getters e setters
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}
	

	private JPanelEstoque getjPanelEstoque() {
		if(jPanelEstoque == null) {
			jPanelEstoque = new JPanelEstoque();
		}
		
		return jPanelEstoque;
	}
	
	
	private void configurarJTable() {
		getjPanelEstoque().getjTableEstoque().getColumnModel().getColumn(0).setMaxWidth(80);
		getjPanelEstoque().getjTableEstoque().getColumnModel().getColumn(2).setMaxWidth(300);
		getjPanelEstoque().getjTableEstoque().getColumnModel().getColumn(2).setMinWidth(250);
		getjPanelEstoque().getjTableEstoque().getColumnModel().getColumn(3).setMaxWidth(80);
		getjPanelEstoque().getjTableEstoque().getColumnModel().getColumn(4).setMaxWidth(100);
	}
}
