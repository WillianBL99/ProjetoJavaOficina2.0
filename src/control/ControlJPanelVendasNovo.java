package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import dao.DaoJPanelVendasNovo;
import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;
import view.JPanelVendasProsseguir;

public class ControlJPanelVendasNovo implements MouseListener, KeyListener {

	// ** Início declaração de variáveis **
	private JFramePrincipal jFramePricipal;
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private JPanelVendasNovo jPanelVendasNovo;
	private JPanelVendas jPanelVendas;
	private JPanelPrincipal jPanelPrincipal;
	private ControlJPanelVendasProsseguir controlJPanelVendasProsseguir;
	private DaoJPanelVendasNovo daoJPanelVendasNovo;

	private Integer qtdProdutoEstoque;
	private Integer qtdProduto;
	private String descricaoProduto;
	private String marcaProduto;
	private Float precoProduto;
	private Integer codProduto;
	private Float valorTotal;

	// ** Fim declaração de variáveis **

	/**
	 * @param jFramePricipal
	 * @param jPanelVendasNovo
	 * @param jPanelVendas
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendasNovo(JFramePrincipal jFramePricipal, JPanelVendasNovo jPanelVendasNovo,
			JPanelVendas jPanelVendas, JPanelPrincipal jPanelPrincipal) {
		super();
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendasNovo = jPanelVendasNovo;
		this.jPanelVendas = jPanelVendas;
		this.jPanelPrincipal = jPanelPrincipal;
		AddEvent();
	}

	private void AddEvent() {
		getjPanelVendasNovo().getjButtonCancelar().addMouseListener(this);
		getjPanelVendasNovo().getjButtonInserir().addMouseListener(this);
		getjPanelVendasNovo().getjButtonProsseguir().addMouseListener(this);
		getjPanelVendasNovo().getjButtonRetirarProduto().addMouseListener(this);
		getjPanelVendasNovo().getjTableInserirProduto().addMouseListener(this);
		getjPanelVendasNovo().getjTableProdutosCompra().addMouseListener(this);

		getjPanelVendasNovo().getjTFieldInserirProdutoDesc().addKeyListener(this);
		getjPanelVendasNovo().getjTFieldInserirProdutoQuant().addKeyListener(this);

	}

	// ** Início métodos sobrescritos **

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
		// Quando for digitado algo em InserirProdutoDesc
		if (e.getSource() == getjPanelVendasNovo().getjTFieldInserirProdutoDesc()) {
			// Verificar se está persquisando por código ou descriçao
			switch (getjPanelVendasNovo().getchoiceBoxDesc().getSelectedItem().toString().replace(" ", "")) {
			case "Descrição":
				// Verificar se houve algum erro na pesquisa
				if (!getdaoJPanelPreOrcamentoNovo().pesquisarPorDescricao()) {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(false);
				}

				// Caso não seja encontrado
				else {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(true);
				}
				break;

			case "Código":
				// Verificar se foi encontrado algum produto
				if (!getdaoJPanelPreOrcamentoNovo().pesquisarPorCodigo()) {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(false);
				}

				// Caso não seja encontrado
				else {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(true);
				}
				break;

			case "Marca":
				// Verificar se houve algum erro na pesquisa
				if (!getdaoJPanelPreOrcamentoNovo().pesquisarPorMarca()) {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(false);
				}

				// Caso não seja encontrado
				else {
					getjPanelVendasNovo().getjTableInserirProduto().setVisible(true);
				}
				break;
			}

			getjPanelVendasNovo().getjTableInserirProduto().getColumnModel().getColumn(0).setMaxWidth(50);
			getjPanelVendasNovo().getjTableInserirProduto().getColumnModel().getColumn(2).setMaxWidth(90);
			getjPanelVendasNovo().getjTableInserirProduto().getColumnModel().getColumn(3).setMaxWidth(50);
			getjPanelVendasNovo().getjTableInserirProduto().getColumnModel().getColumn(4).setMaxWidth(70);
		}

		// Quando for digitado algo em InserirProdutoDesc
		else if (e.getSource() == getjPanelVendasNovo().getjTFieldInserirProdutoQuant()) {
			// Verificar se foi inserido uma quantidade válida
			if(getQtd() == 0) {
				atualizaVarialveis();
				getjPanelVendasNovo().getjTFieldProdutoQuantidade().setText(String.format("  %02d", getQtdProduto()).replace(".", ",")); // Quantidade
				getjPanelVendasNovo().getjTFieldProdutoVal().setText(String.format("  %.2f", getPrecoProduto()).replace(".", ",")); // Valor unitário
				getjPanelVendasNovo().getjTFieldProdutoValTot().setText(String.format("  %.2f", 
						getPrecoProduto() * getQtdProduto()).replace(".", ",")); // Valor total
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o botão cancelar for clicado
		if (e.getSource() == getjPanelVendasNovo().getjButtonCancelar()) {
			// Verificar se tem algum ítem na tabela de produtos
			if(getjPanelVendasNovo().getjTableProdutosCompra().getRowCount() > 0) {
				// Verificar se realmente deseja sair
				// Vetor de String com os nomes das opções que apareceram no joptionpane.
				String[] options = {"Sair", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a opção Sim
				 * - 1: Foi selecionada a opção Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjPanelVendasNovo(), // tela pai
						"Deseja realmente sair?\n"
						+ "Se sair todos produtos inseridos serão\n"
						+ "perdidos.", // mensagem
						"Alerta", // título
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // opção selecionada inicialmente
				
				if(option == 0) {
					getjFramePricipal().alterarJPanel(getjPanelPrincipal());
				}
			}
			// Caso não tenha inserido nenhum ítem
			else {

				getjFramePricipal().alterarJPanel(getjPanelPrincipal());
			}			
		}

		// Quando o botão inserir for clicado
		else if (e.getSource() == getjPanelVendasNovo().getjButtonInserir()) {
			// Verificar foi selecionado um cliente
			if(getjPanelVendasNovo().getjTableInserirProduto().getSelectedRow() >= 0) {
				// Verifica se inseriu uma quantidade, e se a mesma é válida
				// se for válida.
				if(getQtd() == 0) {
					atualizaVarialveis();
					// Verifica se é menor ou iqual a quantidade do produto em estoque
					if(getQtdProduto() <= getQtdProdutoEstoque()) {
						// Se for inserido
						if(inserirProduto()) {
							exibirValorTotal();
							limparCampos(false);
							getjPanelVendasNovo().getjTFieldInserirProdutoDesc().requestFocus();
						}
						// Caso ja tenha inserido antes
						else {
							JOptionPane.showConfirmDialog(
									getjPanelVendasNovo(), // componente
									"Produto não pode ser inserido pois já foi inserido.", // texto
									"Produto já inserido", // titulo
									JOptionPane.DEFAULT_OPTION, // botões
									JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
							);
							
							limparCampos(true);
							getjPanelVendasNovo().getjTFieldInserirProdutoDesc().requestFocus();
						}
					}
					// A quantidade em estoque é menor que a requisitada
					else {
						JOptionPane.showConfirmDialog(
								getjPanelVendasNovo(), // componente
								"A quantidade requisatada é maior doque a quantidade existente\n"
								+ "em estoque.", // texto
								"Alerta estoque insuficiente.", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.ERROR_MESSAGE // tipo de mensagem
						);
						getjPanelVendasNovo().getjTFieldInserirProdutoQuant().requestFocus();
					}
				}
				// se for inválido
				else if(getQtd() == 1) {
					JOptionPane.showConfirmDialog(
							getjPanelVendasNovo(), // componente
							"Insira uma quantidade válida.", // texto
							"Quantidade inválida", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasNovo().getjTFieldInserirProdutoQuant().requestFocus();
				}
				// se estiver vazio
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasNovo(), // componente
							"O campo quantidade não pode está vaizio.", // texto
							"Digite uma quantidade", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
					getjPanelVendasNovo().getjTFieldInserirProdutoQuant().requestFocus();
				}
			}
			
			// Se não selecionou algum produto
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasNovo(), // componente
						"Selecione um produtos antes de clicar em inserir.", // texto
						"Nenhum produto selecionado", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}

		}
		

		// Quando o botão prosseguir for clicado
		else if (e.getSource() == getjPanelVendasNovo().getjButtonProsseguir()) {
			// Prosseguir com a compra. Ir para formas de pagamento
			// Verificar se existe algum produto incluso
			if(getValortotal() != -1352) {
				jPanelVendasProsseguir = null;
				controlJPanelVendasProsseguir = null;
				getjFramePricipal().alterarJPanel(getjPanelVendasProsseguir());
				getcontrolJPanelVendasProsseguir();
			}
			// Caso não tenha selecionado nenhum cliente ainda
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasNovo(), // componente
						"Nenhum produto inserido.\n"
						+ "Selecione algum produto e clique em inserir\n"
						+ "antes de clicar em \"Prosseguir venda\".", // texto
						"Nenhum produto inserido", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		
		}

		// Quando o botão retirar for clicado
		else if (e.getSource() == getjPanelVendasNovo().getjButtonRetirarProduto()) {
			// Verificar se tem algum ítem na lista
			if(getjPanelVendasNovo().getjTableProdutosCompra().getRowCount() > 0) {
				// Verificar se algum ítem está selecionado
				if(getjPanelVendasNovo().getjTableProdutosCompra().getSelectedRow() >= 0) {
					int row = getjPanelVendasNovo().getjTableProdutosCompra().getSelectedRow();
					// Vetor de String com os nomes das opções que apareceram no joptionpane.
					String[] options = {"Retirar", "Cancelar"}; 
					
					/*
					 * int option
					 * recebe 0 ou 1 de acordo com a mensagem selecionada
					 * - 0: Foi secionada a opção Sim
					 * - 1: Foi selecionada a opção Cancelar
					 */
					int option = JOptionPane.showOptionDialog(
							getjPanelVendasNovo(), // tela pai
							"Deseja retirar o produto selecionado, da lista?", // mensagem
							"Alerta", // título
							JOptionPane.DEFAULT_OPTION, 
							JOptionPane.INFORMATION_MESSAGE,
							null,
							options,
							options[1]); // opção selecionada inicialmente
					
					if(option == 0) {
						getjPanelVendasNovo().gettabelaTabelaTemporaria().remove(row);
						getjPanelVendasNovo().gettabelaTabelaTemporaria().preencherTabela(
								getjPanelVendasNovo().getjTableProdutosCompra());
						getjPanelVendasNovo().getjTableProdutosCompra().clearSelection();
						limparCampos(true);
					}
				}
				// Nenhum ítem selecionado
				else {
					JOptionPane.showConfirmDialog(
							getjPanelVendasNovo(), // componente
							"Selecione um produtos antes de clicar em retirar.", // texto
							"Nenhum produto selecionado", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
					);
				}
			}
			// Nenhum produto inserido
			else {
				JOptionPane.showConfirmDialog(
						getjPanelVendasNovo(), // componente
						"Nenhum produto inserido na lista para retirar.", // texto
						"Lista vazia", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}

		// Quando for clicado em algum ítem da tabela inserir produtos
		else if (e.getSource() == getjPanelVendasNovo().getjTableInserirProduto()) {
			// Exibir o nome e a marca d produto na jlabel
			atualizaVarialveis();
			exibirProduto(false);
			getjPanelVendasNovo().getjTFieldInserirProdutoQuant().requestFocus();

		}

		// Quando for clicado em algum ítem da tabela temporária de produtos
		else if (e.getSource() == getjPanelVendasNovo().getjTableProdutosCompra()) {
			// verificar se tem alguma linha selecionada
			if(getjPanelVendasNovo().getjTableProdutosCompra().getSelectedRow() >= 0) {
				int row = getjPanelVendasNovo().getjTableProdutosCompra().getSelectedRow();
				String[] linha = getjPanelVendasNovo().gettabelaTabelaTemporaria().getLinha(row);
				// preenche os campos de "produto"
				getjPanelVendasNovo().getjLabelProdutoDescricao().setText(String.format("%s - %s", linha[2], linha[3]));
				getjPanelVendasNovo().getjTFieldProdutoQuantidade().setText(linha[1]); // Quantidade
				getjPanelVendasNovo().getjTFieldProdutoVal().setText(linha[5]); // Valor unitário
				getjPanelVendasNovo().getjTFieldProdutoValTot().setText("  " + linha[4]); // Valor total
				getjPanelVendasNovo().getjTFieldInserirProdutoDesc().requestFocus();
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

	// ** Fim métodos sobrescritos **

	// ** Início métodos da classe **

	public JFramePrincipal getjFramePricipal() {
		if (jFramePricipal == null) {
			jFramePricipal = new JFramePrincipal();
		}
		return jFramePricipal;
	}

	public JPanelVendasProsseguir getjPanelVendasProsseguir() {
		if (jPanelVendasProsseguir == null) {
			jPanelVendasProsseguir = new JPanelVendasProsseguir();
		}
		return jPanelVendasProsseguir;
	}

	public DaoJPanelVendasNovo getdaoJPanelPreOrcamentoNovo() {
		if (daoJPanelVendasNovo == null) {
			daoJPanelVendasNovo = new DaoJPanelVendasNovo(getjFramePricipal(), getjPanelVendasNovo());
		}
		return daoJPanelVendasNovo;
	}

	public JPanelVendasNovo getjPanelVendasNovo() {
		if (jPanelVendasNovo == null) {
			jPanelVendasNovo = new JPanelVendasNovo();
		}
		return jPanelVendasNovo;
	}

	public JPanelVendas getjPanelVendas() {
		if (jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}

	public JPanelPrincipal getjPanelPrincipal() {
		if (jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}

	public ControlJPanelVendasProsseguir getcontrolJPanelVendasProsseguir() {
		if (controlJPanelVendasProsseguir == null) {
			controlJPanelVendasProsseguir = new ControlJPanelVendasProsseguir(getjFramePricipal(),
					getjPanelVendasProsseguir(), getjPanelPrincipal(), getjPanelVendasNovo(), getjPanelVendas());
		}
		return controlJPanelVendasProsseguir;
	}

	/**
	 * Retorna a quantidade do produto em estoque
	 * @return
	 */
	public Integer getQtdProdutoEstoque() {
		return qtdProdutoEstoque;
	}

	public void setQtdProdutoEstoque(String qtdProdutoEstoque) {
		this.qtdProdutoEstoque = (qtdProdutoEstoque.replace(" ", "").isEmpty() ? -135 : Integer.parseInt(qtdProdutoEstoque));
	}

	/**
	 * Retorna a quantidade de produtos a ser vendida
	 * @return
	 */
	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(String qtdProduto) {
		this.qtdProduto = (qtdProduto.replace(" ", "").isEmpty() ? -135 : Integer.parseInt(qtdProduto));
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public Float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = (precoProduto.replace(" ", "").isEmpty() ? -135 : Float.parseFloat(precoProduto));
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = (codProduto.replace(" ", "").isEmpty() ? -135 : Integer.parseInt(codProduto));
	}
	
	public Float getValortotal() {
		if(valorTotal == null)
			valorTotal = -1352f;
		return valorTotal;
	}
	
	private void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	/**
	 * O método atualizaVarialveis() Atualiza as variáveis.
	 */
	private void atualizaVarialveis() {
		// Recebe a linha clicada na tabela
		int row = getjPanelVendasNovo().getjTableInserirProduto().getSelectedRow();
		String qtdEstoque = getjPanelVendasNovo().getjTableInserirProduto().getValueAt(row, 3).toString();
		String qtd = getjPanelVendasNovo().getjTFieldInserirProdutoQuant().getText();
		// Pega os valores contidos na linha da tabela
		String descricao = getjPanelVendasNovo().getjTableInserirProduto().getValueAt(row, 1).toString();
		String marca = getjPanelVendasNovo().getjTableInserirProduto().getValueAt(row, 2).toString();
		String preco = getjPanelVendasNovo().getjTableInserirProduto().getValueAt(row, 4).toString();
		String codigo = getjPanelVendasNovo().getjTableInserirProduto().getValueAt(row, 0).toString();
		
		setQtdProduto(qtd);
		setDescricaoProduto(descricao);
		setMarcaProduto(marca);
		setPrecoProduto(preco);
		setCodProduto(codigo);
		setQtdProdutoEstoque(qtdEstoque);
	}

	
	/**
	 * o método getQtd() retonar um número int de acordo com a situção do jTxfieldInserirProdutoQuantidade.
	 * 
	 * @return int pode retornar três números
	 * <p> 0 - Se o número digitado for válido.
	 * <p> 1 - Se o número não for válido.
	 * <p> 2 - Se o jTextField estiver vazio.
	 */
	private int getQtd() {
		String value = getjPanelVendasNovo().getjTFieldInserirProdutoQuant().getText().replace(" ", "");
		int qtd = (value.isEmpty() ? -135 : Integer.parseInt(value));
		if(qtd != -135) {
			if(qtd > 0)	qtd = 0;
			else qtd = 1;
		}
		else
			qtd = 2;
		
		return qtd;
	}

	/**
	 * O método inserirProduto() Insere um produto na tabela temporária de produtos.
	 * Assim como realiza as modificações necessárias da interface.
	 * @return Retorna falso caso o produto não tenha sido inserido com sucesso.
	 */
	private boolean inserirProduto() {
		boolean retorno;
		// Insere os dados na tabela de produtos temporaria
		retorno = getjPanelVendasNovo().gettabelaTabelaTemporaria().inserirLinhaIndexAI(
				getjPanelVendasNovo().getjTableProdutosCompra(),
				5,
				String.format("  %02d", getQtdProduto()).replace(".", ","), // qtd
				String.format(" %s", getDescricaoProduto()).replace(".", ","), // descrição
				String.format(" %s", getMarcaProduto()).replace(".", ","), // marca
				String.format("%15.2f", getPrecoProduto() * getQtdProduto()).replace(".", ","), // total
				String.format("  %.2f", getPrecoProduto()).replace(".", ","), // preço				
				String.format("%02d", getCodProduto()).replace(".", ",") // cod
				
				);
		
		// Verifica se foi o produto foi inserido
		if(retorno) {
			exibirProduto(true);
			getjPanelVendasNovo().gettabelaTabelaTemporaria().preencherTabela(
					getjPanelVendasNovo().getjTableProdutosCompra());
		}
		
		return retorno;		
	}
	
	
	/**
	 * Método () Exibe as informações do produto clicado na área de 'produto'.
	 * @param total recebe true para exibir todas as informações e falso para
	 * exibir só a descrição.
	 */
	private void exibirProduto(boolean total) {
		// Jogar as informações da inseerção para a área 'Produto'.
		getjPanelVendasNovo().getjLabelProdutoDescricao().setText(String.format("%s - %s", getDescricaoProduto(),
				getMarcaProduto())); // Descrição
		if(total) {
			getjPanelVendasNovo().getjTFieldProdutoQuantidade().setText(String.format("  %02d", getQtdProduto()).replace(".", ",")); // Quantidade
			getjPanelVendasNovo().getjTFieldProdutoVal().setText(String.format("  %.2f", getPrecoProduto()).replace(".", ",")); // Valor unitário
			getjPanelVendasNovo().getjTFieldProdutoValTot().setText(String.format("  %.2f", 
					getPrecoProduto() * getQtdProduto()).replace(".", ",")); // Valor total
		}
		// Limpar campos não preenchidos
		else {
			getjPanelVendasNovo().getjTFieldProdutoQuantidade().setText(""); // Quantidade
			getjPanelVendasNovo().getjTFieldProdutoVal().setText(""); // Valor unitário
			getjPanelVendasNovo().getjTFieldProdutoValTot().setText(""); // Valor total
		}
	}
	
	
	private void limparCampos(boolean total) {
		getjPanelVendasNovo().getjTFieldInserirProdutoDesc().setText("");
		getjPanelVendasNovo().getjTFieldInserirProdutoQuant().setText("");
		getjPanelVendasNovo().getjTableInserirProduto().clearSelection();
		
		if(total) {
			getjPanelVendasNovo().getjLabelProdutoDescricao().setText("");
			getjPanelVendasNovo().getjTFieldProdutoQuantidade().setText("");
			getjPanelVendasNovo().getjTFieldProdutoVal().setText("");
			getjPanelVendasNovo().getjTFieldProdutoValTot().setText("");
		}
	}
	
	
	private void exibirValorTotal() {
		setValorTotal(getTotalTabela());
		getjPanelVendasNovo().getjTableProdutosCompra().getColumnModel().getColumn(0).setMaxWidth(35);
		getjPanelVendasNovo().getjTableProdutosCompra().getColumnModel().getColumn(1).setMaxWidth(35);
		getjPanelVendasNovo().getjTableProdutosCompra().getColumnModel().getColumn(3).setMaxWidth(90);
		getjPanelVendasNovo().getjTableProdutosCompra().getColumnModel().getColumn(4).setMaxWidth(70);
		getjPanelVendasNovo().getjTableProdutosCompra().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getjPanelVendasNovo().getJTFieldTotal().setText(
				String.format("  R$%18.2f", getValortotal()).replace(".", ","));
	}
	
	
	private Float getTotalTabela() {
		Float total = 0f;
		// recebe o campo em que se encontra o valor total
		int index = getjPanelVendasNovo().getjTableProdutosCompra().getColumnCount() - 1;
		
		for(int i = 0; i < getjPanelVendasNovo().getjTableProdutosCompra().getRowCount(); i++) {
			total += Float.parseFloat(getjPanelVendasNovo().getjTableProdutosCompra().getValueAt(i, index).toString().replace(" ", "").replace(",", "."));
		}			
		return total;
	}

	// ** Fim métodos da classe **
}









