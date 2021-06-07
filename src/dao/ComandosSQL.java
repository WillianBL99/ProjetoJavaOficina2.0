/**
 * 
 */
package dao;

/**
 * @author pWili
 *
 */
public class ComandosSQL {
	
	
	private static String visualizarTodosPreOrcamentos;
	private static String visualizarTodosPreOrcamentos_data;
	private static String validarLogin;
	private static String consultarNumeroPreOrcamento;
	
	
	/*
	 * M�todo String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a fun��o de exibir todos os pr� or�amentos criados
	 */
	public static String getconsultarNumeroPreOrcamento() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Servi�os", "Produtos", "Desconto", "Total"
		 */
		if(consultarNumeroPreOrcamento == null){
			consultarNumeroPreOrcamento = (
					"select (ifnull(max(tb_orc.id_orcamento), 0)) from tb_orcamentos as tb_orc"
			);
	
		}
		return consultarNumeroPreOrcamento;
	}
	
	/*
	 * M�todo String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a fun��o de exibir todos os pr� or�amentos criados
	 */
	public static String getvisualizarTodosPreOrcamentos() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Servi�os", "Produtos", "Desconto", "Total"
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
	 * M�todo String getvisualizarTodosPreOrcamentos()
	 * Retorna a query que tem a fun��o de exibir  os pr� or�amentos de acordo com um intervalo de tempo
	 * 1� "?" a data inicial da consulta
	 * 2� "?" a data final da consulta
	 */
	public static String getvisualizarTodosPreOrcamentos_data() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Servi�os", "Produtos", "Desconto", "Total"
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
	
	
	/* M�todo String getvalidarLogin()
	 * retorna uma linha se existir o usuario e senho requisitado
	 * 1� "?" o nome do usu�rio
	 * 2� "?" a senha do usuario
	 */
	public static String getvalidarLogin() {
		/*
		 * Lista dos nomes dos campos:
		 * "Data", "Placa", "Cliente", "Servi�os", "Produtos", "Desconto", "Total"
		 */
		if(validarLogin == null){
			validarLogin = (
					"select * from tb_usuarios where usuario =? and senha =?"
			);
	
		}
		return validarLogin;
	}
	
}
