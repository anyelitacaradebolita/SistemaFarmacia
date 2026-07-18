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

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 *
 * @author angul
 */
public class PanelRegistro extends JPanel {

    private final JTextField txtCodigo = new JTextField();
    private final JTextField txtNombre = new JTextField();
    private final JTextField txtCantidad = new JTextField();
    private final JTextField txtPrecio = new JTextField();
    private final JTextField txtVencimiento = new JTextField();

    private final JComboBox<String> comboCategoria =
            new JComboBox<>(new String[]{
                "Analgésico",
                "Antibiótico",
                "Antihistamínico",
                "Antipirético",
                "Otro"
            });

    private final JButton btnGuardar =
            new JButton("Guardar");

    private final JButton btnActualizar =
            new JButton("Actualizar");

    private final JButton btnLimpiar =
            new JButton("Limpiar");

    // Permite realizar las operaciones de medicamentos.
    private final MedicamentoNegocio negocio =
            new MedicamentoNegocio();

    // Panel que muestra la lista de medicamentos.
    private PanelLista panelLista;

    public PanelRegistro() {
        construirInterfaz();
        configurarEventos();
    }

    public void setPanelLista(PanelLista panelLista) {
        this.panelLista = panelLista;
    }

    // Crea y organiza los componentes del formulario.
    private void construirInterfaz() {
        setLayout(new BorderLayout(10, 10));

        setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        JPanel formulario =
                new JPanel(new GridBagLayout());

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        // Campo para el código.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Código:"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(txtCodigo, gbc);
        fila++;

        // Campo para el nombre.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Nombre:"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(txtNombre, gbc);
        fila++;

        // Lista de categorías.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Categoría:"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(comboCategoria, gbc);
        fila++;

        // Campo para la cantidad.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Cantidad:"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(txtCantidad, gbc);
        fila++;

        // Campo para el precio.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Precio:"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(txtPrecio, gbc);
        fila++;

        // Campo para la fecha de vencimiento.
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;

        formulario.add(
                new JLabel("Vencimiento (yyyy-MM-dd):"),
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        formulario.add(txtVencimiento, gbc);

        // Área de botones.
        JPanel panelBotones =
                new JPanel(
                        new FlowLayout(FlowLayout.LEFT)
                );

        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnLimpiar);

        add(formulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Asigna una acción a cada botón.
    private void configurarEventos() {
        btnGuardar.addActionListener(
                e -> guardar()
        );

        btnActualizar.addActionListener(
                e -> actualizar()
        );

        btnLimpiar.addActionListener(
                e -> limpiarCampos()
        );
    }

    // Crea un medicamento con los datos del formulario.
    private Medicamento capturarDatos()
            throws NumberFormatException {

        Medicamento medicamento =
                new Medicamento();

        String codigo =
                txtCodigo.getText().trim();

        String cantidad =
                txtCantidad.getText().trim();

        String precio =
                txtPrecio.getText().trim();

        medicamento.setCodigo(
                codigo.isEmpty()
                        ? 0
                        : Integer.parseInt(codigo)
        );

        medicamento.setNombre(
                txtNombre.getText().trim()
        );

        medicamento.setCategoria(
                (String) comboCategoria.getSelectedItem()
        );

        medicamento.setCantidad(
                cantidad.isEmpty()
                        ? -1
                        : Integer.parseInt(cantidad)
        );

        medicamento.setPrecio(
                precio.isEmpty()
                        ? -1
                        : Double.parseDouble(precio)
        );

        medicamento.setVencimiento(
                txtVencimiento.getText().trim()
        );

        return medicamento;
    }

    // Guarda un nuevo medicamento.
    public void guardar() {
        try {
            Medicamento medicamento =
                    capturarDatos();

            negocio.agregar(medicamento);

            JOptionPane.showMessageDialog(
                    this,
                    "Medicamento guardado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            refrescarLista();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cantidad y Precio deben ser numéricos.",
                    "Formato inválido",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Datos inválidos",
                    JOptionPane.WARNING_MESSAGE
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

    // Actualiza un medicamento existente.
    public void actualizar() {
        try {
            Medicamento medicamento =
                    capturarDatos();

            negocio.actualizar(medicamento);

            JOptionPane.showMessageDialog(
                    this,
                    "Medicamento actualizado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            refrescarLista();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cantidad y Precio deben ser numéricos.",
                    "Formato inválido",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Datos inválidos",
                    JOptionPane.WARNING_MESSAGE
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

    // Actualiza la tabla de medicamentos.
    private void refrescarLista() {
        if (panelLista != null) {
            panelLista.cargarDatos();
        }
    }

    // Limpia todos los campos del formulario.
    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtVencimiento.setText("");

        comboCategoria.setSelectedIndex(0);

        txtCodigo.requestFocus();
    }

    // Coloca un medicamento en el formulario para editarlo.
    public void cargarRegistro(Medicamento medicamento) {
        txtCodigo.setText(
                String.valueOf(medicamento.getCodigo())
        );

        txtNombre.setText(
                medicamento.getNombre()
        );

        comboCategoria.setSelectedItem(
                medicamento.getCategoria()
        );

        txtCantidad.setText(
                String.valueOf(medicamento.getCantidad())
        );

        txtPrecio.setText(
                String.valueOf(medicamento.getPrecio())
        );

        txtVencimiento.setText(
                medicamento.getVencimiento()
        );
    }
}
