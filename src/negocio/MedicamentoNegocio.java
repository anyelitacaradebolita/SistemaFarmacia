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

/**
 * Capa de Negocio: contiene la lógica principal del sistema, incluyendo
 * las validaciones de los datos (obligatorias según el enunciado del
 * proyecto). La capa de presentación NUNCA valida directamente; siempre
 * delega en esta clase.
 */
public class MedicamentoNegocio {

    private final MedicamentoDAO dao = new MedicamentoDAO();

    /**
     * Valida las reglas de negocio para un medicamento.
     */
    public void validar(Medicamento m) throws ValidacionException {
        if (m == null) {
            throw new ValidacionException("El medicamento no puede ser nulo.");
        }
        if (m.getCodigo() <= 0) {
            throw new ValidacionException("El código debe ser un número válido mayor a 0.");
        }
        if (m.getNombre() == null || m.getNombre().trim().isEmpty()) {
            throw new ValidacionException("El nombre del medicamento es obligatorio.");
        }
        if (m.getCategoria() == null || m.getCategoria().trim().isEmpty()) {
            throw new ValidacionException("Debe seleccionar una categoría.");
        }
        if (m.getCantidad() < 0) {
            throw new ValidacionException("La cantidad no puede ser negativa.");
        }
        if (m.getPrecio() <= 0) {
            throw new ValidacionException("El precio debe ser mayor a 0.");
        }
        if (m.getVencimiento() == null || m.getVencimiento().trim().isEmpty()) {
            throw new ValidacionException("La fecha de vencimiento es obligatoria (formato yyyy-MM-dd).");
        }
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

