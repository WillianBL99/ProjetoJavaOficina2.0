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
		getjPanelEstoque().getjButtonFiltrar().addMouseListener(this);
		getjPanelEstoque().getjButtonPesquisarTodos().addMouseListener(this);
	}
		
		
	//** Início métodos sobrescritos **
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
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
				getjdialogCadastrarProduto();
				getcontrolJDialogCadastrarProduto();
			}			
		}
		
		// Quando o botão editar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonEditar()) {
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
				jDialogEditarProduto = null;
				getjDialogEditarProduto();
			}
		}
		
		// Quando o botão apagar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonApagar()) {
			
		}
		
		// Quando o botão filtrar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonFiltrar()) {
			
		}
		
		// Quando o botão pesquisar todos os produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonPesquisarTodos()) {
			
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
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
		// TODO Auto-generated method stub
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
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
	
	//** Fim métodos sobrescritos **
	
	
	//** Início métodos da classe **
	
	public void atualizarTabela() {
		getDaoJPanelEstoque().atualizarTabelaProdutos();
	}
		
		
	//** Fim métodos da classe **
}
