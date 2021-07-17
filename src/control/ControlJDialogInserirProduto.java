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
import javax.swing.JOptionPane;
import dao.DaoJDialogIserirProduto;
import model.Cores;
import view.JDialogInserirProduto;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogInserirProduto implements MouseListener, KeyListener, WindowListener, FocusListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogInserirProduto jDialogInserirProduto;
	private DaoJDialogIserirProduto daoJDialogIserirProduto;
	private JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo;
	private boolean modalTela;
		
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
	
	


	//** Fim declaração de variáveis **	
	public ControlJDialogInserirProduto(JFramePrincipal jFramePricipal, JDialogInserirProduto jDialogInserirProduto, JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo) {	
		this.descPercent = 0;
		this.jFramePrincipal = jFramePricipal;
		this.jDialogInserirProduto = jDialogInserirProduto;
		this.jdiJPanelPreOrcamentoNovo = jdiJPanelPreOrcamentoNovo;
		AddEvent();
		setmodal(getjDialogInserirProduto().ismodalTela());
	}


	private void AddEvent() {
		getjDialogInserirProduto().addWindowListener(this);
		getjDialogInserirProduto().getjTFieldProcurar().addKeyListener(this);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().addFocusListener(this);
		getjDialogInserirProduto().getjTFieldDesconto().addFocusListener(this);
		getjDialogInserirProduto().getjButtonInserirPeca().addMouseListener(this);
		getjDialogInserirProduto().getjButtonCancelar().addMouseListener(this);
		getjDialogInserirProduto().getjTablePecas().addMouseListener(this);
	}
		
		
	//** Início métodos sobrescritos **
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// Quando for digitado algo em jtxf procurar
		if(e.getSource() == getjDialogInserirProduto().getjTFieldProcurar()) {
			// Verificar se está persquisando por código ou descriçao
			switch(getjDialogInserirProduto().getChoicePesquisarPor().getSelectedItem().toString().replace(" ", "")) {
			case "Descrição":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorDescricao()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}			
				break;
				
			case "Código":
				// Verificar se foi encontrado algum produto
				if(!getdaoJDialogEditarProduto().pesquisarPorCodigo()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}				
				break;
				
			case "Marca":
				// Verificar se houve algum erro na pesquisa
				if(!getdaoJDialogEditarProduto().pesquisarPorMarca()) {
					getjDialogInserirProduto().getjTablePecas().setVisible(false);
				}
				
				// Caso não seja encontrado
				else {
					getjDialogInserirProduto().getjTablePecas().setVisible(true);
				}				
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Quando o botão inserir produto for clicado
		if(e.getSource() == getjDialogInserirProduto().getjButtonInserirPeca()) {
			//tira o foco do campo de quantidadeInserir
			getjDialogInserirProduto().getjTFieldDesconto().requestFocus();
			atualizaCamposInsercao();
			// verificar se foi setada uma quantidade maior dq zero
			if(getQtdInserir() > 0) {
				// verificar se a quantidade é válida
				if(getDescPercent() >= 0 && getDescPercent() <= 99) {
					// Verifica se o produto no foi inserido anteriormente
					if(inserirProduto(
							getCodigoSelec(),
							getQtdInserir().toString(),
							getDescricaoSelec(),
							getPrecoSelec().toString(),
							String.format("%.2f", getDesconto()),
							String.format("%.2f", getTotal())
						)
					)					
					{					
						// Vetor de String com os nomes das opções que apareceram no joptionpane.
						String[] options = {"Sim", "Não"}; 
						
						/*
						 * int option
						 * recebe 0 ou 1 de acordo com a mensagem selecionada
						 * - 0: Foi secionada a opção Sim
						 * - 1: Foi selecionada a opção Cancelar
						 */
						int option = JOptionPane.showOptionDialog(
								getjDialogInserirProduto(), // tela pai
								"Produto inserido. Deseja adicionar outro?", // mensagem
								"Produto inserido", // título
								JOptionPane.DEFAULT_OPTION, 
								JOptionPane.PLAIN_MESSAGE,
								null,
								options,
								options[1]); // opção selecionada inicialmente
						
						if(option == 0) {
							limpaCampos();				
						}
						
						// Sair da tela
						else {
							getjFramePricipal().setEnabled(true);
							getjDialogInserirProduto().dispose();
						
						}
						
					}
					
					// Se o produto já foi inserido
					else {
						JOptionPane.showConfirmDialog(
								getjDialogInserirProduto(), // componente
								"Esse produto já foi inserido anteriormente.", // texto
								"Impossível inserir", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.ERROR_MESSAGE // tipo de mensagem
							);
					}
				}				
			}
			
			// Insira a quantidade primeiro
			else {
				JOptionPane.showConfirmDialog(
						getjDialogInserirProduto(), // componente
						"Insira uma quantidade válida.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
		
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogInserirProduto().getjButtonCancelar()) {
			// Vetor de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"Sim", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensagem selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogInserirProduto(), // tela pai
					"Produto atual não foi inserido ainda, deseja sair?", // mensagem
					"Alerta", // título
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			if(option == 0) {
				getjFramePricipal().setEnabled(true);
				getjDialogInserirProduto().dispose();
			}			
		}
		
		
		// Quando algum item da tabela for selecionado
		else if(e.getSource() == getjDialogInserirProduto().getjTablePecas()) {
			// Verifica se tem algum item selecionado
			if(getjDialogInserirProduto().getjTablePecas().getSelectedRow() > -1) {
				limpaCampos();
				atualizarCamposDados();
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


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void focusLost(FocusEvent e) {
		// Quando o jtxf QuantidadeInserir perder o foco
		if(e.getSource() == getjDialogInserirProduto().getjTFieldQuantidadeInserir()) {
			// Verificar se foi digitado algum valor
			if(!getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText().isEmpty()) {
				atualizaCamposInsercao();
				// Verificar se não foi inserido um valor menor ou igual à 0 
				if(getQtdInserir() > 0) {
					atualizaCamposInsercao();
					getjDialogInserirProduto().getjTFieldDesconto().requestFocus();
				}
			}
			
			// Senão foi digitado nada
			else {
				getjDialogInserirProduto().getjTFieldQuantidadeInserir().setText("0");
				atualizaCamposInsercao();
			}
		}
		
		// Quando o jtxf Desconto perder o foco
		else if(e.getSource() == getjDialogInserirProduto().getjTFieldDesconto()) {
			if(getjDialogInserirProduto().getjTFieldDesconto().getText().isEmpty()) {
				getjDialogInserirProduto().getjTFieldDesconto().setText("0");
			} else {
				// Verificar se não foi inserido um valor entre 0 e 99
				if(getDescPercent() >= 0 && getDescPercent() <= 99) {
					atualizaCamposInsercao();
					getjDialogInserirProduto().getjButtonInserirPeca().requestFocus();
				} else {
					getjDialogInserirProduto().getjTFieldDesconto().setText("0");
					JOptionPane.showConfirmDialog(
							getjDialogInserirProduto(), // componente
							"Insira um valor de desconto válido.\n"
							+ "Valores mermitidos entre 0 a 99.", // texto
							"Valor de desconto inválido", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
				}
			}
		}
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
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	

	public JDialogInserirProduto getjDialogInserirProduto() {
		if(jDialogInserirProduto == null){
			jDialogInserirProduto = new JDialogInserirProduto(getjFramePricipal(), true);
		}
		return jDialogInserirProduto;
	}
	

	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jdiJPanelPreOrcamentoNovo == null){
			jdiJPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jdiJPanelPreOrcamentoNovo;
	}
	

	public DaoJDialogIserirProduto getdaoJDialogEditarProduto() {
		if(daoJDialogIserirProduto == null){
			daoJDialogIserirProduto = new DaoJDialogIserirProduto(getjFramePricipal(), getjDialogInserirProduto());
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

	// set código selecionado	
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

	// set descrição selecionado	
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

	// set márca selecionado	
	public void setMarcaSelec(String marcaSelec) {
		this.marcaSelec = marcaSelec;				
	}
	
	/**
	 * Metodo getQuantidadeSelec
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
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
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
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
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
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
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
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
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
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
	 * @return Retorna o inteiro do getText() de um jTextField. Caso não tenha nada no jtx retorna o valor -135
	 */
	public Float getTotal() {
		return this.total;
	}

	// set total selecionado	
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
	
	private void limpaCampos() {
		getjDialogInserirProduto().getjTFieldDescricao().setText("");
		getjDialogInserirProduto().getjTFieldPreco().setText("");
		getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText("");
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setText("");
		getjDialogInserirProduto().getjTFieldAtendidos().setText("");
		getjDialogInserirProduto().getjTFieldComprar().setText("");
		getjDialogInserirProduto().getjTFieldDesconto().setText(getDescPercent().toString());
		getjDialogInserirProduto().getjTFieldValorDesconto().setText("");
		getjDialogInserirProduto().getjTFieldValorTotal().setText("");
		
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setEnabled(false);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.cinza4);
		getjDialogInserirProduto().getjTFieldDesconto().setEnabled(false);
		getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.cinza4);
		getjDialogInserirProduto().getjTFieldProcurar().requestFocus();
	}
	
	
	/**
	 * Método inserirProduto() insere o valores de entrada em uma tabela e organiza
	 * os valores antes de inseir.
	 * @param id
	 * @param qtd
	 * @param desc
	 * @param preco
	 * @param valDesc
	 * @param total
	 * @return boolean Retorna false caso o produto já tenha sido inserido.
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
	 * Método atualizarCamposDados atualiza os campos e algumas variáveis
	 * assim que um produto é selecionado na tabela.
	 */
	private void atualizarCamposDados() {
		// Linha clicada na tabela
		setRowSelec(getjDialogInserirProduto().getjTablePecas().getSelectedRow());
		// codigo do produto selecionado
		setCodigoSelec(getjDialogInserirProduto().getjTablePecas().getValueAt(getRowSelec(), 0).toString());
		// descrição do produto selecionado
		setDescricaoSelec(getjDialogInserirProduto().getjTablePecas().getValueAt(getRowSelec(), 1).toString());
		// marca do produto selecionado
		setMarcaSelec(getjDialogInserirProduto().getjTablePecas().getValueAt(getRowSelec(), 2).toString());
		// quantidade do produto selecionado
		setQuantidadeSelec(getjDialogInserirProduto().getjTablePecas().getValueAt(getRowSelec(), 3).toString());
		// preço do produto selecionado
		setPrecoSelec(getjDialogInserirProduto().getjTablePecas().getValueAt(getRowSelec(), 4).toString());
		
		
		// Setar os campos de dados do produto
		getjDialogInserirProduto().getjTFieldPreco().setText(String.format("%.2f", getPrecoSelec()));
		getjDialogInserirProduto().getjTFieldDescricao().setText(getDescricaoSelec());
		getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText(getQuantidadeSelec().toString());
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setEnabled(true);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.branco);
		getjDialogInserirProduto().getjTFieldDesconto().setEnabled(true);
		getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.branco);
		getjDialogInserirProduto().getjTFieldQuantidadeInserir().requestFocus();
	}
	
	private void atualizaCamposInsercao() {
		// rebe o valor do desconto
		setQtdInserir(getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText());
		// Valor dos desconto em %
		setDescPercent(getjDialogInserirProduto().getjTFieldDesconto().getText());
		// Recebe valor total sem desconto
		Float totalSD = getQtdInserir() * getPrecoSelec();
		// Valor dos desconto em reais
		setDesconto((float) ((getDescPercent()/100.0) * totalSD));
		// Valor total a ser pago
		setTotal(totalSD - getDesconto());
		
		// Quantidade de produtos atendidos pelo estoque
		getjDialogInserirProduto().getjTFieldAtendidos().setText(getQuantidadeSelec() >= getQtdInserir() ? getQtdInserir().toString() : getQuantidadeSelec().toString());
		// Quantidade de produtos que precisam ser comprados para atender a demanda atual
		getjDialogInserirProduto().getjTFieldComprar().setText(getQuantidadeSelec() < getQtdInserir() ? String.format("%d", (getQtdInserir() - getQuantidadeSelec())) : "");
		// O valor do desconot em R$
		getjDialogInserirProduto().getjTFieldValorDesconto().setText(String.format("%.2f", getDesconto()));
		// O valor total da inserção
		getjDialogInserirProduto().getjTFieldValorTotal().setText(String.format("%.2f",getTotal()));
	
	}
	
	
	//** Fim métodos da classe **
	
}


















