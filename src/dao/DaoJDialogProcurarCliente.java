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
	
	/**
	 * Método void getClienteTodos().
	 * Tem a função de preencher a table depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getClienteTodos() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesTodaLinhas());
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Nº",
										"CNPj",
										"CPF",
										"Nome",
										"email",
										"Telefone",
										"Cidade"));
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
	
	
	/**
	 * Método void getClienteNome(@nome).
	 * Tem a função de preencher a table depois de executar uma query
	 * @param nome // recebe nome do cliente a ser procurado
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getClienteNome(String nome) {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesNome(), nome);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
						setModel(new PreencherTabela().
								preencher(getModuloConexao().getResultSet(),
										"Nº",
										"CNPj",
										"CPF",
										"Nome",
										"email",
										"Telefone",
										"Cidade"));
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
	

	/**
	 * Método void getClienteCpf(@cpf).
	 * Tem a função de preencher a table depois de executar uma query
	 * @param cpf // recebe cpf do cliente a ser procurado
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getClienteCpf(String cpf) {

		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesCpf(), cpf);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
				setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
								"Nº",
								"CNPj",
								"CPF",
								"Nome",
								"email",
								"Telefone",
								"Cidade"));
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
	
	
	/**
	 * Método void getClienteCnpj(@cnpj).
	 * Tem a função de preencher a table depois de executar uma query
	 * @param cnpj // recebe cnpj do cliente a ser procurado
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getClienteCnpj(String cnpj) {

		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getModuloConexao().executeQuery(ComandosSQL.getconsultarClientesCnpj(), cnpj);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getModuloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento da tabela de jdialogprocurarcliente
				getjDialogProcurarCliente().getjTableCliente().
				setModel(new PreencherTabela().
						preencher(getModuloConexao().getResultSet(),
								"Nº",
								"CNPj",
								"CPF",
								"Nome",
								"email",
								"Telefone",
								"Cidade"));next = true;
			
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
