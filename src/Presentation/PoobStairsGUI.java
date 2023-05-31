package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

import Domain.PoobStairs;
import Domain.PoobStairsException;

public class PoobStairsGUI extends JFrame{
	
	private Dimension dimension;
	
	private JMenuBar menu1;
	private JMenu opciones;
    private JMenuItem cargar;
    private JMenuItem reiniciar;
    private JMenuItem guardar;
    private JMenuItem guardarS;
    private JMenuItem finalizarP;
	
	//Inicio
	private JPanel inicio;
	private JPanel separadorInicio;
	private JPanel separadorJugadores;
	private JLabel fondo;
	private JLabel logo;
	private JButton newGame;
	private JButton cargarJuego;
	private JButton instrucciones;
	private JButton jugador;
	private JButton jugadores;
	private JButton principiante;
	private JButton aprendiz;
	private int numJugadores;
	private int dificultadMaquina;
	
	//Tablero
	
	private JPanel fondoTablero;
	private JPanel tablero;
	private JPanel jugadoresInfo;
	private JButton finalizar;
	private JButton j1;
	private JButton j2;
	private JLabel nombrej1;
	private JLabel nombrej2;
	private JLabel logo1;
	private JButton dado;
	private JPanel[][] casillas;
	
	//controlador
	private PoobStairs programs;
	
	//info jugadores 

	private JButton ficha1;
	private JButton ficha2;

	private JButton fichaaAprendiz;
	private JButton fichaPrincipiante;
	private int turno =1;
	private String nombreJugador1;
	private String nombreJugador2;

	
	private PoobStairsGUI() {
		
		prepareElements();
		prepareActions();
		programs = new PoobStairs();
		

	}

	private void prepareElements() {

		setTitle("PoobStairs");
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(dimension.width, dimension.height));
		setLocationRelativeTo(null);
		
		menu1 = new JMenuBar();
		
		opciones = new JMenu("Juego");
		menu1.add(opciones);
		
		guardar = new JMenuItem("Cargar Partida");
		opciones.add(guardar);
		
		guardarS = new JMenuItem("Guardar");
		opciones.add(guardarS);
		
		cargar = new JMenuItem("Guardar y Salir");
		opciones.add(cargar);
		
		reiniciar = new JMenuItem("Reiniciar");
		opciones.add(reiniciar);
		
		finalizarP = new JMenuItem("Finalizar");
		opciones.add(finalizarP);
		
		this.setJMenuBar(menu1);
		menu1.setVisible(false);
        menu1.setEnabled(false);
		
		elementosInicio();
		add(inicio);
		
		elementosJuego();
		
	}

	private void prepareActions() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				confirmExit();
			}
		});
		
		accionesBotones();
		prepareActionsJuego();
	}
	
	private void confirmExit() {
		
		int i = JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir?", "Confirma salida", JOptionPane.YES_NO_OPTION);
		if(i == 0) {
			System.exit(0);
		}
		
	}
	
	//panel inicio
	private void elementosInicio() {
		
		//panel
		inicio = new JPanel();
		inicio.setSize(new Dimension(dimension.width,dimension.height));
		inicio.setBackground(Color.decode("#CDF0EA"));
		inicio.setLayout(null);
		inicio.setVisible(true);
		
		//portada
		fondo = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("/fondo.jpg")); 
		Image imagenEscalada = icon.getImage().getScaledInstance(dimension.width,dimension.height, Image.SCALE_SMOOTH);
		ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
		fondo.setIcon(imagenEscaladaIcono);
		fondo.setBounds(0, 0, dimension.width, dimension.height);
		inicio.add(fondo);
		
		newGame = new JButton("NUEVO JUEGO");
		newGame.setBorderPainted(false);
		newGame.setContentAreaFilled(false);
		newGame.setOpaque(false);
		newGame.setForeground(Color.WHITE);
		newGame.setFocusPainted(false);
		newGame.setHorizontalAlignment(SwingConstants.LEFT);
		newGame.setFont(new Font("Verdana", Font.BOLD, 20));
		newGame.setBounds(dimension.width - 370, dimension.height / 2 + 120 , 200, 35);
		fondo.add(newGame);
		
		cargarJuego = new JButton("CONTINUAR");
		cargarJuego.setBorderPainted(false);
		cargarJuego.setContentAreaFilled(false);
		cargarJuego.setOpaque(false);
		cargarJuego.setHorizontalAlignment(SwingConstants.LEFT);
		cargarJuego.setForeground(Color.WHITE);
		cargarJuego.setFont(new Font("Verdana", Font.BOLD, 20));
		cargarJuego.setBounds(dimension.width - 370, dimension.height / 2 + 170 , 200, 35);
		fondo.add(cargarJuego);
		
		instrucciones = new JButton("COMO JUGAR");
		instrucciones.setBorderPainted(false);
		instrucciones.setContentAreaFilled(false);
		instrucciones.setOpaque(false);
		instrucciones.setHorizontalAlignment(SwingConstants.LEFT);
		instrucciones.setForeground(Color.WHITE);
		instrucciones.setFocusPainted(false);
		instrucciones.setFont(new Font("Verdana", Font.BOLD, 20));
		instrucciones.setBounds(dimension.width - 370, dimension.height / 2 + 220 , 200, 35);
		fondo.add(instrucciones);
		
		logo = new JLabel();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/logo2.png")); 
		logo.setIcon(icon1);
		logo.setBounds(dimension.width / 4 , dimension.height / 4 - 140, 800, 400);
		fondo.add(logo);
		
		separadorInicio = new JPanel();
		separadorInicio.setBounds(dimension.width - 370, dimension.height / 2 + 270 , 300, 5);
		separadorInicio.setBackground(Color.decode("#fafafa"));
		separadorInicio.setLayout(null);
		separadorInicio.setVisible(true);
		fondo.add(separadorInicio);
		
		jugador = new JButton("2 jugador");
		jugador.setBorderPainted(false);
		jugador.setContentAreaFilled(false);
		jugador.setOpaque(false);
		jugador.setForeground(Color.WHITE);
		jugador.setFocusPainted(false);
		jugador.setHorizontalAlignment(SwingConstants.RIGHT);
		jugador.setFont(new Font("Verdana", Font.BOLD, 17));
		jugador.setBounds(dimension.width - 600, dimension.height / 2 + 100 , 200, 35);
		jugador.setVisible(false);
		fondo.add(jugador);
		
		jugadores = new JButton("1 jugador");
		jugadores.setBorderPainted(false);
		jugadores.setContentAreaFilled(false);
		jugadores.setOpaque(false);
		jugadores.setForeground(Color.WHITE);
		jugadores.setFocusPainted(false);
		jugadores.setHorizontalAlignment(SwingConstants.RIGHT);
		jugadores.setFont(new Font("Verdana", Font.BOLD, 17));
		jugadores.setBounds(dimension.width - 600, dimension.height / 2 + 140 , 200, 35);
		jugadores.setVisible(false);
		fondo.add(jugadores);
		
		separadorJugadores = new JPanel();
		separadorJugadores.setBounds(dimension.width - 600, dimension.height / 2 + 140 , 200, 3);
		separadorJugadores.setBackground(Color.decode("#fafafa"));
		separadorJugadores.setLayout(null);
		separadorJugadores.setVisible(true);
		separadorJugadores.setVisible(false);
		fondo.add(separadorJugadores);
		
		principiante = new JButton("Principiante");
		principiante.setBackground(Color.WHITE);
		principiante.setForeground(Color.decode("#959bbd"));
		principiante.setFocusPainted(false);
		principiante.setBorderPainted(false);
		principiante.setHorizontalAlignment(SwingConstants.CENTER);
		principiante.setFont(new Font("Verdana", Font.BOLD, 15));
		principiante.setBounds(dimension.width - 600, dimension.height / 2 + 180 , 200, 35);
		principiante.setVisible(false);
		fondo.add(principiante);
		
		aprendiz = new JButton("Aprendiz");
		aprendiz.setBackground(Color.WHITE);
		aprendiz.setForeground(Color.decode("#959bbd"));
		aprendiz.setFocusPainted(false);
		aprendiz.setBorderPainted(false);
		aprendiz.setHorizontalAlignment(SwingConstants.CENTER);
		aprendiz.setFont(new Font("Verdana", Font.BOLD, 15));
		aprendiz.setBounds(dimension.width - 600, dimension.height / 2 + 220 , 200, 35);
		aprendiz.setVisible(false);
		fondo.add(aprendiz);
		
	}
	
	//Acciones inicio
	private void accionesBotones() {
				
		//boton nueva partida
		newGame.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == newGame) {
						
						newGame.setBorderPainted(true);
						newGame.setBorder(BorderFactory.createLineBorder(Color.WHITE));
						newGame.setHorizontalAlignment(SwingConstants.LEFT);
						cargarJuego.setBorderPainted(false);
						instrucciones.setBorderPainted(false);
						jugador.setVisible(true);
						jugadores.setVisible(true);
						separadorJugadores.setVisible(true);
						
					}
				}
		});
		
		cargarJuego.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == cargarJuego) {
						
						cargarJuego.setBorderPainted(true);
						cargarJuego.setBorder(BorderFactory.createLineBorder(Color.WHITE));
						cargarJuego.setHorizontalAlignment(SwingConstants.LEFT);
						instrucciones.setBorderPainted(false);
						newGame.setBorderPainted(false);
						jugador.setVisible(false);
						jugadores.setVisible(false);
						separadorJugadores.setVisible(false);
						principiante.setVisible(false);
						aprendiz.setVisible(false);
						abrirArchivo();
						
					}
				}
		});
		
		instrucciones.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == instrucciones) {
						
						instrucciones.setBorderPainted(true);
						instrucciones.setBorder(BorderFactory.createLineBorder(Color.WHITE));
						instrucciones.setHorizontalAlignment(SwingConstants.LEFT);
						cargarJuego.setBorderPainted(false);
						newGame.setBorderPainted(false);
						jugador.setVisible(false);
						jugadores.setVisible(false);
						separadorJugadores.setVisible(false);
						principiante.setVisible(false);
						aprendiz.setVisible(false);
						
					}
				}
		});
		
		jugador.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == jugador) {
						
						numJugadores = 2;
						principiante.setVisible(false);
						aprendiz.setVisible(false);
						
						Configuraciones newFrame = new Configuraciones(2);
				    	newFrame.setVisible(true);
				    	
				    	newFrame.continuar2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								String nombreJ1 = newFrame.getNombreJ1();
								String colorJ1 = newFrame.getColorfichaj1();
								nombreJugador1=nombreJ1;
								
								String nombreJ2 = newFrame.getNombreJ2();
								String colorJ2 = newFrame.getColorfichaj2();
								nombreJugador2 =nombreJ2;
								if ((nombreJ2 != null && colorJ2 != null )){
									
									inicio.setEnabled(false);
									inicio.setVisible(false);
									add(fondoTablero);
									
									programs.setJugadores(numJugadores);
									programs.setSize(newFrame.getTamano());
									programs.setCasillaEspeciales(newFrame.getCasillasEspeciales());
									programs.setModificadores(newFrame.getmodificadores());
									programs.setTransformaciones(newFrame.getTrasformaciones());
									programs.setPorcentajeEspeciales(newFrame.getporcentajeSerpientesScaleras());
									programs.addTablero(programs.getSize(), programs.getCasillasEspeciales(), programs.getEspecial());
									
									elementosTablero(programs.getSize());
							        fondoTablero.add(tablero);
									
									//informacion jugador 1
									programs.addplayer(nombreJ1, colorJ1);
									newFrame.setVisible(false);
									ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ1+".png")); 
									j1.setIcon(icon1);
									nombrej1.setText(nombreJ1);
									
									//informacion jugador 2
									programs.addplayer(nombreJ2, colorJ2);
									ImageIcon icon2 = new ImageIcon(getClass().getResource("/"+colorJ2+".png")); 
									j2.setIcon(icon2);
									nombrej2.setText(nombreJ2);
									
									menu1.setVisible(true);
							        menu1.setEnabled(true);
							        ficha1(newFrame.getTamano(), colorJ1);
							        ficha2(newFrame.getTamano(), colorJ2);

								} else{
									
									JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
									
								}
								
							}
						});
				    
					}
				}

		});
		
		jugadores.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == jugadores) {
						
						numJugadores = 2;
						principiante.setVisible(true);
						aprendiz.setVisible(true);
				    
					}
				}

			});
		
		principiante.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == principiante) {
		
						dificultadMaquina = 1;
						Configuraciones newFrame = new Configuraciones(1);
				    	newFrame.setVisible(true);
				    	
				    	newFrame.continuar1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								String nombreJ1 = newFrame.getNombreJ1();
								String colorJ1 = newFrame.getColorfichaj1();
								
								if ((nombreJ1 != null && colorJ1 != null)){
									
									inicio.setEnabled(false);
									inicio.setVisible(false);
									add(fondoTablero);
									
									programs.setJugadores(numJugadores);
									programs.setSize(newFrame.getTamano());
									programs.setCasillaEspeciales(newFrame.getCasillasEspeciales());
									programs.setModificadores(newFrame.getmodificadores());
									programs.setTransformaciones(newFrame.getTrasformaciones());
									programs.setPorcentajeEspeciales(newFrame.getporcentajeSerpientesScaleras());
									programs.addTablero(programs.getSize(), programs.getCasillasEspeciales(), programs.getEspecial());
									
									elementosTablero(programs.getSize());
							        fondoTablero.add(tablero);
									
							        programs.addplayer(nombreJ1, colorJ1);
									ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ1+".png")); 
									j1.setIcon(icon1);
									nombrej1.setText(nombreJ1);

									programs.addplayer("maquina", "cafe");
									ImageIcon icon2 = new ImageIcon(getClass().getResource("/principiante.png")); 
									j2.setIcon(icon2);
									nombrej2.setText("Principiante");
									
									newFrame.setVisible(false);
									menu1.setVisible(true);
							        menu1.setEnabled(true);
							        ficha1(newFrame.getTamano(), colorJ1);
							        fichaMaquinaprincipiante(newFrame.getTamano(), "principiante.png");

								} else{
									
									JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
									
								}
							}
							

						});
						
					}
				}
		});
		
		aprendiz.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == aprendiz) {
						
						dificultadMaquina = 2;
						Configuraciones newFrame = new Configuraciones(1);
				    	newFrame.setVisible(true);
				    	
				    	newFrame.continuar1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								String nombreJ1 = newFrame.getNombreJ1();
								String colorJ1 = newFrame.getColorfichaj1();
								
								if ((nombreJ1 != null && colorJ1 != null)){
									
									inicio.setEnabled(false);
									inicio.setVisible(false);
									add(fondoTablero);
									
									programs.setJugadores(numJugadores);
									programs.setSize(newFrame.getTamano());
									programs.setCasillaEspeciales(newFrame.getCasillasEspeciales());
									programs.setModificadores(newFrame.getmodificadores());
									programs.setTransformaciones(newFrame.getTrasformaciones());
									programs.setPorcentajeEspeciales(newFrame.getporcentajeSerpientesScaleras());
									programs.addTablero(programs.getSize(), programs.getCasillasEspeciales(), programs.getEspecial());
									
									programs.addplayer(nombreJ1, colorJ1);
									ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ1+".png")); 
									j1.setIcon(icon1);
									nombrej1.setText(nombreJ1);
									
									programs.addplayer("maquina", "morado");
									ImageIcon icon2 = new ImageIcon(getClass().getResource("/aprendiz.png")); 
									j2.setIcon(icon2);
									nombrej2.setText("Aprendiz");
									
									newFrame.setVisible(false);
									menu1.setVisible(true);
							        menu1.setEnabled(true);
							        
							        elementosTablero(programs.getSize());
							        fondoTablero.add(tablero);
							        ficha1(newFrame.getTamano(), colorJ1);
							        fichaMaquinaAprendiz(newFrame.getTamano(), "aprendiz.png");
							        
								} else{
									
									JOptionPane.showMessageDialog(null, new PoobStairsException(PoobStairsException.DATOS_FALTANTES).getMessage());
									
								}
							}
						});
						
						
					}
				}
		});
		
	}
	
	private void abrirArchivo() {
		
	    JFileChooser fileChooser = new JFileChooser();
	    int seleccion = fileChooser.showOpenDialog(this);
	    if (seleccion == JFileChooser.APPROVE_OPTION) {
	    	
    	   String ruta = fileChooser.getSelectedFile().getAbsolutePath();
	       String nombre = fileChooser.getSelectedFile().getName();
	       JOptionPane.showMessageDialog(this, "Se intento abrir el archivo: \n\n" + nombre + "en la siguiente ruta" +ruta);
		       
	    }
	    
	}
	
	private void elementosJuego() {
		
		fondoTablero = new JPanel();
		fondoTablero.setSize(new Dimension(dimension.width,dimension.height));
		fondoTablero.setBackground(Color.decode("#E5EBB2"));
		fondoTablero.setLayout(null);
		fondoTablero.setVisible(true);
		
		logo1 = new JLabel("POOBSTAIRS");
		logo1.setFont(new java.awt.Font("Verdana", 1, 70));
		logo1.setForeground(Color.decode("#BCE29E"));;
		logo1.setBounds(dimension.width / 2 + 150, 610, 700, 70);
		fondoTablero.add(logo1);
		
		elementosInformacion();
		fondoTablero.add(jugadoresInfo);
		
	}
	
	private void elementosInformacion() {
		
		jugadoresInfo = new JPanel();
		jugadoresInfo.setBounds(dimension.width / 2 + 150, 20, 500, 500);
		jugadoresInfo.setBackground(Color.decode("#FF8787"));
		jugadoresInfo.setLayout(null);
		jugadoresInfo.setVisible(true);
		
		finalizar = new JButton("Finalizar partida");
		finalizar.setBounds(30, 30, 440, 30);
		finalizar.setBackground(Color.decode("#BCE29E"));
		finalizar.setForeground(Color.WHITE);
		finalizar.setHorizontalAlignment(SwingConstants.CENTER);
		finalizar.setFont(new Font("Verdana", Font.BOLD, 15));
		jugadoresInfo.add(finalizar);
		
		j1 = new JButton();
		j1.setBounds(80, 100, 150, 150);
		j1.setBorderPainted(true);
		j1.setBackground(Color.decode("#F8C4B4"));
		jugadoresInfo.add(j1);
		
		nombrej1 = new JLabel("Carolina");
		nombrej1.setFont(new java.awt.Font("Verdana", 1, 15));
		nombrej1.setForeground(Color.WHITE);;
		nombrej1.setHorizontalAlignment(SwingConstants.CENTER);
		nombrej1.setBounds(80, 270, 150, 15);
		jugadoresInfo.add(nombrej1);
		
		j2 = new JButton();
		j2.setBounds(270, 100, 150, 150);
		j2.setBorderPainted(true);
		j2.setBackground(Color.decode("#F8C4B4"));
		jugadoresInfo.add(j2);
		
		nombrej2 = new JLabel("Andrea");
		nombrej2.setFont(new java.awt.Font("Verdana", 1, 15));
		nombrej2.setForeground(Color.WHITE);
		nombrej2.setHorizontalAlignment(SwingConstants.CENTER);
		nombrej2.setBounds(270, 270, 150, 15);
		jugadoresInfo.add(nombrej2);
		
		dado = new JButton();
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado1.png")); 
		dado.setIcon(icon1);
		dado.setBounds(210, 350, 90, 90);
		dado.setBorderPainted(false);
		dado.setContentAreaFilled(false);
		dado.setOpaque(false);
		jugadoresInfo.add(dado);
		
	}
	
private void elementosTablero(int tamaño) {
		
		tablero = new JPanel(new  GridLayout(tamaño, tamaño, 2, 2));
		tablero.setBounds(70, 20, 730, 730);
		tablero.setBackground(Color.decode("#FF8787"));

		casillas = new JPanel[tamaño][tamaño];
		JPanel botoncasilla;

	
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				
				botoncasilla=new JPanel();
				botoncasilla.setBackground(Color.decode("#FDF4F5"));
				casillas[i][j]=botoncasilla;
				tablero.add(botoncasilla);	
				
			}
		}
		
		for (int i = 0; i < casillas.length; i++) {
		    for (int j = 0; j < casillas[i].length; j++) {
		    	
		    	int n=programs.obtenerposcasillas(i, j);
		    	Color color = programs.obtenercolor(i, j);
		    	casillas[i][j].setBackground(color);
		    	JLabel texto = new JLabel(Integer.toString(n), SwingConstants.LEFT);
                casillas[i][j].add(texto);
		    }
		}
		
	}
	


private void randomModificador1() {
	Random random = new Random();
	 int  randomModificador = random.nextInt(2)+1; 
	 int[] posicionesJ1 = new int[2];
	 int[] posicionesJ2 = new int[2];
	 int posicionFila;
	 int posicionColumna;
	 switch (randomModificador) {
	 case 1:
		 JOptionPane.showMessageDialog(null, "Se van a cambiar las posiciones ¡Cuidado!");
		  programs.cambioposicion(turno);
		  posicionesJ1= programs.obtenercasillaXY(1);
	 	   posicionFila=posicionesJ1[0];
	 	   posicionColumna =posicionesJ1[1];
	 	  casillas[posicionFila][posicionColumna].add(ficha1);
		  repaint();
		    
		    posicionesJ2= programs.obtenercasillaXY(2);
		 	posicionFila=posicionesJ2[0];
		 	posicionColumna =posicionesJ2[1];
		 	casillas[posicionFila][posicionColumna].add(ficha2);
			repaint();
			JOptionPane.showMessageDialog(null, "se cambiaron las posiciones");
	 break;
	 
	 case 2:
		   if(turno==1) {
			   int Bonificación = JOptionPane.showConfirmDialog(null, "¿Desea Avanzar una casilla adicional?", "Bonificación para: "+nombreJugador1, JOptionPane.YES_NO_OPTION);
			   if (Bonificación == JOptionPane.YES_OPTION) {
				    programs.bonificacion(turno);
				    posicionesJ1= programs.obtenercasillaXY(1);
				 	   posicionFila=posicionesJ1[0];
				 	   posicionColumna =posicionesJ1[1];
				 	  casillas[posicionFila][posicionColumna].add(ficha1);
					    repaint();
		    		JOptionPane.showMessageDialog(null, "Se avanzo una casilla adicional :D Bien hecho: "+nombreJugador1);

			   }else {}
		   }else {
			   int Bonificación = JOptionPane.showConfirmDialog(null, "¿Desea Avanzar una casilla adicional?", "Bonificación para: "+nombreJugador2, JOptionPane.YES_NO_OPTION);
			   if (Bonificación == JOptionPane.YES_OPTION) {
				    programs.bonificacion(turno);
				    posicionesJ2= programs.obtenercasillaXY(2);
				 	   posicionFila=posicionesJ2[0];
				 	   posicionColumna =posicionesJ2[1];
				 	   casillas[posicionFila][posicionColumna].add(ficha2);
					   repaint();
		    		JOptionPane.showMessageDialog(null, "Se avanzo una casilla adicional :D Bien hecho: "+nombreJugador2);


			   }else {}  
		   }
		 
	 break;
		 
	 }
}

	private void prepareActionsJuego() {
		
		dado.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == dado) {
						
						
						  programs.tirardados();

						int tirada = programs.getValorDado();
						
						if(tirada == 1) {
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado1.png")); 
							dado.setIcon(icon1);
							
						}
						else if(tirada == 2){
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado2.png")); 
							dado.setIcon(icon1);
							
						}
						else if(tirada == 3){
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado3.png")); 
							dado.setIcon(icon1);
							
						}
						else if(tirada == 4){
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado4.png")); 
							dado.setIcon(icon1);
							
						}
						else if(tirada == 5){
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado5.png")); 
							dado.setIcon(icon1);
							
						}
						else if(tirada == 6){
							
							ImageIcon icon1 = new ImageIcon(getClass().getResource("/dado6.png")); 
							dado.setIcon(icon1);
							
						}
						
						if (programs.haymodificadores()) {
							randomModificador1();
						}
						
						programs.jugar();
						
						if (turno==1) {
								//movimientos normales
							
						 	  int[] posiciones= programs.obtenercasillaXY(turno);
						 	  int posicionFila=posiciones[0];
						 	  int posicionColumna =posiciones[1];
						 	  casillas[posicionFila][posicionColumna].add(ficha1);
							    repaint();
							  //movimientos casillasEspeciales
								programs.casillasEspeciales1(1);
						
								int[] casillasespeciales= programs.obtenercasillaXY(turno);
							 	int posicionFilas=casillasespeciales[0];
							 	int posicionColumnas =casillasespeciales[1];
							 	casillas[posicionFilas][posicionColumnas].add(ficha1);
								repaint();
								turno=turno+1;
								
							if (programs.hayGanador(1)) {
				 				JOptionPane.showMessageDialog(null, "!Felicidades Ganaste "+ nombreJugador1+"!");
								System.exit(0);
							}
							
						}else {
							  int[] posiciones= programs.obtenercasillaXY(turno);
							  int posicionFila=posiciones[0];
						 	  int posicionColumna =posiciones[1];
						 	  casillas[posicionFila][posicionColumna].add(ficha2);
							  repaint();
					
						 	 programs.casillasEspeciales1(2);
						
							  int[] casillasespeciales= programs.obtenercasillaXY(turno);
						 	  int posicionFilas=casillasespeciales[0];
						 	  int posicionColumnas =casillasespeciales[1];
						 	  casillas[posicionFilas][posicionColumnas].add(ficha2);
							  repaint();
							  turno=1;
							if (programs.hayGanador(2)) {
						
							    JOptionPane.showMessageDialog(null, "!Felicidades Ganaste "+ nombreJugador2+"!");
								System.exit(0);

							}
						}
						
						
						
					}
				}
		});
		
	}
	public void ficha1(int tamañotablero,String colorJ1) {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ1+".png")); 

	    Image imagenEscalada = icon1.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Escala la imagen al tamaño deseado
	    ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada); // Crea un objeto ImageIcon con la imagen escalada
	     ficha1 = new JButton(imagenEscaladaIcono);
	     ficha1.setContentAreaFilled(false);
	     ficha1.setOpaque(false);
	    ficha1.setBorderPainted(false);
		casillas[tamañotablero-1][0].add(ficha1);
		    
	}
	
	public void ficha2(int tamañotablero,String colorJ2) {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ2+".png")); 

	    Image imagenEscalada = icon1.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Escala la imagen al tamaño deseado
	    ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada); // Crea un objeto ImageIcon con la imagen escalada
	     ficha2 = new JButton(imagenEscaladaIcono);
	     ficha2.setContentAreaFilled(false);
	     ficha2.setOpaque(false);
	    ficha2.setBorderPainted(false);
		casillas[tamañotablero-1][0].add(ficha2);   
	}
	
	public void fichaMaquinaAprendiz(int tamañotablero,String colorJ2) {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ2)); 

	    Image imagenEscalada = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Escala la imagen al tamaño deseado
	    ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada); // Crea un objeto ImageIcon con la imagen escalada
	    ficha2 = new JButton(imagenEscaladaIcono);
	    ficha2.setContentAreaFilled(false);
	    ficha2.setOpaque(false);
	    ficha2.setBorderPainted(false);
		casillas[tamañotablero-1][0].add(ficha2);   
	}
	
	public void fichaMaquinaprincipiante(int tamañotablero,String colorJ2) {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/"+colorJ2)); 

	    Image imagenEscalada = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Escala la imagen al tamaño deseado
	    ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada); // Crea un objeto ImageIcon con la imagen escalada
	    ficha2 = new JButton(imagenEscaladaIcono);
	    ficha2.setContentAreaFilled(false);
	    ficha2.setOpaque(false);
	    ficha2.setBorderPainted(false);
		casillas[tamañotablero-1][0].add(ficha2);   
	}
	
	
	public static void main(String[] args) {
		PoobStairsGUI gui = new PoobStairsGUI();
		gui.setVisible(true);
	}
}
