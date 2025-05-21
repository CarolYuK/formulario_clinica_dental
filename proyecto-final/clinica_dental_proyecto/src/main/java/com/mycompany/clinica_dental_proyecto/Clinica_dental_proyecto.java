/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clinica_dental_proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;


/**
 *
 * @author user
 */
public class Clinica_dental_proyecto extends JFrame{
    private JTextField idField, nombreField, apellidoField, dniNieField, telefonoField, emailField;
    private JComboBox<String> tratamientoComboBox;
    private JDateChooser fechaRegistroChooser, fechaVisitaChooser;
    private JButton enviarButton, buscarButton;

    public Clinica_dental_proyecto() {
        // Configuración de la ventana principal
        setTitle("Formulario de Registro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2, 10, 10));

        // Componentes del formulario
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField("Generación automática");
        idField.setEditable(false);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField();

        JLabel dniNieLabel = new JLabel("DNI/NIE:");
        dniNieField = new JTextField();

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel tratamientoLabel = new JLabel("Tratamiento:");
        tratamientoComboBox = new JComboBox<>(new String[]{"Ninguno", "Implantes Dentales", "Ortodencia y Brackets", "Blanqueamiento Dental", "Estética Dental", "Rehabilitación Oral","Odontopediatría"});

        JLabel fechaRegistroLabel = new JLabel("Fecha de Registro:");
        fechaRegistroChooser = new JDateChooser();

        JLabel fechaVisitaLabel = new JLabel("Fecha de Visita:");
        fechaVisitaChooser = new JDateChooser();

        // Botones
        enviarButton = new JButton("Enviar");
        buscarButton = new JButton("Buscar por ID");

        // Añadir los componentes a la ventana
        add(idLabel);
        add(idField);

        add(nombreLabel);
        add(nombreField);

        add(apellidoLabel);
        add(apellidoField);

        add(dniNieLabel);
        add(dniNieField);

        add(telefonoLabel);
        add(telefonoField);

        add(emailLabel);
        add(emailField);

        add(tratamientoLabel);
        add(tratamientoComboBox);

        add(fechaRegistroLabel);
        add(fechaRegistroChooser);

        add(fechaVisitaLabel);
        add(fechaVisitaChooser);

        add(enviarButton);
        add(buscarButton);

        // Acción del botón enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenarDatos();  // Aquí llamamos al método almacenarDatos()
            }
        });

        // Acción del botón buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Busqueda_ID().setVisible(true); // Abre la ventana de búsqueda
            }
        });

        setLocationRelativeTo(null);  // Centrar la ventana
    }

    private void almacenarDatos() {
        String id = idField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dniNie = dniNieField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();
        String tratamiento = (String) tratamientoComboBox.getSelectedItem();
        java.util.Date fechaRegistro = fechaRegistroChooser.getDate();
        java.util.Date fechaVisita = fechaVisitaChooser.getDate();

        
        // Validación de los campos obligatorios
        if (nombre.isEmpty() || apellido.isEmpty() || dniNie.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si hay campos vacíos
        }

        // Validación del campo tratamiento
        if (tratamiento.equals("Ninguno")) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un tratamiento válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si el tratamiento es "Ninguno"
        }
        // Validar que la fecha de registro y la fecha de visita no sean nulas
        if (fechaRegistro == null || fechaVisita == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione las fechas de registro y visita.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir del método si las fechas son nulas
        }
        
        // Aquí se hace la conexión y se guarda en la base de datos (ver parte de la conexión)
        // Llamada a una clase que se encargue de la conexión y consulta a la base de datos
        // Ejemplo: ConexionBaseDeDatos.guardarRegistro(id, nombre, apellido, dniNie, telefono, email, tratamiento, fechaRegistro, fechaVisita);
        // Llamada al método para guardar en la base de datos
        Conexion.guardarRegistro(nombre, apellido, dniNie, telefono, email, tratamiento, fechaRegistro, fechaVisita);
            JOptionPane.showMessageDialog(this, "Los datos se han registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarPorId() {
    String id = idField.getText();
    
    // Verifica si el ID no está vacío o no contiene caracteres no válidos antes de buscarlo.
    if (!id.isEmpty()) {
        // Crea la ventana Buscar, pasando solo el ID
        new Buscar(id).setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clinica_dental_proyecto().setVisible(true);
            }
        });
    }
}