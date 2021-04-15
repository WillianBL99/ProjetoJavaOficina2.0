/**
 * 
 */
package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.JFramePrincipal;
import view.JPanelOrcamentoFinal;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelOrcamentoFinal  implements MouseListener, KeyListener {
	

	//** Início declaração de variáveis **
	
	//private Point point; // posição que a tela e setada na jpanelprincipal
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelOrcamentoFinal jPanelOrcamentoFinal;
	private JPanelPreOrcamentoNovo jPanelOrcamentoFinalNovo;
	
	//** Fim declaração de variáveis **		
	
	/**
	 * @param jFramePrincipal
	 * @param jPanelPrincipal
	 * @param jPanelOrcamentoFinal
	 */
	public ControlJPanelOrcamentoFinal(JFramePrincipal jFramePrincipal, JPanelPrincipal jPanelPrincipal,
			JPanelOrcamentoFinal jPanelOrcamentoFinal) {
		super();
		System.out.println("chamou");
		this.jFramePrincipal = jFramePrincipal;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelOrcamentoFinal = jPanelOrcamentoFinal;
		this.AddEvent();
	}
	

	private void AddEvent() {
		getjPanelOrcamentoFinal().getjButtonNovoOrcamentoFinal().addMouseListener(this);
		getjPanelOrcamentoFinal().getjButtonImprimir().addMouseListener(this);
		getjPanelOrcamentoFinal().getjButtonEditar().addMouseListener(this);
		getjPanelOrcamentoFinal().getjButtonApagar().addMouseListener(this);
		getjPanelOrcamentoFinal().getjButtonFiltrar().addMouseListener(this);
		getjPanelOrcamentoFinal().getjButtonPesquisarTodos().addMouseListener(this);
		
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
		System.out.println("clicou");
		
		if(e.getSource() == getjPanelOrcamentoFinal().getjButtonNovoOrcamentoFinal()) {
			// quando o botão novo pré orçamento for clicado
			String message = "Deseja originar a partir de um pré orçamento?";
			String title = "Gerar novo orçamento final";
			String[] options = {"Cancelar"}; // botoes disponíves na tela
			int optionSelect = 0; //rebe o valor do botão selecionado pelo usuário.
			
			optionSelect = JOptionPane.showOptionDialog(null,
					message,
					title,
					JOptionPane.QUESTION_MESSAGE,
					JOptionPane.YES_NO_OPTION,
					null,
					options,
					options[0]);
			
			// define ações de acor do o botão clicado no JOptionPane
			switch (optionSelect) {
				case 0:
					System.out.println("cancelar");
					break;
					
				case 1:
					System.out.println("sim");
					break;
					
				case 2:
					System.out.println("não");
					break;
					
			}
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
	
	/*private Point getpoint() {
		if(point == null) {
			point  = new Point(250, 47);
		}
		return point;
	}*/

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
	
	
	public JPanelOrcamentoFinal getjPanelOrcamentoFinal() {
		if(jPanelOrcamentoFinal == null){
			jPanelOrcamentoFinal = new JPanelOrcamentoFinal();	
		}
		return jPanelOrcamentoFinal;
	}
	
	
	public JPanelPreOrcamentoNovo getjPanelOrcamentoFinalNovo() {
		if(jPanelOrcamentoFinalNovo == null){
			jPanelOrcamentoFinalNovo = new JPanelPreOrcamentoNovo();	
		}
		return jPanelOrcamentoFinalNovo;
	}
	
	//** Fim métodos da classe **
}
