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

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import dao.DaoJPanelVendas;
import model.Cores;
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
	
	private String data1;
	private String data2;
	
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
		getjPanelVendas().getjTFieldFormPesquisa().addKeyListener(this);
		getjPanelVendas().getjTFieldDTFinal().addFocusListener(this);
		getjPanelVendas().getChoiceFormPesquisa().addItemListener(this);
		
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
		// Quando for digitado em pesquisar como
		if(e.getSource() == getjPanelVendas().getjTFieldFormPesquisa()) {
			// Verificar seleção no choice			
			switch(getjPanelVendas().getChoiceFormPesquisa().getSelectedItem().replace(" ", "")) {
			case "Vendedor":
				getDaoJPanelVendas().consultaVendasVendedor(getjPanelVendas().getjTFieldFormPesquisa().getText());
				break;
				
			case "Cliente":
				getDaoJPanelVendas().consultaVendasCliente(getjPanelVendas().getjTFieldFormPesquisa().getText());
				break;
			}
		}
		
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
		
		
		// Quando o botão pesquisar todos for clicado
		else if(e.getSource() == getjPanelVendas().getjButtonPesquisarTodos()) {
			// Realizar buscas de todos as vendas
			getjPanelVendas().getjTFieldFormPesquisa().setText("");
			getDaoJPanelVendas().consultarVendas();
		}
		
		
		// Quando o botão filtrar for clicado
		else if(e.getSource() == getjPanelVendas().getjButtonFiltrar()) {
			// Colocar foco no jtfild
			getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
			// Verificar se o campo data1 está preenchido
			if(getData1() == null || getData1().replace("/", "").isEmpty()) {
				// Colocar o foco no campo data1
				getjPanelVendas().getjTFieldDTInicial().setBorder(BorderFactory.
						createLineBorder(Cores.vermelho, 1, false));
				getjPanelVendas().getjTFieldDTInicial().requestFocus();
				
			}
			// Verificar se o campo data2 está preenchido
			else if(getData2() == null || getData2().replace("/", "").isEmpty()) {
				// Colocar o foco no campo data2
				getjPanelVendas().getjTFieldDTFinal().setBorder(BorderFactory.
						createLineBorder(Cores.vermelho, 1, false));	
				getjPanelVendas().getjTFieldDTFinal().requestFocus();			
				
			}
			// Verificar  se a data1 é menor ou igual a data2
			else {
				getDaoJPanelVendas().consultaVendasData(getData1(), getData2());
			}
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
					Mascara.setMascara(getjPanelVendas().getjTFieldDTInicial(), Mascara.mascaraNula());
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
				// se for válida
				else {
					setData1(getjPanelVendas().getjTFieldDTInicial().getText());
					getjPanelVendas().getjTFieldDTInicial().setBorder(BorderFactory.
							createLineBorder(Cores.cinza2, 1, false));		
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
					Mascara.setMascara(getjPanelVendas().getjTFieldDTFinal(), Mascara.mascaraNula());				
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
					getjPanelVendas().getjTFieldDTFinal().setText(null);
					getjPanelVendas().getjTFieldDTFinal().requestFocus();					
				}
				// se for válida
				else {
					setData2(getjPanelVendas().getjTFieldDTFinal().getText());
					getjPanelVendas().getjTFieldDTFinal().setBorder(BorderFactory.
							createLineBorder(Cores.cinza2, 1, false));	
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
											
			case "Cartão":
				// Realizar a buscas no banco de dados
				System.out.println("pesquisa cartão");
				getDaoJPanelVendas().consultaVendasCartao();
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
				
			case "Dinheiro":
				// Realizar a buscas no banco de dados
				getDaoJPanelVendas().consultaVendasDinheiro();
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(false);
				break;
				
			default:
				// Realizar a buscas no banco de dados
				getjPanelVendas().getjTFieldFormPesquisa().setEnabled(true);
				getjPanelVendas().getjTFieldFormPesquisa().requestFocus();
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
			getDaoJPanelVendas().consultarVendas();
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
	
		
	public DaoJPanelVendas getDaoJPanelVendas() {
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




	public String getData1() {
		return data1;
	}




	public void setData1(String data1) {
		this.data1 = data1.replace(" ", "");
	}




	public String getData2() {
		return data2;
	}




	public void setData2(String data2) {
		this.data2 = data2.replace(" ", "");
	}
	
	
	
	//** Fim métodos da classe **	








}
