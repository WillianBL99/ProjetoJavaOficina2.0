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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import dao.DaoJDialogInserirServico;
import model.Cores;
import view.JDialogInserirServico;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogInserirServico implements MouseListener, KeyListener, WindowListener, FocusListener{
	
	//** In�cio declara��o de vari�veis **
	private JFramePrincipal jFramePrincipal;
	private JDialogInserirServico jDialogInserirServico;
	private DaoJDialogInserirServico daoJDialogIserirProduto;
	private JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo;
	private boolean modalTela;
	// Tipo enum com as op�oes de botoes clicados
	private enum BotaoClicado {INSERIR_SERVICO, DESCREVER_SERVICO};
	// Objeto tipo enum
	private BotaoClicado botaoClicado;
		
	private int rowSelec;
	private String codigoSelec;
	private String descricaoSelec;
	private String marcaSelec;
	private Integer quantidadeSelec;
	private Float precoSelec;
	
	private Integer qtdInserir;
	private Integer descPercent;
	private Float desconto;
	private Float total;
	
	


	//** Fim declara��o de vari�veis **	
	public ControlJDialogInserirServico(JFramePrincipal jFramePricipal, JDialogInserirServico jDialogInserirServico, JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo) {	
		this.descPercent = 0;
		this.jFramePrincipal = jFramePricipal;
		this.jDialogInserirServico = jDialogInserirServico;
		this.jdiJPanelPreOrcamentoNovo = jdiJPanelPreOrcamentoNovo;
		AddEvent();
		setmodal(getjDialogInserirServico().ismodalTela());

		// Define que bot�o InserirServi�o vai est� clicado inicialmente
		telaVisivel(BotaoClicado.INSERIR_SERVICO);
	}


	private void AddEvent() {
		getjDialogInserirServico().addWindowListener(this);
		getjDialogInserirServico().getjButtonDescreverServico().addMouseListener(this);
		getjDialogInserirServico().getjButtonProcurarServico().addMouseListener(this);
		getjDialogInserirServico().getjButtonCancelar().addMouseListener(this);
		getjDialogInserirServico().getjButtonCancelar().addMouseListener(this);
	}
		
		
	//** In�cio m�todos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// Quando for clicado no jbutton inserir servi�o
		if(e.getSource() == getjDialogInserirServico().getjButtonProcurarServico()) {
			telaVisivel(BotaoClicado.INSERIR_SERVICO);
		}
		
		// Quando for clicado no jbutton descrever servi�o
		else if(e.getSource() == getjDialogInserirServico().getjButtonDescreverServico()) {
			telaVisivel(BotaoClicado.DESCREVER_SERVICO);
		}
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


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void focusLost(FocusEvent e) {
		
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		getjFramePricipal().setEnabled(true);	
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub	
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	

	public JDialogInserirServico getjDialogInserirServico() {
		if(jDialogInserirServico == null){
			jDialogInserirServico = new JDialogInserirServico(getjFramePricipal(), true);
		}
		return jDialogInserirServico;
	}
	

	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jdiJPanelPreOrcamentoNovo == null){
			jdiJPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jdiJPanelPreOrcamentoNovo;
	}
	

	public DaoJDialogInserirServico getdaoJDialogInserirServico() {
		if(daoJDialogIserirProduto == null){
			daoJDialogIserirProduto = new DaoJDialogInserirServico(getjFramePricipal(), null);
		}
		return daoJDialogIserirProduto;
	}
	
	
	public boolean ismodal() {
		return modalTela;
	}
	
	
	public void setmodal(boolean modalTela) {
		this.modalTela = modalTela;
	}
	
	/**
	 * Metodo getRowSelec
	 * @return Retorna um int contendo o valor da linha selecinada.
	 */
	public int getRowSelec() {
		return this.rowSelec;
	}

	// set linhaselecionada selecionado	
	public void setRowSelec(int rowSelec) {
		this.rowSelec = rowSelec;				
	}
	
	/**
	 * Metodo getCodigoSelec
	 * @return Retorna a String contid em um JTextField.
	 */
	public String getCodigoSelec() {
		return this.codigoSelec;
	}

	// set c�digo selecionado	
	public void setCodigoSelec(String codigoSelec) {
		this.codigoSelec = codigoSelec;				
	}
	
	/**
	 * Metodo getCodigoSelec
	 * @return Retorna a String contid em um JTextField.
	 */
	public String getDescricaoSelec() {
		return this.descricaoSelec;
	}

	// set descri��o selecionado	
	public void setDescricaoSelec(String descricaoSelec) {
		this.descricaoSelec = descricaoSelec;				
	}
	
	/**
	 * Metodo getMarcaSelec
	 * @return Retorna a String contida em um JTextField.
	 */
	public String getMarcaSelec() {
		return this.marcaSelec;
	}

	// set m�rca selecionado	
	public void setMarcaSelec(String marcaSelec) {
		this.marcaSelec = marcaSelec;				
	}
	
	/**
	 * Metodo getQuantidadeSelec
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Integer getQuantidadeSelec() {
		return this.quantidadeSelec;
	}

	// set quantidadeSelec selecionado	
	public void setQuantidadeSelec(String quantidadeSelec) {
		this.quantidadeSelec = Integer.parseInt(quantidadeSelec.isEmpty()? "-135" : quantidadeSelec);				
	}
	
	/**
	 * Metodo getPrecoSelec
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Float getPrecoSelec() {
		return this.precoSelec;
	}

	// set preco selecionado	
	public void setPrecoSelec(String precoSelec) {
		this.precoSelec = Float.parseFloat(precoSelec.isEmpty()? "-135" : precoSelec);
	}
	
	/**
	 * Metodo getQtdInserir
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Integer getQtdInserir() {
		return this.qtdInserir;
	}

	// set preco selecionado	
	public void setQtdInserir(String qtdInserir) {
		this.qtdInserir = Integer.parseInt(qtdInserir.isEmpty()? "-135" : qtdInserir);
	}
	
	/**
	 * Metodo getQuantidadeSelec
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Integer getDescPercent() {
		return this.descPercent;
	}

	// set quantidadeSelec selecionado	
	public void setDescPercent(String descPercent) {
		this.descPercent = Integer.parseInt(descPercent.isEmpty()? "-135" : descPercent);;				
	}
	
	/**
	 * Metodo getDesconto
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Float getDesconto() {
		return this.desconto;
	}

	// set desconto selecionado	
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	
	/**
	 * Metodo getTotal
	 * @return Retorna o inteiro do getText() de um jTextField. Caso n�o tenha nada no jtx retorna o valor -135
	 */
	public Float getTotal() {
		return this.total;
	}

	// set total selecionado	
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
	
	private void limpaCampos() {
		
		
	}
	
	
	/**
	 * M�todo inserirProduto() insere o valores de entrada em uma tabela e organiza
	 * os valores antes de inseir.
	 * @param id
	 * @param qtd
	 * @param desc
	 * @param preco
	 * @param valDesc
	 * @param total
	 * @return boolean Retorna false caso o produto j� tenha sido inserido.
	 */
	private boolean inserirProduto(String id, String qtd, String desc, String preco, String valDesc, String total) {
		return getjPanelPreOrcamentoNovo().gettabelaTemporariaProdutos().inserir(
				getjPanelPreOrcamentoNovo().getjTableListaProdutos(),
				id,
				qtd,
				desc,
				preco,
				valDesc,
				total);
	}
	
	/**
	 * M�todo atualizarCamposDados atualiza os campos e algumas vari�veis
	 * assim que um produto � selecionado na tabela.
	 */
	private void atualizarCamposDados() {
		
		
	}
	
	private void atualizaCamposInsercao() {
		
	}
	
	/**
	 * M�todo telaVisivel(BotaoCicado botaoClicado) Exibe componentes de acordo com o bot�o clicado
	 * @param botaoClicado
	 */
	public void telaVisivel(BotaoClicado botaoClicado) {
		setBotaoClicado(botaoClicado);
		boolean exibir = true;
		if(botaoClicado == BotaoClicado.DESCREVER_SERVICO) {
			exibir = false;
			getjDialogInserirServico().getjButtonProcurarServico().setBackground(Cores.cinza2);
			getjDialogInserirServico().getjButtonProcurarServico().setForeground(Cores.preto);
			getjDialogInserirServico().getjButtonDescreverServico().setBackground(Cores.azul1);
			getjDialogInserirServico().getjButtonDescreverServico().setForeground(Cores.branco);
			System.out.println("tela descrever servi�o");
		} else {
			getjDialogInserirServico().getjButtonProcurarServico().setBackground(Cores.azul1);
			getjDialogInserirServico().getjButtonProcurarServico().setForeground(Cores.branco);
			getjDialogInserirServico().getjButtonDescreverServico().setBackground(Cores.cinza2);
			getjDialogInserirServico().getjButtonDescreverServico().setForeground(Cores.preto);
			System.out.println("tela inserir servi�o");
		}
			
		getjDialogInserirServico().getjLabelCodigo().setVisible(exibir);
		getjDialogInserirServico().getjTFieldCodigo().setVisible(exibir);
		getjDialogInserirServico().getjButtonProcurarCodigo().setVisible(exibir);
		getjDialogInserirServico().getjLabelProcurarDescricao().setVisible(exibir);
		getjDialogInserirServico().getjTFieldProcurarDescricao().setVisible(exibir);
		getjDialogInserirServico().getjLabelProcurarPreco().setVisible(exibir);
		getjDialogInserirServico().getjTFieldProcurarPreco().setVisible(exibir);
		
		getjDialogInserirServico().getjTFieldDescreverDescricao().setVisible(!exibir);
		getjDialogInserirServico().getjLabelDescreverPreco().setVisible(!exibir);
		getjDialogInserirServico().getjTFieldDescreverPreco().setVisible(!exibir);
	}
	
	
	/**
	 * M�todo setBotaoClicado(botaoClicado) Set�o qual bot�o est� clicado
	 * @param btClicado
	 */
	public void setBotaoClicado(BotaoClicado botaoClicado) {
		this.botaoClicado = botaoClicado;
	}
	
	
	public BotaoClicado getbotaoClicado() {
		return this.botaoClicado;
	}
	
	//** Fim m�todos da classe **
	
}