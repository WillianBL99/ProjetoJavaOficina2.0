/**
 * 
 */
package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cores;
import model.Fontes;

/**
 * @author Paulo Uilian
 *
 */


public class JPanelVendasProsseguir extends JPanel{

	
	//** In�cio declara��o de vari�veis **
	
	
	private JPanel jPanelBarraSup;
	private JPanel jPanelCentroVendasProsseguir;
	private JPanel jPanelDadosCompra;
	private JPanel jPanelFormaPagamento;
	
	private JButton jButtonFinalizarCompra;
	private JButton jButtonVoltar;
	private JButton jButtonDinheiro;
	private JButton jButtonCart�o;
	
	private JTextField jTFildValorTotCompra;
	private JTextField jTFildDesconto;
	private JTextField jTFildValorPagar;
	
	private JLabel jLabelDescricaoTela;
	
		
	//** Fim declara��o de vari�veis **
	
	//** In�cio construtor **
	
	
	public JPanelVendasProsseguir() {
		
	}
	
	
	//** Fim construtor **
	
	//** In�cio getters JPanels **
	
	
	public JPanelVendasNovo getJPanelVendasNovo() { // OK
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
	
		}
		return jPanelCentroVendasProsseguir;
	}


	public JPanel getjPanelDadosCompra() {
		if(jPanelDadosCompra == null){
	
			jPanelDadosCompra = new ();
	
		}
		return jPanelDadosCompra;
	}


	public JPanel getjPanelFormaPagamento() {
		if(jPanelFormaPagamento == null){
	
			jPanelFormaPagamento = new ();
	
		}
		return jPanelFormaPagamento;
	}
	
	
	//** Fim getters JPanel **	
	
	//** In�cio getters JLabel **
		
	
	public JLabel getjLabelDescricaoTela() {
		if(jLabelDescricaoTela == null){
	
			jLabelDescricaoTela = new ();
	
		}
		return jLabelDescricaoTela;
	}	
	
	
	//** Fim getters JLabel **	
	
	//** In�cio getters JButon **
	
	
	public JButton getjButtonFinalizarCompra() {
		if(jButtonFinalizarCompra == null){
	
			jButtonFinalizarCompra = new ();
	
		}
		return jButtonFinalizarCompra;
	}


	public JButton getjButtonVoltar() {
		if(jButtonVoltar == null){
	
			jButtonVoltar = new ();
	
		}
		return jButtonVoltar;
	}


	public JButton getjButtonDinheiro() {
		if(jButtonDinheiro == null){
	
			jButtonDinheiro = new ();
	
		}
		return jButtonDinheiro;
	}


	public JButton getjButtonCart�o() {
		if(jButtonCart�o == null){
	
			jButtonCart�o = new ();
	
		}
		return jButtonCart�o;
	}
	
	
	//** Fim getters JButon **	
	
	//** In�cio getters JFields **
	
	
	public JTextField getjTFildValorTotCompra() {
		if(jTFildValorTotCompra == null){
	
			jTFildValorTotCompra = new ();
	
		}
		return jTFildValorTotCompra;
	}


	public JTextField getjTFildDesconto() {
		if(jTFildDesconto == null){
	
			jTFildDesconto = new ();
	
		}
		return jTFildDesconto;
	}


	public JTextField getjTFildValorPagar() {
		if(jTFildValorPagar == null){
	
			jTFildValorPagar = new ();
	
		}
		return jTFildValorPagar;
	}
	
	
	//** Fim getters JFields **	
	
	//** In�cio getters JComboBox **
	
	
	
	
	//** Fim getters JComboBox **
	
	//** In�cio m�todos adi��o de componentes **	

	
	public void addCompJPanelVendas() { // OK
		
		this.getJPanelVendasNovo().add(this.getjPanelBarraSup());
		this.getjPanelBarraSup().setLocation(0, 0);		
		
	}


	


	


	


		
	
	
	//** Fim m�todos adi��o de componentes **
	


}
