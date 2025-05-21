/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica_dental_proyecto;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author carol
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/pacientes"; // URL de tu base de datos
    private static final String USER = "proyecto"; // Usuario de la base de datos
    private static final String PASSWORD = "proyecto2025"; // Contraseña de la base de datos

    // Método para conectar con la base de datos
    public static Connection conectar() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para guardar un registro en la base de datos
    public static void guardarRegistro(String nombre, String apellido, String dniNie, String telefono, String email, String tratamiento, Date fechaRegistro, Date fechaVisita) {
        String sql = "INSERT INTO pacientes (nombre, apellido, dniNie, telefono, email, tratamiento, fechaRegistro, fechaVisita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, dniNie);
            statement.setString(4, telefono);
            statement.setString(5, email);
            statement.setString(6, tratamiento);
            statement.setDate(7, new java.sql.Date(fechaRegistro.getTime())); // Convierte java.util.Date a java.sql.Date
            statement.setDate(8, new java.sql.Date(fechaVisita.getTime())); // Convierte java.util.Date a java.sql.Date

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro guardado correctamente.");
            } else {
                System.out.println("Error al guardar el registro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    // Método para buscar un registro por ID
    public static ResultSet buscarPacientePorId(String id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Establecemos la conexión
            con = getConnection();
            
            // Consulta SQL para obtener los datos del paciente por ID
            String sql = "SELECT * FROM pacientes WHERE id = ?"; // Cambia "pacientes" por el nombre de tu tabla
            stmt = con.prepareStatement(sql);
            stmt.setString(1, id); // Establecemos el valor del ID en la consulta
            rs = stmt.executeQuery(); // Ejecutamos la consulta
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs; // Devolvemos el resultado de la consulta
    }
}