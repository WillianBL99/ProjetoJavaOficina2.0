/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import dao.ComandosSQL;
import dao.ModuloConexao;
import dao.PreencherChoice;
import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */
@SuppressWarnings("serial")
public class JPanelVendasProsseguir extends JPanel{

	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private ModuloConexao moduloConexao;
	
	private JPanel jPanelBarraSup;
	private JPanel jPanelCentroVendasProsseguir;
	private JPanel jPanelDadosCompra;
	private JPanel jPanelFormaPagamento;
	private JPanel jPanelDadosPagamento;
	private JPanel jPanelDadosVendedorCliente;
	
	private JScrollPane jSPCentroVendasProsseguir;
	
	private JButton jButtonFinalizarCompra;
	private JButton jButtonVoltar;
	private JButton jButtonDinheiro;
	private JButton jButtonCartão;
	private JButton jButtonProcurar;
	
	private JTextField jTFildValorTotCompra;
	private JTextField jTFildDesconto;
	private JTextField jTFildValorPagar;
	private JTextField jTFieldValorPago;
	private JTextField jTFieldTroco;
	private JTextField jTFieldCliente;
	
	private Choice choiceVendedor;
	
	private JLabel jLabelDescricaoTela;
	private JLabel jLabelResponsavel;
	private JLabel jLabelCliente;
	
		
	//** Fim declaração de variáveis **
	
	//** Início construtor **
	
	
	public JPanelVendasProsseguir() {
		this.addCompJPanelDadosPagamento();
		this.addCompJPanelFormaPagamento();
		this.addCompJPanelDadosCompra();
		this.addCompJpanelDadosVendedorCliente();
		this.addCompJPanelCentroVendas();
		this.addCompJPanelVendasProsseguir();
	}
	
	
	//** Fim construtor **
	
	//** Início getters JPanels **
	
	
	public JPanelVendasProsseguir getJPanelVendasProsseguir() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(1280, 720);
		this.setVisible(true);
		return this;
	}
	
	
	public JPanel getjPanelBarraSup() { // OK
		if(jPanelBarraSup == null) {
			jPanelBarraSup = new JPanel();
			jPanelBarraSup.setLayout(null);
			jPanelBarraSup.setBackground(Cores.azul1);
			jPanelBarraSup.setSize(1280, 46);
			jPanelBarraSup.setBorder(null);
		}
		return jPanelBarraSup;
	}
	
	public JPanel getjPanelCentroVendasProsseguir() {
		if(jPanelCentroVendasProsseguir == null){
			jPanelCentroVendasProsseguir = new JPanel();
			jPanelCentroVendasProsseguir.setLayout(null);
			jPanelCentroVendasProsseguir.setBackground(Cores.branco);
			jPanelCentroVendasProsseguir.setSize(1249,682);
			jPanelCentroVendasProsseguir.setPreferredSize(new Dimension(1249,682));
			jPanelCentroVendasProsseguir.setBorder(null);
		}
		return jPanelCentroVendasProsseguir;
	}


	public JPanel getjPanelDadosCompra() {
		if(jPanelDadosCompra == null){
			jPanelDadosCompra = new JPanel();
			jPanelDadosCompra.setLayout(null);
			jPanelDadosCompra.setBackground(Cores.branco);
			jPanelDadosCompra.setSize(1219,140);
			jPanelDadosCompra.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza1, 3, true),
							"Dados da compra",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza1)
					);
		}
		return jPanelDadosCompra;
	}


	public JPanel getjPanelFormaPagamento() {
		if(jPanelFormaPagamento == null){
			jPanelFormaPagamento = new JPanel();
			jPanelFormaPagamento.setLayout(null);
			jPanelFormaPagamento.setBackground(Cores.branco);
			jPanelFormaPagamento.setSize(1219,105);
			jPanelFormaPagamento.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza1, 3, true),
							"Forma de pagamento",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza1)
					);
		}
		return jPanelFormaPagamento;
	}
	
	
	public JPanel getjPanelDadosPagamento() {
		if(jPanelDadosPagamento == null){
			jPanelDadosPagamento = new JPanel();
			jPanelDadosPagamento.setLayout(null);
			jPanelDadosPagamento.setBackground(Cores.branco);
			jPanelDadosPagamento.setSize(1219,120);
			jPanelDadosPagamento.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza1, 3, true),
							"Dados do pagamento",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza1)
					);
			jPanelDadosPagamento.setVisible(true);
		}
		return jPanelDadosPagamento;
	}	
	
	
	public JPanel getjPanelDadosVendedorCliente() {
		if(jPanelDadosVendedorCliente == null){
			jPanelDadosVendedorCliente = new JPanel();
			jPanelDadosVendedorCliente.setLayout(null);
			jPanelDadosVendedorCliente.setBackground(Cores.branco);
			jPanelDadosVendedorCliente.setSize(1219,120);
			jPanelDadosVendedorCliente.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza1, 3, true),
							"Dados vendedor e cliente",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza1)
					);
			jPanelDadosVendedorCliente.setVisible(true);
		}
		return jPanelDadosVendedorCliente;
	}
	
	
	public JLabel getjLabelResponsavel() {
		if(jLabelResponsavel == null){
			jLabelResponsavel = new JLabel("Responsável*:");
			jLabelResponsavel.setFont(Fontes.fontJLabelPlain3);
			jLabelResponsavel.setSize(152, 35);
			jLabelResponsavel.setForeground(Cores.preto);
			jLabelResponsavel.setOpaque(false);
		}
		return jLabelResponsavel;
	}
	
	
	public JLabel getjLabelCliente() {
		if(jLabelCliente == null){
			jLabelCliente = new JLabel("Cliente:");
			jLabelCliente.setFont(Fontes.fontJLabelPlain3);
			jLabelCliente.setSize(100, 35);
			jLabelCliente.setForeground(Cores.preto);
			jLabelCliente.setOpaque(false);
		}
		return jLabelCliente;
	}
	
	
	public JScrollPane getjSPCentroVendasProsseguir() {
		if(jSPCentroVendasProsseguir == null){
			jSPCentroVendasProsseguir = new JScrollPane();
			jSPCentroVendasProsseguir.setViewportView(getjPanelCentroVendasProsseguir());
			jSPCentroVendasProsseguir.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			jSPCentroVendasProsseguir.setBorder(null);
			jSPCentroVendasProsseguir.setSize(1249, 610);	
		}
		return jSPCentroVendasProsseguir;
	}
	
	//** Fim getters JPanel **	
	
	//** Início getters JLabel **
		
	
	public JLabel getjLabelDescricaoTela() {
		if(jLabelDescricaoTela == null){
			jLabelDescricaoTela = new JLabel();
			jLabelDescricaoTela.setBackground(Cores.branco);
			jLabelDescricaoTela.setFont(Fontes.fontJLabelPlain2);
			jLabelDescricaoTela.setText("Concluindo venda");
			jLabelDescricaoTela.setForeground(Cores.branco);
			jLabelDescricaoTela.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDescricaoTela.setBorder(null);
			jLabelDescricaoTela.setSize(300,30);			
		}
		return jLabelDescricaoTela;
	}	
	
	
	public Choice getchoiceVendedor() {
		if(choiceVendedor == null) {
			choiceVendedor = new Choice();
			choiceVendedor.setSize(364, 35);
			choiceVendedor.setFont(Fontes.fontJTFieldPlain3);
			choiceVendedor.setForeground(Cores.azul1);
			choiceVendedor.setVisible(true);
			choiceVendedor.setFocusable(false);	
			choiceVendedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			choiceVendedor.add(String.format("%150s", ""));
			// Executa a query que retorna os nomes dos usuarios
			getModuloConexao().executeQuery(ComandosSQL.consultarNomesUsuarios());
			// Seta os itens do Choice com os valores da consulta sql
			new PreencherChoice(getModuloConexao().getResultSet(), choiceVendedor);
		}
		return choiceVendedor;
	}
	
	
	//** Fim getters JLabel **	
	
	//** Início getters JButon **
	
	
	public JButton getjButtonFinalizarCompra() {
		if(jButtonFinalizarCompra == null){
			jButtonFinalizarCompra = new JButton();			
			jButtonFinalizarCompra.setFont(Fontes.fontJButtonPlain3);
			jButtonFinalizarCompra.setBackground(Cores.azul1);
			jButtonFinalizarCompra.setForeground(Color.white);
			jButtonFinalizarCompra.setText("Finalizar compra");
			jButtonFinalizarCompra.setSize(439, 45);
			jButtonFinalizarCompra.setFocusable(false);
			jButtonFinalizarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtonFinalizarCompra.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonFinalizarCompra;
	}


	public JButton getjButtonVoltar() {
		if(jButtonVoltar == null){
			jButtonVoltar = new JButton();			
			jButtonVoltar.setFont(Fontes.fontJButtonPlain3);
			jButtonVoltar.setBackground(Cores.azul1);
			jButtonVoltar.setForeground(Color.white);
			jButtonVoltar.setText("Voltar");
			jButtonVoltar.setSize(100, 35);
			jButtonVoltar.setFocusable(false);
			jButtonVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtonVoltar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonVoltar;
	}


	public JButton getjButtonDinheiro() {
		if(jButtonDinheiro == null){
			jButtonDinheiro = new JButton();
			jButtonDinheiro.setBackground(Cores.branco);
			jButtonDinheiro.setFont(Fontes.fontJButtonBold1);
			jButtonDinheiro.setText(" Dinheiro");
			jButtonDinheiro.setForeground(Cores.preto);
			setSizeIcon.setIconJButton(jButtonDinheiro, Icones.
					getDinheiroAzul(), 50, 50);
			jButtonDinheiro.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonDinheiro.setBorder(null);
			jButtonDinheiro.setFocusPainted(false);
			jButtonDinheiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtonDinheiro.setSize(140,50);
			
		}
		return jButtonDinheiro;
	}


	public JButton getjButtonCartao() {
		if(jButtonCartão == null){
			jButtonCartão = new JButton();
			jButtonCartão.setBackground(Cores.branco);
			jButtonCartão.setForeground(Cores.cinza1);
			jButtonCartão.setFont(Fontes.fontJButtonBold1);
			jButtonCartão.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtonCartão.setHorizontalAlignment(SwingConstants.LEFT);
			jButtonCartão.setFocusPainted(false);
			jButtonCartão.setBorder(null);
			jButtonCartão.setSize(140,50);
			jButtonCartão.setText(" Cartão");
			setSizeIcon.setIconJButton(jButtonCartão, Icones.getCartaoCinza(), 50, 50);			
		}
		return jButtonCartão;
	}

	
	public JButton getjButtonProcurar() {
		if(jButtonProcurar == null){
			jButtonProcurar = new JButton();			
			jButtonProcurar.setFont(Fontes.fontJButtonPlain3);
			jButtonProcurar.setBackground(Cores.azul1);
			jButtonProcurar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonProcurar, Icones.
					getBuscar(), 30, 30);
			jButtonProcurar.setSize(43, 35);
			jButtonProcurar.setFocusable(false);
			jButtonProcurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtonProcurar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonProcurar;
	}
	
	
	//** Fim getters JButon **	
	
	//** Início getters JFields **
	
	
	public JTextField getjTFieldValorTotCompra() {
		if(jTFildValorTotCompra == null){
			jTFildValorTotCompra = new JTextField();
			jTFildValorTotCompra.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Valor total da compra",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza2)
					);
			jTFildValorTotCompra.setForeground(Cores.azul1);
			jTFildValorTotCompra.setFont(Fontes.fontJTFieldBold2);
			jTFildValorTotCompra.setSize(320, 77);
			jTFildValorTotCompra.setEditable(false);
			jTFildValorTotCompra.setOpaque(false);
			
		}
		return jTFildValorTotCompra;
	}


	public JTextField getjTFieldDesconto() {
		if(jTFildDesconto == null){
			jTFildDesconto = new JTextField();
			jTFildDesconto.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.azul1, 4, true),
							"Desconto",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.azul1)
					);
			jTFildDesconto.setForeground(Cores.azul1);
			jTFildDesconto.setFont(Fontes.fontJTFieldBold2);
			jTFildDesconto.setSize(345, 77);
			jTFildDesconto.setOpaque(false);
			
		}
		return jTFildDesconto;
	}


	public JTextField getjTFieldValorPagar() {
		if(jTFildValorPagar == null){
			jTFildValorPagar = new JTextField();
			jTFildValorPagar.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Valor a pagar",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza2)
					);
			jTFildValorPagar.setForeground(Cores.azul1);
			jTFildValorPagar.setFont(Fontes.fontJTFieldBold2);
			jTFildValorPagar.setSize(345, 77);
			jTFildValorPagar.setEditable(false);
			jTFildValorPagar.setOpaque(false);
			
		}
		return jTFildValorPagar;
	}
	
	
	public JTextField getjTFieldValorPago() {
		if(jTFieldValorPago == null){
			jTFieldValorPago = new JTextField();
			jTFieldValorPago.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.azul1, 4, true),
							"Valor pago*",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.azul1)
					);
			jTFieldValorPago.setForeground(Cores.azul1);
			jTFieldValorPago.setFont(Fontes.fontJTFieldBold2);
			jTFieldValorPago.setSize(226, 68);
			jTFieldValorPago.setOpaque(false);
			
		}
		return jTFieldValorPago;
	}


	public JTextField getjTFieldTroco() {
		if(jTFieldTroco == null){
			jTFieldTroco = new JTextField();
			jTFieldTroco.setBorder(BorderFactory.
					createTitledBorder(new javax.swing.border.
							LineBorder(Cores.cinza2, 3, true),
							"Troco",
							javax.swing.border.TitledBorder.LEFT,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							Fontes.fontBorda2,
							Cores.cinza2)
					);
			jTFieldTroco.setForeground(Cores.azul1);
			jTFieldTroco.setFont(Fontes.fontJTFieldBold2);
			jTFieldTroco.setSize(226, 68);
			jTFieldTroco.setEditable(false);
			jTFieldTroco.setOpaque(false);
			
		}
		return jTFieldTroco;
	}
	
	
	public JTextField getjTFieldCliente() {
		if(jTFieldCliente == null){
			jTFieldCliente = new JTextField();
			jTFieldCliente.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 3, false));
			jTFieldCliente.setForeground(Cores.preto);
			jTFieldCliente.setFont(Fontes.fontJTFieldPlain3);
			jTFieldCliente.setForeground(Cores.azul1);
			jTFieldCliente.setSize(359, 35);
			jTFieldCliente.setEditable(false);
			jTFieldCliente.setOpaque(true);
		}
		return jTFieldCliente;
	}
	
	
	//** Fim getters JFields **	
	
	//** Início getters JComboBox **
	
	
	
	
	//** Fim getters JComboBox **
	
	//** Início métodos adição de componentes **	

	
	public void addCompJPanelVendasProsseguir() { // OK
		
		this.getJPanelVendasProsseguir().add(this.getjPanelBarraSup());
		this.getjPanelBarraSup().setLocation(0, 0);	
		
		this.getJPanelVendasProsseguir().add(this.getjButtonVoltar());
		this.getjButtonVoltar().setLocation(14, 67);	
		
		this.getJPanelVendasProsseguir().add(this.getjSPCentroVendasProsseguir());
		this.getjSPCentroVendasProsseguir().setLocation(14, 116);		
		
	}

	
	public void addCompJPanelCentroVendas() {
		
		this.getjPanelCentroVendasProsseguir().add(this.getjPanelDadosCompra());
		this.getjPanelDadosCompra().setLocation(14, 26);	
		
		this.getjPanelCentroVendasProsseguir().add(this.getjPanelFormaPagamento());
		this.getjPanelFormaPagamento().setLocation(14, 192);	
		
		this.getjPanelCentroVendasProsseguir().add(this.getjPanelDadosPagamento());
		this.getjPanelDadosPagamento().setLocation(14, 323);		
		
		this.getjPanelCentroVendasProsseguir().add(this.getjPanelDadosVendedorCliente());
		this.getjPanelDadosVendedorCliente().setLocation(14, 469);
		
		this.getjPanelCentroVendasProsseguir().add(this.getjButtonFinalizarCompra());
		this.getjButtonFinalizarCompra().setLocation(807, 615);	
		
	}
	

	public void addCompJPanelDadosCompra() {
		
		this.getjPanelDadosCompra().add(this.getjTFieldValorTotCompra());
		this.getjTFieldValorTotCompra().setLocation(20, 35);
		
		this.getjPanelDadosCompra().add(this.getjTFieldDesconto());
		this.getjTFieldDesconto().setLocation(437, 35);
		
		this.getjPanelDadosCompra().add(this.getjTFieldValorPagar());
		this.getjTFieldValorPagar().setLocation(854, 35);
		
	}


	public void addCompJPanelFormaPagamento() {
		
		this.getjPanelFormaPagamento().add(this.getjButtonDinheiro());
		this.getjButtonDinheiro().setLocation(14, 35);
		
		this.getjPanelFormaPagamento().add(this.getjButtonCartao());
		this.getjButtonCartao().setLocation(202, 35);
		
	}


	public void addCompJPanelDadosPagamento() {	
		
		this.getjPanelDadosPagamento().add(this.getjTFieldValorPago());
		this.getjTFieldValorPago().setLocation(14, 35);
		
		this.getjPanelDadosPagamento().add(this.getjTFieldTroco());
		this.getjTFieldTroco().setLocation(276, 35);
		
	}
	
	
	public void addCompJpanelDadosVendedorCliente() {
		
		this.getjPanelDadosVendedorCliente().add(this.getjLabelResponsavel());
		this.getjLabelResponsavel().setLocation(14, 45);
		
		this.getjPanelDadosVendedorCliente().add(this.getchoiceVendedor());
		this.getchoiceVendedor().setLocation(172, 45);
		
		
		this.getjPanelDadosVendedorCliente().add(this.getjLabelCliente());
		this.getjLabelCliente().setLocation(640, 45);
		
		this.getjPanelDadosVendedorCliente().add(this.getjTFieldCliente());
		this.getjTFieldCliente().setLocation(736, 45);
		
		this.getjPanelDadosVendedorCliente().add(this.getjButtonProcurar());
		this.getjButtonProcurar().setLocation(1094, 45);
	}

	
	
	//** Fim métodos adição de componentes **

	public SetSizeIcon getSetSizeIcon() {
		return setSizeIcon;
	}
	
	private ModuloConexao getModuloConexao() {
		if(this.moduloConexao == null) {
			this.moduloConexao = new ModuloConexao();
		}
		return this.moduloConexao;
	}


}
