/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica_dental_proyecto;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carol
 */
public class Buscar extends JFrame{
    private JTextField idField, nombreField, apellidoField, dniNieField, telefonoField, emailField;
    private JComboBox<String> tratamientoComboBox;
    private JDateChooser fechaRegistroChooser, fechaVisitaChooser;

    public Buscar(String id) {
        // Configurar la ventana
        setTitle("Resultado de Búsqueda");
        setLayout(new GridLayout(9, 2));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Componentes del formulario
        idField = new JTextField(id);
        nombreField = new JTextField();
        apellidoField = new JTextField();
        dniNieField = new JTextField();
        telefonoField = new JTextField();
        emailField = new JTextField();
        tratamientoComboBox = new JComboBox<>(new String[]{"Ninguno", "Implantes Dentales", "Ortodencia y Brackets", "Blanqueamiento Dental", "Estética Dental"});
        fechaRegistroChooser = new JDateChooser();
        fechaVisitaChooser = new JDateChooser();

        // Añadir los componentes a la ventana
        add(new JLabel("ID:"));
        add(idField);
        idField.setEditable(false);

        add(new JLabel("Nombre:"));
        add(nombreField);
        nombreField.setEditable(false);

        add(new JLabel("Apellido:"));
        add(apellidoField);
        apellidoField.setEditable(false);

        add(new JLabel("DNI/NIE:"));
        add(dniNieField);
        dniNieField.setEditable(false);

        add(new JLabel("Teléfono:"));
        add(telefonoField);
        telefonoField.setEditable(false);

        add(new JLabel("Email:"));
        add(emailField);
        emailField.setEditable(false);

        add(new JLabel("Tratamiento:"));
        add(tratamientoComboBox);
        tratamientoComboBox.setEnabled(false);

        add(new JLabel("Fecha de Registro:"));
        add(fechaRegistroChooser);
        fechaRegistroChooser.setEnabled(false);

        add(new JLabel("Fecha de Visita:"));
        add(fechaVisitaChooser);
        fechaVisitaChooser.setEnabled(false);

        // Realizar la consulta a la base de datos
        buscarEnBaseDeDatos(id);

        setLocationRelativeTo(null);
    }

    private void buscarEnBaseDeDatos(String id) {
        // Aquí haces la consulta a la base de datos usando el id
        ResultSet rs = Conexion.buscarPacientePorId(id);

        try {
            if (rs != null && rs.next()) {
                // Si encontramos el paciente, llenamos los campos con los datos
                nombreField.setText(rs.getString("nombre"));
                apellidoField.setText(rs.getString("apellido"));
                dniNieField.setText(rs.getString("dniNie"));
                telefonoField.setText(rs.getString("telefono"));
                emailField.setText(rs.getString("email"));
                tratamientoComboBox.setSelectedItem(rs.getString("tratamiento"));
                fechaRegistroChooser.setDate(rs.getDate("fechaRegistro"));
                fechaVisitaChooser.setDate(rs.getDate("fechaVisita"));
            } else {
                // Si no se encuentra el ID, mostramos un mensaje en los campos
                nombreField.setText("No se ha encontrado");
                apellidoField.setText("No se ha encontrado");
                dniNieField.setText("No se ha encontrado");
                telefonoField.setText("No se ha encontrado");
                emailField.setText("No se ha encontrado");
                tratamientoComboBox.setSelectedItem("No se ha encontrado");

                // Limpiamos las fechas
                fechaRegistroChooser.setDate(null);
                fechaVisitaChooser.setDate(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
