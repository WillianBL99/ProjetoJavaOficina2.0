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
	

	//** In�cio declara��o de vari�veis **
	
	private Point point = new Point(250, 47); // posi��o que a tela e setada na jpanelprincipal
	private JButton jButtonClicado; // guarda o jbutton clicado
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	
	//** Fim declara��o de vari�veis **	
	
	
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
		
		this.jButtonClicado = getjPanelPreOrcamentoNovo().getjButtonListaProdutos(); // bot�o que est� selecionado previamente.
		
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
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonCancelar()) {
			// quando o bot�o "cancelar pr� or�amento" for clicado
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamento(), this.point);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSalvar()) {
			// quando o bot�o "salvar pr� or�amento" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonImprimir()) {
			// quando o bot�o "imprimir pr� or�amento" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonProcuraCliente()) {
			// quando o bot�o "procurar cliente" for clicado
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSelecionarVeiculo()) {
			// quando o bot�o "selecionar ve�culo" for clicado
			new JDialogProcurarVeiculo(getjFramePrincipal(), true);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaProdutos()) {
			// quando o bot�o "lista de produtos" for clicado
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaProdutos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(true);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(false);
			
			
		} else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaServicos()) {
			// quando o bot�o "lista de servisos" for clicado
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
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

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
	 * m�todo mudarCorJButtonSelecionado(@jButton)
	 * 
	 * @jButton - Recebe como par�metro o JButton para realiza��o de mudan�a de �cone,
	 * mudan�a de background e mudan�a de foreground.
	 * 
	 */
	public void mudarCorJButtonSelecionado(JButton jButton) {
		if(jButtonClicado != null && jButtonClicado != jButton) { 
			// setando a nova apar�ncia do JButton clicado.
			jButton.setBackground(Cores.azul1);
			jButton.setForeground(Cores.branco);
			// setando a apar�ncia do JButton clicado ateriormente.
			jButtonClicado.setBackground(Cores.cinza2);
			jButtonClicado.setForeground(Cores.preto);
			// guardando os caminhos dos �cones do JButton que est� selecionado.
			jButtonClicado = jButton;
		}
	}
	//** Fim m�todos da classe **
}
