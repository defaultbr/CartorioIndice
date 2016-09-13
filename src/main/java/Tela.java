import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class Tela {

	
	
	JFrame jframe;
	JPanel jpanelprincipal;
	JPanel jpanel_dados_principais;
	JPanel jpanel_onde_estao_digitalizados;
	
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
	

	
	
	
	////Dados da pessoa
	
	JLabel jlblNome = new JLabel("Nome:");
	JTextField jtxtNome = new JTextField();
	
	JLabel jlblProcessoNumero = new JLabel("Processo Número:");
	JTextField jtxtProcessoNumero = new JTextField();
	
	JLabel jlblNumerosAnteriores = new JLabel("Números Anteriores:");
	JTextField jtxtNumerosAnteriores = new JTextField();
	
	JLabel jlblObservacoes = new JLabel("Observações:");
	JTextField jtxtObservacoes = new JTextField();
	
	

	
//	Estao digitalizado em:
	JLabel jlblOndeEstaoProtocoloNumero = new JLabel("Protocolo N:");
	JTextField jtxtOndeEstaoProtocoloNumero = new JTextField();
	
	JLabel jlblOndeEstaoLivroNumero = new JLabel("Livro N:");
	JTextField jtxtOndeEstaoLivroNumero = new JTextField();
	
	JLabel jlblOndeEstaoNumeroDoRegistro = new JLabel("Numero do Registro:");
	JTextField jtxtOndeEstaoNumeroDoRegistro = new JTextField();
	
	JLabel jlblOndeEstaoNumeroDaImagem = new JLabel("Número da Imagem:");
	JTextField jtxtOndeEstaoNumeroDaImagem = new JTextField();
	
	JLabel jlblOndeEstaoAtoNumero = new JLabel("Ato N:");
	JTextField jtxtOndeEstaoAtoNumero = new JTextField();
	
	JLabel jlblOndeEstaoPlantaOuMemorial = new JLabel("Planta ou Memorial:");
	JTextField jtxtOndeEstaoPlantaOuMemorial = new JTextField();
	
	JLabel jlblOndeEstaoQuadraNumero = new JLabel("Quadra N:");
	JTextField jtxtOndeEstaoQuadraNumero = new JTextField();
	
	JLabel jlblOndeEstaoLoteNumero = new JLabel("Lote N:");
	JTextField jtxtOndeEstaoLoteNumero = new JTextField();
	
	JLabel jlblOndeEstaoPastaDigital = new JLabel("Pasta Digital:");
	JTextField jtxtOndeEstaoPastaDigital = new JTextField();
	
	
	
	
	JLabel jlblPrincipalNome = new JLabel("Nome:");
	JTextField jtxtPrincipalNome = new JTextField();
	
	JLabel jlblPrincipalProcessoNumero = new JLabel("Processo Número:");
	JTextField jtxtPrincipalProcessoNumero = new JTextField();
	
	
//	
	JButton jbuttonSalvar = new JButton("Salvar");

	
	
	public void run() {
		jframe = new JFrame();
		jpanelprincipal = new JPanel(new MigLayout("fillx"));
		jpanel_dados_principais = new JPanel(new MigLayout("fillx"));
		jpanel_onde_estao_digitalizados = new JPanel(new MigLayout("fillx"));
		 
	
		TitledBorder titled1 = new TitledBorder("Dados Principais");
		TitledBorder titled2 = new TitledBorder("Onde Estão Digitalizados");
	    jpanel_dados_principais.setBorder(titled1);
	    jpanel_onde_estao_digitalizados.setBorder(titled2);
		
		
		buildScreen();
		
		jpanelprincipal.add(jpanel_dados_principais, "growx, wrap, span");
		jpanelprincipal.add(jpanel_onde_estao_digitalizados, "growx, span, wrap");
		jpanelprincipal.add(jlblPrincipalNome);
		jpanelprincipal.add(jtxtPrincipalNome, "growx, span, pushx, wrap");
		
		jpanelprincipal.add(jlblPrincipalProcessoNumero);
		jpanelprincipal.add(jtxtPrincipalProcessoNumero, "growx, pushx, span, wrap");
		
		jpanelprincipal.add(jbuttonSalvar, "growx, span");

		
		jframe.setContentPane(jpanelprincipal);
		jframe.setSize(500, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		jframe.setUndecorated(true);
		jframe.setVisible(true);
		
	}
	private void buildScreen() {
		jpanel_dados_principais.add(jlabelServico, "");
		jpanel_dados_principais.add(jtextfieldServico, "growx, pushx");
//		String.format("%1$05d %2$05d", i, i + 10)
	
		jpanel_dados_principais.add(jlabelPeriodo);
		jpanel_dados_principais.add(jtextfieldPeriodo, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelLivro);
		jpanel_dados_principais.add(jtextfieldLivro, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelNumeroDoRegistro);
		jpanel_dados_principais.add(jtextfieldNumeroDoRegistro, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelDataDoAto);
		jpanel_dados_principais.add(jtextfieldDataDoAto, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelNumeroDoAto);
		jpanel_dados_principais.add(jtextfieldNumeroDoAto, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelNumeroDoProtocolo);
		jpanel_dados_principais.add(jtextfieldNumeroDoProtocolo, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelNumeroDaImagem);
		jpanel_dados_principais.add(jtextfieldNumeroDaImagem, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelTipoDoAto);
		jpanel_dados_principais.add(jtextfieldTipoDoAto, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelPlantaOuMemorial);
		jpanel_dados_principais.add(jtextfieldPlantaOuMemorial, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelQuadra);
		jpanel_dados_principais.add(jtextfieldQuadra, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelLote);
		jpanel_dados_principais.add(jtextfieldLote, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelCPFCNPJCEI);
		jpanel_dados_principais.add(jtextfieldCPFCNPJCEI, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelTipoDoDocumento);
		jpanel_dados_principais.add(jtextfieldTipoDoDocumento, "growx, pushx, wrap");
		
		jpanel_dados_principais.add(jlabelOrigem);
		jpanel_dados_principais.add(jtextfieldOrigem, "growx, pushx, span, wrap");

		jpanel_dados_principais.add(jlabelEspecieDoAto);
		jpanel_dados_principais.add(jtextfieldEspecieDoAto, "growx, pushx");
		
		jpanel_dados_principais.add(jlabelCaixaDoArquivo);
		jpanel_dados_principais.add(jtextfieldCaixaDoArquivo, "growx, pushx, wrap");
		
		
		
		
		
//		Dados da pessoa
		jpanel_dados_principais.add(jlblNome);
		jpanel_dados_principais.add(jtxtNome, "growx, pushx, span, wrap, gapy 20");
		
		jpanel_dados_principais.add(jlblProcessoNumero);
		jpanel_dados_principais.add(jtxtProcessoNumero, "growx, pushx, span, wrap");
		
		jpanel_dados_principais.add(jlblNumerosAnteriores);
		jpanel_dados_principais.add(jtxtNumerosAnteriores, "growx, pushx, span, wrap");
		
		jpanel_dados_principais.add(jlblObservacoes);
		jpanel_dados_principais.add(jtxtObservacoes, "growx, pushx, span, wrap");
		
		
//		
		
//		Estao digitalizado em:

		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoProtocoloNumero);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoProtocoloNumero, "growx, pushx");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoLivroNumero);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoLivroNumero, "growx, pushx, wrap");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoNumeroDoRegistro);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoNumeroDoRegistro, "growx, pushx");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoNumeroDaImagem);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoNumeroDaImagem, "growx, pushx, wrap");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoAtoNumero);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoAtoNumero, "growx, pushx");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoPlantaOuMemorial);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoPlantaOuMemorial, "growx, pushx, wrap");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoQuadraNumero);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoQuadraNumero, "growx, pushx");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoLoteNumero);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoLoteNumero, "growx, pushx, wrap");
		
		jpanel_onde_estao_digitalizados.add(jlblOndeEstaoPastaDigital);
		jpanel_onde_estao_digitalizados.add(jtxtOndeEstaoPastaDigital, "growx, pushx, span, wrap");
		
		
//
	
		
		
		

		

		
		
//		
		
	
	}
}
