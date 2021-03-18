/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.ComponentOrientation;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JDialogCadastrarCliente  extends JDialog{	
	
	
	//** Início declaração de variáveis **
		
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
		super(frame, "Cadastrar Cliente");
		this.modal = modal;
		this.addCompJDialogCadastrarCliente();
	}	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogCadastrarCliente  getJDialogCadastrarCliente() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 238);
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
			jLabelCpf.setSize(70, 25);
			jLabelCpf.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelCpf.setBackground(Cores.branco);
			jLabelCpf.setForeground(Cores.azul1);
			jLabelCpf.setOpaque(false);
		}
		return jLabelCpf;
	}


	public JLabel getjLabelNome() {
		if(jLabelNome == null){			
			jLabelNome = new JLabel("Nome:");
			jLabelNome.setFont(Fontes.fontJLabelPlain1);
			jLabelNome.setSize(70, 25);
			jLabelNome.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelNome.setBackground(Cores.branco);
			jLabelNome.setForeground(Cores.azul1);
			jLabelNome.setOpaque(false);
		}
		return jLabelNome;
	}


	public JLabel getjLabelTelefone() {
		if(jLabelTelefone == null){			
			jLabelTelefone = new JLabel("Telefone:");
			jLabelTelefone.setFont(Fontes.fontJLabelPlain1);
			jLabelTelefone.setSize(70, 25);
			jLabelTelefone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelTelefone.setBackground(Cores.branco);
			jLabelTelefone.setForeground(Cores.azul1);
			jLabelTelefone.setOpaque(false);
		}
		return jLabelTelefone;
	}


	public JLabel getjLabelEmail() {
		if(jLabelEmail == null){			
			jLabelEmail = new JLabel("Email:");
			jLabelEmail.setFont(Fontes.fontJLabelPlain1);
			jLabelEmail.setSize(70, 25);
			jLabelEmail.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelEmail.setBackground(Cores.branco);
			jLabelEmail.setForeground(Cores.azul1);
			jLabelEmail.setOpaque(false);
		}
		return jLabelEmail;
	}


	public JLabel getjLabelCidade() {
		if(jLabelCidade == null){			
			jLabelCidade = new JLabel("Cidade:");
			jLabelCidade.setFont(Fontes.fontJLabelPlain1);
			jLabelCidade.setSize(70, 25);
			jLabelCidade.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelCidade.setBackground(Cores.branco);
			jLabelCidade.setForeground(Cores.azul1);
			jLabelCidade.setOpaque(false);
		}
		return jLabelCidade;
	}


	public JLabel getjLabelBairro() {
		if(jLabelBairro == null){			
			jLabelBairro = new JLabel("Bairro:");
			jLabelBairro.setFont(Fontes.fontJLabelPlain1);
			jLabelBairro.setSize(70, 25);
			jLabelBairro.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelBairro.setBackground(Cores.branco);
			jLabelBairro.setForeground(Cores.azul1);
			jLabelBairro.setOpaque(false);
		}
		return jLabelBairro;
	}


	public JLabel getjLabelRua() {
		if(jLabelRua == null){			
			jLabelRua = new JLabel("Rua:");
			jLabelRua.setFont(Fontes.fontJLabelPlain1);
			jLabelRua.setSize(70, 25);
			jLabelRua.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelRua.setBackground(Cores.branco);
			jLabelRua.setForeground(Cores.azul1);
			jLabelRua.setOpaque(false);
		}
		return jLabelRua;
	}


	public JLabel getjLabelNumeroCasa() {
		if(jLabelNumeroCasa == null){			
			jLabelNumeroCasa = new JLabel("Casa:");
			jLabelNumeroCasa.setFont(Fontes.fontJLabelPlain1);
			jLabelNumeroCasa.setSize(70, 25);
			jLabelNumeroCasa.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelNumeroCasa.setBackground(Cores.branco);
			jLabelNumeroCasa.setForeground(Cores.azul1);
			jLabelNumeroCasa.setOpaque(false);
		}
		return jLabelNumeroCasa;
	}


	public JLabel getjLabelTipoPessoa() {
		if(jLabelTipoPessoa == null){			
			jLabelTipoPessoa = new JLabel("Tipo:");
			jLabelTipoPessoa.setFont(Fontes.fontJLabelPlain1);
			jLabelTipoPessoa.setSize(70, 25);
			jLabelTipoPessoa.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
			jRadioButtonCpf = new JRadioButton("CPF");
			jRadioButtonCpf.setSize(45, 15);
			jRadioButtonCpf.setBackground(Cores.branco);
			jRadioButtonCpf.setForeground(Cores.preto);
			jRadioButtonCpf.setFocusPainted(false);
			jRadioButtonCpf.setFont(Fontes.fontJButtonPlain1);
		}
		return jRadioButtonCpf;
	}


	public JRadioButton getjRadioButtonCnpj() {
		if(jRadioButtonCnpj == null){
			jRadioButtonCnpj = new JRadioButton("CNPJ");
			jRadioButtonCnpj.setSize(55, 15);
			jRadioButtonCnpj.setBackground(Cores.branco);
			jRadioButtonCnpj.setForeground(Cores.preto);
			jRadioButtonCnpj.setFocusPainted(false);
			jRadioButtonCnpj.setFont(Fontes.fontJButtonPlain1);		
		}
		return jRadioButtonCnpj;
	}


	
	
	public Choice getChoiceTipoPessoa() {
		if(choiceTipoPessoa == null){
			choiceTipoPessoa = new Choice();
			choiceTipoPessoa.setSize(175, 25);
			choiceTipoPessoa.setFont(Fontes.fontJTFieldPlain1);
			choiceTipoPessoa.setVisible(true);
			choiceTipoPessoa.add("              ");
			choiceTipoPessoa.add("física        ");
			choiceTipoPessoa.add("jurídica      ");
			choiceTipoPessoa.setFocusable(false);	
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
			jButtonCadastrarCliente.setText("Cadastrar cliente");
			jButtonCadastrarCliente.setSize(150, 25);
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
		
		getJDialogCadastrarCliente().getContentPane().add(getjRadioButtonCpf());
		getjRadioButtonCpf().setLocation(76, 31);
		
		getJDialogCadastrarCliente().getContentPane().add(getjRadioButtonCnpj());
		getjRadioButtonCnpj().setLocation(119, 31);

		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelCpf());
		getjLabelCpf().setLocation(1, 48);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldCpf());
		getjTFieldCpf().setLocation(76, 48);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelNome());
		getjLabelNome().setLocation(258, 48);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldNome());
		getjTFieldNome().setLocation(333, 48);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelTelefone());
		getjLabelTelefone().setLocation(576, 48);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldTelefone());		
		getjTFieldTelefone().setLocation(649, 48);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelEmail());
		getjLabelEmail().setLocation(1, 82);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldEmail());
		getjTFieldEmail().setLocation(76, 82);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelCidade());
		getjLabelCidade().setLocation(258, 82);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldCidade());
		getjTFieldCidade().setLocation(333, 82);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelBairro());
		getjLabelBairro().setLocation(576, 82);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldBairro());
		getjTFieldBairro().setLocation(649, 82);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelRua());
		getjLabelRua().setLocation(1, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldRua());
		getjTFieldRua().setLocation(76, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelNumeroCasa());
		getjLabelNumeroCasa().setLocation(258, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldNumeroCasa());
		getjTFieldNumeroCasa().setLocation(333, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelTipoPessoa());
		getjLabelTipoPessoa().setLocation(576, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getChoiceTipoPessoa());
		getChoiceTipoPessoa().setLocation(649, 116);

		
		getJDialogCadastrarCliente().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(688, 163);
		
		getJDialogCadastrarCliente().getContentPane().add(getjButtonCadastrarCliente());
		getjButtonCadastrarCliente().setLocation(787, 163);
		
		}
	
		
	
	
	
	//** Fim métodos adição de componentes **
	

}