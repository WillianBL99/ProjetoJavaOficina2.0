/**
 * 
 */
package dao;

/**
 * @author Paulo Uilian
 *
 */
public class ComandosSQL {
	
	private static String consultaProdutoID;
	private static String consultarProdutos;
	private static String consultarProdutosDescricao;
	private static String consultarProdutosCod;
	private static String consultarProdutosMarca;
	
	private static String cadastrarProduto;
	
	private static String deletarProduto;
	
	private static String alterarProdutoQtd;
	private static String alterarProdutoPreco;
	private static String alterarProdutoDescricao;
	private static String alterarProdutoMarca;
	
	private static String consultarNomesUsuarios;
	private static String consultarUsuarios;
	
	private static String consultarProdutosPreOrcamento;
	private static String consultarServicosPreOrcamento;
	
	private static String visualizarTodosPreOrcamentos;
	private static String visualizarTodosPreOrcamentos_data;
	private static String validarLogin;
	private static String consultarNumeroPreOrcamento;
	
	private static String consultarClientesTodosCampos;
	private static String consultarClientesTodasLinhas;
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
	
	private static String cadastrarVeiculo;
	
	
	/**
	 * Método getconsultarProdutosMarca() realiza a consulta dos produtos cadastrados com a
	 * marca procurada.
	 * @param Passar como parametro para o método ModuloConexao.ExecuteQuery(sql, "Marca")
	 * @return retorna a query de consulta dos produtos cadastrados com a descriação procurada.
	 */
	public static String getconsultarProdutosMarca() {
		if(consultarProdutosMarca == null){
			consultarProdutosMarca = (
				"select id_produto, descricao, marca, quantidade, preco from tb_produtos\r\n"
				+ "where marca like concat('%', ?, '%')\r\n"
				+ "group by id_produto;"
			);
		}
		return consultarProdutosMarca;
	}
	
	
	/**
	 * Método getconsultarProdutosCodigo() realiza a consulta dos produtos cadastrados com o
	 * código procurado.
	 * @param Passar como parametro para o método ModuloConexao.ExecuteQuery(sql, "Codigo")
	 * @return retorna a query de consulta dos produtos cadastrados com a descriação procurada.
	 */
	public static String getconsultarProdutosCodigo() {
		if(consultarProdutosCod == null){
			consultarProdutosCod = (
				"select id_produto, descricao, marca, quantidade, preco from tb_produtos\r\n"
				+ "where id_produto like concat('%', ?, '%')\r\n"
				+ "group by id_produto;"
			);
		}
		return consultarProdutosCod;
	}
	
	
	/**
	 * Método getconsultarProdutosDescricao() realiza a consulta dos produtos cadastrados com a
	 * descrição procurada.
	 * @param Passar como parametro para o método ModuloConexao.ExecuteQuery(sql, "Descrição")
	 * @return retorna a query de consulta dos produtos cadastrados com a descriação procurada.
	 */
	public static String getconsultarProdutosDescricao() {
		if(consultarProdutosDescricao == null){
			consultarProdutosDescricao = (
				"select id_produto, descricao, marca, quantidade, preco from tb_produtos\r\n"
				+ "where descricao like concat('%', ?, '%')\r\n"
				+ "group by id_produto;"
			);
		}
		return consultarProdutosDescricao;
	}
	
	
	/**
	 * Método getalterarProdutoMarca() altera a marca de um produto no estoque
	 * @param Passar como parametro para o método Cadastrar.ExecuteUpdate(sql, "marca", "ID")
	 * @return retorna a query de alteração da quantidade de um produto cadastrado.
	 */
	public static String getalterarProdutoMarca() {
		if(alterarProdutoMarca == null){
			alterarProdutoMarca = (
				"update tb_produtos set marca = ? "
				+ "where id_produto = ?;"
			);
		}
		return alterarProdutoMarca;
	}
	
	
	/**
	 * Método getalterarProdutoDescricao() altera a descrição um produto no estoque
	 * @param Passar como parametro para o método Cadastrar.ExecuteUpdate(sql, "descrição", "ID")
	 * @return retorna a query de alteração da quantidade de um produto cadastrado.
	 */
	public static String getalterarProdutoDescricao() {
		if(alterarProdutoDescricao == null){
			alterarProdutoDescricao = (
				"update tb_produtos set descricao = ? "
				+ "where id_produto = ?;"
			);
		}
		return alterarProdutoDescricao;
	}
	
	
	/**
	 * Método getalterarProdutoPreco() altera o valor de um produto no estoque
	 * @param Passar como parametro para o método Cadastrar.ExecuteUpdate(sql, "Novo valor", "ID")
	 * @return retorna a query de alteração da quantidade de um produto cadastrado.
	 */
	public static String getalterarProdutoPreco() {
		if(alterarProdutoPreco == null){
			alterarProdutoPreco = (
				"update tb_produtos set preco = ? "
				+ "where id_produto = ?;"
			);
		}
		return alterarProdutoPreco;
	}
	
	
	/**
	 * Método getalterarProdutoQtd() altera a quantidade de um produto no estoque
	 * @param Passar como parametro para o método Cadastrar.ExecuteUpdate(sql, "Nova quantidade", "ID")
	 * @return retorna a query de alteração da quantidade de um produto cadastrado.
	 */
	public static String getalterarProdutoQtd() {
		if(alterarProdutoQtd == null){
			alterarProdutoQtd = (
				"update tb_produtos set quantidade = ? "
				+ "where id_produto = ?;"
			);
		}
		return alterarProdutoQtd;
	}
	
	
	/**
	 * Método getdeletarProduto() deleta um produto de acordo com id
	 * @param Passar como parametro para o método ModuloConexao.ExecuteQuery(sql, "ID")
	 * @return retorna a query de exclusão de produto cadastrado.
	 */
	public static String getdeletarProduto() {
		if(deletarProduto == null){
			deletarProduto = (
				"delete from tb_produtos where id_produto = ?;"
			);
		}
		return deletarProduto;
	}
	
	
	/**
	 * Método getconsultarProdutosID() realiza a consulta dos ids cadastrados
	 * @param Passar como parametro para o método ModuloConexao.ExecuteQuery(sql, "ID")
	 * @return retorna a query de consulta dos ids dos produtos cadastrados.
	 */
	public static String getconsultarProdutoID() {
		if(consultaProdutoID == null){
			consultaProdutoID = (
				"select id_produto, descricao, marca, quantidade, preco from tb_produtos\r\n"
				+ "where id_produto = ?"
			);
		}
		return consultaProdutoID;
	}
	
	
	/**
	 * Método String getcadastrarProduto()
	 * Cadastrar um produto com os dados inseridos.
	 * @param Passar comos parametros para o método Cadastrar.ExecutUpdate(sql, "Código", "Descrição", "Marca", "Quantidade", "Preço")
	 * @return Retorna uma query que cadastra um produto com os valores passados nos campos do método Cadastrar.ExecutUpdate(sql,campos...);
	 */
	public static String getcadastrarProduto() {
		if(cadastrarProduto == null){
			cadastrarProduto = (
				"insert into tb_produtos(id_produto, descricao, marca, quantidade, preco) values\n"
				+ "(?, ?, ?, ?, ?);"
			);
		}
		return cadastrarProduto;
	}
	
	
	/**
	 * Método getconsultarUsuarios() realiza a consulta os usuarios cadastrados
	 * @return retorna a query de consulta dos nomes dos usuarios.
	 */
	public static String getconsultarUsuarios() {
		/*
		 * Lista dos nomes dos campos:
		 *  "CPF", "Nome", "Email", "Telefone", "Cidade", "Usuário", "Senha", "Função"
		 */
		if(consultarUsuarios == null){
			consultarUsuarios = (
				"select\r\n"
				+ "cpf,\r\n"
				+ "nome,\r\n"
				+ "email,\r\n"
				+ "telefone,\r\n"
				+ "cidade,\r\n"
				+ "usuario,\r\n"
				+ "senha,\r\n"
				+ "funcao\r\n"
				+ "from tb_usuarios;"
			);
		}
		return consultarUsuarios;
	}
	
	
	/**
	 * Método getconsultarProdutos() realiza a consulta dos produtos cadastrados
	 * @return retorna a query de consulta dos produtos cadastrados.
	 */
	public static String getconsultarProdutos() {
		/*
		 * Lista dos nomes dos campos:
		 * "Código", "Descrição", "Marca", "Quantidade", "Preço"
		 */
		if(consultarProdutos == null){
			consultarProdutos = (
				"select id_produto, descricao, marca, quantidade, preco from tb_produtos"
			);
		}
		return consultarProdutos;
	}
	
	
	/**
	 * Método getconsultarNomesUsuarios() realiza a consulta dos nomes dos usuarios
	 * @return retorna a query de consulta dos nomes dos usuarios.
	 */
	public static String getconsultarNomesUsuarios() {
		/*
		 * Lista dos nomes dos campos:
		 * "Nome"
		 */
		if(consultarNomesUsuarios == null){
			consultarNomesUsuarios = (
				"select nome from tb_usuarios"
			);
		}
		return consultarNomesUsuarios;
	}
	
	
	/**
	 * Método getconsultarServicosPreOrcamento() realiza a consulta dos produtos associados
	 * a um pré orçamento.
	 * @param passar como segundo parametro no método preencher() da classe PreencherTabela()
	 * o id do pre_orcamento
	 * @return retorna a query de consulta dos produtos requisitados em um pré orçamento.
	 */
	public static String getconsultarServicosPreOrcamento() {
		/*
		 * Lista dos nomes dos campos:
		 * "Cod.", "Descrição.", "Desconto", "Preço", "Total"
		 */
		if(consultarServicosPreOrcamento == null){
			consultarServicosPreOrcamento = (
					"select \r\n"
					+ "	id_servico,\r\n"
					+ "	(select descricao from tb_servicos where id_servico = tb_pre_orcamento_servico.id_servico),\r\n"
					+ "	quantidade,\r\n"
					+ "	preco_produto, (quantidade * preco_produto)\r\n"
					+ "	from tb_pre_orcamento_servico \r\n"
					+ "	where id_pre_orcamento = ?\r\n"
					+ "	order by id_servico;"
			);
		}
		return consultarServicosPreOrcamento;
	}
	
	
	/**
	 * Método getconsultarProdutosPreOrcamento() realiza a consulta dos produtos associados
	 * a um pré orçamento.
	 * @param passar como segundo parametro no método preencher() da classe PreencherTabela()
	 * o id do pre_orcamento
	 * @return retorna a query de consulta dos produtos requisitados em um pré orçamento.
	 */
	public static String getconsultarProdutosPreOrcamento() {
		/*
		 * Lista dos nomes dos campos:
		 * "Cod.", "Qtd.", "Descrição", "Preço", "Total"
		 */
		if(consultarProdutosPreOrcamento == null){
			consultarProdutosPreOrcamento = (
					"select \r\n"
					+ "id_produto,\r\n"
					+ "quantidade,\r\n"
					+ "(select descricao from tb_produtos where id_produto = tb_pre_orcamento_produto.id_produto),\r\n"
					+ "preco_produto, (quantidade * preco_produto)\r\n"
					+ "from tb_pre_orcamento_produto \r\n"
					+ "where id_pre_orcamento = ?\r\n"
					+ "order by id_produto;"
			);
		}
		return consultarProdutosPreOrcamento;
	}
	
	
	/*
	 * Método String getcadastrarVeiculo()
	 * Cadastrar um veículo com os dados inseridos
	 * e associa à um cliente prviamente selecionado
	 */
	public static String getcadastrarVeiculo() {
		/*
		 * Lista dos nomes dos campos:
		 * "Chassi", "Placa", "km atual", "Marca", "Modelo", "Motor", "Combustível", "Cor", "Ano", "ID Cliente"
		 */
		if(cadastrarVeiculo == null){
			cadastrarVeiculo = (
				"insert into tb_veiculos(chassi, placa, km_atual, marca, modelo, motor, combustivel, cor, ano, id_cliente) values\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
			);
		}
		return cadastrarVeiculo;
	}
	
	
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
				+ "where tb_veiculos.placa like concat('%', ?, '%') "
				+ "group by id_veiculo;"
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
				+ "where tb_veiculos.chassi like concat('%', ?, '%') \"\r\n"
				+ "group by id_veiculo;"
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
	 * Método String getconsultarClientesTodaLinhas()
	 * Retorna a query que tem a função de exibir todos os clientes
	 */
	public static String getconsultarClientesTodaLinhas() {
		/*
		 * Lista dos nomes dos campos:
		 * "ID", "CPF", "CNPj", "Tipo", "Nome", "email", "Telefone", "Cidade", "Bairro", "Rua", "Nº Casa"
		 */
		if(consultarClientesTodasLinhas == null){
			consultarClientesTodasLinhas = (
				"select id_cliente, cnpj, cpf, nome, email, telefone, cidade from tb_clientes\r\n"
						+ "order by nome;"
			);
	
		}
		return consultarClientesTodasLinhas;
	}
		
	
	/*
	 * Método String getconsultarClientesTodosCampos()
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
