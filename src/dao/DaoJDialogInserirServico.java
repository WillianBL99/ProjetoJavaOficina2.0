/**
 * 
 */
package dao;

import view.JDialogInserirProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogInserirServico {
	
	// Classe de consulta de dados no banco de dados
	private JDialogInserirProduto jDialogInserirProduto;
	private ModuloConexao moduloConexao;
	private JFramePrincipal jFramePrincipal;
	
	public DaoJDialogInserirServico(JFramePrincipal jFramePrincipal, JDialogInserirProduto jDialogInserirProduto) {
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogInserirProduto = jDialogInserirProduto;
	}
	
	
	/**
	 * Método void pesquisarPorMarca().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorMarca() {
		boolean status;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o codigo do produto
			String marca_produto = getjDialogInserirProduto().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutosMarca(), marca_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogInserirProduto().getjTablePecas().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
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
	
	/**
	 * Método void pesquisarPorCodigo().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorCodigo() {
		boolean status;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o codigo do produto
			String cod_produto = getjDialogInserirProduto().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutoID(), cod_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogInserirProduto().getjTablePecas().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
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
		
	/**
	 * Método void pesquisarPorCodigo().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean status
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean pesquisarPorDescricao() {
		boolean status;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe a descrição do produto
			String desc_produto = getjDialogInserirProduto().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutosDescricao(), desc_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				System.out.println("ta preenchendo");
				getjDialogInserirProduto().getjTablePecas().
						setModel(new PreencherTabela().
								preencher(getmoduloConexao().getResultSet(),
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
	
	
	
	
	
	/**
	 * Método isFirst() Verifica se o produto a ser inserido na lista de produtos da tela preOrcamentoNovo,
	 * não foi inserida anteriormente.
	 * @return Retorna verdadeiro se não encontrar outro id no banco de dados, e falso caso contrário.
	 */
	public boolean isFirst() {
		boolean status = false;
		getmoduloConexao().executeQuery(ComandosSQL.consultarProdutoID());
		if(getmoduloConexao().resultSetIsEmpty()) {
			status = true;
		}
		return status;
	}
	
	
	// Metodos getters e setters
	
	private JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	private JDialogInserirProduto getjDialogInserirProduto() {
		if(jDialogInserirProduto == null) {
			jDialogInserirProduto = new JDialogInserirProduto(getjFramePrincipal(), true);
		}
		return jDialogInserirProduto;
	}
	
	
	private ModuloConexao getmoduloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
}
