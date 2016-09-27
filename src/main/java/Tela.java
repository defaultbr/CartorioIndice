import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.management.AttributeValueExp;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import net.miginfocom.swing.MigLayout;

public class Tela {

	Paragraph paragrafo;
	Document doc;
	List<Element> elements;
	Element element;
	String regex_backup = "^(.{5})(.{4})(.{10})(.{12})(.{13})(.{6})(.{9})(.{12})(.{4})(.{9})(.{9})(.{9})(.{17})(.{6})(.{25})(.{9})(.{6})";

	Pattern p = Pattern.compile(regex_backup);
	Matcher m;

	String text;
	Pattern p2;
	Matcher m2;

	int pos;
	int porcentagem = 50;
	JFrame jframe;
	JPanel jpanelprincipal;
	JPanel jpanelEsquerdo;
	JPanel jpanelDireito;
	JPanel jpanel_dados_principais;
	JPanel jpanel_onde_estao_digitalizados;
	JPanel jpanel_final;
	JPanel jpanel_zoom_options;
	JFileChooser jfc_folder;
	JScrollPane jscroll_pane_imagem;
	List<String> linhas_informacoes = new ArrayList();
	List<String> linhas_onde_digitalizados = new ArrayList();
	List<String> linhas_final = new ArrayList();
	String linha = "";
	JLabel picLabel;
	BufferedImage myPicture = null;
	File[] arquivos;
	ImageIcon icon;

	JButton jbtn_escolher_pasta;

	JButton btn_img_anterior = new JButton("Anterior");
	JLabel jlbl_posicao = new JLabel("0/0");
	JButton btn_img_proxima = new JButton("Proxima");
	JButton btn_img_zoommais = new JButton("+");
	JLabel jlbl_zoom_porcentagem = new JLabel("0%");
	JButton btn_img_zoommenos = new JButton("-");

	JLabel jlabelServico = new JLabel("Serviço:");
	JTextField jtextfieldServico = new JTextField(5);

	JLabel jlabelPeriodo = new JLabel("Período:");
	JTextField jtextfieldPeriodo = new JTextField(4);

	JLabel jlabelLivro = new JLabel("Livro:");
	JTextField jtextfieldLivro = new JTextField(10);

	JLabel jlabelNumeroDoRegistro = new JLabel("Número do Registro:");
	JTextField jtextfieldNumeroDoRegistro = new JTextField(12);

	JLabel jlabelDataDoAto = new JLabel("Data do Ato:");
	JTextField jtextfieldDataDoAto = new JTextField(13);

	JLabel jlabelNumeroDoAto = new JLabel("Número do Ato:");
	JTextField jtextfieldNumeroDoAto = new JTextField(6);

	JLabel jlabelNumeroDoProtocolo = new JLabel("Número do Protocolo:");
	JTextField jtextfieldNumeroDoProtocolo = new JTextField(9);

	JLabel jlabelNumeroDaImagem = new JLabel("Número da Imagem:");
	JTextField jtextfieldNumeroDaImagem = new JTextField(12);

	JLabel jlabelTipoDoAto = new JLabel("Tipo do Ato:");
	JTextField jtextfieldTipoDoAto = new JTextField(4);

	JLabel jlabelPlantaOuMemorial = new JLabel("Planta ou Memorial:");
	JTextField jtextfieldPlantaOuMemorial = new JTextField(9);

	JLabel jlabelQuadra = new JLabel("Quadra:");
	JTextField jtextfieldQuadra = new JTextField(9);

	JLabel jlabelLote = new JLabel("Lote:");
	JTextField jtextfieldLote = new JTextField(9);

	JLabel jlabelCPFCNPJCEI = new JLabel("CPF/CNPJ/CEI:");
	JTextField jtextfieldCPFCNPJCEI = new JTextField(17);

	JLabel jlabelTipoDoDocumento = new JLabel("Tipo do Documento:");
	JTextField jtextfieldTipoDoDocumento = new JTextField(6);

	JLabel jlabelOrigem = new JLabel("Origem:");
	JTextField jtextfieldOrigem = new JTextField(25);

	JLabel jlabelEspecieDoAto = new JLabel("Espécie do Ato:");
	JTextField jtextfieldEspecieDoAto = new JTextField(9);

	JLabel jlabelCaixaDoArquivo = new JLabel("Caixa do Arquivo:");
	JTextField jtextfieldCaixaDoArquivo = new JTextField(6);

	//// Dados da pessoa

	JLabel jlblNome = new JLabel("Nome da Pessoa:");
	JTextField jtxtNome = new JTextField();

	JLabel jlblProcessoNumero = new JLabel("Processo Número:");
	JTextField jtxtProcessoNumero = new JTextField();

	JLabel jlblNumerosAnteriores = new JLabel("Números Anteriores:");
	JTextField jtxtNumerosAnteriores = new JTextField();

	JLabel jlblObservacoes = new JLabel("Observações:");
	JTextField jtxtObservacoes = new JTextField();

	// Estao digitalizado em:
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
	private File img_mostrando;
	private JPanel jpanel_com_jscroll;
	protected Component[] components;

	private void buildScreen() {
		jpanel_dados_principais.add(jlabelServico, "");
		jpanel_dados_principais.add(jtextfieldServico, "growx, pushx");
		// String.format("%1$05d %2$05d", i, i + 10)

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

		// Dados da pessoa
		jpanel_dados_principais.add(jlblNome);
		jpanel_dados_principais.add(jtxtNome, "growx, pushx, span, wrap, gapy 20");

		jpanel_dados_principais.add(jlblProcessoNumero);
		jpanel_dados_principais.add(jtxtProcessoNumero, "growx, pushx, span, wrap");

		jpanel_dados_principais.add(jlblNumerosAnteriores);
		jpanel_dados_principais.add(jtxtNumerosAnteriores, "growx, pushx, span, wrap");

		// jpanel_dados_principais.add(jlblObservacoes);
		// jpanel_dados_principais.add(jtxtObservacoes, "growx, pushx, span,
		// wrap");

		//

		// Estao digitalizado em:

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
		jpanelprincipal = new JPanel(new MigLayout("debug, fillx", "[grow, 50%][grow, 50%]"));
		jpanelEsquerdo = new JPanel(new MigLayout("fillx"));
		jpanelDireito = new JPanel(new MigLayout("fillx"));
		jpanel_dados_principais = new JPanel(new MigLayout("fillx"));
		jpanel_onde_estao_digitalizados = new JPanel(new MigLayout("fillx"));
		jpanel_final = new JPanel(new MigLayout("fillx"));
		jpanel_zoom_options = new JPanel(new MigLayout("fillx"));
		btn_img_anterior = new JButton("Anterior");
		btn_img_anterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior();
			}
		});
		jlbl_posicao = new JLabel("0/0");
		btn_img_proxima = new JButton("Proxima");
		btn_img_proxima.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				proxima();
			}
		});
		btn_img_zoommais = new JButton("+");
		btn_img_zoommais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (porcentagem < 100) {
					porcentagem = porcentagem + 10;
				}
				mostrarImagem(pos);

			}
		});
		jlbl_zoom_porcentagem = new JLabel(porcentagem + "%");
		btn_img_zoommenos = new JButton("-");
		btn_img_zoommenos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (porcentagem > 0) {
					porcentagem = porcentagem - 10;
				}
				mostrarImagem(pos);

			}
		});
		jfc_folder = new JFileChooser();
		// jfc_folder.setControlButtonsAreShown( false );
		jfc_folder.setFileFilter(new FolderFilter());
		jfc_folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jbtn_escolher_pasta = new JButton("Abrir Pasta");

		TitledBorder titled1 = new TitledBorder("Dados Principais");
		TitledBorder titled2 = new TitledBorder("Onde Estão Digitalizados");
		jpanel_dados_principais.setBorder(titled1);
		jpanel_onde_estao_digitalizados.setBorder(titled2);

		jpanelEsquerdo.add(jpanel_dados_principais, "growx, wrap");
		jpanelEsquerdo.add(jpanel_onde_estao_digitalizados, "growx, wrap");
		jpanelEsquerdo.add(jpanel_final, "growx, wrap");

		jpanelprincipal.add(jpanelEsquerdo, "growx");

		jpanelprincipal.add(jpanelDireito, "grow, wrap");

		buildScreen();

		buildSalvarButton();

		jpanel_final.add(jlblPrincipalNome, "");
		jpanel_final.add(jtxtPrincipalNome, "growx, pushx, wrap");

		jpanel_final.add(jlblPrincipalProcessoNumero);
		jpanel_final.add(jtxtPrincipalProcessoNumero, "growx, pushx, wrap");

		jpanel_final.add(jlblObservacoes);
		jpanel_final.add(jtxtObservacoes, "growx, pushx, wrap");

		jpanel_final.add(jbuttonSalvar, "grow");
		jpanel_final.add(jbtn_escolher_pasta, "");
		jpanelprincipal.add(jpanel_final, "growx, span, wrap");
		buildImagePanel();

		String folder = "//home//tarcisio//0AAAAAAAAAAA//";
		jbtn_escolher_pasta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfc_folder.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					arquivos = jfc_folder.getSelectedFile().listFiles();
					if (arquivos != null && arquivos.length > 0) {
						mostrarImagem(0);
					} else {
						jlbl_posicao.setText("0/0");
					}
				}
			}
		});

		try {
			ativarValidacoes();
			jtextfieldServico.setText(" ");
			jtextfieldPeriodo.setText(" ");
			jtextfieldLivro.setText(" ");
			jtextfieldNumeroDoRegistro.setText(" ");
			jtextfieldDataDoAto.setText(" ");
			jtextfieldNumeroDoAto.setText(" ");
			jtextfieldNumeroDoProtocolo.setText(" ");
			jtextfieldNumeroDaImagem.setText(" ");
			jtextfieldTipoDoAto.setText(" ");
			jtextfieldPlantaOuMemorial.setText(" ");
			jtextfieldQuadra.setText(" ");
			jtextfieldLote.setText(" ");
			jtextfieldCPFCNPJCEI.setText(" ");
			jtextfieldTipoDoDocumento.setText(" ");
			jtextfieldOrigem.setText(" ");
			jtextfieldEspecieDoAto.setText(" ");
			jtextfieldCaixaDoArquivo.setText(" ");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		jframe.setContentPane(jpanelprincipal);
		jframe.setSize(500, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jframe.setVisible(true);

	}

	protected void mostrarImagem(int posicao) {

		jlbl_zoom_porcentagem.setText(porcentagem + "%");
		jlbl_posicao.setText((posicao + 1) + "/" + arquivos.length);
		img_mostrando = arquivos[posicao];

		try {
			icon = new ImageIcon(ImageIO.read(new File(img_mostrando.getAbsolutePath())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (img_mostrando != null) {
			preencherCampos(img_mostrando.getName());

			icon = new ImageIcon(icon.getImage().getScaledInstance((int) (icon.getIconWidth() * porcentagem / 100),
					(int) (icon.getIconHeight() * porcentagem / 100), Image.SCALE_SMOOTH));
			if (porcentagem > 0 && porcentagem < 100 && icon.getIconHeight() > 0 && icon.getIconWidth() > 0) {
				icon = new ImageIcon(icon.getImage().getScaledInstance((int) (icon.getIconWidth() * porcentagem / 100),
						(int) (icon.getIconHeight() * porcentagem / 100), Image.SCALE_SMOOTH));

			} else {
				icon = null;
			}

			picLabel.setIcon(icon);
			picLabel.setText("");
			picLabel.invalidate();
			picLabel.repaint();
		}

	}

	public void proxima() {
		if (arquivos != null && arquivos.length > 0 && pos < (arquivos.length - 1)) {
			pos++;
			mostrarImagem(pos);
		}

	}

	public void anterior() {
		if (arquivos != null && arquivos.length > 0 && pos > 0) {
			pos--;
			mostrarImagem(pos);
		}
	}

	public void buildSalvarButton() {

		jbuttonSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (arquivos.length > 0) {

					components = jpanel_dados_principais.getComponents();
					linhas_informacoes = new ArrayList();
					linhas_onde_digitalizados = new ArrayList();
					linhas_final = new ArrayList();
					linha = "";
					for (int i = 0; i < components.length; i++) {
						if (components[i] instanceof JLabel) {
							linha = ((JLabel) components[i]).getText() + " ";
						}
						if (components[i] instanceof JTextField) {
							linha = linha + (((JTextField) components[i]).getText());
							linhas_informacoes.add(linha);
							linha = "";

						}
					}

					components = jpanel_onde_estao_digitalizados.getComponents();

					for (int i = 0; i < components.length; i++) {
						if (components[i] instanceof JLabel) {
							linha = ((JLabel) components[i]).getText() + " ";
						}
						if (components[i] instanceof JTextField) {
							linha = linha + (((JTextField) components[i]).getText());
							linhas_onde_digitalizados.add(linha);
							linha = "";

						}
					}

					components = jpanel_final.getComponents();
					for (int i = 0; i < components.length; i++) {
						if (components[i] instanceof JLabel) {
							linha = ((JLabel) components[i]).getText() + " ";
						}
						if (components[i] instanceof JTextField) {
							linha = linha + (((JTextField) components[i]).getText());
							linhas_final.add(linha);
							linha = "";

						}
					}

					// BufferedImage image = convertTextToGraphic(textos, new
					// Font("Arial", Font.PLAIN, 18));
					// java.util.Properties properties = System.getProperties();
					// String home = properties.get("user.home").toString();
					// String separator =
					// properties.get("file.separator").toString();
					String directoryName = arquivos[pos].getParent();
					String fileName = arquivos[pos].getName().substring(0, arquivos[pos].getName().lastIndexOf("."))
							+ ".pdf";

					File dir = new File(directoryName);
					dir.mkdir();
					File file = new File(dir, fileName);

					// the rest of your code
					try {
						if (file.createNewFile()) {
							JOptionPane.showMessageDialog(null, "Arquivo Salvo");
							System.out.println("created new fle");
						} else {
							JOptionPane.showMessageDialog(null, "Ocorreu um erro, arquivo não salvo");
							System.out.println("could not create a new file");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					// //write BufferedImage to file

					generatePDF(linhas_informacoes, linhas_onde_digitalizados, linhas_final, file);
					// try {
					// ImageIO.write(createImage(linhas_informacoes,
					// linhas_onde_digitalizados, linhas_final), "png", file);
					// } catch (IOException e1) {
					// // TODO Auto-generated catch block
					// e1.printStackTrace();
					// }
				}
			}
		});

	}

	public BufferedImage createImage(List<String> linhas_informacoes, List<String> linhas_onde_digitalizados,
			List<String> linhas_final) {
		int width = 595;
		int height = 842;
		int fontSize;
		int nextLinePosition = 16;
		int padding_top = 4;
		int padding_bottom = 4;
		int padding_sides = 4;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		Font font;

		font = new Font("Arial", Font.PLAIN, 18);
		g2d.setFont(font);

		FontMetrics fm = g2d.getFontMetrics();
		String informações = "OS DOCUMENTOS A QUE SE REFERE AS INFORMAÇÕES ABAIXO:";
		String digitalizados = "DIGITALIZADOS EM";

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
		// fm = g2d.getFontMetrics();1
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.BLACK);

		// Drawing Informações TOPO
		font = new Font("Arial", Font.PLAIN, 26);
		g2d.setFont(font);
		nextLinePosition = font.getSize() + padding_top;
		Shape informacoes_shape = font.createGlyphVector(g2d.getFontMetrics().getFontRenderContext(), informações)
				.getOutline();
		// the shape returned is located at the left side of the baseline, this
		// means we need to re-align it to the top left corner. We also want to
		// set it the the center of the screen while we are there
		AffineTransform transform = AffineTransform.getTranslateInstance(
				-informacoes_shape.getBounds().getX() + width / 2 - informacoes_shape.getBounds().width / 2,
				-informacoes_shape.getBounds().getY() + nextLinePosition);
		informacoes_shape = transform.createTransformedShape(informacoes_shape);
		g2d.draw(informacoes_shape);

		font = new Font("Arial", Font.PLAIN, 18);
		g2d.setFont(font);
		fontSize = font.getSize();
		nextLinePosition = (int) (nextLinePosition + informacoes_shape.getBounds().getY() + nextLinePosition);

		for (int i = 0; i < linhas_informacoes.size(); i++) {
			if (linhas_informacoes.get(i).startsWith("Nome da Pessoa")) {
				nextLinePosition = nextLinePosition + 4;
				g2d.setColor(Color.RED);
				g2d.drawLine(padding_sides, nextLinePosition, width, nextLinePosition);
				g2d.setColor(Color.BLACK);
				nextLinePosition = (int) (nextLinePosition + 4 + informacoes_shape.getBounds().getY());
			}
			g2d.drawString(linhas_informacoes.get(i), padding_sides, nextLinePosition);
			nextLinePosition = nextLinePosition + fontSize;
		}

		// Drawing Informações DIGITALIZADOS EM
		font = new Font("Arial", Font.PLAIN, 26);
		g2d.setFont(font);
		nextLinePosition = nextLinePosition + font.getSize() + padding_top;
		Shape digitalizados_shape = font.createGlyphVector(g2d.getFontMetrics().getFontRenderContext(), digitalizados)
				.getOutline();
		// the shape returned is located at the left side of the baseline, this
		// means we need to re-align it to the top left corner. We also want to
		// set it the the center of the screen while we are there
		transform = AffineTransform.getTranslateInstance(
				-digitalizados_shape.getBounds().getX() + width / 2 - digitalizados_shape.getBounds().width / 2,
				-digitalizados_shape.getBounds().getY() + nextLinePosition);
		digitalizados_shape = transform.createTransformedShape(digitalizados_shape);
		g2d.draw(digitalizados_shape);
		//

		font = new Font("Arial", Font.PLAIN, 18);
		g2d.setFont(font);
		fontSize = font.getSize();
		nextLinePosition = (int) (informacoes_shape.getBounds().getY() * 2 + nextLinePosition);
		for (int i = 0; i < linhas_onde_digitalizados.size(); i++) {
			g2d.drawString(linhas_onde_digitalizados.get(i), padding_sides, nextLinePosition);
			nextLinePosition = nextLinePosition + fontSize;

		}

		g2d.dispose();
		return img;

	}

	public void generatePDF(List<String> informacoes, List<String> digitalizados_em, List<String> finais, File file) {
		com.itextpdf.text.Font fonte_titulo = FontFactory.getFont("Arial", 14);
		fonte_titulo.setColor(BaseColor.RED);
		com.itextpdf.text.Font fonte_paragrafo = FontFactory.getFont("Arial", 10);
		LineSeparator ls = new LineSeparator();

		try {
			// create a new document

			doc = new Document(PageSize.A4, 20, 20, 20, 20);
			PdfWriter.getInstance(doc, new FileOutputStream(file));

			doc.open();

			String informações = "OS DOCUMENTOS A QUE SE REFERE AS INFORMAÇÕES ABAIXO:";

			paragrafo = new Paragraph(informações);
			paragrafo.setAlignment(Element.ALIGN_CENTER);

			paragrafo.setFont(fonte_titulo);
			doc.add(paragrafo);

			for (int i = 0; i < informacoes.size(); i++) {
				if (informacoes.get(i).contains("Nome da")) {
					doc.add(new Chunk());
					doc.add(new Chunk());

				}
				paragrafo = new Paragraph(informacoes.get(i));
				paragrafo.setAlignment(Element.ALIGN_LEFT);
				paragrafo.setFont(fonte_paragrafo);
				doc.add(paragrafo);
			}

			doc.add(new Chunk(ls));

			paragrafo = new Paragraph("Estão Digitalizados:");
			paragrafo.setAlignment(Element.ALIGN_CENTER);
			paragrafo.setFont(fonte_titulo);
			doc.add(paragrafo);

			for (int i = 0; i < digitalizados_em.size(); i++) {

				paragrafo = new Paragraph(digitalizados_em.get(i));
				paragrafo.setAlignment(Element.ALIGN_LEFT);
				paragrafo.setFont(fonte_paragrafo);
				doc.add(paragrafo);
			}
			//
			doc.add(new Chunk(ls));
			// doc.add( Chunk.NEWLINE );

			for (int i = 0; i < finais.size(); i++) {
				paragrafo = new Paragraph(finais.get(i));
				paragrafo.setAlignment(Element.ALIGN_LEFT);
				paragrafo.setFont(fonte_paragrafo);
				doc.add(paragrafo);
			}
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buildImagePanel() {

		picLabel = new JLabel("Selecione a pasta de imagens");
		jscroll_pane_imagem = new JScrollPane(picLabel);
		jpanelDireito.add(jscroll_pane_imagem, "grow, push, wrap");
		jscroll_pane_imagem.setBackground(Color.red);
		jpanelDireito.add(jpanel_zoom_options);
		jpanel_zoom_options.add(btn_img_anterior);
		jpanel_zoom_options.add(jlbl_posicao);
		jpanel_zoom_options.add(btn_img_proxima);
		jpanel_zoom_options.add(btn_img_zoommais);
		jpanel_zoom_options.add(jlbl_zoom_porcentagem);
		jpanel_zoom_options.add(btn_img_zoommenos);
		jpanelDireito.add(jpanel_zoom_options, "growx, wrap");

	}

	private static class FolderFilter extends javax.swing.filechooser.FileFilter {
		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}

		@Override
		public String getDescription() {
			return "Pastas";
		}
	}

	public void preencherCampos(String filename) {
		m = p.matcher(img_mostrando.getName());
		while (m.find()) {
			jtextfieldServico.setText(m.group(1));
			jtextfieldPeriodo.setText(m.group(2));
			
			jtextfieldLivro.setText(m.group(3));
			jtxtOndeEstaoLivroNumero.setText(m.group(3));
			
			jtextfieldNumeroDoRegistro.setText(m.group(4));
			jtxtOndeEstaoNumeroDoRegistro.setText(m.group(4));
			
			jtextfieldDataDoAto.setText(m.group(5));
			
			jtextfieldNumeroDoAto.setText(m.group(6));
			jtxtOndeEstaoAtoNumero.setText(m.group(6));
			
			jtextfieldNumeroDoProtocolo.setText(m.group(7));
			jtxtOndeEstaoProtocoloNumero.setText(m.group(7));
			
			jtextfieldNumeroDaImagem.setText(m.group(8));
			jtxtOndeEstaoNumeroDaImagem.setText(m.group(8));
			
			jtextfieldTipoDoAto.setText(m.group(9));
			jtextfieldPlantaOuMemorial.setText(m.group(10));
			jtxtOndeEstaoPlantaOuMemorial.setText(m.group(10));
			
			jtextfieldQuadra.setText(m.group(11));
			jtxtOndeEstaoQuadraNumero.setText(m.group(11));
			
			jtextfieldLote.setText(m.group(12));
			jtxtOndeEstaoLoteNumero.setText(m.group(12));
			
			jtextfieldCPFCNPJCEI.setText(m.group(13));
			jtextfieldTipoDoDocumento.setText(m.group(14));
			jtextfieldOrigem.setText(m.group(15));
			jtextfieldEspecieDoAto.setText(m.group(16));
			jtextfieldCaixaDoArquivo.setText(m.group(17));

		}
	}

	public void ativarValidacoes() throws ParseException {
		
		jtextfieldServico.setDocument(new MaxLengthTextDocument(5));
		jtextfieldServico.getDocument().addDocumentListener(new Validator(jtextfieldServico));
		
		
		jtextfieldPeriodo.getDocument().addDocumentListener(new Validator(jtextfieldPeriodo));

		jtextfieldLivro.getDocument().addDocumentListener(new Validator(jtextfieldLivro));

		jtextfieldNumeroDoRegistro.getDocument().addDocumentListener(new Validator(jtextfieldNumeroDoRegistro));

		jtextfieldDataDoAto.getDocument().addDocumentListener(new Validator(jtextfieldDataDoAto));

		jtextfieldNumeroDoAto.getDocument().addDocumentListener(new Validator(jtextfieldNumeroDoAto));

		jtextfieldNumeroDoProtocolo.getDocument().addDocumentListener(new Validator(jtextfieldNumeroDoProtocolo));

		jtextfieldNumeroDaImagem.getDocument().addDocumentListener(new Validator(jtextfieldNumeroDaImagem));

		jtextfieldTipoDoAto.getDocument().addDocumentListener(new Validator(jtextfieldTipoDoAto));

		jtextfieldPlantaOuMemorial.getDocument().addDocumentListener(new Validator(jtextfieldPlantaOuMemorial));

		jtextfieldQuadra.getDocument().addDocumentListener(new Validator(jtextfieldQuadra));

		jtextfieldLote.getDocument().addDocumentListener(new Validator(jtextfieldLote));

		jtextfieldCPFCNPJCEI.getDocument().addDocumentListener(new Validator(jtextfieldCPFCNPJCEI));

		jtextfieldTipoDoDocumento.getDocument().addDocumentListener(new Validator(jtextfieldTipoDoDocumento));

		jtextfieldOrigem.getDocument().addDocumentListener(new Validator(jtextfieldOrigem));

		jtextfieldEspecieDoAto.getDocument().addDocumentListener(new Validator(jtextfieldEspecieDoAto));

		jtextfieldCaixaDoArquivo.getDocument().addDocumentListener(new Validator(jtextfieldCaixaDoArquivo));
	}

	public class Validator implements DocumentListener {

		JTextField dummy;

		public Validator(JTextField d) {
			this.dummy = d;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			warn();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			warn();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			warn();
		}

		public void warn() {
			text = dummy.getText();

			System.out.println(text);
			String r = "";
			if (dummy == jtextfieldServico) {
				r = "^(.{5})";
			} else if (dummy == jtextfieldPeriodo) {
				r = "(.{4})";
			} else if (dummy == jtextfieldLivro) {
				r = "(.{10})";
			} else if (dummy == jtextfieldNumeroDoRegistro) {
				System.out.println("ta no numero do registro");
				r = "(.{12})";
			} else if (dummy == jtextfieldDataDoAto) {
				r = "(.{13})";
			} else if (dummy == jtextfieldNumeroDoAto) {
				r = "(.{6})";
			} else if (dummy == jtextfieldNumeroDoProtocolo) {
				r = "(.{9})";
			} else if (dummy == jtextfieldNumeroDaImagem) {
				r = "(.{12})";
			} else if (dummy == jtextfieldTipoDoAto) {
				r = "(.{4})";
			} else if (dummy == jtextfieldPlantaOuMemorial) {
				r = "(.{9})";
			} else if (dummy == jtextfieldQuadra) {
				r = "(.{9})";
			} else if (dummy == jtextfieldLote) {
				r = "(.{9})";
			} else if (dummy == jtextfieldCPFCNPJCEI) {
				r = "(.{17})";
			} else if (dummy == jtextfieldTipoDoDocumento) {
				r = "(.{6})";
			} else if (dummy == jtextfieldOrigem) {
				r = "(.{25})";
			} else if (dummy == jtextfieldEspecieDoAto) {
				r = "(.{9})";
			} else if (dummy == jtextfieldCaixaDoArquivo) {
				r = "(.{6})";
			}

			p2 = Pattern.compile(r);
			m2 = p2.matcher(text);

			if (m2.find() && text.length() == dummy.getColumns() && text.length() > 0) {
				dummy.setBackground(null);
			} else {
				dummy.setBackground(Color.red);
			}
		}
	}

	public class MaxLengthTextDocument extends PlainDocument {
		// Store maximum characters permitted
		private int maxChars;

		public MaxLengthTextDocument(int max) {
			this.maxChars = max;
		}

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			// the length of string that will be created is getLength() +
			// str.length()
			if (str != null && (getLength() + str.length() <= maxChars)) {
				super.insertString(offs, str.toUpperCase(), a);
			}
		}

	}
}
