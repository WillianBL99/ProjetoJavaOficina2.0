/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
public class JDialogCadastrarCliente   extends JDialog{	
	
	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	
	private boolean modal;
	
	
	private JRadioButton jRadioButtonCpf;
	private JRadioButton jRadioButtonCnpj;
	
	private JButton jButtonCancelar;
	private JButton jButtonCadastrarCliente;
	
	
	private JLabel jLabelCpf;
	private JLabel jLabelNome;
	private JLabel jLabelTelefone;
	private JLabel jLabelEmail;
	private JLabel jLabelCidade;
	private JLabel jLabelBairro;
	private JLabel jLabelRua;
	private JLabel jLabelNumeroCasa;
	private JLabel jLabelTipoPessoa;
	
	
	private JTextField jTFieldCpf;
	private JTextField jTFieldNome;
	private JTextField jTFieldTelefone;
	private JTextField jTFieldEmail;
	private JTextField jTFieldCidade;
	private JTextField jTFieldBairro;
	private JTextField jTFieldRua;
	private JTextField jTFieldNumeroCasa;
	
	
	private Choice choiceTipoPessoa;
	
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogCadastrarCliente(Frame frame, boolean modal) {
		super(frame, "Inserir Serviço");
		this.modal = modal;
		this.addCompJDialogCadastrarCliente();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogCadastrarCliente  getJDialogCadastrarCliente() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 360);
		this.setVisible(true);
		this.setModal(modal);
		this.setVisible(true);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	public JLabel getjLabelCpf() {
		if(jLabelCpf == null){			
			jLabelCpf = new JLabel("CPF:");
			jLabelCpf.setFont(Fontes.fontJLabelPlain1);
			jLabelCpf.setSize(30, 25);
			jLabelCpf.setBackground(Cores.branco);
			jLabelCpf.setForeground(Cores.azul1);
			jLabelCpf.setOpaque(false);
		}
		return jLabelCpf;
	}


	public JLabel getjLabelNome() {
		if(jLabelNome == null){			
			jLabelNome = new JLabel("CPF:");
			jLabelNome.setFont(Fontes.fontJLabelPlain1);
			jLabelNome.setSize(47, 25);
			jLabelNome.setBackground(Cores.branco);
			jLabelNome.setForeground(Cores.azul1);
			jLabelNome.setOpaque(false);
		}
		return jLabelNome;
	}


	public JLabel getjLabelTelefone() {
		if(jLabelTelefone == null){			
			jLabelTelefone = new JLabel("CPF:");
			jLabelTelefone.setFont(Fontes.fontJLabelPlain1);
			jLabelTelefone.setSize(63, 25);
			jLabelTelefone.setBackground(Cores.branco);
			jLabelTelefone.setForeground(Cores.azul1);
			jLabelTelefone.setOpaque(false);
		}
		return jLabelTelefone;
	}


	public JLabel getjLabelEmail() {
		if(jLabelEmail == null){			
			jLabelEmail = new JLabel("CPF:");
			jLabelEmail.setFont(Fontes.fontJLabelPlain1);
			jLabelEmail.setSize(41, 25);
			jLabelEmail.setBackground(Cores.branco);
			jLabelEmail.setForeground(Cores.azul1);
			jLabelEmail.setOpaque(false);
		}
		return jLabelEmail;
	}


	public JLabel getjLabelCidade() {
		if(jLabelCidade == null){			
			jLabelCidade = new JLabel("CPF:");
			jLabelCidade.setFont(Fontes.fontJLabelPlain1);
			jLabelCidade.setSize(53, 25);
			jLabelCidade.setBackground(Cores.branco);
			jLabelCidade.setForeground(Cores.azul1);
			jLabelCidade.setOpaque(false);
		}
		return jLabelCidade;
	}


	public JLabel getjLabelBairro() {
		if(jLabelBairro == null){			
			jLabelBairro = new JLabel("CPF:");
			jLabelBairro.setFont(Fontes.fontJLabelPlain1);
			jLabelBairro.setSize(45, 25);
			jLabelBairro.setBackground(Cores.branco);
			jLabelBairro.setForeground(Cores.azul1);
			jLabelBairro.setOpaque(false);
		}
		return jLabelBairro;
	}


	public JLabel getjLabelRua() {
		if(jLabelRua == null){			
			jLabelRua = new JLabel("CPF:");
			jLabelRua.setFont(Fontes.fontJLabelPlain1);
			jLabelRua.setSize(30, 25);
			jLabelRua.setBackground(Cores.branco);
			jLabelRua.setForeground(Cores.azul1);
			jLabelRua.setOpaque(false);
		}
		return jLabelRua;
	}


	public JLabel getjLabelNumeroCasa() {
		if(jLabelNumeroCasa == null){			
			jLabelNumeroCasa = new JLabel("CPF:");
			jLabelNumeroCasa.setFont(Fontes.fontJLabelPlain1);
			jLabelNumeroCasa.setSize(60, 25);
			jLabelNumeroCasa.setBackground(Cores.branco);
			jLabelNumeroCasa.setForeground(Cores.azul1);
			jLabelNumeroCasa.setOpaque(false);
		}
		return jLabelNumeroCasa;
	}


	public JLabel getjLabelTipoPessoa() {
		if(jLabelTipoPessoa == null){			
			jLabelTipoPessoa = new JLabel("CPF:");
			jLabelTipoPessoa.setFont(Fontes.fontJLabelPlain1);
			jLabelTipoPessoa.setSize(35, 25);
			jLabelTipoPessoa.setBackground(Cores.branco);
			jLabelTipoPessoa.setForeground(Cores.azul1);
			jLabelTipoPessoa.setOpaque(false);
		}
		return jLabelTipoPessoa;
	}




	//** Fim getters JLabel **
	
	//** Início getters JButton **

	
	


	public JRadioButton getjRadioButtonCpf() {
		if(jRadioButtonCpf == null){
	
			jRadioButtonCpf = new ();
	
		}
		return jRadioButtonCpf;
	}


	public JRadioButton getjRadioButtonCnpj() {
		if(jRadioButtonCnpj == null){
	
			jRadioButtonCnpj = new ();
	
		}
		return jRadioButtonCnpj;
	}


	
	
	public Choice getChoiceTipoPessoa() {
		if(choiceTipoPessoa == null){
	
			choiceTipoPessoa = new ();
	
		}
		return choiceTipoPessoa;
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


	public JButton getjButtonCadastrarCliente() {
		if(jButtonCadastrarCliente == null){
			jButtonCadastrarCliente = new JButton();			
			jButtonCadastrarCliente.setFont(Fontes.fontJButtonPlain2);
			jButtonCadastrarCliente.setBackground(Cores.azul1);
			jButtonCadastrarCliente.setForeground(Cores.branco);
			jButtonCadastrarCliente.setText("Inserir serviço");
			jButtonCadastrarCliente.setSize(114, 25);
			jButtonCadastrarCliente.setFocusable(false);
			jButtonCadastrarCliente.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCadastrarCliente;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **


	
	public JTextField getjTFieldCpf() {
		if(jTFieldCpf == null){
			jTFieldCpf = new JTextField();
			jTFieldCpf.setSize(166, 21);
			jTFieldCpf.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCpf.setForeground(Cores.preto);
			jTFieldCpf.setFont(Fontes.fontJTFieldPlain1);
			jTFieldCpf.setOpaque(true);
		}
		return jTFieldCpf;
	}
	
	
	public JTextField getjTFieldNome() {
		if(jTFieldNome == null){
			jTFieldNome = new JTextField();
			jTFieldNome.setSize(219, 21);
			jTFieldNome.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldNome.setForeground(Cores.preto);
			jTFieldNome.setFont(Fontes.fontJTFieldPlain1);
			jTFieldNome.setOpaque(true);
		}
		return jTFieldNome;
	}


	public JTextField getjTFieldTelefone() {
		if(jTFieldTelefone == null){
			jTFieldTelefone = new JTextField();
			jTFieldTelefone.setSize(140, 21);
			jTFieldTelefone.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldTelefone.setForeground(Cores.preto);
			jTFieldTelefone.setFont(Fontes.fontJTFieldPlain1);
			jTFieldTelefone.setOpaque(true);
		}
		return jTFieldTelefone;
	}


	public JTextField getjTFieldEmail() {
		if(jTFieldEmail == null){
			jTFieldEmail = new JTextField();
			jTFieldEmail.setSize(166, 21);
			jTFieldEmail.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldEmail.setForeground(Cores.preto);
			jTFieldEmail.setFont(Fontes.fontJTFieldPlain1);
			jTFieldEmail.setOpaque(true);
		}
		return jTFieldEmail;
	}


	public JTextField getjTFieldCidade() {
		if(jTFieldCidade == null){
			jTFieldCidade = new JTextField();
			jTFieldCidade.setSize(219, 21);
			jTFieldCidade.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCidade.setForeground(Cores.preto);
			jTFieldCidade.setFont(Fontes.fontJTFieldPlain1);
			jTFieldCidade.setOpaque(true);
		}
		return jTFieldCidade;
	}


	public JTextField getjTFieldBairro() {
		if(jTFieldBairro == null){
			jTFieldBairro = new JTextField();
			jTFieldBairro.setSize(140, 21);
			jTFieldBairro.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldBairro.setForeground(Cores.preto);
			jTFieldBairro.setFont(Fontes.fontJTFieldPlain1);
			jTFieldBairro.setOpaque(true);
		}
		return jTFieldBairro;
	}


	public JTextField getjTFieldRua() {
		if(jTFieldRua == null){
			jTFieldRua = new JTextField();
			jTFieldRua.setSize(166, 21);
			jTFieldRua.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldRua.setForeground(Cores.preto);
			jTFieldRua.setFont(Fontes.fontJTFieldPlain1);
			jTFieldRua.setOpaque(true);
		}
		return jTFieldRua;
	}


	public JTextField getjTFieldNumeroCasa() {
		if(jTFieldNumeroCasa == null){
			jTFieldNumeroCasa = new JTextField();
			jTFieldNumeroCasa.setSize(120, 21);
			jTFieldNumeroCasa.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldNumeroCasa.setForeground(Cores.preto);
			jTFieldNumeroCasa.setFont(Fontes.fontJTFieldPlain1);
			jTFieldNumeroCasa.setOpaque(true);
		}
		return jTFieldNumeroCasa;
	}
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogCadastrarCliente() {
		
		getJDialogCadastrarCliente().getContentPane().add(getjButtonProcurarPeca());
		getjButtonProcurarPeca().setLocation(36, 21);
		
		}
	
		
	
	
	
	//** Fim métodos adição de componentes **
	

}