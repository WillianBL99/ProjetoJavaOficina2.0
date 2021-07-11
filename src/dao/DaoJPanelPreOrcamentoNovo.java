/**
 * 
 */
package dao;

import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelPreOrcamentoNovo {
	
	// Classe de consulta de dados no banco de dados
	private ModuloConexao moduloConexao;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	
	private int numeroPreOrcamento;
	
	
	/**
	 * Método void getListaProduotos().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getListaServicos() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do pré orçamento
			String id_orcamento = getjpanelPreOrcamentoNovo().getjTFieldNumeroPreOrcamento().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarServicosPreOrcamento(), id_orcamento);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpanelPreOrcamentoNovo().getjTableListaServicos().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Cod.",
										"Descrição.",
										"Desconto",
										"Preço",
										"Total"));
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
				System.out.println("sem serviços");
			}
			
			
		} catch(Exception e) {
			System.err.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return next;
	}

	
	/**
	 * Método void getListaProduotos().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getListaProduotos() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do pré orçamento
			String id_orcamento = getjpanelPreOrcamentoNovo().getjTFieldNumeroPreOrcamento().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarProdutosPreOrcamento(), id_orcamento);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpanelPreOrcamentoNovo().getjTableListaProdutos().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Cod.",
										"Qtd.",
										"Descrição",
										"Preço",
										"Total"));
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return next;
	}
	
	
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
	
	
	private JPanelPreOrcamentoNovo getjpanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null) {
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		
		return jPanelPreOrcamentoNovo;
	}
	
	


}
