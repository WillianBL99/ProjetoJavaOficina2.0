/**
 * 
 */
package dao;

import view.JDialogCadastrarProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class DaoJDialogCadastrarProduto {
	
	// Classe de consulta de dados no banco de dados
	private JDialogCadastrarProduto jDialogCadastrarProduto;
	private ModuloConexao moduloConexao;
	private JFramePrincipal jFramePrincipal;
	
	public DaoJDialogCadastrarProduto(JFramePrincipal jFramePrincipal, JDialogCadastrarProduto jDialogCadastrarProduto) {
		this.jFramePrincipal = jFramePrincipal;
		this.jDialogCadastrarProduto = jDialogCadastrarProduto;
	}
	
	
	/**
	 * Método cadastrarProduto() Realiza o cadastro dos produtos
	 * @return Retorna um valor booleano. Se a inserção for bem sucedida será retornado true.
	 * Caso contrário, false.
	 */
	public boolean cadastrarProduto() {
		boolean insert = false;
		try {
			// Método executeUpdate(query, campos...) retorna verdadeiro caso a inserção seja bem sucedida
			if(new Cadastrar().executeUpdate(
					ComandosSQL.cadastrarProduto(),
					getjDialogCadastrarProduto().getjTFieldCodigo().getText(),
					getjDialogCadastrarProduto().getjTFieldDescricao().getText(),
					getjDialogCadastrarProduto().getjTFieldMarca().getText(),
					getjDialogCadastrarProduto().getjTFieldQuantidade().getText(),
					getjDialogCadastrarProduto().getjTFieldPreco().getText().replace(",", "").replace(" ", "")))
			{
				insert = true;
			} else {
				insert = false;
			}
			
		} catch (Exception e) {
			System.err.println("Erro-Class:DaoJDialogCadastrarProduto: " + e.getMessage());
			insert = false;
		}			
		return insert;
	}
	
	
	/**
	 * Método isUnico(id) Verifica se um id é unico e pode ser inserido no banco de dados.
	 * @param id - Inserir o id para verificar se o mesmo existe no banco de dados.
	 * @return Retorna verdadeiro se não encontrar outro id no banco de dados, e falso caso contrário.
	 */
	public boolean idUnico(String id) {
		boolean status = false;
		getmoduloConexao().executeQuery(ComandosSQL.consultarProdutoID(), id);
		if(getmoduloConexao().resultSetIsEmpty()) {
			status = true;
		}
		return status;
	}
	
	
	// Metodos getters e setters
	
	private JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	private JDialogCadastrarProduto getjDialogCadastrarProduto() {
		if(jDialogCadastrarProduto == null) {
			jDialogCadastrarProduto = new JDialogCadastrarProduto(getjFramePrincipal(), true);
		}
		return jDialogCadastrarProduto;
	}
	
	
	private ModuloConexao getmoduloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
}
