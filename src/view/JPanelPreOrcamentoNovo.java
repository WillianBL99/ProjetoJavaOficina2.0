/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
public class JPanelPreOrcamentoNovo extends JPanel {
	

    //** In�cio declara��o de vari�veis **
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // t�tulo que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JPanel jPanelCentro;
	
	private JButton jButtonCancelar;
	private JButton jButtonSalvar;
	private JButton jButtonImprimir;
	private JButton jButtonProcuraCliente;
	private JButton jButtonSelecionarVeiculo;
	
	private JButton jButtonListaProdutos;
	private JButton jButtonListaServicos;
	
	private JButton jButtonAdicionarProdutoServico;
	private JButton jButtonEditarProdutoServico;
	private JButton jButtonApagarProdutoServico;
	
	
	private JRadioButton jRadioButtonCpf;
	private JRadioButton jRadioButtonCnpj;
	
	
	private JLabel jLabelDadosPreOrcamento;
	private JLabel jLabelNumeroPreOrcamento;
	private JLabel jLabelDataPreOrcamento;
	private JLabel jLabelHorarioPreOrcamento;
	private JLabel jLabelResponsavelPreOrcamento;
	
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
	

	private JTextField jTFieldNumeroPreOrcamento;
	private JTextField jTFieldDataPreOrcamento;
	private JTextField jTFieldHorarioPreOrcamento;
	private JTextField jTFieldResponsavelPreOrcamento;
	
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
	
	private JScrollPane JSPListaProdutoServico;
	private JTable jTableListaProdutoServico;
	
    //** Fim declara��o de vari�veis **


	public JPanelPreOrcamentoNovo() {
		getJPanelPreOrcamentoNovo();
		addCompJPanelPreOrcamentoNovo();
		addCompJpanelCentro();
	}
	
	
    //** In�cio getters JPanels **
	
	public JPanelPreOrcamentoNovo getJPanelPreOrcamentoNovo() {		
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
			jPanelCentro.setSize(new Dimension(950, 568));
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
	
	
	public JButton getjButtonListaProdutos() {
		if(jButtonListaProdutos == null){			
			jButtonListaProdutos = new JButton();
			jButtonListaProdutos.setFont(Fontes.fontJButtonPlain3);			
			jButtonListaProdutos.setBackground(Cores.azul1);
			jButtonListaProdutos.setForeground(Color.white);
			jButtonListaProdutos.setText("Seleciona Ve�culo");
			jButtonListaProdutos.setSize(169,25);
			jButtonListaProdutos.setFocusable(false);
			jButtonListaProdutos.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonListaProdutos;
	}


	public JButton getjButtonListaServicos() {
		if(jButtonListaServicos == null){		
			jButtonListaServicos = new JButton();
			jButtonListaServicos.setFont(Fontes.fontJButtonPlain3);			
			jButtonListaServicos.setBackground(Cores.azul1);
			jButtonListaServicos.setForeground(Color.white);
			jButtonListaServicos.setText("Seleciona Ve�culo");
			jButtonListaServicos.setSize(169,25);
			jButtonListaServicos.setFocusable(false);
			jButtonListaServicos.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonListaServicos;
	}


	public JButton getjButtonAdicionarProdutoServico() {
		if(jButtonAdicionarProdutoServico == null){		
			jButtonAdicionarProdutoServico = new JButton();
			jButtonAdicionarProdutoServico.setFont(Fontes.fontJButtonPlain3);			
			jButtonAdicionarProdutoServico.setBackground(Cores.azul1);
			jButtonAdicionarProdutoServico.setForeground(Color.white);
			jButtonAdicionarProdutoServico.setText("Seleciona Ve�culo");
			jButtonAdicionarProdutoServico.setSize(169,25);
			jButtonAdicionarProdutoServico.setFocusable(false);
			jButtonAdicionarProdutoServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonAdicionarProdutoServico;
	}


	public JButton getjButtonEditarProdutoServico() {
		if(jButtonEditarProdutoServico == null){		
			jButtonEditarProdutoServico = new JButton();
			jButtonEditarProdutoServico.setFont(Fontes.fontJButtonPlain3);			
			jButtonEditarProdutoServico.setBackground(Cores.azul1);
			jButtonEditarProdutoServico.setForeground(Color.white);
			jButtonEditarProdutoServico.setText("Seleciona Ve�culo");
			jButtonEditarProdutoServico.setSize(169,25);
			jButtonEditarProdutoServico.setFocusable(false);
			jButtonEditarProdutoServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonEditarProdutoServico;
	}


	public JButton getjButtonApagarProdutoServico() {
		if(jButtonApagarProdutoServico == null){		
			jButtonApagarProdutoServico = new JButton();
			jButtonApagarProdutoServico.setFont(Fontes.fontJButtonPlain3);			
			jButtonApagarProdutoServico.setBackground(Cores.azul1);
			jButtonApagarProdutoServico.setForeground(Color.white);
			jButtonApagarProdutoServico.setText("Seleciona Ve�culo");
			jButtonApagarProdutoServico.setSize(169,25);
			jButtonApagarProdutoServico.setFocusable(false);
			jButtonApagarProdutoServico.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonApagarProdutoServico;
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
	public JLabel getjLabelDadosPreOrcamento() {
		if(jLabelDadosPreOrcamento == null){
			jLabelDadosPreOrcamento = new JLabel("N� Casa:");
			jLabelDadosPreOrcamento.setFont(Fontes.fontJLabelPlain1);
			jLabelDadosPreOrcamento.setSize(60, 21);
			jLabelDadosPreOrcamento.setForeground(Cores.preto);
			jLabelDadosPreOrcamento.setOpaque(false);
		}
		return jLabelDadosPreOrcamento;
	}


	public JLabel getjLabelNumeroPreOrcamento() {
		if(jLabelNumeroPreOrcamento == null){
			jLabelNumeroPreOrcamento = new JLabel("N� Casa:");
			jLabelNumeroPreOrcamento.setFont(Fontes.fontJLabelPlain1);
			jLabelNumeroPreOrcamento.setSize(60, 21);
			jLabelNumeroPreOrcamento.setForeground(Cores.preto);
			jLabelNumeroPreOrcamento.setOpaque(false);
		}
		return jLabelNumeroPreOrcamento;
	}


	public JLabel getjLabelDataPreOrcamento() {
		if(jLabelDataPreOrcamento == null){
			jLabelDataPreOrcamento = new JLabel("N� Casa:");
			jLabelDataPreOrcamento.setFont(Fontes.fontJLabelPlain1);
			jLabelDataPreOrcamento.setSize(60, 21);
			jLabelDataPreOrcamento.setForeground(Cores.preto);
			jLabelDataPreOrcamento.setOpaque(false);
		}
		return jLabelDataPreOrcamento;
	}


	public JLabel getjLabelHorarioPreOrcamento() {
		if(jLabelHorarioPreOrcamento == null){
			jLabelHorarioPreOrcamento = new JLabel("N� Casa:");
			jLabelHorarioPreOrcamento.setFont(Fontes.fontJLabelPlain1);
			jLabelHorarioPreOrcamento.setSize(60, 21);
			jLabelHorarioPreOrcamento.setForeground(Cores.preto);
			jLabelHorarioPreOrcamento.setOpaque(false);
		}
		return jLabelHorarioPreOrcamento;
	}


	public JLabel getjLabelResponsavelPreOrcamento() {
		if(jLabelResponsavelPreOrcamento == null){
			jLabelResponsavelPreOrcamento = new JLabel("N� Casa:");
			jLabelResponsavelPreOrcamento.setFont(Fontes.fontJLabelPlain1);
			jLabelResponsavelPreOrcamento.setSize(60, 21);
			jLabelResponsavelPreOrcamento.setForeground(Cores.preto);
			jLabelResponsavelPreOrcamento.setOpaque(false);
		}
		return jLabelResponsavelPreOrcamento;
	}


	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Novo Pr� Or�amento";	
		}
		return tituloDescricaoTela;
	}
	

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

	
	
	//** Fim getters JLabel **
	
	
	//** In�cio getters JTextField **
	
	
	public JTextField getjTFieldCpf() {
		if(jTFieldCpf == null){	
			jTFieldCpf = new JTextField("999.999.999-99");
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
	
	
	public JTextField getjTFieldTipo() {
		if(jTFieldTipo == null){	
			jTFieldTipo = new JTextField("Fisica");
			jTFieldTipo.setSize(53, 21);
			jTFieldTipo.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTFieldTipo.setForeground(Cores.preto);
			jTFieldTipo.setFont(Fontes.fontJTFieldPlain1);
			jTFieldTipo.setOpaque(true);
		}
		return jTFieldTipo;
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
	
	
	public JTextField getjTFieldTelefone() {
		if(jTFieldTelefone == null){	
			jTFieldTelefone = new JTextField("(77) 9 9999-9999");
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
	
	
	public JTextField getjTFieldChassi() {
		if(jTFieldChassi == null){	
			jTFieldChassi = new JTextField();
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
	
	
	public JTextField getjTFieldAno() {
		if(jTFieldAno == null){	
			jTFieldAno = new JTextField();
			jTFieldAno.setSize(105, 21);
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
			jTFieldPlaca = new JTextField();
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
	
	
	public JTextField getjTFieldKMAtual() {
		if(jTFieldKMAtual == null){	
			jTFieldKMAtual = new JTextField();
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
	
	
	public JTextField getjTFieldNumeroPreOrcamento() {
		if(jTFieldNumeroPreOrcamento == null){
			jTFieldNumeroPreOrcamento = new JTextField();
			jTFieldNumeroPreOrcamento.setSize(125, 21);
			jTFieldNumeroPreOrcamento.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTFieldNumeroPreOrcamento.setForeground(Cores.preto);
			jTFieldNumeroPreOrcamento.setFont(Fontes.fontJTFieldPlain1);
			jTFieldNumeroPreOrcamento.setOpaque(true);
		}
		return jTFieldNumeroPreOrcamento;
	}


	public JTextField getjTFieldDataPreOrcamento() {
		if(jTFieldDataPreOrcamento == null){
			jTFieldDataPreOrcamento = new JTextField();
			jTFieldDataPreOrcamento.setSize(125, 21);
			jTFieldDataPreOrcamento.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTFieldDataPreOrcamento.setForeground(Cores.preto);
			jTFieldDataPreOrcamento.setFont(Fontes.fontJTFieldPlain1);
			jTFieldDataPreOrcamento.setOpaque(true);
		}
		return jTFieldDataPreOrcamento;
	}


	public JTextField getjTFieldHorarioPreOrcamento() {
		if(jTFieldHorarioPreOrcamento == null){
			jTFieldHorarioPreOrcamento = new JTextField();
			jTFieldHorarioPreOrcamento.setSize(125, 21);
			jTFieldHorarioPreOrcamento.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTFieldHorarioPreOrcamento.setForeground(Cores.preto);
			jTFieldHorarioPreOrcamento.setFont(Fontes.fontJTFieldPlain1);
			jTFieldHorarioPreOrcamento.setOpaque(true);
		}
		return jTFieldHorarioPreOrcamento;
	}


	public JTextField getjTFieldResponsavelPreOrcamento() {
		if(jTFieldResponsavelPreOrcamento == null){
			jTFieldResponsavelPreOrcamento = new JTextField();
			jTFieldResponsavelPreOrcamento.setSize(125, 21);
			jTFieldResponsavelPreOrcamento.setBorder(BorderFactory.
				createLineBorder(Cores.cinza2, 1, false));
			jTFieldResponsavelPreOrcamento.setForeground(Cores.preto);
			jTFieldResponsavelPreOrcamento.setFont(Fontes.fontJTFieldPlain1);
			jTFieldResponsavelPreOrcamento.setOpaque(true);
		}
		return jTFieldResponsavelPreOrcamento;
	}
	
	
    //** Fim getters JTextField **
	
	
	//** In�cio getters JScrollPane/JTable **

	public JScrollPane getJSPListaProdutoServico() {
		if(JSPListaProdutoServico == null){
			JSPListaProdutoServico = new JScrollPane();
			JSPListaProdutoServico.setViewportView(getjTableListaProdutoServico());
			JSPListaProdutoServico.setSize(990, 225);	
		}
		return JSPListaProdutoServico;
	}


	public JTable getjTableListaProdutoServico() {
		if(jTableListaProdutoServico == null){
			jTableListaProdutoServico = new JTable();
			jTableListaProdutoServico.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                {null, null, null, null, null, null, null},
		                
		            },
		            new String [] {
		                "Data", "Cliente", "Placa", "Qtd.Produtos",
		                "Desconto", "Valor"
		            }
		        ));			

			jTableListaProdutoServico.setFont(Fontes.fontJTablePlain2);
			jTableListaProdutoServico.setOpaque(false);
			jTableListaProdutoServico.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableListaProdutoServico.getTableHeader().setForeground(Cores.branco);
			jTableListaProdutoServico.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableListaProdutoServico;
	}

	//** Fim getters JScrollPane/JTable **
		
	
	//** In�cio m�todos adi��o de componentes **
	void addCompJPanelPreOrcamentoNovo() {
		this.getJPanelPreOrcamentoNovo().add(getjButtonCancelar());
		this.getjButtonCancelar().setLocation(14, 21);
		
		this.getJPanelPreOrcamentoNovo().add(getjButtonSalvar());
		this.getjButtonSalvar().setLocation(133, 21);
		
		this.getJPanelPreOrcamentoNovo().add(getjButtonImprimir());
		this.getjButtonImprimir().setLocation(199, 21);
		
		this.getJPanelPreOrcamentoNovo().add(getjPanelCentro());
		this.getjPanelCentro().setLocation(14, 78);
		
	}
	
	void addCompJpanelCentro() {
		
		// -- parte descritiva cliente
		this.getjPanelCentro().add(getjButtonProcuraCliente());
		this.getjButtonProcuraCliente().setLocation(28, 103);
		
		this.getjPanelCentro().add(getjRadioButtonCpf());
		this.getjRadioButtonCpf().setLocation(98, 136);
		
		this.getjPanelCentro().add(getjRadioButtonCnpj());
		this.getjRadioButtonCnpj().setLocation(141, 136);
		
		this.getjPanelCentro().add(getjLabelCpf());
		this.getjLabelCpf().setLocation(63,153);
		
		this.getjPanelCentro().add(getjTFieldCpf());
		this.getjTFieldCpf().setLocation(97, 153);
		
		this.getjPanelCentro().add(getjLabelNome());
		this.getjLabelNome().setLocation(303, 153);
		
		this.getjPanelCentro().add(getjTFieldNome());
		this.getjTFieldNome().setLocation(354, 153);
		
		this.getjPanelCentro().add(getjLabelTipo());
		this.getjLabelTipo().setLocation(613, 153);
		
		this.getjPanelCentro().add(getjTFieldTipo());
		this.getjTFieldTipo().setLocation(656, 153);
		
		this.getjPanelCentro().add(getjLabelTelefone());
		this.getjLabelTelefone().setLocation(754, 153);
		
		this.getjPanelCentro().add(getjTFieldTelefone());
		this.getjTFieldTelefone().setLocation(825, 153);
		
		
		this.getjPanelCentro().add(getjLabelEmail());
		this.getjLabelEmail().setLocation(52, 187);
		
		this.getjPanelCentro().add(getjTFieldEmail());
		this.getjTFieldEmail().setLocation(97, 187);
		
		this.getjPanelCentro().add(getjLabelCidade());
		this.getjLabelCidade().setLocation(297, 187);
		
		this.getjPanelCentro().add(getjTFieldCidade());
		this.getjTFieldCidade().setLocation(354, 187);
		
		this.getjPanelCentro().add(getjLabelBairro());
		this.getjLabelBairro().setLocation(603, 187);
		
		this.getjPanelCentro().add(getjTFieldBairro());
		this.getjTFieldBairro().setLocation(656, 187);
	
		
		this.getjPanelCentro().add(getjLabelRua());
		this.getjLabelRua().setLocation(65, 221);
		
		this.getjPanelCentro().add(getjTFieldRua());
		this.getjTFieldRua().setLocation(97, 221);
		
		this.getjPanelCentro().add(getjLabelNumeroCasa());
		this.getjLabelNumeroCasa().setLocation(290, 221);
		
		this.getjPanelCentro().add(getjTFieldNumeroCasa());
		this.getjTFieldNumeroCasa().setLocation(354, 221);
		
		// -- parte descritiva do ve�culo
		this.getjPanelCentro().add(getjButtonSelecionarVeiculo());
		this.getjButtonSelecionarVeiculo().setLocation(22, 258);
		
		this.getjPanelCentro().add(getjLabelNumeroVeiculo());
		this.getjLabelNumeroVeiculo().setLocation(71, 300);
	
		this.getjPanelCentro().add(getjTFieldNumeroVeiculo());
		this.getjTFieldNumeroVeiculo().setLocation(97, 300);
	
		this.getjPanelCentro().add(getjLabelChassi());
		this.getjLabelChassi().setLocation(242, 300);
		
		this.getjPanelCentro().add(getjTFieldChassi());
		this.getjTFieldChassi().setLocation(294, 300);
		
		this.getjPanelCentro().add(getjLabelPlaca());
		this.getjLabelPlaca().setLocation(553, 300);
		
		this.getjPanelCentro().add(getjTFieldPlaca());
		this.getjTFieldPlaca().setLocation(597, 300);
		
		this.getjPanelCentro().add(getjLabelKMAtual());
		this.getjLabelKMAtual().setLocation(758, 300);
		
		this.getjPanelCentro().add(getjTFieldKMAtual());
		this.getjTFieldKMAtual().setLocation(829, 300);
	
		this.getjPanelCentro().add(getjLabelMarca());
		this.getjLabelMarca().setLocation(46, 334);
		
		this.getjPanelCentro().add(getjTFieldMarca());
		this.getjTFieldMarca().setLocation(97, 334);
		
		this.getjPanelCentro().add(getjLabelModelo());
		this.getjLabelModelo().setLocation(231, 334);
		
		this.getjPanelCentro().add(getjTFieldModelo());
		this.getjTFieldModelo().setLocation(294, 334);
		
		this.getjPanelCentro().add(getjLabelMotor());
		this.getjLabelMotor().setLocation(544, 334);
		
		this.getjPanelCentro().add(getjTFieldMotor());
		this.getjTFieldMotor().setLocation(597, 334);
		
		this.getjPanelCentro().add(getjLabelCombustivel());
		this.getjLabelCombustivel().setLocation(733, 334);
		
		this.getjPanelCentro().add(getjTFieldCombustivel());
		this.getjTFieldCombustivel().setLocation(829, 334);
		
		this.getjPanelCentro().add(getjLabelCor());
		this.getjLabelCor().setLocation(63, 368);
		
		this.getjPanelCentro().add(getjTFieldCor());
		this.getjTFieldCor().setLocation(97, 368);
		
		this.getjPanelCentro().add(getjLabelAno());
		this.getjLabelAno().setLocation(257, 368);

		this.getjPanelCentro().add(getjTFieldAno());
		this.getjTFieldAno().setLocation(294, 368);
		
		
		
	}
	
}