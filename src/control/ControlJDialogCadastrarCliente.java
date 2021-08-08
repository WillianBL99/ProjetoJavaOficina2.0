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

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import dao.DaoJDialogCadastrarCliente;
import model.Cores;
import model.Mascara;
import model.Validar;
import view.JDialogCadastrarCliente;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogCadastrarCliente implements MouseListener, KeyListener, WindowListener, FocusListener{
	
	//** In�cio declara��o de vari�veis **
	private enum TipoPessoa {fisica, juridica};
	
	private TipoPessoa tipoPessoa;
	
	private JFramePrincipal jFramePrincipal;
	private DaoJDialogCadastrarCliente daoJDialogCadastrarCliente;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private JDialogCadastrarCliente jDialogCadastrarCliente;	
	private boolean modal;
	
	//** Fim declara��o de vari�veis **	
	public ControlJDialogCadastrarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente, JDialogCadastrarCliente jDialogCadastrarCliente) {	
		this.jFramePrincipal = jFramePricipal;
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		this.jDialogCadastrarCliente = jDialogCadastrarCliente;
		setmodal(this.jDialogProcurarCliente.ismodalTela());
		// define o tipo de pessoa ao inicializar a tela
		setTipoPessoa(TipoPessoa.fisica);
		AddEvent();
	}


	private void AddEvent() {
		getjDialogCadastrarCliente().addWindowListener(this);
		getjDialogCadastrarCliente().getjButtonCadastrarCliente().addMouseListener(this);
		getjDialogCadastrarCliente().getjButtonCancelar().addMouseListener(this);
		getjDialogCadastrarCliente().getjRadioButtonCnpj().addMouseListener(this);
		getjDialogCadastrarCliente().getjRadioButtonCpf().addMouseListener(this);
		
		getjDialogCadastrarCliente().getjTFieldCpf().addFocusListener(this);
		getjDialogCadastrarCliente().getjTFieldTelefone().addFocusListener(this);
		
		getjDialogCadastrarCliente().getjTFieldCpf().addKeyListener(this);	
		getjDialogCadastrarCliente().getjTFieldTelefone().addKeyListener(this);	
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
		// Quando for digitado algo em cpf/cnpj
		if(e.getSource() == getjDialogCadastrarCliente().getjTFieldCpf()) {
			// Verificar o tipo de pessoa
			switch(getTipoPessoa()) {
			// Caso seja pessoa f�sica a mascara ser� de cpf
			case fisica:
				Mascara.mascaraCPF(getjDialogCadastrarCliente().getjTFieldCpf());
				break;
				
			// Caso seja jur�dica a mascara ser� de cnpj
			case juridica:
				Mascara.mascaraCNPj(getjDialogCadastrarCliente().getjTFieldCpf());
				break;
			}
		}	
		
		// Quando for digitado algo em telefone
		else if(e.getSource() == getjDialogCadastrarCliente().getjTFieldTelefone()) {
			Mascara.mascaraTelefone(getjDialogCadastrarCliente().getjTFieldTelefone());
		}	
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o bot�o cadastrar cliente for clicado
		if(e.getSource() == getjDialogCadastrarCliente().getjButtonCadastrarCliente()) {
		
			// Se o cadastro for bem sucedido o m�todo cadastrarCliente() retorna o valor 1
			if(getdaoCadastrarCliente().cadastrarCliente()) {
				// Exibe uma mensagem de confirma��o do cadastro.
				JOptionPane.showConfirmDialog(
						getjDialogProcurarCliente(), // componente
						"Cadastro realizado com sucesso!.", // texto
						"Cadastro realizado.", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
				// limpa os campos da tela de cadastro de clientes.
				limpaCampos();
				getjDialogProcurarCliente().setEnabled(true);;
				getjDialogCadastrarCliente().dispose();
			}
		}
		
		// Quando o bot�o cancelar for clicado
		else if(e.getSource() == getjDialogCadastrarCliente().getjButtonCancelar()) {
			// se todos os campos estiverem vazios a tela ser� fechada sem exibir alerta
			if(camposIsEmpty()) {	
				getjDialogProcurarCliente().setEnabled(true);
				getjDialogCadastrarCliente().dispose();
			} 
			
			// se algum campo ter algum caracter ser� exibida uma menssagem de alerta
			else {

				/*
				 * Quando o bot�o cancelar da tela cadastrar cliente for clicado ele ir� 
				 * exibir uma caixa de dialogo perguntando se realmente deseja sair
				 */
				// Vetor de String com os nomes das op��es que apareceram no joptionpane.
				String[] options = {"Sim", "Cancelar"}; 
				
				/*
				 * int option
				 * recebe 0 ou 1 de acordo com a mensagem selecionada
				 * - 0: Foi secionada a op��o Sim
				 * - 1: Foi selecionada a op��o Cancelar
				 */
				int option = JOptionPane.showOptionDialog(
						getjDialogProcurarCliente(), // tela pai
						"Todas as informa�oes digitadas ser�o perdidas.Tem certesa que deseja sair sem cadastrar o cliente?", // mensagem
						"Alerta", // t�tulo
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]); // op��o selecionada inicialmente
				
				// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
				if(option == 0) {
					getjDialogProcurarCliente().setEnabled(true);
					getjDialogCadastrarCliente().dispose();
					
				}
			}
		}
		
		
		// Quando for clicado no radio button cpf
		else if(e.getSource() == getjDialogCadastrarCliente().getjRadioButtonCpf()) {
			setTipoPessoa(TipoPessoa.fisica);
		}
		
		
		// Quando for clicado no radio button cnpj
		else if(e.getSource() == getjDialogCadastrarCliente().getjRadioButtonCnpj()) {
			setTipoPessoa(TipoPessoa.juridica);
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
		this.getjDialogProcurarCliente().setEnabled(!ismodal());
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.getjDialogProcurarCliente().setEnabled(true);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub			
	}


	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == getjDialogCadastrarCliente().getjTFieldCpf()) {		
			if(validarCNPJ()) {
				getjDialogCadastrarCliente().getjTFieldCpf().setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1, false));
			}
			else {
				getjDialogCadastrarCliente().getjTFieldCpf().setBorder(BorderFactory.
						createLineBorder(Cores.vermelho, 1, false));				
			}
		}
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
	 * O m�todo getTipoPessoa() Retorna se foi selecionado pessoa f�sica ou jur�dica
	 * @return TipoPessoa
	 */
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		if(this.tipoPessoa != tipoPessoa) {
			this.tipoPessoa = tipoPessoa;
			// se for selecionada m�scara pessoa jur�dica
			if(tipoPessoa == TipoPessoa.juridica) {
				getjDialogCadastrarCliente().getjRadioButtonCnpj().setSelected(true);
				getjDialogCadastrarCliente().getjRadioButtonCpf().setSelected(false);
				Mascara.mascaraCNPj(getjDialogCadastrarCliente().getjTFieldCpf());
			}
			// se for selecionada pessoa f�sica
			else {
				getjDialogCadastrarCliente().getjRadioButtonCnpj().setSelected(false);
				getjDialogCadastrarCliente().getjRadioButtonCpf().setSelected(true);
				Mascara.mascaraCPF(getjDialogCadastrarCliente().getjTFieldCpf());
				
			}
		}
	}
	

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	
	public JDialogCadastrarCliente getjDialogCadastrarCliente() {
		if(jDialogCadastrarCliente == null){
			jDialogCadastrarCliente = new JDialogCadastrarCliente(getjFramePricipal(), true);
		}
		return jDialogCadastrarCliente;
	}
	
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}
	
	
	public DaoJDialogCadastrarCliente getdaoCadastrarCliente() {
		if(daoJDialogCadastrarCliente == null){
			daoJDialogCadastrarCliente = new DaoJDialogCadastrarCliente(getjFramePricipal(), getjDialogCadastrarCliente());
		}
		return daoJDialogCadastrarCliente;
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
	private boolean camposIsEmpty() {
				
		if(
			getjDialogCadastrarCliente().getjTFieldCpf().getText().replace("(\\.|\\-|\\s)", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldNome().getText().isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldTelefone().getText().replace("(\\(|\\)|\\.|\\-|\\s)", "").isEmpty() &&
			getjDialogCadastrarCliente().getjTFieldEmail().getText().isEmpty() &&
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
		getjDialogCadastrarCliente().getjTFieldCpf().setText("");
		getjDialogCadastrarCliente().getjTFieldNome().setText("");
		getjDialogCadastrarCliente().getjTFieldTelefone().setText("");
		getjDialogCadastrarCliente().getjTFieldEmail().setText("");
		getjDialogCadastrarCliente().getjTFieldCidade().setText("");
		getjDialogCadastrarCliente().getjTFieldBairro().setText("");
		getjDialogCadastrarCliente().getjTFieldRua().setText("");
		getjDialogCadastrarCliente().getjTFieldNumeroCasa().setText("");
	}
	//** Fim m�todos da classe **


	/**
	 * O m�todo validarCNPJ(), verifica se o cnpj est� preenchido corretamente
	 * @return boolean
	 */
	private boolean validarCNPJ() {
		String cnpj = getjDialogCadastrarCliente().getjTFieldCpf().getText().replaceAll("\\D", "");
		// se n�o estiver vazio
		if(!cnpj.isEmpty())
			return Validar.cnpjValido(cnpj);
		return false;
	}

	

}