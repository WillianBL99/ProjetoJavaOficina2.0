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

	
	//** In�cio declara��o de vari�veis **
	
	private JPanelGeraOS jPanelGeraOS;
	
	
	//** Fim declara��o de vari�veis **	
	
	
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
		
		getjPanelGeraOS().getjTFieldAno().addKeyListener(this);
		getjPanelGeraOS().getjTFieldKMAtual().addKeyListener(this);
	}
	
	
	//** In�cio m�todos sobrescritos **
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldChassi() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldChassi(), Mascara.mascaraChassi());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldPlaca() ) {
			//Mascara.setMascara(getjPanelGeraOS().getjTFieldPlaca(), Mascara.mascaraPlaca());
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
		
		// Quando for digitado algo no campo de telefone
		else if(e.getSource() == getjPanelGeraOS().getjTFieldTelefone()) {
			Mascara.mascaraTelefone(getjPanelGeraOS().getjTFieldTelefone());
		}
		
		// Quando for digitado algo no campo de ano do ve�culo
		else if(e.getSource() == getjPanelGeraOS().getjTFieldAno()) {
			Mascara.mascaraAno(getjPanelGeraOS().getjTFieldAno());
		}
	}
	
	//** Fim m�todos sobrescritos **
	
	
	//** In�cio m�todos da classe **
	
	
	public JPanelGeraOS getjPanelGeraOS() {
		if(jPanelGeraOS == null){
	
			jPanelGeraOS = new JPanelGeraOS();
	
		}
		return jPanelGeraOS;
	}
	//** Fim m�todos da classe **

	
	
	



	


	
	
}
