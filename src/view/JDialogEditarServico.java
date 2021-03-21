/**
 * 
 */
package view;

import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JDialogEditarServico extends JDialog{	
	
	
	//** Início declaração de variáveis **
		
	private boolean modal;
	
	
	private JButton jButtonCancelar;
	private JButton jButtonEditarServico;
	
	
	private JLabel jLabelDadosServico;
	private JLabel jLabeCodigo;
	private JLabel jLabelProcurarDescricao;
	private JLabel jLabelProcurarPreco;
	
	
	private JTextField jTFieldCodigo;
	private JTextField jTFieldProcurarDescricao;
	private JTextField jTFieldProcurarPreco;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogEditarServico(Frame frame, boolean modal) {
		super(frame, "Editar Serviço");
		this.modal = modal;
		this.addCompJDialogEditarServico();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogEditarServico  getJDialogEditarServico() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 236);
		this.setVisible(true);
		this.setModal(modal);
		this.setVisible(true);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **


	public JLabel getjLabelDadosServico() {
		if(jLabelDadosServico == null){	
			jLabelDadosServico = new JLabel("Dados do serviço");
			jLabelDadosServico.setFont(Fontes.fontJLabelBold2);
			jLabelDadosServico.setSize(170, 25);
			jLabelDadosServico.setForeground(Cores.azul1);
			jLabelDadosServico.setOpaque(false);
		}
		return jLabelDadosServico;
	}


	public JLabel getjLabelCodigo() {
		if(jLabeCodigo == null){	
			jLabeCodigo = new JLabel("Código:");
			jLabeCodigo.setFont(Fontes.fontJLabelPlain1);
			jLabeCodigo.setSize(55, 25);
			jLabeCodigo.setForeground(Cores.preto);
			jLabeCodigo.setOpaque(false);
		}
		return jLabeCodigo;
	}


	public JLabel getjLabelProcurarDescricao() {
		if(jLabelProcurarDescricao == null){	
			jLabelProcurarDescricao = new JLabel("Descrição:");
			jLabelProcurarDescricao.setFont(Fontes.fontJLabelPlain1);
			jLabelProcurarDescricao.setSize(72, 25);
			jLabelProcurarDescricao.setForeground(Cores.preto);
			jLabelProcurarDescricao.setOpaque(false);
		}
		return jLabelProcurarDescricao;
	}


	public JLabel getjLabelProcurarPreco() {
		if(jLabelProcurarPreco == null){	
			jLabelProcurarPreco = new JLabel("Preço:");
			jLabelProcurarPreco.setFont(Fontes.fontJLabelPlain1);
			jLabelProcurarPreco.setSize(43, 25);
			jLabelProcurarPreco.setForeground(Cores.preto);
			jLabelProcurarPreco.setOpaque(false);
		}
		return jLabelProcurarPreco;
	}

	
	
	//** Fim getters JLabel **
	
	//** Início getters JButton **

	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain2);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Cores.branco);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(82, 25);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCancelar;
	}


	public JButton getjButtonEditarServico() {
		if(jButtonEditarServico == null){
			jButtonEditarServico = new JButton();			
			jButtonEditarServico.setFont(Fontes.fontJButtonPlain2);
			jButtonEditarServico.setBackground(Cores.azul1);
			jButtonEditarServico.setForeground(Cores.branco);
			jButtonEditarServico.setText("Editar serviço");
			jButtonEditarServico.setSize(114, 25);
			jButtonEditarServico.setFocusable(false);
			jButtonEditarServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonEditarServico;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **

	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
			jTFieldCodigo = new JTextField();
			jTFieldCodigo.setBorder(null);
			jTFieldCodigo.setForeground(Cores.preto);
			jTFieldCodigo.setBackground(Cores.cinza4);
			jTFieldCodigo.setFont(Fontes.fontJTFieldPlain2);
			jTFieldCodigo.setSize(123, 25);
			jTFieldCodigo.setOpaque(true);	
			jTFieldCodigo.setEditable(false);
		}
		return jTFieldCodigo;
	}


	public JTextField getjTFieldProcurarDescricao() {
		if(jTFieldProcurarDescricao == null){
			jTFieldProcurarDescricao = new JTextField();
			jTFieldProcurarDescricao.setBorder(null);
			jTFieldProcurarDescricao.setBackground(Cores.cinza4);
			jTFieldProcurarDescricao.setFont(Fontes.fontJTFieldPlain2);
			jTFieldProcurarDescricao.setSize(403, 25);
			jTFieldProcurarDescricao.setOpaque(true);
			jTFieldProcurarDescricao.setEditable(false);		
		}
		return jTFieldProcurarDescricao;
	}


	public JTextField getjTFieldProcurarPreco() {
		if(jTFieldProcurarPreco == null){
			jTFieldProcurarPreco = new JTextField();
			jTFieldProcurarPreco.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldProcurarPreco.setForeground(Cores.azul1);
			jTFieldProcurarPreco.setFont(Fontes.fontJTFieldPlain2);
			jTFieldProcurarPreco.setSize(142, 25);
			jTFieldProcurarPreco.setOpaque(true);	
		}
		return jTFieldProcurarPreco;
	}	

	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogEditarServico() {
		
		getJDialogEditarServico().getContentPane().add(getjLabelDadosServico());
		getjLabelDadosServico().setLocation(36, 49);
		
		getJDialogEditarServico().getContentPane().add(getjLabelCodigo());
		getjLabelCodigo().setLocation(36, 91);
		
		getJDialogEditarServico().getContentPane().add(getjTFieldCodigo());
		getjTFieldCodigo().setLocation(96, 91);
		
		getJDialogEditarServico().getContentPane().add(getjLabelProcurarDescricao());
		getjLabelProcurarDescricao().setLocation(257, 91);
		
		getJDialogEditarServico().getContentPane().add(getjTFieldProcurarDescricao());
		getjTFieldProcurarDescricao().setLocation(334, 91);
		
		getJDialogEditarServico().getContentPane().add(getjLabelProcurarPreco());
		getjLabelProcurarPreco().setLocation(757, 91);
		
		getJDialogEditarServico().getContentPane().add(getjTFieldProcurarPreco());
		getjTFieldProcurarPreco().setLocation(805, 91);
		
		getJDialogEditarServico().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(736, 160);
		
		getJDialogEditarServico().getContentPane().add(getjButtonEditarServico());
		getjButtonEditarServico().setLocation(831, 160);
	}
	
	//** Fim métodos adição de componentes **
	

}