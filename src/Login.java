package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                dispose();
                register register = new register(null);
            }
        });
        btInicioSesion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String usuario = tfusuario.getText();
                String contrasenia = new String(pfcontrasenia.getPassword());

                resultado = getAuthenticatedUser(usuario,contrasenia);
                if (!resultado.isEmpty()) {
                    JOptionPane.showMessageDialog(loginPanel, "Bienvenido a Estym, "+ resultado.get(0),
                            "Bienvenido",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new TPO_Viernes();

                }
                else {
                    JOptionPane.showMessageDialog(loginPanel,
                            "Usuario o Contraseña incorrecta",
                            "Pruebe otra vez",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }

    public List<String> resultado;

    private List<String> getAuthenticatedUser(String usuario, String contrasenia){
        resultado = new ArrayList<>();
        try(Connection connection = obtenerConexion()) {
            PreparedStatement is = connection.prepareStatement("select * from usuarios where usuario = ? and contrasenia = ?");
            is.setString(1, usuario);
            is.setString(2, contrasenia);
            ResultSet rs = is.executeQuery();
            if(rs.next()){
                 String usuario1 = rs.getString("usuario");
                 resultado.add(usuario1);
                 String contra = rs.getString("contrasenia");
                 resultado.add(contra);
            }
        }
        catch (SQLException e){System.err.println("Error al ingresar usuario: " + e.getMessage());}
        return resultado;
    }

    public static void main(String[] args) {
        Login login = new Login(null);
    }

}
