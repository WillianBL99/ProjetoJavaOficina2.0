/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Mascara;
import view.JPanelGeraOS;

/**
 * @author Perseu
 *
 */
public class ControlJPanelGeraOS implements FocusListener, KeyListener{

	
	//** Início declaração de variáveis **
	
	private JPanelGeraOS jPanelGeraOS;
	
	
	//** Fim declaração de variáveis **	
	
	
	public ControlJPanelGeraOS() {
		AddEvent();
	}
	
	public void AddEvent() {
		getjPanelGeraOS().getjTFieldAno().addFocusListener(this);
		getjPanelGeraOS().getjTFieldChassi().addFocusListener(this);
		getjPanelGeraOS().getjTFieldCpf().addFocusListener(this);
		getjPanelGeraOS().getjTFieldKMAtual().addFocusListener(this);
		getjPanelGeraOS().getjTFieldPlaca().addFocusListener(this);
		getjPanelGeraOS().getjTFieldTelefone().addFocusListener(this);
	}
	
	
	//** Início métodos sobrescritos **
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldAno() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldAno(), Mascara.mascaraAno());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldChassi() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldChassi(), Mascara.mascaraChassi());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldKMAtual() ) {
			
			Mascara.setMascara(getjPanelGeraOS().getjTFieldKMAtual(), Mascara.mascaraQuilometragem());

		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldPlaca() ) {
			//Mascara.setMascara(getjPanelGeraOS().getjTFieldPlaca(), Mascara.mascaraPlaca());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldTelefone() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldTelefone(), Mascara.mascaraTelefone());
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getjPanelGeraOS().getjTFieldKMAtual() ) {
			System.out.println(getjPanelGeraOS().getjTFieldKMAtual().getText());
		}
		
	}
	
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
		// Quando for digitado algo no campo de cpf
		if(e.getSource() == getjPanelGeraOS().getjTFieldCpf()) {
			Mascara.mascaraCPF(getjPanelGeraOS().getjTFieldCpf());
		}
	}
	
	//** Fim métodos sobrescritos **
	
	
	//** Início métodos da classe **
	
	
	public JPanelGeraOS getjPanelGeraOS() {
		if(jPanelGeraOS == null){
	
			jPanelGeraOS = new JPanelGeraOS();
	
		}
		return jPanelGeraOS;
	}
	//** Fim métodos da classe **

	
	
	



	


	
	
}
