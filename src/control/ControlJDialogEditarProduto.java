/**
 * 
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import dao.DaoJDialogEditarProduto;
import view.JDialogEditarProduto;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogEditarProduto  implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogEditarProduto jDialogEditarProduto;
	private DaoJDialogEditarProduto daoJDialogCadastrarProduto;
	private ControlJPanelEstoque controlJPanelEstoque;
	private boolean modalTela;
	
	private String codigoProcurado;
	private String descricaoProcurado;
	private String marcaProcurardo;
	private String quantidadeProcurado;
	private String precoProcurado;
	
	


	//** Fim declaração de variáveis **	
	public ControlJDialogEditarProduto(JFramePrincipal jFramePricipal, JDialogEditarProduto jDialogEditarProduto, ControlJPanelEstoque controlJPanelEstoque) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogEditarProduto = jDialogEditarProduto;
		this.controlJPanelEstoque = controlJPanelEstoque;
		AddEvent();
		setmodal(getjDialogEditarProduto().ismodalTela());
	}


	private void AddEvent() {
		getjDialogEditarProduto().addWindowListener(this);
		getjDialogEditarProduto().getjButtonProcurarCodigo().addMouseListener(this);
		getjDialogEditarProduto().getjButtonEditarProduto().addMouseListener(this);
		getjDialogEditarProduto().getjButtonCancelar().addMouseListener(this);
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
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// Quando o botão procurar produto for clicado
		if(e.getSource() == getjDialogEditarProduto().getjButtonProcurarCodigo()) {
			// Se não realizar a busca retorn false
			if(!getdaoJDialogEditarProduto().getprocurarProduto()) {
				JOptionPane.showConfirmDialog(
						getjDialogEditarProduto(), // componente
						"O código digitado não foi encontrado no estoque.\n"
						+ "Verifique e tente novamente.", // texto
						"Produto não foi encontrado", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.ERROR_MESSAGE // tipo de mensagem
				);
				limpaCampos();
				getjDialogEditarProduto().getjTFieldCodigo().requestFocus();
			} else {
				atualizarVariaveis();
			}
			
		}

		
		// Quando o botão editar produto for clicado
		else if(e.getSource() == getjDialogEditarProduto().getjButtonEditarProduto()) {
			// Verificar se tem algum campo sem preencher ou não
			if(!camposIsEmpty()) {
				// Verifica se o codigo esta igual ao codigo do produto procurado ou houve alteração.
				if(getjDialogEditarProduto().getjTFieldCodigo().getText().equals(getCodigoProcurado())){
					/*
					 * Verificar se algum campo foi alterado
					 */
					if(isCamposAterados(2)) {
						// Verificar se algum dos campos alterados foi descricao e/ou marca
						if(isCamposAterados(0)) {
							// Vetor de String com os nomes das opções que apareceram no joptionpane.
							String[] options = {"Alterar", "Cancelar"}; 
							
							/*
							 * int option
							 * recebe 0 ou 1 de acordo com a mensagem selecionada
							 * - 0: Foi secionada a opção Alterar
							 * - 1: Foi selecionada a opção Cancelar
							 */
							int option = JOptionPane.showOptionDialog(
									getjDialogEditarProduto(), // tela pai
									"A alteração do nome e/ou marca de um produto só é aconselhada\n"
									+ "se for para corrigir erros na digitação. Não é aconselhado mudar\n"
									+ " o tipo de produto e/ou marca.\n"
									+ "Deseja alterar assim mesmo?", // mensagem
									"Atenção!!!", // título
									JOptionPane.DEFAULT_OPTION, 
									JOptionPane.INFORMATION_MESSAGE,
									null,
									options,
									options[1]); // opção selecionada inicialmente
							
							// alterar valores dos campos descrição e/ou marca
							if(option == 0) {
								// Alterando descricão se foi pedido para alterar
								if(!getjDialogEditarProduto().getjTFieldDescricao().getText().equals(getDescricaoProcurado())) {
									// alterar valores do campo quantidade
									if(getdaoJDialogEditarProduto().geteditarDescricao()) {
										getcontrolJPanelEstoque().atualizarTabela();
										JOptionPane.showConfirmDialog(
												getjDialogEditarProduto(), // componente
												"Descrição alterada com sucesso.", // texto
												"Descrição alterada", // titulo
												JOptionPane.DEFAULT_OPTION, // botões
												JOptionPane.PLAIN_MESSAGE // tipo de mensagem
										);
										getcontrolJPanelEstoque().atualizarTabela();
									}
								}

								// Alterando descricão
								if(!getjDialogEditarProduto().getjTFieldMarca().getText().equals(getMarcaProcurardo())) {
									// alterar valores do campo quantidade
									if(getdaoJDialogEditarProduto().geteditarMarca()) {
										JOptionPane.showConfirmDialog(
												getjDialogEditarProduto(), // componente
												"Marca alterada com sucesso.", // texto
												"Marca alterada", // titulo
												JOptionPane.DEFAULT_OPTION, // botões
												JOptionPane.PLAIN_MESSAGE // tipo de mensagem
										);
										getcontrolJPanelEstoque().atualizarTabela();
									}
								}
								atualizarVariaveis();
								getdaoJDialogEditarProduto().getprocurarProduto();
							}
							
							// Retorna o valor de descricao e marca para valor anterior
							else {
								getjDialogEditarProduto().getjTFieldCodigo().setText(getCodigoProcurado());
								getjDialogEditarProduto().getjTFieldDescricao().setText(getDescricaoProcurado());
								getjDialogEditarProduto().getjTFieldMarca().setText(getMarcaProcurardo());
							}
						}
						
						// Verifica se os campos de nova quantidade ou novo preço também foi alterado
						if(isCamposAterados(1)) {
							//Verificar se quantidade foi alterado
							if(!getjDialogEditarProduto().getjTFieldNovaQuantidade().getText().isEmpty()) {
								// Verificar se é válido o novo valor
								if(isNovaQuantidadeValida()) {
									// Vetor de String com os nomes das opções que apareceram no joptionpane.
									String[] options = {"Alterar", "Cancelar"}; 
									
									/*
									 * int option
									 * recebe 0 ou 1 de acordo com a mensagem selecionada
									 * - 0: Foi secionada a opção Alterar
									 * - 1: Foi selecionada a opção Cancelar
									 */
									int option = JOptionPane.showOptionDialog(
											getjDialogEditarProduto(), // tela pai
											"Você deseja alterar a quantidade desse produto, no estoque?\n"
											+ "Quantidade atual = " + quantidadeProcurado +
											"\nNova quantidade = " + getjDialogEditarProduto().getjTFieldNovaQuantidade().getText() + "\n", // mensagem
											"Atenção!", // título
											JOptionPane.DEFAULT_OPTION, 
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[1]); // opção selecionada inicialmente
									
									if(option == 0) {
										// alterar valores do campo quantidade
										if(getdaoJDialogEditarProduto().geteditarQuantidade()) {
											getdaoJDialogEditarProduto().getprocurarProduto();
											JOptionPane.showConfirmDialog(
													getjDialogEditarProduto(), // componente
													"Quantidade alterada com sucesso.", // texto
													"Quantidade alterada", // titulo
													JOptionPane.DEFAULT_OPTION, // botões
													JOptionPane.PLAIN_MESSAGE // tipo de mensagem
											);
											getjDialogEditarProduto().getjTFieldNovaQuantidade().setText("");
											getcontrolJPanelEstoque().atualizarTabela();
										}
									}
									
								}
								
								// Caso o nova quantidade não seja válida e não seja null
								else if(!getjDialogEditarProduto().getjLabelNovaQuantidade().getText().isEmpty()) {
									JOptionPane.showConfirmDialog(
											getjDialogEditarProduto(), // componente
											"A nova quantidade inserida não é válida.\n"
											+ "Verifique se o valor não é negativo ou igual à quantidade\n"
											+ "existente no estoque.", // texto
											"Impossível alterar quantidade", // titulo
											JOptionPane.DEFAULT_OPTION, // botões
											JOptionPane.ERROR_MESSAGE // tipo de mensagem
									);
								}
								
							}
							
							// Verificar se foi requisitada alteraçao do preço
							if(!getjDialogEditarProduto().getjTFieldNovoValor().getText().isEmpty()) {
								// Verificar se é válido o novo valor
								if(isNovoValorValido()) {
									// Vetor de String com os nomes das opções que apareceram no joptionpane.
									String[] options = {"Alterar", "Cancelar"}; 
									
									/*
									 * int option
									 * recebe 0 ou 1 de acordo com a mensagem selecionada
									 * - 0: Foi secionada a opção Alterar
									 * - 1: Foi selecionada a opção Cancelar
									 */
									int option = JOptionPane.showOptionDialog(
											getjDialogEditarProduto(), // tela pai
											"Você deseja alterar o valor desse produto, no estoque?\n"
											+ "Valor atual = R$ " + String.format("%.2f", Float.parseFloat(getPrecoProcurado()))  +
											"\nNovo valor = R$ " + String.format("%.2f", Float.parseFloat(getjDialogEditarProduto().getjTFieldNovoValor().getText())) + "\n", // mensagem
											"Atenção!", // título
											JOptionPane.DEFAULT_OPTION, 
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[1]); // opção selecionada inicialmente
									
									if(option == 0) {
										// alterar valores do campo preço
										if(getdaoJDialogEditarProduto().geteditarValor()) {
											getdaoJDialogEditarProduto().getprocurarProduto();
											JOptionPane.showConfirmDialog(
													getjDialogEditarProduto(), // componente
													"Valor do produto alterado com sucesso.", // texto
													"Valor alterado", // titulo
													JOptionPane.DEFAULT_OPTION, // botões
													JOptionPane.PLAIN_MESSAGE // tipo de mensagem
											);
											getjDialogEditarProduto().getjTFieldNovoValor().setText("");
											getcontrolJPanelEstoque().atualizarTabela();
										}
									}
									
								}
								
								// Caso o novo valor não seja válida e não seja null
								else if(!getjDialogEditarProduto().getjTFieldNovoValor().getText().isEmpty()) {
									JOptionPane.showConfirmDialog(
											getjDialogEditarProduto(), // componente
											"O novo valor inserido não é válido.\n"
											+ "Verifique se o valor não é negativo ou igual à quantidade\n"
											+ "existente no estoque.", // texto
											"Impossível alterar valor", // titulo
											JOptionPane.DEFAULT_OPTION, // botões
											JOptionPane.ERROR_MESSAGE // tipo de mensagem
									);
								}							
							}
						}
					}
						
					// Caso nenhum textField tenha sido alterado
					else {
						JOptionPane.showConfirmDialog(
								getjDialogEditarProduto(), // componente
								"Nenhum campo foi alterado. Altere a informação\n"
								+ " de algum campo antes de editar o produto.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}
				
				// Caso o cliente tenha alterado o o codigo do produto
				} else {
					JOptionPane.showConfirmDialog(
							getjDialogEditarProduto(), // componente
							"O campo codigo não pode ser alterado. Se o produto não fez parte de nenhuma\n"
							+ " ação, ex.: Venda... Orçamento... etc.. Você pode apagar o produto e reenserir \n"
							+ "com o novo código.", // texto
							"Código não pode ser alterado", // titulo
							JOptionPane.DEFAULT_OPTION, // botões
							JOptionPane.ERROR_MESSAGE // tipo de mensagem
					);
					getjDialogEditarProduto().getjTFieldCodigo().setText(getCodigoProcurado());
				}
			}
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogEditarProduto().getjButtonCancelar()) {
			getjFramePricipal().setEnabled(true);
			getjDialogEditarProduto().dispose();
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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		getcontrolJPanelEstoque().atualizarTabela();
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
	

	public JDialogEditarProduto getjDialogEditarProduto() {
		if(jDialogEditarProduto == null){
			jDialogEditarProduto = new JDialogEditarProduto(getjFramePricipal(), true);
		}
		return jDialogEditarProduto;
	}
	

	public DaoJDialogEditarProduto getdaoJDialogEditarProduto() {
		if(daoJDialogCadastrarProduto == null){
			daoJDialogCadastrarProduto = new DaoJDialogEditarProduto(getjFramePricipal(), getjDialogEditarProduto());
		}
		return daoJDialogCadastrarProduto;
	}
	

	public ControlJPanelEstoque getcontrolJPanelEstoque() {
		if(controlJPanelEstoque == null){
			controlJPanelEstoque = new ControlJPanelEstoque(getjFramePricipal(), null);
		}
		return controlJPanelEstoque;
	}
	
	
	public boolean ismodal() {
		return modalTela;
	}
	
	
	public void setmodal(boolean modalTela) {
		this.modalTela = modalTela;
	}
	
	
	public String getCodigoProcurado() {
		if(codigoProcurado == null){	
			codigoProcurado = new String();	
		}
		return codigoProcurado;
	}


	public void setCodigoProcurado(String codigoProcurado) {
		this.codigoProcurado = codigoProcurado;
	}


	public String getDescricaoProcurado() {
		if(descricaoProcurado == null){	
			descricaoProcurado = new String();	
		}
		return descricaoProcurado;
	}


	public void setDescricaoProcurado(String descricaoProcurado) {
		this.descricaoProcurado = descricaoProcurado;
	}


	public String getMarcaProcurardo() {
		if(marcaProcurardo == null){	
			marcaProcurardo = new String();	
		}
		return marcaProcurardo;
	}


	public void setMarcaProcurardo(String marcaProcurardo) {
		this.marcaProcurardo = marcaProcurardo;
	}


	public String getQuantidadeProcurado() {
		if(quantidadeProcurado == null){	
			quantidadeProcurado = new String();	
		}
		return quantidadeProcurado;
	}


	public void setQuantidadeProcurado(String quantidadeProcurado) {
		this.quantidadeProcurado = quantidadeProcurado;
	}


	public String getPrecoProcurado() {
		if(precoProcurado == null){	
			precoProcurado = new String();	
		}
		return precoProcurado;
	}


	public void setPrecoProcurado(String precoProcurado) {
		this.precoProcurado = precoProcurado;
	}
	
	
	/**
	 * Método camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente estão vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios será retornado o valor true
	 */
	private boolean camposIsEmpty() {
		boolean retorno;
		int qtdCamposVazios = 0;
		String campoVazio[] = new String[5];
		String mensagemInicio = "";
		String mensagemMeio = "";
		String mensagemFinal = "";
		
		if(getjDialogEditarProduto().getjTFieldCodigo().getText().isEmpty()) {campoVazio[0] = "código"; qtdCamposVazios++;}
		if(getjDialogEditarProduto().getjTFieldDescricao().getText().isEmpty()) {campoVazio[1] = "descrição"; qtdCamposVazios++;}
		if(getjDialogEditarProduto().getjTFieldMarca().getText().isEmpty()) {campoVazio[2] = "marca"; qtdCamposVazios++;}
		if(getjDialogEditarProduto().getjTFieldQuantidadeEstoque().getText().isEmpty()) {campoVazio[3] = "estoque"; qtdCamposVazios++;}
		if(getjDialogEditarProduto().getjTFieldPreco().getText().isEmpty()) {campoVazio[4] = "preço"; qtdCamposVazios++;}
		
		
		// Se todos os campos estiverem vazios
		if(qtdCamposVazios >= 5) {
			mensagemFinal = "Todos os campos estão vazios. Procure um produto pelo código\ne tente novamente.";
			retorno =  true;
			
		} else {
			// Se mais de um campo estiver vazio
			if(qtdCamposVazios > 1) {
				mensagemInicio = "Os campos ";
				int campoAtual = 1;
				for(String campo : campoVazio) {
					if(campo != null) {
						mensagemMeio += campo;
						if(campoAtual == (qtdCamposVazios - 1)) {
							mensagemMeio += " e ";
						} else if(campoAtual < (qtdCamposVazios - 1)){
							mensagemMeio += ", ";
						}
						campoAtual++;
					}
				}
				mensagemFinal = mensagemInicio + mensagemMeio + " estão vazios.\nProcure um produto pelo código e tente novamente.";	
				retorno =  true;
				
			}
			
			
			// Se só um campo estiver vazio
			else if(qtdCamposVazios == 1){
				mensagemInicio = "O campo ";
				for(String campo : campoVazio) {
					if(campo != null) {
						mensagemMeio = campo;
					}
				}
				mensagemFinal = mensagemInicio + mensagemMeio + " está vazio.\nProcure um produto pelo código e tente novamente.";	
				retorno =  true;
			
			// Se todos os campos estiverem preenchidos
			} else {
				retorno =  false;
			}
		}		
		
		if(retorno) JOptionPane.showConfirmDialog(
				getjDialogEditarProduto(), // componente
				mensagemFinal, // texto
				"Alerta", // titulo
				JOptionPane.DEFAULT_OPTION, // botões
				JOptionPane.ERROR_MESSAGE // tipo de mensagem
		);
		return retorno;
	}
	
	private void limpaCampos() {
		getjDialogEditarProduto().getjTFieldCodigo().setText("");
		getjDialogEditarProduto().getjTFieldDescricao().setText("");
		getjDialogEditarProduto().getjTFieldMarca().setText("");
		getjDialogEditarProduto().getjTFieldQuantidadeEstoque().setText("");
		getjDialogEditarProduto().getjTFieldPreco().setText("");
		getjDialogEditarProduto().getjTFieldCodigo().requestFocus();
	}
	
	/**
	 * Método isCamposAterados() verifica se todos os 
	 * campos editaveis da tela editar produto estão inalterados.
	 * @param input Pode ser setado como 0, 1 ou 2:
	 * 0 - Para retornar se o campo descricao ou marca foram alterados.
	 * 1 - Para retornar se o campo novaQuantidade ou preço foram alterados.
	 * 2 - Para retornar se algum campo foi alterado
	 * @return boolean Se existir algum campo alterado na tela de editar produto
	 * será retornado true, caso contrário, false.
	 */
	private boolean isCamposAterados(int input) {
		boolean retorno = false;
		// campos de ediçao
		boolean camposEditar = (!getjDialogEditarProduto().getjTFieldNovoValor().getText().isEmpty()||
				!getjDialogEditarProduto().getjTFieldNovaQuantidade().getText().isEmpty());
		// campos de dados de produto
		boolean camposDados = (!getjDialogEditarProduto().getjTFieldDescricao().getText().equals(getDescricaoProcurado()) ||
				!getjDialogEditarProduto().getjTFieldMarca().getText().equals(getMarcaProcurardo()));
		
		
		switch(input){
		// Para retornar se o campo descricao ou marca foram alterados.
		case 0:
			if(camposDados) {
				retorno = true;
			}
			break;

		// Para retornar se o campo novaQuantidade ou preço foram alterados.
		case 1:
			if(camposEditar) {
				retorno = true;
			}
			break;

		// Para retornar se algum campo foi alterado
		case 2:
			if(camposDados || camposEditar) {
				retorno = true;
			}
			break;
		}
		return retorno;
	}
	
	
	/**
	 * Método isNovaQuantidadeValida() verifica se a nova quantidade de produtos
	 * é válida.
	 * @return boolean Se a nova quantidade for válida retorna true, caso não, retorna false.
	 */
	private boolean isNovaQuantidadeValida() {	
		// a nova quantidade de produtos
		int newQtd = Integer.parseInt(getjDialogEditarProduto().getjTFieldNovaQuantidade().getText().isEmpty() ? "-1": getjDialogEditarProduto().getjTFieldNovaQuantidade().getText());
		// a quantidade de produtos anterior
		int oldQtd = Integer.parseInt(getQuantidadeProcurado());
		// Verificação se o novo código é valido
		if(newQtd >= 0 && newQtd != oldQtd) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Método isNovoValorValido() verifica se o novo valor do produto é válido
	 * @return boolean Se a nova quantidade for válida retorna true, caso não, retorna false.
	 */
	private boolean isNovoValorValido() {	
		// O novo valor do produto
		float newVal = Float.parseFloat(getjDialogEditarProduto().getjTFieldNovoValor().getText().isEmpty() ?
				"-1": getjDialogEditarProduto().getjTFieldNovoValor().getText().replace(" ", ""));
		// a quantidade de produtos anterior
		float oldVal = Integer.parseInt(getQuantidadeProcurado());
		// Verificação se o novo código é valido
		if(newVal >= 0 && newVal != oldVal) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private void atualizarVariaveis() {
		setCodigoProcurado(getjDialogEditarProduto().getjTFieldCodigo().getText());
		setDescricaoProcurado(getjDialogEditarProduto().getjTFieldDescricao().getText());
		setMarcaProcurardo(getjDialogEditarProduto().getjTFieldMarca().getText());
		setQuantidadeProcurado(getjDialogEditarProduto().getjTFieldQuantidadeEstoque().getText());
		setPrecoProcurado(getjDialogEditarProduto().getjTFieldPreco().getText());
	}
	
	
	//** Fim métodos da classe **
	
}


















