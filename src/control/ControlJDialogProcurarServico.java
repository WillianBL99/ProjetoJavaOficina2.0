/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.JDialogProcurarServico;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarServico  implements MouseListener, KeyListener {
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarServico jDialogProcurarServico;
	
	//** Fim declaração de variáveis **	
	
	public ControlJDialogProcurarServico(JFramePrincipal jFramePricipal, JDialogProcurarServico jDialogProcurarServico) {		
		this.jFramePrincipal = jFramePricipal;	
		this.jDialogProcurarServico = jDialogProcurarServico;
		AddEvent();
		
	}


	private void AddEvent() {

		//DragListener.add(getjDialogProcurarVeiculo()); // possibilita mover o JDialog como o undecorated = true
		
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

		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}
		

		public JDialogProcurarServico getjDialogProcurarServico() {
			if(jDialogProcurarServico == null){
				jDialogProcurarServico = new JDialogProcurarServico(getjFramePricipal(), true);
			}
			return jDialogProcurarServico;
		}
	
	
	//** Fim métodos da classe **
	

}


