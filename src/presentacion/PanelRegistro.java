/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentacion;

/**
 *
 * @author angul
 */
import modelo.Medicamento;
import negocio.MedicamentoNegocio;
import negocio.ValidacionException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;

import java.util.HashMap;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.Image;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author angul
 */
public class PanelRegistro extends JPanel {

    private final JTextField txtCodigo
            = new JTextField();

    private final JTextField txtNombre
            = new JTextField();

    private final JTextField txtCantidad
            = new JTextField();

    private final JTextField txtPrecio
            = new JTextField();

    private final JTextField txtVencimiento
            = new JTextField();

    private final Map<JComponent, JLabel> etiquetasMensajes
            = new HashMap<>();

    private final Map<JComponent, String> mensajesOriginales
            = new HashMap<>();

    private final Color COLOR_AYUDA
            = new Color(65, 84, 97);

    private final Color COLOR_ERROR
            = new Color(211, 47, 47);

    private final JComboBox<String> comboCategoria
            = new JComboBox<>(
                    new String[]{
                        "Analgésico",
                        "Antibiótico",
                        "Antihistamínico",
                        "Antipirético",
                        "Otro"
                    }
            );

    private final BotonBrillante btnLimpiar
            = new BotonBrillante(
                    "Limpiar formulario"
            );

    private final MedicamentoNegocio negocio
            = new MedicamentoNegocio();

    private PanelLista panelLista;

    private Border bordeCodigoOriginal;
    private Border bordeNombreOriginal;
    private Border bordeCantidadOriginal;
    private Border bordePrecioOriginal;
    private Border bordeVencimientoOriginal;
    private Border bordeCategoriaOriginal;

    public PanelRegistro() {

        configurarPanelPrincipal();
        configurarComponentes();
        construirInterfaz();

        guardarBordesOriginales();

        configurarEventos();
    }

    public void setPanelLista(
            PanelLista panelLista
    ) {

        this.panelLista = panelLista;
    }

    private void configurarPanelPrincipal() {

        setOpaque(false);

        setLayout(
                new BorderLayout()
        );
    }

    private void configurarComponentes() {

        configurarCampoTexto(
                txtCodigo,
                "Escriba el código. Ejemplo: 1001"
        );

        configurarCampoTexto(
                txtNombre,
                "Escriba el nombre del medicamento"
        );

        configurarCampoTexto(
                txtCantidad,
                "Escriba la cantidad disponible"
        );

        configurarCampoTexto(
                txtPrecio,
                "Escriba el precio. Ejemplo: 2500.00"
        );

        configurarCampoTexto(
                txtVencimiento,
                "Escriba la fecha. Formato: yyyy-MM-dd"
        );

        configurarComboCategoria();
        configurarBotonLimpiar();
    }

    private void configurarCampoTexto(
            JTextField campo,
            String placeholder
    ) {

        campo.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(15f)
        );

        campo.setForeground(
                new Color(
                        18,
                        39,
                        55
                )
        );

        campo.setBackground(
                Color.WHITE
        );

        campo.setCaretColor(
                TemaFarmacia.AZUL_TITULO
        );

        campo.setSelectionColor(
                TemaFarmacia.TURQUESA_CLARO
        );

        campo.setSelectedTextColor(
                TemaFarmacia.AZUL_TITULO
        );

        campo.setOpaque(true);

        campo.setPreferredSize(
                new Dimension(
                        400,
                        48
                )
        );

        campo.setMinimumSize(
                new Dimension(
                        250,
                        48
                )
        );

        campo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        48
                )
        );

        campo.putClientProperty(
                "JTextField.placeholderText",
                placeholder
        );

        campo.putClientProperty(
                "JTextField.placeholderForeground",
                new Color(
                        80,
                        98,
                        110
                )
        );

        campo.putClientProperty(
                "JComponent.roundRect",
                true
        );

        campo.putClientProperty(
                "JComponent.arc",
                18
        );

        campo.putClientProperty(
                "JComponent.focusWidth",
                2
        );

        campo.putClientProperty(
                "JComponent.focusColor",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );
    }

    private void configurarComboCategoria() {

        comboCategoria.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(15f)
        );

        comboCategoria.setForeground(
                new Color(
                        18,
                        39,
                        55
                )
        );

        comboCategoria.setBackground(
                Color.WHITE
        );

        comboCategoria.setOpaque(true);

        comboCategoria.setPreferredSize(
                new Dimension(
                        400,
                        48
                )
        );

        comboCategoria.setMinimumSize(
                new Dimension(
                        250,
                        48
                )
        );

        comboCategoria.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        48
                )
        );

        comboCategoria.putClientProperty(
                "JComponent.roundRect",
                true
        );

        comboCategoria.putClientProperty(
                "JComponent.arc",
                18
        );

        comboCategoria.putClientProperty(
                "JComponent.focusWidth",
                2
        );
    }

    private void configurarBotonLimpiar() {

        Dimension dimension
                = new Dimension(
                        220,
                        48
                );

        btnLimpiar.setPreferredSize(
                dimension
        );

        btnLimpiar.setMinimumSize(
                dimension
        );

        btnLimpiar.setColorBase(
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        btnLimpiar.setColorHover(
                TemaFarmacia.TURQUESA_CLARO
        );

        btnLimpiar.setColorPresionado(
                TemaFarmacia.BORDE_TURQUESA
        );

        btnLimpiar.setColorTexto(
                TemaFarmacia.TURQUESA_OSCURO
        );

        btnLimpiar.setColorBorde(
                TemaFarmacia.BORDE_TURQUESA
        );
    }

    private void construirInterfaz() {

        JPanel panelDesplazable
                = new JPanel(
                        new GridBagLayout()
                );

        panelDesplazable.setOpaque(false);

        panelDesplazable.setBorder(
                BorderFactory.createEmptyBorder(
                        28,
                        28,
                        35,
                        28
                )
        );

        PanelVidrio tarjetaFormulario
                = construirTarjetaFormulario();

        GridBagConstraints gbc
                = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.anchor
                = GridBagConstraints.NORTH;

        gbc.fill
                = GridBagConstraints.HORIZONTAL;

        gbc.insets
                = new Insets(
                        0,
                        0,
                        20,
                        0
                );

        panelDesplazable.add(
                tarjetaFormulario,
                gbc
        );

        JScrollPane scrollFormulario
                = new JScrollPane(
                        panelDesplazable
                );

        scrollFormulario.setOpaque(false);

        scrollFormulario.getViewport()
                .setOpaque(false);

        scrollFormulario.setBorder(
                BorderFactory.createEmptyBorder()
        );

        scrollFormulario.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollFormulario.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollFormulario.getVerticalScrollBar()
                .setUnitIncrement(18);

        scrollFormulario.getVerticalScrollBar()
                .setBlockIncrement(80);

        add(
                scrollFormulario,
                BorderLayout.CENTER
        );
    }

    private PanelVidrio construirTarjetaFormulario() {

        PanelVidrio tarjetaFormulario
                = new PanelVidrio(
                        TemaFarmacia.RADIO_GRANDE
                );

        tarjetaFormulario.setLayout(
                new BorderLayout(
                        0,
                        28
                )
        );

        tarjetaFormulario.setPreferredSize(
                new Dimension(
                        1050,
                        670
                )
        );

        tarjetaFormulario.setMinimumSize(
                new Dimension(
                        750,
                        670
                )
        );

        tarjetaFormulario.setColorFondo(
                TemaFarmacia.BLANCO
        );

        tarjetaFormulario.setColorBorde(
                TemaFarmacia.BORDE_SUAVE
        );

        tarjetaFormulario.setColorBrillo(
                new Color(
                        255,
                        255,
                        255,
                        70
                )
        );

        tarjetaFormulario.setOpacidad(
                1.0f
        );

        tarjetaFormulario.setMostrarSombra(
                true
        );

        tarjetaFormulario.setMostrarBrillo(
                true
        );

        tarjetaFormulario.setBorder(
                BorderFactory.createEmptyBorder(
                        36,
                        46,
                        34,
                        46
                )
        );

        tarjetaFormulario.add(
                construirEncabezadoFormulario(),
                BorderLayout.NORTH
        );

        tarjetaFormulario.add(
                construirCamposFormulario(),
                BorderLayout.CENTER
        );

        tarjetaFormulario.add(
                construirPieFormulario(),
                BorderLayout.SOUTH
        );

        return tarjetaFormulario;
    }

    private JPanel construirEncabezadoFormulario() {

        JPanel encabezado
                = new JPanel(
                        new BorderLayout(
                                22,
                                0
                        )
                );

        encabezado.setOpaque(false);

        encabezado.add(
                construirIconoFormulario(),
                BorderLayout.WEST
        );

        encabezado.add(
                construirTextosEncabezado(),
                BorderLayout.CENTER
        );

        return encabezado;
    }

    private JPanel construirIconoFormulario() {

        JPanel fondoIcono
                = new JPanel(
                        new GridBagLayout()
                );

        fondoIcono.setOpaque(true);

        fondoIcono.setBackground(
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        fondoIcono.setPreferredSize(
                new Dimension(
                        100,
                        100
                )
        );

        fondoIcono.setMinimumSize(
                new Dimension(
                        100,
                        100
                )
        );

        fondoIcono.setBorder(
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
                        "/recursos/logo_farma.jpeg"
                )
        );

        Image imagen = logo.getImage().getScaledInstance(
                100,
                100,
                Image.SCALE_SMOOTH
        );

        JLabel lblIcono = new JLabel(
                new ImageIcon(imagen)
        );

        lblIcono.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        fondoIcono.add(lblIcono);

        return fondoIcono;
    }

    private JPanel construirTextosEncabezado() {

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
                        "GESTIÓN DE INVENTARIO"
                );

        lblSeccion.setFont(
                TemaFarmacia.FUENTE_ETIQUETA
                        .deriveFont(13f)
        );

        lblSeccion.setForeground(
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        lblSeccion.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel lblTitulo
                = new JLabel(
                        "Registrar medicamento"
                );

        lblTitulo.setFont(
                TemaFarmacia.FUENTE_TITULO
                        .deriveFont(31f)
        );

        lblTitulo.setForeground(
                TemaFarmacia.AZUL_TITULO
        );

        lblTitulo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel lblDescripcion
                = new JLabel(
                        "Complete la información del producto "
                        + "para incorporarlo al inventario."
                );

        lblDescripcion.setFont(
                TemaFarmacia.FUENTE_SUBTITULO
                        .deriveFont(16f)
        );

        lblDescripcion.setForeground(
                new Color(
                        62,
                        81,
                        94
                )
        );

        lblDescripcion.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        panelTextos.add(
                lblSeccion
        );

        panelTextos.add(
                Box.createVerticalStrut(5)
        );

        panelTextos.add(
                lblTitulo
        );

        panelTextos.add(
                Box.createVerticalStrut(7)
        );

        panelTextos.add(
                lblDescripcion
        );

        return panelTextos;
    }

    private JPanel construirCamposFormulario() {

        JPanel panelCampos
                = new JPanel(
                        new GridBagLayout()
                );

        panelCampos.setOpaque(false);

        panelCampos.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        0,
                        8,
                        0
                )
        );

        GridBagConstraints base
                = new GridBagConstraints();

        base.fill
                = GridBagConstraints.HORIZONTAL;

        base.anchor
                = GridBagConstraints.NORTHWEST;

        base.weightx = 1;

        base.insets
                = new Insets(
                        8,
                        15,
                        8,
                        15
                );

        agregarCampo(
                panelCampos,
                "Código",
                txtCodigo,
                "Identificador numérico único",
                0,
                0,
                base
        );

        agregarCampo(
                panelCampos,
                "Nombre del medicamento",
                txtNombre,
                "Nombre comercial o genérico",
                1,
                0,
                base
        );

        agregarCampo(
                panelCampos,
                "Categoría",
                comboCategoria,
                "Clasificación farmacológica",
                0,
                1,
                base
        );

        agregarCampo(
                panelCampos,
                "Cantidad disponible",
                txtCantidad,
                "Número de unidades disponibles",
                1,
                1,
                base
        );

        agregarCampo(
                panelCampos,
                "Precio",
                txtPrecio,
                "Valor unitario del medicamento",
                0,
                2,
                base
        );

        agregarCampo(
                panelCampos,
                "Fecha de vencimiento",
                txtVencimiento,
                "Formato requerido: año-mes-día",
                1,
                2,
                base
        );

        return panelCampos;
    }

    private void agregarCampo(
            JPanel panel,
            String titulo,
            JComponent componente,
            String ayuda,
            int columna,
            int fila,
            GridBagConstraints base
    ) {

        JPanel contenedorCampo
                = new JPanel();

        contenedorCampo.setOpaque(false);

        contenedorCampo.setLayout(
                new BoxLayout(
                        contenedorCampo,
                        BoxLayout.Y_AXIS
                )
        );

        contenedorCampo.setPreferredSize(
                new Dimension(
                        430,
                        102
                )
        );

        contenedorCampo.setMinimumSize(
                new Dimension(
                        300,
                        102
                )
        );

        JLabel lblTitulo
                = crearEtiqueta(
                        titulo
                );

        JLabel lblAyuda
                = crearAyudaCampo(
                        ayuda
                );

        etiquetasMensajes.put(
                componente,
                lblAyuda
        );

        mensajesOriginales.put(
                componente,
                ayuda
        );

        lblTitulo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        componente.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        lblAyuda.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        contenedorCampo.add(
                lblTitulo
        );

        contenedorCampo.add(
                Box.createVerticalStrut(7)
        );

        contenedorCampo.add(
                componente
        );

        contenedorCampo.add(
                Box.createVerticalStrut(6)
        );

        contenedorCampo.add(
                lblAyuda
        );

        GridBagConstraints gbc
                = (GridBagConstraints) base.clone();

        gbc.gridx = columna;
        gbc.gridy = fila;

        panel.add(
                contenedorCampo,
                gbc
        );
    }

    private JLabel crearEtiqueta(
            String texto
    ) {

        JLabel etiqueta
                = new JLabel(
                        texto
                );

        etiqueta.setFont(
                TemaFarmacia.FUENTE_ETIQUETA
                        .deriveFont(14f)
        );

        etiqueta.setForeground(
                new Color(
                        10,
                        31,
                        48
                )
        );

        return etiqueta;
    }

    private JLabel crearAyudaCampo(
            String texto
    ) {

        JLabel ayuda
                = new JLabel(
                        texto
                );

        ayuda.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(12.5f)
        );

        ayuda.setForeground(
                new Color(
                        65,
                        84,
                        97
                )
        );

        return ayuda;
    }

    private JPanel construirPieFormulario() {

        JPanel pie
                = new JPanel(
                        new BorderLayout(
                                20,
                                0
                        )
                );

        pie.setOpaque(false);

        pie.setBorder(
                BorderFactory.createMatteBorder(
                        1,
                        0,
                        0,
                        0,
                        TemaFarmacia.BORDE_SUAVE
                )
        );

        JPanel panelAyuda
                = new JPanel();

        panelAyuda.setOpaque(false);

        panelAyuda.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        0,
                        0,
                        0
                )
        );

        panelAyuda.setLayout(
                new BoxLayout(
                        panelAyuda,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel lblTituloAyuda
                = new JLabel(
                        "Los campos deben completarse correctamente"
                );

        lblTituloAyuda.setFont(
                TemaFarmacia.FUENTE_ETIQUETA
                        .deriveFont(13.5f)
        );

        lblTituloAyuda.setForeground(
                new Color(
                        12,
                        34,
                        50
                )
        );

        JLabel lblDescripcionAyuda
                = new JLabel(
                        "Utilice los botones principales para guardar "
                        + "o actualizar el medicamento."
                );

        lblDescripcionAyuda.setFont(
                TemaFarmacia.FUENTE_NORMAL
                        .deriveFont(12.5f)
        );

        lblDescripcionAyuda.setForeground(
                new Color(
                        65,
                        83,
                        96
                )
        );

        panelAyuda.add(
                lblTituloAyuda
        );

        panelAyuda.add(
                Box.createVerticalStrut(5)
        );

        panelAyuda.add(
                lblDescripcionAyuda
        );

        JPanel panelBoton
                = new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                0,
                                18
                        )
                );

        panelBoton.setOpaque(false);

        panelBoton.add(
                btnLimpiar
        );

        pie.add(
                panelAyuda,
                BorderLayout.CENTER
        );

        pie.add(
                panelBoton,
                BorderLayout.EAST
        );

        return pie;
    }

    private void configurarEventos() {

        btnLimpiar.addActionListener(
                evento -> limpiarCampos()
        );

        txtVencimiento.addActionListener(
                evento -> guardar()
        );

        configurarValidacionesTiempoReal();
    }

    private void guardarBordesOriginales() {

        bordeCodigoOriginal = txtCodigo.getBorder();
        bordeNombreOriginal = txtNombre.getBorder();
        bordeCantidadOriginal = txtCantidad.getBorder();
        bordePrecioOriginal = txtPrecio.getBorder();
        bordeVencimientoOriginal = txtVencimiento.getBorder();
        bordeCategoriaOriginal = comboCategoria.getBorder();
    }

    private void limpiarErroresVisuales() {

        limpiarErrorCampo(txtCodigo);
        limpiarErrorCampo(txtNombre);
        limpiarErrorCampo(txtCantidad);
        limpiarErrorCampo(txtPrecio);
        limpiarErrorCampo(txtVencimiento);
        limpiarErrorCampo(comboCategoria);

        revalidate();
        repaint();
    }

    private void marcarCampoConError(JComponent componente) {

        componente.setBorder(
                new LineBorder(
                        new Color(211, 47, 47),
                        2,
                        true
                )
        );

        componente.setBackground(
                new Color(255, 235, 238)
        );

        SwingUtilities.invokeLater(
                () -> componente.requestFocusInWindow()
        );

        componente.revalidate();
        componente.repaint();
    }

    private void validarFormatoFecha() {

        SwingUtilities.invokeLater(() -> {

            String fecha
                    = txtVencimiento
                            .getText()
                            .trim();

            if (fecha.isEmpty()) {

                limpiarErrorCampo(
                        txtVencimiento
                );

                return;
            }

            if (fecha.length() < 10) {

                return;
            }

            if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {

                mostrarErrorDebajo(
                        txtVencimiento,
                        "Utilice el formato yyyy-MM-dd. Ejemplo: 2026-12-31."
                );

            } else {

                limpiarErrorCampo(
                        txtVencimiento
                );
            }
        });
    }

    private void mostrarErrorDebajo(
            JComponent campo,
            String mensaje
    ) {

        JLabel etiqueta = etiquetasMensajes.get(campo);

        if (etiqueta != null) {

            etiqueta.setText(
                    "⚠ " + mensaje
            );

            etiqueta.setForeground(
                    COLOR_ERROR
            );

            etiqueta.setFont(
                    TemaFarmacia.FUENTE_NORMAL
                            .deriveFont(java.awt.Font.BOLD, 12.5f)
            );
        }

        campo.setBorder(
                new LineBorder(
                        COLOR_ERROR,
                        2,
                        true
                )
        );

        campo.setBackground(
                new Color(255, 235, 238)
        );

        campo.revalidate();
        campo.repaint();
    }

    private void limpiarErrorCampo(
            JComponent campo
    ) {

        JLabel etiqueta = etiquetasMensajes.get(campo);

        if (etiqueta != null) {

            etiqueta.setText(
                    mensajesOriginales.get(campo)
            );

            etiqueta.setForeground(
                    COLOR_AYUDA
            );

            etiqueta.setFont(
                    TemaFarmacia.FUENTE_NORMAL
                            .deriveFont(12.5f)
            );
        }

        restaurarBordeCampo(campo);

        campo.setBackground(
                Color.WHITE
        );

        campo.revalidate();
        campo.repaint();
    }

    private void restaurarBordeCampo(
            JComponent campo
    ) {

        if (campo == txtCodigo) {

            campo.setBorder(
                    bordeCodigoOriginal
            );

        } else if (campo == txtNombre) {

            campo.setBorder(
                    bordeNombreOriginal
            );

        } else if (campo == txtCantidad) {

            campo.setBorder(
                    bordeCantidadOriginal
            );

        } else if (campo == txtPrecio) {

            campo.setBorder(
                    bordePrecioOriginal
            );

        } else if (campo == txtVencimiento) {

            campo.setBorder(
                    bordeVencimientoOriginal
            );

        } else if (campo == comboCategoria) {

            campo.setBorder(
                    bordeCategoriaOriginal
            );
        }
    }

    private void mostrarAdvertencia(
            JComponent campo,
            String mensaje
    ) {

        limpiarErroresVisuales();

        marcarCampoConError(campo);

        JLabel lblMensaje = new JLabel(
                "<html>"
                + "<div style='color:#D32F2F;"
                + "font-family:sans-serif;"
                + "font-size:13px;"
                + "width:340px;'>"
                + "<b>⚠ Advertencia</b><br><br>"
                + mensaje
                + "</div>"
                + "</html>"
        );

        JOptionPane.showMessageDialog(
                this,
                lblMensaje,
                "Datos incorrectos",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void configurarValidacionesTiempoReal() {

        txtCodigo.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char caracter = e.getKeyChar();

                if (Character.isDigit(caracter)
                        || caracter == KeyEvent.VK_BACK_SPACE
                        || caracter == KeyEvent.VK_DELETE) {

                    limpiarErrorCampo(txtCodigo);
                    return;
                }

                e.consume();

                mostrarErrorDebajo(
                        txtCodigo,
                        "El código solo permite números."
                );
            }
        });

        txtCantidad.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char caracter = e.getKeyChar();

                if (Character.isDigit(caracter)
                        || caracter == KeyEvent.VK_BACK_SPACE
                        || caracter == KeyEvent.VK_DELETE) {

                    limpiarErrorCampo(txtCantidad);
                    return;
                }

                e.consume();

                mostrarErrorDebajo(
                        txtCantidad,
                        "La cantidad solo permite números enteros."
                );
            }
        });

        txtPrecio.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char caracter = e.getKeyChar();

                if (Character.isDigit(caracter)
                        || caracter == KeyEvent.VK_BACK_SPACE
                        || caracter == KeyEvent.VK_DELETE) {

                    limpiarErrorCampo(txtPrecio);
                    return;
                }

                if (caracter == '.'
                        && !txtPrecio.getText().contains(".")) {

                    limpiarErrorCampo(txtPrecio);
                    return;
                }

                e.consume();

                if (caracter == '.'
                        && txtPrecio.getText().contains(".")) {

                    mostrarErrorDebajo(
                            txtPrecio,
                            "El precio solo puede contener un punto decimal."
                    );

                } else {

                    mostrarErrorDebajo(
                            txtPrecio,
                            "El precio solo permite números y un punto decimal."
                    );
                }
            }
        });

        txtNombre.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char caracter = e.getKeyChar();

                boolean permitido
                        = Character.isLetterOrDigit(caracter)
                        || Character.isWhitespace(caracter)
                        || caracter == '-'
                        || caracter == '('
                        || caracter == ')'
                        || caracter == '/'
                        || caracter == KeyEvent.VK_BACK_SPACE
                        || caracter == KeyEvent.VK_DELETE;

                if (permitido) {

                    limpiarErrorCampo(txtNombre);
                    return;
                }

                e.consume();

                mostrarErrorDebajo(
                        txtNombre,
                        "El nombre contiene un carácter no permitido."
                );
            }
        });

        txtVencimiento.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char caracter = e.getKeyChar();

                boolean permitido
                        = Character.isDigit(caracter)
                        || caracter == '-'
                        || caracter == KeyEvent.VK_BACK_SPACE
                        || caracter == KeyEvent.VK_DELETE;

                if (permitido) {

                    limpiarErrorCampo(txtVencimiento);
                    return;
                }

                e.consume();

                mostrarErrorDebajo(
                        txtVencimiento,
                        "La fecha solo permite números y guiones."
                );
            }
        });

        txtVencimiento.getDocument().addDocumentListener(
                new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                validarFormatoFecha();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarFormatoFecha();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarFormatoFecha();
            }
        });

        comboCategoria.addActionListener(
                evento -> limpiarErrorCampo(
                        comboCategoria
                )
        );
    }

    private void mostrarErrorValidacion(
            String mensaje
    ) {

        String texto
                = mensaje.toLowerCase();

        if (texto.contains("código")) {

            mostrarErrorDebajo(
                    txtCodigo,
                    mensaje
            );

            txtCodigo.requestFocusInWindow();

        } else if (texto.contains("nombre")) {

            mostrarErrorDebajo(
                    txtNombre,
                    mensaje
            );

            txtNombre.requestFocusInWindow();

        } else if (texto.contains("categoría")) {

            mostrarErrorDebajo(
                    comboCategoria,
                    mensaje
            );

            comboCategoria.requestFocusInWindow();

        } else if (texto.contains("cantidad")) {

            mostrarErrorDebajo(
                    txtCantidad,
                    mensaje
            );

            txtCantidad.requestFocusInWindow();

        } else if (texto.contains("precio")) {

            mostrarErrorDebajo(
                    txtPrecio,
                    mensaje
            );

            txtPrecio.requestFocusInWindow();

        } else if (texto.contains("fecha")
                || texto.contains("vencimiento")) {

            mostrarErrorDebajo(
                    txtVencimiento,
                    mensaje
            );

            txtVencimiento.requestFocusInWindow();
        }
    }

    private Medicamento capturarDatos()
            throws NumberFormatException {

        Medicamento medicamento
                = new Medicamento();

        medicamento.setCodigo(
                txtCodigo.getText().trim().isEmpty()
                ? 0
                : Integer.parseInt(
                        txtCodigo.getText().trim()
                )
        );

        medicamento.setNombre(
                txtNombre.getText().trim()
        );

        medicamento.setCategoria(
                (String) comboCategoria.getSelectedItem()
        );

        medicamento.setCantidad(
                txtCantidad.getText().trim().isEmpty()
                ? -1
                : Integer.parseInt(
                        txtCantidad.getText().trim()
                )
        );

        medicamento.setPrecio(
                txtPrecio.getText().trim().isEmpty()
                ? -1
                : Double.parseDouble(
                        txtPrecio.getText().trim()
                )
        );

        medicamento.setVencimiento(
                txtVencimiento.getText().trim()
        );

        return medicamento;
    }

    public void guardar() {
        System.out.println("ENTRÓ AL MÉTODO GUARDAR");

        try {

            limpiarErroresVisuales();

            Medicamento medicamento = capturarDatos();

            negocio.agregar(medicamento);

            JOptionPane.showMessageDialog(
                    this,
                    "El medicamento fue registrado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            refrescarLista();

        } catch (NumberFormatException ex) {

            if (!txtCodigo.getText().trim().matches("\\d+")) {

                mostrarAdvertencia(
                        txtCodigo,
                        "El código debe contener únicamente números enteros."
                );

            } else if (!txtCantidad.getText().trim().matches("\\d+")) {

                mostrarAdvertencia(
                        txtCantidad,
                        "La cantidad debe contener únicamente números enteros."
                );

            } else {

                mostrarAdvertencia(
                        txtPrecio,
                        "El precio debe contener un valor numérico válido. "
                        + "Ejemplo: 2500.00"
                );
            }

        } catch (ValidacionException ex) {

            mostrarErrorValidacion(
                    ex.getMessage()
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void actualizar() {

        try {

            limpiarErroresVisuales();

            Medicamento medicamento = capturarDatos();

            negocio.actualizar(medicamento);

            JOptionPane.showMessageDialog(
                    this,
                    "El medicamento fue actualizado correctamente.",
                    "Actualización exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            refrescarLista();

        } catch (NumberFormatException ex) {

            if (!txtCodigo.getText().trim().matches("\\d+")) {

                mostrarAdvertencia(
                        txtCodigo,
                        "El código debe contener únicamente números enteros."
                );

            } else if (!txtCantidad.getText().trim().matches("\\d+")) {

                mostrarAdvertencia(
                        txtCantidad,
                        "La cantidad debe contener únicamente números enteros."
                );

            } else {

                mostrarAdvertencia(
                        txtPrecio,
                        "El precio debe contener un valor numérico válido. "
                        + "Ejemplo: 2500.00"
                );
            }

        } catch (ValidacionException ex) {

            mostrarErrorValidacion(
                    ex.getMessage()
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void refrescarLista() {

        if (panelLista != null) {

            panelLista.cargarDatos();
        }
    }

    public void limpiarCampos() {

        limpiarErroresVisuales();
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtVencimiento.setText("");

        comboCategoria.setSelectedIndex(0);

        SwingUtilities.invokeLater(
                () -> txtCodigo.requestFocusInWindow()
        );
    }

    public void cargarRegistro(
            Medicamento medicamento
    ) {

        if (medicamento == null) {
            return;
        }

        txtCodigo.setText(
                String.valueOf(
                        medicamento.getCodigo()
                )
        );

        txtNombre.setText(
                medicamento.getNombre()
        );

        comboCategoria.setSelectedItem(
                medicamento.getCategoria()
        );

        txtCantidad.setText(
                String.valueOf(
                        medicamento.getCantidad()
                )
        );

        txtPrecio.setText(
                String.valueOf(
                        medicamento.getPrecio()
                )
        );

        txtVencimiento.setText(
                medicamento.getVencimiento()
        );

        SwingUtilities.invokeLater(
                () -> txtNombre.requestFocusInWindow()
        );
    }
}
