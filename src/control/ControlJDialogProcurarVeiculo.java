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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ComandosSQL;
import dao.DaoJDialogProcurarVeiculo;
import dao.PreencherTabela;
import view.JDialogCadastrarVeiculo;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarVeiculo implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private DaoJDialogProcurarVeiculo daoJDialogProcurarVeiculo;
	private JDialogCadastrarVeiculo jDialogCadastrarVeiculo;
	private ControlJDialogCadastrarVeiculo controlJDialogCadastrarVeiculo;
	private boolean modal;
	private int coutWindowAtivated; // Verifica se a tela ja foi ativada antes
	
	private String idCliente; // salva o numero do id do cliente selecionado na tela jdialogprocurarcliente
	
	//** Fim declaração de variáveis **	
	public ControlJDialogProcurarVeiculo(JFramePrincipal jFramePricipal, JDialogProcurarVeiculo jDialogProcurarVeiculo,
			JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogProcurarVeiculo = jDialogProcurarVeiculo;
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
		coutWindowAtivated = 1; // seta para não entra de primeira
		
		setidCliente(getjPanelPreOrcamentoNovo().getidCliente());
		
		setmodal(this.getjDialogProcurarVeiculo().ismodalTela());
		AddEvent();
		setmodal(getjDialogProcurarVeiculo().ismodalTela());
		carrosCliente();
	}


	private void AddEvent() {
		getjDialogProcurarVeiculo().addWindowListener(this);
		getjDialogProcurarVeiculo().getjButtonProcurar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonNovoVeiculo().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonCancelar().addMouseListener(this);
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
		// Quando o botão procurar for clicado
		if(e.getSource() == getjDialogProcurarVeiculo().getjButtonProcurar()) {
			// ser for a caixa de texto estiver vazia exibe uma mensagem de alerta
			if(!getjDialogProcurarVeiculo().getjTFieldProcurar().getText().isEmpty()) {
				/*
				 *  Veículo pode ser procurado de duas formas diferentes
				 * - Placa - Executa uma query que retorna todos os veiculos com a placa inserida
				 * - Chassi - Executa uma query que retorna todos os veiculos com o chassi inserido
				 */
				switch (getjDialogProcurarVeiculo().getChoicePesquisarPor().getSelectedItem().toString()) {
				
				// procurando veículo por chassi
				case "Chassi":
					/*
					 * O método getdaoJDialogProcurarVeiculo().getveiculoChassi(chassi) retorna falso caso a consulta no banco de
					 * dados não retorne nenhuma linha
					 */
					if(!getdaoJDialogProcurarVeiculo().getveiculoChassi(getjDialogProcurarVeiculo().getjTFieldProcurar().getText())) {
						JOptionPane.showConfirmDialog(
								getjDialogProcurarVeiculo(), // componente
								"Não foi encontrado nenhum veículo com a chassi procurarda.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}
					break;
					
				// procurando veículo por placa
				case "Placa":
					/*
					 * O método getdaoJDialogProcurarVeiculo().getveiculoPlaca(placa) retorna falso caso a consulta no banco de
					 * dados não retorne nenhuma linha
					 */
					if(!getdaoJDialogProcurarVeiculo().getveiculoPlaca(getjDialogProcurarVeiculo().getjTFieldProcurar().getText())) {
						JOptionPane.showConfirmDialog(
								getjDialogProcurarVeiculo(), // componente
								"Não foi encontrado nenhum veículo com a placa procurarda.", // texto
								"Alerta", // titulo
								JOptionPane.DEFAULT_OPTION, // botões
								JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					}
					break;
				}
				
			} else {
				// exibe uma mensage avisando que a caixa de texto está vasia
				JOptionPane.showMessageDialog(getjDialogProcurarVeiculo(),
					    "A caixa de texto esta vazia. Preencha e pesquise novamente.",
					    "Erro na consulta",
					    JOptionPane.WARNING_MESSAGE);
			}
		}
		
		// Quando o botão novo veículo for clicado
		else if(e.getSource() == getjDialogProcurarVeiculo().getjButtonNovoVeiculo()) {
			/*
			 * Exibe uma mensagem de pergunta se a pessoa quer adicionar um novo veículo.
			 * Caso seja confirmada a escolha, será chamado uma novo jdialog para cadastrar
			 * um novo veiculo.
			 */
			
			// Vetor de String contendo os nomes das opções do JOptionpane abaixo.
			String options[] = {"Sim", "Cancelar"};
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogProcurarVeiculo(),
					"Você deseja adiconar um novo veículo à lista de veículos?", // texto
					"Alerta", // título
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]);
			
			/*
			 * Caso a condicional seja verdadeira, será aberta a tela de 
			 * cadastro de clientes.
			 * Caso contraio a o joptionpane será fechado.
			 */
			if (option == 0) {
				jDialogCadastrarVeiculo = null;
				controlJDialogCadastrarVeiculo = null;
				getjDialogCadastrarVeiculo();
				getcontrolJDialogCadastrarVeiculo();
			}
			
		}
		
		// Quando o botão cancelar for clicado
		else if(e.getSource() == getjDialogProcurarVeiculo().getjButtonCancelar()) {
			getjFramePricipal().setEnabled(true);
			getjDialogProcurarVeiculo().dispose();
		}
		
		// Quando o botão selecionar for clicado
		else if(e.getSource() == getjDialogProcurarVeiculo().getjButtonSelecionar()) {
			/*
			 *  Verifica se foi selecionado algum veículo
			 *  se getSelectedRow() retornar um numero menor que 0 
			 *  siguinifica que nenhuma linha foi selecionada
			 */
			if(getjDialogProcurarVeiculo().getjTableVeiculos().getSelectedRow() < 0) {
				JOptionPane.showConfirmDialog(
						getjDialogProcurarVeiculo(), // componente
						"Selecione um veículo primeiro.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);

			} else {
				int row =getjDialogProcurarVeiculo().getjTableVeiculos().getSelectedRow();
				preencherPreOrcamentoNovoVeiculo(getjDialogProcurarVeiculo().getjTableVeiculos().getValueAt(row, 0).toString());
				getjFramePricipal().setEnabled(true);
				getjDialogProcurarVeiculo().dispose();
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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjFramePricipal().setEnabled(true);
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
		System.out.println("chamando ativated");
		getdaoJDialogProcurarVeiculo().getveiculoTodos();
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **
	
	/**
	 * Método carrosClientes() realiza o preenchimento
	 * da tabela da classe jdialogProcurarVeiculo com os veículos
	 * associados ao cliente selecionado assima.
	 */
	private void carrosCliente() {
		// Reaiza a chamada da query que realiza a busca de um veículo através do cliente
		getdaoJDialogProcurarVeiculo().getModuloConexao().executeQuery(ComandosSQL.getconsultarVeiculoTodosByCliente(), this.getidCliente());
		// Verifica se a consulta retornou alguma linha do banco de dados
		if(!getdaoJDialogProcurarVeiculo().getModuloConexao().resultSetIsEmpty()) {
			// seta com visible(true) caso esteja (false)
			getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(true);
			// Preenche a tabela com o resultset.
			getjDialogProcurarVeiculo().getjTableVeiculos().setModel(
					new PreencherTabela().preencher(getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet()));
		
		// Caso não tenha retornado nenhuma linha pede para o cliente inserir um novo veículo.
		} else {
			// seta com visible(false) para não mostrar nehum dado de veiculos precarregados
			getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(false);
			/*
			 * Quando o botão selecionar veículo da tela pre orçamento novo for clicado
			 * será exibida uma caixa com duas opção
			 * - Sim // A tela Procurar veiculo continuará aberta e será chamada a tela cadastrarVeículo.
			 * - Cancelar // A tela Procurar Veículo será fechada.
			 */
			// Vetro de String com os nomes das opções que apareceram no joptionpane.
			String[] options = {"Sim", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a opção Sim
			 * - 1: Foi selecionada a opção Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogProcurarVeiculo(), // tela pai
					"Nenhum veículo cadastrardo está associado a esse cliente.\n"
					+ "Deseja associar um veículo ou cadastrar um novo?", // mensagem
					"Nenhum veículo encontrado", // título
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // opção selecionada inicialmente
			
			// Se foi selecionado a opção sim (option == 0) será aberta a tela de cadastro de veículo
			if(option == 0) {
				jDialogCadastrarVeiculo = null;
				controlJDialogCadastrarVeiculo = null;
				getjDialogCadastrarVeiculo();
				getcontrolJDialogCadastrarVeiculo();
			} else {
				getjFramePricipal().setEnabled(true);
				getjDialogProcurarVeiculo().dispose();
			}
		}
	}
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	

	public JPanelPreOrcamentoNovo getjPanelPreOrcamentoNovo() {
		if(jPanelPreOrcamentoNovo == null){
			jPanelPreOrcamentoNovo = new JPanelPreOrcamentoNovo();
		}
		return jPanelPreOrcamentoNovo;
	}
	
	
	public JDialogProcurarVeiculo getjDialogProcurarVeiculo() {
		if(jDialogProcurarVeiculo == null){
			jDialogProcurarVeiculo = new JDialogProcurarVeiculo(getjFramePricipal(), true);
		}
		return jDialogProcurarVeiculo;
	}
	
	
	public DaoJDialogProcurarVeiculo getdaoJDialogProcurarVeiculo() {
		if(daoJDialogProcurarVeiculo == null){
			daoJDialogProcurarVeiculo = new DaoJDialogProcurarVeiculo(getjDialogProcurarVeiculo(), getjPanelPreOrcamentoNovo());
		}
		return daoJDialogProcurarVeiculo;
	}
	
	
	public ControlJDialogCadastrarVeiculo getcontrolJDialogCadastrarVeiculo() {
		if(controlJDialogCadastrarVeiculo == null){
			controlJDialogCadastrarVeiculo = new ControlJDialogCadastrarVeiculo(getjFramePricipal(), getjDialogCadastrarVeiculo(), getjDialogProcurarVeiculo(),this.getidCliente());
		}
		return controlJDialogCadastrarVeiculo;
	}
	
	
	public JDialogCadastrarVeiculo getjDialogCadastrarVeiculo() {
		if(jDialogCadastrarVeiculo == null){
			jDialogCadastrarVeiculo = new JDialogCadastrarVeiculo(getjFramePricipal(), true);
		}
		return jDialogCadastrarVeiculo;
	}
	
	
	public boolean ismodal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	
	
	public String getidCliente() {
		return idCliente;
	}
	
	
	public void setidCliente(String idCliente) {
		this.idCliente = idCliente;
	}	


	public int getcountWindowAtivated() {
		return coutWindowAtivated;
	}
	
	
	public void setcouWindowAtivated(int coutWindowAtivated) {
		if(coutWindowAtivated == 0) {
			this.coutWindowAtivated = 0;
		} else {
			this.coutWindowAtivated++;
		}
	}
	
	
	// Início métodos da classe
	
	private void preencherPreOrcamentoNovoVeiculo(String id_veiculo) {
		getdaoJDialogProcurarVeiculo().getModuloConexao().executeQuery(
				ComandosSQL.getconsultarVeiculoID(), id_veiculo);

		String id = null;
		String chassi = null;
		String placa = null;
		String kmAtual = null;
		String marca = null;
		String modelo = null;
		String motor = null;
		String combustivel = null;
		String cor = null;
		String ano = null;
		
		try {
			getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().next();
			id = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(1);
			chassi = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(2);
			placa = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(3);
			System.out.println(placa);
			kmAtual = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(4);
			marca = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(5);
			modelo = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(6);
			motor = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(7);
			combustivel = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(8);
			cor = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(9);
			ano = getdaoJDialogProcurarVeiculo().getModuloConexao().getResultSet().getString(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getjPanelPreOrcamentoNovo().getjTFieldNumeroVeiculo().setText(id);
		getjPanelPreOrcamentoNovo().getjTFieldPlaca().setText(placa);
		getjPanelPreOrcamentoNovo().getjTFieldChassi().setText(chassi);
		getjPanelPreOrcamentoNovo().getjTFieldKMAtual().setText(kmAtual);
		getjPanelPreOrcamentoNovo().getjTFieldMarca().setText(marca);
		getjPanelPreOrcamentoNovo().getjTFieldModelo().setText(modelo);
		getjPanelPreOrcamentoNovo().getjTFieldMotor().setText(motor);
		getjPanelPreOrcamentoNovo().getjTFieldCombustivel().setText(combustivel);
		getjPanelPreOrcamentoNovo().getjTFieldCor().setText(cor);
		getjPanelPreOrcamentoNovo().getjTFieldAno().setText(ano);	
	}
	
	
	

}

