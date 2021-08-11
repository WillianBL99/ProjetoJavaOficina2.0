/**
 * 
 */
package control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import dao.DaoJDialogProcurarProduto;
import view.JDialogProcurarPeca;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarPeca implements MouseListener, KeyListener, WindowListener{
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarPeca jDialogProcurarPeca;
	private DaoJDialogProcurarProduto daoJDialogProcurarProduto;
	
	//** Fim declara��o de vari�veis **	
	
	public ControlJDialogProcurarPeca(JFramePrincipal jFramePricipal, JDialogProcurarPeca jDialogProcurarPeca) {		
		this.jFramePrincipal = jFramePricipal;	
		this.jDialogProcurarPeca = jDialogProcurarPeca;
		AddEvent();
		getdaoJDialogProcurarProduto().atualizarTabelaProdutos();		
	}


	private void AddEvent() {
		getjDialogProcurarPeca().addWindowListener(this);
		getjDialogProcurarPeca().getjTFieldProcurar().addKeyListener(this);
		getjDialogProcurarPeca().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarPeca().getjButtonCancelar().addMouseListener(this);
		
	}
		
		
	//** In�cio m�todos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// Quando for digitado algo em jtxf procurar
		if(e.getSource() == getjDialogProcurarPeca().getjTFieldProcurar()) {		
			
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando for clicado em selecionar produto
		if(e.getSource() == getjDialogProcurarPeca().getjButtonSelecionar()) {
		// Verificar ser foi selecionado um produto // Verificar se o produto j� foi selecionado // Alertar se o produto esta com estoque baixo
		}
		
		// Quando for clicado em cancelar
		else if(e.getSource() == getjDialogProcurarPeca().getjButtonCancelar()) {
			
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

	
	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}

	public DaoJDialogProcurarProduto getdaoJDialogProcurarProduto() {
		if(daoJDialogProcurarProduto == null){
			daoJDialogProcurarProduto = new DaoJDialogProcurarProduto(getjFramePricipal(), getjDialogProcurarPeca());
		}
		return daoJDialogProcurarProduto;
	}

	public JDialogProcurarPeca getjDialogProcurarPeca() {
		if(jDialogProcurarPeca == null){
			jDialogProcurarPeca = new JDialogProcurarPeca(getjFramePricipal(), true);
		}
		return jDialogProcurarPeca;
	}

	//** Fim m�todos da classe **
		
}