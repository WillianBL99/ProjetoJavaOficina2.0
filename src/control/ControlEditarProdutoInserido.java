/**
 * Classe controladora da tela para alterar produto inserido
 * A tela aterar produto inserido � uma modifica��o da tela inserir
 * produto, e classe controlEditarProdutoInserir extend da classe
 * controladora da tela adicionar produto.
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.Cores;
import view.JDialogInserirProduto;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * Realiza o controle da casse JDialogInserirProduto, no modo editar produto inserido.
 * @author Paulo Uilian
 *
 */
public class ControlEditarProdutoInserido extends ControlJDialogInserirProduto {
	
	//*** Declara��o de vari�veis e objetos ***
	private int rowSelected;

	private String oldQtdInserir;
	private String oldDescotno;
	/**
	 * Metodo ControlEditarProdutoInserido(JFramePrincipal jFramePricipal, JDialogInserirProduto jDialogInserirProduto,
	 * 		JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo, int rowSelected) Controla a tela respons�vel por editar os
	 * valores dos produtos inseridos na lista de produtos da tela de preor�amentonovo
	 * @param jFramePricipal
	 * @param jDialogInserirProduto
	 * @param jdiJPanelPreOrcamentoNovo
	 * @param rowSelected Recebe a linha selecionada da tabela de produtos de preorcamentonovo
	 */
	public ControlEditarProdutoInserido(JFramePrincipal jFramePricipal, JDialogInserirProduto jDialogInserirProduto,
			JPanelPreOrcamentoNovo jdiJPanelPreOrcamentoNovo, int rowSelected) {
		// Chama o construtor da classe JDialogInserirProduto
		super(jFramePricipal, jDialogInserirProduto, jdiJPanelPreOrcamentoNovo);
		this.rowSelected = rowSelected;
		alterarAcessibilidade();
		inicializarCampos();
		super.atualizaCamposInsercao();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o bot�o AterarProduto for clicado
		if(e.getSource() == super.getjDialogInserirProduto().getjButtonInserirPeca()) {
			super.getjDialogInserirProduto().getjButtonInserirPeca().requestFocus();
			super.atualizaCamposInsercao();
			
			// Guarda se algum campo foi alterado
			boolean valAlterado = false;
			// Guarda se o cadastro foi relizdo
			boolean cadastrado = false;
			// Verificar ser foi realizada alguma modifica��o em qtdInserir
			if(!oldQtdInserir.equals(super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText())) {
				valAlterado = true;
				// Verifica se � valido
				if(isQtdInserirValida(getQuantidadeInserir()) != 2) {
					// N�mero � v�lido
					if(isQtdInserirValida(getQuantidadeInserir()) == 0) {
						// Se for inserido com sucesso
						if(alterarProduto()) {
							// Preenche a tabela de JPanelPreOrcamento novo com os novos valores
							cadastrado = true;
						}
					}
					
					// N�mero n�o � v�lido
					else {
						cadastrado = false;
						JOptionPane.showConfirmDialog(
								super.getjDialogInserirProduto(), // componente
								"Insira um valor v�lido no campo quantidade.\n"
								+ "Valores negativos e 0 n�o s�o permitidos.", // texto
								"Valor inv�lido", // titulo
								JOptionPane.DEFAULT_OPTION, // bot�es
								JOptionPane.ERROR_MESSAGE // tipo de mensagem
						);
					}
				}
				
				// Caso n�o digitado nada
				else {
					cadastrado = false;
					JOptionPane.showConfirmDialog(
							super.getjDialogInserirProduto(), // componente
							"O campo quantidade n�o pode est� vazio.", // texto
							"Campo vazio", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
				}
			}
			
			
			// Verificar ser foi realizada alguma modifica��o em desconto
			if(!oldDescotno.equals(super.getjDialogInserirProduto().getjTFieldDesconto().getText())) {
				valAlterado = true;
				// Verifica se � valido
				if(isDescontoValido(getDescontAlterar()) != 2) {
					// N�mero � v�lido
					if(isDescontoValido(getDescontAlterar()) == 0) {
						// Se for inserido com sucesso
						if(alterarProduto()) {
							// Preenche a tabela de JPanelPreOrcamento novo com os novos valores
							cadastrado = true;
						}
					}
					
					// N�mero n�o � v�lido
					else {
						cadastrado = false;
						JOptionPane.showConfirmDialog(
								super.getjDialogInserirProduto(), // componente
								"Insira um valor v�lido no campo desconto.\n"
								+ "Valores permitidos de 0 a 99.", // texto
								"Valor inv�lido", // titulo
								JOptionPane.DEFAULT_OPTION, // bot�es
								JOptionPane.ERROR_MESSAGE // tipo de mensagem
						);
					}
				}
				
				// Caso n�o digitado nada
				else {
					cadastrado = false;
					JOptionPane.showConfirmDialog(
							super.getjDialogInserirProduto(), // componente
							"O campo desconto n�o pode est� vazio.", // texto
							"Campo vazio", // titulo
							JOptionPane.DEFAULT_OPTION, // bot�es
							JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
				}
			}
			
			// Verificar se o campo n�o est� setaddo como zero quando perder foco // 
			
			// Se nenhum campo n�o foi modificado exibe uma mensagem
			if(!valAlterado) {
				cadastrado = false;
				JOptionPane.showConfirmDialog(
						super.getjDialogInserirProduto(), // componente
						"Altere algum campo e clique em alterar produto.", // texto
						"Nenhum campo alterado", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
			
			// Se foi cadastrado com sucesso
			if(cadastrado) {
				super.getjPanelPreOrcamentoNovo().gettabelaTemporariaProdutos().preencher(
						super.getjPanelPreOrcamentoNovo().getjTableListaProdutos());
				JOptionPane.showConfirmDialog(
						super.getjDialogInserirProduto(), // componente
						"Produto alterado com sucesso.", // texto
						"Produto alterado", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.PLAIN_MESSAGE // tipo de mensagem
				);
				super.fecharTela();
			}
		}
		
		
		// Quando o bot�o cancelar for clicado
		if(e.getSource() == super.getjDialogInserirProduto().getjButtonCancelar()) {
			super.fecharTela();
		}
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// Quando o bot�o AterarProduto for clicado
	}

	
	@Override
	public void focusLost(FocusEvent e) {
		// Quando o jtextfield quantidade inserir perder o foco
		if(e.getSource() == super.getjDialogInserirProduto().getjTFieldQuantidadeInserir()) {
			if(super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText().replace(" ", "").isEmpty())
				super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().setText("0");
		
			super.atualizaCamposInsercao();
		}
		
		
		// Quando o jtextfield desconto perder o foco
		else if(e.getSource() == super.getjDialogInserirProduto().getjTFieldDesconto()) {
			if(super.getjDialogInserirProduto().getjTFieldDesconto().getText().replace(" ", "").isEmpty())
				super.getjDialogInserirProduto().getjTFieldDesconto().setText("0");
		
			super.atualizaCamposInsercao();
		}
	}
	
	
	public int getRowSelected() {
		return rowSelected;
	}
	
	
	/**
	 * Alterar a acessibilidade dos campos da tela inserirProduto para se tornar editar produto
	 */
	private void alterarAcessibilidade() {
		super.getjDialogInserirProduto().getChoicePesquisarPor().setEnabled(false);
		super.getjDialogInserirProduto().getChoicePesquisarPor().setBackground(Cores.cinza4);
		super.getjDialogInserirProduto().getjTFieldProcurar().setEnabled(false);
		super.getjDialogInserirProduto().getjTFieldProcurar().setBackground(Cores.cinza4);
		super.getjDialogInserirProduto().getjTablePecas().setEnabled(false);
		super.getjDialogInserirProduto().getjTablePecas().setBackground(Cores.cinza4);
		super.getjDialogInserirProduto().getjTablePecas().setVisible(false);
		super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().setEnabled(true);
		super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().setBackground(Cores.branco);
		super.getjDialogInserirProduto().getjTFieldDesconto().setEnabled(true);
		super.getjDialogInserirProduto().getjTFieldDesconto().setBackground(Cores.branco);
		// Aterar nome do bot�o inserir para alterar
		super.getjDialogInserirProduto().getjButtonInserirPeca().setText("Alterar produto");
	}
	
	
	/**
	 * Inicializa os campos com os valres da linha clicada para alterar
	 */
	private void inicializarCampos() {
		String[] linhaTabela = null;
		
		try {
			linhaTabela = super.getjPanelPreOrcamentoNovo().gettabelaTemporariaProdutos().
					getLinha(getRowSelected());
		} catch (IllegalArgumentException e) {
			System.out.println("A linha requisitada n�o existe na TabelaTemporaria");
		}		

		super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().setText(linhaTabela[1]);
		this.oldQtdInserir = super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText();
		super.getjDialogInserirProduto().getjTFieldDescricao().setText(linhaTabela[2]);
		super.getjDialogInserirProduto().getjTFieldPreco().setText(linhaTabela[3]);
		super.setPrecoSelec(linhaTabela[3]);
		super.getjDialogInserirProduto().getjTFieldQuantidadeEstoque().setText(linhaTabela[6]);
		super.setQuantidadeSelec(linhaTabela[6]);
		super.getjDialogInserirProduto().getjTFieldDesconto().setText(linhaTabela[7]);
		super.setDescPercent(linhaTabela[7]);
		this.oldDescotno = super.getjDialogInserirProduto().getjTFieldDesconto().getText();
	}
	
	/**
	 * Retorna o n�mero inserido na String.
	 * @param num Recebe a string a ser convertida em objeto Integer.
	 * @return Retorna o n�mero inserido na String. Caso n�o tenha nada retorna -135.
	 */
	private Integer getQuantidadeInserir() {
		String num = super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText();
		Integer numero = (num.replace(" ", "").isEmpty() ? -135 : Integer.parseInt(num.replace(" ", "")));
		
		return numero;
	}
	
	/**
	 * Retorna o n�mero inserido na String.
	 * @param num Recebe a string a ser convertida em objeto Integer.
	 * @return Retorna o n�mero inserido na String. Caso n�o tenha nada retorna -135.
	 */
	private Integer getDescontAlterar() {
		String num = super.getjDialogInserirProduto().getjTFieldDesconto().getText();
		Integer numero = (num.replace(" ", "").isEmpty() ? -135 : Integer.parseInt(num.replace(" ", "")));
		return numero;
	}
	
	/**
	 * M�todo isQtdInserirValida() Verifica se o numero convertido de uma String � v�lido.
	 * @param num Recebe uma strig contendo o n�mero a ser verificado.
	 * @return Retorna se o numero foi aceito e se n�o foi aceito identifica o motivo:
	 * 0-O n�mero � v�lido.
	 * 1-O n�mero n�o � v�lido.
	 * 2-A String inserida n�o contem n�mero.
	 */
	private int isQtdInserirValida(int numero) {
		int retorno =  0;
		
		if(numero == -135) 
			retorno = 2;
		
		else if(numero < 1)
			retorno = 1;
		
		return retorno;
	}
	

	
	/**
	 * M�todo isDescontoValido() Verifica se o numero convertido de uma String � v�lido.
	 * @param num Recebe uma strig contendo o n�mero a ser verificado.
	 * @return Retorna se o numero foi aceito e se n�o foi aceito identifica o motivo:
	 * 0-O n�mero � v�lido.
	 * 1-O n�mero n�o � v�lido.
	 * 2-A String inserida n�o contem n�mero.
	 */
	private int isDescontoValido(int numero) {
		int retorno =  0;
		
		if(numero == -135)
			retorno = 2;
		
		else if(numero < 0 || numero > 99)
			retorno = 1;
		
		return retorno;
	}
	
	private boolean alterarProduto() {
		// n�meros referente aos campos: quantideInserir, valorDesconto, total, descontPercentual
		int[] campos = {1, 4, 5, 7};
		try {
			super.getjPanelPreOrcamentoNovo().gettabelaTemporariaProdutos().alterarLinha(
					getRowSelected(), // Linha a ser alterada
					campos, // capos da tabela a serem modificados
					super.getjDialogInserirProduto().getjTFieldQuantidadeInserir().getText(), // quantidadeInserir
					super.getjDialogInserirProduto().getjTFieldValorDesconto().getText(), // valorDesconto
					super.getjDialogInserirProduto().getjTFieldValorTotal().getText(), // total
					super.getjDialogInserirProduto().getjTFieldDesconto().getText() // descontoPercentual
				);
			
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}








