package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Conexion.cerrarConexion;
import static org.example.Conexion.obtenerConexion;

public class register extends JDialog{
    private JTextField tfusuario;
    private JTextField tfEmail;
    private JPasswordField pfcontrasenia;
    private JPasswordField pfConfirmPasword;
    private JButton btRegister;
    private JButton btCancel;
    private JPanel registerPanel;

    public register(JFrame parent){
        super(parent);
        setTitle("Create New Account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        btRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String usuario = tfusuario.getText();
        String email = tfEmail.getText();
        String contrasenia = pfcontrasenia.getText();
        String confirmPassword = pfConfirmPasword.getText();

        if(usuario.isEmpty() || email.isEmpty() || contrasenia.isEmpty() || confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "All fields are required",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contrasenia.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Comfirm password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(usuario,email,contrasenia);
        if (user != null) {
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,
                    "Failed to register",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String usuario, String email, String contrasenia) {
        User user = null;
        boolean resultado = false;
        try(Connection connection = obtenerConexion()) {
            PreparedStatement ingresoUsuario = connection.prepareStatement("INSERT INTO usuarios (usuario, email, contrasenia, creacion) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");

            ingresoUsuario.setString(1, usuario);
            ingresoUsuario.setString(2, email);
            ingresoUsuario.setString(3, contrasenia);
            int rowsAffected = ingresoUsuario.executeUpdate();
            System.out.println(rowsAffected + " Usuario registrado correctamente.");

            resultado = rowsAffected > 0;
        }
        catch (SQLException e){
            System.err.println("Error al ingresar usuario: " + e.getMessage());
        }
        finally {
            cerrarConexion();
        }
        return user;
    }

    public static void main(String[] args) {
        register myForm = new register(null);

    }
}
