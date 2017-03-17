package Grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Grafica.ventanas.controladoresVentanas.controladorBoletosVendidosXEx;
import Grafica.ventanas.controladoresVentanas.controladorExcursionesXDestino;
import Grafica.ventanas.controladoresVentanas.controladorExcursionesXPrecio;
import Grafica.ventanas.controladoresVentanas.controladorListadoExcursionDisp;
import Grafica.ventanas.controladoresVentanas.controladorListadoGralBuses;
import Grafica.ventanas.controladoresVentanas.controladorNuevaExcursion;
import Grafica.ventanas.controladoresVentanas.controladorNuevoBus;
import Grafica.ventanas.controladoresVentanas.controladorReasignarExcursion;
import Grafica.ventanas.controladoresVentanas.controladorRecaudacionExcursion;
import Grafica.ventanas.controladoresVentanas.controladorRespaldoDatos;
import Grafica.ventanas.controladoresVentanas.controladorVentaBoleto;
import Logica.Hora;
import Logica.valueObjects.VOBoletoTipo;
import Logica.valueObjects.VOBusCant;
import Logica.valueObjects.VOExcursionDisp;
import javax.swing.table.DefaultTableModel;

public class ventanaPrueba {

	private JFrame frame;
	private JTextField Tf_NuevoBus_Matricula;
	private JTextField Tf_NuevoBus_Marca;
	private JTextField Tf_NuevoBus_Capacidad;
	private JTextField Tf_RegistroNuevaExcursion_Codigo;
	private JTextField Tf_RegistroNuevaExcursion_Destino;
	private JTextField Tf_RegistroNuevaExcursion_HrPartida;
	private JTextField Tf_RegistroNuevaExcursion_HrRegreso;
	private JTextField Tf_RegistroNuevaExcursion_Precio;
	private JTextField Tf_RegistroNuevaExcursion_HrPartidaMin;
	private JTextField Tf_RegistroNuevaExcursion_HrRegresoMin;
	private JTextField Tf_ReasignacionDeExcursion_Codigo;
	private JTextField Tf_ListadoExcBus_Matricula;
	private JTextField Tf_ListadoExcDest_Destino;
	private JTextField Tf_ListadoExcXRango_Rango1;
	private JTextField Tf_ListadoExcXRango_Rango2;
	private JTextField Tf_Recaudacion_Codigo;
	private JTextField Tf_VentaBoleto_Codigo;
	private JTextField Tf_VentaBoleto_Descuento;
	private JTextField Tf_VentaBoleto_Edad;
	private JTextField Tf_VentaBoleto_Procedencia;
	private JTextField Tf_VentaBoleto_Cel;
	private JTextField Tf_ListadoBoletosExcursion_Codigo;
	private JTable tableListadoBuses;
	private JTable tableListExBus;
	private JTable tableListadoExcDest;
	private JTable tableListExXRango;

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
		
		Image img= new ImageIcon(this.getClass().getResource("/iconDuck.png")).getImage();
				
				
				final JPanel panel_listExDest = new JPanel();
				panel_listExDest.setBackground(Color.WHITE);
				panel_listExDest.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_listExDest);
				panel_listExDest.setLayout(null);
				
				JLabel lblNewLabel_10 = new JLabel("Listado de excursiones por destino");
				lblNewLabel_10.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_10.setBounds(28, 27, 754, 37);
				panel_listExDest.add(lblNewLabel_10);
				
				final JPanel panel_6 = new JPanel();
				panel_6.setBounds(28, 126, 754, 333);
				panel_listExDest.add(panel_6);
				panel_6.setLayout(null);
				
				Tf_ListadoExcDest_Destino = new JTextField();
				Tf_ListadoExcDest_Destino.setBounds(121, 93, 146, 26);
				panel_listExDest.add(Tf_ListadoExcDest_Destino);
				Tf_ListadoExcDest_Destino.setColumns(10);
				
				tableListadoExcDest = new JTable();
				tableListadoExcDest.setBounds(0, 0, 754, 333);
				panel_6.add(tableListadoExcDest);
				
				JLabel lblNewLabel_11 = new JLabel("Destino");
				lblNewLabel_11.setBounds(43, 94, 63, 20);
				panel_listExDest.add(lblNewLabel_11);
				lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JButton Btn_ListadoExcDest_Listar = new JButton("Listar");
				Btn_ListadoExcDest_Listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_ListadoExcDest_Listar.setBounds(655, 475, 127, 48);
				panel_listExDest.add(Btn_ListadoExcDest_Listar);
				final DefaultTableModel model1 = new DefaultTableModel(0, 0);
				
				Btn_ListadoExcDest_Listar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model1.setRowCount(0);	
						VOExcursionDisp arrVO[];	
						arrVO = controladorExcursionesXDestino.excursionesXDestino(Tf_ListadoExcDest_Destino.getText());
						
						String columnNames [] = new String[] {"Codigo",
				                "Destino",
				                "Hr Partida",
				                "Hr Regreso",
				                "Precio Base",
				                "Cantidad disponible"};
						

						model1.setColumnIdentifiers(columnNames);
						
						tableListExBus.setModel(model1);

						panel_6.setLayout(new BorderLayout());
						panel_6.add(tableListExBus.getTableHeader(), BorderLayout.PAGE_START);
						panel_6.add(tableListExBus, BorderLayout.CENTER);
		
						if(arrVO != null){		
							for(int i=0;i<arrVO.length;i++){
								Hora hp= arrVO[i].getHr_partida();
								Hora hr= arrVO[i].getHr_regreso();
								String hr_partida = String.valueOf(hp.getHora())+":"+String.valueOf(hp.getMin());
								String hr_regreso = String.valueOf(hr.getHora())+":"+String.valueOf(hr.getMin());
								model1.addRow(new Object[] { arrVO[i].getCodigo(), arrVO[i].getDestino(),hr_partida,hr_regreso,arrVO[i].getPrecioBase(),arrVO[i].getCant_disponibles()});
							}
						}

					}
				});
					
				final JPanel panel_ventaBoleto = new JPanel();
				panel_ventaBoleto.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_ventaBoleto);
				panel_ventaBoleto.setBackground(Color.WHITE);
				panel_ventaBoleto.setLayout(null);
				
				JLabel lblNewLabel_16 = new JLabel("Venta de boleto");
				lblNewLabel_16.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_16.setBounds(28, 27, 754, 37);
				panel_ventaBoleto.add(lblNewLabel_16);
				
				JPanel panel_9 = new JPanel();
				panel_9.setBounds(28, 90, 754, 369);
				panel_ventaBoleto.add(panel_9);
				panel_9.setLayout(null);
				
				JLabel lblNewLabel_17 = new JLabel("C\u00F3digo excursi\u00F3n");
				lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_17.setBounds(63, 74, 129, 20);
				panel_9.add(lblNewLabel_17);
				
				Tf_VentaBoleto_Codigo = new JTextField();
				Tf_VentaBoleto_Codigo.setBounds(191, 68, 220, 26);
				panel_9.add(Tf_VentaBoleto_Codigo);
				Tf_VentaBoleto_Codigo.setColumns(10);
				
				Tf_VentaBoleto_Descuento = new JTextField();
				Tf_VentaBoleto_Descuento.setBounds(191, 107, 220, 26);
				panel_9.add(Tf_VentaBoleto_Descuento);
				Tf_VentaBoleto_Descuento.setColumns(10);
				
				JLabel lblNewLabel_18 = new JLabel("Datos de pasajero");
				lblNewLabel_18.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
				lblNewLabel_18.setBounds(15, 160, 200, 50);
				panel_9.add(lblNewLabel_18);
				
				JLabel lblNewLabel_19 = new JLabel("Edad");
				lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_19.setBounds(63, 213, 70, 27);
				panel_9.add(lblNewLabel_19);
				
				Tf_VentaBoleto_Edad = new JTextField();
				Tf_VentaBoleto_Edad.setBounds(159, 213, 252, 26);
				panel_9.add(Tf_VentaBoleto_Edad);
				Tf_VentaBoleto_Edad.setColumns(10);
				
				JLabel lblNewLabel_20 = new JLabel("Procedencia");
				lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_20.setBounds(63, 256, 100, 27);
				panel_9.add(lblNewLabel_20);
				
				Tf_VentaBoleto_Procedencia = new JTextField();
				Tf_VentaBoleto_Procedencia.setBounds(159, 256, 252, 26);
				panel_9.add(Tf_VentaBoleto_Procedencia);
				Tf_VentaBoleto_Procedencia.setColumns(10);
				
				JLabel lblNCel = new JLabel("N\u00B0 Cel");
				lblNCel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNCel.setBounds(63, 299, 70, 27);
				panel_9.add(lblNCel);
				
				Tf_VentaBoleto_Cel = new JTextField();
				Tf_VentaBoleto_Cel.setBounds(159, 299, 252, 26);
				panel_9.add(Tf_VentaBoleto_Cel);
				Tf_VentaBoleto_Cel.setColumns(10);
				
				JLabel lblNewLabel_21 = new JLabel("Datos del boleto");
				lblNewLabel_21.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
				lblNewLabel_21.setBounds(10, 11, 200, 50);
				panel_9.add(lblNewLabel_21);
				
				JLabel lblNewLabel_32 = new JLabel("Descuento");
				lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_32.setBounds(63, 105, 129, 26);
				panel_9.add(lblNewLabel_32);
				
				
				JButton Btn_VentaBoleto_Ingresar = new JButton("Ingresar");
				Btn_VentaBoleto_Ingresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_VentaBoleto_Ingresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String codigo = Tf_VentaBoleto_Codigo.getText();
						String edad = Tf_VentaBoleto_Edad.getText();
						String descuento = Tf_VentaBoleto_Descuento.getText();
						String procedencia = Tf_VentaBoleto_Procedencia.getText();
						String cel = Tf_VentaBoleto_Cel.getText();

						controladorVentaBoleto.ventaBoleto (codigo, edad, procedencia, cel, descuento);

					}
				});
				
				
				Btn_VentaBoleto_Ingresar.setBounds(655, 475, 127, 48);
				panel_ventaBoleto.add(Btn_VentaBoleto_Ingresar);
				
				final JButton Btn_VentaBoleto_Limpiar = new JButton("Limpiar");
				Btn_VentaBoleto_Limpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_VentaBoleto_Limpiar.addActionListener(new ActionListener() {
					
					//BOTON LIMPIAR VENTA BOLETO
					public void actionPerformed(ActionEvent arg0) {
				
						Tf_VentaBoleto_Codigo.setText("");
						Tf_VentaBoleto_Edad.setText("");
						Tf_VentaBoleto_Descuento.setText("0");
						Tf_VentaBoleto_Procedencia.setText("");
						Tf_VentaBoleto_Cel.setText("");
					}
				});
				Btn_VentaBoleto_Limpiar.setAutoscrolls(true);
				Btn_VentaBoleto_Limpiar.setBounds(500, 475, 127, 48);
				panel_ventaBoleto.add(Btn_VentaBoleto_Limpiar);
				
				
				
				final JPanel panel_listExPrecio = new JPanel();
				panel_listExPrecio.setBackground(Color.WHITE);
				panel_listExPrecio.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_listExPrecio);
				panel_listExPrecio.setLayout(null);
				
				JLabel lblNewLabel_12 = new JLabel("Listado de excursiones por rango de precios");
				lblNewLabel_12.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_12.setBounds(28, 27, 754, 37);
				panel_listExPrecio.add(lblNewLabel_12);
				
				final JPanel panel_7 = new JPanel();
				panel_7.setBounds(28, 131, 754, 328);
				panel_listExPrecio.add(panel_7);
				panel_7.setLayout(null);
				
				tableListExXRango = new JTable();
				tableListExXRango.setBounds(0, 0, 754, 328);
				panel_7.add(tableListExXRango);
				
				JButton Btn_ListadoExcXRango_Listar = new JButton("Listar");
				Btn_ListadoExcXRango_Listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_ListadoExcXRango_Listar.setBounds(655, 475, 127, 48);
				panel_listExPrecio.add(Btn_ListadoExcXRango_Listar);
				final DefaultTableModel model3 = new DefaultTableModel(0, 0);
				
				
				Btn_ListadoExcXRango_Listar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
							VOExcursionDisp arrVO[];
							model3.setRowCount(0);
										
							arrVO = controladorExcursionesXPrecio.excursionesXPrecio(Tf_ListadoExcXRango_Rango1.getText(), Tf_ListadoExcXRango_Rango2.getText());

							String columnNames [] = new String[] {"Codigo",
					                "Destino",
					                "Hr Partida",
					                "Hr Regreso",
					                "Precio Base",
					                "Cantidad disponible"};
							
							model3.setColumnIdentifiers(columnNames);
							
							tableListExXRango.setModel(model3);

							panel_7.setLayout(new BorderLayout());
							panel_7.add(tableListExXRango.getTableHeader(), BorderLayout.PAGE_START);
							panel_7.add(tableListExXRango, BorderLayout.CENTER);
							
							if(arrVO != null){
							{
								for(int i=0;i<arrVO.length;i++){
									Hora hp= arrVO[i].getHr_partida();
									Hora hr= arrVO[i].getHr_regreso();
									String hr_partida = String.valueOf(hp.getHora())+":"+String.valueOf(hp.getMin());
									String hr_regreso = String.valueOf(hr.getHora())+":"+String.valueOf(hr.getMin());
									model3.addRow(new Object[] { arrVO[i].getCodigo(), arrVO[i].getDestino(),hr_partida,hr_regreso,arrVO[i].getPrecioBase(),arrVO[i].getCant_disponibles()});
								}
							}
							
							
						}
						
					}
				});
				
				
				JLabel lblNewLabel_13 = new JLabel("Rango entre");
				lblNewLabel_13.setBounds(44, 98, 95, 20);
				panel_listExPrecio.add(lblNewLabel_13);
				lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				Tf_ListadoExcXRango_Rango1 = new JTextField();
				Tf_ListadoExcXRango_Rango1.setBounds(137, 97, 146, 26);
				panel_listExPrecio.add(Tf_ListadoExcXRango_Rango1);
				Tf_ListadoExcXRango_Rango1.setColumns(10);
				
				Tf_ListadoExcXRango_Rango2 = new JTextField();
				Tf_ListadoExcXRango_Rango2.setBounds(301, 97, 146, 26);
				panel_listExPrecio.add(Tf_ListadoExcXRango_Rango2);
				Tf_ListadoExcXRango_Rango2.setColumns(10);
				//scrollPane.setViewportView(table1);	
				
								//table1.setLayout(new BorderLayout());
								//panel_listGralBus.add(table1.getTableHeader(), BorderLayout.PAGE_START);
				
				
				
				final JPanel panel_inicio = new JPanel();
				panel_inicio.setBackground(Color.WHITE);
				panel_inicio.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_inicio);
				panel_inicio.setLayout(null);
				
				JLabel lblNewLabel_25 = new JLabel("Bienvenido al sistema Duck Boat");
				lblNewLabel_25.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_25.setBounds(28, 27, 754, 37);
				panel_inicio.add(lblNewLabel_25);
				
						
						JPanel panel_12 = new JPanel();
						panel_12.setBounds(28, 90, 754, 369);
						panel_inicio.add(panel_12);
						panel_12.setLayout(null);
						
						JLabel label_2 = new JLabel("");
						label_2.setIcon(new ImageIcon(img));
						label_2.setBounds(633, 8, 113, 136);
						panel_12.add(label_2);
						
						JLabel lblNuestaMisin = new JLabel("Quienes somos");
						lblNuestaMisin.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
						lblNuestaMisin.setBounds(15, 8, 200, 20);
						panel_12.add(lblNuestaMisin);
						
						JLabel lblNewLabel_26 = new JLabel("Somos una empresa de transporte que realiza paseos tanto por tierra como por mar. ");
						lblNewLabel_26.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblNewLabel_26.setBounds(35, 39, 681, 38);
						panel_12.add(lblNewLabel_26);
						
						JLabel lblNewLabel_27 = new JLabel("Misi\u00F3n y Visi\u00F3n");
						lblNewLabel_27.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
						lblNewLabel_27.setBounds(15, 202, 153, 29);
						panel_12.add(lblNewLabel_27);
						
						JLabel lblNewLabel_28 = new JLabel("Ofrecer tanto a turistas como a residentes, paseos \u00FAnicos y recreativos.");
						lblNewLabel_28.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblNewLabel_28.setBounds(35, 246, 676, 20);
						panel_12.add(lblNewLabel_28);
						
						JLabel lblNewLabel_29 = new JLabel("Convertirnos en uno de los paseos t\u00EDpicos de la zona de nuestro departamento Rocha, Uruguay.");
						lblNewLabel_29.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblNewLabel_29.setBounds(35, 277, 681, 28);
						panel_12.add(lblNewLabel_29);
						
						JLabel lblPosicionarnos = new JLabel("Posicionarnos como una empresa seria y responsable, cuya garant\u00EDa sea la satisfacci\u00F3n del cliente. ");
						lblPosicionarnos.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblPosicionarnos.setBounds(35, 316, 711, 28);
						panel_12.add(lblPosicionarnos);
						
						JLabel lblNewLabel_30 = new JLabel("Contamos con una flota de \u00F3mnibus llamados \"Duck boats\", los cuales son \u00FAnicos ");
						lblNewLabel_30.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblNewLabel_30.setBounds(35, 76, 681, 28);
						panel_12.add(lblNewLabel_30);
						
						JLabel lblNewLabel_31 = new JLabel("en nuestro pa\u00EDs. ");
						lblNewLabel_31.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 16));
						lblNewLabel_31.setBounds(35, 110, 152, 20);
						panel_12.add(lblNewLabel_31);
				

				
				
				
				final JPanel panel_respaldar = new JPanel();
				panel_respaldar.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_respaldar);
				panel_respaldar.setBackground(Color.WHITE);
				panel_respaldar.setLayout(null);
				
				JLabel lblNewLabel_24 = new JLabel("Respaldo de datos");
				lblNewLabel_24.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_24.setBounds(28, 27, 754, 37);
				panel_respaldar.add(lblNewLabel_24);
				
				JPanel panel_11 = new JPanel();
				panel_11.setBounds(28, 90, 754, 233);
				panel_respaldar.add(panel_11);
				panel_11.setLayout(null);
				
				JLabel lblestSeguroQue = new JLabel("\u00BFEst\u00E1 seguro que desea guardar los datos?");
				lblestSeguroQue.setBounds(179, 98, 550, 27);
				lblestSeguroQue.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
				panel_11.add(lblestSeguroQue);
				
				JButton Btn_Respaldar_Aceptar = new JButton("Aceptar");
				Btn_Respaldar_Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_Respaldar_Aceptar.setBounds(655, 475, 127, 48);
				panel_respaldar.add(Btn_Respaldar_Aceptar);
				
				Btn_Respaldar_Aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						controladorRespaldoDatos.respaldoDatos();
					}
				});

				
				final JPanel panel_listGralBus = new JPanel();
				panel_listGralBus.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_listGralBus);
				panel_listGralBus.setBackground(Color.WHITE);
				panel_listGralBus.setLayout(null);
				
				JLabel lblListadoDeTodos = new JLabel("Listado de todos los buses registrados");
				lblListadoDeTodos.setBounds(28, 27, 754, 37);
				lblListadoDeTodos.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				panel_listGralBus.add(lblListadoDeTodos);
				
				final JPanel panel_5 = new JPanel();
				panel_5.setBounds(28, 93, 754, 370);
				panel_listGralBus.add(panel_5);
				
				
				
				// TABLA LISTADO GRAL BUSES
				
				
				
				//JScrollPane scrollPane = new JScrollPane();
				
				tableListadoBuses = new JTable();
				panel_5.add(tableListadoBuses);
				tableListadoBuses.setBorder(UIManager.getBorder("EditorPane.border"));
				
				final JPanel panel_boletoVendidosEx = new JPanel();
				panel_boletoVendidosEx.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_boletoVendidosEx);
				panel_boletoVendidosEx.setBackground(Color.WHITE);
				panel_boletoVendidosEx.setLayout(null);
				
				JLabel lblNewLabel_22 = new JLabel("Listado de boletos vendidos para una excursion");
				lblNewLabel_22.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_22.setBounds(28, 27, 754, 37);
				panel_boletoVendidosEx.add(lblNewLabel_22);
				
				final JPanel panel_10 = new JPanel();
				panel_10.setBounds(28, 127, 754, 332);
				panel_boletoVendidosEx.add(panel_10);
				panel_10.setLayout(null);
				
				final JComboBox Cb_ListadoBoletosExcursion = new JComboBox();
				Cb_ListadoBoletosExcursion.setBounds(579, 93, 190, 26);
				panel_boletoVendidosEx.add(Cb_ListadoBoletosExcursion);
				Cb_ListadoBoletosExcursion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				Cb_ListadoBoletosExcursion.setModel(new DefaultComboBoxModel(new String[] {"comun", "especial"}));
				
				JButton Btn_ListadoBoletosExcursion_Listar = new JButton("Listar");
				Btn_ListadoBoletosExcursion_Listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_ListadoBoletosExcursion_Listar.setBounds(655, 475, 127, 48);
				panel_boletoVendidosEx.add(Btn_ListadoBoletosExcursion_Listar);
				final DefaultTableModel model4 = new DefaultTableModel(0, 0);
				Btn_ListadoBoletosExcursion_Listar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						VOBoletoTipo arrVO[];	
						model4.setRowCount(0);
					
						arrVO = controladorBoletosVendidosXEx.boletosVendidosXEx(Tf_ListadoBoletosExcursion_Codigo.getText(), Cb_ListadoBoletosExcursion.getSelectedItem().toString());
						
						
						String columnNames [] = new String[] {"Nro boleto",
				                "Edad pasajero",
				                "Lugar procedencia",
				                "Celular pasajero",
				                "Descuento"};
						

						model4.setColumnIdentifiers(columnNames);
						
						tableListExBus.setModel(model4);

						panel_10.setLayout(new BorderLayout());
						panel_10.add(tableListExBus.getTableHeader(), BorderLayout.PAGE_START);
						panel_10.add(tableListExBus, BorderLayout.CENTER);
						
						if(arrVO!=null){
							for(int i=0;i<arrVO.length;i++){
								model4.addRow(new Object[] { arrVO[i].getNro_boleto(), arrVO[i].getEdad_pas(),arrVO[i].getLugar_procedencia(),arrVO[i].getCel_pas(),arrVO[i].getDescuento()});
							}
						}					
					}
				});
				
				JLabel lblNewLabel_23 = new JLabel("C\u00F3digo de excursi\u00F3n");
				lblNewLabel_23.setBounds(44, 96, 151, 20);
				panel_boletoVendidosEx.add(lblNewLabel_23);
				lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				Tf_ListadoBoletosExcursion_Codigo = new JTextField();
				Tf_ListadoBoletosExcursion_Codigo.setBounds(194, 95, 146, 26);
				panel_boletoVendidosEx.add(Tf_ListadoBoletosExcursion_Codigo);
				Tf_ListadoBoletosExcursion_Codigo.setColumns(10);
				
				JLabel lblTipoDeBoleto = new JLabel("Tipo de boleto");
				lblTipoDeBoleto.setBounds(458, 96, 103, 20);
				panel_boletoVendidosEx.add(lblTipoDeBoleto);
				lblTipoDeBoleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
			
				
				
				final JPanel panel_recaudacionEx = new JPanel();
				panel_recaudacionEx.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_recaudacionEx);
				panel_recaudacionEx.setBackground(Color.WHITE);
				panel_recaudacionEx.setLayout(null);
				
				JLabel lblNewLabel_14 = new JLabel("Recaudaci\u00F3n de excursi\u00F3n");
				lblNewLabel_14.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_14.setBounds(28, 27, 754, 37);
				panel_recaudacionEx.add(lblNewLabel_14);
				
				JPanel panel_8 = new JPanel();
				panel_8.setBounds(28, 90, 754, 369);
				panel_recaudacionEx.add(panel_8);
				panel_8.setLayout(null);
				
				JLabel lblNewLabel_15 = new JLabel("C\u00F3digo de excursi\u00F3n");
				lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_15.setBounds(15, 8, 150, 20);
				panel_8.add(lblNewLabel_15);
				
				Tf_Recaudacion_Codigo = new JTextField();
				Tf_Recaudacion_Codigo.setBounds(180, 5, 146, 26);
				panel_8.add(Tf_Recaudacion_Codigo);
				Tf_Recaudacion_Codigo.setColumns(10);
				
				final JLabel lb_RecaudacionExc = new JLabel("");
				lb_RecaudacionExc.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lb_RecaudacionExc.setBounds(86, 84, 624, 54);
				panel_8.add(lb_RecaudacionExc);
				
				JButton Btn_RecaudacionExcursion_Ver = new JButton("Ver");
				Btn_RecaudacionExcursion_Ver.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_RecaudacionExcursion_Ver.setBounds(655, 475, 127, 48);
				panel_recaudacionEx.add(Btn_RecaudacionExcursion_Ver);
				
				Btn_RecaudacionExcursion_Ver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {								
						controladorRecaudacionExcursion.recaudacionExcursion(Tf_Recaudacion_Codigo.getText());
					}
				});
				
			
				
				final JPanel panel_listExBus = new JPanel();
				panel_listExBus.setBackground(Color.WHITE);
				panel_listExBus.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_listExBus);
				panel_listExBus.setLayout(null);
				
				JLabel lblNewLabel_9 = new JLabel("Listado excursiones asignadas a un bus");
				lblNewLabel_9.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_9.setBounds(28, 27, 754, 37);
				panel_listExBus.add(lblNewLabel_9);
				
				final JPanel panel_4 = new JPanel();
				panel_4.setBounds(28, 125, 754, 334);
				panel_listExBus.add(panel_4);
				panel_4.setLayout(null);
				
				tableListExBus = new JTable();
				tableListExBus.setBounds(0, 0, 754, 334);
				panel_4.add(tableListExBus);
				final DefaultTableModel model = new DefaultTableModel(0, 0);
				
				
				JButton Btn_ListadoExcBus_Listar = new JButton("Listar");
				Btn_ListadoExcBus_Listar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_ListadoExcBus_Listar.setBounds(655, 475, 127, 48);
				panel_listExBus.add(Btn_ListadoExcBus_Listar);
				
				Btn_ListadoExcBus_Listar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);	
						VOExcursionDisp arrVO[];

						arrVO = controladorListadoExcursionDisp.listadoExcursionesXBus(Tf_ListadoExcBus_Matricula.getText());
						
						
						String columnNames [] = new String[] {"Codigo",
				                "Destino",
				                "Hr Partida",
				                "Hr Regreso",
				                "Precio Base",
				                "Cantidad disponible"};
						

						model.setColumnIdentifiers(columnNames);
						
						tableListExBus.setModel(model);

						panel_4.setLayout(new BorderLayout());
						panel_4.add(tableListExBus.getTableHeader(), BorderLayout.PAGE_START);
						panel_4.add(tableListExBus, BorderLayout.CENTER);
						

						if(arrVO != null){
							for(int i=0;i<arrVO.length;i++){
								Hora hp= arrVO[i].getHr_partida();
								Hora hr= arrVO[i].getHr_regreso();
								String hr_partida = String.valueOf(hp.getHora())+":"+String.valueOf(hp.getMin());
								String hr_regreso = String.valueOf(hr.getHora())+":"+String.valueOf(hr.getMin());
								model.addRow(new Object[] { arrVO[i].getCodigo(), arrVO[i].getDestino(),hr_partida,hr_regreso,arrVO[i].getPrecioBase(),arrVO[i].getCant_disponibles()});
							}
							
							
						}
					
					}
					
				});
				
	
				JLabel lblMatricula_1 = new JLabel("Matricula");
				lblMatricula_1.setBounds(44, 94, 63, 20);
				panel_listExBus.add(lblMatricula_1);
				lblMatricula_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				Tf_ListadoExcBus_Matricula = new JTextField();
				Tf_ListadoExcBus_Matricula.setBounds(117, 93, 146, 26);
				panel_listExBus.add(Tf_ListadoExcBus_Matricula);
				Tf_ListadoExcBus_Matricula.setColumns(10);
				JButton btnListadoGeneralBuses = new JButton("Listado gral buses");
		
				
				final JPanel panel_nuevaExcursion = new JPanel();
				panel_nuevaExcursion.setBackground(Color.WHITE);
				panel_nuevaExcursion.setBounds(183, 11, 819, 539);
				frame.getContentPane().add(panel_nuevaExcursion);
				panel_nuevaExcursion.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("Registro de nueva excursi\u00F3n");
				lblNewLabel_2.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
				lblNewLabel_2.setBounds(28, 27, 754, 37);
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
				
				Tf_RegistroNuevaExcursion_Codigo = new JTextField();
				Tf_RegistroNuevaExcursion_Codigo.setBounds(173, 49, 372, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_Codigo);
				Tf_RegistroNuevaExcursion_Codigo.setColumns(10);
				
				Tf_RegistroNuevaExcursion_Destino = new JTextField();
				Tf_RegistroNuevaExcursion_Destino.setBounds(173, 82, 372, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_Destino);
				Tf_RegistroNuevaExcursion_Destino.setColumns(10);
				
				Tf_RegistroNuevaExcursion_HrPartida = new JTextField();
				Tf_RegistroNuevaExcursion_HrPartida.setBounds(173, 113, 56, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_HrPartida);
				Tf_RegistroNuevaExcursion_HrPartida.setColumns(10);
				
				Tf_RegistroNuevaExcursion_HrRegreso = new JTextField();
				Tf_RegistroNuevaExcursion_HrRegreso.setBounds(173, 143, 56, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_HrRegreso);
				Tf_RegistroNuevaExcursion_HrRegreso.setColumns(10);
				
				Tf_RegistroNuevaExcursion_Precio = new JTextField();
				Tf_RegistroNuevaExcursion_Precio.setBounds(173, 175, 372, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_Precio);
				Tf_RegistroNuevaExcursion_Precio.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel(":");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel_5.setBounds(239, 110, 19, 20);
				panel_2.add(lblNewLabel_5);
				
				JLabel label = new JLabel(":");
				label.setFont(new Font("Tahoma", Font.PLAIN, 20));
				label.setBounds(239, 142, 19, 20);
				panel_2.add(label);
				
				Tf_RegistroNuevaExcursion_HrPartidaMin = new JTextField();
				Tf_RegistroNuevaExcursion_HrPartidaMin.setBounds(259, 114, 56, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_HrPartidaMin);
				Tf_RegistroNuevaExcursion_HrPartidaMin.setColumns(10);
				
				Tf_RegistroNuevaExcursion_HrRegresoMin = new JTextField();
				Tf_RegistroNuevaExcursion_HrRegresoMin.setBounds(259, 143, 56, 20);
				panel_2.add(Tf_RegistroNuevaExcursion_HrRegresoMin);
				Tf_RegistroNuevaExcursion_HrRegresoMin.setColumns(10);
				
				JButton Btn_RegistroNuevaExcursion_Ingresar = new JButton("Ingresar");
				Btn_RegistroNuevaExcursion_Ingresar.addActionListener(new ActionListener() {
					
					
					//BOTON INGRESAR NUEVA EXCURSION
					public void actionPerformed(ActionEvent arg0) {
						String Codigo = Tf_RegistroNuevaExcursion_Codigo.getText();
						String Destino = Tf_RegistroNuevaExcursion_Destino.getText();
						String HrPartida = Tf_RegistroNuevaExcursion_HrPartida.getText();
						String HrPartidaMin = Tf_RegistroNuevaExcursion_HrPartidaMin.getText();
						String HrRegreso = Tf_RegistroNuevaExcursion_HrRegreso.getText();
						String HrRegresoMin = Tf_RegistroNuevaExcursion_HrRegresoMin.getText();
						String Precio = Tf_RegistroNuevaExcursion_Precio.getText();
					
						controladorNuevaExcursion.nuevaExcursion (Codigo, Destino, HrPartida, HrPartidaMin, HrRegreso, HrRegresoMin, Precio);
						
					}
				});
				
				
				Btn_RegistroNuevaExcursion_Ingresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_RegistroNuevaExcursion_Ingresar.setBounds(655, 475, 127, 48);
				panel_nuevaExcursion.add(Btn_RegistroNuevaExcursion_Ingresar);
				
				final JButton Btn_RegistroNuevaExcursion_Limpiar = new JButton("Limpiar");
				Btn_RegistroNuevaExcursion_Limpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Tf_RegistroNuevaExcursion_Codigo.setText("");
						Tf_RegistroNuevaExcursion_Destino.setText("");
						Tf_RegistroNuevaExcursion_HrPartida.setText("");
						Tf_RegistroNuevaExcursion_HrPartidaMin.setText("");
						Tf_RegistroNuevaExcursion_HrRegreso.setText("");
						Tf_RegistroNuevaExcursion_HrRegresoMin.setText("");
						Tf_RegistroNuevaExcursion_Precio.setText("");
					}
				});
				Btn_RegistroNuevaExcursion_Limpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Btn_RegistroNuevaExcursion_Limpiar.setBounds(500, 475, 127, 48);
				panel_nuevaExcursion.add(Btn_RegistroNuevaExcursion_Limpiar);
		
		final JPanel panel_reasigExcursion = new JPanel();
		panel_reasigExcursion.setBackground(Color.WHITE);
		panel_reasigExcursion.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_reasigExcursion);
		panel_reasigExcursion.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Reasignaci\u00F3n de excursi\u00F3n");
		lblNewLabel_6.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 27));
		lblNewLabel_6.setBounds(28, 27, 754, 37);
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
		
		Tf_ReasignacionDeExcursion_Codigo = new JTextField();
		Tf_ReasignacionDeExcursion_Codigo.setBounds(148, 80, 146, 26);
		panel_3.add(Tf_ReasignacionDeExcursion_Codigo);
		Tf_ReasignacionDeExcursion_Codigo.setColumns(10);
		
		JButton Btn_ReasignacionNuevaExcursion_Reasignar = new JButton("Reasignar");
		Btn_ReasignacionNuevaExcursion_Reasignar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Btn_ReasignacionNuevaExcursion_Reasignar.addActionListener(new ActionListener() {
			
			
			//BOTON REASIGNAR EXCURSION
			public void actionPerformed(ActionEvent arg0) {
				String Codigo = Tf_ReasignacionDeExcursion_Codigo.getText();		
				controladorReasignarExcursion.reasignarExcursion (Codigo);						
			}
		});
		
		
		Btn_ReasignacionNuevaExcursion_Reasignar.setBounds(655, 475, 127, 48);
		panel_reasigExcursion.add(Btn_ReasignacionNuevaExcursion_Reasignar);
		
		final JPanel panel_nuevoBus = new JPanel();
		panel_nuevoBus.setBounds(183, 11, 819, 539);
		frame.getContentPane().add(panel_nuevoBus);
		panel_nuevoBus.setBackground(Color.WHITE);
		panel_nuevoBus.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingreso de un nuevo bus");
		lblNewLabel_1.setBounds(28, 27, 754, 37);
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
		
		Tf_NuevoBus_Matricula = new JTextField();
		Tf_NuevoBus_Matricula.setBounds(171, 76, 376, 20);
		panel_1.add(Tf_NuevoBus_Matricula);
		Tf_NuevoBus_Matricula.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(64, 106, 71, 19);
		panel_1.add(lblMarca);
		
		Tf_NuevoBus_Marca = new JTextField();
		Tf_NuevoBus_Marca.setBounds(171, 107, 376, 20);
		panel_1.add(Tf_NuevoBus_Marca);
		Tf_NuevoBus_Marca.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCapacidad.setBounds(64, 138, 97, 20);
		panel_1.add(lblCapacidad);
		
		Tf_NuevoBus_Capacidad = new JTextField();
		Tf_NuevoBus_Capacidad.setBounds(171, 138, 376, 20);
		panel_1.add(Tf_NuevoBus_Capacidad);
		Tf_NuevoBus_Capacidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Datos del bus");
		lblNewLabel.setBounds(10, 11, 219, 27);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		
		JButton Btn_NuevoBus_Ingresar = new JButton("Ingresar");
		Btn_NuevoBus_Ingresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Btn_NuevoBus_Ingresar.addActionListener(new ActionListener() {
			
			//ESTE ES EL BOTON INGRESAR DE NUEVO BUS
			
			public void actionPerformed(ActionEvent arg0) {
				String Matricula = Tf_NuevoBus_Matricula.getText();
				String Marca = Tf_NuevoBus_Marca.getText();
				String Capacidad = Tf_NuevoBus_Capacidad.getText();						
				controladorNuevoBus.nuevoBus (Matricula, Marca, Capacidad);

			}
		});
		Btn_NuevoBus_Ingresar.setBounds(655, 475, 127, 48);
		panel_nuevoBus.add(Btn_NuevoBus_Ingresar);
		
		final JButton Btn_NuevoBus_Limpiar = new JButton("Limpiar");
		Btn_NuevoBus_Limpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Btn_NuevoBus_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tf_NuevoBus_Matricula.setText("");
				Tf_NuevoBus_Marca.setText("");
				Tf_NuevoBus_Capacidad.setText("");
			}
		});
		Btn_NuevoBus_Limpiar.setBounds(500, 475, 127, 48);
		panel_nuevoBus.add(Btn_NuevoBus_Limpiar);
		
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
		panel.add(btnInicio); btnInicio.doClick();
		
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
				Btn_NuevoBus_Limpiar.doClick();
				
			}
		});
		btnNuevoBus.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNuevoBus.setBounds(10, 53, 153, 31);
		panel.add(btnNuevoBus);
	
		btnListadoGeneralBuses.setFont(new Font("Verdana", Font.BOLD, 11));
		btnListadoGeneralBuses.setBounds(10, 95, 153, 31);
		panel.add(btnListadoGeneralBuses);
		
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

				
				VOBusCant arrVO[];
				arrVO = controladorListadoGralBuses.listadoGralBuses();
				DefaultTableModel model = new DefaultTableModel(0, 0);
				
				String columnNames [] = new String[] {"Matricula",
		                "Marca",
		                "Capacidad",
		                "Cantidad Excursiones"};
				

				model.setColumnIdentifiers(columnNames);
				
				tableListadoBuses.setModel(model);

				panel_5.setLayout(new BorderLayout());
				panel_5.add(tableListadoBuses.getTableHeader(), BorderLayout.PAGE_START);
				panel_5.add(tableListadoBuses, BorderLayout.CENTER);
				
	
				if(arrVO != null){
					for(int i=0;i<arrVO.length;i++){
						model.addRow(new Object[] { arrVO[i].getMatricula(), arrVO[i].getMarca(), arrVO[i].getCapacidad(),
								arrVO[i].getCat_ex()});
					}
				}
					
			}
		});
		
		
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
				Btn_RegistroNuevaExcursion_Limpiar.doClick();
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
				Tf_ReasignacionDeExcursion_Codigo.setText("");
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
				Tf_ListadoExcBus_Matricula.setText("");
				model.setRowCount(0);
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
				Tf_ListadoExcDest_Destino.setText("");
				model1.setRowCount(0);
			}
		});
		btnListadoExcDest.setBounds(10, 263, 153, 31);
		panel.add(btnListadoExcDest);
		
		JButton btnListadoExcPrecio = new JButton("List. exc-precio");
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
				Tf_ListadoExcXRango_Rango1.setText("");
				Tf_ListadoExcXRango_Rango2.setText("");
				model3.setRowCount(0);
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
				Tf_Recaudacion_Codigo.setText("");
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
				Btn_VentaBoleto_Limpiar.doClick();
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
				Tf_ListadoBoletosExcursion_Codigo.setText("");
				model4.setRowCount(0);
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
				panel_boletoVendidosEx.setVisible(false);
				panel_respaldar.setVisible(true);
			}
		});
		btnRespaldar.setBounds(10, 473, 153, 31);
		panel.add(btnRespaldar);
		
	}
}
