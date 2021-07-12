/**
 * 
 */
package control;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Mascara;
import view.JFramePrincipal;
import view.JPanelOrcamentoFinal;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelOrcamentoFinal  implements MouseListener, KeyListener, FocusListener {
	

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
		getjPanelOrcamentoFinal().getjTFieldDTInicial().addFocusListener(this);
		getjPanelOrcamentoFinal().getjTFieldDTFinal().addFocusListener(this);
		
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
		
		if(e.getSource() == getjPanelOrcamentoFinal().getjButtonNovoOrcamentoFinal()) {
			// quando o botão novo pré orçamento for clicado
			this.gerarNovoOrcamentoFinal();
		}
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getjPanelOrcamentoFinal().getjTFieldDTInicial()) {
			
			Mascara.setMascara(getjPanelOrcamentoFinal().getjTFieldDTInicial(), Mascara.mascaraData());
			
		}
		
		if(e.getSource() == getjPanelOrcamentoFinal().getjTFieldDTFinal()) {
			
			Mascara.setMascara(getjPanelOrcamentoFinal().getjTFieldDTFinal(), Mascara.mascaraData());
			
		}
		
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
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
	
	
	/*
	 * Exibe uma um JOptionPane com a messagem "Deseja originar a partir de um pré orçamento?"
	 * e disponibiliza as opções: Sim, não e cancelar.
	 * 
	 */
	private void gerarNovoOrcamentoFinal() {
		
		int optionSelect = 0; //rebe o valor do botão selecionado pelo usuário.

		String message = "Deseja originar a partir de um pré orçamento?";
		String title = "Gerar novo orçamento final";
		String[] options = {"Sim", "Não", "Cancelar"}; // botoes disponíves na tela
		
		optionSelect = JOptionPane.showOptionDialog(null,
				message,
				title,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		
		switch (optionSelect) {
		//opção "SIM"
		case 0:			
			this.gerarParcialOuCompleto();
			break;
			
		//opção "NÃO"
		case 1:
			// ? leva direto para novo orçamento final
			break;
			
		//opção "CANCELAR"
		case 2:
			
			break;
			
		}
	}

	
	/*
	 * Exibe uma um JOptionPane com a messagem "Selecionar ítens expecificos ou todos do pre orçamento?"
	 * e disponibiliza as opções: Parcial, todos e voltar.
	 * 
	 */
	private void gerarParcialOuCompleto() {
		
		int optionSelect = 0; //rebe o valor do botão selecionado pelo usuário.

		String message = "Selecionar ítens expecificos ou todos do pre orçamento?";
		String title = "Gerar novo orçamento final";
		String[] options = {"Parcial", "Todos", "Voltar"}; // botoes disponíves na tela
		
		optionSelect = JOptionPane.showOptionDialog(null,
				message,
				title,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		
		switch (optionSelect) {
		//opção "PARCIAL"
		case 0:			
			// ? leva para tela de seleção de ítens
			
			break;
			
		//opção "TODOS"
		case 1:
			// ? leva direto para novo orçamento final
			
			break;
			
		//opção "VOLTAR"
		case 2:
			
			break;
		}
	}
	
	
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
