package view;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

public class JPanelGeraOS extends JPanel {
	
	//** Início declaração de variáveis **
		private JButton jButtonCancelar;
		private JButton jButtonSalvar;
		private JButton jButtonImprimir;
		private JButton jButtonProcuraCliente;
		private JButton jButtonSelecionarVeiculo;
		
		
		private JLabel jLabelCpf;
		private JLabel jLabelEmail;
		private JLabel jLabelRua;
		private JLabel jLabelNome;
		private JLabel jLabelCidade;
		private JLabel jLabelNumeroCasa;
		private JLabel jLabelTipo;
		private JLabel jLabelBairro;
		private JLabel jLabelTelefone;
		
		
		private JLabel jLabelNumeroVeiculo;
		private JLabel jLabelMarca;
		private JLabel jLabelCor;
		private JLabel jLabelChassi;
		private JLabel jLabelModelo;
		private JLabel jLabelAno;
		private JLabel jLabelPlaca;
		private JLabel jLabelMotor;
		private JLabel jLabelKMAtual;
		private JLabel jLabelCombustivel;
		
		
		private JLabel jLabelNumeroOS;
		private JLabel jLabelServico;
		private JLabel jLabelReclamacao;
		private JLabel jLabelData;
		private JLabel jLabelMotorista;
		private JLabel jLabelResponsavel;
		
		private JTextField jTFieldCpf;
		private JTextField jTFieldEmail;
		private JTextField jTFieldRua;
		private JTextField jTFieldNome;
		private JTextField jTFieldCidade;
		private JTextField jTFieldNumeroCasa;
		private JTextField jTFieldTipo;
		private JTextField jTFieldBairro;
		private JTextField jTFieldTelefone;
		
		private JTextField jTFieldNumeroVeiculo;
		private JTextField jTFieldMarca;
		private JTextField jTFieldCor;
		private JTextField jTFieldChassi;
		private JTextField jTFieldModelo;
		private JTextField jTFieldAno;
		private JTextField jTFieldPlaca;
		private JTextField jTFieldMotor;
		private JTextField jTFieldKMAtual;
		private JTextField jTFieldCombustivel;
		
		private JTextField jTFieldNumeroOS;
		private JTextField jTFieldServico;
		private JTextField jTFieldReclamacao;
		private JTextField jTFieldData;
		private JTextField jTFieldMotorista;
		private JTextField jTFieldResponsavel;
		
	//** Fim declaração de variáveis **

	

	
	
	
	
	//** Início getters JPanels **
	//** Fim getters JPanel **
	
	
	//** Início getters JButon **

		public JButton getjButtonCancelar() {
			if(jButtonCancelar == null){
				
				jButtonCancelar = new JButton();
		
				}	
			return jButtonCancelar;
	
		}
		
		public JButton getjButtonSalvar() {
			if(jButtonSalvar == null){
				
				jButtonSalvar = new JButton();
		
				}	
			return jButtonSalvar;
		
		}
		
		public JButton getjButtonImprimir() {
			if(jButtonImprimir == null){
				
				jButtonImprimir = new JButton();
		
				}	
			return jButtonImprimir;
		
		}
		
		public JButton getjButtonProcuraCliente() {
			if(jButtonProcuraCliente == null){
				
				jButtonProcuraCliente = new JButton();
		
				}	
			return jButtonProcuraCliente;
		
		}
		
		public JButton getjButtonSelecionarVeiculo() {
			if(jButtonSelecionarVeiculo == null){
				
				jButtonSelecionarVeiculo = new JButton();
		
				}	
			return jButtonSelecionarVeiculo;
		
		}
		
	//** Fim getters JButon **
	
	
	//** Início getters JLabel **
	//** Fim getters JLabel **
	
	
	//** Início métodos adição de componentes **
	//** Fim métodos adição de componentes **
	
	
	//** Início métodos da classe **
	//** Fim métodos da classe **
	

}