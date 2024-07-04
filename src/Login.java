package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Conexion.cerrarConexion;
import static org.example.Conexion.obtenerConexion;

public class Login extends JDialog {
    private JTextField tfusuario;
    private JPasswordField pfcontrasenia;
    private JButton btInicioSesion;
    private JPanel loginPanel;
    private JTextField tfEmail;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(670,475));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        btInicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = tfusuario.getText(), mail = tfEmail.getText();
                String contrasenia = String.valueOf(pfcontrasenia.getPassword());

                user = getAuthenticatedUser(usuario,mail,contrasenia);

                if (user != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Usuario o Contraseña incorecta",
                            "Pruebe otra vez",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    Usuario user;
    private Usuario getAuthenticatedUser(String usuario, String mail, String contrasenia){
        Usuario user = null;

        boolean resultado = false;
        try(Connection connection = obtenerConexion()) {
            PreparedStatement iniciosecion = connection.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND password = ? AND email = ?");

            iniciosecion.setString(1, usuario);
            iniciosecion.setString(2, contrasenia);
            System.out.printf("Inicio Secion: %s\n", iniciosecion);

            ResultSet resultSet = iniciosecion.executeQuery();

            if (resultSet.next()){
                user = new Usuario(resultSet.getString("usuario"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));
            }

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
        Login login = new Login(null);
        Usuario user = login.user;
    }
}
