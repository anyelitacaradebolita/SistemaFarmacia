/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
 *
 * @author Anyel
 */
public class MainFrame extends JFrame {
    private final PanelRegistro panelRegistro;
    private final PanelLista panelLista;

    private final JTabbedPane tabbedPane;
    private final FondoAnimado fondoAnimado;

    private static final int INDICE_REGISTRO = 0;
    private static final int INDICE_LISTA = 1;

    public MainFrame() {

        panelRegistro = new PanelRegistro();
        panelLista = new PanelLista();

        tabbedPane = new JTabbedPane();
        fondoAnimado = new FondoAnimado();

        configurarVentana();
        integrarPaneles();
        construirInterfaz();

        setJMenuBar(
                construirMenu()
        );

        panelLista.cargarDatos();
    }


    private void configurarVentana() {

        setTitle(
                "Sistema de Inventario de Farmacia"
        );

        setSize(
                1200,
                780
        );

        setMinimumSize(
                new Dimension(
                        1000,
                        680
                )
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DO_NOTHING_ON_CLOSE
        );

        fondoAnimado.setLayout(
                new BorderLayout()
        );

        setContentPane(
                fondoAnimado
        );

        addWindowListener(
                new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(
                    java.awt.event.WindowEvent evento
            ) {

                salir();
            }
        });
    }


    private void construirInterfaz() {

        JPanel contenedorPrincipal
                = new JPanel(
                        new BorderLayout(
                                0,
                                20
                        )
                );

        contenedorPrincipal.setOpaque(false);

        contenedorPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        22,
                        28,
                        28,
                        28
                )
        );

        contenedorPrincipal.add(
                construirEncabezado(),
                BorderLayout.NORTH
        );

        contenedorPrincipal.add(
                construirContenidoCentral(),
                BorderLayout.CENTER
        );

        fondoAnimado.add(
                contenedorPrincipal,
                BorderLayout.CENTER
        );
    }


    private JPanel construirEncabezado() {

        PanelVidrio encabezado
                = new PanelVidrio(
                        TemaFarmacia.RADIO_GRANDE
                );

        encabezado.setLayout(
                new BorderLayout(
                        25,
                        0
                )
        );

        encabezado.setBorder(
                BorderFactory.createEmptyBorder(
                        22,
                        28,
                        22,
                        28
                )
        );

        encabezado.setColorFondo(
                TemaFarmacia.BLANCO
        );

        encabezado.setColorBorde(
                TemaFarmacia.BORDE_SUAVE
        );

        encabezado.setColorBrillo(
                new Color(
                        255,
                        255,
                        255,
                        70
                )
        );

        encabezado.setOpacidad(
                1.0f
        );

        encabezado.setMostrarSombra(
                true
        );

        encabezado.setMostrarBrillo(
                true
        );

        encabezado.add(
                construirInformacionSistema(),
                BorderLayout.WEST
        );

        encabezado.add(
                construirBarraAcciones(),
                BorderLayout.CENTER
        );

        encabezado.add(
                construirInformacionUsuario(),
                BorderLayout.EAST
        );

        return encabezado;
    }


    private JPanel construirInformacionSistema() {

        JPanel panelPrincipal
                = new JPanel(
                        new BorderLayout(
                                16,
                                0
                        )
                );

        panelPrincipal.setOpaque(false);

        panelPrincipal.add(
                construirLogo(),
                BorderLayout.WEST
        );

        JPanel panelTextos
                = new JPanel();

        panelTextos.setOpaque(false);

        panelTextos.setLayout(
                new BoxLayout(
                        panelTextos,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel lblSeccion
                = new JLabel(
                        "CONTROL DE INVENTARIO"
                );

        lblSeccion.setFont(
                TemaFarmacia.FUENTE_ETIQUETA
                        .deriveFont(11.5f)
        );

        lblSeccion.setForeground(
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        lblSeccion.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel lblTitulo
                = new JLabel(
                        "Sistema Farmacia"
                );

        lblTitulo.setFont(
                TemaFarmacia.FUENTE_LOGO
        );

        lblTitulo.setForeground(
                TemaFarmacia.AZUL_TITULO
        );

        lblTitulo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel lblSubtitulo
                = new JLabel(
                        "Gestión segura y organizada "
                        + "de medicamentos"
                );

        lblSubtitulo.setFont(
                TemaFarmacia.FUENTE_SUBTITULO
                        .deriveFont(13.5f)
        );

        lblSubtitulo.setForeground(
                TemaFarmacia.TEXTO_SECUNDARIO
        );

        lblSubtitulo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        panelTextos.add(
                lblSeccion
        );

        panelTextos.add(
                Box.createVerticalStrut(4)
        );

        panelTextos.add(
                lblTitulo
        );

        panelTextos.add(
                Box.createVerticalStrut(5)
        );

        panelTextos.add(
                lblSubtitulo
        );

        panelPrincipal.add(
                panelTextos,
                BorderLayout.CENTER
        );

        return panelPrincipal;
    }


    private JPanel construirLogo() {

        JPanel fondoLogo
                = new JPanel(
                        new GridBagLayout()
                );

        fondoLogo.setOpaque(true);

        fondoLogo.setBackground(
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        fondoLogo.setPreferredSize(
                new Dimension(
                        100,
                        100
                )
        );

        fondoLogo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                TemaFarmacia.BORDE_TURQUESA,
                                1,
                                true
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                8,
                                8,
                                8
                        )
                )
        );

        ImageIcon logo = new ImageIcon(
                getClass().getResource(
                        "/recursos/Seguro_caja.jpeg"
                )
        );

        Image imagen = logo.getImage().getScaledInstance(
                150,
                150,
                Image.SCALE_SMOOTH
        );

        JLabel lblLogo = new JLabel(
                new ImageIcon(imagen)
        );

        lblLogo.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        fondoLogo.add(
                lblLogo
        );
        
        return fondoLogo;
    }


    private JPanel construirBarraAcciones() {

        JPanel barraAcciones
                = new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                9,
                                11
                        )
                );

        barraAcciones.setOpaque(false);

        BotonBrillante btnNuevo
                = new BotonBrillante(
                        "Nuevo"
                );

        BotonBrillante btnGuardar
                = new BotonBrillante(
                        "Guardar"
                );

        BotonBrillante btnBuscar
                = new BotonBrillante(
                        "Buscar"
                );

        BotonBrillante btnActualizar
                = new BotonBrillante(
                        "Actualizar"
                );

        BotonBrillante btnEliminar
                = new BotonBrillante(
                        "Eliminar"
                );

        configurarBotonSecundario(
                btnNuevo
        );

        configurarBotonPrincipal(
                btnGuardar
        );

        configurarBotonSecundario(
                btnBuscar
        );

        configurarBotonActualizar(
                btnActualizar
        );

        configurarBotonEliminar(
                btnEliminar
        );

        configurarTamanoBoton(
                btnNuevo
        );

        configurarTamanoBoton(
                btnGuardar
        );

        configurarTamanoBoton(
                btnBuscar
        );

        configurarTamanoBoton(
                btnActualizar
        );

        configurarTamanoBoton(
                btnEliminar
        );

        btnNuevo.setToolTipText(
                "Limpia el formulario para registrar un medicamento"
        );

        btnGuardar.setToolTipText(
                "Guarda el medicamento escrito en el formulario"
        );

        btnBuscar.setToolTipText(
                "Abre la lista y enfoca el campo de búsqueda"
        );

        btnActualizar.setToolTipText(
                "Edita o actualiza el medicamento seleccionado"
        );

        btnEliminar.setToolTipText(
                "Abre la lista para seleccionar un medicamento"
        );

        btnNuevo.addActionListener(
                evento -> {

            panelRegistro.limpiarCampos();

            tabbedPane.setSelectedIndex(
                    INDICE_REGISTRO
            );
        });


        btnGuardar.addActionListener(
                evento -> {

            tabbedPane.setSelectedIndex(
                    INDICE_REGISTRO
            );

            panelRegistro.guardar();
        });

        /*
         * Botón Buscar.
         */
        btnBuscar.addActionListener(
                evento -> {

            panelLista.cargarDatos();

            tabbedPane.setSelectedIndex(
                    INDICE_LISTA
            );

            panelLista.enfocarBusqueda();
        });


        btnActualizar.addActionListener(
                evento -> {

            if (tabbedPane.getSelectedIndex()
                    == INDICE_LISTA) {

                panelLista.cargarSeleccionParaEditar();

            } else {

                panelRegistro.actualizar();
            }
        });

        btnEliminar.addActionListener(
                evento -> {

            panelLista.cargarDatos();

            tabbedPane.setSelectedIndex(
                    INDICE_LISTA
            );
        });

        barraAcciones.add(
                btnNuevo
        );

        barraAcciones.add(
                btnGuardar
        );

        barraAcciones.add(
                btnBuscar
        );

        barraAcciones.add(
                btnActualizar
        );

        barraAcciones.add(
                btnEliminar
        );

        return barraAcciones;
    }



    private void configurarBotonPrincipal(
            BotonBrillante boton
    ) {

        boton.setColorBase(
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        boton.setColorHover(
                TemaFarmacia.TURQUESA_OSCURO
        );

        boton.setColorPresionado(
                new Color(
                        17,
                        108,
                        123
                )
        );

        boton.setColorTexto(
                TemaFarmacia.BLANCO
        );

        boton.setColorBorde(
                TemaFarmacia.TURQUESA_PRINCIPAL
        );
    }

    private void configurarBotonSecundario(
            BotonBrillante boton
    ) {

        boton.setColorBase(
                TemaFarmacia.BLANCO
        );

        boton.setColorHover(
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        boton.setColorPresionado(
                TemaFarmacia.TURQUESA_CLARO
        );

        boton.setColorTexto(
                TemaFarmacia.TURQUESA_OSCURO
        );

        boton.setColorBorde(
                TemaFarmacia.BORDE_TURQUESA
        );
    }

    private void configurarBotonActualizar(
            BotonBrillante boton
    ) {

        boton.setColorBase(
                TemaFarmacia.INFORMACION
        );

        boton.setColorHover(
                new Color(
                        40,
                        112,
                        161
                )
        );

        boton.setColorPresionado(
                new Color(
                        32,
                        91,
                        132
                )
        );

        boton.setColorTexto(
                TemaFarmacia.BLANCO
        );

        boton.setColorBorde(
                TemaFarmacia.INFORMACION
        );
    }


    private void configurarBotonEliminar(
            BotonBrillante boton
    ) {

        boton.setColorBase(
                TemaFarmacia.ERROR
        );

        boton.setColorHover(
                new Color(
                        195,
                        58,
                        72
                )
        );

        boton.setColorPresionado(
                new Color(
                        166,
                        45,
                        58
                )
        );

        boton.setColorTexto(
                TemaFarmacia.BLANCO
        );

        boton.setColorBorde(
                TemaFarmacia.ERROR
        );
    }

    private void configurarTamanoBoton(
            JButton boton
    ) {

        Dimension dimension
                = new Dimension(
                        112,
                        TemaFarmacia.ALTURA_BOTON
                );

        boton.setPreferredSize(
                dimension
        );

        boton.setMinimumSize(
                dimension
        );
    }


    private JPanel construirInformacionUsuario() {

        JPanel panelUsuario
                = new JPanel();

        panelUsuario.setOpaque(false);

        panelUsuario.setLayout(
                new BoxLayout(
                        panelUsuario,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel lblUsuario
                = new JLabel(
                        "Administrador"
                );

        lblUsuario.setFont(
                TemaFarmacia.FUENTE_ETIQUETA
        );

        lblUsuario.setForeground(
                TemaFarmacia.AZUL_TITULO
        );

        lblUsuario.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        JLabel lblRol
                = new JLabel(
                        "Usuario del sistema"
                );

        lblRol.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(12f)
        );

        lblRol.setForeground(
                TemaFarmacia.TEXTO_SECUNDARIO
        );

        lblRol.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        JLabel lblFecha
                = new JLabel(
                        obtenerFechaActual()
                );

        lblFecha.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(11.5f)
        );

        lblFecha.setForeground(
                TemaFarmacia.TEXTO_SUAVE
        );

        lblFecha.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        panelUsuario.add(
                lblUsuario
        );

        panelUsuario.add(
                Box.createVerticalStrut(4)
        );

        panelUsuario.add(
                lblRol
        );

        panelUsuario.add(
                Box.createVerticalStrut(7)
        );

        panelUsuario.add(
                lblFecha
        );

        return panelUsuario;
    }


    private String obtenerFechaActual() {

        Locale localeEspanol
                = new Locale(
                        "es",
                        "CR"
                );

        DateTimeFormatter formato
                = DateTimeFormatter.ofPattern(
                        "dd 'de' MMMM 'de' yyyy",
                        localeEspanol
                );

        return LocalDate.now().format(
                formato
        );
    }



    private JPanel construirContenidoCentral() {

        PanelVidrio tarjetaContenido
                = new PanelVidrio(
                        TemaFarmacia.RADIO_GRANDE
                );

        tarjetaContenido.setLayout(
                new BorderLayout()
        );

        tarjetaContenido.setBorder(
                BorderFactory.createEmptyBorder(
                        14,
                        16,
                        18,
                        16
                )
        );

        tarjetaContenido.setColorFondo(
                TemaFarmacia.BLANCO
        );

        tarjetaContenido.setColorBorde(
                TemaFarmacia.BORDE_SUAVE
        );

        tarjetaContenido.setColorBrillo(
                new Color(
                        255,
                        255,
                        255,
                        65
                )
        );

        tarjetaContenido.setOpacidad(
                1.0f
        );

        tarjetaContenido.setMostrarSombra(
                true
        );

        tarjetaContenido.setMostrarBrillo(
                false
        );

        tarjetaContenido.add(
                tabbedPane,
                BorderLayout.CENTER
        );

        return tarjetaContenido;
    }

    private void integrarPaneles() {

        panelRegistro.setPanelLista(
                panelLista
        );

        panelLista.setPanelRegistro(
                panelRegistro
        );

        panelLista.setIrARegistro(
                () -> {

            tabbedPane.setSelectedIndex(
                    INDICE_REGISTRO
            );
        });

        panelRegistro.setOpaque(false);
        panelLista.setOpaque(false);

        configurarPestanas();

        tabbedPane.addTab(
                "Registrar medicamento",
                panelRegistro
        );

        tabbedPane.addTab(
                "Inventario de medicamentos",
                panelLista
        );
    }

    private void configurarPestanas() {

        tabbedPane.setOpaque(false);

        tabbedPane.setBackground(
                TemaFarmacia.FONDO_SECCION
        );

        tabbedPane.setForeground(
                TemaFarmacia.TEXTO_SECUNDARIO
        );

        tabbedPane.setFont(
                TemaFarmacia.FUENTE_BOTON
        );

        tabbedPane.setTabPlacement(
                SwingConstants.TOP
        );

        tabbedPane.setBorder(
                BorderFactory.createEmptyBorder(
                        2,
                        2,
                        2,
                        2
                )
        );

        tabbedPane.putClientProperty(
                "JTabbedPane.tabType",
                "card"
        );

        tabbedPane.putClientProperty(
                "JTabbedPane.showTabSeparators",
                false
        );

        tabbedPane.putClientProperty(
                "JTabbedPane.tabAreaAlignment",
                "leading"
        );
    }



    private JMenuBar construirMenu() {

        JMenuBar menuBar
                = new JMenuBar();

        menuBar.setBackground(
                TemaFarmacia.BLANCO
        );

        menuBar.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        TemaFarmacia.BORDE_SUAVE
                )
        );

        JMenu menuArchivo
                = new JMenu(
                        "Archivo"
                );

        menuArchivo.setMnemonic(
                KeyEvent.VK_A
        );

        JMenuItem itemSalir
                = new JMenuItem(
                        "Salir"
                );

        itemSalir.addActionListener(
                evento -> salir()
        );

        menuArchivo.add(
                itemSalir
        );

        JMenu menuHerramientas
                = new JMenu(
                        "Herramientas"
                );

        menuHerramientas.setMnemonic(
                KeyEvent.VK_H
        );

        JMenuItem itemListar
                = new JMenuItem(
                        "Listar medicamentos"
                );

        itemListar.addActionListener(
                evento -> {

            panelLista.cargarDatos();

            tabbedPane.setSelectedIndex(
                    INDICE_LISTA
            );
        });

        JMenuItem itemLimpiar
                = new JMenuItem(
                        "Limpiar formulario"
                );

        itemLimpiar.addActionListener(
                evento -> {

            panelRegistro.limpiarCampos();

            tabbedPane.setSelectedIndex(
                    INDICE_REGISTRO
            );
        });

        JMenuItem itemNuevo
                = new JMenuItem(
                        "Nuevo medicamento"
                );

        itemNuevo.addActionListener(
                evento -> {

            panelRegistro.limpiarCampos();

            tabbedPane.setSelectedIndex(
                    INDICE_REGISTRO
            );
        });

        menuHerramientas.add(
                itemNuevo
        );

        menuHerramientas.addSeparator();

        menuHerramientas.add(
                itemListar
        );

        menuHerramientas.add(
                itemLimpiar
        );

        JMenu menuAyuda
                = new JMenu(
                        "Ayuda"
                );

        menuAyuda.setMnemonic(
                KeyEvent.VK_Y
        );

        JMenuItem itemAcercaDe
                = new JMenuItem(
                        "Acerca del sistema"
                );

        itemAcercaDe.addActionListener(
                evento -> mostrarInformacionSistema()
        );

        menuAyuda.add(
                itemAcercaDe
        );

        menuBar.add(
                menuArchivo
        );

        menuBar.add(
                menuHerramientas
        );

        menuBar.add(
                menuAyuda
        );

        return menuBar;
    }


    private void mostrarInformacionSistema() {

        JOptionPane.showMessageDialog(
                this,
                "Sistema de Inventario de Farmacia\n\n"
                + "Permite registrar, consultar, actualizar "
                + "y eliminar medicamentos.\n\n"
                + "Proyecto académico de Programación IV.",
                "Acerca del sistema",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void salir() {

        int confirmacion
                = JOptionPane.showConfirmDialog(
                        this,
                        "¿Está seguro de que desea salir del sistema?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

        if (confirmacion
                == JOptionPane.YES_OPTION) {

            fondoAnimado.detenerAnimacion();

            dispose();

            System.exit(0);
        }
    }
}