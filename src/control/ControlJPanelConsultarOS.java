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

	
	//** Início declaração de variáveis **
	
	private JPanelConsultarOS jPanelConsultarOS;
	
		
	//** Fim declaração de variáveis **	
	
	public ControlJPanelConsultarOS() {
		
		this.AddEvent();
	}
	
	public void AddEvent() {
		
		
	}
	
	
	//** Início métodos sobrescritos **
	
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


	
	//** Fim métodos sobrescritos **
	
	
	//** Início métodos da classe **
	
	public JPanelConsultarOS getjPanelConsultarOS() {
		if(jPanelConsultarOS == null){
	
			jPanelConsultarOS = new JPanelConsultarOS();
	
		}
		return jPanelConsultarOS;
	}
	
	
	//** Fim métodos da classe **
	
	
	
	
	
	
	

	
	

	
	
}
