package com.mycompany.clinica_dental_proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class Clinica_dental_proyecto extends JFrame {
    private JTextField idField, nombreField, apellidoField, dniNieField, telefonoField, emailField;
    private JComboBox<String> tratamientoComboBox;
    private JDateChooser fechaRegistroChooser, fechaVisitaChooser;
    private JButton enviarButton, buscarButton;

    private final Color morado = new Color(115, 93, 165);
    private final Font fuenteBase = new Font("Segoe UI", Font.PLAIN, 16);

    public Clinica_dental_proyecto() {
        setTitle("Clínica Dental Sonría – Registro");
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(237, 233, 250)); 

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        gbc.gridx = 0; gbc.gridy = y;
        panel.add(label("ID:"), gbc);
        gbc.gridx = 1;
        idField = textField("Generación automática", false);
        panel.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Nombre:"), gbc);
        gbc.gridx = 1;
        nombreField = textField("", true);
        panel.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Apellido:"), gbc);
        gbc.gridx = 1;
        apellidoField = textField("", true);
        panel.add(apellidoField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("DNI/NIE:"), gbc);
        gbc.gridx = 1;
        dniNieField = textField("", true);
        panel.add(dniNieField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Teléfono:"), gbc);
        gbc.gridx = 1;
        telefonoField = textField("", true);
        panel.add(telefonoField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Email:"), gbc);
        gbc.gridx = 1;
        emailField = textField("", true);
        panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Tratamiento:"), gbc);
        gbc.gridx = 1;
        tratamientoComboBox = new JComboBox<>(new String[]{
                "Ninguno", "Implantes Dentales", "Ortodencia y Brackets", "Blanqueamiento Dental",
                "Estética Dental", "Rehabilitación Oral", "Odontopediatría"
        });
        tratamientoComboBox.setFont(fuenteBase);
        tratamientoComboBox.setBackground(Color.WHITE);
        tratamientoComboBox.setBorder(BorderFactory.createLineBorder(morado, 1, true));
        panel.add(tratamientoComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Fecha de Registro:"), gbc);
        gbc.gridx = 1;
        fechaRegistroChooser = new JDateChooser();
        fechaRegistroChooser.setFont(fuenteBase);
        fechaRegistroChooser.setBorder(BorderFactory.createLineBorder(morado, 1, true));
        panel.add(fechaRegistroChooser, gbc);

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(label("Fecha de Visita:"), gbc);
        gbc.gridx = 1;
        fechaVisitaChooser = new JDateChooser();
        fechaVisitaChooser.setFont(fuenteBase);
        fechaVisitaChooser.setBorder(BorderFactory.createLineBorder(morado, 1, true));
        panel.add(fechaVisitaChooser, gbc);

        // Botones
        enviarButton = boton("Enviar");
        buscarButton = boton("Buscar por ID");

        gbc.gridx = 0; gbc.gridy = ++y;
        panel.add(enviarButton, gbc);
        gbc.gridx = 1;
        panel.add(buscarButton, gbc);

        // Acciones
        enviarButton.addActionListener(e -> almacenarDatos());
        buscarButton.addActionListener(e -> new Busqueda_ID().setVisible(true));

        add(panel);
    }

    private JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setFont(fuenteBase.deriveFont(Font.BOLD));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private JTextField textField(String texto, boolean editable) {
        JTextField field = new JTextField(texto);
        field.setFont(fuenteBase);
        field.setEditable(editable);
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(morado, 1, true));
        return field;
    }

    private JButton boton(String texto) {
        JButton button = new JButton(texto);
        button.setFont(fuenteBase.deriveFont(Font.BOLD));
        button.setBackground(morado);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(morado.darker(), 1));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void almacenarDatos() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dniNie = dniNieField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();
        String tratamiento = (String) tratamientoComboBox.getSelectedItem();
        Date fechaRegistro = fechaRegistroChooser.getDate();
        Date fechaVisita = fechaVisitaChooser.getDate();

        if (nombre.isEmpty() || apellido.isEmpty() || dniNie.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tratamiento.equals("Ninguno")) {
            JOptionPane.showMessageDialog(this, "Seleccione un tratamiento válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fechaRegistro == null || fechaVisita == null) {
            JOptionPane.showMessageDialog(this, "Seleccione ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Conexion.guardarRegistro(nombre, apellido, dniNie, telefono, email, tratamiento, fechaRegistro, fechaVisita);
        JOptionPane.showMessageDialog(this, "Datos registrados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Clinica_dental_proyecto().setVisible(true));
    }
}
