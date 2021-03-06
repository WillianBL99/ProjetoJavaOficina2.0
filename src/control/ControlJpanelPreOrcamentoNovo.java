/**
 * 
 */
package control;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import model.Cores;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;
import view.JPanelPreOrcamento;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJpanelPreOrcamentoNovo  implements MouseListener, KeyListener {
	

	//** Início declaração de variáveis **
	
	private Point point = new Point(250, 47); // posição que a tela e setada na jpanelprincipal
	private JButton jButtonClicado; // guarda o jbutton clicado
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	
	//** Fim declaração de variáveis **	
	
	
	/**
	 * @param jPanelPrincipal
	 * @param jPanelPreOrcamento
	 */
	public ControlJpanelPreOrcamentoNovo(JFramePrincipal jFramePrincipal, JPanelPrincipal jPanelPrincipal, JPanelPreOrcamento jPanelPreOrcamento,
			JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo) {
		super();
		this.jFramePrincipal = jFramePrincipal;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelPreOrcamento = jPanelPreOrcamento;
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
		
		this.jButtonClicado = getjPanelPreOrcamentoNovo().getjButtonListaProdutos(); // botão que está selecionado previamente.
		
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelPreOrcamentoNovo().getjButtonCancelar().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonSalvar().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonImprimir().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonProcuraCliente().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonSelecionarVeiculo().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonListaProdutos().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonListaServicos().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonAdicionarProdutoServico().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonEditarProdutoServico().addMouseListener(this);
		getjPanelPreOrcamentoNovo().getjButtonApagarProdutoServico().addMouseListener(this);
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
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonCancelar()) {
			// quando o botão "cancelar pré orçamento" for clicado
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamento(), this.point);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSalvar()) {
			// quando o botão "salvar pré orçamento" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonImprimir()) {
			// quando o botão "imprimir pré orçamento" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonProcuraCliente()) {
			// quando o botão "procurar cliente" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSelecionarVeiculo()) {
			// quando o botão "selecionar veículo" for clicado
			new JDialogProcurarVeiculo(getjFramePrincipal(), true);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaProdutos()) {
			// quando o botão "lista de produtos" for clicado
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaProdutos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(true);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(false);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaServicos()) {
			// quando o botão "lista de servisos" for clicado
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaServicos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(false);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(true);
			
			
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
	
	/*
	 * método mudarCorJButtonSelecionado(@jButton)
	 * 
	 * @jButton - Recebe como parâmetro o JButton para realização de mudança de ícone,
	 * mudança de background e mudança de foreground.
	 * 
	 */
	public void mudarCorJButtonSelecionado(JButton jButton) {
		if(jButtonClicado != null && jButtonClicado != jButton) { 
			// setando a nova aparência do JButton clicado.
			jButton.setBackground(Cores.azul1);
			jButton.setForeground(Cores.branco);
			// setando a aparência do JButton clicado ateriormente.
			jButtonClicado.setBackground(Cores.cinza2);
			jButtonClicado.setForeground(Cores.preto);
			// guardando os caminhos dos ícones do JButton que está selecionado.
			jButtonClicado = jButton;
		}
	}
	//** Fim métodos da classe **
}
