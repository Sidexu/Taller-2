package Grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ventanaPrueba {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
		frame.setBounds(100, 100, 1024, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel_nuevaExcursion = new JPanel();
		panel_nuevaExcursion.setBackground(Color.WHITE);
		panel_nuevaExcursion.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_nuevaExcursion);
		panel_nuevaExcursion.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Registro de nueva excursion");
		lblNewLabel_2.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(29, 21, 562, 37);
		panel_nuevaExcursion.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(29, 90, 752, 233);
		panel_nuevaExcursion.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Datos excursion");
		lblNewLabel_3.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 11, 219, 27);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblCodigo = new JLabel("Codigo");
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
		btnNewButton_2.setBounds(655, 451, 127, 48);
		panel_nuevaExcursion.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Limpiar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(500, 452, 127, 48);
		panel_nuevaExcursion.add(btnNewButton_3);
		
		final JPanel panel_listGralBus = new JPanel();
		panel_listGralBus.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_listGralBus);
		panel_listGralBus.setBackground(Color.WHITE);
		panel_listGralBus.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
					"Matricula", "Marca", "Capacidad", "Cant excursiones"
			}
		));
		table.setVisible(true);
		table.setBounds(27, 492, 752, -402);
		panel_listGralBus.add(table);
		
		JLabel lblListadoDeTodos = new JLabel("Listado de todos los buses registrados");
		lblListadoDeTodos.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 27));
		lblListadoDeTodos.setBounds(27, 21, 579, 48);
		panel_listGralBus.add(lblListadoDeTodos);
		
		final JPanel panel_nuevoBus = new JPanel();
		panel_nuevoBus.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_nuevoBus);
		panel_nuevoBus.setBackground(Color.YELLOW);
		panel_nuevoBus.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del bus");
		lblNewLabel_1.setBounds(28, 27, 421, 34);
		panel_nuevoBus.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 90, 754, 233);
		panel_nuevoBus.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula");
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
		
		JLabel lblNewLabel = new JLabel("Ingreso de nuevo Bus");
		lblNewLabel.setBounds(10, 11, 413, 41);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(655, 451, 127, 48);
		panel_nuevoBus.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(500, 452, 127, 48);
		panel_nuevoBus.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 173, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JPanel panel_respaldar = new JPanel();
		panel_respaldar.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_respaldar);
		panel_respaldar.setBackground(Color.BLUE);
		
		final JPanel panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.ORANGE);
		panel_inicio.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_inicio);
		
		final JPanel panel_reasigExcursion = new JPanel();
		panel_reasigExcursion.setBackground(new Color(0, 100, 0));
		panel_reasigExcursion.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_reasigExcursion);
		
		final JPanel panel_listExBus = new JPanel();
		panel_listExBus.setBackground(Color.LIGHT_GRAY);
		panel_listExBus.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_listExBus);
		
		final JPanel panel_listExDest = new JPanel();
		panel_listExDest.setBackground(Color.WHITE);
		panel_listExDest.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_listExDest);
		
		final JPanel panel_listExPrecio = new JPanel();
		panel_listExPrecio.setBackground(Color.GREEN);
		panel_listExPrecio.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_listExPrecio);
		
		final JPanel panel_recaudacionEx = new JPanel();
		panel_recaudacionEx.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_recaudacionEx);
		panel_recaudacionEx.setBackground(Color.DARK_GRAY);
		
		final JPanel panel_ventaBoleto = new JPanel();
		panel_ventaBoleto.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_ventaBoleto);
		panel_ventaBoleto.setBackground(Color.CYAN);
		
		final JPanel panel_boletoVendidosEx = new JPanel();
		panel_boletoVendidosEx.setBounds(183, 11, 815, 539);
		frame.getContentPane().add(panel_boletoVendidosEx);
		panel_boletoVendidosEx.setBackground(Color.BLACK);
		
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
		
		JButton btnListadoExcDest = new JButton("Listado exc-destino");
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
		
		JButton btnRecaudacionEx = new JButton("Recaudacion excursion");
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
		
		JButton btnBoletosVendidosexc = new JButton("Boletos vendidos-exc");
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
