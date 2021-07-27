/**
 * 
 */
package dao;

import view.JPanelVendas;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelVendas {
	
	// Classe de consulta de dados no banco de dados
	private JPanelVendas jPanelVendas;
	private ModuloConexao moduloConexao;
	
	public DaoJPanelVendas(JPanelVendas jPanelVendas) {
		this.jPanelVendas = jPanelVendas;
	}

	
	/*
	 *  Método void consultaVendasDinheiro().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas no dinheiro.
	 */
	public boolean consultaVendasDinheiro() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasDinheiro());
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"Nº",
							"Data",
							"Vendedor",
							"Cliente",
							"Forma Pag.",
							"Qtd. Peças",
							"Desconto",
							"Total"));
				
				configuraTabela();
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	/*
	 *  Método void consultaVendasData(data1, data2).
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas entre duas datas.
	 */
	public boolean consultaVendasData(String data1, String data2) {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasEntreData(), data1, data2);
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				System.out.println("formatou");
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
				setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
								"Nº",
								"Data",
								"Vendedor",
								"Cliente",
								"Forma Pag.",
								"Qtd. Peças",
								"Desconto",
								"Total"));
				
				configuraTabela();
				next = true;
				
				// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}

	
	/*
	 *  Método void consultaVendasCartao().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas no cartão.
	 */
	public boolean consultaVendasCartao() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasCartao());

			System.out.println("pesquisa cartão2");
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"Nº",
							"Data",
							"Vendedor",
							"Cliente",
							"Forma Pag.",
							"Qtd. Peças",
							"Desconto",
							"Total"));
				
				configuraTabela();
				next = true;

				System.out.println("pesquisa cartão3");
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}

	
	/*
	 *  Método void consultaVendasVendedor().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas relacionada a um vendedor.
	 */
	public boolean consultaVendasVendedor(String vendedor) {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasVendedor(), vendedor);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"Nº",
							"Data",
							"Vendedor",
							"Cliente",
							"Forma Pag.",
							"Qtd. Peças",
							"Desconto",
							"Total"));
				
				configuraTabela();
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	/*
	 *  Método void consultarVendas().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas relacionada a um cliente.
	 */
	public boolean consultaVendasCliente(String cliente) {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasCliente(), cliente);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"Nº",
							"Data",
							"Vendedor",
							"Cliente",
							"Forma Pag.",
							"Qtd. Peças",
							"Desconto",
							"Total"));
				
				configuraTabela();
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	
	/*
	 *  Método void consultarVendas().
	 *  Tem a função de preencher a table depois de executar uma query
	 *  de busca de todas as vendas.
	 */
	public boolean consultarVendas() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.consultarVendasTodasTodas());
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjpJPanelVendas().getjTableVendas().
					setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
							"Nº",
							"Data",
							"Vendedor",
							"Cliente",
							"Forma Pag.",
							"Qtd. Peças",
							"Desconto",
							"Total"));
				
				configuraTabela();				
				next = true;
				getModuloConexao().getConnection().close();
				moduloConexao = null;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarveiculo\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		return next;
	}
	
	// Metodos getters e setters
	
	
	private void configuraTabela() {
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(0).setMaxWidth(50);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(4).setMaxWidth(110);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(4).setMinWidth(110);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(5).setMaxWidth(110);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(5).setMinWidth(110);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(6).setMaxWidth(90);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(6).setMinWidth(90);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(7).setMaxWidth(90);
		getjpJPanelVendas().getjTableVendas().getColumnModel().getColumn(7).setMinWidth(90);
	}
	
	private JPanelVendas getjpJPanelVendas() {
		if(jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


}
