/**
 * 
 */
package dao;

/**
 * @author Paulo Uilian
 *
 */
public class ComandosSQL {
	
	
	private static String visualizarTodosPreOrcamentos;
	private static String visualizarTodosPreOrcamentos_data;
	private static String validarLogin;
	private static String consultarNumeroPreOrcamento;
	
	private static String consultarClientesTodosCampos;
	private static String consultarClientesNome;
	private static String consultarClientesCnpj;
	private static String consultarClientesCpf;
	
	private static String cadastrarClientesCnpj;
	private static String cadastrarClienteCpf;
	
	private static String consultarVeiculoID;
	private static String consultarVeiculoTodos;
	private static String consultarVeiculoTodosByCliente;
	private static String consultarVeiculoChassiByCliente;
	private static String consultarVeiculoPlacaByCliente;
	
	
	/*
	 * Método String getconsultarVeiculoTodos()
	 * Consulta todos os veiculos
	 */
	public static String getconsultarVeiculoID() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nº Veiculo", "Chassi", "Placa", km atual "Marca", "Modelo", "Motor", "Combustivel", "Cor", "Ano"
		 */
		if(consultarVeiculoID == null){
			consultarVeiculoID = (
				"select id_veiculo, chassi, placa, km_atual, marca, modelo, motor, combustivel, cor, ano from tb_veiculos "
				+ "where id_veiculo = ?;"
			);
		}
		return consultarVeiculoID;
	}
	
	
	/*
	 * Método String getconsultarVeiculoTodos()
	 * Consulta todos os veiculos
	 */
	public static String getconsultarVeiculoTodos() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nº Veiculo", "Placa", "Chassi", "Marca", "Modelo", "Motor", "Combustivel", "Cor", "Ano"
		 */
		if(consultarVeiculoTodos == null){
			consultarVeiculoTodos = (
				"select id_veiculo, chassi, placa, marca, modelo, motor, combustivel, cor, ano from tb_veiculos;"
			);
		}
		return consultarVeiculoTodos;
	}
	
	
	/*
	 * Método String getconsultarVeiculoTodosByCliente()
	 * Consulta um veiculo apartir da placa e do cliente
	 */
	public static String getconsultarVeiculoTodosByCliente() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nº Veiculo", "Placa", "Chassi", "Marca", "Modelo", "Motor", "Combustivel", "Cor", "Ano"
		 */
		if(consultarVeiculoTodosByCliente == null){
			consultarVeiculoTodosByCliente = (
				"select id_veiculo, chassi, placa, marca, modelo, motor, combustivel, cor, ano from "
				+ "tb_veiculos "
				+ "join "
				+ "tb_clientes "
				+ "on "
				+ "tb_veiculos.id_cliente = ? "
				+ "group by id_veiculo;"
			);
		}
		return consultarVeiculoTodosByCliente;
	}
	
	
	/*
	 * Método String getconsultarVeiculoPlacaByCliente()
	 * Consulta um veiculo apartir da placa  e do cliente
	 */
	public static String getconsultarVeiculoPlacaByCliente() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nº Veiculo", "Placa", "Chassi", "Marca", "Modelo", "Motor", "Combustivel", "Cor", "Ano"
		 */
		if(consultarVeiculoPlacaByCliente == null){
			consultarVeiculoPlacaByCliente = (
				"select id_veiculo, chassi, placa, marca, modelo, motor, combustivel, cor, ano from "
				+ "tb_veiculos "
				+ "join "
				+ "tb_clientes "
				+ "on "
				+ "tb_veiculos.id_cliente = ?"
				+ "where tb_veiculos.placa like concat('%', ?, '%');"
			);
		}
		return consultarVeiculoPlacaByCliente;
	}
	
	
	/*
	 * Método String getconsultarVeiculoChassiByCliente()
	 * Consulta um veiculo apartir do chassi e do cliente
	 */
	public static String getconsultarVeiculoChassiByCliente() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nº Veiculo", "Placa", "Chassi", "Marca", "Modelo", "Motor", "Combustivel", "Cor", "Ano"
		 */
		if(consultarVeiculoChassiByCliente == null){
			consultarVeiculoChassiByCliente = (
				"select id_veiculo, chassi, placa, marca, modelo, motor, combustivel, cor, ano from "
				+ "tb_veiculos "
				+ "join "
				+ "tb_clientes "
				+ "on "
				+ "tb_veiculos.id_cliente = ?"
				+ "where tb_veiculos.chassi like concat('%', ?, '%');"
			);
		}
		return consultarVeiculoChassiByCliente;
	}
	
	
	/*
	 * Método String getcadastrarClientesCnpj()
	 * Cadastrar um cliente com os dados inseridos
	 */
	public static String getcadastrarClientesCpf() {
		/*
		 * Lista dos nomes dos campos:
		 * "CPF", "Nome", "email", "Telefone", "Cidade", "Bairro", "Rua", "Nº Casa"
		 */
		if(cadastrarClientesCnpj == null){
			cadastrarClientesCnpj = (
				"insert into tb_clientes(cpf, nome, email, telefone, cidade, bairro, rua, numero) values\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?);"
			);
		}
		return cadastrarClientesCnpj;
	}
	
	
	/*
	 * Método String getconsultarClientesCpf()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getcadastrarClientesCnpj() {
		/*
		 * Lista dos nomes dos campos:
		 * "CNPj", "Nome", "email", "Telefone", "Cidade", "Bairro", "Rua", "Nº Casa"
		 */
		if(cadastrarClienteCpf == null){
			cadastrarClienteCpf = (
				"insert into tb_clientes(cnpj, nome, email, telefone, cidade, bairro, rua, numero) values\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?);"
			);
	
		}
		return cadastrarClienteCpf;
	}
		
	
	/*
	 * Método String getconsultarClientesCpf()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getconsultarClientesTodosCampos() {
		/*
		 * Lista dos nomes dos campos:
		 * "ID", "CPF", "CNPj", "Tipo", "Nome", "email", "Telefone", "Cidade", "Bairro", "Rua", "Nº Casa"
		 */
		if(consultarClientesTodosCampos == null){
			consultarClientesTodosCampos = (
				"select * from tb_clientes\r\n"
				+ "where id_cliente = ?;"
			);
	
		}
		return consultarClientesTodosCampos;
	}
	
	
	/*
	 * Método String getconsultarClientesCpf()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getconsultarClientesCpf() {
		/*
		 * Lista dos nomes dos campos:
		 * "CNPj", "CPF", "Nome", "email", "Telefone", "Cidade"
		 */
		if(consultarClientesCpf == null){
			consultarClientesCpf = (
				"select id_cliente, cnpj, cpf, nome, email, telefone, cidade from tb_clientes\r\n"
				+ "where cpf = ?\r\n"
				+ "order by nome;"
			);
	
		}
		return consultarClientesCpf;
	}
	
	
	/*
	 * Método String getconsultarClientesCpf()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getconsultarClientesCnpj() {
		/*
		 * Lista dos nomes dos campos:
		 * "CNPj", "CPF", "Nome", "email", "Telefone", "Cidade"
		 */
		if(consultarClientesCnpj == null){
			consultarClientesCnpj = (
				"select id_cliente, cnpj, cpf, nome, email, telefone, cidade from tb_clientes\r\n"
				+ "where cnpj = ?\r\n"
				+ "order by nome;"
			);
	
		}
		return consultarClientesCnpj;
	}
	
	
	/*
	 * Método String getconsultarClientesCpf()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getconsultarClientesNome() {
		/*
		 * Lista dos nomes dos campos:
		 * "CNPj", "CPF", "Nome", "email", "Telefone", "Cidade"
		 */
		if(consultarClientesNome == null){
			consultarClientesNome = (
				"select id_cliente, cnpj, cpf, nome, email, telefone, cidade from tb_clientes\r\n"
				+ "where nome like concat('%', ?,'%')\r\n"
				+ "order by nome;"
			);
	
		}
		return consultarClientesNome;
	}
	
	
	/*
	 * Método String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a função de exibir todos os pré orçamentos criados
	 */
	public static String getconsultarNumeroPreOrcamento() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Serviços", "Produtos", "Desconto", "Total"
		 */
		if(consultarNumeroPreOrcamento == null){
			consultarNumeroPreOrcamento = (
					"select (ifnull(max(tb_orc.id_orcamento), 0)) from tb_orcamentos as tb_orc"
			);
	
		}
		return consultarNumeroPreOrcamento;
	}
	
	
	/*
	 * Método String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a função de exibir todos os pré orçamentos criados
	 */
	public static String getvisualizarTodosPreOrcamentos() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Serviços", "Produtos", "Desconto", "Total"
		 */
		if(visualizarTodosPreOrcamentos == null){
			visualizarTodosPreOrcamentos = (
					"select\r\n"
					+ "date_format(pre_orc.data, '%d/%m/%y - %T') as data,\r\n"
					+ "    vec.placa,\r\n"
					+ "    cli.nome,\r\n"
					+ "ifnull(sum(pre_orc_serv.quantidade * pre_orc_serv.preco_produto), 0),\r\n"
					+ "    ifnull(sum(pre_orc_prod.quantidade * pre_orc_prod.preco_produto), 0),\r\n"
					+ "    (ifnull(sum(pre_orc_serv.desconto), 0) + ifnull(sum(pre_orc_prod.desconto), 0) + ifnull(pre_orc.desconto, 0)),\r\n"
					+ "    ((ifnull(sum(pre_orc_serv.quantidade * pre_orc_serv.preco_produto), 0)) +\r\n"
					+ "    (ifnull(sum(pre_orc_prod.quantidade * pre_orc_prod.preco_produto), 0)) -\r\n"
					+ "	   (ifnull(sum(pre_orc_serv.desconto), 0) + ifnull(sum(pre_orc_prod.desconto), 0) + ifnull(pre_orc.desconto, 0))\r\n"
					+ "    )\r\n"
					+ "from \r\n"
					+ "tb_orcamentos as orc right outer join\r\n"
					+ "tb_pre_orcamento as pre_orc\r\n"
					+ "on ( orc.id_pre_orcamento = pre_orc.id_pre_orcamento) left outer join\r\n"
					+ "\r\n"
					+ "tb_pre_orcamento_produto as pre_orc_prod \r\n"
					+ "on (pre_orc.id_pre_orcamento = pre_orc_prod.id_pre_orcamento) left join\r\n"
					+ "\r\n"
					+ "tb_pre_orcamento_servico as pre_orc_serv\r\n"
					+ "on (pre_orc.id_pre_orcamento = pre_orc_serv.id_pre_orcamento) join\r\n"
					+ "\r\n"
					+ "tb_veiculos as vec\r\n"
					+ "on (orc.id_veiculo = vec.id_veiculo) join \r\n"
					+ "\r\n"
					+ "tb_clientes as cli\r\n"
					+ "on ( orc.id_cliente = cli.id_cliente)\r\n"
					+ "\r\n"
					// "where date_format(pre_orc.data, '%d/%m/%y') between '06/06/2021' and ?"
					+ "group by pre_orc.id_pre_orcamento"
			);
	
		}
		return visualizarTodosPreOrcamentos;
	}
	
	
	/*
	 * Método String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a função de exibir  os pré orçamentos de acordo com um intervalo de tempo
	 * 1° "?" a data inicial da consulta
	 * 2º "?" a data final da consulta
	 */
	public static String getvisualizarTodosPreOrcamentos_data() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Serviços", "Produtos", "Desconto", "Total"
		 */
		if(visualizarTodosPreOrcamentos_data == null){
			visualizarTodosPreOrcamentos_data = (
					"select\r\n"
					+ "date_format(pre_orc.data, '%d/%m/%y - %T') as data,\r\n"
					+ "    vec.placa,\r\n"
					+ "    cli.nome,\r\n"
					+ "ifnull(sum(pre_orc_serv.quantidade * pre_orc_serv.preco_produto), 0),\r\n"
					+ "    ifnull(sum(pre_orc_prod.quantidade * pre_orc_prod.preco_produto), 0),\r\n"
					+ "    (ifnull(sum(pre_orc_serv.desconto), 0) + ifnull(sum(pre_orc_prod.desconto), 0) + ifnull(pre_orc.desconto, 0)),\r\n"
					+ "    ((ifnull(sum(pre_orc_serv.quantidade * pre_orc_serv.preco_produto), 0)) +\r\n"
					+ "    (ifnull(sum(pre_orc_prod.quantidade * pre_orc_prod.preco_produto), 0)) -\r\n"
					+ "	   (ifnull(sum(pre_orc_serv.desconto), 0) + ifnull(sum(pre_orc_prod.desconto), 0) + ifnull(pre_orc.desconto, 0))\r\n"
					+ "    )\r\n"
					+ "from \r\n"
					+ "tb_orcamentos as orc right outer join\r\n"
					+ "tb_pre_orcamento as pre_orc\r\n"
					+ "on ( orc.id_pre_orcamento = pre_orc.id_pre_orcamento) left outer join\r\n"
					+ "\r\n"
					+ "tb_pre_orcamento_produto as pre_orc_prod \r\n"
					+ "on (pre_orc.id_pre_orcamento = pre_orc_prod.id_pre_orcamento) left join\r\n"
					+ "\r\n"
					+ "tb_pre_orcamento_servico as pre_orc_serv\r\n"
					+ "on (pre_orc.id_pre_orcamento = pre_orc_serv.id_pre_orcamento) join\r\n"
					+ "\r\n"
					+ "tb_veiculos as vec\r\n"
					+ "on (orc.id_veiculo = vec.id_veiculo) join \r\n"
					+ "\r\n"
					+ "tb_clientes as cli\r\n"
					+ "on ( orc.id_cliente = cli.id_cliente)\r\n"
					+ "\r\n"
					+ "where date_format(pre_orc.data, '%d/%m/%y') between ? and ?"
					+ "group by pre_orc.id_pre_orcamento"
			);
	
		}
		return visualizarTodosPreOrcamentos_data;
	}
	
	
	/* Método String getvalidarLogin()
	 * retorna uma linha se existir o usuario e senho requisitado
	 * 1° "?" o nome do usuário
	 * 2º "?" a senha do usuario
	 */
	public static String getvalidarLogin() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Serviços", "Produtos", "Desconto", "Total"
		 */
		if(validarLogin == null){
			validarLogin = (
					"select * from tb_usuarios where usuario =? and senha =?"
			);
	
		}
		return validarLogin;
	}
	
}
