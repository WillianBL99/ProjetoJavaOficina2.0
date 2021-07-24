/**
 * 
 */
package control;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import view.JDialogProcurarCliente;
import view.JFramePrincipal;
import view.JPanelVendasProsseguir;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJDialogProcurarCliente_Venda extends ControlJDialogProcurarCliente{
	
	private JPanelVendasProsseguir jPanelVendasProsseguir;
	private ControlJPanelVendasProsseguir controlJPanelVendasProsseguir;

	/**
	 * @param jFramePricipal
	 * @param jDialogProcurarCliente
	 */
	public ControlJDialogProcurarCliente_Venda(JFramePrincipal jFramePricipal, JDialogProcurarCliente jDialogProcurarCliente,
			JPanelVendasProsseguir jPanelVendasProsseguir, ControlJPanelVendasProsseguir controlJPanelVendasProsseguir) {
		super(jFramePricipal, jDialogProcurarCliente);
		this.jPanelVendasProsseguir = jPanelVendasProsseguir;
		this.controlJPanelVendasProsseguir = controlJPanelVendasProsseguir;
	}
	
	

	@Override
	public void mouseClicked(MouseEvent ex) {
		System.out.println("clicou");
		if(ex.getSource() == super.getjDialogProcurarCliente().getjButtonSelecionar()) {
			/*
			 *  Verifica se foi selecionado algum cliente
			 *  se getSelectedRow() retornar um numero menor que 0 
			 *  siguinifica que nenhuma linha foi selecionada
			 */
			if(super.getjDialogProcurarCliente().getjTableCliente().getSelectedRow() >= 0) {
				setarVariaveis();
				//super.getjFramePricipal().setEnabled(true);
				//super.getjDialogProcurarCliente().dispose();
			}
			// nenhuma linha foi selecionada
			else {
				JOptionPane.showConfirmDialog(
						super.getjDialogProcurarCliente(), // componente
						"Selecione um cliente primeiro.", // texto
						"Alerta", // titulo
						JOptionPane.DEFAULT_OPTION, // bot�es
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
				);
			}
		}
			
		
		// Quando o bot�o cancelar na tela procurar clientes for clicado
		else if(ex.getSource() == super.getjDialogProcurarCliente().getjButtonCancelar()) {
			/*
			 * Quando o bot�o cancelar da tela procurar cliente for clicado ele ira fechar a tela
			 * e perguntar se quer realmente que feche sem selecionar um cliente.
			 */
			// Vetro de String com os nomes das op��es que apareceram no joptionpane.
			String[] options = {"OK", "Cancelar"}; 
			
			/*
			 * int option
			 * recebe 0 ou 1 de acordo com a mensage selecionada
			 * - 0: Foi secionada a op��o ok
			 * - 1: Foi selecionada a op��o cancelar
			 */
			int option = JOptionPane.showOptionDialog(
					super.getjDialogProcurarCliente(), // tela pai
					"Nenhum cliente foi selecionado. Deseja sair?", // mensagem
					"Alerta", // t�tulo
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]); // op��o selecionada inicialmente
			
			// Se foi confirmado o cancelamento (option == 0) a tela procurar cliente ser� fechada
			if(option == 0) {
				super.getjFramePricipal().setEnabled(true);
				super.getjDialogProcurarCliente().dispose();
				
			}
		}
	}

	
	public JPanelVendasProsseguir getjPanelVendasProsseguir() {
		if(jPanelVendasProsseguir == null){	
			jPanelVendasProsseguir = new JPanelVendasProsseguir();	
		}
		return jPanelVendasProsseguir;
	}


	public ControlJPanelVendasProsseguir getControlJPanelVendasProsseguir() {
		if(controlJPanelVendasProsseguir == null){	
			controlJPanelVendasProsseguir = new ControlJPanelVendasProsseguir(getjFramePricipal(),
					getjPanelVendasProsseguir(), null, null, null);
		}
		return controlJPanelVendasProsseguir;
	}
	
	
	private void setarVariaveis() {
		System.out.println("chamou");
		int index = super.getjDialogProcurarCliente().getjTableCliente().getSelectedRow();
		String id = super.getjDialogProcurarCliente().getjTableCliente().getValueAt(index, 0).toString();
		String nome = super.getjDialogProcurarCliente().getjTableCliente().getValueAt(index, 3).toString();
		getControlJPanelVendasProsseguir().setIdCliente(Integer.parseInt(id));
		System.out.println("setou cliente vendas = " + nome);
		getjPanelVendasProsseguir().getjTFieldCliente().setText(nome);
	}
	
	
	
	
}
