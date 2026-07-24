/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author PC
 */
import datos.MedicamentoDAO;
import modelo.Medicamento;

import java.sql.SQLException;
import java.util.List;


public class MedicamentoNegocio {

    private final MedicamentoDAO dao = new MedicamentoDAO();

    public void validar(Medicamento m) throws ValidacionException {

        if (m == null) {
            throw new ValidacionException(
                    "El medicamento no puede ser nulo."
            );
        }

        if (m.getCodigo() <= 0) {
            throw new ValidacionException(
                    "El código debe ser mayor que 0."
            );
        }

        if (m.getNombre() == null
                || m.getNombre().trim().isEmpty()) {

            throw new ValidacionException(
                    "El nombre del medicamento es obligatorio."
            );
        }

        String nombre = m.getNombre().trim();

        if (nombre.length() < 3) {
            throw new ValidacionException(
                    "El nombre debe tener al menos 3 caracteres."
            );
        }

        if (nombre.length() > 100) {
            throw new ValidacionException(
                    "El nombre no puede superar los 100 caracteres."
            );
        }

        if (nombre.matches("\\d+")) {
            throw new ValidacionException(
                    "El nombre no puede contener solamente números."
            );
        }

        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9 .()/-]+")) {
            throw new ValidacionException(
                    "El nombre contiene caracteres no permitidos."
            );
        }

        if (m.getCategoria() == null
                || m.getCategoria().trim().isEmpty()) {

            throw new ValidacionException(
                    "Debe seleccionar una categoría."
            );
        }

        String categoria = m.getCategoria().trim();

        if (categoria.equalsIgnoreCase("Seleccione...")
                || categoria.equalsIgnoreCase("Seleccione una categoría")) {

            throw new ValidacionException(
                    "Debe seleccionar una categoría válida."
            );
        }

        if (m.getCantidad() <= 0) {
            throw new ValidacionException(
                    "La cantidad debe ser mayor que 0."
            );
        }

        if (m.getCantidad() > 1_000_000) {
            throw new ValidacionException(
                    "La cantidad ingresada es demasiado alta."
            );
        }

        if (m.getPrecio() <= 0) {
            throw new ValidacionException(
                    "El precio debe ser mayor que 0."
            );
        }

        if (m.getPrecio() > 100_000_000) {
            throw new ValidacionException(
                    "El precio ingresado es demasiado alto."
            );
        }

        if (m.getVencimiento() == null
                || m.getVencimiento().trim().isEmpty()) {

            throw new ValidacionException(
                    "La fecha de vencimiento es obligatoria."
            );
        }

        String vencimientoTexto
                = m.getVencimiento().trim();

        try {

            java.time.LocalDate vencimiento
                    = java.time.LocalDate.parse(
                            vencimientoTexto,
                            java.time.format.DateTimeFormatter
                                    .ofPattern("yyyy-MM-dd")
                    );

            java.time.LocalDate hoy
                    = java.time.LocalDate.now();

            if (!vencimiento.isAfter(hoy)) {
                throw new ValidacionException(
                        "La fecha de vencimiento debe ser posterior a hoy."
                );
            }

        } catch (java.time.format.DateTimeParseException e) {

            throw new ValidacionException(
                    "La fecha debe tener el formato yyyy-MM-dd."
            );
        }

        m.setNombre(nombre);
        m.setCategoria(categoria);
        m.setVencimiento(vencimientoTexto);

    }

    public void agregar(Medicamento m) throws ValidacionException, SQLException {
        validar(m);
        try {
            if (dao.buscarPorId(m.getCodigo()) != null) {
                throw new ValidacionException("Ya existe un medicamento con el código " + m.getCodigo() + ".");
            }
            dao.agregar(m);
        } catch (SQLException e) {
            throw new SQLException("Error al guardar el medicamento en la base de datos.", e);
        }
    }

    public List<Medicamento> listar() throws SQLException {
        try {
            return dao.listar();
        } catch (SQLException e) {
            throw new SQLException("Error al listar los medicamentos desde la base de datos.", e);
        }
    }

    public Medicamento buscar(int codigo) throws ValidacionException, SQLException {
        if (codigo <= 0) {
            throw new ValidacionException("El código de búsqueda no es válido.");
        }
        try {
            return dao.buscarPorId(codigo);
        } catch (SQLException e) {
            throw new SQLException("Error al buscar el medicamento.", e);
        }
    }

    public void actualizar(Medicamento m) throws ValidacionException, SQLException {
        validar(m);
        try {
            if (dao.buscarPorId(m.getCodigo()) == null) {
                throw new ValidacionException("No existe un medicamento con el código " + m.getCodigo() + ".");
            }
            dao.actualizar(m);
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el medicamento.", e);
        }
    }

    public void eliminar(int codigo) throws ValidacionException, SQLException {
        if (codigo <= 0) {
            throw new ValidacionException("El código no es válido.");
        }
        try {
            if (dao.buscarPorId(codigo) == null) {
                throw new ValidacionException("No existe un medicamento con el código " + codigo + ".");
            }
            dao.eliminar(codigo);
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el medicamento.", e);
        }
    }
}
