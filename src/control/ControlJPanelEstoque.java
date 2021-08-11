/**
 * 
 */
package control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import dao.DaoJPanelEstoque;
import view.JDialogCadastrarProduto;
import view.JDialogEditarProduto;
import view.JFramePrincipal;
import view.JPanelEstoque;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelEstoque  implements MouseListener, KeyListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JPanelEstoque jPanelEstoque;
	private DaoJPanelEstoque daoJPanelEstoque;
	private JDialogCadastrarProduto jDialogCadastrarProduto;
	private ControlJDialogCadastrarProduto controlJDialogCadastrarProduto;
	private JDialogEditarProduto jDialogEditarProduto;
	private ControlJDialogEditarProduto controlJDialogEditarProduto;
	
	
	//** Fim declaração de variáveis **	
	
	public ControlJPanelEstoque(JFramePrincipal jFramePrincipal, JPanelEstoque jPanelEstoque) {
		this.jFramePrincipal = jFramePrincipal;
		this.jPanelEstoque = jPanelEstoque;
		AddEvent();
	}


	private void AddEvent() {
		getjPanelEstoque().getjButtonAdicionar().addMouseListener(this);
		getjPanelEstoque().getjButtonEditar().addMouseListener(this);
		getjPanelEstoque().getjButtonApagar().addMouseListener(this);
		getjPanelEstoque().getjTFieldBuscarPor().addKeyListener(this);
		//getjPanelEstoque().getjButtonFiltrar().addMouseListener(this);
		//getjPanelEstoque().getjButtonPesquisarTodos().addMouseListener(this);
	}
		
		
	//** Início métodos sobrescritos **
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// Quando o botão adicionar produto for clicado
		if(e.getSource() == getjPanelEstoque().getjButtonAdicionar()) {
			// Vetor de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"Sim", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensagem selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjFramePrincipal(), // tela pai
					"Deseja adicionar um novo produto ao estoque?", // mensagem
					"Alerta", // título
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			if(option == 0) {
				jDialogCadastrarProduto = null;
				controlJDialogCadastrarProduto = null;
				getjdialogCadastrarProduto();
				getcontrolJDialogCadastrarProduto();
			}			
		}
		
		
		// Quando o botão editar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonEditar()) {
			/*
			 * Primeiro verificar se tem tem algum produto selecionado.
			 * Se sim - Setar os capos da tela de edição com os valores do produto
			 * Se não - Abrir a tela de edição de valores sem setar os campos
			 */
			// Se tem alguma linha selecionada
			int row = getjPanelEstoque().getjTableEstoque().getSelectedRow();
			if(row >= 0) {
				this.chamarEditarProduto();
				preencherCampos(row);
			}
			
			// se não
			else {
				this.chamarEditarProduto();
			}
		}
		
		
		// Quando o botão apagar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonApagar()) {
			/*
			 *  Verifica se foi selecionado algum cliente
			 *  se getSelectedRow() retornar um numero menor que 0 
			 *  siguinifica que nenhuma linha foi selecionada
			 */
			// Se nenhuma linha for selecionada
			if(getjPanelEstoque().getjTableEstoque().getSelectedRow() < 0) {
				JOptionPane.showConfirmDialog(
						getjPanelEstoque(), // componente
						"Selecione um produto primeiro.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			// Uma linha está selecionada
			else {
				// recebe o numero da linha selecionada da tabela
				int row = getjPanelEstoque().getjTableEstoque().getSelectedRow();
				// recebe a descrição do produto selecionado na tabela
				String descProduto = getjPanelEstoque().getjTableEstoque().getValueAt(row, 1).toString();
				System.out.println("produto = " + descProduto);
				// Vetor de String com os nomes das opções que apareceram no joptionpane.
				String[] options = {"Deletar", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a opção Sim
				 * - 1: Foi selecionada a opção Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjFramePrincipal(), // tela pai
						"Tem certeza que deseja apagar o produto '" + descProduto + "'?\n"
								+ "Atenção! O produto só poderá ser deletado se ainda não\n"
								+ "foi ultilizado em nenhuma operação ex.: Venda...Orçamento...", // mensagem
						"Alerta", // título
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // opção selecionada inicialmente
				
				if(option == 0) {
					// Caso tenha deletado com sucesso
					if(getDaoJPanelEstoque().deletarProduto(getjPanelEstoque().getjTableEstoque().getValueAt(row, 0).toString())) {
						atualizarTabela();
						JOptionPane.showConfirmDialog(
								getjPanelEstoque(), // componente
								"Produto '" + descProduto + "' deletado com sucesso!\n",
								"Produto deletado", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.PLAIN_MESSAGE // tipo de mensagem
						);
					}
					
					// Caso não tenha deletado
					else {
						atualizarTabela();
						JOptionPane.showConfirmDialog(
								getjPanelEstoque(), // componente
								"Produto '" + descProduto + "' não foi deletado.\n"
										+ "Verificar se o produto ja foi utilizado em alguma operação.", // texto
								"Impossível deletar produto", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.ERROR_MESSAGE // tipo de mensagem
						);
					}
					
					
				}
			}			
		}
		/*
		// Quando o botão filtrar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonFiltrar()) {
			// Verificar se o txf não está vaizio
			if(!getjPanelEstoque().getjTFieldBuscarPor().getText().isEmpty()) {
				
			}
			
			// O jtxf está vazio
			else {
				
			}
		}
		
		// Quando o botão pesquisar todos os produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonPesquisarTodos()) {
			
		}
		*/
	}


	@Override
	public void mouseReleased(MouseEvent e) {
			
	}
	

	@Override
	public void mouseEntered(MouseEvent e) { // Quando o ponteiro do mouse passar por algum componente
		/*
		if(e.getSource() == this.getjPanelPrincipal().getJButtonInicio()) {
			
			
		}
		
		else if(e.getSource() == this.getjPanelPrincipal().getjButtonOS()) {
			
			
		}
		
		else if(e.getSource() == this.getjPanelPrincipal().getjButtonVendas()) {
			
			
		}
		*/
	}


	@Override
	public void mouseExited(MouseEvent e) { // Quando o ponteiro do mouse sair de algum componente		}
			
	}	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// Quando for digitado algo em jtxf buscarPor
		if(e.getSource() == getjPanelEstoque().getjTFieldBuscarPor()) {
			// Verificar se está persquisando por código ou descriçao
			switch(getjPanelEstoque().getchoicePesquisarPor().getSelectedItem().toString().replace(" ", "")) {
			case "Descrição":
				// Verificar se houve algum erro na pesquisa
				if(!getDaoJPanelEstoque().pesquisarPorDescricao()) {
				}				
				break;
				
			case "Código":
				// Verificar se houve algum erro na pesquisa
				if(!getDaoJPanelEstoque().pesquisarPorCodigo()) {
				}
				
				break;
				
			case "Marca":
				// Verificar se houve algum erro na pesquisa
				if(!getDaoJPanelEstoque().pesquisarPorMarca()) {
				}
				
				break;
			}
		}
	}
	
		
	//** Fim métodos sobrescritos **
	
	
	//** Início métodos da classe **
	
	private JFramePrincipal getjFramePrincipal() {
		if(this.jFramePrincipal == null) {
			this.jFramePrincipal = new JFramePrincipal();
		}
		return this.jFramePrincipal;
	}
	
	
	private JPanelEstoque getjPanelEstoque() {
		if(this.jPanelEstoque == null) {
			this.jPanelEstoque = new JPanelEstoque();
		}
		return this.jPanelEstoque;
	}
	
	
	private DaoJPanelEstoque getDaoJPanelEstoque() {
		if(this.daoJPanelEstoque == null) {
			this.daoJPanelEstoque = new DaoJPanelEstoque(getjPanelEstoque());
		}
		return this.daoJPanelEstoque;
	}
	
	
	private JDialogCadastrarProduto getjdialogCadastrarProduto() {
		if(this.jDialogCadastrarProduto == null) {
			this.jDialogCadastrarProduto = new JDialogCadastrarProduto(getjFramePrincipal(), true);
		}
		return this.jDialogCadastrarProduto;
	}
	
	
	private JDialogEditarProduto getjDialogEditarProduto() {
		if(this.jDialogEditarProduto == null) {
			this.jDialogEditarProduto = new JDialogEditarProduto(getjFramePrincipal(), true);
		}
		return this.jDialogEditarProduto;
	}
	
	
	private ControlJDialogCadastrarProduto getcontrolJDialogCadastrarProduto() {
		if(this.controlJDialogCadastrarProduto == null) {
			this.controlJDialogCadastrarProduto = new ControlJDialogCadastrarProduto(getjFramePrincipal(), getjdialogCadastrarProduto(), this);
		}
		return this.controlJDialogCadastrarProduto;
	}
	
	
	private ControlJDialogEditarProduto getcontrolJDialogEditarProduto() {
		if(this.controlJDialogEditarProduto == null) {
			this.controlJDialogEditarProduto = new ControlJDialogEditarProduto(getjFramePrincipal(), getjDialogEditarProduto(), this);
		}
		return this.controlJDialogEditarProduto;
	}
	
	// Chama a tela editar produto
	private void chamarEditarProduto() {
		jDialogEditarProduto = null;
		controlJDialogEditarProduto = null;
		getjDialogEditarProduto();
		getjDialogEditarProduto().getjTFieldCodigo().requestFocus();
		getcontrolJDialogEditarProduto();
	
	}
	
	
	
	/**
	 * Método preencherCampos() reenche campos dados do produto da tela editar produto
	 * assim como as variaveis da classe controlJDialogEditarProduto contendo os valores
	 * atuis de cada campo.
	 * @param row Passar a linha selecionada na tabela
	 */
	private void preencherCampos(int row) {
		
		String codigo  = getjPanelEstoque().getjTableEstoque().getValueAt(row, 0).toString();
		String descricao  = getjPanelEstoque().getjTableEstoque().getValueAt(row, 1).toString();
		String marca  = getjPanelEstoque().getjTableEstoque().getValueAt(row, 2).toString();
		String quantidade  = getjPanelEstoque().getjTableEstoque().getValueAt(row, 3).toString();
		String preco  = getjPanelEstoque().getjTableEstoque().getValueAt(row, 4).toString();
		
		getcontrolJDialogEditarProduto().setCodigoProcurado(codigo);
		getcontrolJDialogEditarProduto().setDescricaoProcurado(descricao);
		getcontrolJDialogEditarProduto().setMarcaProcurardo(marca);
		getcontrolJDialogEditarProduto().setQuantidadeProcurado(quantidade);
		getcontrolJDialogEditarProduto().setPrecoProcurado(preco);
		
		getjDialogEditarProduto().getjTFieldCodigo().setText(codigo);
		getjDialogEditarProduto().getjTFieldDescricao().setText(descricao);
		getjDialogEditarProduto().getjTFieldMarca().setText(marca);
		getjDialogEditarProduto().getjTFieldQuantidadeEstoque().setText(quantidade);
		getjDialogEditarProduto().getjTFieldPreco().setText(preco);
		getjDialogEditarProduto().getjTFieldNovaQuantidade().requestFocus();
	}
	
	
	//** Fim métodos sobrescritos **
	
	
	//** Início métodos da classe **
	
	public void atualizarTabela() {
		getDaoJPanelEstoque().atualizarTabelaProdutos();
	}
		
		
	//** Fim métodos da classe **
}
