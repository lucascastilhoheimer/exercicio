package Camisa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Camisa_GUI {
	//variaveis
	private JFrame jftela = new JFrame();
	private JLabel lbmatricula = new JLabel("Matrícula");
	private JLabel lbtamanho = new JLabel("Tamanho da Camisa");
	private JLabel lbcor = new JLabel("Selecione a cor da camisa:");
	private JLabel lbcorSelecionada = new JLabel();
	private JLabel lbquantidade = new JLabel("Quantidade de camisas");
	private JLabel lbtitulo = new JLabel("SOLICITAÇÃO DE CAMISAS");
	private ImageIcon iconBranca = new ImageIcon(getClass().getResource("white.png"));
	private ImageIcon iconAzul = new ImageIcon(getClass().getResource("blue.png"));
	private ImageIcon iconAmarela = new ImageIcon(getClass().getResource("yellow.png"));
	private ImageIcon iconVerde = new ImageIcon(getClass().getResource("green.png"));
	private ImageIcon iconVermelha = new ImageIcon(getClass().getResource("red.png"));
	private JLabel lbbranca = new JLabel(iconBranca);
	private JLabel lbazul = new JLabel(iconAzul);
	private JLabel lbvermelha = new JLabel(iconVermelha);
	private JLabel lbverde = new JLabel(iconVerde);
	private JLabel lbamarela = new JLabel(iconAmarela);
	private JLabel lbfundo1 = new JLabel();
	private JLabel lbfundo2 = new JLabel();
	private JLabel lbfundo3 = new JLabel();
	private JTextField txtmatricula = new JTextField();
	private JTextField txtquantidade = new JTextField();
	private JButton btnsolicitar = new JButton("Solicitar");
	
	private String corCamisa, matricula, tamanho;
	private int quantidade;
	
	private JPanel panel1 = new JPanel();
	private JComboBox<String> combo = new JComboBox<String>();
	
	public Camisa_GUI(){
		this.inicializar();
	}
	//metodo inicializar
	public void inicializar(){
		//adicionando os componentes a tela
		this.jftela.setLayout(null);
		this.jftela.setVisible(true);
		this.jftela.setSize(600, 480);
		this.jftela.setResizable(false);
		this.jftela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jftela.setLocationRelativeTo(null);
		this.jftela.add(this.panel1);
		
		this.panel1.setSize(600, 480);
		this.panel1.setLayout(null);
		this.panel1.setBackground(new Color(102, 102, 102));
		this.panel1.add(this.lbmatricula); this.panel1.add(this.txtmatricula);
		this.panel1.add(combo); this.panel1.add(this.lbtamanho);
		this.panel1.add(this.lbcor); this.panel1.add(lbbranca);
		this.panel1.add(lbazul); this.panel1.add(lbvermelha);
		this.panel1.add(lbverde); this.panel1.add(lbamarela); this.panel1.add(this.lbtitulo);
		this.panel1.add(this.lbquantidade); this.panel1.add(this.txtquantidade);
		this.panel1.add(this.btnsolicitar); this.panel1.add(this.lbfundo1);
		this.panel1.add(this.lbfundo2); this.panel1.add(this.lbfundo3);
		
		this.lbbranca.setBounds(460,230,60,30);
		this.lbazul.setBounds(360,230,60,30);
		this.lbverde.setBounds(260,230,60,30);
		this.lbamarela.setBounds(160,230,60,30);
		this.lbvermelha.setBounds(60,230,60,30);
		this.lbtitulo.setBounds(45,10,490,60);
		this.lbtitulo.setForeground(Color.WHITE);
		this.lbtitulo.setFont(new Font("Verdana", 1, 32));
		this.lbfundo1.setBounds(40,80,500,270);
		this.lbfundo1.setBorder(new MatteBorder(1, 1, 2, 2, new Color(51, 51, 51)));
		this.lbfundo2.setBounds(40,80,500,200);
		this.lbfundo2.setBorder(new MatteBorder(1, 1, 2, 2, new Color(51, 51, 51)));
		this.lbfundo3.setBounds(40,80,500,90);
		this.lbfundo3.setBorder(new MatteBorder(1, 1, 2, 2, new Color(51, 51, 51)));
		//metodo para verificar atividades do mouse sobre as labels
		this.clique(lbbranca); this.clique(lbazul);
		this.clique(lbvermelha); this.clique(lbverde);
		this.clique(lbamarela);
		
		this.lbmatricula.setVisible(true);
		this.lbmatricula.setBounds(50,105,150,30);
		this.lbmatricula.setFont(new Font("Verdana", 1, 14));
		this.lbmatricula.setForeground(Color.WHITE);
		
		this.lbtamanho.setBounds(280,105,250,30);
		this.lbtamanho.setFont(new Font("Verdana", 1, 14));
		this.lbtamanho.setForeground(Color.WHITE);
	
		this.lbcor.setBounds(50,180,250,30);
		this.lbcor.setFont(new Font("Verdana", 1, 12));
		this.lbcor.setForeground(Color.WHITE);
		
		this.lbquantidade.setBounds(50,290,200,50);
		this.lbquantidade.setForeground(Color.WHITE);
		this.lbquantidade.setFont(new Font("Verdana", 1, 12));
		
		this.txtmatricula.setBounds(150,105,100,30);
		this.txtmatricula.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtmatricula.setDocument(new Numero());
		this.txtmatricula.setText("0000000000");
		this.txtquantidade.setBounds(230,300,40,30);
		this.txtquantidade.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtquantidade.setDocument(new Numero());

		//focus nos jtextfields, uma numeracao de exemplo sera exibida
		txtmatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) { //quando o cursor focar no jtextfield
				if(txtmatricula.getText().equals("0000000000")){
					txtmatricula.setText(""); //troca o texto para nulo
				}
			}
			@Override
			public void focusLost(FocusEvent e) { //quando o cursor sair do jtextfield
				if(txtmatricula.getText().equals("")) {
					txtmatricula.setText("0000000000"); //troca o texto para o exemplo
				}
			}
		});
		//botao solicitar
		this.btnsolicitar.setBounds(190,370,200,40);
		this.btnsolicitar.setFont(new Font("Verdana", 1, 18)); //alterando fonto do botao
		//combobox
		this.combo.setBounds(470,105,50,30);
		this.combo.addItem(null); //adicionando opcoes
		this.combo.addItem("P");
		this.combo.addItem("M");
		this.combo.addItem("G");
		
		//adicionando bordas padrao ao clique do mouse
		bordasDefault(txtmatricula);
		bordasDefault(txtquantidade);
		
		//acao ao clicar no botao solicitar
		this.btnsolicitar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent solicitar){
				try {
					matricula = txtmatricula.getText(); //atribuindo o valor do jtextfield a variavel
					quantidade = Integer.parseInt(txtquantidade.getText()); //atribuindo o valor do jtextfield a variavel
					
					if(corCamisa == null || combo.getSelectedItem() == null) { //verificando se nao foi selecionado cor e tamanho
						JOptionPane.showMessageDialog(null, "Prencha todos os campos!");
					}else if(quantidade == 0){ //quantidade não pode ser zero
						txtquantidade.setBorder(new MatteBorder(2,2,2,2, new Color(255,99,71)));
						JOptionPane.showMessageDialog(null, "Quantidade não pode ser zero!");
					}else if(matricula.equals("0") || matricula.equals("0000000000")){ //matricula nao pode ser zero
						txtmatricula.setBorder(new MatteBorder(2,2,2,2, new Color(255,99,71)));
						JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Matrícula Inválida!</p></body></html>");
					}else {
						if(combo.getSelectedItem() != null) { //caso tenha selecionado o tamanho de forma correta
							tamanho = (String) combo.getSelectedItem();
						}
					}
				}catch(NumberFormatException ex) { //se os jtextfields não tiverem numeros ao apertar o botao
					if(matricula.equals("0") || matricula.equals("0000000000")){ //caso a matrica seja zero, ficara com a borda vermelha
						txtmatricula.setBorder(new MatteBorder(2,2,2,2, new Color(255,99,71)));
					}
					if(quantidade == 0) { //caso a quantidade seja zero, ficara com a borda vermelha
						txtquantidade.setBorder(new MatteBorder(2,2,2,2, new Color(255,99,71)));
					}
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!"); //mensagem de erro
				}
				//verificando se todos os campos foram preenchidos corretamente
				if(quantidade != 0 && !matricula.equals("0000000000") && !matricula.equals("0") && combo.getSelectedItem() != null && corCamisa != null) {
					JOptionPane.showMessageDialog(null, "Solicitação feita com sucesso!");
				}
				
				//for para escrever uma linha para cada pedido
				for(int i=0; i<quantidade; i++) {
					String texto = matricula+":"+tamanho+":"+corCamisa; //string que armazena no formato da gravacao

					try {
						gravar(texto); //chamando o metodo para gravar no arquivo, sempre tem que ser por um try/catch
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
	}
	
	//clase interna para impedir que no jtextfield sejam digitados letras
	class Numero extends PlainDocument{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			super.insertString(offs, str.replaceAll("[^0-9]", ""), a); //só aceitando de 0 a 9
		}
	}
	
	//manipulacao das labels das cores que recebe uma label por parametro
	public void clique(JLabel label){
		label.addMouseListener(new MouseAdapter(){
			//quando passar o mouse sobre a label ira gerar uma borda de relevo
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				if(label != lbcorSelecionada){
					label.setBorder(new MatteBorder(1, 1, 3, 3, Color.BLACK));
				}
			}
			
			//quando o mouse sair de cima da label voltara a ficar sem bordas
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				if(label != lbcorSelecionada){
					label.setBorder(null);
				}
			}

			//quando clicar numa label ira adicionar uma borda para mostrar que esta selecionada
			@Override
			public void mouseClicked(MouseEvent e){
				if(label.equals(lbbranca)){
					lbbranca.setBorder(new MatteBorder(3, 3, 3, 3, new Color(75,0,130)));
					corCamisa = "0000";
					lbcorSelecionada = lbbranca;
					controleLabel(); //chama a funcao que controla as bordas das labels
				}else if(label.equals(lbazul)){
					lbazul.setBorder(new MatteBorder(3, 3, 3, 3, new Color(75,0,130)));
					corCamisa = "1100";
					lbcorSelecionada = lbazul;
					controleLabel(); //chama a funcao que controla as bordas das labels
				}else if(label.equals(lbvermelha)){
					lbvermelha.setBorder(new MatteBorder(3, 3, 3, 3, new Color(75,0,130)));
					corCamisa = "0110";
					lbcorSelecionada = lbvermelha;
					controleLabel(); //chama a funcao que controla as bordas das labels
				}else if(label.equals(lbverde)){
					lbverde.setBorder(new MatteBorder(3, 3, 3, 3, new Color(75,0,130)));
					corCamisa = "1010";
					lbcorSelecionada = lbverde;
					controleLabel(); //chama a funcao que controla as bordas das labels
				}else if(label.equals(lbamarela)){
					lbamarela.setBorder(new MatteBorder(3, 3, 3, 3, new Color(75,0,130)));
					corCamisa = "0010";
					lbcorSelecionada = lbamarela;
					controleLabel(); //chama a funcao que controla as bordas das labels
				}
			}
		});
	}
	
	//deixa as labels nao selecionadas sem bordas
	public void controleLabel(){
		//se a label dos if's abaixo forem diferentes da selecionada
		if(lbamarela != lbcorSelecionada){
			lbamarela.setBorder(null);
		}
		if(lbazul != lbcorSelecionada){
			lbazul.setBorder(null);
		}
		if(lbbranca != lbcorSelecionada){
			lbbranca.setBorder(null);
		}
		if(lbverde != lbcorSelecionada){
			lbverde.setBorder(null);
		}
		if(lbvermelha != lbcorSelecionada){
			lbvermelha.setBorder(null);
		}
	}
	
	//metodo para gravar arquivos num .txt recebendo uma string contento um texto
	public void gravar(String texto) throws IOException {
		String usuario = System.getProperty("user.home"); //utilizado para pegar o nome do usuario logado no computador
		//armazenando o caminho do arquivo para poder escrever, true para nao sobrescrever toda vez que usar o metodo
		FileWriter arquivo = new FileWriter(usuario+"\\Desktop\\Camisas.txt", true);
		PrintWriter gravarArquivo = new PrintWriter(arquivo); 

		gravarArquivo.println(texto); //gravando o texto
		
		arquivo.close(); //fechando o arquivo
		gravarArquivo.close();
		System.out.println("Arquivos gravado comm sucesso!"); //mensagem de confirmacao	
	}
	
	//metodo para tirar as bordas vermelhas quando gerar erro
	public void bordasDefault(JTextField text) {
		text.addMouseListener(new MouseAdapter(){
			//quando clicar no textfield define a borda para a padrao
			@Override
			public void mouseClicked(MouseEvent e){
				text.setBorder(BorderUIResource.getEtchedBorderUIResource());
			}
		});
	}
	
	//main
	public static void main(String[] args) {
		new Camisa_GUI();
	}
}
