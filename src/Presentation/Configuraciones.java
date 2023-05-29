package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Domain.PoobStairsException;

public class Configuraciones extends JFrame{
	
	private Dimension screen;
	private JPanel separador;
	private boolean datosListos;
	private int numJug;
	private JButton tableroPequeño1;
	private JButton tableroMediano1;
	private JButton tableroNormal1;
	private JButton tableroGrande1;
	private JComboBox<Integer> frecuencia;
	private JLabel titulo1;
	private JLabel titulo2;
	private JLabel titulo3;
	private int m;
	private int aparicion;
	 
	private JPanel menu;
	private JButton inicio;
	private JButton continuar;
	private JLabel logo;
		
	private JPanel formulario1;
	private JButton casillasEspeciales;
	private JButton transformar;
	private JButton modificar;
	private JLabel titulo4;
	private JLabel subtitulo1;
	private JLabel subtitulo2;
	private JComboBox<Integer> casillaEspecialPorc;
	private JComboBox<Integer> aparicionModificadores;
	private int modifica = 0;
	private int especialesPorc = 0;
	private boolean transforma;
	
	private JPanel formulario2;
	private JButton tableroPequeño;
	private JButton tableroMediano;
	private JButton tableroNormal;
	private JButton tableroGrande;
	
	private JPanel jugador2;
	private JPanel informacion2;
	private JTextField nombre2;
	private JLabel icono2;
	private JLabel colores2;
	private JButton azul2;
	private JButton verde2;
	private JButton gris2;
	private JButton naranja2;
	private JButton amarillo2;
	private JButton rosa2;
	private String color2;
	private String nombrej2;
	
	private JPanel menu2;
	private JButton inicio2;
	public JButton continuar2;
	private JLabel logo2;
	
	private JPanel jugador1;
	private JPanel informacion;
	private JTextField nombre1;
	private JLabel icono;
	private JLabel colores;
	private JButton azul;
	private JButton verde;
	private JButton gris;
	private JButton naranja;
	private JButton amarillo;
	private JButton rosa;
	private String color1;
	private String nombrej1;
	
	private JPanel menu1;
	private JButton inicio1;
	public JButton continuar1;
	private JLabel logo1;
	
	
	public Configuraciones(int numJugadores){
		
		numJug = numJugadores;
        prepareElements(); /*Vista*/
        prepareActions(); /*controlador*/
        
    }
	
	private void prepareElements() {
		
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocationRelativeTo(null);
		setTitle("Configuraciones");
		setSize(screen.width - 580, screen.height - 200);
		setLocation(screen.width / 7, screen.height / 8);
		
		elementosFormulario();
		add(separador);
		
	}
	
	private void prepareActions() {
		
		prepareActionsTablero();
		prepareActionsJugador1();
		prepareActionsJugador2();
		
	}
	
	private void elementosFormulario() {
		
		//panel
		separador = new JPanel();
		separador.setSize(screen.width / 2, screen.height / 2);
		separador.setBackground(Color.decode("#FDF4F5"));
		separador.setLayout(null);
		separador.setVisible(true);
		
		elementosMenu();
		continuar.setEnabled(false);
		separador.add(menu);
		
		elementosFormulario1();
		separador.add(formulario1);
		
		elementosFormulario2();
		separador.add(formulario2);
		
		titulo1 = new JLabel("Tablero");
		titulo1.setFont(new java.awt.Font("Verdana", 1, 50));
		titulo1.setForeground(Color.decode("#E8A0BF"));
		titulo1.setBounds(70, 350, 350, 50);
		separador.add(titulo1);
		
		titulo2 = new JLabel("Frecuencia de aparición de las serpientes");
		titulo2.setFont(new java.awt.Font("Verdana", 1, 15));
		titulo2.setForeground(Color.decode("#EEBED3"));;
		titulo2.setBounds(70, 410, 360, 15);
		separador.add(titulo2);
		
		titulo3 = new JLabel("y escaleras: ");
		titulo3.setFont(new java.awt.Font("Verdana", 1, 15));
		titulo3.setForeground(Color.decode("#EEBED3"));;
		titulo3.setBounds(70, 430, 360, 15);
		separador.add(titulo3);
		
		frecuencia = new JComboBox<Integer>();
		frecuencia.addItem(0);
		frecuencia.addItem(5);
		frecuencia.addItem(10);
		frecuencia.addItem(15);
		frecuencia.addItem(20);
		frecuencia.addItem(25);
		frecuencia.setBounds(70, 460, 150, 30);
		frecuencia.setBackground(Color.decode("#C0DBEA"));
		separador.add(frecuencia);
		
		tableroPequeño1 = new JButton("Pequeño");
		tableroPequeño1.setBounds(575, 280, 140, 70);
		tableroPequeño1.setBorderPainted(false);
		tableroPequeño1.setForeground(Color.WHITE);
		tableroPequeño1.setBackground(Color.decode("#BA90C6"));
		separador.add(tableroPequeño1);
		
		tableroNormal1 = new JButton("Normal");
		tableroNormal1.setBounds(725, 280, 140, 70);
		tableroNormal1.setBorderPainted(false);
		tableroNormal1.setForeground(Color.WHITE);
		tableroNormal1.setBackground(Color.decode("#BA90C6"));
		separador.add(tableroNormal1);
		
		tableroMediano1 = new JButton("Mediano");
		tableroMediano1.setBounds(575, 525, 140, 70);
		tableroMediano1.setBorderPainted(false);
		tableroMediano1.setForeground(Color.WHITE);
		tableroMediano1.setBackground(Color.decode("#BA90C6"));
		separador.add(tableroMediano1);
		
		tableroGrande1 = new JButton("Grande");
		tableroGrande1.setBounds(725, 525, 140, 70);
		tableroGrande1.setBorderPainted(false);
		tableroGrande1.setForeground(Color.WHITE);
		tableroGrande1.setBackground(Color.decode("#BA90C6"));
		separador.add(tableroGrande1);
		
		elementosFormularioJugadores();
		
		elementosFormularioJugadores2();
		
	}
	
	private void elementosMenu() {
		
		menu = new JPanel();
		menu.setBounds(0, 0, (screen.width / 2) + 200, 50);
		menu.setBackground(Color.decode("#E8A0BF"));
		menu.setLayout(null);
		menu.setVisible(true);
		
		inicio = new JButton();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/hogar.png")); 
		inicio.setIcon(icon1);
		inicio.setBounds(10, 0, 50, 50);
		inicio.setBorderPainted(false);
		inicio.setContentAreaFilled(false);
		menu.add(inicio);
		
		continuar = new JButton();
		ImageIcon icon = new ImageIcon(getClass().getResource("/aceptar.png")); 
		continuar.setIcon(icon);
		continuar.setBounds((screen.width / 2) + 120, 0, 50, 50);
		continuar.setBorderPainted(false);
		continuar.setOpaque(false);
		continuar.setContentAreaFilled(false);
		menu.add(continuar);
		
		logo = new JLabel("POOBSTAIRS");
		logo.setFont(new java.awt.Font("Verdana", 1, 30));
		logo.setForeground(Color.decode("#EEBED3"));;
		logo.setBounds(350, 10, 360, 30);
		menu.add(logo);
		
	}
	
	private void elementosFormulario1() {
		
		formulario1 = new JPanel();
		formulario1.setBounds(70, 70, 800, 170);
		formulario1.setBackground(Color.decode("#C0DBEA"));
		formulario1.setLayout(null);
		formulario1.setVisible(true);
		
		titulo4 = new JLabel("Adicional");
		titulo4.setFont(new java.awt.Font("Verdana", 1, 30));
		titulo4.setForeground(Color.decode("#E8A0BF"));
		titulo4.setBounds(30, 30, 350, 50);
		formulario1.add(titulo4);
		
		subtitulo1 = new JLabel("Aumenta la dificutlad del");
		subtitulo1.setFont(new java.awt.Font("Verdana", 1, 15));
		subtitulo1.setForeground(Color.decode("#EEBED3"));;
		subtitulo1.setBounds(30, 75, 360, 15);
		formulario1.add(subtitulo1);
		
		subtitulo2 = new JLabel("juego con lo siguiente:");
		subtitulo2.setFont(new java.awt.Font("Verdana", 1, 15));
		subtitulo2.setForeground(Color.decode("#EEBED3"));;
		subtitulo2.setBounds(30, 95, 360, 15);
		formulario1.add(subtitulo2);
		
		casillasEspeciales = new JButton("Casillas Especiales");
		casillasEspeciales.setForeground(Color.WHITE);
		casillasEspeciales.setBounds(300, 0, 150, 160);
		casillasEspeciales.setBorderPainted(false);
		casillasEspeciales.setBackground(Color.decode("#BA90C6"));
		formulario1.add(casillasEspeciales);
		
		transformar = new JButton("Transformaciones");
		transformar.setForeground(Color.WHITE);
		transformar.setBounds(460, 0, 150, 160);
		transformar.setBorderPainted(false);
		transformar.setBackground(Color.decode("#BA90C6"));
		formulario1.add(transformar);
		
		modificar = new JButton("Modificadores");
		modificar.setForeground(Color.WHITE);
		modificar.setBounds(620, 0, 150, 160);
		modificar.setBorderPainted(false);
		modificar.setBackground(Color.decode("#BA90C6"));
		formulario1.add(modificar);
		
		casillaEspecialPorc = new JComboBox<Integer>();
		casillaEspecialPorc.addItem(0);
		casillaEspecialPorc.addItem(5);
		casillaEspecialPorc.addItem(10);
		casillaEspecialPorc.addItem(15);
		casillaEspecialPorc.addItem(20);
		casillaEspecialPorc.addItem(25);
		casillaEspecialPorc.setBounds(300, 70, 150, 30);
		casillaEspecialPorc.setBackground(Color.decode("#C0DBEA"));
		
		
		aparicionModificadores = new JComboBox<Integer>();
		aparicionModificadores.addItem(0);
		aparicionModificadores.addItem(5);
		aparicionModificadores.addItem(10);
		aparicionModificadores.addItem(15);
		aparicionModificadores.addItem(20);
		aparicionModificadores.addItem(25);
		aparicionModificadores.setBounds(620, 70, 150, 30);
		aparicionModificadores.setBackground(Color.decode("#C0DBEA"));
		
	}
	
	private void elementosFormulario2() {
		
		formulario2 = new JPanel();
		formulario2.setBounds(520, 350, 450, 175);
		formulario2.setBackground(Color.decode("#C0DBEA"));
		formulario2.setLayout(null);
		formulario2.setVisible(true);
		
		tableroPequeño = new JButton();
		tableroPequeño.setBounds(55, 0, 140, 70);
		tableroPequeño.setBorderPainted(false);
		tableroPequeño.setBackground(Color.decode("#BA90C6"));
		formulario2.add(tableroPequeño);
		
		tableroNormal = new JButton();
		tableroNormal.setBounds(205, 0, 140, 70);
		tableroNormal.setBorderPainted(false);
		tableroNormal.setBackground(Color.decode("#BA90C6"));
		formulario2.add(tableroNormal);
		
		tableroMediano = new JButton();
		tableroMediano.setBounds(55, 105, 140, 70);
		tableroMediano.setBorderPainted(false);
		tableroMediano.setBackground(Color.decode("#BA90C6"));
		formulario2.add(tableroMediano);
		
		tableroGrande = new JButton();
		tableroGrande.setBounds(205, 105, 140, 70);
		tableroGrande.setBorderPainted(false);
		tableroGrande.setBackground(Color.decode("#BA90C6"));
		formulario2.add(tableroGrande);
		
	}
	
private void prepareActionsTablero() {
		
		inicio.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == inicio) {
						
						setVisible(false);
						
					}
				}
		});
		
		continuar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == continuar) {
						
						aparicion = frecuencia.getItemAt(frecuencia.getSelectedIndex());
						
						if(m != 0 && aparicion != 0 ) {
							
							if(casillasEspeciales.getBackground().equals(Color.decode("#E8A0BF"))) {
								
								if(casillaEspecialPorc.getItemAt(casillaEspecialPorc.getSelectedIndex()) != 0) {
									
									especialesPorc = casillaEspecialPorc.getItemAt(casillaEspecialPorc.getSelectedIndex());
									
									if(modificar.getBackground().equals(Color.decode("#E8A0BF"))) {
										
										if(aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex()) != 0) {
											
											modifica = aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex());
											separador.setEnabled(false);
											separador.setVisible(false);
											add(jugador1);
											jugador1.setEnabled(true);
											jugador1.setVisible(true);
											
										}
										else {
											
											JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
											
										}
										
									}
									else {
										
										if(modificar.getBackground().equals(Color.decode("#E8A0BF"))) {
											
											if(aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex()) != 0) {
												
												modifica = aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex());
												separador.setEnabled(false);
												separador.setVisible(false);
												add(jugador1);
												jugador1.setEnabled(true);
												jugador1.setVisible(true);
												
											}
											else {
												
												JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
												
											}
											
										}
										else {
											
											if(modificar.getBackground().equals(Color.decode("#E8A0BF"))) {
												
												if(aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex()) != 0) {
													
													modifica = aparicionModificadores.getItemAt(aparicionModificadores.getSelectedIndex());
													separador.setEnabled(false);
													separador.setVisible(false);
													add(jugador1);
													jugador1.setEnabled(true);
													jugador1.setVisible(true);
													
												}
												else {
													
													JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
													
												}
												
											}
											else {
												
												separador.setEnabled(false);
												separador.setVisible(false);
												add(jugador1);
												jugador1.setEnabled(true);
												jugador1.setVisible(true);
												
											}
											
										}

										
									}
									
								}
								else {
									
									JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
									
								}
								
							}
							else {
								
								separador.setEnabled(false);
								separador.setVisible(false);
								add(jugador1);
								jugador1.setEnabled(true);
								jugador1.setVisible(true);
								
							}
							
							
							
						}
						else {
	
							JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
							
						}
							
					}
				}
		});
		
		tableroPequeño.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == tableroPequeño) {
						
						tableroPequeño.setBackground(Color.decode("#E8A0BF"));
						tableroPequeño1.setBackground(Color.decode("#E8A0BF"));
						tableroMediano.setBackground(Color.decode("#BA90C6"));
						tableroMediano1.setBackground(Color.decode("#BA90C6"));
						tableroNormal.setBackground(Color.decode("#BA90C6"));
						tableroNormal1.setBackground(Color.decode("#BA90C6"));
						tableroGrande.setBackground(Color.decode("#BA90C6"));
						tableroGrande1.setBackground(Color.decode("#BA90C6"));
						continuar.setEnabled(true);
						m = 5;
						
					}
				}
		});
		
		tableroMediano.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == tableroMediano) {
						
						tableroPequeño.setBackground(Color.decode("#BA90C6"));
						tableroPequeño1.setBackground(Color.decode("#BA90C6"));
						tableroMediano.setBackground(Color.decode("#E8A0BF"));
						tableroMediano1.setBackground(Color.decode("#E8A0BF"));
						tableroNormal.setBackground(Color.decode("#BA90C6"));
						tableroNormal1.setBackground(Color.decode("#BA90C6"));
						tableroGrande.setBackground(Color.decode("#BA90C6"));
						tableroGrande1.setBackground(Color.decode("#BA90C6"));
						continuar.setEnabled(true);
						m = 8;
						
					}
				}
		});
		
		tableroNormal.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == tableroNormal) {
						
						tableroPequeño.setBackground(Color.decode("#BA90C6"));
						tableroPequeño1.setBackground(Color.decode("#BA90C6"));
						tableroMediano.setBackground(Color.decode("#BA90C6"));
						tableroMediano1.setBackground(Color.decode("#BA90C6"));
						tableroNormal.setBackground(Color.decode("#E8A0BF"));
						tableroNormal1.setBackground(Color.decode("#E8A0BF"));
						tableroGrande.setBackground(Color.decode("#BA90C6"));
						tableroGrande1.setBackground(Color.decode("#BA90C6"));
						continuar.setEnabled(true);
						m = 7;
					}
				}
		});
		
		tableroGrande.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == tableroGrande) {
						
						tableroPequeño.setBackground(Color.decode("#BA90C6"));
						tableroPequeño1.setBackground(Color.decode("#BA90C6"));
						tableroMediano.setBackground(Color.decode("#BA90C6"));
						tableroMediano1.setBackground(Color.decode("#BA90C6"));
						tableroNormal.setBackground(Color.decode("#BA90C6"));
						tableroNormal1.setBackground(Color.decode("#BA90C6"));
						tableroGrande.setBackground(Color.decode("#E8A0BF"));
						tableroGrande1.setBackground(Color.decode("#E8A0BF"));
						continuar.setEnabled(true);
						m = 10;
					}
				}
		});
		
		tableroPequeño1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == tableroPequeño1) {
							
							tableroPequeño.setBackground(Color.decode("#E8A0BF"));
							tableroPequeño1.setBackground(Color.decode("#E8A0BF"));
							tableroMediano.setBackground(Color.decode("#BA90C6"));
							tableroMediano1.setBackground(Color.decode("#BA90C6"));
							tableroNormal.setBackground(Color.decode("#BA90C6"));
							tableroNormal1.setBackground(Color.decode("#BA90C6"));
							tableroGrande.setBackground(Color.decode("#BA90C6"));
							tableroGrande1.setBackground(Color.decode("#BA90C6"));
							continuar.setEnabled(true);
							m = 5;
						}
					}
			});
			
			tableroMediano1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == tableroMediano1) {
							
							tableroPequeño.setBackground(Color.decode("#BA90C6"));
							tableroPequeño1.setBackground(Color.decode("#BA90C6"));
							tableroMediano.setBackground(Color.decode("#E8A0BF"));
							tableroMediano1.setBackground(Color.decode("#E8A0BF"));
							tableroNormal.setBackground(Color.decode("#BA90C6"));
							tableroNormal1.setBackground(Color.decode("#BA90C6"));
							tableroGrande.setBackground(Color.decode("#BA90C6"));
							tableroGrande1.setBackground(Color.decode("#BA90C6"));
							continuar.setEnabled(true);
							m = 8;
							
						}
					}
			});
			
			tableroNormal1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == tableroNormal1) {
							
							tableroPequeño.setBackground(Color.decode("#BA90C6"));
							tableroPequeño1.setBackground(Color.decode("#BA90C6"));
							tableroMediano.setBackground(Color.decode("#BA90C6"));
							tableroMediano1.setBackground(Color.decode("#BA90C6"));
							tableroNormal.setBackground(Color.decode("#E8A0BF"));
							tableroNormal1.setBackground(Color.decode("#E8A0BF"));
							tableroGrande.setBackground(Color.decode("#BA90C6"));
							tableroGrande1.setBackground(Color.decode("#BA90C6"));
							continuar.setEnabled(true);
							m = 7;
							
						}
					}
			});
			
			tableroGrande1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == tableroGrande1) {
							
							tableroPequeño.setBackground(Color.decode("#BA90C6"));
							tableroPequeño1.setBackground(Color.decode("#BA90C6"));
							tableroMediano.setBackground(Color.decode("#BA90C6"));
							tableroMediano1.setBackground(Color.decode("#BA90C6"));
							tableroNormal.setBackground(Color.decode("#BA90C6"));
							tableroNormal1.setBackground(Color.decode("#BA90C6"));
							tableroGrande.setBackground(Color.decode("#E8A0BF"));
							tableroGrande1.setBackground(Color.decode("#E8A0BF"));
							continuar.setEnabled(true);
							m = 10;
							
						}
					}
			});
			
			casillasEspeciales.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == casillasEspeciales) {
							
							if(casillasEspeciales.getBackground().equals(Color.decode("#E8A0BF"))) {
								
								casillasEspeciales.setBounds(300, 0, 150, 160);
								casillasEspeciales.setBackground(Color.decode("#BA90C6"));
								casillaEspecialPorc.setEnabled(false);
								casillaEspecialPorc.setVisible(false);
								especialesPorc = 0;
								
							}
							else {
								
								formulario1.add(casillaEspecialPorc);
								casillaEspecialPorc.setEnabled(true);
								casillaEspecialPorc.setVisible(true);
								casillasEspeciales.setBackground(Color.decode("#E8A0BF"));
								casillasEspeciales.setBounds(300, 0, 150, 60);
								
							}
							
						}
					}
			});
			
			transformar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == transformar) {
							
							if(transforma) {
								
								transforma = false;
								transformar.setBackground(Color.decode("#BA90C6"));
								
							}
							else {
								
								transforma = true;
								transformar.setBackground(Color.decode("#E8A0BF"));
								
							}
							
						}
					}
			});
			
			modificar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == modificar) {
							
							if(modificar.getBackground().equals(Color.decode("#E8A0BF"))) {
								
								modificar.setBounds(620, 0, 150, 160);
								modificar.setBackground(Color.decode("#BA90C6"));
								aparicionModificadores.setEnabled(false);
								aparicionModificadores.setVisible(false);
								modifica = 0;
								
							}
							else {
								
								formulario1.add(aparicionModificadores);
								aparicionModificadores.setEnabled(true);
								aparicionModificadores.setVisible(true);
								modificar.setBackground(Color.decode("#E8A0BF"));
								modificar.setBounds(620, 0, 150, 60);
								
							}
							
						}
					}
			});
			
	}
	
	private void elementosFormularioJugadores() {
			
		//panel
		jugador1 = new JPanel();
		jugador1.setSize(screen.width / 2, screen.height / 2);
		jugador1.setBackground(Color.decode("#FDF4F5"));
		jugador1.setLayout(null);
		jugador1.setVisible(true);
		
		jugador1();
		jugador1.add(informacion);
		
		elementosMenu1();
		jugador1.add(menu1);
		
		icono = new JLabel();
		icono.setBounds(180, 230, 180, 180);
		icono.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.decode("#E8A0BF"), 1);
		icono.setBorder(border);
		jugador1.add(icono);		
			
	}
	
	private void jugador1() {
		
		//panel
		informacion = new JPanel();
		informacion.setBounds(550, 130, 300, 400);
		informacion.setBackground(Color.decode("#E8A0BF"));
		informacion.setLayout(null);
		informacion.setVisible(true);
		
		nombre1 = new JTextField("Escribe tu nombre");
		nombre1.setBounds(50, 50, 200, 30);
		informacion.add(nombre1);
		
		colores = new JLabel("Elige tu color: ");
		colores.setFont(new java.awt.Font("Verdana", 1, 15));
		colores.setForeground(Color.decode("#FAFAFA"));;
		colores.setBounds(50, 160, 150, 20);
		informacion.add(colores);
		
		azul = new JButton();
		azul.setBounds(70, 200, 50, 50);
		azul.setBorderPainted(false);
		azul.setBackground(Color.BLUE);
		informacion.add(azul);
		
		verde = new JButton();
		verde.setBounds(120, 200, 50, 50);
		verde.setBorderPainted(false);
		verde.setBackground(Color.GREEN);
		informacion.add(verde);
		
		gris = new JButton();
		gris.setBounds(170, 200, 50, 50);
		gris.setBorderPainted(false);
		gris.setBackground(Color.GRAY);
		informacion.add(gris);
		
		naranja = new JButton();
		naranja.setBounds(70, 250, 50, 50);
		naranja.setBorderPainted(false);
		naranja.setBackground(Color.ORANGE);
		informacion.add(naranja);
		
		amarillo = new JButton();
		amarillo.setBounds(120, 250, 50, 50);
		amarillo.setBorderPainted(false);
		amarillo.setBackground(Color.YELLOW);
		informacion.add(amarillo);
		
		rosa = new JButton();
		rosa.setBounds(170, 250, 50, 50);
		rosa.setBorderPainted(false);
		rosa.setBackground(Color.PINK);
		informacion.add(rosa);
		
	}
	
	private void elementosMenu1() {
		
		menu1 = new JPanel();
		menu1.setBounds(0, 0, (screen.width / 2) + 200, 50);
		menu1.setBackground(Color.decode("#E8A0BF"));
		menu1.setLayout(null);
		menu1.setVisible(true);
		
		inicio1 = new JButton();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/atras.png")); 
		inicio1.setIcon(icon1);
		inicio1.setBounds(10, 0, 50, 50);
		inicio1.setBorderPainted(false);
		inicio1.setContentAreaFilled(false);
		menu1.add(inicio1);
		
		continuar1 = new JButton();
		ImageIcon icon = new ImageIcon(getClass().getResource("/aceptar.png")); 
		continuar1.setIcon(icon);
		continuar1.setBounds((screen.width / 2) + 120, 0, 50, 50);
		continuar1.setBorderPainted(false);
		continuar1.setOpaque(false);
		continuar1.setContentAreaFilled(false);
		menu1.add(continuar1);
		
		logo1 = new JLabel("POOBSTAIRS");
		logo1.setFont(new java.awt.Font("Verdana", 1, 30));
		logo1.setForeground(Color.decode("#EEBED3"));;
		logo1.setBounds(350, 10, 360, 30);
		menu1.add(logo1);
		
	}
	
	private void prepareActionsJugador1() {
		
		azul.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						color1 = "azul";
						ImageIcon icon = new ImageIcon(getClass().getResource("/" +  color1 + ".png"));
						icono.setIcon(icon);
						
				}
		});
		
		verde.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == verde) {
						
						color1 = "verde";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color1 +".png")); 
						icono.setIcon(icon);
						
					}
				}
		});
		
		
		
		gris.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == gris) {
						
						color1 = "gris";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color1 +".png")); 
						icono.setIcon(icon);
						
					}
				}
		});
		
		naranja.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == naranja) {
						
						color1 = "naranja";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color1 +".png")); 
						icono.setIcon(icon);
						
					}
				}
		});
		
		amarillo.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == amarillo) {
						
						color1 = "amarillo";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color1 +".png")); 
						icono.setIcon(icon);
						
					}
				}
		});
		
		rosa.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == rosa) {
						
						color1 = "rosa";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color1 +".png")); 
						icono.setIcon(icon);
						
					}
				}
		});
		

		
		inicio1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					separador.setEnabled(true);
					separador.setVisible(true);
					jugador1.setEnabled(false);
					jugador1.setVisible(false);
					
				}
		});
		
		continuar1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					if(numJug == 2) {
						
						jugador1.setEnabled(false);
						jugador1.setVisible(false);
						add(jugador2);
						jugador2.setEnabled(true);
						jugador2.setVisible(true);
						
					}
					else {
						
						datosListos = true;
						
					}
					
				}
		});
		
	}
	
	private void elementosFormularioJugadores2() {
		
		//panel
		jugador2 = new JPanel();
		jugador2.setSize(screen.width / 2, screen.height / 2);
		jugador2.setBackground(Color.decode("#FDF4F5"));
		jugador2.setLayout(null);
		jugador2.setVisible(true);
		
		jugador2();
		jugador2.add(informacion2);
		
		elementosMenu2();
		jugador2.add(menu2);
		
		icono2 = new JLabel();
		icono2.setBounds(180, 230, 180, 180);
		icono2.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.decode("#E8A0BF"), 1);
		icono2.setBorder(border);
		jugador2.add(icono2);		
			
	}
	
	private void jugador2() {
		
		//panel
		informacion2 = new JPanel();
		informacion2.setBounds(550, 130, 300, 400);
		informacion2.setBackground(Color.decode("#E8A0BF"));
		informacion2.setLayout(null);
		informacion2.setVisible(true);
		
		nombre2 = new JTextField("Escribe tu nombre");
		nombre2.setBounds(50, 50, 200, 30);
		informacion2.add(nombre2);
		
		colores2 = new JLabel("Elige tu color: ");
		colores2.setFont(new java.awt.Font("Verdana", 1, 15));
		colores2.setForeground(Color.decode("#FAFAFA"));;
		colores2.setBounds(50, 160, 150, 20);
		informacion2.add(colores2);
		
		azul2 = new JButton();
		azul2.setBounds(70, 200, 50, 50);
		azul2.setBorderPainted(false);
		azul2.setBackground(Color.BLUE);
		informacion2.add(azul2);
		
		verde2 = new JButton();
		verde2.setBounds(120, 200, 50, 50);
		verde2.setBorderPainted(false);
		verde2.setBackground(Color.GREEN);
		informacion2.add(verde2);
		
		gris2 = new JButton();
		gris2.setBounds(170, 200, 50, 50);
		gris2.setBorderPainted(false);
		gris2.setBackground(Color.GRAY);
		informacion2.add(gris2);
		
		naranja2 = new JButton();
		naranja2.setBounds(70, 250, 50, 50);
		naranja2.setBorderPainted(false);
		naranja2.setBackground(Color.ORANGE);
		informacion2.add(naranja2);
		
		amarillo2 = new JButton();
		amarillo2.setBounds(120, 250, 50, 50);
		amarillo2.setBorderPainted(false);
		amarillo2.setBackground(Color.YELLOW);
		informacion2.add(amarillo2);
		
		rosa2 = new JButton();
		rosa2.setBounds(170, 250, 50, 50);
		rosa2.setBorderPainted(false);
		rosa2.setBackground(Color.PINK);
		informacion2.add(rosa2);
		
	}
	
	private void elementosMenu2() {
		
		menu2 = new JPanel();
		menu2.setBounds(0, 0, (screen.width / 2) + 200, 50);
		menu2.setBackground(Color.decode("#E8A0BF"));
		menu2.setLayout(null);
		menu2.setVisible(true);
		
		inicio2 = new JButton();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/atras.png")); 
		inicio2.setIcon(icon1);
		inicio2.setBounds(10, 0, 50, 50);
		inicio2.setBorderPainted(false);
		inicio2.setContentAreaFilled(false);
		menu2.add(inicio2);
		
		continuar2 = new JButton();
		ImageIcon icon = new ImageIcon(getClass().getResource("/aceptar.png")); 
		continuar2.setIcon(icon);
		continuar2.setBounds((screen.width / 2) + 120, 0, 50, 50);
		continuar2.setBorderPainted(false);
		continuar2.setOpaque(false);
		continuar2.setContentAreaFilled(false);
		menu2.add(continuar2);
		
		logo2 = new JLabel("POOBSTAIRS");
		logo2.setFont(new java.awt.Font("Verdana", 1, 30));
		logo2.setForeground(Color.decode("#EEBED3"));;
		logo2.setBounds(350, 10, 360, 30);
		menu2.add(logo2);
		
	}
	
	private void prepareActionsJugador2() {
		
		azul2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!color1.equals("azul")) {	
						color2 = "azul";
						ImageIcon icon = new ImageIcon(getClass().getResource("/" +  color2 + ".png"));
						icono2.setIcon(icon);
					}
					else {
						
						JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
						
					}
				}
		});
		
		verde2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == verde2) {
						if(!color1.equals("verde")) {
							
							color2 = "verde";
							ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color2 +".png")); 
							icono2.setIcon(icon);
						
						}
						else {
							
							JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
							
						}
					}
				}
		});
		
		
		
		gris2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == gris2) {
						if(!color1.equals("gris")) {
							color2 = "gris";
							ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color2 +".png")); 
							icono2.setIcon(icon);
						}
						else {
							
							JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
							
						}
						
					}
				}
		});
		
		naranja2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == naranja2) {
						if(!color1.equals("naranja")) {
							color2 = "naranja";
							ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color2 +".png")); 
							icono2.setIcon(icon);
						}
						else {
							
							JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
							
						}
						
					}
				}
		});
		
		amarillo2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == amarillo2) {
						if(!color1.equals("amarillo")) {
							color2 = "amarillo";
							ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color2 +".png")); 
							icono2.setIcon(icon);
						}
						else {
							
							JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
							
						}
						
					}
				}
		});
		
		rosa2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == rosa2) {
						if(!color1.equals("rosa")) {
						color2 = "rosa";
						ImageIcon icon = new ImageIcon(getClass().getResource("/"+ color2 +".png")); 
						icono2.setIcon(icon);
						
						}
					}
					else {
						
						JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.COLOR_REPETIDO).getMessage());
						
					}
				}
		});
		
		inicio2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					jugador2.setEnabled(false);
					jugador2.setVisible(false);	
					jugador1.setEnabled(true);
					jugador1.setVisible(true);	
						
				}
		});
		
	}
	
	public int getTamano() {
		return m;
	}
	public int getCasillasEspeciales() {
		return especialesPorc;
	}
	public int getmodificadores() {
		return modifica;
	}
	
	public boolean getTrasformaciones() {
		return transforma;
	}
	public int getporcentajeSerpientesScaleras() {
		return aparicion;
	}
	
	public String getNombreJ1() {
		return nombre1.getText();
	}
	
	public String getColorfichaj1() {
		return color1;
	}

	public String getNombreJ2() {
		
		return nombre2.getText();
	}

	public String getColorfichaj2() {
		
		return color2;
	}
	
}
