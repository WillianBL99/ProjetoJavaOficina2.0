/**
 * 
 */
package dao;

import javax.swing.JOptionPane;

import view.JDialogProcurarCliente;

/**
 * @author pWili
 *
 */
public class DaoJDialogProcurarCliente {
	
	// Classe de consulta de dados no banco de dados
	private JDialogProcurarCliente jDialogProcurarCliente;
	private ModuloConexao moduloConexao;
	
	private String nome;
	private int cpf;
	private int cnpj;
	
	public DaoJDialogProcurarCliente(JDialogProcurarCliente jDialogProcurarCliente) {
		this.jDialogProcurarCliente = jDialogProcurarCliente;
	}
	
	
	/*
	 *  M�todo void getClienteNome().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de clientes atrav�s do nome.
	 */
	public void getClienteNome(String nome) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesNome(), nome);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(getModuloConexao().getResultSet().next()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"CNPj",
										"CPF",
										"Nome",
										"email",
										"Telefone",
										"Cidade"));
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						jDialogProcurarCliente, // componente
						"N�o foi encontrado nenhum cliente com o nome procurardo.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
		}
	}
	

	/*
	 *  M�todo void getClienteCpf().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de clientes atrav�s do cpf.
	 */
	public void getClienteCpf(String cpf) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesCpf(), cpf);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(getModuloConexao().getResultSet().next()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
				setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
								"CNPj",
								"CPF",
								"Nome",
								"email",
								"Telefone",
								"Cidade"));
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						jDialogProcurarCliente, // componente
						"N�o foi encontrado nenhum cliente com o CPF procurardo.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}

			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
		}
	}
	
	
	/*
	 *  M�todo void getClienteCnpj().
	 *  Tem a fun��o de preencher a table depois de executar uma query
	 *  de busca de clientes atrav�s do cnpj.
	 */
	public void getClienteCnpj(String cnpj) {
		
		// Tratamento de exce��es no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesCnpj(), cnpj);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(getModuloConexao().getResultSet().next()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
				setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
								"CNPj",
								"CPF",
								"Nome",
								"email",
								"Telefone",
								"Cidade"));
			
			// Se n�o retornou nenhum valor exibe um caixa de alerta	
			} else {
				JOptionPane.showConfirmDialog(
						jDialogProcurarCliente, // componente
						"N�o foi encontrado nenhum cliente com o CNPj procurardo.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao setar o jtable de jdialogprocurarcliente\n" + e);
		}
	}
	
	
	// Metodos getters e setters
	
	
	private JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null) {
			jDialogProcurarCliente = new JDialogProcurarCliente(null, false);
		}
		
		return jDialogProcurarCliente;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		
		return moduloConexao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public int getCnpj() {
		return cnpj;
	}


	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	


}
