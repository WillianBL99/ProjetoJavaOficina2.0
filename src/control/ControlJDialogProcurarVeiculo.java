/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarVeiculo implements MouseListener, KeyListener {
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	
	
	//** Fim declaração de variáveis **	
	
	public ControlJDialogProcurarVeiculo(JFramePrincipal jFramePricipal) {		
		this.jFramePrincipal = jFramePricipal;		
		AddEvent();
		
	}


	private void AddEvent() {

		//DragListener.add(getjDialogProcurarVeiculo()); // possibilita mover o JDialog como o undecorated = true
		getjDialogProcurarVeiculo().getjButtonProcurar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonCancelar().addMouseListener(this);
		
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
		// TODO Auto-generated method stub
		/*
		if(e.getSource() == getjDialogProcurarVeiculo().getjButtonFecharTela()) {	
			
			int fechar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar a tela?", "Alerta!", JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar a tela?", "Alerta!", JOptionPane.OK_CANCEL_OPTION);
			if(fechar == 0) {
				getjFramePricipal().dispose(); // método da classe
			}
			
		}
		*/
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
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

		public JDialogProcurarVeiculo getjDialogProcurarVeiculo() {
			if(jDialogProcurarVeiculo == null){
				jDialogProcurarVeiculo = new JDialogProcurarVeiculo(getjFramePricipal(), true);
			}
			return jDialogProcurarVeiculo;
		}


		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}
	
	
	//** Fim métodos da classe **
	

}


