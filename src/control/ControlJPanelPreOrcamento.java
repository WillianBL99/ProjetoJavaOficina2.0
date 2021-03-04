/**
 * 
 */
package control;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.JPanelPreOrcamento;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelPreOrcamento  implements MouseListener, KeyListener {
	

	//** In�cio declara��o de vari�veis **
	
	private Point point = new Point(250, 47); // posi��o que a tela e setada na jpanelprincipal
	
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	
	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jPanelPrincipal
	 * @param jPanelPreOrcamento
	 */
	public ControlJPanelPreOrcamento(JPanelPrincipal jPanelPrincipal, JPanelPreOrcamento jPanelPreOrcamento) {
		super();
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
		
		if(e.getSource() == getjPanelPreOrcamento().getjButtonNovoPreOrcamento()) {
			// quando o bot�o nova venda for clicado
			System.out.println("novo pre orcamento");
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamentoNovo(), this.point);
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
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

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
	//** Fim m�todos da classe **
}
