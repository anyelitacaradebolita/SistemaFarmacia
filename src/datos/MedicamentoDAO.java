/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Daryelin
 */


import modelo.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Capa de Datos: acceso directo a la base de datos mediante JDBC.
 * Contiene únicamente sentencias SQL, PreparedStatement y ResultSet.
 * No contiene validaciones de negocio.
 */
public class MedicamentoDAO {

    public void agregar(Medicamento m) throws SQLException {
        String sql = "INSERT INTO medicamento (codigo, nombre, categoria, cantidad, precio, vencimiento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, m.getCodigo());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getCategoria());
            ps.setInt(4, m.getCantidad());
            ps.setDouble(5, m.getPrecio());
            ps.setString(6, m.getVencimiento());
            ps.executeUpdate();
        }
    }

    public List<Medicamento> listar() throws SQLException {
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT codigo, nombre, categoria, cantidad, precio, vencimiento "
                + "FROM medicamento ORDER BY codigo";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Medicamento buscarPorId(int codigo) throws SQLException {
        String sql = "SELECT codigo, nombre, categoria, cantidad, precio, vencimiento "
                + "FROM medicamento WHERE codigo = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public void actualizar(Medicamento m) throws SQLException {
        String sql = "UPDATE medicamento SET nombre = ?, categoria = ?, cantidad = ?, "
                + "precio = ?, vencimiento = ? WHERE codigo = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getCategoria());
            ps.setInt(3, m.getCantidad());
            ps.setDouble(4, m.getPrecio());
            ps.setString(5, m.getVencimiento());
            ps.setInt(6, m.getCodigo());
            ps.executeUpdate();
        }
    }

    
    public void eliminar(int codigo) throws SQLException {
        String sql = "DELETE FROM medicamento WHERE codigo = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }

    private Medicamento mapear(ResultSet rs) throws SQLException {
        Medicamento m = new Medicamento();
        m.setCodigo(rs.getInt("codigo"));
        m.setNombre(rs.getString("nombre"));
        m.setCategoria(rs.getString("categoria"));
        m.setCantidad(rs.getInt("cantidad"));
        m.setPrecio(rs.getDouble("precio"));
        m.setVencimiento(rs.getString("vencimiento"));
        return m;
    }
}