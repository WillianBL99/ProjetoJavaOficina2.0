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
import dao.DaoJDialogCadastrarVeiculo;
import view.JDialogCadastrarCliente;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarCliente implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private DaoJDialogCadastrarVeiculo daoJDialogCadastrarVeiculo;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private JDialogCadastrarCliente jDialogCadastrarCliente;	
	private boolean modal;
	
	//** Fim declaração de variáveis **	
	public ControlJDialogCadastrarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente, JDialogCadastrarCliente jDialogCadastrarCliente) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		this.jDialogCadastrarCliente = jDialogCadastrarCliente;
		setmodal(this.jDialogProcurarCliente.ismodalTela());
		AddEvent();
	}


	private void AddEvent() {
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
		// Quando o botão cadastrar cliente for clicado
		if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCadastrarCliente()) {
			
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarVeiculo().getjButtonCancelar()) {
			
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
		this.getjDialogProcurarCliente().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjDialogProcurarCliente().setEnabled(true);
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
	
	
	public JDialogCadastrarCliente getjDialogCadastrarVeiculo() {
		if(jDialogCadastrarCliente == null){
			jDialogCadastrarCliente = new JDialogCadastrarCliente(getjFramePricipal(), true);
		}
		return jDialogCadastrarCliente;
	}
	
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}
	
	
	public DaoJDialogCadastrarVeiculo getdaoCadastrarVeiculo() {
		if(daoJDialogCadastrarVeiculo == null){
			daoJDialogCadastrarVeiculo = new DaoJDialogCadastrarVeiculo();
		}
		return daoJDialogCadastrarVeiculo;
	}
	
	
	public boolean ismodal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	
	/**
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
				
		if(true
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		
	}
	//** Fim métodos da classe **
	

}