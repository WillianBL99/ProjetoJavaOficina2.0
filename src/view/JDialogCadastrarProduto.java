/**
 * 
 */
package view;

import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */
@SuppressWarnings("serial")
public class JDialogCadastrarProduto extends JDialog{	
	
	
	//** Início declaração de variáveis **
		
	private boolean modalTela;
	
	private JButton jButtonCancelar;
	private JButton jButtonCadastrarCliente;	
	
	private JLabel jLabeCodigo;
	private JLabel jLabelDescricao;
	private JLabel jLabelMarca;
	private JLabel jLabelQuantidade;
	private JLabel jLabelPreco;	
	
	private JTextField jTFieldCodigo;
	private JTextField jTFieldDescricao;
	private JTextField jTFieldMarca;
	private JTextField jTFieldQuantidade;
	private JTextField jTFieldPreco;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	public JDialogCadastrarProduto(Frame frame, boolean modal) {
		super(frame, "Cadastrar produto");
		setmodalTela(modal);
		this.addCompJDialogCadastrarCliente();
	}	
	
	
	public JDialogCadastrarProduto(Dialog dialog, boolean modal) {
		super(dialog, "Cadastrar produto");
		setmodalTela(modal);
		this.addCompJDialogCadastrarCliente();
	}	
	

	
	//** Fim construtor **
	
	//** Início getters JPanels **
	public JDialogCadastrarProduto  getJDialogCadastrarCliente() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBackground(Cores.branco);
		this.setSize(814, 255);
		this.setVisible(true);
		setmodalTela(modalTela);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	public JLabel getjLabelCodigo() {
		if(jLabeCodigo == null){			
			jLabeCodigo = new JLabel("Código:");
			jLabeCodigo.setFont(Fontes.fontJLabelPlain1);
			jLabeCodigo.setSize(90, 25);
			jLabeCodigo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabeCodigo.setBackground(Cores.branco);
			jLabeCodigo.setForeground(Cores.azul1);
			jLabeCodigo.setOpaque(false);
		}
		return jLabeCodigo;
	}


	public JLabel getjLabelDescricao() {
		if(jLabelDescricao == null){			
			jLabelDescricao = new JLabel("Descrição:");
			jLabelDescricao.setFont(Fontes.fontJLabelPlain1);
			jLabelDescricao.setSize(90, 25);
			jLabelDescricao.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelDescricao.setBackground(Cores.branco);
			jLabelDescricao.setForeground(Cores.azul1);
			jLabelDescricao.setOpaque(false);
		}
		return jLabelDescricao;
	}


	public JLabel getjLabelMarca() {
		if(jLabelMarca == null){			
			jLabelMarca = new JLabel("Marca:");
			jLabelMarca.setFont(Fontes.fontJLabelPlain1);
			jLabelMarca.setSize(90, 25);
			jLabelMarca.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelMarca.setBackground(Cores.branco);
			jLabelMarca.setForeground(Cores.azul1);
			jLabelMarca.setOpaque(false);
		}
		return jLabelMarca;
	}


	public JLabel getjLabelQuantidade() {
		if(jLabelQuantidade == null){			
			jLabelQuantidade = new JLabel("Quantidade:");
			jLabelQuantidade.setFont(Fontes.fontJLabelPlain1);
			jLabelQuantidade.setSize(90, 25);
			jLabelQuantidade.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelQuantidade.setBackground(Cores.branco);
			jLabelQuantidade.setForeground(Cores.azul1);
			jLabelQuantidade.setOpaque(false);
		}
		return jLabelQuantidade;
	}


	public JLabel getjLabelPreco() {
		if(jLabelPreco == null){			
			jLabelPreco = new JLabel("Preço:");
			jLabelPreco.setFont(Fontes.fontJLabelPlain1);
			jLabelPreco.setSize(90, 25);
			jLabelPreco.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelPreco.setBackground(Cores.branco);
			jLabelPreco.setForeground(Cores.azul1);
			jLabelPreco.setOpaque(false);
		}
		return jLabelPreco;
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
			jButtonCancelar.setSize(86, 25);
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
			jButtonCadastrarCliente.setText("Cadastrar produto");
			jButtonCadastrarCliente.setSize(150, 25);
			jButtonCadastrarCliente.setFocusable(false);
			jButtonCadastrarCliente.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCadastrarCliente;
	}
	
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **


	
	public JTextField getjTFieldCodigo() {
		if(jTFieldCodigo == null){
			jTFieldCodigo = new JTextField();
			jTFieldCodigo.setSize(302, 21);
			jTFieldCodigo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCodigo.setForeground(Cores.preto);
			jTFieldCodigo.setFont(Fontes.fontJTFieldPlain1);
			jTFieldCodigo.setOpaque(true);
		}
		return jTFieldCodigo;
	}
	
	
	public JTextField getjTFieldDescricao() {
		if(jTFieldDescricao == null){
			jTFieldDescricao = new JTextField();
			jTFieldDescricao.setSize(302, 21);
			jTFieldDescricao.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldDescricao.setForeground(Cores.preto);
			jTFieldDescricao.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDescricao.setOpaque(true);
		}
		return jTFieldDescricao;
	}
	
	
	public JTextField getjTFieldMarca() {
		if(jTFieldMarca == null){
			jTFieldMarca = new JTextField();
			jTFieldMarca.setSize(260, 21);
			jTFieldMarca.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldMarca.setForeground(Cores.preto);
			jTFieldMarca.setFont(Fontes.fontJTFieldPlain1);
			jTFieldMarca.setOpaque(true);
		}
		return jTFieldMarca;
	}


	public JTextField getjTFieldQuantidade() {
		if(jTFieldQuantidade == null){
			jTFieldQuantidade = new JTextField();
			jTFieldQuantidade.setSize(302, 21);
			jTFieldQuantidade.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldQuantidade.setForeground(Cores.preto);
			jTFieldQuantidade.setFont(Fontes.fontJTFieldPlain1);
			jTFieldQuantidade.setOpaque(true);
		}
		return jTFieldQuantidade;
	}


	public JTextField getjTFieldPreco() {
		if(jTFieldPreco == null){
			jTFieldPreco = new JTextField();
			jTFieldPreco.setSize(261, 21);
			jTFieldPreco.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldPreco.setForeground(Cores.preto);
			jTFieldPreco.setFont(Fontes.fontJTFieldPlain1);
			jTFieldPreco.setOpaque(true);
		}
		return jTFieldPreco;
	}
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogCadastrarCliente() {
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelCodigo());
		getjLabelCodigo().setLocation(20, 30);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldCodigo());
		getjTFieldCodigo().setLocation(112, 30);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelDescricao());
		getjLabelDescricao().setLocation(20, 73);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldDescricao());
		getjTFieldDescricao().setLocation(112, 73);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelMarca());
		getjLabelMarca().setLocation(411, 73);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldMarca());
		getjTFieldMarca().setLocation(506, 73);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelQuantidade());
		getjLabelQuantidade().setLocation(20, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldQuantidade());		
		getjTFieldQuantidade().setLocation(112, 116);
				
		
		getJDialogCadastrarCliente().getContentPane().add(getjLabelPreco());
		getjLabelPreco().setLocation(411, 116);
		
		getJDialogCadastrarCliente().getContentPane().add(getjTFieldPreco());
		getjTFieldPreco().setLocation(506, 116);

		
		getJDialogCadastrarCliente().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(521, 175);
		
		
		getJDialogCadastrarCliente().getContentPane().add(getjButtonCadastrarCliente());
		getjButtonCadastrarCliente().setLocation(617, 175);
		
	}
		
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}
	
	
	
	//** Fim métodos adição de componentes **
	

}