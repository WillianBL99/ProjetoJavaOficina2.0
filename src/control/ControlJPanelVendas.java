/**
 * 
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;

import dao.DaoJPanelVendas;
import model.Mascara;
import view.JFramePrincipal;
import view.JPanelPrincipal;
import view.JPanelVendas;
import view.JPanelVendasNovo;

/**
 * @author Paulo Uilian
 *
 */
public class ControlJPanelVendas implements MouseListener, KeyListener, FocusListener, WindowListener, ItemListener {
	

	//** Início declaração de variáveis **
	private JFramePrincipal jFramePricipal;
	private JPanelVendas jPanelVendas;
	private JPanelPrincipal jPanelPrincipal;
	private JPanelVendasNovo jPanelVendasNovo;
	private ControlJPanelVendasNovo controlJPanelVendasNovo;
	private DaoJPanelVendas daoJPanelVendas;
	
	//** Fim declaração de variáveis **	
	
	
	/**
	 * @param jFramePricipal
	 * @param jPanelVendas
	 * @param jPanelPrincipal
	 */
	public ControlJPanelVendas(JFramePrincipal jFramePricipal, JPanelVendas jPanelVendas,
			JPanelPrincipal jPanelPrincipal) {
		super();
		this.jFramePricipal = jFramePricipal;
		this.jPanelVendas = jPanelVendas;
		this.jPanelPrincipal = jPanelPrincipal;
		this.AddEvent();
	}
	



	private void AddEvent() {
		getjFramePricipal().addWindowListener(this);
		getjPanelVendasNovo().addFocusListener(this);
		getjPanelVendas().getjButtonNovaVenda().addMouseListener(this);
		getjPanelVendas().getjButtonApagar().addMouseListener(this);
		getjPanelVendas().getjButtonImprimir().addMouseListener(this);
		getjPanelVendas().getjButtonFiltrar().addMouseListener(this);
		getjPanelVendas().getjButtonPesquisarTodos().addMouseListener(this);
		getjPanelVendas().getjTFieldDTInicial().addFocusListener(this);
		getjPanelVendas().getjTFieldDTFinal().addFocusListener(this);
		getjPanelVendas().getChoiceFormPesquisa().addItemListener(this);
		getjPanelVendas().getChoiceFormPesquisa().addMouseListener(this);
		getjPanelVendas().getChoiceFormPesquisa().addFocusListener(this);
		
	}

	
		
		
	//** Início métodos sobrescritos **
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// Quando o botão nova venda for clicado
		if(e.getSource() == getjPanelVendas().getjButtonNovaVenda()) {
			jPanelVendasNovo = null;
			controlJPanelVendasNovo = null;
			getjFramePricipal().alterarJPanel(getjPanelVendasNovo());
			getControlJPanelVendasNovo();
		}
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// Quando o campo DataInicial ganhar foco
		if(e.getSource() == getjPanelVendas().getjTFieldDTInicial()) {			
			Mascara.setMascara(getjPanelVendas().getjTFieldDTInicial(), Mascara.mascaraData());		
		}
		
		
		// Quando o campo DataFinal ganhar foco		
		else if(e.getSource() == getjPanelVendas().getjTFieldDTFinal()) {			
			Mascara.setMascara(getjPanelVendas().getjTFieldDTFinal(), Mascara.mascaraData());		
		}
	}

	
	@Override
	public void focusLost(FocusEvent e) {
		// Quando o campo dataInicial perder o foco
		if(e.getSource() == getjPanelVendas().getjTFieldDTInicial()) {
			// Verificar se não está vazio
			String dataInicial = getjPanelVendas().getjTFieldDTInicial().getText().replace(" ", "").replace("/", "");
			if(!dataInicial.isEmpty()) {
				// Verifica se está faltando números
				if(dataInicial.length() < 8) {					
					getjPanelVendas().getjTFieldDTInicial().setText("");				
				}
				// Verifica se é válido
				else if(!Mascara.validandoData(getjPanelVendas().getjTFieldDTInicial().getText())){
					JOptionPane.showConfirmDialog(
						getjPanelVendas(), // componente
						"Data inválida, digite novamente", // texto
						"Data inválida", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					getjPanelVendas().getjTFieldDTInicial().setText("");
					getjPanelVendas().getjTFieldDTInicial().requestFocus();					
				}
			}	
				
		}
		
		
		// Quando o campo dataFinal perder o foco
		else if(e.getSource() == getjPanelVendas().getjTFieldDTFinal()) {
			// Verificar se não está vazio
			String dataFinal = getjPanelVendas().getjTFieldDTFinal().getText().replace(" ", "").replace("/", "");
			if(!dataFinal.isEmpty()) {
				// Verifica se está faltando números
				if(dataFinal.length() < 8) {					
					getjPanelVendas().getjTFieldDTFinal().setText("");				
				}
				// Verifica se é válido
				else if(!Mascara.validandoData(getjPanelVendas().getjTFieldDTFinal().getText())){
					JOptionPane.showConfirmDialog(
						getjPanelVendas(), // componente
						"Data inválida, digite novamente", // texto
						"Data inválida", // titulo
						JOptionPane.DEFAULT_OPTION, // botões
						JOptionPane.INFORMATION_MESSAGE // tipo de mensagem
						);
					getjPanelVendas().getjTFieldDTFinal().setText("");
					getjPanelVendas().getjTFieldDTFinal().requestFocus();					
				}
			}		
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Quando for selecionado algum ítem do choice FormPesquisa
		if(e.getSource() == getjPanelVendas().getChoiceFormPesquisa()) {
			// Verificar qual ítem foi selecionado
			switch(getjPanelVendas().getChoiceFormPesquisa().getSelectedItem().replace(" ", "")) {
			case "Cliente":
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(true);
				getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
				break;
				
			case "Vendedor":
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(true);
				getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
				break;
				
			case "Cartão":
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
				
			case "Dinheiro":
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
			}
		}
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// Quando o JFrame for ativado
		if(e.getSource() == getjFramePricipal()) {
			// Atualizar a tabela de vendas
			System.out.println("Atualizou tabela vendas");
			getdDaoJPanelVendas().consultarVendas();
		}
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	


		
	//** Fim métodos sobrescritos **
	
	//** Início métodos da classe **

	public JFramePrincipal getjFramePricipal() {
		if(jFramePricipal == null) {
			jFramePricipal = new JFramePrincipal();
		}
		return jFramePricipal;
	}



	public JPanelVendas getjPanelVendas() {
		if(jPanelVendas == null) {
			jPanelVendas = new JPanelVendas();
		}
		return jPanelVendas;
	}



	public JPanelPrincipal getjPanelPrincipal() {
		if(jPanelPrincipal == null) {
			jPanelPrincipal = new JPanelPrincipal();
		}
		return jPanelPrincipal;
	}		
		
		
	public JPanelVendasNovo getjPanelVendasNovo() {
		if(jPanelVendasNovo == null){
			jPanelVendasNovo = new JPanelVendasNovo();	
		}
		return jPanelVendasNovo;
	}	
	
		
	public DaoJPanelVendas getdDaoJPanelVendas() {
		if(daoJPanelVendas == null){
			daoJPanelVendas = new DaoJPanelVendas(getjPanelVendas());	
		}
		return daoJPanelVendas;
	}


	public ControlJPanelVendasNovo getControlJPanelVendasNovo() {
		if(controlJPanelVendasNovo == null){
			controlJPanelVendasNovo = new ControlJPanelVendasNovo(getjFramePricipal(), getjPanelVendasNovo(),
					getjPanelVendas(), getjPanelPrincipal());
	
		}
		return controlJPanelVendasNovo;
	}
	//** Fim métodos da classe **	








}
