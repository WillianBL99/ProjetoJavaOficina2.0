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

import dao.ModuloConexao;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;

/**
 * @author Perseu
 *
 */
public class ControlJDialogProcurarCliente implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private boolean modal;
	private ModuloConexao moduloConexao;
	
	//** Fim declaração de variáveis **	
	
	public ControlJDialogProcurarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente) {	
		this.jFramePrincipal = jFramePricipal;	
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		AddEvent();
		setmodal(getjDialogProcurarCliente().ismodalTela());
	}


	private void AddEvent() {
		getjDialogProcurarCliente().addWindowListener(this);
		getjDialogProcurarCliente().getjButtonCancelar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonPesquisar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarCliente().getjTextFieldCampoPesquisa().addKeyListener(this);
		
	}
		
		
	//** Início métodos sobrescritos **
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
		if(e.getSource() == getjDialogProcurarCliente().getjButtonPesquisar()) {
			
		} else if() {
			
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
		this.getjFramePricipal().setEnabled(!isModal());
	}


	@SuppressWarnings("deprecation")
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(true);
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
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}


	public boolean isModal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	//** Fim métodos da classe **
	

}