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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JDialogCadastrarVeiculo  extends JDialog{	
	
	
	//** Início declaração de variáveis **
		
	private boolean modalTela;	

	private JButton jButtonCancelar;
	private JButton jButtonCadastrarVeiculo;
	
	private JLabel jLabelMarca;
	private JLabel jLabelCor;
	private JLabel jLabelChassi;
	private JLabel jLabelModelo;
	private JLabel jLabelAno;
	private JLabel jLabelPlaca;
	private JLabel jLabelMotor;
	private JLabel jLabelKMAtual;
	private JLabel jLabelCombustivel;	
	
	private JTextField jTFieldMarca;
	private JTextField jTFieldCor;
	private JFormattedTextField jTFieldChassi;
	private JTextField jTFieldModelo;
	private JFormattedTextField jTFieldAno;
	private JTextField jTFieldPlaca;
	private JTextField jTFieldMotor;
	private JFormattedTextField jTFieldKMAtual;
	
	
	private Choice choiceCombustivel;
	
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	public JDialogCadastrarVeiculo(Frame frame, boolean modal) {
		super(frame, "Cadastrar Veículo");
		setmodalTela(modal);
		this.addCompJDialogCadastrarVeiculo();
	}	
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	public JDialogCadastrarVeiculo  getJDialogCadastrarVeiculo() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBackground(Cores.branco);
		this.setSize(975, 238);
		this.setVisible(true);
		setmodalTela(modalTela);
		return this;
	}
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **


	public JLabel getjLabelMarca() {
		if(jLabelMarca == null){			
			jLabelMarca = new JLabel("Marca:");
			jLabelMarca.setFont(Fontes.fontJLabelPlain1);
			jLabelMarca.setSize(80, 25);
			jLabelMarca.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelMarca.setBackground(Cores.branco);
			jLabelMarca.setForeground(Cores.azul1);
			jLabelMarca.setOpaque(false);
		}
		return jLabelMarca;
	}


	public JLabel getjLabelCor() {
		if(jLabelCor == null){			
			jLabelCor = new JLabel("Cor:");
			jLabelCor.setFont(Fontes.fontJLabelPlain1);
			jLabelCor.setSize(80, 25);
			jLabelCor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelCor.setBackground(Cores.branco);
			jLabelCor.setForeground(Cores.azul1);
			jLabelCor.setOpaque(false);
		}
		return jLabelCor;
	}


	public JLabel getjLabelChassi() {
		if(jLabelChassi == null){			
			jLabelChassi = new JLabel("Chassi:");
			jLabelChassi.setFont(Fontes.fontJLabelPlain1);
			jLabelChassi.setSize(80, 25);
			jLabelChassi.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelChassi.setBackground(Cores.branco);
			jLabelChassi.setForeground(Cores.azul1);
			jLabelChassi.setOpaque(false);
		}
		return jLabelChassi;
	}


	public JLabel getjLabelModelo() {
		if(jLabelModelo == null){			
			jLabelModelo = new JLabel("Modelo:");
			jLabelModelo.setFont(Fontes.fontJLabelPlain1);
			jLabelModelo.setSize(80, 25);
			jLabelModelo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelModelo.setBackground(Cores.branco);
			jLabelModelo.setForeground(Cores.azul1);
			jLabelModelo.setOpaque(false);
		}
		return jLabelModelo;
	}


	public JLabel getjLabelAno() {
		if(jLabelAno == null){			
			jLabelAno = new JLabel("Ano:");
			jLabelAno.setFont(Fontes.fontJLabelPlain1);
			jLabelAno.setSize(80, 25);
			jLabelAno.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelAno.setBackground(Cores.branco);
			jLabelAno.setForeground(Cores.azul1);
			jLabelAno.setOpaque(false);
		}
		return jLabelAno;
	}


	public JLabel getjLabelPlaca() {
		if(jLabelPlaca == null){			
			jLabelPlaca = new JLabel("Placa:");
			jLabelPlaca.setFont(Fontes.fontJLabelPlain1);
			jLabelPlaca.setSize(80, 25);
			jLabelPlaca.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelPlaca.setBackground(Cores.branco);
			jLabelPlaca.setForeground(Cores.azul1);
			jLabelPlaca.setOpaque(false);
		}
		return jLabelPlaca;
	}


	public JLabel getjLabelMotor() {
		if(jLabelMotor == null){			
			jLabelMotor = new JLabel("Motor:");
			jLabelMotor.setFont(Fontes.fontJLabelPlain1);
			jLabelMotor.setSize(80, 25);
			jLabelMotor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelMotor.setBackground(Cores.branco);
			jLabelMotor.setForeground(Cores.azul1);
			jLabelMotor.setOpaque(false);
		}
		return jLabelMotor;
	}


	public JLabel getjLabelKMAtual() {
		if(jLabelKMAtual == null){			
			jLabelKMAtual = new JLabel("Km atual:");
			jLabelKMAtual.setFont(Fontes.fontJLabelPlain1);
			jLabelKMAtual.setSize(95, 25);
			jLabelKMAtual.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelKMAtual.setBackground(Cores.branco);
			jLabelKMAtual.setForeground(Cores.azul1);
			jLabelKMAtual.setOpaque(false);
		}
		return jLabelKMAtual;
	}


	public JLabel getjLabelCombustivel() {
		if(jLabelCombustivel == null){			
			jLabelCombustivel = new JLabel("Combustível:");
			jLabelCombustivel.setFont(Fontes.fontJLabelPlain1);
			jLabelCombustivel.setSize(95, 25);
			jLabelCombustivel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabelCombustivel.setBackground(Cores.branco);
			jLabelCombustivel.setForeground(Cores.azul1);
			jLabelCombustivel.setOpaque(false);
		}
		return jLabelCombustivel;
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


	public JButton getjButtonCadastrarVeiculo() {
		if(jButtonCadastrarVeiculo == null){
			jButtonCadastrarVeiculo = new JButton();			
			jButtonCadastrarVeiculo.setFont(Fontes.fontJButtonPlain2);
			jButtonCadastrarVeiculo.setBackground(Cores.azul1);
			jButtonCadastrarVeiculo.setForeground(Cores.branco);
			jButtonCadastrarVeiculo.setText("Cadastrar veículo");
			jButtonCadastrarVeiculo.setSize(150, 25);
			jButtonCadastrarVeiculo.setFocusable(false);
			jButtonCadastrarVeiculo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));	        
		}
		return jButtonCadastrarVeiculo;
	}
	
	
	//** Fim getters JButon **	
	
	//** Início getters JTextFields **


	public JTextField getjTFieldMarca() {
		if(jTFieldMarca == null){
			jTFieldMarca = new JTextField();
			jTFieldMarca.setSize(105, 21);
			jTFieldMarca.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldMarca.setForeground(Cores.preto);
			jTFieldMarca.setFont(Fontes.fontJTFieldPlain1);
			jTFieldMarca.setOpaque(true);
		}
		return jTFieldMarca;
	}


	public JTextField getjTFieldCor() {
		if(jTFieldCor == null){
			jTFieldCor = new JTextField();
			jTFieldCor.setSize(105, 21);
			jTFieldCor.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldCor.setForeground(Cores.preto);
			jTFieldCor.setFont(Fontes.fontJTFieldPlain1);
			jTFieldCor.setOpaque(true);
		}
		return jTFieldCor;
	}


	public JFormattedTextField getjTFieldChassi() {
		if(jTFieldChassi == null){
			jTFieldChassi = new JFormattedTextField();
			jTFieldChassi.setSize(219, 21);
			jTFieldChassi.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldChassi.setForeground(Cores.preto);
			jTFieldChassi.setFont(Fontes.fontJTFieldPlain1);
			jTFieldChassi.setOpaque(true);
		}
		return jTFieldChassi;
	}


	public JTextField getjTFieldModelo() {
		if(jTFieldModelo == null){
			jTFieldModelo = new JTextField();
			jTFieldModelo.setSize(219, 21);
			jTFieldModelo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldModelo.setForeground(Cores.preto);
			jTFieldModelo.setFont(Fontes.fontJTFieldPlain1);
			jTFieldModelo.setOpaque(true);
		}
		return jTFieldModelo;
	}


	public JFormattedTextField getjTFieldAno() {
		if(jTFieldAno == null){
			jTFieldAno = new JFormattedTextField();
			jTFieldAno.setSize(107, 21);
			jTFieldAno.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldAno.setForeground(Cores.preto);
			jTFieldAno.setFont(Fontes.fontJTFieldPlain1);
			jTFieldAno.setOpaque(true);
		}
		return jTFieldAno;
	}


	public JTextField getjTFieldPlaca() {
		if(jTFieldPlaca == null){
			jTFieldPlaca = new JFormattedTextField();
			jTFieldPlaca.setSize(122, 21);
			jTFieldPlaca.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldPlaca.setForeground(Cores.preto);
			jTFieldPlaca.setFont(Fontes.fontJTFieldPlain1);
			jTFieldPlaca.setOpaque(true);
		}
		return jTFieldPlaca;
	}


	public JTextField getjTFieldMotor() {
		if(jTFieldMotor == null){
			jTFieldMotor = new JTextField();
			jTFieldMotor.setSize(122, 21);
			jTFieldMotor.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldMotor.setForeground(Cores.preto);
			jTFieldMotor.setFont(Fontes.fontJTFieldPlain1);
			jTFieldMotor.setOpaque(true);
		}
		return jTFieldMotor;
	}


	public JFormattedTextField getjTFieldKMAtual() {
		if(jTFieldKMAtual == null){
			jTFieldKMAtual = new JFormattedTextField();
			jTFieldKMAtual.setSize(120, 21);
			jTFieldKMAtual.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
			jTFieldKMAtual.setForeground(Cores.preto);
			jTFieldKMAtual.setFont(Fontes.fontJTFieldPlain1);
			jTFieldKMAtual.setOpaque(true);
		}
		return jTFieldKMAtual;
	}


	public Choice getChoiceCombustivel() {
		if(choiceCombustivel == null){
			choiceCombustivel = new Choice();
			choiceCombustivel.setSize(150, 25);
			choiceCombustivel.setFont(Fontes.fontJTFieldPlain1);
			choiceCombustivel.setVisible(true);
			choiceCombustivel.add("Flex         ");
			choiceCombustivel.add("Álcool       ");
			choiceCombustivel.add("Diesel       ");
			choiceCombustivel.add("Elétrico     ");
			choiceCombustivel.add("Gasolina     ");
			choiceCombustivel.add("Híbrido      ");
			choiceCombustivel.setFocusable(false);	
		}
		return choiceCombustivel;
	}
	
	//** Fim getters JTextField **		
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	
	//** Fim getters conjuto JScrollPane/JTable **
	
	//** Início métodos adição de componentes **
	
	
	public void addCompJDialogCadastrarVeiculo() {
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelChassi());
		getjLabelChassi().setLocation(198, 35);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldChassi());
		getjTFieldChassi().setLocation(283, 35);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelPlaca());
		getjLabelPlaca().setLocation(502, 35);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldPlaca());
		getjTFieldPlaca().setLocation(587, 35);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelKMAtual());
		getjLabelKMAtual().setLocation(718, 35);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldKMAtual());
		getjTFieldKMAtual().setLocation(818, 35);
		
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelMarca());
		getjLabelMarca().setLocation(0, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldMarca());
		getjTFieldMarca().setLocation(85, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelModelo());
		getjLabelModelo().setLocation(198, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldModelo());
		getjTFieldModelo().setLocation(283, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelMotor());
		getjLabelMotor().setLocation(502, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldMotor());
		getjTFieldMotor().setLocation(587, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelCombustivel());
		getjLabelCombustivel().setLocation(718, 69);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getChoiceCombustivel());
		getChoiceCombustivel().setLocation(818, 69);
		
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelCor());
		getjLabelCor().setLocation(0, 103);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldCor());
		getjTFieldCor().setLocation(85, 103);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjLabelAno());
		getjLabelAno().setLocation(198, 103);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjTFieldAno());
		getjTFieldAno().setLocation(283, 103);

		
		getJDialogCadastrarVeiculo().getContentPane().add(getjButtonCancelar());
		getjButtonCancelar().setLocation(688, 155);
		
		getJDialogCadastrarVeiculo().getContentPane().add(getjButtonCadastrarVeiculo());
		getjButtonCadastrarVeiculo().setLocation(787, 155);
		
	}
	
	//** Fim métodos adição de componentes **
	
	
	public boolean ismodalTela() {
		return modalTela;
	}
	
	
	public void setmodalTela(boolean modalTela) {
		this.modalTela = modalTela;
	}

}