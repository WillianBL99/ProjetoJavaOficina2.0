/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import model.Mascara;
import view.JPanelGeraOS;

/**
 * @author Perseu
 *
 */
public class ControlJPanelGeraOS implements FocusListener {

	
	//** In�cio declara��o de vari�veis **
	
	private JPanelGeraOS jPanelGeraOS;
	
	
	//** Fim declara��o de vari�veis **	
	
	
	public ControlJPanelGeraOS() {
		
	}
	
	public void AddEvent() {
		getjPanelGeraOS().getjTFieldAno().addFocusListener(this);
		getjPanelGeraOS().getjTFieldChassi().addFocusListener(this);
		getjPanelGeraOS().getjTFieldCpf().addFocusListener(this);
		getjPanelGeraOS().getjTFieldKMAtual().addFocusListener(this);
		getjPanelGeraOS().getjTFieldPlaca().addFocusListener(this);
		getjPanelGeraOS().getjTFieldTelefone().addFocusListener(this);
	}
	
	
	//** In�cio m�todos sobrescritos **
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldAno() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldAno(), Mascara.mascaraAno());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldChassi() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldChassi(), Mascara.mascaraChassi());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldCpf() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldCpf(), Mascara.mascaraCPF());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldKMAtual() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldKMAtual(), Mascara.mascaraQuilometragem());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldPlaca() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldPlaca(), Mascara.mascaraPlaca());
		}
		
		if(e.getSource() == getjPanelGeraOS().getjTFieldTelefone() ) {
			Mascara.setMascara(getjPanelGeraOS().getjTFieldTelefone(), Mascara.mascaraTelefone());
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
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
