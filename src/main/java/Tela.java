import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

public class Tela {

	
	
	JFrame jframe;
	JPanel jpanel;
	
	JLabel jlabelServico = new JLabel("Serviço:");
	JTextField jtextfieldServico = new JTextField();
	
	JLabel jlabelPeriodo = new JLabel("Período:");
	JTextField jtextfieldPeriodo = new JTextField();
	
	JLabel jlabelLivro = new JLabel("Livro:");
	JTextField jtextfieldLivro = new JTextField();
	
	JLabel jlabelNumeroDoRegistro = new JLabel("Número do Registro:");
	JTextField jtextfieldNumeroDoRegistro = new JTextField();
	
	JLabel jlabelDataDoAto = new JLabel("Data do Ato:");
	JTextField jtextfieldDataDoAto = new JTextField();
	
	JLabel jlabelNumeroDoAto = new JLabel("Número do Ato:");
	JTextField jtextfieldNumeroDoAto = new JTextField();
	
	
	JLabel jlabelNumeroDoProtocolo = new JLabel("Número do Protocolo:");
	JTextField jtextfieldNumeroDoProtocolo = new JTextField();
	
	JLabel jlabelNumeroDaImagem = new JLabel("Número da Imagem:");
	JTextField jtextfieldNumeroDaImagem = new JTextField();
	
	JLabel jlabelTipoDoAto = new JLabel("Tipo do Ato:");
	JTextField jtextfieldTipoDoAto = new JTextField();
	
	JLabel jlabelPlantaOuMemorial = new JLabel("Planta ou Memorial:");
	JTextField jtextfieldPlantaOuMemorial = new JTextField();
	
	JLabel jlabelQuadra = new JLabel("Quadra:");
	JTextField jtextfieldQuadra = new JTextField();
	
	JLabel jlabelLote = new JLabel("Lote:");
	JTextField jtextfieldLote = new JTextField();
	
	JLabel jlabelCPFCNPJCEI = new JLabel("CPF/CNPJ/CEI:");
	JTextField jtextfieldCPFCNPJCEI = new JTextField();
	
	JLabel jlabelTipoDoDocumento = new JLabel("Tipo do Documento:");
	JTextField jtextfieldTipoDoDocumento = new JTextField();
	
	JLabel jlabelOrigem = new JLabel("Origem:");
	JTextField jtextfieldOrigem = new JTextField();
	
	JLabel jlabelEspecieDoAto = new JLabel("Espécie do Ato:");
	JTextField jtextfieldEspecieDoAto = new JTextField();
	
	JLabel jlabelCaixaDoArquivo = new JLabel("Caixa do Arquivo:");
	JTextField jtextfieldCaixaDoArquivo = new JTextField();
	

	JButton jbuttonSalvar = new JButton("Salvar");
//	Estao digitalizado em:
	
	
//	
	
	
	public void run() {
		jframe = new JFrame();
		jpanel = new JPanel(new MigLayout("fillx"));
	
		
		buildScreen();
		
		jframe.setContentPane(jpanel);
		jframe.setSize(500, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		
	}
	private void buildScreen() {
		jpanel.add(jlabelServico, "");
		jpanel.add(jtextfieldServico, "growx, pushx, wrap");
//		String.format("%1$05d %2$05d", i, i + 10)
		
		jtextfieldServico.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void removeUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void insertUpdate(DocumentEvent e) {
				    warn();
				  }

				  public void warn() {
//				     System.out.println(String.format("%1$05d", jtextfieldServico.getText()));
				  }
				});
		
		
		jpanel.add(jlabelPeriodo);
		jpanel.add(jtextfieldPeriodo, "growx, pushx, wrap");
		
		jpanel.add(jlabelLivro);
		jpanel.add(jtextfieldLivro, "growx, pushx, wrap");
		
		jpanel.add(jlabelNumeroDoRegistro);
		jpanel.add(jtextfieldNumeroDoRegistro, "growx, pushx, wrap");
		
		jpanel.add(jlabelDataDoAto);
		jpanel.add(jtextfieldDataDoAto, "growx, pushx, wrap");
		
		jpanel.add(jlabelNumeroDoAto);
		jpanel.add(jtextfieldNumeroDoAto, "growx, pushx, wrap");
		
		jpanel.add(jlabelNumeroDoProtocolo);
		jpanel.add(jtextfieldNumeroDoProtocolo, "growx, pushx, wrap");
		
		jpanel.add(jlabelNumeroDaImagem);
		jpanel.add(jtextfieldNumeroDaImagem, "growx, pushx, wrap");
		
		jpanel.add(jlabelTipoDoAto);
		jpanel.add(jtextfieldTipoDoAto, "growx, pushx, wrap");
		
		jpanel.add(jlabelPlantaOuMemorial);
		jpanel.add(jtextfieldPlantaOuMemorial, "growx, pushx, wrap");
		
		jpanel.add(jlabelQuadra);
		jpanel.add(jtextfieldQuadra, "growx, pushx, wrap");
		
		jpanel.add(jlabelLote);
		jpanel.add(jtextfieldLote, "growx, pushx, wrap");
		
		jpanel.add(jlabelCPFCNPJCEI);
		jpanel.add(jtextfieldCPFCNPJCEI, "growx, pushx, wrap");
		
		jpanel.add(jlabelTipoDoDocumento);
		jpanel.add(jtextfieldTipoDoDocumento, "growx, pushx, wrap");
		
		jpanel.add(jlabelOrigem);
		jpanel.add(jtextfieldOrigem, "growx, pushx, wrap");

		jpanel.add(jlabelEspecieDoAto);
		jpanel.add(jtextfieldEspecieDoAto, "growx, pushx, wrap");
		
		jpanel.add(jlabelCaixaDoArquivo);
		jpanel.add(jtextfieldCaixaDoArquivo, "growx, pushx, wrap");
		
		jpanel.add(jbuttonSalvar, "growx");
		
		
		
//		Estao digitalizado em:
		
		
//		
		
	
	}
}
