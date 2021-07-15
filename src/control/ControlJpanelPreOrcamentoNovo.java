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
	

	//** Início declaração de variáveis **
	
	private Point point = new Point(250, 47); // posição que a tela e setada na jpanelprincipal
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
		// quando o botão "cancelar pré orçamento" for clicado
		if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonCancelar()) {
			getjPanelPrincipal().alterarJPanel(getjPanelPreOrcamento(), this.point);
		}
		
		
		// quando o botão "salvar pré orçamento" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSalvar()) {
		}
		
		
		// quando o botão "imprimir pré orçamento" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonImprimir()) {
			
		}
		
		
		// quando o botão "procurar cliente" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonProcuraCliente()) {
			jDialogProcurarCliente = null;
			controlJDialogProcurarCliente = null;
			getjDialogProCliente();
			getconControlJDialogProcurarCliente();
		}
		
		
		// quando o botão "selecionar veículo" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonSelecionarVeiculo()) {
			/*
			 * Realizar verificação se já foi selecionada algum cliente
			 * se sim faz a chamada da tela para selecionar um veículo
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
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		
		// quando o botão "lista de produtos" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaProdutos()) {
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaProdutos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(true);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(false);
			/*
			 * caso o método getListaProduotos() retorne false será exibida uma mensagem de aviso
			 */
			if(!getdaoJPanelPreOrcamentoNovo().getListaProduotos()) {
				JOptionPane.showConfirmDialog(
						getjPanelPreOrcamentoNovo(), // componente
						"Clique no botão com o símbolo de '+'\npara adicionar um novo produto.", // texto
						"Nenhum produto inserido", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}			
		}
		
		
		// quando o botão "lista de servisos" for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonListaServicos()) {
			this.mudarCorJButtonSelecionado(getjPanelPreOrcamentoNovo().getjButtonListaServicos());
			this.getjPanelPreOrcamentoNovo().getjSPListaProdutos().setVisible(false);
			this.getjPanelPreOrcamentoNovo().getjSPListaServicos().setVisible(true);
			/*
			 * caso o método getListaProduotos() retorne false será exibida uma mensagem de aviso
			 */
			if(!getdaoJPanelPreOrcamentoNovo().getListaServicos()) {
				JOptionPane.showConfirmDialog(
						getjPanelPreOrcamentoNovo(), // componente
						"Clique no botão com o símbolo de '+'\npara adicionar um  novo serviço.", // texto
						"Nenhum serviço inserido", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}	
		}
		
		
		// Quando o botão adicionar for clicado
		else if(e.getSource() == getjPanelPreOrcamentoNovo().getjButtonAdicionarProdutoServico()) {
			jDialogInserirProduto = null;
			controlJDialogInserirProduto = null;
			getjDialogInserirProduto();
			getconControlJDialogInserirProduto();
		}
		
		
		// Quando o botão editar for clicado
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
	
	
	public DaoJPanelPreOrcamentoNovo getdaoJPanelPreOrcamentoNovo() {
		if(daoJPanelPreOrcamentoNovo == null){
			daoJPanelPreOrcamentoNovo = new DaoJPanelPreOrcamentoNovo();	
		}
		return daoJPanelPreOrcamentoNovo;
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
	
	/*
	 * método mudarCorJButtonSelecionado(@jButton)
	 * 
	 * @jButton - Recebe como parâmetro o JButton para realização de mudança de ícone,
	 * mudança de background e mudança de foreground.
	 * 
	 */
	public void preencherCabecalho() {
		// seta o jTextField do numero do pre orçamento
		getjPanelPreOrcamentoNovo().getjTFieldNumeroPreOrcamento().setText(
				Integer.toString(getdaoJPanelPreOrcamentoNovo().getnumeroPreOrcamento())				
		);
		
		// seta a data no jTextField data
		getjPanelPreOrcamentoNovo().getjTFieldDataPreOrcamento().setText(
				new SimpleDateFormat("dd/MM/yy").format(new Date())
		);
		
		// seta o horário no jTextField horario
		getjPanelPreOrcamentoNovo().getjTFieldHorarioPreOrcamento().setText(
				new SimpleDateFormat("hh:mm:ss").format(new Date())
		);
	}
	//** Fim métodos da classe **
	
	
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
