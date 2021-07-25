/**
 * 
 */
package dao;

import control.ControlJPanelVendasProsseguir;
import model.TabelaTemporaria;
import view.JPanelVendasProsseguir;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJPanelVendasProsseguir {
	
	// Classe de consulta de dados no banco de dados
	private ControlJPanelVendasProsseguir controlJPanelVendasProsseguir;
	private TabelaTemporaria tabelaTemporaria;
	private ModuloConexao moduloConexao;
	
	private Integer id_venda;	
	
	public DaoJPanelVendasProsseguir(ControlJPanelVendasProsseguir controlJPanelVendasProsseguir) {
		this.controlJPanelVendasProsseguir = controlJPanelVendasProsseguir;
	}
	
	
	
	
	public boolean cadastrarVenda() {
		try {

			// Caso tenha algum erro com o camando sql
			if(!getModuloConexao().executeQuery("select max(id_venda) from tb_vendas"))
				return false;
			System.out.println("pegou id");
			setId_venda(Integer.parseInt(getModuloConexao().valueAtLine(0)) + 1);
			
			// Caso tenha algum erro com o camando sql
			if(!new Cadastrar().executeUpdate(ComandosSQL.cadastrarVenda(),
					getId_venda().toString(),
					"1",
					getControlJPanelVendasProsseguir().getIdUsuario().toString(),
					getControlJPanelVendasProsseguir().getIdCliente().toString(),
					getControlJPanelVendasProsseguir().getFormaPagamento().toString().replace("CARTAO", "CARTÃO"),
					String.format("%.2f", getControlJPanelVendasProsseguir().getDesconto())
					))
				return false;

			System.out.println("Cadastrou venda");
			// insere todos os produtos da compra e atualiza os produtos no estoque
			return inserirProdutos(getId_venda().toString());			

			
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
		
	}
	
	
	/**
	 * O método inserirProdutos(@{code: id_venda}) void
	 * @return boolean Caso a inserção não seja bem sucedida retorna verdadeiro
	 */
	private boolean inserirProdutos(String id_venda) {
		boolean retorno = true;
		try {
			// Itera por cada linha da tabela temporária
			for(String[] linha : getTabelaTemporaria().getTabela()) {
				String id_produto = linha[6];
				String qtd = linha[1];		
				// Insere o produto na venda e retorna falso caso não seja bem sucedido
				if(!new Cadastrar().executeUpdate(ComandosSQL.inserirProdutoVenda(), id_venda, id_produto, qtd, id_produto))
					return false;
				// Altera a quantidade do produto no estoque e retorna falso caso não seja bem sucedido
				if(!new Cadastrar().executeUpdate(ComandosSQL.updateEstoque(), qtd, id_produto))
					return false;
			}

			System.out.println("inseriu produtos");
		} catch (Exception e) {
			retorno = false;
			System.err.println("Erro ao inserirProdutos() - " + e);
		}
		
		return retorno;
	}
	
	
	private ControlJPanelVendasProsseguir getControlJPanelVendasProsseguir() {
		if(controlJPanelVendasProsseguir == null) {
			controlJPanelVendasProsseguir = new ControlJPanelVendasProsseguir(null, null, null, null, null, null);
		}		
		return controlJPanelVendasProsseguir;
	}
	
	
	public TabelaTemporaria getTabelaTemporaria() {
		if(tabelaTemporaria == null){
			tabelaTemporaria =  getControlJPanelVendasProsseguir().getTabelaTemporaria();
		}
		return tabelaTemporaria;
	}
	
	
	public ModuloConexao getModuloConexao() {
		if(moduloConexao == null){
			moduloConexao =  new ModuloConexao();
		}
		return moduloConexao;
	}
	
	
	public Integer getId_venda() {			
		return id_venda;
	}
	

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}
}
