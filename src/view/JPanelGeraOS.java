package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;
import javax.swing.JRadioButton;


/**
 * @author josim
 *
 */
	@SuppressWarnings("serial")
	public class JPanelGeraOS extends JPanel {
		
		public JPanelGeraOS() {
			getJPanelGeraOS();
			addCompJPanelGeraOS();
			getjPanelCentro();
			addCompJpanelCentro();
		}
	
	//** In�cio declara��o de vari�veis **
		private SetSizeIcon setSizeIcon = new SetSizeIcon();
		private String tituloDescricaoTela;
		
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
		
		private JLabel ordemServico;
		private JLabel jLabelNumeroOS;
		private JLabel jLabelServico;
		private JLabel jLabelReclamacao;
		private JLabel jLabelData;
		private JLabel jLabelMotorista;
		private JLabel jLabelResponsavel;
		
		private JFormattedTextField jTFieldCpf;
		private JTextField jTFieldEmail;
		private JTextField jTFieldRua;
		private JTextField jTFieldNome;
		private JTextField jTFieldCidade;
		private JTextField jTFieldNumeroCasa;
		private Choice choiceTipo;
		private JTextField jTFieldBairro;
		private JFormattedTextField jTFieldTelefone;
		
		private JTextField jTFieldNumeroVeiculo;
		private JTextField jTFieldMarca;
		private JTextField jTFieldCor;
		private JFormattedTextField jTFieldChassi;
		private JTextField jTFieldModelo;
		private JFormattedTextField jTFieldAno;
		private JFormattedTextField jTFieldPlaca;
		private JTextField jTFieldMotor;
		private JFormattedTextField jTFieldKMAtual;
		private JTextField jTFieldCombustivel;
		
		private JTextField jTFieldNumeroOS;
		private JTextField jTFieldServico;
		private JTextField jTFieldReclamacao;
		private JFormattedTextField jTFieldData;
		private JTextField jTFieldMotorista;
		private JComboBox<String> jComboBoxResponsavel;
		
	//** Fim declara��o de vari�veis **

	
	//** In�cio getters JPanels **
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
				jPanelCentro.setSize(new Dimension(990, 568));
				jPanelCentro.setVisible(true);
				jPanelCentro.setBackground(Cores.branco);
		
			}
			return jPanelCentro;
		}
		
	//** Fim getters JPanel **
	
	
	//** In�cio getters JButon **


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
				jButtonSelecionarVeiculo.setFont(Fontes.fontJButtonPlain3);			
				jButtonSelecionarVeiculo.setBackground(Cores.azul1);
				jButtonSelecionarVeiculo.setForeground(Color.white);
				jButtonSelecionarVeiculo.setText("Seleciona Ve�culo");
				jButtonSelecionarVeiculo.setSize(169,25);
				jButtonSelecionarVeiculo.setFocusable(false);
				jButtonSelecionarVeiculo.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1));
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
	
	
	//** In�cio getters JLabel **
	


		public JLabel getjLabelCpf() {
				if(jLabelCpf == null){
			
					jLabelCpf = new JLabel("CPF:");
					jLabelCpf.setFont(Fontes.fontJLabelPlain1);
					jLabelCpf.setSize(30, 21);
					jLabelCpf.setForeground(Cores.preto);
					jLabelCpf.setOpaque(false);
					
				}
				return jLabelCpf;
		}	
		public JLabel getjLabelEmail() {
			if(jLabelEmail == null){
		
				jLabelEmail = new JLabel("Email:");
				jLabelEmail.setFont(Fontes.fontJLabelPlain1);
				jLabelEmail.setSize(41, 21);
				jLabelEmail.setForeground(Cores.preto);
				jLabelEmail.setOpaque(false);
			}
			return jLabelEmail;
		}	
		public JLabel getjLabelRua() {
			if(jLabelRua == null){
		
				jLabelRua = new JLabel("Rua:");
				jLabelRua.setFont(Fontes.fontJLabelPlain1);
				jLabelRua.setSize(30, 21);
				jLabelRua.setForeground(Cores.preto);
				jLabelRua.setOpaque(false);
			}
			return jLabelRua;
		}	
		public JLabel getjLabelNome() {
			if(jLabelNome == null){
		
				jLabelNome = new JLabel("Nome:");
				jLabelNome.setFont(Fontes.fontJLabelPlain1);
				jLabelNome.setSize(47, 21);
				jLabelNome.setForeground(Cores.preto);
				jLabelNome.setOpaque(false);
			}
			return jLabelNome;
		}	
		public JLabel getjLabelCidade() {
			if(jLabelCidade == null){
		
				jLabelCidade = new JLabel("Cidade:");
				jLabelCidade.setSize(65, 21);
				jLabelCidade.setFont(Fontes.fontJLabelPlain1);
				jLabelCidade.setForeground(Cores.preto);
				jLabelCidade.setOpaque(false);
			}
			return jLabelCidade;
		}	
		public JLabel getjLabelNumeroCasa() {
			if(jLabelNumeroCasa == null){
		
				jLabelNumeroCasa = new JLabel("N� Casa:");
				jLabelNumeroCasa.setFont(Fontes.fontJLabelPlain1);
				jLabelNumeroCasa.setSize(60, 21);
				jLabelNumeroCasa.setForeground(Cores.preto);
				jLabelNumeroCasa.setOpaque(false);
			}
			return jLabelNumeroCasa;
		}	
		public JLabel getjLabelTipo() {
			if(jLabelTipo == null){
		
				jLabelTipo = new JLabel("Tipo:");
				jLabelTipo.setFont(Fontes.fontJLabelPlain1);
				jLabelTipo.setSize(35, 21);
				jLabelTipo.setForeground(Cores.preto);
				jLabelTipo.setOpaque(false);
			}
			return jLabelTipo;
		}
		public JLabel getjLabelBairro() {
			if(jLabelBairro == null){
		
				jLabelBairro = new JLabel("Bairro:");
				jLabelBairro.setSize(45, 21);
				jLabelBairro.setFont(Fontes.fontJLabelPlain1);
				jLabelBairro.setForeground(Cores.preto);
				jLabelBairro.setOpaque(false);
			}
			return jLabelBairro;
		}
		public JLabel getjLabelTelefone() {
			if(jLabelTelefone == null){
		
				jLabelTelefone = new JLabel("Telefone:");
				jLabelTelefone.setFont(Fontes.fontJLabelPlain1);
				jLabelTelefone.setSize(63, 21);
				jLabelTelefone.setForeground(Cores.preto);
				jLabelTelefone.setOpaque(false);
			}
			return jLabelTelefone;
		}	
	
		
		public JLabel getjLabelNumeroVeiculo() {
			if(jLabelNumeroVeiculo == null){
		
				jLabelNumeroVeiculo = new JLabel("N�:");
				jLabelNumeroVeiculo.setFont(Fontes.fontJLabelPlain1);
				jLabelNumeroVeiculo.setSize(22, 21);
				jLabelNumeroVeiculo.setForeground(Cores.preto);
				jLabelNumeroVeiculo.setOpaque(false);
			}
			return jLabelNumeroVeiculo;
		}
		public JLabel getjLabelMarca() {
			if(jLabelMarca == null){
		
				jLabelMarca = new JLabel("Marca:");
				jLabelMarca.setFont(Fontes.fontJLabelPlain1);
				jLabelMarca.setSize(47, 21);
				jLabelMarca.setForeground(Cores.preto);
				jLabelMarca.setOpaque(false);
			}
			return jLabelMarca;
		}
		public JLabel getjLabelCor() {
			if(jLabelCor == null){
		
				jLabelCor = new JLabel("Cor:");
				jLabelCor.setFont(Fontes.fontJLabelPlain1);
				jLabelCor.setSize(28, 21);
				jLabelCor.setForeground(Cores.preto);
				jLabelCor.setOpaque(false);
			}
			return jLabelCor;
		}
		public JLabel getjLabelChassi() {
			if(jLabelChassi == null){
		
				jLabelChassi = new JLabel("Chassi:");
				jLabelChassi.setFont(Fontes.fontJLabelPlain1);
				jLabelChassi.setSize(48, 21);
				jLabelChassi.setForeground(Cores.preto);
				jLabelChassi.setOpaque(false);
			}
			return jLabelChassi;
		}
		public JLabel getjLabelModelo() {
			if(jLabelModelo == null){
		
				jLabelModelo = new JLabel("Modelo:");
				jLabelModelo.setFont(Fontes.fontJLabelPlain1);
				jLabelModelo.setSize(58, 21);
				jLabelModelo.setForeground(Cores.preto);
				jLabelModelo.setOpaque(false);
			}
			return jLabelModelo;
		}
		public JLabel getjLabelAno() {
			if(jLabelAno == null){
		
				jLabelAno = new JLabel("Ano:");
				jLabelAno.setFont(Fontes.fontJLabelPlain1);
				jLabelAno.setSize(32, 21);
				jLabelAno.setForeground(Cores.preto);
				jLabelAno.setOpaque(false);
			}
			return jLabelAno;
		}
		public JLabel getjLabelPlaca() {
			if(jLabelPlaca == null){
		
				jLabelPlaca = new JLabel("Placa:");
				jLabelPlaca.setFont(Fontes.fontJLabelPlain1);
				jLabelPlaca.setSize(40, 21);
				jLabelPlaca.setForeground(Cores.preto);
				jLabelPlaca.setOpaque(false);
			}
			return jLabelPlaca;
		}
		public JLabel getjLabelMotor() {
			if(jLabelMotor == null){
		
				jLabelMotor = new JLabel("Motor:");
				jLabelMotor.setFont(Fontes.fontJLabelPlain1);
				jLabelMotor.setSize(48, 21);
				jLabelMotor.setForeground(Cores.preto);
				jLabelMotor.setOpaque(false);
			}
			return jLabelMotor;
		}
		public JLabel getjLabelKMAtual() {
			if(jLabelKMAtual == null){
		
				jLabelKMAtual = new JLabel("Km atual:");
				jLabelKMAtual.setFont(Fontes.fontJLabelPlain1);
				jLabelKMAtual.setSize(66, 21);
				jLabelKMAtual.setForeground(Cores.preto);
				jLabelKMAtual.setOpaque(false);
			}
			return jLabelKMAtual;
		}
		public JLabel getjLabelCombustivel() {
			if(jLabelCombustivel == null){
		
				jLabelCombustivel = new JLabel("Combust�vel:");
				jLabelCombustivel.setFont(Fontes.fontJLabelPlain1);
				jLabelCombustivel.setSize(91, 21);
				jLabelCombustivel.setForeground(Cores.preto);
				jLabelCombustivel.setOpaque(false);
			}
			return jLabelCombustivel;
		}
	
		public JLabel getOrdemServico() {
			if(ordemServico == null){
		
				ordemServico = new JLabel("Ordem de Sevi�o");
				ordemServico.setFont(Fontes.fontJLabelBold2);
				ordemServico.setSize(160, 27);
				ordemServico.setBackground(Cores.branco);
				ordemServico.setForeground(Cores.azul1);
				ordemServico.setOpaque(false);
			}
			return ordemServico;
		}
		
		public JLabel getjLabelNumeroOS() {
			if(jLabelNumeroOS == null){
		
				jLabelNumeroOS = new JLabel("N�:");
				jLabelNumeroOS.setFont(Fontes.fontJLabelPlain1);
				jLabelNumeroOS.setSize(22, 21);
				jLabelNumeroOS.setForeground(Cores.preto);
				jLabelNumeroOS.setOpaque(false);
			}
			return jLabelNumeroOS;
		}
		public JLabel getjLabelServico() {
			if(jLabelServico == null){
		
				jLabelServico = new JLabel("Servi�o:");
				jLabelServico.setFont(Fontes.fontJLabelPlain1);
				jLabelServico.setSize(55, 21);
				jLabelServico.setForeground(Cores.preto);
				jLabelServico.setOpaque(false);
			}
			return jLabelServico;
		}
		public JLabel getjLabelReclamacao() {
			if(jLabelReclamacao == null){
		
				jLabelReclamacao = new JLabel("Reclama��o:");
				jLabelReclamacao.setFont(Fontes.fontJLabelPlain1);
				jLabelReclamacao.setSize(87, 21);
				jLabelReclamacao.setForeground(Cores.preto);
				jLabelReclamacao.setOpaque(false);
			}
			return jLabelReclamacao;
		}
		public JLabel getjLabelData() {
			if(jLabelData == null){
		
				jLabelData = new JLabel("Data:");
				jLabelData.setFont(Fontes.fontJLabelPlain1);
				jLabelData.setSize(36, 21);
				jLabelData.setForeground(Cores.preto);
				jLabelData.setOpaque(false);
			}
			return jLabelData;
		}
		public JLabel getjLabelMotorista() {
			if(jLabelMotorista == null){
		
				jLabelMotorista = new JLabel("Motorista:");
				jLabelMotorista.setFont(Fontes.fontJLabelPlain1);
				jLabelMotorista.setSize(72, 21);
				jLabelMotorista.setForeground(Cores.preto);
				jLabelMotorista.setOpaque(false);
			}
			return jLabelMotorista;
		}
		public JLabel getjLabelResponsavel() {
			if(jLabelResponsavel == null){
		
				jLabelResponsavel = new JLabel("Respons�vel:");
				jLabelResponsavel.setFont(Fontes.fontJLabelPlain1);
				jLabelResponsavel.setSize(90, 21);
				jLabelResponsavel.setForeground(Cores.preto);
				jLabelResponsavel.setOpaque(false);
			}
			return jLabelResponsavel;
		}
		
		//** Fim getters JLabel **
		
		
		//** In�cio getters JTextField **
		public JFormattedTextField getjTFieldCpf() {
			if(jTFieldCpf == null){
				
				jTFieldCpf = new JFormattedTextField();
				jTFieldCpf.setSize(165, 21);
				jTFieldCpf.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1, false));
				jTFieldCpf.setForeground(Cores.preto);
				jTFieldCpf.setFont(Fontes.fontJTFieldPlain1);
				jTFieldCpf.setOpaque(true);

				
			}
			return jTFieldCpf;
		}
		public JTextField getjTFieldEmail() {
			if(jTFieldEmail == null){
		
				jTFieldEmail = new JTextField();
				jTFieldEmail.setSize(149, 21);
				jTFieldEmail.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1, false));
				jTFieldEmail.setForeground(Cores.preto);
				jTFieldEmail.setFont(Fontes.fontJTFieldPlain1);
				jTFieldEmail.setOpaque(true);
			}
			return jTFieldEmail;
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
		public JTextField getjTFieldNome() {
			
			if(jTFieldNome == null){
		
				jTFieldNome = new JTextField("Jos� da Silva");
				jTFieldNome.setSize(219, 21);
				jTFieldNome.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldNome.setForeground(Cores.preto);
				jTFieldNome.setFont(Fontes.fontJTFieldPlain1);
				jTFieldNome.setOpaque(true);
			}
			return jTFieldNome;
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
		public Choice getchoiceTipo() {
			if(choiceTipo == null){
		
				choiceTipo = new Choice();
				choiceTipo.setSize(92, 21);
				choiceTipo.setForeground(Cores.preto);
				choiceTipo.setFont(Fontes.fontJTFieldPlain1);
				choiceTipo.setFocusable(true);
				choiceTipo.add("F�sica");
				choiceTipo.add("Jur�dica");
			}
			return choiceTipo;
		}
		public JTextField getjTFieldBairro() {
			if(jTFieldBairro == null){
		
				jTFieldBairro = new JTextField();
				jTFieldBairro.setSize(91, 21);
				jTFieldBairro.setBorder(BorderFactory.
						createLineBorder(Cores.cinza2, 1, false));
				jTFieldBairro.setForeground(Cores.preto);
				jTFieldBairro.setFont(Fontes.fontJTFieldPlain1);
				jTFieldBairro.setOpaque(true);
			}
			return jTFieldBairro;
		}
		public JFormattedTextField getjTFieldTelefone() {
			if(jTFieldTelefone == null){
		
				jTFieldTelefone = new JFormattedTextField();
				jTFieldTelefone.setSize(115, 21);
				jTFieldTelefone.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldTelefone.setForeground(Cores.preto);
				jTFieldTelefone.setFont(Fontes.fontJTFieldPlain1);
				jTFieldTelefone.setOpaque(true);
			}
			return jTFieldTelefone;
		}
	
		
		public JTextField getjTFieldNumeroVeiculo() {
			if(jTFieldNumeroVeiculo == null){
		
				jTFieldNumeroVeiculo = new JTextField();
				jTFieldNumeroVeiculo.setSize(105, 21);
				jTFieldNumeroVeiculo.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldNumeroVeiculo.setForeground(Cores.preto);
				jTFieldNumeroVeiculo.setFont(Fontes.fontJTFieldPlain1);
				jTFieldNumeroVeiculo.setOpaque(true);
			}
			return jTFieldNumeroVeiculo;
		}
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
				jTFieldAno.setSize(105, 21);
				jTFieldAno.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldAno.setForeground(Cores.preto);
				jTFieldAno.setFont(Fontes.fontJTFieldPlain1);
				jTFieldAno.setOpaque(true);
			}
			return jTFieldAno;
		}
		public JFormattedTextField getjTFieldPlaca() {
			if(jTFieldPlaca == null){
		
				jTFieldPlaca = new JFormattedTextField();
				jTFieldPlaca.setSize(125, 21);
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
				jTFieldMotor.setSize(125, 21);
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
		public JTextField getjTFieldCombustivel() {//pode ser pudado para jcombobox!
	
			if(jTFieldCombustivel == null){
		
				jTFieldCombustivel = new JTextField();
				jTFieldCombustivel.setSize(125, 21);
				jTFieldCombustivel.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldCombustivel.setForeground(Cores.preto);
				jTFieldCombustivel.setFont(Fontes.fontJTFieldPlain1);
				jTFieldCombustivel.setOpaque(true);
			}
			return jTFieldCombustivel;
		}
		
		
		public JTextField getjTFieldNumeroOS() {
			if(jTFieldNumeroOS == null){
		
				jTFieldNumeroOS = new JTextField();
				jTFieldNumeroOS.setSize(165, 21);
				jTFieldNumeroOS.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldNumeroOS.setForeground(Cores.preto);
				jTFieldNumeroOS.setFont(Fontes.fontJTFieldPlain1);
				jTFieldNumeroOS.setOpaque(true);
			}
			return jTFieldNumeroOS;
		}
		public JTextField getjTFieldServico() {
			if(jTFieldServico == null){
		
				jTFieldServico = new JTextField();
				jTFieldServico.setSize(627, 21);
				jTFieldServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldServico.setForeground(Cores.preto);
				jTFieldServico.setFont(Fontes.fontJTFieldPlain1);
				jTFieldServico.setOpaque(true);
			}
			return jTFieldServico;
		}
		public JTextField getjTFieldReclamacao() {
			if(jTFieldReclamacao == null){
		
				jTFieldReclamacao = new JTextField();
				jTFieldReclamacao.setSize(627, 85);
				jTFieldReclamacao.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldReclamacao.setForeground(Cores.preto);
				jTFieldReclamacao.setFont(Fontes.fontJTFieldPlain1);
				jTFieldReclamacao.setOpaque(true);
			}
			return jTFieldReclamacao;
		}
		public JTextField getjTFieldData() {
			if(jTFieldData == null){
		
				jTFieldData = new JFormattedTextField();
				jTFieldData.setSize(131, 21);
				jTFieldData.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldData.setForeground(Cores.preto);
				jTFieldData.setFont(Fontes.fontJTFieldPlain1);
				jTFieldData.setOpaque(true);
			}
			return jTFieldData;
		}
		public JTextField getjTFieldMotorista() {
			if(jTFieldMotorista == null){
		
				jTFieldMotorista = new JTextField();
				jTFieldMotorista.setSize(115, 21);
				jTFieldMotorista.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jTFieldMotorista.setForeground(Cores.preto);
				jTFieldMotorista.setFont(Fontes.fontJTFieldPlain1);
				jTFieldMotorista.setOpaque(true);
			}
			return jTFieldMotorista;
		}
		
	//** Fim getters JTextField **
		
		
	//** In�cio getters JComboBox **
		
		public JComboBox<String> getjComboBoxResponsavel() {
			if(jComboBoxResponsavel == null){
		
				jComboBoxResponsavel = new JComboBox<String>();
				jComboBoxResponsavel.setSize(89, 21);
				jComboBoxResponsavel.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1, false));
				jComboBoxResponsavel.setForeground(Cores.preto);
				jComboBoxResponsavel.setFont(Fontes.fontJTFieldPlain1);
				jComboBoxResponsavel.setOpaque(true);
				jComboBoxResponsavel.addItem("Pedro");
			}
			return jComboBoxResponsavel;
		}
	
	//** Fim getters JComboBox **
		
		
	//** In�cio m�todos adi��o de componentes **
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
		
		/*return newdfha tituloDescricaoTela;
		*/
		public String getTituloDescricaoTela() {
			if(tituloDescricaoTela == null){
		
				tituloDescricaoTela = "Gera OS";
		
			}
			return tituloDescricaoTela;
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
			
			this.getjPanelCentro().add(getjTFieldCpf());
			this.getjTFieldCpf().setLocation(97, 77);
			
			this.getjPanelCentro().add(getjLabelNome());
			this.getjLabelNome().setLocation(303, 77);
			
			this.getjPanelCentro().add(getjTFieldNome());
			this.getjTFieldNome().setLocation(354, 77);
			
			this.getjPanelCentro().add(getjLabelTipo());
			this.getjLabelTipo().setLocation(613, 77);
			
			this.getjPanelCentro().add(getchoiceTipo());
			this.getchoiceTipo().setLocation(656, 77);
			
			this.getjPanelCentro().add(getjLabelTelefone());
			this.getjLabelTelefone().setLocation(754, 77);
			
			this.getjPanelCentro().add(getjTFieldTelefone());
			this.getjTFieldTelefone().setLocation(825, 77);
			
			
			this.getjPanelCentro().add(getjLabelEmail());
			this.getjLabelEmail().setLocation(52, 111);
			
			this.getjPanelCentro().add(getjTFieldEmail());
			this.getjTFieldEmail().setLocation(101, 111);
			
			this.getjPanelCentro().add(getjLabelCidade());
			this.getjLabelCidade().setLocation(297, 111);
			
			this.getjPanelCentro().add(getjTFieldCidade());
			this.getjTFieldCidade().setLocation(354, 111);
			
			this.getjPanelCentro().add(getjLabelBairro());
			this.getjLabelBairro().setLocation(603, 111);
			
			this.getjPanelCentro().add(getjTFieldBairro());
			this.getjTFieldBairro().setLocation(656, 111);
		
			this.getjPanelCentro().add(getjLabelRua());
			this.getjLabelRua().setLocation(65, 145);
			
			this.getjPanelCentro().add(getjTFieldRua());
			this.getjTFieldRua().setLocation(97, 145);
			
			this.getjPanelCentro().add(getjLabelNumeroCasa());
			this.getjLabelNumeroCasa().setLocation(290, 145);
			
			this.getjPanelCentro().add(getjTFieldNumeroCasa());
			this.getjTFieldNumeroCasa().setLocation(354, 145);
			
			this.getjPanelCentro().add(getjButtonSelecionarVeiculo());
			this.getjButtonSelecionarVeiculo().setLocation(22, 182);
			
			this.getjPanelCentro().add(getjLabelNumeroVeiculo());
			this.getjLabelNumeroVeiculo().setLocation(71, 224);
		
			this.getjPanelCentro().add(getjLabelMarca());
			this.getjLabelMarca().setLocation(46, 258);
			
			this.getjPanelCentro().add(getjLabelCor());
			this.getjLabelCor().setLocation(63, 292);
		
			this.getjPanelCentro().add(getjLabelChassi());
			this.getjLabelChassi().setLocation(242, 224);
			
			this.getjPanelCentro().add(getjLabelModelo());
			this.getjLabelModelo().setLocation(231, 258);
			
			this.getjPanelCentro().add(getjLabelAno());
			this.getjLabelAno().setLocation(257, 292);
			
			this.getjPanelCentro().add(getjLabelPlaca());
			this.getjLabelPlaca().setLocation(553, 224);
			
			this.getjPanelCentro().add(getjLabelMotor());
			this.getjLabelMotor().setLocation(544, 258);
			
			this.getjPanelCentro().add(getjLabelKMAtual());
			this.getjLabelKMAtual().setLocation(758, 224);
			
			this.getjPanelCentro().add(getjLabelCombustivel());
			this.getjLabelCombustivel().setLocation(733, 258);
		
			this.getjPanelCentro().add(getjTFieldNumeroVeiculo());
			this.getjTFieldNumeroVeiculo().setLocation(97, 224);
			
			this.getjPanelCentro().add(getjTFieldMarca());
			this.getjTFieldMarca().setLocation(97, 258);
			
			this.getjPanelCentro().add(getjTFieldCor());
			this.getjTFieldCor().setLocation(97, 292);
			
			this.getjPanelCentro().add(getjTFieldChassi());
			this.getjTFieldChassi().setLocation(294, 224);
			
			this.getjPanelCentro().add(getjTFieldModelo());
			this.getjTFieldModelo().setLocation(294, 258);
	
			this.getjPanelCentro().add(getjTFieldAno());
			this.getjTFieldAno().setLocation(294, 292);
			
			this.getjPanelCentro().add(getjTFieldPlaca());
			this.getjTFieldPlaca().setLocation(597, 224);
			
			this.getjPanelCentro().add(getjTFieldMotor());
			this.getjTFieldMotor().setLocation(597, 258);
			
			this.getjPanelCentro().add(getjTFieldKMAtual());
			this.getjTFieldKMAtual().setLocation(829, 224);
			
			this.getjPanelCentro().add(getjTFieldCombustivel());
			this.getjTFieldCombustivel().setLocation(829, 258);
			
			this.getjPanelCentro().add(getOrdemServico());
			this.getOrdemServico().setLocation(21, 329);
			
			this.getjPanelCentro().add(getjLabelNumeroOS());
			this.getjLabelNumeroOS().setLocation(70, 370);
			
			this.getjPanelCentro().add(getjLabelServico());
			this.getjLabelServico().setLocation(38, 404);
			
			this.getjPanelCentro().add(getjLabelReclamacao());
			this.getjLabelReclamacao().setLocation(99, 439);
			
			this.getjPanelCentro().add(getjLabelData());
			this.getjLabelData().setLocation(312, 370);
			
			this.getjPanelCentro().add(getjLabelMotorista());
			this.getjLabelMotorista().setLocation(533, 370);
			
			this.getjPanelCentro().add(getjLabelResponsavel());
			this.getjLabelResponsavel().setLocation(773, 370);
			
			this.getjPanelCentro().add(getjTFieldNumeroOS());
			this.getjTFieldNumeroOS().setLocation(96, 370);
			
			this.getjPanelCentro().add(getjTFieldServico());
			this.getjTFieldServico().setLocation(96, 404);
			
			this.getjPanelCentro().add(getjTFieldReclamacao());
			this.getjTFieldReclamacao().setLocation(96, 464);
			
			this.getjPanelCentro().add(getjTFieldData());
			this.getjTFieldData().setLocation(352, 370);
			
			this.getjPanelCentro().add(getjTFieldMotorista());
			this.getjTFieldMotorista().setLocation(611, 370);
			
			this.getjPanelCentro().add(getjComboBoxResponsavel());
			this.getjComboBoxResponsavel().setLocation(867, 370);
			
		}
}