/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package example;

import java.sql.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelEstym = new javax.swing.JLabel();
        labelIDJuego = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        textoTitulo = new javax.swing.JTextField();
        labelGenero = new javax.swing.JLabel();
        textoGenero = new javax.swing.JTextField();
        labelLanzamiento = new javax.swing.JLabel();
        textoLanzamiento = new javax.swing.JTextField();
        labelDeasrrollador = new javax.swing.JLabel();
        labelDesarrollador = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        listaJuegos = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(73, 142, 235));

        labelEstym.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        labelEstym.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstym.setText("Estym");
        labelEstym.setToolTipText("");
        labelEstym.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelEstym.setDisabledIcon(null);
        labelEstym.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelEstym.setVerifyInputWhenFocusTarget(false);

        labelIDJuego.setText("ID Juego");

        labelTitulo.setText("Titulo del Videojuego");

        labelGenero.setText("ID Genero");

        labelLanzamiento.setText("Lanzamiento");

        labelDeasrrollador.setText("Desarrollador");

        btnView.setText("Ver Juegos");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnInsert.setText("Ingresar");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(labelIDJuego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTitulo)
                                    .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelGenero)))
                            .addComponent(btnView))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInsert)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLanzamiento)
                                    .addComponent(textoLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDeasrrollador)
                                    .addComponent(labelDesarrollador, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(listaJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(labelEstym)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelEstym)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDJuego)
                    .addComponent(labelTitulo)
                    .addComponent(labelGenero)
                    .addComponent(labelLanzamiento)
                    .addComponent(labelDeasrrollador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDesarrollador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnDelete)
                            .addComponent(btnCancel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnView)))
                .addGap(11, 11, 11)
                .addComponent(listaJuegos, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        textoID.setText("");
        textoTitulo.setText("");
        textoGenero.setText("");
        textoLanzamiento.setText("");
        labelDesarrollador.setText("");

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Connection connection = Conexion.obtenerConexion()) {
            String query = "DELETE FROM juegos WHERE id_juego = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(textoID.getText()));
            statement.executeUpdate();
            showMessageDialog(this,
                "Eliminacion del videojuego completa.",
                "Eliminacion Completa",
                INFORMATION_MESSAGE);
            textoID.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if("".equals(labelTitulo.getText()) || "".equals(labelGenero.getText()) || "".equals(labelLanzamiento.getText()) || "".equals(labelDesarrollador.getText())){
            showMessageDialog(this,
                "Todos los campos son requeridos para ingresar un juego.",
                "Intente Otra Vez",
                ERROR_MESSAGE);
            return;}

        try (Connection connection = Conexion.obtenerConexion()) {
            String query = "INSERT INTO juegos (titulo, id_genero, lanzamiento, desarrollador) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, labelTitulo.getText());
            statement.setInt(2, Integer.parseInt(labelGenero.getText()));
            statement.setDate(3, Date.valueOf(labelLanzamiento.getText()));
            statement.setString(4, labelDesarrollador.getText());
            statement.executeUpdate();

            showMessageDialog(this,
                "Ingreso del videojuego completo.",
                "Insercion Completa",
                INFORMATION_MESSAGE);
            textoTitulo.setText("");
            textoGenero.setText("");
            textoLanzamiento.setText("");
            labelDesarrollador.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        try (Connection connection = Conexion.obtenerConexion()) {
            String query = "SELECT * FROM juegos";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            listaJuegos.setText("");
            while (resultSet.next()) {
                listaJuegos.append(resultSet.getInt("id_juego") + " - " +
                    resultSet.getString("titulo") + " - " +
                    resultSet.getInt("id_genero") + " - " +
                    resultSet.getString("lanzamiento") + " - " +
                    resultSet.getString("desarrollador") + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnViewActionPerformed

    public static void main(String[] args) {
        new TPO_Viernes();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDeasrrollador;
    private javax.swing.JTextField labelDesarrollador;
    private javax.swing.JLabel labelEstym;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelIDJuego;
    private javax.swing.JLabel labelLanzamiento;
    private javax.swing.JLabel labelTitulo;
    private java.awt.TextArea listaJuegos;
    private javax.swing.JTextField textoGenero;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoLanzamiento;
    private javax.swing.JTextField textoTitulo;
    // End of variables declaration//GEN-END:variables
}
