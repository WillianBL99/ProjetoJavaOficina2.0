/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.JPanelConsultarOS;

/**
 * @author Perseu
 *
 */
public class ControlJPanelConsultarOS implements FocusListener {

	
	//** In�cio declara��o de vari�veis **
	
	private JPanelConsultarOS jPanelConsultarOS;
	
		
	//** Fim declara��o de vari�veis **	
	
	public ControlJPanelConsultarOS() {
		
		this.AddEvent();
	}
	
	public void AddEvent() {
		
		
	}
	
	
	//** In�cio m�todos sobrescritos **
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*return newdfha jPanelConsultarOS;
	*/


	
	//** Fim m�todos sobrescritos **
	
	
	//** In�cio m�todos da classe **
	
	public JPanelConsultarOS getjPanelConsultarOS() {
		if(jPanelConsultarOS == null){
	
			jPanelConsultarOS = new JPanelConsultarOS();
	
		}
		return jPanelConsultarOS;
	}
	
	
	//** Fim m�todos da classe **
	
	
	
	
	
	
	

	
	

	
	
}
