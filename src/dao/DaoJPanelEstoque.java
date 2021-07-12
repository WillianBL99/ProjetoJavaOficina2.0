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
	 * Método void getListaProduotos().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean atualizarTabelaProdutos() {
		boolean status;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutos());
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjPanelEstoque().getjTableEstoque().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										 "Código",
										 "Descrição",
										 "Marca",
										 "Quantidade",
										 "Preço"));
				status = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
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
}
