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
	

	//** In�cio declara��o de vari�veis **
	
	//private Point point; // posi��o que a tela e setada na jpanelprincipal
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelOrcamentoFinal jPanelOrcamentoFinal;
	private JPanelPreOrcamentoNovo jPanelOrcamentoFinalNovo;
	
	//** Fim declara��o de vari�veis **		
	
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
		System.out.println("clicou");
		
		if(e.getSource() == getjPanelOrcamentoFinal().getjButtonNovoOrcamentoFinal()) {
			// quando o bot�o novo pr� or�amento for clicado
			String message = "Deseja originar a partir de um pr� or�amento?";
			String title = "Gerar novo or�amento final";
			String[] options = {"Cancelar"}; // botoes dispon�ves na tela
			int optionSelect = 0; //rebe o valor do bot�o selecionado pelo usu�rio.
			
			optionSelect = JOptionPane.showOptionDialog(null,
					message,
					title,
					JOptionPane.QUESTION_MESSAGE,
					JOptionPane.YES_NO_OPTION,
					null,
					options,
					options[0]);
			
			// define a��es de acor do o bot�o clicado no JOptionPane
			switch (optionSelect) {
				case 0:
					System.out.println("cancelar");
					break;
					
				case 1:
					System.out.println("sim");
					break;
					
				case 2:
					System.out.println("n�o");
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
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **
	
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
	
	//** Fim m�todos da classe **
}
