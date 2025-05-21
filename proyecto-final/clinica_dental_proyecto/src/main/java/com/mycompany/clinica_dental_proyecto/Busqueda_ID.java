/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica_dental_proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carol
 */
public class Busqueda_ID extends JFrame{
    private JTextField idField;
    private JButton enviarButton;

    public Busqueda_ID() {
        setTitle("Buscar Paciente por ID");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        // Componentes de la ventana
        JLabel idLabel = new JLabel("Ingrese ID:");
        idField = new JTextField();

        enviarButton = new JButton("Enviar");

        // Añadir los componentes
        add(idLabel);
        add(idField);
        add(new JLabel()); // Espacio vacío
        add(enviarButton);

        // Acción del botón enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (!id.isEmpty()) {
                    // Pasar el ID a la ventana ResultadoBusqueda
                        new Buscar(id).setVisible(true);
                    dispose(); // Cerrar la ventana de búsqueda
                } else {
                    JOptionPane.showMessageDialog(Busqueda_ID.this, "Por favor, ingrese un ID.");
                }
            }
        });

        setLocationRelativeTo(null); // Centrar la ventana
    }
}
