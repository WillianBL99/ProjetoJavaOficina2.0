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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import dao.DaoJPanelPreOrcamentoNovo;
import model.Cores;
import model.Mascara;
import view.JDialogInserirProduto;
import view.JDialogProcurarCliente;
import view.JDialogProcurarPeca;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;
import view.JPanelPreOrcamento;
import view.JPanelPreOrcamentoNovo;
import view.JPanelPrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJpanelPreOrcamentoNovo  implements MouseListener, KeyListener, FocusListener {
	

	//** In�cio declara��o de vari�veis **
	
	private Point point = new Point(250, 47); // posi��o que a tela e setada na jpanelprincipal
	private JButton jButtonClicado; // guarda o jbutton clicado
	
	private JFramePrincipal jFramePrincipal;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPreOrcamento jPanelPreOrcamento;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private DaoJPanelPreOrcamentoNovo daoJPanelPreOrcamentoNovo;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private ControlJDialogProcurarCliente controlJDialogProcurarCliente;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private ControlJDialogProcurarVeiculo controlJDialogProcurarVeiculo;
	private JDialogInserirProduto jDialogInserirProduto;
	private ControlJDialogInserirProduto controlJDialogInserirProduto;
	
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
		this.preencherCabecalho();
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
		
		getjPanelPreOrcamentoNovo().getjTFieldAno().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldChassi().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldCpf().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldDataPreOrcamento().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldKMAtual().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldPlaca().addFocusListener(this);
		getjPanelPreOrcamentoNovo().getjTFieldTelefone().addFocusListener(this);
		
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
		// quando o bot�o "cancelar pr� or�amento" for clicado
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonCancelar()) {
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamento(), this.point);
		}
		
		
		// quando o bot�o "salvar pr� or�amento" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSalvar()) {
		}
		
		
		// quando o bot�o "imprimir pr� or�amento" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonImprimir()) {
			
		}
		
		
		// quando o bot�o "procurar cliente" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonProcuraCliente()) {
			jDialogProcurarCliente = null;
			controlJDialogProcurarCliente = null;
			getjDialogProCliente();
			getconControlJDialogProcurarCliente();
		}
		
		
		// quando o bot�o "selecionar ve�culo" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSelecionarVeiculo()) {
			/*
			 * Realizar verifica��o se j� foi selecionada algum cliente
			 * se sim faz a chamada da tela para selecionar um ve�culo
			 */
			if(getjPanelPreOrcamentoNovo().getidCliente() != null) {
				jDialogProcurarVeiculo = null;
				controlJDialogProcurarVeiculo = null;
				getjDialogProcurarVeiculo();
				getcontrolJDialogProcurarVeiculo();
				
			// Caixa de dialogo
			} else {
				JOptionPane.showConfirmDialog(
						getjPanelPreOrcamentoNovo(), // componente
						"Selecione um cliente primeiro.", // texto
						"Nenhum Cliente Selecionado", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		
		// quando o bot�o "lista de produtos" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaProdutos()) {
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaProdutos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(true);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(false);
			/*
			 * caso o m�todo getListaProduotos() retorne false ser� exibida uma mensagem de aviso
			 */
			if(!getdaoJPanelPreOrcamentoNovo().getListaProduotos()) {
				JOptionPane.showConfirmDialog(
						getjPanelPreOrcamentoNovo(), // componente
						"Clique no bot�o com o s�mbolo de '+'\npara adicionar um novo produto.", // texto
						"Nenhum produto inserido", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}			
		}
		
		
		// quando o bot�o "lista de servisos" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaServicos()) {
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaServicos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(false);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(true);
			/*
			 * caso o m�todo getListaProduotos() retorne false ser� exibida uma mensagem de aviso
			 */
			if(!getdaoJPanelPreOrcamentoNovo().getListaServicos()) {
				JOptionPane.showConfirmDialog(
						getjPanelPreOrcamentoNovo(), // componente
						"Clique no bot�o com o s�mbolo de '+'\npara adicionar um  novo servi�o.", // texto
						"Nenhum servi�o inserido", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}	
		}
		
		
		// Quando o bot�o adicionar for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonAdicionarProdutoServico()) {
			jDialogInserirProduto = null;
			controlJDialogInserirProduto = null;
			getjDialogInserirProduto();
			getconControlJDialogInserirProduto();
		}
		
		
		// Quando o bot�o editar for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonEditarProdutoServico()) {
			new JDialogProcurarPeca(getjFramePrincipal(), false);
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldAno()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldAno(), Mascara.mascaraAno());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldChassi()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldChassi(), Mascara.mascaraChassi());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldCpf()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldCpf(), Mascara.mascaraCPF());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldDataPreOrcamento()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldDataPreOrcamento(), Mascara.mascaraData());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldKMAtual()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldKMAtual(), Mascara.mascaraQuilometragem());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldPlaca()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldPlaca(), Mascara.mascaraPlaca());
			
		}
		
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjTFieldTelefone()) {
			
			Mascara.setMascara(getjPanelPreOrcamentoNovo().getjTFieldTelefone(), Mascara.mascaraTelefone());
			
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
	
	
	public DaoJPanelPreOrcamentoNovo getdaoJPanelPreOrcamentoNovo() {
		if(daoJPanelPreOrcamentoNovo == null){
			daoJPanelPreOrcamentoNovo = new DaoJPanelPreOrcamentoNovo();	
		}
		return daoJPanelPreOrcamentoNovo;
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
	
	/*
	 * m�todo mudarCorJButtonSelecionado(@jButton)
	 * 
	 * @jButton - Recebe como par�metro o JButton para realiza��o de mudan�a de �cone,
	 * mudan�a de background e mudan�a de foreground.
	 * 
	 */
	public void preencherCabecalho() {
		// seta o jTextField do numero do pre or�amento
		getjPanelPreOrcamentoNovo().getjTFieldNumeroPreOrcamento().setText(
				Integer.toString(getdaoJPanelPreOrcamentoNovo().getnumeroPreOrcamento())				
		);
		
		// seta a data no jTextField data
		getjPanelPreOrcamentoNovo().getjTFieldDataPreOrcamento().setText(
				new SimpleDateFormat("dd/MM/yy").format(new Date())
		);
		
		// seta o hor�rio no jTextField horario
		getjPanelPreOrcamentoNovo().getjTFieldHorarioPreOrcamento().setText(
				new SimpleDateFormat("hh:mm:ss").format(new Date())
		);
	}
	//** Fim m�todos da classe **
	
	
	public JDialogInserirProduto getjDialogInserirProduto() {
		if(jDialogInserirProduto == null) {
			jDialogInserirProduto = new JDialogInserirProduto(getjFramePrincipal(), true);
		}
		return jDialogInserirProduto;
	}
	
	
	public ControlJDialogInserirProduto getconControlJDialogInserirProduto() {
		if(controlJDialogInserirProduto == null) {
			controlJDialogInserirProduto = new ControlJDialogInserirProduto(getjFramePrincipal(), getjDialogInserirProduto(), getjPanelPreOrcamentoNovo());
		}
		return controlJDialogInserirProduto;
	}
	
	
	public JDialogProcurarCliente getjDialogProCliente() {
		if(jDialogProcurarCliente == null) {
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePrincipal(), true);
			jDialogProcurarCliente.setLocationRelativeTo(getjFramePrincipal());
		}
		return jDialogProcurarCliente;
	}
	
	
	public ControlJDialogProcurarCliente getconControlJDialogProcurarCliente() {
		if(controlJDialogProcurarCliente == null) {
			controlJDialogProcurarCliente = new ControlJDialogProcurarCliente(getjFramePrincipal(), getjDialogProCliente(), getjPanelPreOrcamentoNovo());
		}
		return controlJDialogProcurarCliente;
	}
	
	
	public ControlJDialogProcurarVeiculo getcontrolJDialogProcurarVeiculo() {
		if(controlJDialogProcurarVeiculo == null) {
			controlJDialogProcurarVeiculo = new ControlJDialogProcurarVeiculo(getjFramePrincipal(), getjDialogProcurarVeiculo(), getjPanelPreOrcamentoNovo());
		}
		return controlJDialogProcurarVeiculo;
	}
	
	
	public JDialogProcurarVeiculo getjDialogProcurarVeiculo() {
		if(jDialogProcurarVeiculo == null) {
			jDialogProcurarVeiculo = new JDialogProcurarVeiculo(getjFramePrincipal(), true);
			jDialogProcurarVeiculo.setLocationRelativeTo(getjFramePrincipal());
		}
		return jDialogProcurarVeiculo;
	}





}
