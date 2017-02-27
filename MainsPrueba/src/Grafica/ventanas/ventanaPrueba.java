package Grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import defaultP.Fachada;
import Logica.Buses;
import Logica.Excursiones;
import Logica.Excepciones.ExcepcionBus;
import Logica.valueObjects.VOBus;
import Logica.valueObjects.VOBusCant;

public class ventanaPrueba {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrueba window = new ventanaPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1024, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel_listGralBus = new JPanel();
		panel_listGralBus.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_listGralBus);
		panel_listGralBus.setBackground(Color.WHITE);
		panel_listGralBus.setLayout(null);
		
		JLabel lblListadoDeTodos = new JLabel("Listado de todos los buses registrados");
		lblListadoDeTodos.setBounds(28, 27, 500, 37);
		lblListadoDeTodos.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		panel_listGralBus.add(lblListadoDeTodos);
		
		String[] columnNames = {"Matricula",
                "Marca",
                "Capacidad",
                "Cantidad de excursiones"};
		Object[][] rowData = {
			};
		table = new JTable(rowData, columnNames);
		table.setBounds(28, 93, 756, 368);
		panel_listGralBus.add(table);
		table.setLayout(new BorderLayout());
		table.add(table.getTableHeader(), BorderLayout.PAGE_START);
		
		
		final JPanel panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.WHITE);
		panel_inicio.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_inicio);
		panel_inicio.setLayout(null);
		
		JLabel lblNewLabel_25 = new JLabel("Bienvenido al sistema Duck Boat");
		lblNewLabel_25.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_25.setBounds(28, 27, 421, 37);
		panel_inicio.add(lblNewLabel_25);

		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(28, 90, 754, 369);
		panel_inicio.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/iconDuck.png")).getImage();
		label_2.setIcon(new ImageIcon(img));
		label_2.setBounds(641, 0, 113, 136);
		panel_12.add(label_2);
		
		JLabel lblNuestaMisin = new JLabel("Quienes somos");
		lblNuestaMisin.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNuestaMisin.setBounds(15, 8, 200, 20);
		panel_12.add(lblNuestaMisin);
		
		JLabel lblNewLabel_26 = new JLabel("Somos una empresa de transporte que realiza paseos tanto por tierra como por mar. ");
		lblNewLabel_26.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblNewLabel_26.setBounds(63, 36, 576, 38);
		panel_12.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Misi\u00F3n y Visi\u00F3n");
		lblNewLabel_27.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNewLabel_27.setBounds(15, 202, 153, 20);
		panel_12.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Ofrecer tanto a turistas como a residentes, paseos \u00FAnicos y recreativos.");
		lblNewLabel_28.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblNewLabel_28.setBounds(63, 247, 676, 20);
		panel_12.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Convertirnos en uno de los paseos t\u00EDpicos de la zona de nuestro departamento Rocha, Uruguay.");
		lblNewLabel_29.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblNewLabel_29.setBounds(63, 277, 661, 28);
		panel_12.add(lblNewLabel_29);
		
		JLabel lblPosicionarnos = new JLabel("Posicionarnos como una empresa seria y responsable, cuya garant\u00EDa sea la satisfacci\u00F3n del cliente. ");
		lblPosicionarnos.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblPosicionarnos.setBounds(63, 310, 676, 28);
		panel_12.add(lblPosicionarnos);
		
		JLabel lblNewLabel_30 = new JLabel("Contamos con una flota de \u00F3mnibus llamados \"Duck boats\", los cuales son \u00FAnicos ");
		lblNewLabel_30.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblNewLabel_30.setBounds(63, 75, 576, 28);
		panel_12.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("en nuestro pa\u00EDs. ");
		lblNewLabel_31.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
		lblNewLabel_31.setBounds(63, 110, 152, 20);
		panel_12.add(lblNewLabel_31);

		
		
		
		final JPanel panel_respaldar = new JPanel();
		panel_respaldar.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_respaldar);
		panel_respaldar.setBackground(Color.WHITE);
		panel_respaldar.setLayout(null);
		
		JLabel lblNewLabel_24 = new JLabel("Respaldo de datos");
		lblNewLabel_24.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_24.setBounds(28, 27, 421, 37);
		panel_respaldar.add(lblNewLabel_24);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(28, 90, 754, 233);
		panel_respaldar.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("\u00BFEst\u00E1 seguro que desea guardar los datos?");
		lblestSeguroQue.setBounds(179, 98, 403, 27);
		lblestSeguroQue.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		panel_11.add(lblestSeguroQue);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(655, 475, 127, 48);
		panel_respaldar.add(btnAceptar);
		
		JButton btnNewButton_11 = new JButton("Cancelar");
		btnNewButton_11.setBounds(500, 475, 127, 48);
		panel_respaldar.add(btnNewButton_11);
		
		final JPanel panel_boletoVendidosEx = new JPanel();
		panel_boletoVendidosEx.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_boletoVendidosEx);
		panel_boletoVendidosEx.setBackground(Color.WHITE);
		panel_boletoVendidosEx.setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel("Listado de boletos vendidos para una excursion");
		lblNewLabel_22.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_22.setBounds(28, 27, 600, 37);
		panel_boletoVendidosEx.add(lblNewLabel_22);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(28, 90, 754, 369);
		panel_boletoVendidosEx.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_23 = new JLabel("C\u00F3digo de excursi\u00F3n");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_23.setBounds(15, 8, 151, 20);
		panel_10.add(lblNewLabel_23);
		
		textField_21 = new JTextField();
		textField_21.setBounds(168, 5, 146, 26);
		panel_10.add(textField_21);
		textField_21.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ninguno seleccionado", "Com\u00FAn", "Especial"}));
		comboBox.setBounds(549, 5, 190, 26);
		panel_10.add(comboBox);
		
		JLabel lblTipoDeBoleto = new JLabel("Tipo de boleto");
		lblTipoDeBoleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeBoleto.setBounds(431, 8, 103, 20);
		panel_10.add(lblTipoDeBoleto);
		
		JButton btnNewButton_10 = new JButton("Listar");
		btnNewButton_10.setBounds(655, 475, 127, 48);
		panel_boletoVendidosEx.add(btnNewButton_10);
		
		final JPanel panel_ventaBoleto = new JPanel();
		panel_ventaBoleto.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_ventaBoleto);
		panel_ventaBoleto.setBackground(Color.WHITE);
		panel_ventaBoleto.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Venta de boleto");
		lblNewLabel_16.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_16.setBounds(28, 27, 421, 37);
		panel_ventaBoleto.add(lblNewLabel_16);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(28, 90, 754, 369);
		panel_ventaBoleto.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("C\u00F3digo excursi\u00F3n");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_17.setBounds(63, 74, 129, 20);
		panel_9.add(lblNewLabel_17);
		
		textField_16 = new JTextField();
		textField_16.setBounds(191, 68, 220, 26);
		panel_9.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(191, 107, 220, 26);
		panel_9.add(textField_17);
		textField_17.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Descuento");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(63, 106, 139, 29);
		panel_9.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_18 = new JLabel("Datos de pasajero");
		lblNewLabel_18.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNewLabel_18.setBounds(15, 160, 200, 50);
		panel_9.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Edad");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(63, 213, 70, 27);
		panel_9.add(lblNewLabel_19);
		
		textField_18 = new JTextField();
		textField_18.setBounds(159, 213, 252, 26);
		panel_9.add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Procedencia");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20.setBounds(63, 256, 100, 27);
		panel_9.add(lblNewLabel_20);
		
		textField_19 = new JTextField();
		textField_19.setBounds(159, 256, 252, 26);
		panel_9.add(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblNCel = new JLabel("N\u00B0 Cel");
		lblNCel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNCel.setBounds(63, 299, 70, 27);
		panel_9.add(lblNCel);
		
		textField_20 = new JTextField();
		textField_20.setBounds(159, 299, 252, 26);
		panel_9.add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Datos del boleto");
		lblNewLabel_21.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNewLabel_21.setBounds(10, 11, 200, 50);
		panel_9.add(lblNewLabel_21);
		
		JButton btnNewButton_8 = new JButton("Ingresar");
		btnNewButton_8.setBounds(655, 475, 127, 48);
		panel_ventaBoleto.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Limpiar");
		btnNewButton_9.setAutoscrolls(true);
		btnNewButton_9.setBounds(500, 475, 127, 48);
		panel_ventaBoleto.add(btnNewButton_9);
		
		final JPanel panel_recaudacionEx = new JPanel();
		panel_recaudacionEx.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_recaudacionEx);
		panel_recaudacionEx.setBackground(Color.WHITE);
		panel_recaudacionEx.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Recaudaci\u00F3n de excursi\u00F3n");
		lblNewLabel_14.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_14.setBounds(28, 27, 421, 37);
		panel_recaudacionEx.add(lblNewLabel_14);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(28, 90, 754, 369);
		panel_recaudacionEx.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("C\u00F3digo de excursi\u00F3n");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_15.setBounds(15, 8, 150, 20);
		panel_8.add(lblNewLabel_15);
		
		textField_15 = new JTextField();
		textField_15.setBounds(180, 5, 146, 26);
		panel_8.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("Ver");
		btnNewButton_7.setBounds(655, 475, 127, 48);
		panel_recaudacionEx.add(btnNewButton_7);
		
		final JPanel panel_listExPrecio = new JPanel();
		panel_listExPrecio.setBackground(Color.WHITE);
		panel_listExPrecio.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_listExPrecio);
		panel_listExPrecio.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Listado de excursiones por rango de precios");
		lblNewLabel_12.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_12.setBounds(28, 27, 600, 37);
		panel_listExPrecio.add(lblNewLabel_12);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(28, 90, 754, 369);
		panel_listExPrecio.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Rango entre");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(15, 8, 95, 20);
		panel_7.add(lblNewLabel_13);
		
		textField_13 = new JTextField();
		textField_13.setBounds(110, 5, 146, 26);
		panel_7.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(271, 5, 146, 26);
		panel_7.add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Listar");
		btnNewButton_6.setBounds(655, 475, 127, 48);
		panel_listExPrecio.add(btnNewButton_6);
		
		final JPanel panel_listExDest = new JPanel();
		panel_listExDest.setBackground(Color.WHITE);
		panel_listExDest.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_listExDest);
		panel_listExDest.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Listado de excursiones por destino");
		lblNewLabel_10.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_10.setBounds(28, 27, 461, 37);
		panel_listExDest.add(lblNewLabel_10);
		
		JButton btnNewButton_5 = new JButton("Listar");
		btnNewButton_5.setBounds(655, 475, 127, 48);
		panel_listExDest.add(btnNewButton_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(28, 90, 754, 369);
		panel_listExDest.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Destino");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(15, 8, 63, 20);
		panel_6.add(lblNewLabel_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(93, 5, 146, 26);
		panel_6.add(textField_12);
		textField_12.setColumns(10);
		
		final JPanel panel_listExBus = new JPanel();
		panel_listExBus.setBackground(Color.WHITE);
		panel_listExBus.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_listExBus);
		panel_listExBus.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Listado excursiones asignadas a un bus");
		lblNewLabel_9.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_9.setBounds(28, 27, 500, 37);
		panel_listExBus.add(lblNewLabel_9);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(655, 475, 127, 48);
		panel_listExBus.add(btnListar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(28, 90, 754, 369);
		panel_listExBus.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMatricula_1 = new JLabel("Matricula");
		lblMatricula_1.setBounds(15, 8, 63, 20);
		panel_4.add(lblMatricula_1);
		lblMatricula_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_11 = new JTextField();
		textField_11.setBounds(93, 5, 146, 26);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		final JPanel panel_reasigExcursion = new JPanel();
		panel_reasigExcursion.setBackground(Color.WHITE);
		panel_reasigExcursion.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_reasigExcursion);
		panel_reasigExcursion.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Reasignaci\u00F3n de excursi\u00F3n");
		lblNewLabel_6.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_6.setBounds(28, 27, 421, 37);
		panel_reasigExcursion.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(28, 90, 754, 233);
		panel_reasigExcursion.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Ingrese c\u00F3digo de excursi\u00F3n a reasignar");
		lblNewLabel_7.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 11, 385, 27);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("C\u00F3digo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(63, 83, 70, 20);
		panel_3.add(lblNewLabel_8);
		
		textField_10 = new JTextField();
		textField_10.setBounds(148, 80, 146, 26);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Reasignar");
		btnNewButton_4.setBounds(655, 475, 127, 48);
		panel_reasigExcursion.add(btnNewButton_4);
		
		final JPanel panel_nuevaExcursion = new JPanel();
		panel_nuevaExcursion.setBackground(Color.WHITE);
		panel_nuevaExcursion.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_nuevaExcursion);
		panel_nuevaExcursion.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Registro de nueva excursi\u00F3n");
		lblNewLabel_2.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_2.setBounds(28, 27, 421, 37);
		panel_nuevaExcursion.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 90, 754, 233);
		panel_nuevaExcursion.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Datos excursi\u00F3n");
		lblNewLabel_3.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 11, 219, 27);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(63, 49, 70, 20);
		panel_2.add(lblCodigo);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDestino.setBounds(63, 80, 70, 27);
		panel_2.add(lblDestino);
		
		JLabel lblHoraPartida = new JLabel("Hora Partida");
		lblHoraPartida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoraPartida.setBounds(63, 111, 88, 22);
		panel_2.add(lblHoraPartida);
		
		JLabel lblHoraRegreso = new JLabel("Hora Regreso");
		lblHoraRegreso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoraRegreso.setBounds(63, 144, 107, 20);
		panel_2.add(lblHoraRegreso);
		
		JLabel lblNewLabel_4 = new JLabel("Precio base");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(63, 175, 107, 20);
		panel_2.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 49, 372, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 82, 372, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(173, 113, 56, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(173, 143, 56, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(173, 175, 372, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(239, 110, 19, 20);
		panel_2.add(lblNewLabel_5);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(239, 142, 19, 20);
		panel_2.add(label);
		
		textField_8 = new JTextField();
		textField_8.setBounds(259, 114, 56, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(259, 143, 56, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Ingresar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(655, 475, 127, 48);
		panel_nuevaExcursion.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Limpiar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(500, 475, 127, 48);
		panel_nuevaExcursion.add(btnNewButton_3);
		
		final JPanel panel_nuevoBus = new JPanel();
		panel_nuevoBus.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_nuevoBus);
		panel_nuevoBus.setBackground(Color.WHITE);
		panel_nuevoBus.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingreso de un nuevo bus");
		lblNewLabel_1.setBounds(28, 27, 421, 37);
		panel_nuevoBus.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 90, 754, 233);
		panel_nuevoBus.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatricula.setBounds(64, 76, 97, 17);
		panel_1.add(lblMatricula);
		
		textField = new JTextField();
		textField.setBounds(171, 76, 376, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(64, 106, 71, 19);
		panel_1.add(lblMarca);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 107, 376, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCapacidad.setBounds(64, 138, 97, 20);
		panel_1.add(lblCapacidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 138, 376, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Datos del bus");
		lblNewLabel.setBounds(10, 11, 219, 27);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(655, 475, 127, 48);
		panel_nuevoBus.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(500, 475, 127, 48);
		panel_nuevoBus.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 173, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Verdana", Font.BOLD, 11));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(true);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnInicio.setBounds(10, 11, 153, 31);
		panel.add(btnInicio);
		
		JButton btnNuevoBus = new JButton("Nuevo Bus");
		btnNuevoBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(true);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnNuevoBus.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNuevoBus.setBounds(10, 53, 153, 31);
		panel.add(btnNuevoBus);
		
		JButton btnListadoGeneralBuses = new JButton("Listado gral buses");
		btnListadoGeneralBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(true);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
				
			}
		});
		btnListadoGeneralBuses.setFont(new Font("Verdana", Font.BOLD, 11));
		btnListadoGeneralBuses.setBounds(10, 95, 153, 31);
		panel.add(btnListadoGeneralBuses);
		
		JButton btnNuevaExcursion = new JButton("Nueva excusion");
		btnNuevaExcursion.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNuevaExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(true);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnNuevaExcursion.setBounds(10, 137, 153, 31);
		panel.add(btnNuevaExcursion);
		
		JButton btnReasignacionExcursion = new JButton("Reasignacion exc");
		btnReasignacionExcursion.setBackground(UIManager.getColor("Button.background"));
		btnReasignacionExcursion.setFont(new Font("Verdana", Font.BOLD, 11));
		btnReasignacionExcursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(true);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnReasignacionExcursion.setBounds(10, 179, 153, 31);
		panel.add(btnReasignacionExcursion);
		
		JButton btnListadoExcBus = new JButton("Listado exc-bus");
		btnListadoExcBus.setBackground(UIManager.getColor("Button.background"));
		btnListadoExcBus.setFont(new Font("Verdana", Font.BOLD, 11));
		btnListadoExcBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(true);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnListadoExcBus.setBounds(10, 221, 153, 31);
		panel.add(btnListadoExcBus);
		
		JButton btnListadoExcDest = new JButton("List. exc-destino");
		btnListadoExcDest.setFont(new Font("Verdana", Font.BOLD, 11));
		btnListadoExcDest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(true);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnListadoExcDest.setBounds(10, 263, 153, 31);
		panel.add(btnListadoExcDest);
		
		JButton btnListadoExcPrecio = new JButton("Listado exc-precio");
		btnListadoExcPrecio.setFont(new Font("Verdana", Font.BOLD, 11));
		btnListadoExcPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(true);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnListadoExcPrecio.setBounds(10, 305, 153, 31);
		panel.add(btnListadoExcPrecio);
		
		JButton btnRecaudacionEx = new JButton("Recaudacion exc");
		btnRecaudacionEx.setFont(new Font("Verdana", Font.BOLD, 11));
		btnRecaudacionEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(true);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnRecaudacionEx.setBounds(10, 347, 153, 31);
		panel.add(btnRecaudacionEx);
		
		JButton btnVentaBoleto = new JButton("Venta boleto");
		btnVentaBoleto.setFont(new Font("Verdana", Font.BOLD, 11));
		btnVentaBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(true);
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(false);
			}
		});
		btnVentaBoleto.setBounds(10, 389, 153, 31);
		panel.add(btnVentaBoleto);
		
		JButton btnBoletosVendidosexc = new JButton("Bts vendidos-exc");
		btnBoletosVendidosexc.setFont(new Font("Verdana", Font.BOLD, 11));
		btnBoletosVendidosexc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(true);
				panel_respaldar.setVisible(false);
			}
		});
		btnBoletosVendidosexc.setBounds(10, 431, 153, 31);
		panel.add(btnBoletosVendidosexc);
		
		JButton btnRespaldar = new JButton("Respaldar");
		btnRespaldar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnRespaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_inicio.setVisible(false);
				panel_nuevoBus.setVisible(false);
				panel_listGralBus.setVisible(false);
				panel_nuevaExcursion.setVisible(false);
				panel_reasigExcursion.setVisible(false);
				panel_listExBus.setVisible(false);
				panel_listExDest.setVisible(false);
				panel_listExPrecio.setVisible(false);
				panel_recaudacionEx.setVisible(false);
				panel_ventaBoleto.setVisible(false);
				panel_boletoVendidosEx.setVisible(true);
				panel_respaldar.setVisible(true);
			}
		});
		btnRespaldar.setBounds(10, 473, 153, 31);
		panel.add(btnRespaldar);
		
	}
	/*
	public void abrirVentana (JPanel jp){
		panel_inicio.setVisible(false);
		panel_nuevoBus.setVisible(false);
		panel_listGralBus.setVisible(false);
		panel_nuevaExcursion.setVisible(false);
		panel_reasigExcursion.setVisible(false);
		panel_listExBus.setVisible(false);
		panel_listExDest.setVisible(false);
		panel_listExPrecio.setVisible(false);
		panel_recaudacionEx.setVisible(false);
		panel_ventaBoleto.setVisible(false);
		panel_boletoVendidosEx.setVisible(false);
		panel_respaldar.setVisible(false);
		
	}*/

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
