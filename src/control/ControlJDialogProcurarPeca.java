/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.JDialogProcurarPeca;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarPeca implements MouseListener, KeyListener {
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarPeca jDialogProcurarPeca;
	
	//** Fim declara��o de vari�veis **	
	
	public ControlJDialogProcurarPeca(JFramePrincipal jFramePricipal, JDialogProcurarPeca jDialogProcurarPeca) {		
		this.jFramePrincipal = jFramePricipal;	
		this.jDialogProcurarPeca = jDialogProcurarPeca;
		AddEvent();
		
	}


	private void AddEvent() {

		//DragListener.add(getjDialogProcurarVeiculo()); // possibilita mover o JDialog como o undecorated = true
		
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
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

		public JFramePrincipal getjFramePricipal() {
			if(jFramePrincipal == null){
				jFramePrincipal = new JFramePrincipal();
			}
			return jFramePrincipal;
		}

		public JDialogProcurarPeca getDialogProcurarPeca() {
			if(jDialogProcurarPeca == null){
				jDialogProcurarPeca = new JDialogProcurarPeca(getjFramePricipal(), true);
			}
			return jDialogProcurarPeca;
		}
	
	
	//** Fim m�todos da classe **
	

}


