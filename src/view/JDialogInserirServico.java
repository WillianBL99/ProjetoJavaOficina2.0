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
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JDialogInserirServico extends JDialog{	
	
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private boolean modalTela;
	
	private JButton jButtonProcurarServico;
	private JButton jButtonDescreverServico;
	private JButton jButtonProcurarCodigo;
	private JButton jButtonCancelar;
	private JButton jButtonInserirServico;
	
	
	private JLabel jLabelDadosServico;
	private JLabel jLabeCodigo;
	private JLabel jLabelProcurarDescricao;
	private JLabel jLabelProcurarPreco;
	private JLabel jLabelDescreverPreco;
	
	
	private JTextField jTFieldCodigo;
	private JTextField jTFieldProcurarDescricao;
	private JTextField jTFieldProcurarPreco;
	
	private JTextField jTFieldDescreverDescricao;
	private JTextField jTFieldDescreverPreco;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogInserirServico(Frame frame, boolean modal) {
		super(frame, "Inserir Serviço");
		this.addCompJDialogInserirServico();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogInserirServico  getJDialogInserirServico() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 236);
		this.setVisible(true);
		setmodalTela(modalTela);
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
			jLabeCodigo.setVisible(false);
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
			jLabelProcurarDescricao.setVisible(false);
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
			jLabelProcurarPreco.setVisible(false);
		}
		return jLabelProcurarPreco;
	}


	public JLabel getjLabelDescreverPreco() {
		if(jLabelDescreverPreco == null){	
			jLabelDescreverPreco = new JLabel("Preço:");
			jLabelDescreverPreco.setFont(Fontes.fontJLabelPlain1);
			jLabelDescreverPreco.setSize(43, 25);
			jLabelDescreverPreco.setForeground(Cores.preto);
			jLabelDescreverPreco.setOpaque(false);
			jLabelDescreverPreco.setVisible(false);
		}
		return jLabelDescreverPreco;
	}
	
	
	//** Fim getters JLabel **
	
	//** Início getters JButton **

	
	public JButton getjButtonProcurarServico() {
		if(jButtonProcurarServico == null){
			jButtonProcurarServico = new JButton();			
			jButtonProcurarServico.setFont(Fontes.fontJButtonPlain2);
			jButtonProcurarServico.setBackground(Cores.azul1);
			jButtonProcurarServico.setForeground(Cores.branco);
			jButtonProcurarServico.setText("Inserir serviço");
			jButtonProcurarServico.setSize(125, 25);
			jButtonProcurarServico.setFocusable(false);
			jButtonProcurarServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonProcurarServico;
	}


	public JButton getjButtonDescreverServico() {
		if(jButtonDescreverServico == null){
			jButtonDescreverServico = new JButton();			
			jButtonDescreverServico.setFont(Fontes.fontJButtonPlain2);
			jButtonDescreverServico.setBackground(Cores.cinza2);
			jButtonDescreverServico.setForeground(Cores.preto);
			jButtonDescreverServico.setText("Descrever serviço");
			jButtonDescreverServico.setSize(140, 25);
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
			jButtonProcurarCodigo.setForeground(Cores.branco);
			setSizeIcon.setIconJButton(jButtonProcurarCodigo,
					Icones.getBuscar(), 16, 16);
			jButtonProcurarCodigo.setSize(30, 25);
			jButtonProcurarCodigo.setFocusable(false);
			jButtonProcurarCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
			jButtonProcurarCodigo.setVisible(false);	
		}
		return jButtonProcurarCodigo;
	}


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


	public JButton getjButtonInserirServico() {
		if(jButtonInserirServico == null){
			jButtonInserirServico = new JButton();			
			jButtonInserirServico.setFont(Fontes.fontJButtonPlain2);
			jButtonInserirServico.setBackground(Cores.azul1);
			jButtonInserirServico.setForeground(Cores.branco);
			jButtonInserirServico.setText("Inserir serviço");
			jButtonInserirServico.setSize(114, 25);
			jButtonInserirServico.setFocusable(false);
			jButtonInserirServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonInserirServico;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **

	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
			jTFieldCodigo = new JTextField();
			jTFieldCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCodigo.setForeground(Cores.preto);
			jTFieldCodigo.setFont(Fontes.fontJTFieldPlain2);
			jTFieldCodigo.setSize(123, 25);
			jTFieldCodigo.setOpaque(true);	
			jTFieldCodigo.setVisible(false);		
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
			jTFieldProcurarDescricao.setVisible(false);		
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
			jTFieldProcurarPreco.setVisible(false);		
		}
		return jTFieldProcurarPreco;
	}	


	public JTextField getjTFieldDescreverDescricao() {
		if(jTFieldDescreverDescricao == null){
			jTFieldDescreverDescricao = new JTextField();
			jTFieldDescreverDescricao.setBorder(null);
			jTFieldDescreverDescricao.setBackground(Cores.cinza4);
			jTFieldDescreverDescricao.setFont(Fontes.fontJTFieldPlain2);
			jTFieldDescreverDescricao.setSize(623, 25);
			jTFieldDescreverDescricao.setOpaque(true);	
			jTFieldDescreverDescricao.setVisible(false);		
		}
		return jTFieldDescreverDescricao;
	}

	public JTextField getjTFieldDescreverPreco() {
		if(jTFieldDescreverPreco == null){
			jTFieldDescreverPreco = new JTextField();
			jTFieldDescreverPreco.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDescreverPreco.setForeground(Cores.azul1);
			jTFieldDescreverPreco.setFont(Fontes.fontJTFieldPlain2);
			jTFieldDescreverPreco.setSize(142, 25);
			jTFieldDescreverPreco.setOpaque(true);	
			jTFieldDescreverPreco.setVisible(false);		
		}
		return jTFieldDescreverPreco;
	}
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogInserirServico() {
		
		getJDialogInserirServico().getContentPane().add(getjButtonProcurarServico());
		getjButtonProcurarServico().setLocation(36, 21);
		
		getJDialogInserirServico().getContentPane().add(getjButtonDescreverServico());
		getjButtonDescreverServico().setLocation(171, 21);
		
		getJDialogInserirServico().getContentPane().add(getjLabelDadosServico());
		getjLabelDadosServico().setLocation(36, 49);
		
		// inicio parte visivel quando jbuttonProcurarServico estiver clicado
		getJDialogInserirServico().getContentPane().add(getjLabelCodigo());
		getjLabelCodigo().setLocation(36, 91);
		
		getJDialogInserirServico().getContentPane().add(getjTFieldCodigo());
		getjTFieldCodigo().setLocation(96, 91);
		
		getJDialogInserirServico().getContentPane().add(getjButtonProcurarCodigo());
		getjButtonProcurarCodigo().setLocation(219, 91);
		
		getJDialogInserirServico().getContentPane().add(getjLabelProcurarDescricao());
		getjLabelProcurarDescricao().setLocation(257, 91);
		
		getJDialogInserirServico().getContentPane().add(getjTFieldProcurarDescricao());
		getjTFieldProcurarDescricao().setLocation(334, 91);
		
		getJDialogInserirServico().getContentPane().add(getjLabelProcurarPreco());
		getjLabelProcurarPreco().setLocation(757, 91);
		
		getJDialogInserirServico().getContentPane().add(getjTFieldProcurarPreco());
		getjTFieldProcurarPreco().setLocation(805, 91);
		
		getJDialogInserirServico().getContentPane().add(getjTFieldDescreverDescricao());
		getjTFieldDescreverDescricao().setLocation(113, 91);
		
		getJDialogInserirServico().getContentPane().add(getjLabelDescreverPreco());
		getjLabelDescreverPreco().setLocation(757, 91);
		
		getJDialogInserirServico().getContentPane().add(getjTFieldDescreverPreco());
		getjTFieldDescreverPreco().setLocation(805, 91);
		
		// fim parte visivel quando jbuttonDescreverServico estiver clicado	

		
		getJDialogInserirServico().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(736, 160);
		
		getJDialogInserirServico().getContentPane().add(getjButtonInserirServico());
		getjButtonInserirServico().setLocation(831, 160);
	}
	
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}
		
	//** Fim métodos adição de componentes **
	

}