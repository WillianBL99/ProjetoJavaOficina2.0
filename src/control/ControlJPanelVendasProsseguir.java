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
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import dao.ComandosSQL;
import dao.DaoJPanelVendasProsseguir;
import dao.ModuloConexao;
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.TabelaTemporaria;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;
import view.JPanelVendasProsseguir;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelVendasProsseguir implements MouseListener, KeyListener, FocusListener {
	

	//** In�cio declara��o de vari�veis **
	private TabelaTemporaria tabelaTemporaria;
	public enum FormaPagamento{DINHEIRO, CARTAO};
	
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private ControlJDialogProcurarCliente_Venda controlJDialogProcurarCliente_Venda;
	private DaoJPanelVendasProsseguir daoJPanelVendasProsseguir;
	private FormaPagamento formaPagamento;
	private Float valorTotal;
	private Float desconto;
	private Float valorPagar;
	private Float valorPago;
	private Float valorTroco;
	private Integer idEmpresa;
	private Integer idUsuario;
	private Integer idCliente;
	
	
	//** Fim declara��o de vari�veis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendasProsseguir
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendasProsseguir(JFramePrincipal jFramePricipal, JPanelVendasProsseguir jPanelVendasProsseguir,
			JPanelPrincipal jPanelPrincipal, JPanelVendasNovo jPanelVendasNovo, JPanelVendas jPanelVendas, ControlJPanelVendasNovo controlJPanelVendasNovo) {
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendasProsseguir = jPanelVendasProsseguir;
		this.jPanelPrincipal = jPanelPrincipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.controlJPanelVendasNovo = controlJPanelVendasNovo;
		this.jPanelVendas = jPanelVendas;
		setValorTotal(getControlJPanelVendasNovo().getValortotal());		
		iniciarTela();
		
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjPanelVendasProsseguir().getjButtonVoltar().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonCartao().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonDinheiro().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonProcurar().addMouseListener(this);
		getjPanelVendasProsseguir().getjButtonFinalizarCompra().addMouseListener(this);
		getjPanelVendasProsseguir().getchoiceVendedor().addMouseListener(this);
		getjPanelVendasProsseguir().getjTFieldDesconto().addFocusListener(this);
		getjPanelVendasProsseguir().getjTFieldValorPago().addFocusListener(this);
		
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
		// Quando clicar no bot�o voltar
		if(e.getSource() == getjPanelVendasProsseguir().getjButtonVoltar()) {
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			
		} 
		
		
		// Quando clicar no choice
		else if(e.getSource() == getjPanelVendasProsseguir().getchoiceVendedor()) {
			
		}
		
		
		// Quando clicar no bot�o cart�o
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonCartao()) {
			limparDados();
			setFormaPagamento(FormaPagamento.CARTAO);
			getjPanelVendasProsseguir().getchoiceVendedor().requestFocus();
		} 
		
		
		// Quando clicar no bot�o dinheiro
		 else if(e.getSource() == getjPanelVendasProsseguir().getjButtonDinheiro()) {
			setFormaPagamento(FormaPagamento.DINHEIRO);
		} 
		
		
		// Quando clicar no bot�o procurar cliente
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonProcurar()) {
			jDialogProcurarCliente = null;
			controlJDialogProcurarCliente_Venda = null;
			getjDialogProcurarCliente();
			getControlJDialogProcurarCliente_Venda();
		 }
		 

		// Quando clicar no bot�o finalizar compra 
		else if(e.getSource() == getjPanelVendasProsseguir().getjButtonFinalizarCompra()) {
						
			validarVenda();
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
		// 
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// Quando o campo Valor pago receber foco
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			// Verifica se o valor atual � nullo
			if(valorPagoValido()) {
				getjPanelVendasProsseguir().getjTFieldValorPago().setText(String.format("%.2f", getValorPago()));
			}
			// caso o valor apgo n�o seja valido
			else {
				getjPanelVendasProsseguir().getjTFieldValorPago().setText("");				
			}
		}
		
		
		// Quando o campo desconto receber foco
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			// Verifica se o desconto atual � nullo
			if(valorDescontoValido()) {
				getjPanelVendasProsseguir().getjTFieldDesconto().setText(String.format("%.2f", getDesconto()));
			}
			// caso o desconto n�o seja valido
			else {
				getjPanelVendasProsseguir().getjTFieldDesconto().setText("");				
			}
		}
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// Quando o JTxF desconto perder o focu
		if(e.getSource() == getjPanelVendasProsseguir().getjTFieldDesconto()) {
			setDesconto(getjPanelVendasProsseguir().getjTFieldDesconto().getText());
			// Verifica se digitou algo
			if(getDesconto() != -1352) {
				// verifica se o desconto � v�lido
				if(valorDescontoValido()) {
					// atualizar valores da tela e vari�vel
					setValorPagar(getValorTotal() - getDesconto());
					getjPanelVendasProsseguir().getjTFieldDesconto().setText(String.format(" R$ %.2f", getDesconto()));
					getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %.2f", getValorPagar()));
					getjPanelVendasProsseguir().getjTFieldValorPago().requestFocus();
					// verifica se est� clicado em dinheiro e se o valor n�o est� vazio
					if(getFormaPagamento() == FormaPagamento.DINHEIRO
							&& !getjPanelVendasProsseguir().getjTFieldValorPago().getText().replace(" ", "").isEmpty()) {
						atualizaTroco();
						getjPanelVendasProsseguir().getjTFieldValorPago().requestFocus();
					}
				}
				// Caso o desconto n�o seja v�lido
				else {
					
				}
			}
			// se n�o digitou nada
			else {
				setDesconto(0f);
				getjPanelVendasProsseguir().getjTFieldDesconto().setText(String.format(" R$ %.2f", getDesconto()));
				getjPanelVendasProsseguir().getjTFieldValorPago().requestFocus();
			}
		}
		
		
		// Quando o JTxF valor pago perder o foco
		else if(e.getSource() == getjPanelVendasProsseguir().getjTFieldValorPago()) {
			setValorPago(getjPanelVendasProsseguir().getjTFieldValorPago().getText());
			// Verificar se foi digitado algo
			if(getValorPago() != -1352) {
				// Verificar se o valor � v�lido
				if(valorPagoValido()){
					// formata o campo valor pago
					getjPanelVendasProsseguir().getjTFieldValorPago().setText(String.format(" R$ %.2f", getValorPago()));
					atualizaTroco();
				}
				// Caso n�o seja v�lido
				else {
					atualizaTroco();
					JOptionPane.showConfirmDialog(
							getjPanelVendasProsseguir(), // componente
							"Valor inv�lido inserido."
							+ "O valor tem que ser maior ou igual ao valor do campo \"Valor pagar\".", // texto
							"Valor inv�lido", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
				}
			}
			// N�o foi digitado nada
			else {
				atualizaTroco();
			}
		}
		
	}
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **

	public JFramePrincipal getjFramePricipal() {
		if(jFramePricipal == null) {
			jFramePricipal = new JFramePrincipal();
		}
		return jFramePricipal;
	}



	public JPanelVendasProsseguir getjPanelVendasProsseguir() {
		if(jPanelVendasProsseguir == null) {
			jPanelVendasProsseguir = new JPanelVendasProsseguir();
		}
		return jPanelVendasProsseguir;
	}



	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}		
	
	
	public JPanelVendas getjPanelVendas() {
		if(jPanelVendas == null){
			jPanelVendas = new JPanelVendas();

		}
		return jPanelVendas;
	}		
		
		
	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null){
			jPanelVendasNovo = new JPanelVendasNovo();
	
		}
		return jPanelVendasNovo;
	}
	

	public ControlJPanelVendasNovo getControlJPanelVendasNovo() {
		if(controlJPanelVendasNovo == null){
			controlJPanelVendasNovo = new ControlJPanelVendasNovo(getjFramePricipal(), getjPanelVendasNovo(),
					getjPanelVendas(), getjPanelPrincipal());	
		}
		return controlJPanelVendasNovo;
	}
	
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);			
		}
		return jDialogProcurarCliente;
	}
	
	
	public ControlJDialogProcurarCliente_Venda getControlJDialogProcurarCliente_Venda() {
		if(controlJDialogProcurarCliente_Venda == null){
			controlJDialogProcurarCliente_Venda = new ControlJDialogProcurarCliente_Venda(getjFramePricipal(), getjDialogProcurarCliente(), getjPanelVendasProsseguir(), this);
		}
		return controlJDialogProcurarCliente_Venda;
	}
	
	
	public DaoJPanelVendasProsseguir getDaoJPanelVendasProsseguir() {
		if(daoJPanelVendasProsseguir == null){
			daoJPanelVendasProsseguir = new DaoJPanelVendasProsseguir(this);
		}
		return daoJPanelVendasProsseguir;
	}
	
	
	public TabelaTemporaria getTabelaTemporaria() {
		if(tabelaTemporaria == null){
			tabelaTemporaria = getjPanelVendasNovo().gettabelaTabelaTemporaria();
		}
		return tabelaTemporaria;
	}
	
	
	public Float getValorTotal() {
		return valorTotal;
	}
	

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	public void setValorTotal(String valorTotal) {
		String valor = valorTotal.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorTotal = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getDesconto() {
		if(desconto == null)
			desconto = -1352f;
		return desconto;
	}


	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	
	
	public void setDesconto(String desconto) {
		String valor = desconto.replace(" ", "").replace(",", ".").replace("R$", "");
		this.desconto = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getValorPagar() {
		return valorPagar;
	}
	

	public void setValorPagar(Float valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	
	public void setValorPagar(String valorPagar) {
		String valor = valorPagar.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorPagar = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}
	

	public Float getValorPago() {
		if(valorPago == null)
			valorPago = -1352f;
		return valorPago;
	}
	

	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}
	
	
	public void setValorPago(String valorPago) {
		String valor = valorPago.replace(" ", "").replace(",", ".").replace("R$", "");
		this.valorPago = (valor.isEmpty() ? -1352 : Float.parseFloat(valor));
	}


	public Float getValorTroco() {
		return valorTroco;
	}


	public void setValorTroco(Float valorTroco) {
		this.valorTroco = valorTroco;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	public void setIdEmpresa(String idEmpresa) {
		String valor = idEmpresa.replace(" ", "");
		this.idEmpresa = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public void setIdUsuario(String idUsuario) {
		System.out.println(idUsuario + " id usuario");
		String valor = idUsuario.replace(" ", "");
		this.idUsuario = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}


	public Integer getIdCliente() {
		if(idCliente == null) idCliente = 0;
		return idCliente;
	}
	

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	public void setIdCliente(String idCliente) {
		String valor = idCliente.replace(" ", "");
		this.idCliente = Integer.parseInt(valor.isEmpty() ? "-1354" : valor);
	}
	
	
	public FormaPagamento getFormaPagamento() {
		if(formaPagamento == null) {
			formaPagamento = FormaPagamento.DINHEIRO;
		}
		return formaPagamento;
	}
	
	/**
	 * Seta a forma de pagamento de acordo com o bot�o clicado, assim como, configura a interface
	 * da tela.
	 * @param formaPagamento
	 */
	private void setFormaPagamento(FormaPagamento formaPagamento) {
		
		if(getFormaPagamento() != formaPagamento) {
			// Seta a forma de pagamento
			this.formaPagamento = formaPagamento;
			// Seta a interface para cart�o clicado
			if(formaPagamento == FormaPagamento.CARTAO) {
				getjPanelVendasProsseguir().getjButtonCartao().setForeground(Cores.preto);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonCartao(), Icones.getCartaoAzul(), 50, 50);
				
				getjPanelVendasProsseguir().getjButtonDinheiro().setForeground(Cores.cinza1);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonDinheiro(), Icones.getDinheiroCinza(), 50, 50);
				
				getjPanelVendasProsseguir().getjPanelDadosPagamento().setVisible(false);
				getjPanelVendasProsseguir().getjPanelDadosVendedorCliente().setLocation(14 ,323);
				getjPanelVendasProsseguir().getjButtonFinalizarCompra().setLocation(807 ,469);
			}
			// seta a interface para dinheiro clicado
			else {
				getjPanelVendasProsseguir().getjButtonCartao().setForeground(Cores.cinza1);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonCartao(), Icones.getCartaoCinza(), 50, 50);
				
				getjPanelVendasProsseguir().getjButtonDinheiro().setForeground(Cores.preto);
				getjPanelVendasProsseguir().getSetSizeIcon().setIconJButton(
						getjPanelVendasProsseguir().getjButtonDinheiro(), Icones.getDinheiroAzul(), 50, 50);
				
				getjPanelVendasProsseguir().getjPanelDadosPagamento().setVisible(true);
				getjPanelVendasProsseguir().getjPanelDadosVendedorCliente().setLocation(14 ,469);
				getjPanelVendasProsseguir().getjButtonFinalizarCompra().setLocation(807 ,615);
			}
		}		
	}
	
	
	/**
	 * Seta os campos ao iniciar a tela.
	 */
	private void iniciarTela() {
		setValorPagar(getValorTotal());
		getjPanelVendasProsseguir().getjTFieldValorTotCompra().setText(String.format(" R$ %.2f", getValorTotal()));
		getjPanelVendasProsseguir().getjTFieldValorPagar().setText(String.format(" R$ %.2f", getValorPagar()));
		getjPanelVendasProsseguir().getjTFieldDesconto().requestFocus();
	}
	
	
	/**
	 * Verifica se o desconto � v�lido
	 * @return retorna verdadeiro se for v�lido
	 */
	private boolean valorDescontoValido() {
		if(getDesconto() >= 0 && getDesconto() <= getValorPagar()) 
			return true;
		return false;
	}
	
	/**
	 * Verifica se o valor pago � v�lido.
	 * @return retorna verdadeiro caso seja v�lido.
	 */
	private boolean valorPagoValido() {
		if(getValorPago() >= getValorPagar())
			return true;
		return false;
	}
	
	
	/**
	 * Atualiza o campo troco e modifica o campo valor pago caso seja inv�lido.
	 */
	private void atualizaTroco() {
		// se o valor pago for v�lido
		if(valorPagoValido()) {
			setValorTroco(getValorPago() - getValorPagar());
			getjPanelVendasProsseguir().getjTFieldTroco().setText(String.format(" R$ %.2f", getValorTroco()));
			// seta o campo valor pago com o designer normal
			getjPanelVendasProsseguir().getjTFieldValorPago().setBorder(BorderFactory.
				createTitledBorder(new javax.swing.border.
					LineBorder(Cores.azul1, 4, true),
					"Valor pago",
					javax.swing.border.TitledBorder.LEFT,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					Fontes.fontBorda2,
					Cores.azul1));
		}
		// se o valor pago n�o for v�lido
		else {
			// seta o campo valor pago com designer de erro.
			// Setar campo troco como ""
			getjPanelVendasProsseguir().getjTFieldTroco().setText("");
			getjPanelVendasProsseguir().getjTFieldValorPago().setBorder(BorderFactory.
				createTitledBorder(new javax.swing.border.
					LineBorder(Cores.vermelho, 4, true),
					"Valor pago*",
					javax.swing.border.TitledBorder.LEFT,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					Fontes.fontBorda2,
					Cores.vermelho));
		}		
	}
	
	
	// Finaliza a venda
	private boolean finalizarVenda() {
		if(getDaoJPanelVendasProsseguir().cadastrarVenda()) {
			JOptionPane.showConfirmDialog(
					getjPanelVendasProsseguir(), // componente
					"Venda finalizada com sucesso.", // texto
					"Venda finalizada", // titulo
					JOptionPane.DEFAULT_OPTION, // bot�es
					JOptionPane.PLAIN_MESSAGE // tipo de mensagem
					);
			this.getjFramePricipal().alterarJPanel(this.getjPanelPrincipal());
			return true;			
		}
		// caso ocorra erro no momento da venda
		else {
			JOptionPane.showConfirmDialog(
					getjPanelVendasProsseguir(), // componente
					"A compra n�o foi finalizada.\n"
					+ "Ocorreu um erro inesperado com o banco de dados.\n"
					+ "Tente novamente. Caso n�o consiga contate a assist�ncia.", // texto
					"Erro inesperado", // titulo
					JOptionPane.DEFAULT_OPTION, // bot�es
					JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
			return false;
		}		
	}
	
	
	/**
	 * Exibe as principais informa��es da venda.
	 * @return Retorna uma String com as principais iforma��es da venda.
	 */
	private String exibirVenda() {
		String texto = String.format(
				"Dados da venda:\n"
				+ "%-12s R$ %.2f\n"
				+ "%-12s R$ %.2f\n"
				+ "%-12s R$ %.2f\n\n"
				+ "Finalizar venda?",
				"Total:", getValorPagar(),
				"Recebido:", getValorPago(),
				"Troco:", getValorTroco());
		return texto;
	}
	
	
	private boolean exibirOptionPaneFinalizar(String texto) {
		// Vetor de String com os nomes das op��es que apareceram no joptionpane.
		String[] options = {"Finalizar", "Cancelar"}; 
		
		/*
		 * int option
		 * recebe 0 ou 1 de acordo com a mensage selecionada
		 * - 0: Foi secionada a op��o Sim
		 * - 1: Foi selecionada a op��o Cancelar
		 */
		int option = JOptionPane.showOptionDialog(
				getjPanelVendasProsseguir(), // tela pai
				texto, // mensagem
				"Finalizar venda", // t�tulo
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE,
				null,
				options,
				options[1]); // op��o selecionada inicialmente
		
		// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
		if(option == 0) {
			return true;
		}
		return false;
	}
	
	
	private boolean validarVenda() {
		boolean retorno = false;
		// Verifica se foi escolhido um usu�rio;
		if(getjPanelVendasProsseguir().getchoiceVendedor().getSelectedIndex() != 0) {
			/*
			 * Realiza a busca de todos os usu�rios busca o valor do id na ordem em que
			 * est�o dispostos e selecionado o usuario no choice
			 */
			ModuloConexao md = new ModuloConexao();
			md.executeQuery(ComandosSQL.consultarUsuariosAll());
			try {
				setIdUsuario(md.valueAt(getjPanelVendasProsseguir().getchoiceVendedor().getSelectedIndex() - 1, 0));
			} catch (SQLException e1) {
				// Erro ao fazer consultar no banco de dados
				e1.printStackTrace();
			}				
			
			/*
			 * Verificar se a compra foi paga via cart�o ou dinheiro
			 */
			switch(getFormaPagamento()) {
			// Caso a forma de pagamento seja no cart�o
			case CARTAO:
				// Verifica a escolha do usu�rio
				if(exibirOptionPaneFinalizar(
					"Certifique-se que a compra foi paga corretamente\n"
					+ "antes de clicar em \"Finalizar compra\"."))
				{
					// Caso ocorra erros na execu��o das multiplas querys
					finalizarVenda();
				}				
				break;
				
			// Caso a forma de pagamento seja no dinheiro
			case DINHEIRO:
				// Verifica se o valor pago � v�lido
				if(valorPagoValido()) {
					// Verificar a escolha do usu�rio
					if(exibirOptionPaneFinalizar(exibirVenda())) {
						// Caso ocorra erros na execu��o das multiplas querys
						finalizarVenda();
					}
				}
				// Valor pago n�o � v�lido
				else {
					existCamposVazio();	
					retorno = false;
				}
				break;
			}
		}
		// vendedor n�o foi selecionado
		else {			
			existCamposVazio();
			retorno = false;
		}
		return retorno;
	}
	
	
	
	private void existCamposVazio() {
		JOptionPane.showConfirmDialog(
				getjPanelVendasProsseguir(), // componente
				"Verifique se todos os campos marcados com \"*\" est�o preenchidos corretamente.", // texto
				"Imposs�vel finalizar", // titulo
				JOptionPane.DEFAULT_OPTION, // bot�es
				JOptionPane.ERROR_MESSAGE // tipo de mensagem
				);
	}
	
	
	/**
	 * Limpa os camos e as vari�veis da �rea dados pagamento.
	 */
	private void limparDados() {
		getjPanelVendasProsseguir().getjTFieldValorPago().setText("");
		getjPanelVendasProsseguir().getjTFieldTroco().setText("");
		setValorPago("");
		setValorTroco(0f);
	}
	//** Fim m�todos da classe **



}
