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
import dao.DaoJDialogProcurarCliente;
import dao.ModuloConexao;
import view.JDialogProcurarCliente;
import view.JFramePrincipal;

/**
 * @author Perseu
 *
 */
public class ControlJDialogProcurarCliente implements MouseListener, KeyListener, WindowListener{
	
	//** Início declaração de variáveis **
	private JFramePrincipal jFramePrincipal;
	private JDialogProcurarCliente jDialogProcurarCliente;
	private DaoJDialogProcurarCliente daoJDialogProcurarCliente;
	private boolean modal;
	
	//** Fim declaração de variáveis **	
	
	public ControlJDialogProcurarCliente(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente) {	
		this.jFramePrincipal = jFramePricipal;	
		this.jDialogProcurarCliente = jDialogProcurarCliente;
		AddEvent();
		setmodal(getjDialogProcurarCliente().ismodalTela());
	}


	private void AddEvent() {
		getjDialogProcurarCliente().addWindowListener(this);
		getjDialogProcurarCliente().getjButtonCancelar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonPesquisar().addMouseListener(this);
		getjDialogProcurarCliente().getjButtonSelecionar().addMouseListener(this);
		getjDialogProcurarCliente().getjTextFieldCampoPesquisa().addKeyListener(this);
		
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
		// quando o botão de pesquisar for clicado na tela de proucar clientes
		if(e.getSource() == getjDialogProcurarCliente().getjButtonPesquisar()) {
			// ser for a caixa de texto estiver vazia exibe uma mensagem de alerta
			if(!getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText().isEmpty()) {
				/*
				 * Cliente pode ser procurado de três formas diferentes
				 * - Nome - Realiza uma query retornando todos os clientes com o nome inserido
				 * - CPF - Executa uma query que retorna os dados do cliente com o numero do cpf inserido
				 * - CNPj - Executa uma query que retorna os dados do cliente com o numero do cnpj inserido
				 */

				switch (getjDialogProcurarCliente().getjComboBoxPesquisa().getSelectedItem().toString()) {
				
				// procurando cliente pelo nome
				case "Nome":
					getdaoJDialogProcurarCliente().getClienteNome(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
					
				// procurando cliente pelo CPF
				case "CPF":
					getdaoJDialogProcurarCliente().getClienteCpf(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
					
				// procurando cliente pelo CNPj
				case "CNPj":
					getdaoJDialogProcurarCliente().getClienteCnpj(getjDialogProcurarCliente().getjTextFieldCampoPesquisa().getText());
					break;
				}
				
			} else {
				// exibe uma mensage avisando que a caixa de texto está vasia
				JOptionPane.showMessageDialog(getjDialogProcurarCliente(),
					    "A caixa de texto esta vazia. Preencha e pesquise novamente.",
					    "Erro na consulta",
					    JOptionPane.WARNING_MESSAGE);
			}
			
		
		// Quando o botão selecionar cliente na tela procurar clientes for clicado
		} else if(e.getSource() == getjDialogProcurarCliente().getjButtonSelecionar()) {
			
			
		// Quando o botão cancelar na tela procurar clientes for clicado
		} else if(e.getSource() == getjDialogProcurarCliente().getjButtonCancelar()) {
			
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
		this.getjFramePricipal().setEnabled(!isModal());
	}


	@SuppressWarnings("deprecation")
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
		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

	public JFramePrincipal getjFramePricipal() {
		if(jFramePrincipal == null){
			jFramePrincipal = new JFramePrincipal();
		}
		return jFramePrincipal;
	}
	
	public JDialogProcurarCliente getjDialogProcurarCliente() {
		if(jDialogProcurarCliente == null){
			jDialogProcurarCliente = new JDialogProcurarCliente(getjFramePricipal(), true);
		}
		return jDialogProcurarCliente;
	}
	
	
	public DaoJDialogProcurarCliente getdaoJDialogProcurarCliente() {
		if(daoJDialogProcurarCliente == null){
			daoJDialogProcurarCliente = new DaoJDialogProcurarCliente(getjDialogProcurarCliente());
		}
		return daoJDialogProcurarCliente;
	}


	public boolean isModal() {
		return modal;
	}
	
	
	public void setmodal(boolean modal) {
		this.modal = modal;
	}		
	//** Fim métodos da classe **
	

}