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

import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherTabela;
import view.JDialogProcurarVeiculo;
import view.JFramePrincipal;
import view.JPanelPreOrcamentoNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarVeiculo implements MouseListener, KeyListener, WindowListener{
	
	//** In�cio declara��o de vari�veis **
	private ModuloConexao moduloConexao;
	private JFramePrincipal jFramePrincipal;
	private JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo;
	private JDialogProcurarVeiculo jDialogProcurarVeiculo;
	private DaoJDialogProcurarVeiculo daoJDialogProcurarVeiculo;
	private boolean modal;
	
	//** Fim declara��o de vari�veis **	
	public ControlJDialogProcurarVeiculo(JFramePrincipal jFramePricipal, JDialogProcurarVeiculo jDialogProcurarVeiculo,
			JPanelPreOrcamentoNovo jPanelPreOrcamentoNovo) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogProcurarVeiculo = jDialogProcurarVeiculo;
		this.jPanelPreOrcamentoNovo = jPanelPreOrcamentoNovo;
		setmodal(this.getjDialogProcurarVeiculo().ismodalTela());
		AddEvent();
		setmodal(getjDialogProcurarVeiculo().ismodalTela());
		carrosCliente();
	}


	private void AddEvent() {
		getjDialogProcurarVeiculo().addWindowListener(this);
		getjDialogProcurarVeiculo().getjButtonProcurar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarVeiculo().getjButtonCancelar().addMouseListener(this);
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
				
		// Quando o bot�o cancelar for clicado
		if(e.getSource() == getjDialogProcurarVeiculo().getjButtonCancelar()) {
			
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	//** Fim m�todos sobrescritos **
	
	//** In�cio m�todos da classe **
	
	/**
	 * M�todo carrosClientes() realiza o preenchimento
	 * da tabela da classe jdialogProcurarVeiculo com os ve�culos
	 * associados ao cliente selecionado assima.
	 */
	private void carrosCliente() {
		// Reaiza a chamada da query que realiza a busca de um ve�culo atrav�s do cliente
		getModuloConexao().executeQuery(ComandosSQL.getconsultarVeiculoTodosByCliente(), getjPanelPreOrcamentoNovo().getidCliente());
		// Verifica se a consulta retornou alguma linha do banco de dados
		if(!getModuloConexao().resultSetIsEmpty()) {
			// seta com visible(true) caso esteja (false)
			getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(true);
			// Preenche a tabela com o resultset.
			getjDialogProcurarVeiculo().getjTableVeiculos().setModel(
					new PreencherTabela().preencher(getModuloConexao().getResultSet()));
		
		// Caso n�o tenha retornado nenhuma linha pede para o cliente inserir um novo ve�culo.
		} else {
			// seta com visible(false) para n�o mostrar nehum dado de veiculos precarregados
			getjDialogProcurarVeiculo().getjTableVeiculos().setVisible(false);
			/*
			 * Quando o bot�o selecionar ve�culo da tela pre or�amento novo for clicado
			 * ser� exibida uma caixa com duas op��o
			 * - Sim // A tela Procurar veiculo continuar� aberta e ser� chamada a tela cadastrarVe�culo.
			 * - Cancelar // A tela Procurar Ve�culo ser� fechada.
			 */
			// Vetro de String com os nomes das op��es que apareceram no joptionpane.
			String[] options = {"Sim", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a op��o Sim
			 * - 1: Foi selecionada a op��o Cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					getjDialogProcurarVeiculo(), // tela pai
					"Nenhum ve�culo cadastrardo est� associado a esse cliente.\n"
					+ "Deseja associar um ve�culo ou cadastrar um novo?", // mensagem
					"Alerta", // t�tulo
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // op��o selecionada inicialmente
			
			// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
			if(option == 0) {

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
			daoJDialogProcurarVeiculo = new DaoJDialogProcurarVeiculo(getjDialogProcurarVeiculo());
		}
		return daoJDialogProcurarVeiculo;
	}
	
	
	private ModuloConexao getModuloConexao() {
		if(moduloConexao == null) {
			moduloConexao = new ModuloConexao();
		}
		return moduloConexao;
	}
	
	
	public boolean ismodal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	
	/**
	 * M�todo camposIsEmpty() verifica se todos os 
	 * campos da tela cadastrar cliente est�o vazios.
	 * @return boolean // Se todos os capos de cadastrar clientes estiverem
	 * vazios ser� retornado o valor true
	 */
	/*private boolean camposIsEmpty() {
				
		if(
			getjDialogCadastrarCliente().getjTFieldCpf().getText().replace(".", "").replace("-", "").replace(" ", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldNome().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldEmail().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldTelefone().getText().replace("(", "").replace(")", "").replace(".", "").replace(" ", "").replace("-", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldCidade().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldBairro().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldRua().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldNumeroCasa().getText().isEmpty()
		) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limpaCampos() {
		getjDialogCadastrarCliente().getjRadioButtonCnpj().setSelected(false);
		getjDialogCadastrarCliente().getjRadioButtonCpf().setSelected(true);
		getjDialogCadastrarCliente().getjTFieldCpf().setText("");
		getjDialogCadastrarCliente().getjTFieldNome().setText("");
		getjDialogCadastrarCliente().getjTFieldEmail().setText("");
		getjDialogCadastrarCliente().getjTFieldTelefone().setText("");
		getjDialogCadastrarCliente().getjTFieldCidade().setText("");
		getjDialogCadastrarCliente().getjTFieldBairro().setText("");
		getjDialogCadastrarCliente().getjTFieldRua().setText("");
		getjDialogCadastrarCliente().getjTFieldNumeroCasa().setText("");
		
	}*/
	//** Fim m�todos da classe **
	

}

