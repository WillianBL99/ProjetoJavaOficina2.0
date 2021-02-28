/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

import model.Relogio;
import view.JPanelHome;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelHome  implements MouseListener, KeyListener {
	

	//** In�cio declara��o de vari�veis **
	
	private JPanelHome jPanelHome;
	
	//** Fim declara��o de vari�veis **	
	
	/**
	 * @param jPanelHome
	 */
	public ControlJPanelHome(JPanelHome jPanelHome) {
		super();
		this.jPanelHome = jPanelHome;
		new Relogio(getjPanelHome().getjLabelHoras()).start();
	}


	private void AddEvent() {
		//getjPanelVendas().getjButtonNovaVenda().addMouseListener(this);
		
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

	public JPanelHome getjPanelHome() {
		if(jPanelHome == null) {
			jPanelHome = new JPanelHome();
		}
		return jPanelHome;
	}
	
	//** Fim m�todos da classe ControlJPanelHome**
	
	
}
