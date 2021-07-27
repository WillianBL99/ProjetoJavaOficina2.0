/**
 * 
 */
package dao;

import view.JDialogEditarProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogEditarProduto {
	
	// Classe de consulta de dados no banco de dados
	private JDialogEditarProduto jDialogEditarProduto;
	private ModuloConexao moduloConexao;
	private JFramePrincipal jFramePrincipal;
	
	public DaoJDialogEditarProduto(JFramePrincipal jFramePrincipal, JDialogEditarProduto jDialogEditarProduto) {
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogEditarProduto = jDialogEditarProduto;
	}
	
	
	/**
	 * Método void geteditarDescricao().
	 * Tem a função de alterar a descrição em etoque de um produto
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean geteditarDescricao() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do produto
			String id_produto = getjDialogEditarProduto().getjTFieldCodigo().getText();
			// Recebe o novo valor
			String desc_produto = getjDialogEditarProduto().getjTFieldDescricao().getText();		
			
			// Verifica se foi retornado algum valor do banco de dados
			if(new Cadastrar().executeUpdate(ComandosSQL.alterarProdutoDescricao(), desc_produto, id_produto)) {				
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}		
			
		} catch(Exception e) {
			System.out.println("Erro ao setar os campos de jdialogeditarproduto\n" + e);
			next = false;
		}
		
		return next;
	}
	
	
	/**
	 * Método void geteditarMarca().
	 * Tem a função de alterar a marca em etoque de um produto
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean geteditarMarca() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do produto
			String id_produto = getjDialogEditarProduto().getjTFieldCodigo().getText();
			// Recebe o novo valor
			String marca_produto = getjDialogEditarProduto().getjTFieldMarca().getText();		
			
			// Verifica se foi retornado algum valor do banco de dados
			if(new Cadastrar().executeUpdate(ComandosSQL.alterarProdutoMarca(), marca_produto, id_produto)) {				
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}		
			
		} catch(Exception e) {
			System.out.println("Erro ao setar os campos de jdialogeditarproduto\n" + e);
			next = false;
		}
		
		return next;
	}
	
	
	/**
	 * Método void geteditarValor().
	 * Tem a função de alterar o preço em etoque de um produto
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean geteditarValor() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do produto
			String id_produto = getjDialogEditarProduto().getjTFieldCodigo().getText();
			// Recebe o novo valor
			String valor_produto = getjDialogEditarProduto().getjTFieldNovoValor().getText();		
			
			// Verifica se foi retornado algum valor do banco de dados
			if(new Cadastrar().executeUpdate(ComandosSQL.alterarProdutoPreco(), valor_produto, id_produto)) {				
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}		
			
		} catch(Exception e) {
			System.out.println("Erro ao setar os campos de jdialogeditarproduto\n" + e);
			next = false;
		}
		
		return next;
	}
	
	
	/**
	 * Método void geteditarQuantidade().
	 * Tem a função de alterar a quantidade em etoque de um produto
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean geteditarQuantidade() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do produto
			String id_produto = getjDialogEditarProduto().getjTFieldCodigo().getText();
			// Recebe a nova quantidade
			String qtd_produto = getjDialogEditarProduto().getjTFieldNovaQuantidade().getText();		
			
			// Verifica se foi retornado algum valor do banco de dados
			if(new Cadastrar().executeUpdate(ComandosSQL.alterarProdutoQtd(), qtd_produto, id_produto)) {				
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}		
			
		} catch(Exception e) {
			System.out.println("Erro ao setar os campos de jdialogeditarproduto\n" + e);
			next = false;
		}
		
		return next;
	}
	
	
	/**
	 * Método void getprocurarProduto().
	 * Tem a função de preencher os campos da tela editar produto depois de executar uma query
	 * @return boolean next
	 * false - Se a consulta não retornar nenhuma linha
	 * true - Se a consulta retornar linhas
	 */
	public boolean getprocurarProduto() {
		boolean next;
		// Tratamento de exceções no momento de consulta do banco de dados
		try {
			// Recebe o id do produto
			String id_produto = getjDialogEditarProduto().getjTFieldCodigo().getText();
			// As linhas abaixo realizam a consulta de dados do banco de dados
			getmoduloConexao().executeQuery(ComandosSQL.consultarProdutoID(), id_produto);
			
			// Verifica se foi retornado algum valor do banco de dados
			if(!getmoduloConexao().resultSetIsEmpty()) {
				// Realiza o preenchimento dos campos de jdialogeditarproduto
				
				// Coloca o cursor na primeira e unica linha da da consulta
				getmoduloConexao().getResultSet().first();
				String codigo  = getmoduloConexao().getResultSet().getString(1);
				String descricao  = getmoduloConexao().getResultSet().getString(2);
				String marca  = getmoduloConexao().getResultSet().getString(3);
				String quantidade  = getmoduloConexao().getResultSet().getString(4);
				String preco  = getmoduloConexao().getResultSet().getString(5);
				
				getjDialogEditarProduto().getjTFieldCodigo().setText(codigo);
				getjDialogEditarProduto().getjTFieldDescricao().setText(descricao);
				getjDialogEditarProduto().getjTFieldMarca().setText(marca);
				getjDialogEditarProduto().getjTFieldQuantidadeEstoque().setText(quantidade);
				getjDialogEditarProduto().getjTFieldPreco().setText(preco);
				next = true;
			
			// Se não retornou nenhum valor exibe um caixa de alerta	
			} else {
				next = false;
			}
			
			
		} catch(Exception e) {
			System.out.println("Erro ao setar os campos de jdialogeditarproduto\n" + e);
			next = true; // tenta preencher a tabela mesmo gerando o erro
		}
		
		return next;
	}
	
	
	// Metodos getters e setters
	
	private JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	private JDialogEditarProduto getjDialogEditarProduto() {
		if(jDialogEditarProduto == null) {
			jDialogEditarProduto = new JDialogEditarProduto(getjFramePrincipal(), true);
		}
		return jDialogEditarProduto;
	}
	
	
	private ModuloConexao getmoduloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}


}
