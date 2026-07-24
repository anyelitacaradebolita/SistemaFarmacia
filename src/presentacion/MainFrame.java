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

    private final PanelRegistro panelRegistro = new PanelRegistro();
    private final PanelLista panelLista = new PanelLista();
    private final JTabbedPane tabbedPane = new JTabbedPane();

    private static final int INDICE_REGISTRO = 0;
    private static final int INDICE_LISTA = 1;

    public MainFrame() {
        configurarVentana();
        integrarPaneles();
        setJMenuBar(construirMenu());
        add(construirToolBar(), BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

        // Carga inicial de datos al abrir el sistema
        panelLista.cargarDatos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Inventario de Farmacia - UISIL Programación IV");
        setSize(900, 600);
        setLocationRelativeTo(null); // centrar en pantalla
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                salir();
            }
        });
    }

    /**
     * Conecta ambos paneles entre sí (para refrescar la lista tras guardar,
     * y para cargar un registro seleccionado al editar) y arma el
     * JTabbedPane con las dos pestañas requeridas.
     */
    private void integrarPaneles() {
        panelRegistro.setPanelLista(panelLista);
        panelLista.setPanelRegistro(panelRegistro);
        panelLista.setIrARegistro(() -> tabbedPane.setSelectedIndex(INDICE_REGISTRO));

        tabbedPane.addTab("Registro", panelRegistro);
        tabbedPane.addTab("Lista", panelLista);
    }

    private JMenuBar construirMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic(KeyEvent.VK_A);
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> salir());
        menuArchivo.add(itemSalir);

        // Menú Herramientas
        JMenu menuHerramientas = new JMenu("Herramientas");
        menuHerramientas.setMnemonic(KeyEvent.VK_H);

        JMenuItem itemListar = new JMenuItem("Listar");
        itemListar.addActionListener(e -> {
            panelLista.cargarDatos();
            tabbedPane.setSelectedIndex(INDICE_LISTA);
        });

        JMenuItem itemLimpiar = new JMenuItem("Limpiar");
        itemLimpiar.addActionListener(e -> {
            panelRegistro.limpiarCampos();
            tabbedPane.setSelectedIndex(INDICE_REGISTRO);
        });

        menuHerramientas.add(itemListar);
        menuHerramientas.add(itemLimpiar);

        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);
        return menuBar;
    }

    private JToolBar construirToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton btnNuevo = new JButton("Nuevo");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");

        btnNuevo.addActionListener(e -> {
            panelRegistro.limpiarCampos();
            tabbedPane.setSelectedIndex(INDICE_REGISTRO);
        });

        btnGuardar.addActionListener(e -> {
            tabbedPane.setSelectedIndex(INDICE_REGISTRO);
            panelRegistro.guardar();
        });

        btnBuscar.addActionListener(e -> {
            tabbedPane.setSelectedIndex(INDICE_LISTA);
            panelLista.enfocarBusqueda();
        });

        btnActualizar.addActionListener(e -> {
            // Si estamos en Lista, carga el seleccionado en el formulario.
            // Si ya estamos en Registro editando, ejecuta la actualización.
            if (tabbedPane.getSelectedIndex() == INDICE_LISTA) {
                panelLista.cargarSeleccionParaEditar();
            } else {
                panelRegistro.actualizar();
            }
        });

        btnEliminar.addActionListener(e -> tabbedPane.setSelectedIndex(INDICE_LISTA));

        toolBar.add(btnNuevo);
        toolBar.add(btnGuardar);
        toolBar.add(btnBuscar);
        toolBar.add(btnActualizar);
        toolBar.add(btnEliminar);

        return toolBar;
    }

    private void salir() {
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir del sistema?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmacion == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }
}

