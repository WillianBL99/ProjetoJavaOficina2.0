/**
 * 
 */
package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import icons.Icones;
import model.Cores;
import model.Fontes;
import model.SetSizeIcon;

/**
 * @author Paulo Uilian
 *
 */

@SuppressWarnings("serial")
public class JPanelOrcamentoFinal_PreOrcamento extends JPanel{

	
	//** Início declaração de variáveis **
	
	private SetSizeIcon setSizeIcon = new SetSizeIcon();
	private String tituloDescricaoTela; // título que descreve a tela que foi chamanda no JPanelPrincipal
	
	private JPanel jPanelFundo; // painel branco ocupando quase todo espaço da tela
	
	private JLabel jLabelInformacao; // informa oq tem que ser feito
	private JLabel jLabelServPreOrc; // serviços do pré orçamento
	private JLabel jLabelPecPreOrc; // peças do pré orçamento
	
	private JScrollPane jSPTabelaServicaos;
	private JScrollPane jSPTabelaPecas;
	
	private JTable jTableTabelaServicos;
	private JTable jTableTabelaPecas;
	
	private JButton jButtonCancelar;
	private JButton jButtonIncluirSelecao;

	//** Fim declaração de variáveis **
	
	//** Início construtor **


	public JPanelOrcamentoFinal_PreOrcamento() {
		this.addCompJPanelOrcamentoFinal_PreOrcamento();
	}
	
	//** Fim construtor **
	
	//** Início getters JPanels **

	public JPanelOrcamentoFinal_PreOrcamento getJPanelOrcamentoFinal_PreOrcamento() { // OK
		this.setLayout(null);
		this.setBackground(Cores.cinza3);
		this.setSize(new Dimension(1030,674));
		this.setVisible(true);
		return this;
	}
	
	public JPanel getjPanelFundo() {
		if(jPanelFundo == null){
			jPanelFundo = new JPanel();
			jPanelFundo.setLayout(null);
			jPanelFundo.setBackground(Cores.branco);
			jPanelFundo.setSize(990, 50);
			jPanelFundo.setBorder(null);
		}
		return jPanelFundo;
	}
	
	
	//** Fim getters JPanel **
	
	//** Início getters JLabel **
	

	public JLabel getjLabelInformacao() {
		if(jLabelInformacao == null){
			jLabelInformacao = new JLabel();
			jLabelInformacao.setFont(Fontes.fontJLabelPlain1);
			jLabelInformacao.setForeground(Cores.preto);
			jLabelInformacao.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelInformacao.setText("Data final");
			jLabelInformacao.setOpaque(false);
			jLabelInformacao.setSize(70,21);	
		}
		return jLabelInformacao;
	}
	

	public JLabel getjLabelServPreOrc() {
		if(jLabelServPreOrc == null){
			jLabelServPreOrc = new JLabel();
			jLabelServPreOrc.setFont(Fontes.fontJLabelPlain1);
			jLabelServPreOrc.setForeground(Cores.preto);
			jLabelServPreOrc.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelServPreOrc.setText("Data final");
			jLabelServPreOrc.setOpaque(false);
			jLabelServPreOrc.setSize(70,21);	
		}
		return jLabelServPreOrc;
	}
	

	public JLabel getjLabelPecPreOrc() {
		if(jLabelPecPreOrc == null){
			jLabelPecPreOrc = new JLabel();
			jLabelPecPreOrc.setFont(Fontes.fontJLabelPlain1);
			jLabelPecPreOrc.setForeground(Cores.preto);
			jLabelPecPreOrc.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelPecPreOrc.setText("Data final");
			jLabelPecPreOrc.setOpaque(false);
			jLabelPecPreOrc.setSize(70,21);	
		}
		return jLabelPecPreOrc;
	}
	
	//** Fim getters JLabel **
	
	//** Início getters JButon **
	
	
	public JButton getjButtonCancelar() {
		if(jButtonCancelar == null){
			jButtonCancelar = new JButton();			
			jButtonCancelar.setFont(Fontes.fontJButtonPlain3);
			jButtonCancelar.setBackground(Cores.azul1);
			jButtonCancelar.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonCancelar, Icones.
					getApagar(), 30, 30);
			jButtonCancelar.setSize(56, 35);
			jButtonCancelar.setFocusable(false);
			jButtonCancelar.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonCancelar;
	}
	
	
	public JButton getjButtonIncluirSelecao() {
		if(jButtonIncluirSelecao == null){
			jButtonIncluirSelecao = new JButton();			
			jButtonIncluirSelecao.setFont(Fontes.fontJButtonPlain3);
			jButtonIncluirSelecao.setBackground(Cores.azul1);
			jButtonIncluirSelecao.setForeground(Color.white);
			setSizeIcon.setIconJButton(jButtonIncluirSelecao, Icones.
					getApagar(), 30, 30);
			jButtonIncluirSelecao.setSize(56, 35);
			jButtonIncluirSelecao.setFocusable(false);
			jButtonIncluirSelecao.setBorder(BorderFactory.
					createLineBorder(Cores.cinza2, 1));
		}
		return jButtonIncluirSelecao;
	}
	
	
	//** Fim getters JButon **
	
	//** Início getters conjuto JScrollPane/JTable **
	
	
	public JScrollPane getjSPTabelaServicaos() {
		if(jSPTabelaServicaos == null){
			jSPTabelaPecas = new JScrollPane();
			jSPTabelaPecas.setViewportView(jSPTabelaServicaos());
			jSPTabelaPecas.setSize(990, 225);	
		}
		return jSPTabelaServicaos;
	}

	public JScrollPane getjSPTabelaPecas() {
		if(jSPTabelaPecas == null){
			jSPTabelaPecas = new JScrollPane();
			jSPTabelaPecas.setViewportView(jTableTabelaPecas());
			jSPTabelaPecas.setSize(990, 225);	
		}
		return jSPTabelaPecas;
	}

	public JTable jSPTabelaServicaos() {
		if(jTableTabelaServicos == null){
			jTableTabelaServicos = new JTable();
			jTableTabelaServicos.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                {null, null, null, null, null, null},
		                
		            },
		            new String [] {
		                "Cod. Produto", "Qtd. Produto", "Descrição", "Preço",
		                "Total"
		            }
		        ));			

			jTableTabelaServicos.setFont(Fontes.fontJTablePlain2);
			jTableTabelaServicos.setOpaque(false);
			jTableTabelaServicos.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableTabelaServicos.getTableHeader().setForeground(Cores.branco);
			jTableTabelaServicos.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableTabelaServicos;
	}

	public JTable jTableTabelaPecas() {
		if(jTableTabelaPecas == null){
			jTableTabelaPecas = new JTable();
			jTableTabelaPecas.setModel(new javax.swing.table.DefaultTableModel(
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
		                "Cod. Serviço", "Descrição", "Desconto", "Preço",
		                "Total"
		            }
		        ));			

			jTableTabelaPecas.setFont(Fontes.fontJTablePlain2);
			jTableTabelaPecas.setOpaque(false);
			jTableTabelaPecas.getTableHeader().setFont(Fontes.fontJTableBold2);
			jTableTabelaPecas.getTableHeader().setForeground(Cores.branco);
			jTableTabelaPecas.getTableHeader().setBackground(Cores.azul1);
		}
		return jTableTabelaPecas;
	}
	
	
	//** Fim getters conjuto JScrollPane/JTable **
		
	//** Início métodos adição de componentes **	


	public String getTituloDescricaoTela() {
		if(tituloDescricaoTela == null){	
			tituloDescricaoTela = "Pré Orçamento";	
		}
		return tituloDescricaoTela;
	}
	

	public void addCompJPanelOrcamentoFinal_PreOrcamento() { 
	
		this.getJPanelOrcamentoFinal_PreOrcamento().add(this.getjPanelFundo());
		this.getjPanelFundo().setLocation(14, 20);
	}

	
	public void addCompJPanelFundo() { 
	
		this.getjPanelFundo().add(this.getjLabelInformacao());
		this.getjLabelInformacao().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjLabelServPreOrc());
		this.getjLabelServPreOrc().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjSPTabelaServicaos());
		this.getjSPTabelaServicaos().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjLabelPecPreOrc());
		this.getjLabelPecPreOrc().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjSPTabelaPecas());
		this.getjSPTabelaPecas().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjButtonIncluirSelecao());
		this.getjButtonIncluirSelecao().setLocation(14, 20);
	
		this.getjPanelFundo().add(this.getjButtonCancelar());
		this.getjButtonCancelar().setLocation(14, 20);
	}

	
	//** Fim métodos adição de componentes **
	

}
