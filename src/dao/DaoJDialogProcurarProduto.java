/**
 * 
 */
package dao;
import view.JDialogProcurarPeca;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogProcurarProduto {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	private JDialogProcurarPeca jDialogProcurarPeca;
	private JFramePrincipal jFramePrincipal;
	
	public DaoJDialogProcurarProduto(JFramePrincipal jFramePrincipal, JDialogProcurarPeca jDialogProcurarPeca) {
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogProcurarPeca = jDialogProcurarPeca;
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
			String marca_produto = getjDialogProcurarPeca().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosMarca(), marca_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarPeca().getjTablePecas().
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
			System.err.println("Erro ao setar o jtable de jDialogProcurarPeca\n" + e);
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
			String cod_produto = getjDialogProcurarPeca().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosCodigo(), cod_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarPeca().getjTablePecas().
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
			System.err.println("Erro ao setar o jtable de jDialogProcurarPeca\n" + e);
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
			String desc_produto = getjDialogProcurarPeca().getjTFieldProcurar().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosDescricao(), desc_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				System.out.println("ta preenchendo");
				getjDialogProcurarPeca().getjTablePecas().
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
			System.err.println("Erro ao setar o jtable de jDialogProcurarPeca\n" + e);
			status = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return status;
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
				getjDialogProcurarPeca().getjTablePecas().
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
			System.err.println("Erro ao setar o jtable de jDialogProcurarPeca\n" + e);
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
	
	
	private JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		
		return jFramePrincipal;
	}
	

	private JDialogProcurarPeca getjDialogProcurarPeca() {
		if(jDialogProcurarPeca == null) {
			jDialogProcurarPeca = new JDialogProcurarPeca(getjFramePrincipal(), true);
		}
		
		return jDialogProcurarPeca;
	}
}
