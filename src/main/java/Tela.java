import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
public File pasta;
public File arquivo;


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
		
	}
	
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
		
		buildSalvarButton();
		
		jframe.setContentPane(jpanelprincipal);
		jframe.setSize(500, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jframe.setVisible(true);
		
	}
	
	public void buildSalvarButton() {
		
	jbuttonSalvar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Component[] components = jpanel_dados_principais.getComponents();
			List<String> linhas = new ArrayList();
			StringBuilder sb = new StringBuilder();
			String linha = "";
			for(int i = 0; i< components.length;i++) {
				if(components[i] instanceof JLabel) {
					linha = ((JLabel)components[i]).getText() + " ";
					sb.append(linha);
				}
				if(components[i] instanceof JTextField) {
					linha = linha + (((JTextField)components[i]).getText());
					linhas.add(linha);
					sb.append(linha);
					linha ="";

				}
			}
			
			
//			BufferedImage image = convertTextToGraphic(textos, new Font("Arial", Font.PLAIN, 18));
		    java.util.Properties properties = System.getProperties();
			 String home = properties.get("user.home").toString();
			    String separator = properties.get("file.separator").toString();
			    String directoryName = "cartorio";
			    String fileName = System.currentTimeMillis() + ".png";
			    
			    File dir = new File(home+separator+directoryName);
			    dir.mkdir();    
			    File file = new File(dir,fileName);

			    // the rest of your code
			    try {
			        if (file.createNewFile()) {
			            System.out.println("created new fle");
			        } else {
			            System.out.println("could not create a new file");
			        }
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    }

		
//		    //write BufferedImage to file
		    try {
				ImageIO.write(createImage(linhas), "png", file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		
		
	
	
	
		jpanelprincipal.add(jbuttonSalvar, " span, growx");

	}
	

	
	
	public BufferedImage createImage(List<String> linhas) {
	      int width = 595;
	        int height = 842;
	        int fontSize;
	        int nextLinePosition = 16;
	        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = img.createGraphics();
	        Font font = new Font("Arial", Font.PLAIN, 18);
	        g2d.setFont(font);
	        FontMetrics fm = g2d.getFontMetrics();

	        g2d.dispose();

	        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        g2d = img.createGraphics();
	        
	        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	        g2d.setFont(font);
	        //fm = g2d.getFontMetrics();1
	        g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0, width, height);
	        g2d.setBackground(Color.YELLOW);


            g2d.drawString("OS DOCUMENTOS A QUE SE REFEREM AS INFORMAÇÕES ABAIXO:", 0, nextLinePosition);
	      
	        g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0, width, height);
	        g2d.setColor(Color.BLACK);

	        fontSize = font.getSize();
	        nextLinePosition=16;

	        for(int i = 0; i< linhas.size();i++) {
	               g2d.drawString(linhas.get(i), 0, nextLinePosition);
	               nextLinePosition = nextLinePosition + fontSize;
	        }
	       


	        g2d.dispose();
//	        try {
//	            ImageIO.write(img, "png", new File("Text.png"));
//	        } catch (IOException ex) {
//	            ex.printStackTrace();
//	        }
	        
	        return img;
		
	}
	
}



