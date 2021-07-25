/**
 * 
 */
package control;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Cores;
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
	
	
	public JPanelVendasProsseguir getjPanelVendasProsseguir() {
		if(jPanelVendasProsseguir == null){	
			jPanelVendasProsseguir = new JPanelVendasProsseguir();	
		}
		return jPanelVendasProsseguir;
	}


	public ControlJPanelVendasProsseguir getControlJPanelVendasProsseguir() {
		if(controlJPanelVendasProsseguir == null){	
			controlJPanelVendasProsseguir = new ControlJPanelVendasProsseguir(getjFramePricipal(),
					getjPanelVendasProsseguir(), null, null, null, null);
		}
		return controlJPanelVendasProsseguir;
	}
	
	
	private void setarVariaveis() {
		System.out.println("chamou");
		int index = super.getjDialogProcurarCliente().getjTableCliente().getSelectedRow();
		String id = super.getjDialogProcurarCliente().getjTableCliente().getValueAt(index, 0).toString();
		String nome = super.getjDialogProcurarCliente().getjTableCliente().getValueAt(index, 3).toString();
		getControlJPanelVendasProsseguir().setIdCliente(Integer.parseInt(id));
		getjPanelVendasProsseguir().getjTFieldCliente().setText(nome);
		getjPanelVendasProsseguir().getjButtonFinalizarCompra().setBackground(Cores.azul3);
	}
	
	
	@Override
	public void selecionarCliente() {
		setarVariaveis();
		super.getjFramePricipal().setEnabled(true);
		super.getjDialogProcurarCliente().dispose();
	}
	
}
