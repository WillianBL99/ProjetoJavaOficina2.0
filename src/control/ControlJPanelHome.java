/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Relogio;
import view.JPanelHome;

/**
 * @author Paulo Uilian
 *
 */

public class ControlJPanelHome  implements MouseListener, KeyListener {
	

	//** Início declaração de variáveis **
	
	private JPanelHome jPanelHome;
	
	//** Fim declaração de variáveis **	
	
	/**
	 * @param jPanelHome
	 */
	public ControlJPanelHome(JPanelHome jPanelHome) {
		super();
		this.jPanelHome = jPanelHome;
		
		 /*
		  *  Chamada da classe Relogio realiza a inicialização de uma nova thread
		  *  que realiza a modificação das horas da jlabel passada pelo parametro
		  */
		new Relogio(getjPanelHome().getjLabelHoras()).start();
		this.AddEvent();
	}


	private void AddEvent() {
		//getjPanelHome().addKeyListener(this);
		
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

	public JPanelHome getjPanelHome() {
		if(jPanelHome == null) {
			jPanelHome = new JPanelHome();
		}
		return jPanelHome;
	}
	
	//** Fim métodos da classe ControlJPanelHome**
	
	
}
