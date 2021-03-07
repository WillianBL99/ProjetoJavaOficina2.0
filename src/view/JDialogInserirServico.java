/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JDialogInserirServico  extends JDialog{	
	
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private boolean modal;
	
	private boolean visibleProcurarDescrever; // define os componentes que ficam visivel quando clicado
		//"procurar serviço" ou "descrever serviço"
	
	private JButton jButtonInserirServico;
	private JButton jButtonDescreverServico;
	private JButton jButtonProcurarCodigo;
	private JButton jButtonCancelar;
	private JButton jButtonIserirServico;
	
	private JLabel jLabelDadosServico;
	private JLabel jLabeCodigo;
	private JLabel jLabelDescricao;
	private JLabel jLabelPreco;
	
	private JTextField jTFieldCodigo;
	private JTextField jTFieldDescricao;
	private JTextField jTFieldPreco;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogInserirServico(Frame frame, boolean modal) {
		super(frame, "Inserir Serviço");
		this.modal = modal;
		this.addCompJDialogInserirServico();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogInserirServico  getJDialogInserirServico() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 310);
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


	public JLabel getjLabeCodigo() {
		if(jLabeCodigo == null){	
			jLabeCodigo = new JLabel("Código:");
			jLabeCodigo.setFont(Fontes.fontJLabelPlain1);
			jLabeCodigo.setSize(55, 25);
			jLabeCodigo.setForeground(Cores.preto);
			jLabeCodigo.setOpaque(false);
			jLabeCodigo.setVisible(isVisibleProcurarDescrever());
		}
		return jLabeCodigo;
	}


	public JLabel getjLabelDescricao() {
		if(jLabelDescricao == null){	
			jLabelDescricao = new JLabel("Descrição:");
			jLabelDescricao.setFont(Fontes.fontJLabelPlain1);
			jLabelDescricao.setSize(72, 25);
			jLabelDescricao.setForeground(Cores.preto);
			jLabelDescricao.setOpaque(false);
			jLabelDescricao.setVisible(isVisibleProcurarDescrever());
		}
		return jLabelDescricao;
	}


	public JLabel getjLabelPreco() {
		if(jLabelPreco == null){	
			jLabelPreco = new JLabel("Preço:");
			jLabelPreco.setFont(Fontes.fontJLabelPlain1);
			jLabelPreco.setSize(43, 25);
			jLabelPreco.setForeground(Cores.preto);
			jLabelPreco.setOpaque(false);
			jLabelPreco.setVisible(isVisibleProcurarDescrever());
		}
		return jLabelPreco;
	}
	
	
	//** Fim getters JLabel **
	
	//** Início getters JButton **

	
	public JButton getjButtonInserirServico() {
		if(jButtonInserirServico == null){
			jButtonInserirServico = new JButton();			
			jButtonInserirServico.setFont(Fontes.fontJButtonPlain2);
			jButtonInserirServico.setBackground(Cores.azul1);
			jButtonInserirServico.setForeground(Color.white);
			jButtonInserirServico.setText("Inserir serviço");
			jButtonInserirServico.setSize(82, 25);
			jButtonInserirServico.setFocusable(false);
			jButtonInserirServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonInserirServico;
	}


	public JButton getjButtonDescreverServico() {
		if(jButtonDescreverServico == null){
			jButtonDescreverServico = new JButton();			
			jButtonDescreverServico.setFont(Fontes.fontJButtonPlain2);
			jButtonDescreverServico.setBackground(Cores.azul1);
			jButtonDescreverServico.setForeground(Color.white);
			jButtonDescreverServico.setText("Descrever serviço");
			jButtonDescreverServico.setSize(82, 25);
			jButtonDescreverServico.setFocusable(false);
			jButtonDescreverServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonDescreverServico;
	}


	public JButton getjButtonProcurarCodigo() {
		if(jButtonProcurarCodigo == null){		
			jButtonProcurarCodigo = new JButton();			
			jButtonProcurarCodigo.setBackground(Cores.azul1);
			jButtonProcurarCodigo.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonProcurarCodigo,
					Icones.getBuscar(), 16, 16);
			jButtonProcurarCodigo.setSize(30, 21);
			jButtonProcurarCodigo.setFocusable(false);
			jButtonProcurarCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonProcurarCodigo;
	}


	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain2);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(82, 25);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCancelar;
	}


	public JButton getjButtonIserirServico() {
		if(jButtonIserirServico == null){
			jButtonIserirServico = new JButton();			
			jButtonIserirServico.setFont(Fontes.fontJButtonPlain2);
			jButtonIserirServico.setBackground(Cores.azul1);
			jButtonIserirServico.setForeground(Color.white);
			jButtonIserirServico.setText("Inserir serviço");
			jButtonIserirServico.setSize(114, 25);
			jButtonIserirServico.setFocusable(false);
			jButtonIserirServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonIserirServico;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **

	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
	
			jTFieldCodigo = new ();
	
		}
		return jTFieldCodigo;
	}


	public JTextField getjTFieldDescricao() {
		if(jTFieldDescricao == null){
	
			jTFieldDescricao = new ();
	
		}
		return jTFieldDescricao;
	}


	public JTextField getjTFieldPreco() {
		if(jTFieldPreco == null){
	
			jTFieldPreco = new ();
	
		}
		return jTFieldPreco;
	}	
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogInserirServico() {
		
		getJDialogProcurarPeca().getContentPane().add(getjButtonSelecionar());
		getjButtonSelecionar().setLocation(860, 235);
	}


	public boolean isVisibleProcurarDescrever() {
		return visibleProcurarDescrever;
	}


	public void setVisibleProcurarDescrever(boolean visibleProcurarDescrever) {
		this.visibleProcurarDescrever = visibleProcurarDescrever;
	}
	
	//** Fim métodos adição de componentes **
	

}