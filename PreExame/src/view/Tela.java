package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Desktop.Action;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.ScrollPane;

import control.Control;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Tela extends JFrame {

	private JPanel contentPane;
	private ScrollPane sPane;
	
	private JTextField tfTamanho;
	private JTable table;
	private JButton btnBuscaArquivo;
	private JButton btnMontarDiscos;
	private JRadioButton rdbtnSelecionar;
	private JRadioButton rdbtnDigitar;
	private JLabel lblTamanhoDoArquivo;
	private JLabel lblNumDiscos ;
	private JLabel lblBytes;
	private JComboBox comboNumeroDiscos ;
	private String[] vetorCombo  = {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		Control ctr = new Control();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnBuscaArquivo= new JButton("Selecionar Arquivo");
		btnBuscaArquivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscaArquivo.setBounds(293, 12, 161, 23);
		contentPane.add(btnBuscaArquivo);
		
		btnMontarDiscos = new JButton("Montar Discos");
		btnMontarDiscos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMontarDiscos.setBounds(907, 44, 204, 23);
		contentPane.add(btnMontarDiscos);
		
		
		lblTamanhoDoArquivo = new JLabel("Tamanho do arquivo:");
		lblTamanhoDoArquivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTamanhoDoArquivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTamanhoDoArquivo.setBounds(157, 49, 124, 14);
		contentPane.add(lblTamanhoDoArquivo);
		
		lblNumDiscos = new JLabel("Numero de Discos:");
		lblNumDiscos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumDiscos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumDiscos.setBounds(468, 50, 116, 14);
		contentPane.add(lblNumDiscos);
		
		lblBytes = new JLabel("bytes");
		lblBytes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBytes.setBounds(417, 49, 37, 14);
		contentPane.add(lblBytes);
		
		
		tfTamanho = new JTextField();
		tfTamanho.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTamanho.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfTamanho.setBounds(291, 46, 116, 20);
		contentPane.add(tfTamanho);
		tfTamanho.setColumns(10);
		
		
		rdbtnSelecionar = new JRadioButton("Selecionar Arquivo");
		rdbtnSelecionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSelecionar.setSelected(true);
		rdbtnSelecionar.setBounds(10, 11, 140, 23);
		contentPane.add(rdbtnSelecionar);
		
		rdbtnDigitar = new JRadioButton("Digitar Tamanho");
		rdbtnDigitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnDigitar.setBounds(152, 11, 135, 23);
		contentPane.add(rdbtnDigitar);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnDigitar);
		btnGroup.add(rdbtnSelecionar);
		
		
		
		comboNumeroDiscos = new JComboBox();
		comboNumeroDiscos.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboNumeroDiscos.setModel(new DefaultComboBoxModel(vetorCombo));
		comboNumeroDiscos.setBounds(589, 47, 86, 20);
		contentPane.add(comboNumeroDiscos);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 76, 1101, 2);
		contentPane.add(separator);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 1101, 380);
		contentPane.add(scrollPane);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setBounds(10, 42, 124, 23);
		contentPane.add(btnLimparTela);
		
		table = new JTable();
		
		
		/*Sessão de ActionListener*/
		
		ActionListener SelectDigitar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnableTela(true, false);
			}
		};
		
		ActionListener SelectBuscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnableTela(false, true);				
			}
		};
		
		ActionListener buscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProcuraArquivo();
			}
		};
		
		ActionListener montar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GeraTabela(ctr.montarDiscos(tfTamanho.getText(), Discos()));
				
			}
			
		};
		
		/*Sessão para aplicar actionListener nos botões*/
		
		btnBuscaArquivo.addActionListener(buscar);
		rdbtnDigitar.addActionListener(SelectDigitar);
		rdbtnSelecionar.addActionListener(SelectBuscar);
 		btnMontarDiscos.addActionListener(montar);
	}
	
	
	private void limparTela(){
		tfTamanho.setText("");
		table = new JTable();
		scrollPane.setViewportView(table);
		rdbtnSelecionar.setSelected(true);
		rdbtnDigitar.setSelected(false);
		tfTamanho.setEnabled(false);
		comboNumeroDiscos.setSelectedIndex(0);
		btnBuscaArquivo.setEnabled(true);
		
	}
	
	/**
	 * Metodo que gera a tabela.
	 * @param tabela - String[][] 
	 */
	private void GeraTabela (String[][] tab){
		Control ctr = new Control();
		
		String[] discos = ctr.StringDiscos(Discos());
		
		table.setModel(new DefaultTableModel(tab,discos ));
		table.setBounds(10, 123, 491, 222);
		scrollPane.setViewportView(table);
	}
	
	/**
	 * Método do filechooser
	 */
	public void ProcuraArquivo(){
		String dirBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(dirBase);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(dir);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int retorno = chooser.showOpenDialog(null);
		
		
		
		if (retorno == JFileChooser.APPROVE_OPTION){
			long tamanho = chooser.getSelectedFile().length();
			tfTamanho.setText(tamanho + "");
			lblBytes.setVisible(true);
			
		}
	}
	
	/**
	 * metodo para dar enable/disable nos itens da tela
	 * true para enable e false para disable.
	 * @param booleano tf
	 * @param booleano btn
	 */
	private void EnableTela(boolean tf, boolean btn){
		tfTamanho.setEnabled(tf);
		btnBuscaArquivo.setEnabled(btn);
		
	}
	
	/**
	 * retorna quantidade de linhas necessárias
	 * @return int
	 */
	private int Linhas(){
		String tamanho = tfTamanho.getText();
		tamanho += ".0";
		double bits = Double.parseDouble(tamanho) * 8;
		
		double linhas = bits/Discos()-1;
		
		if (linhas - (int)linhas != 0) linhas++;
		if ((int)linhas < 0) linhas = 0;
		return (int)linhas;
	}
	
	/**
	 * metodo que retorna um int com o número de discos selecionados
	 * @return int
	 */
	private int Discos(){
		return Integer.parseInt(vetorCombo[comboNumeroDiscos.getSelectedIndex()]);
	}
}
