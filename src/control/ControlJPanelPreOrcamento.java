/**
 * 
 */
package control;

import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Mascara;
import view.JFramePrincipal;
import view.JPanelPreOrcamento;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */

public class ControlJPanelPreOrcamento  implements MouseListener, KeyListener, FocusListener {
	

	//** Início declaração de variáveis **
	
	private Point point = new Point(250, 47); // posição que a tela e setada na jpanelprincipal
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	
	private ControlJpanelPreOrcamentoNovo controlJpanelPreOrcamentoNovo;
	
	//** Fim declaração de variáveis **	
	
	
	/**
	 * @param jFramePrincipal
	 * @param jPanelPrincipal
	 * @param jPanelPreOrcamento
	 */
	public ControlJPanelPreOrcamento(JFramePrincipal jFramePrincipal, JPanelPrincipal jPanelPrincipal,
			JPanelPreOrcamento jPanelPreOrcamento) {
		super();
		this.jFramePrincipal = jFramePrincipal;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelPreOrcamento = jPanelPreOrcamento;
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelPreOrcamento().getjButtonNovoPreOrcamento().addMouseListener(this);
		getjPanelPreOrcamento().getjButtonImprimir().addMouseListener(this);
		getjPanelPreOrcamento().getjButtonEditar().addMouseListener(this);
		getjPanelPreOrcamento().getjButtonApagar().addMouseListener(this);
		getjPanelPreOrcamento().getjButtonFiltrar().addMouseListener(this);
		getjPanelPreOrcamento().getjButtonPesquisarTodos().addMouseListener(this);
		getjPanelPreOrcamento().getjTFieldDTInicial().addFocusListener(this);
		getjPanelPreOrcamento().getjTFieldDTFinal().addFocusListener(this);
		
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
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == getjPanelPreOrcamento().getjTFieldDTInicial()) {
			
			Mascara.setMascara(getjPanelPreOrcamento().getjTFieldDTInicial(), Mascara.mascaraData());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamento().getjTFieldDTFinal()) {
			
			Mascara.setMascara(getjPanelPreOrcamento().getjTFieldDTFinal(), Mascara.mascaraData());
			
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == getjPanelPreOrcamento().getjButtonNovoPreOrcamento()) {
			// quando o botão novo pré orçamento for clicado
			this.getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamentoNovo(),this.point,
					getjPanelPreOrcamentoNovo().getTituloDescricaoTela());
			this.getcontrolJpanelPreOrcamentoNovo();
		}
		
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

	public JFramePrincipal getjFramePrincipal() {
		if(jFramePrincipal == null) {
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}

	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}
	
	
	public JPanelPreOrcamento getjPanelPreOrcamento() {
		if(jPanelPreOrcamento == null){
			jPanelPreOrcamento = new JPanelPreOrcamento();	
		}
		return jPanelPreOrcamento;
	}
	
	
	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null){
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();	
		}
		return jPanelPreOrcamentoNovo;
	}
	
	
	public ControlJpanelPreOrcamentoNovo getcontrolJpanelPreOrcamentoNovo() {
		if(controlJpanelPreOrcamentoNovo == null){
			controlJpanelPreOrcamentoNovo = new ControlJpanelPreOrcamentoNovo(getjFramePrincipal(), getjPanelPrincipal(),
					getjPanelPreOrcamento(), getjPanelPreOrcamentoNovo());	
		}
		return controlJpanelPreOrcamentoNovo;
	}
	//** Fim métodos da classe **





}
