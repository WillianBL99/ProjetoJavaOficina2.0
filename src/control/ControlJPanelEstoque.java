/**
 * 
 */
package control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import model.Cores;
import model.SetSizeIcon;
import view.JDialogEditarProduto;
import view.JDialogCadastrarProduto;
import view.JDialogCadastrarServico;
import view.JFramePrincipal;
import view.JPanelEstoque;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelEstoque  implements MouseListener, KeyListener  {
	
	//** In�cio declara��o de vari�veis **
	
	
	private SetSizeIcon setSizeIcon;
	private JFramePrincipal jFramePrincipal;
	private JPanelEstoque jPanelEstoque;
	private JDialogCadastrarProduto jDialogCadastrarProduto;
	private JButton jButtonClicado; // guarda o jbutton clicado
	private String iconeJButtonClicado; // guarda o caminho do icone do jbutton clicado
	
	
	//** Fim declara��o de vari�veis **	
	
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
		
		
	//** In�cio m�todos sobrescritos **
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

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o bot�o adicionar produto for clicado
		if(e.getSource() == getjPanelEstoque().getjButtonAdicionar()) {
			jDialogCadastrarProduto = null;
			getjdialogCadastrarProduto();
		}
		
		// Quando o bot�o editar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonEditar()) {
			
		}
		
		// Quando o bot�o apagar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonApagar()) {
			
		}
		
		// Quando o bot�o filtrar produto for clicado
		else if(e.getSource() == getjPanelEstoque().getjButtonFiltrar()) {
			
		}
		
		// Quando o bot�o pesquisar todos os produto for clicado
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
		
	//** Fim m�todos sobrescritos **
	
	
	//** In�cio m�todos da classe **
	
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
	
	
	private JDialogCadastrarProduto getjdialogCadastrarProduto() {
		if(this.jDialogCadastrarProduto == null) {
			this.jDialogCadastrarProduto = new JDialogCadastrarProduto(getjFramePrincipal(), true);
		}
		return this.jDialogCadastrarProduto;
	}
	
	//** Fim m�todos sobrescritos **
	
	
	//** In�cio m�todos da classe **
	
	/*
	 * m�todo mudarCorJButtonSelecionado(@jButton, @iconeSelected, @iconeNotSelected)
	 * 
	 * @jButton - Recebe como par�metro o JButton para realiza��o de mudan�a de �cone,
	 * mudan�a de background e mudan�a de foreground.
	 * 
	 * @iconeSelected - Recebe caminho do �cone que deve ser setado quando o JButton
	 * estiver selecionado.
	 * 
	 * @iconeNotSelected - Recebe caminho do �cone que deve ser setado quando o JButton n�o
	 * estiver selecionado.
	 * 
	 */
	public void mudarCorJButtonSelecionado(JButton jButton, String iconeSelected, String iconeNotSelected) {
		if(jButtonClicado != null && jButtonClicado != jButton) { 
			// setando a nova apar�ncia do JButton clicado.
			jButton.setBackground(Cores.azul1);
			jButton.setForeground(Cores.branco);
			setSizeIcon.setIconJButton(jButton, iconeSelected, 34 ,34);
			// setando a apar�ncia do JButton clicado ateriormente.
			jButtonClicado.setBackground(Cores.branco);
			jButtonClicado.setForeground(Cores.cinza2);
			setSizeIcon.setIconJButton(jButtonClicado, iconeJButtonClicado, 34 ,34);
			// guardando os caminhos dos �cones do JButton que est� selecionado.
			jButtonClicado = jButton;
			iconeJButtonClicado = iconeNotSelected;
		}
	}
		
		
	//** Fim m�todos da classe **
}
