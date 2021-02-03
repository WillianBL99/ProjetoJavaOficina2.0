package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

	public class JPanelGeraOS extends JPanel {
		
		public JPanelGeraOS() {
			getJPanelGeraOS();
			addCompJPanelGeraOS();
			getjPanelCentro();
			addCompJpanelCentro();
		}
	
	//** Início declaração de variáveis **
		private SetSizeIcon setSizeIcon = new SetSizeIcon();
		
		private JPanel jPanelCentro;
		
		private JButton jButtonCancelar;
		private JButton jButtonSalvar;
		private JButton jButtonImprimir;
		private JButton jButtonProcuraCliente;
		private JButton jButtonSelecionarVeiculo;
		
		private JRadioButton jRadioButtonCpf;
		private JRadioButton jRadioButtonCnpj;
		
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
		public JPanelGeraOS getJPanelGeraOS() {
			
			this.setLayout(null);
			this.setSize(new Dimension(1030, 674));
			this.setBackground(Cores.cinza4);
			this.setVisible(true);
			
			return this;
		}
		
		public JPanel getjPanelCentro() {
			if(jPanelCentro == null){
		
				jPanelCentro = new JPanel();
				jPanelCentro.setLayout(null);
				jPanelCentro.setSize(new Dimension(1002, 568));
				jPanelCentro.setVisible(true);
				jPanelCentro.setBackground(Cores.branco);
		
			}
			return jPanelCentro;
		}
		
	//** Fim getters JPanel **
	
	
	//** Início getters JButon **


		public JButton getjButtonCancelar() {
			if(jButtonCancelar == null){
				
				jButtonCancelar = new JButton();			
				jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
				jButtonCancelar.setBackground(Cores.azul1);
				jButtonCancelar.setForeground(Color.white);
				jButtonCancelar.setText("Cancelar");
				jButtonCancelar.setSize(110, 35);
				jButtonCancelar.setFocusable(false);
				jButtonCancelar.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1));
			}	
			return jButtonCancelar;
	
		}
		
		public JButton getjButtonSalvar() {
			if(jButtonSalvar == null){
				
				jButtonSalvar = new JButton();
				jButtonSalvar.setFont(Fontes.fontJButtonPlain3);
				jButtonSalvar.setBackground(Cores.azul1);
				jButtonSalvar.setForeground(Color.white);
				setSizeIcon.setIconJButton(jButtonSalvar, Icones.
						getSalvar(), 30, 30);
				jButtonSalvar.setSize(56,35);
				jButtonSalvar.setFocusable(false);
				jButtonSalvar.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1));
		
			}	
			return jButtonSalvar;
		
		}
		
		public JButton getjButtonImprimir() {
			if(jButtonImprimir == null){
				
				jButtonImprimir = new JButton();			
				jButtonImprimir.setFont(Fontes.fontJButtonPlain3);
				jButtonImprimir.setBackground(Cores.azul1);
				jButtonImprimir.setForeground(Color.white);
				setSizeIcon.setIconJButton(jButtonImprimir, Icones.
						getImprimir(), 30, 30);
				jButtonImprimir.setSize(56, 35);
				jButtonImprimir.setFocusable(false);
				jButtonImprimir.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1));
			}	
			return jButtonImprimir;
		
		}
		
		public JButton getjButtonProcuraCliente() {
			if(jButtonProcuraCliente == null){
				
				jButtonProcuraCliente = new JButton();
				jButtonProcuraCliente.setFont(Fontes.fontJButtonPlain3);			
				jButtonProcuraCliente.setBackground(Cores.azul1);
				jButtonProcuraCliente.setForeground(Color.white);
				jButtonProcuraCliente.setText("Procura Cliente");
				jButtonProcuraCliente.setSize(150,25);
				jButtonProcuraCliente.setFocusable(false);
				jButtonProcuraCliente.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1));
				
				}	
			return jButtonProcuraCliente;
		
		}
		
		public JButton getjButtonSelecionarVeiculo() {
			if(jButtonSelecionarVeiculo == null){
				
				jButtonSelecionarVeiculo = new JButton();
		
				}	
			return jButtonSelecionarVeiculo;
		
		}
		
		public JRadioButton getjRadioButtonCpf() {
			if(jRadioButtonCpf == null){
		
				jRadioButtonCpf = new JRadioButton("CPF");
				jRadioButtonCpf.setSize(45, 15);
				jRadioButtonCpf.setBackground(Cores.branco);
				jRadioButtonCpf.setForeground(Color.black);
				jRadioButtonCpf.setFont(Fontes.fontJButtonPlain0);
			}
			return jRadioButtonCpf;
		}

		public JRadioButton getjRadioButtonCnpj() {
			if(jRadioButtonCnpj == null){
		
				jRadioButtonCnpj = new JRadioButton("CNPJ");
				jRadioButtonCnpj.setSize(50, 15);
				jRadioButtonCnpj.setBackground(Cores.branco);
				jRadioButtonCnpj.setForeground(Color.black);
				jRadioButtonCnpj.setFont(Fontes.fontJButtonPlain0);
			}
			return jRadioButtonCnpj;
		}
		
	//** Fim getters JButon **
	
	
	//** Início getters JLabel **
	


		public JLabel getjLabelCpf() {
				if(jLabelCpf == null){
			
					jLabelCpf = new JLabel("CPF:");
					jLabelCpf.setFont(Fontes.fontJLabelPlain1);
					jLabelCpf.setSize(30, 20);
					jLabelCpf.setForeground(Cores.preto);
					jLabelCpf.setOpaque(false);
					
				}
				return jLabelCpf;
		}	
		public JLabel getjLabelEmail() {
			if(jLabelEmail == null){
		
				jLabelEmail = new JLabel();
		
			}
			return jLabelEmail;
		}	
		public JLabel getjLabelRua() {
			if(jLabelRua == null){
		
				jLabelRua = new JLabel();
		
			}
			return jLabelRua;
		}	
		public JLabel getjLabelNome() {
			if(jLabelNome == null){
		
				jLabelNome = new JLabel();
		
			}
			return jLabelNome;
		}	
		public JLabel getjLabelCidade() {
			if(jLabelCidade == null){
		
				jLabelCidade = new JLabel();
		
			}
			return jLabelCidade;
		}	
		public JLabel getjLabelNumeroCasa() {
			if(jLabelNumeroCasa == null){
		
				jLabelNumeroCasa = new JLabel();
		
			}
			return jLabelNumeroCasa;
		}	
		public JLabel getjLabelTipo() {
			if(jLabelTipo == null){
		
				jLabelTipo = new JLabel();
		
			}
			return jLabelTipo;
		}
		public JLabel getjLabelBairro() {
			if(jLabelBairro == null){
		
				jLabelBairro = new JLabel();
		
			}
			return jLabelBairro;
		}
		public JLabel getjLabelTelefone() {
			if(jLabelTelefone == null){
		
				jLabelTelefone = new JLabel();
		
			}
			return jLabelTelefone;
		}	
	
		
		public JLabel getjLabelNumeroVeiculo() {
			if(jLabelNumeroVeiculo == null){
		
				jLabelNumeroVeiculo = new JLabel();
		
			}
			return jLabelNumeroVeiculo;
		}
		public JLabel getjLabelMarca() {
			if(jLabelMarca == null){
		
				jLabelMarca = new JLabel();
		
			}
			return jLabelMarca;
		}
		public JLabel getjLabelCor() {
			if(jLabelCor == null){
		
				jLabelCor = new JLabel();
		
			}
			return jLabelCor;
		}
		public JLabel getjLabelChassi() {
			if(jLabelChassi == null){
		
				jLabelChassi = new JLabel();
		
			}
			return jLabelChassi;
		}
		public JLabel getjLabelModelo() {
			if(jLabelModelo == null){
		
				jLabelModelo = new JLabel();
		
			}
			return jLabelModelo;
		}
		public JLabel getjLabelAno() {
			if(jLabelAno == null){
		
				jLabelAno = new JLabel();
		
			}
			return jLabelAno;
		}
		public JLabel getjLabelPlaca() {
			if(jLabelPlaca == null){
		
				jLabelPlaca = new JLabel();
		
			}
			return jLabelPlaca;
		}
		public JLabel getjLabelMotor() {
			if(jLabelMotor == null){
		
				jLabelMotor = new JLabel();
		
			}
			return jLabelMotor;
		}
		public JLabel getjLabelKMAtual() {
			if(jLabelKMAtual == null){
		
				jLabelKMAtual = new JLabel();
		
			}
			return jLabelKMAtual;
		}
		public JLabel getjLabelCombustivel() {
			if(jLabelCombustivel == null){
		
				jLabelCombustivel = new JLabel();
		
			}
			return jLabelCombustivel;
		}
	
		
		public JLabel getjLabelNumeroOS() {
			if(jLabelNumeroOS == null){
		
				jLabelNumeroOS = new JLabel();
		
			}
			return jLabelNumeroOS;
		}
		public JLabel getjLabelServico() {
			if(jLabelServico == null){
		
				jLabelServico = new JLabel();
		
			}
			return jLabelServico;
		}
		public JLabel getjLabelReclamacao() {
			if(jLabelReclamacao == null){
		
				jLabelReclamacao = new JLabel();
		
			}
			return jLabelReclamacao;
		}
		public JLabel getjLabelData() {
			if(jLabelData == null){
		
				jLabelData = new JLabel();
		
			}
			return jLabelData;
		}
		public JLabel getjLabelMotorista() {
			if(jLabelMotorista == null){
		
				jLabelMotorista = new JLabel();
		
			}
			return jLabelMotorista;
		}
		public JLabel getjLabelResponsavel() {
			if(jLabelResponsavel == null){
		
				jLabelResponsavel = new JLabel();
		
			}
			return jLabelResponsavel;
		}
		
		//** Fim getters JLabel **
		
		
		//** Início getters JTextField **
		public JTextField getjTFieldCpf() {
			if(jTFieldCpf == null){
		
				jTFieldCpf = new JTextField();
		
			}
			return jTFieldCpf;
		}
		public JTextField getjTFieldEmail() {
			if(jTFieldEmail == null){
		
				jTFieldEmail = new JTextField();
		
			}
			return jTFieldEmail;
		}
		public JTextField getjTFieldRua() {
			if(jTFieldRua == null){
		
				jTFieldRua = new JTextField();
		
			}
			return jTFieldRua;
		}
		public JTextField getjTFieldNome() {
			if(jTFieldNome == null){
		
				jTFieldNome = new JTextField();
		
			}
			return jTFieldNome;
		}
		public JTextField getjTFieldCidade() {
			if(jTFieldCidade == null){
		
				jTFieldCidade = new JTextField();
		
			}
			return jTFieldCidade;
		}
		public JTextField getjTFieldNumeroCasa() {
			if(jTFieldNumeroCasa == null){
		
				jTFieldNumeroCasa = new JTextField();
		
			}
			return jTFieldNumeroCasa;
		}
		public JTextField getjTFieldTipo() {
			if(jTFieldTipo == null){
		
				jTFieldTipo = new JTextField();
		
			}
			return jTFieldTipo;
		}
		public JTextField getjTFieldBairro() {
			if(jTFieldBairro == null){
		
				jTFieldBairro = new JTextField();
		
			}
			return jTFieldBairro;
		}
		public JTextField getjTFieldTelefone() {
			if(jTFieldTelefone == null){
		
				jTFieldTelefone = new JTextField();
		
			}
			return jTFieldTelefone;
		}
	
		
		public JTextField getjTFieldNumeroVeiculo() {
			if(jTFieldNumeroVeiculo == null){
		
				jTFieldNumeroVeiculo = new JTextField();
		
			}
			return jTFieldNumeroVeiculo;
		}
		public JTextField getjTFieldMarca() {
			if(jTFieldMarca == null){
		
				jTFieldMarca = new JTextField();
		
			}
			return jTFieldMarca;
		}
		public JTextField getjTFieldCor() {
			if(jTFieldCor == null){
		
				jTFieldCor = new JTextField();
		
			}
			return jTFieldCor;
		}
		public JTextField getjTFieldChassi() {
			if(jTFieldChassi == null){
		
				jTFieldChassi = new JTextField();
		
			}
			return jTFieldChassi;
		}
		public JTextField getjTFieldModelo() {
			if(jTFieldModelo == null){
		
				jTFieldModelo = new JTextField();
		
			}
			return jTFieldModelo;
		}
		public JTextField getjTFieldAno() {
			if(jTFieldAno == null){
		
				jTFieldAno = new JTextField();
		
			}
			return jTFieldAno;
		}
		public JTextField getjTFieldPlaca() {
			if(jTFieldPlaca == null){
		
				jTFieldPlaca = new JTextField();
		
			}
			return jTFieldPlaca;
		}
		public JTextField getjTFieldMotor() {
			if(jTFieldMotor == null){
		
				jTFieldMotor = new JTextField();
		
			}
			return jTFieldMotor;
		}
		public JTextField getjTFieldKMAtual() {
			if(jTFieldKMAtual == null){
		
				jTFieldKMAtual = new JTextField();
		
			}
			return jTFieldKMAtual;
		}
		public JTextField getjTFieldCombustivel() {
	
			if(jTFieldCombustivel == null){
		
				jTFieldCombustivel = new JTextField();
		
			}
			return jTFieldCombustivel;
		}
		
		
		public JTextField getjTFieldNumeroOS() {
			if(jTFieldNumeroOS == null){
		
				jTFieldNumeroOS = new JTextField();
		
			}
			return jTFieldNumeroOS;
		}
		public JTextField getjTFieldServico() {
			if(jTFieldServico == null){
		
				jTFieldServico = new JTextField();
		
			}
			return jTFieldServico;
		}
		public JTextField getjTFieldReclamacao() {
			if(jTFieldReclamacao == null){
		
				jTFieldReclamacao = new JTextField();
		
			}
			return jTFieldReclamacao;
		}
		public JTextField getjTFieldData() {
			if(jTFieldData == null){
		
				jTFieldData = new JTextField();
		
			}
			return jTFieldData;
		}
		public JTextField getjTFieldMotorista() {
			if(jTFieldMotorista == null){
		
				jTFieldMotorista = new JTextField();
		
			}
			return jTFieldMotorista;
		}
		public JTextField getjTFieldResponsavel() {
			if(jTFieldResponsavel == null){
		
				jTFieldResponsavel = new JTextField();
		
			}
			return jTFieldResponsavel;
		}
		
	//** Fim getters JTextField **
	
	//** Início métodos adição de componentes **
		void addCompJPanelGeraOS() {
			this.getJPanelGeraOS().add(getjButtonCancelar());
			this.getjButtonCancelar().setLocation(14, 21);
			
			this.getJPanelGeraOS().add(getjButtonSalvar());
			this.getjButtonSalvar().setLocation(133, 21);
			
			this.getJPanelGeraOS().add(getjButtonImprimir());
			this.getjButtonImprimir().setLocation(199, 21);
			
			this.getJPanelGeraOS().add(getjPanelCentro());
			this.getjPanelCentro().setLocation(14, 78);
			
		}
		
		void addCompJpanelCentro() {
			this.getjPanelCentro().add(getjButtonProcuraCliente());
			this.getjButtonProcuraCliente().setLocation(22, 27);
			
			this.getjPanelCentro().add(getjRadioButtonCpf());
			this.getjRadioButtonCpf().setLocation(98, 60);
			
			this.getjPanelCentro().add(getjRadioButtonCnpj());
			this.getjRadioButtonCnpj().setLocation(141, 60);
			
			
			this.getjPanelCentro().add(getjLabelCpf());
			this.getjLabelCpf().setLocation(63,77);
		}
}