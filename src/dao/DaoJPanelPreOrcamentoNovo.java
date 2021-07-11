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
	 * M�todo void getListaProduotos().
	 * Tem a fun��o de preencher a table depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getListaServicos() {
		boolean next;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// Recebe o id do pr� or�amento
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
										"Descri��o.",
										"Desconto",
										"Pre�o",
										"Total"));
				next = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
				System.out.println("sem servi�os");
			}
			
			
		} catch(Exception e) {
			System.err.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return next;
	}

	
	/**
	 * M�todo void getListaProduotos().
	 * Tem a fun��o de preencher a table depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta n�o retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getListaProduotos() {
		boolean next;
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// Recebe o id do pr� or�amento
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
										"Descri��o",
										"Pre�o",
										"Total"));
				next = true;
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
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
	
	
	private JPanelPreOrcamentoNovo getjpanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null) {
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		
		return jPanelPreOrcamentoNovo;
	}
	
	


}
