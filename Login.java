package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static example.Conexion.obtenerConexion;

public class Login extends JDialog {
    private JTextField tfusuario;
    private JPasswordField pfcontrasenia;
    private JButton btInicioSesion;
    private JPanel loginPanel;
    private JButton btnRegistro;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(670,475));
        setLocationRelativeTo(null);
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register register = new register(parent);
                loginPanel.setVisible(false);
            }
        });
        btInicioSesion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String usuario = tfusuario.getText();
                String contrasenia = pfcontrasenia.getPassword().toString();

                if (getAuthenticatedUser(usuario,contrasenia)) {
                    JOptionPane.showMessageDialog(loginPanel, "Bienvenido a Estym",
                            "Bienvenido",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Usuario o Contraseña incorrecta",
                            "Pruebe otra vez",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
    Usuario user;
    private boolean getAuthenticatedUser(String usuario, String contrasenia){
        boolean resultado = false;
        try(Connection connection = obtenerConexion()) {
            PreparedStatement iniciosesion = connection.prepareStatement("SELECT * FROM usuarios WHERE (email = ? or usuario = ?) AND contrasenia = ?");

            iniciosesion.setString(1, usuario);
            iniciosesion.setString(2, usuario);
            iniciosesion.setString(3, contrasenia);

            ResultSet resultSet = iniciosesion.executeQuery();

            while (resultSet.next()){
                if ((resultSet.getString("usuario").equals(usuario) ||
                        resultSet.getString("email").equals(usuario)) &&
                        resultSet.getString("contrasenia").equals(contrasenia)){
                    resultado = true;
                }
            }
        }
        catch (SQLException e){System.err.println("Error al ingresar usuario: " + e.getMessage());}
        return resultado;
    }

    public static void main(String[] args) {
        Login login = new Login(null);
        Usuario user = login.user;
    }

}
