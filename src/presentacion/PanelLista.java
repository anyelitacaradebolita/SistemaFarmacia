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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class PanelLista extends JPanel {

    private final JTextField txtBuscar = new JTextField(10);
    private final JButton btnBuscar = new JButton("Buscar");
    private final JButton btnActualizar = new JButton("Actualizar");
    private final JButton btnEliminar = new JButton("Eliminar");
    private final JButton btnListar = new JButton("Listar");

    private final String[] columnas = {
        "Código",
        "Nombre",
        "Categoría",
        "Cantidad",
        "Precio",
        "Vencimiento"
    };

    private final DefaultTableModel modeloTabla =
            new DefaultTableModel(columnas, 0) {

        // Evita que las celdas puedan editarse.
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable tabla = new JTable(modeloTabla);

    // Permite utilizar las operaciones de medicamentos.
    private final MedicamentoNegocio negocio =
            new MedicamentoNegocio();

    // Panel donde se cargará el medicamento que se desea editar.
    private PanelRegistro panelRegistro;

    // Acción para cambiar a la pestaña de registro.
    private Runnable irARegistro;

    public PanelLista() {
        construirInterfaz();
        configurarEventos();
    }

    public void setPanelRegistro(PanelRegistro panelRegistro) {
        this.panelRegistro = panelRegistro;
    }

    public void setIrARegistro(Runnable irARegistro) {
        this.irARegistro = irARegistro;
    }

    // Crea y organiza los componentes del panel.
    private void construirInterfaz() {
        setLayout(new BorderLayout(10, 10));
        setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        // Área de búsqueda.
        JPanel panelBusqueda =
                new JPanel(
                        new FlowLayout(FlowLayout.LEFT)
                );

        panelBusqueda.add(new JLabel("Código:"));
        panelBusqueda.add(txtBuscar);
        panelBusqueda.add(btnBuscar);

        // Área de botones.
        JPanel panelBotones =
                new JPanel(
                        new FlowLayout(FlowLayout.LEFT)
                );

        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        // Une la búsqueda y los botones en la parte superior.
        JPanel superior = new JPanel(new BorderLayout());

        superior.add(
                panelBusqueda,
                BorderLayout.WEST
        );

        superior.add(
                panelBotones,
                BorderLayout.EAST
        );

        add(superior, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    // Asigna una acción a cada botón.
    private void configurarEventos() {
        btnBuscar.addActionListener(e -> buscar());

        btnActualizar.addActionListener(
                e -> cargarSeleccionParaEditar()
        );

        btnEliminar.addActionListener(
                e -> eliminarSeleccionado()
        );

        btnListar.addActionListener(
                e -> cargarDatos()
        );
    }

    // Carga todos los medicamentos en la tabla.
    public void cargarDatos() {
        try {
            List<Medicamento> lista = negocio.listar();

            // Limpia la tabla antes de cargar los datos.
            modeloTabla.setRowCount(0);

            for (Medicamento m : lista) {
                modeloTabla.addRow(new Object[]{
                    m.getCodigo(),
                    m.getNombre(),
                    m.getCategoria(),
                    m.getCantidad(),
                    m.getPrecio(),
                    m.getVencimiento()
                });
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Coloca el cursor en el campo de búsqueda.
    public void enfocarBusqueda() {
        txtBuscar.requestFocus();
    }

    // Busca un medicamento por su código.
    private void buscar() {
        try {
            int codigo = Integer.parseInt(
                    txtBuscar.getText().trim()
            );

            Medicamento m = negocio.buscar(codigo);

            // Limpia la tabla antes de mostrar el resultado.
            modeloTabla.setRowCount(0);

            if (m == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró un medicamento con ese código.",
                        "Sin resultados",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {
                modeloTabla.addRow(new Object[]{
                    m.getCodigo(),
                    m.getNombre(),
                    m.getCategoria(),
                    m.getCantidad(),
                    m.getPrecio(),
                    m.getVencimiento()
                });
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un código numérico válido para buscar.",
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

    // Carga el medicamento seleccionado para modificarlo.
    public void cargarSeleccionParaEditar() {
        int fila = tabla.getSelectedRow();

        // Verifica que exista una fila seleccionada.
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un registro de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Crea el medicamento con los datos de la fila.
        Medicamento m = new Medicamento();

        m.setCodigo(
                (Integer) modeloTabla.getValueAt(fila, 0)
        );

        m.setNombre(
                (String) modeloTabla.getValueAt(fila, 1)
        );

        m.setCategoria(
                (String) modeloTabla.getValueAt(fila, 2)
        );

        m.setCantidad(
                (Integer) modeloTabla.getValueAt(fila, 3)
        );

        m.setPrecio(
                (Double) modeloTabla.getValueAt(fila, 4)
        );

        m.setVencimiento(
                (String) modeloTabla.getValueAt(fila, 5)
        );

        // Envía los datos al panel de registro.
        if (panelRegistro != null) {
            panelRegistro.cargarRegistro(m);
        }

        // Cambia a la pestaña de registro.
        if (irARegistro != null) {
            irARegistro.run();
        }
    }

    // Elimina el medicamento seleccionado.
    private void eliminarSeleccionado() {
        int fila = tabla.getSelectedRow();

        // Verifica que exista una fila seleccionada.
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un registro de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int codigo =
                (Integer) modeloTabla.getValueAt(fila, 0);

        // Solicita confirmación antes de eliminar.
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el medicamento "
                        + "con código " + codigo + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            negocio.eliminar(codigo);

            JOptionPane.showMessageDialog(
                    this,
                    "Medicamento eliminado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Actualiza la tabla después de eliminar.
            cargarDatos();

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
}