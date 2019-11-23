/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import clases.ClaseCalificaciones;
import dataBase.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class Califica extends javax.swing.JFrame {

    /**
     * Creates new form Califica
     */
    public Califica() {
        initComponents();
        mostrar_grupos();
        setSize(577, 444);
         l1.setVisible(false);
            jtCalificacion.setVisible(false);
            jcAlumnos.setVisible(false);
            jbGrabar.setVisible(false);
            jbNuevoGrupo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcGrupos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jcAlumnos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcParcial = new javax.swing.JComboBox<>();
        jtCalificacion = new javax.swing.JTextField();
        jbGrabar = new javax.swing.JButton();
        jbNuevoGrupo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jcGrupos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        jcGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcGruposActionPerformed(evt);
            }
        });
        jPanel1.add(jcGrupos);
        jcGrupos.setBounds(100, 70, 110, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Grupo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 70, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Materia Programación");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 10, 200, 30);

        l1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l1.setText("Alumnos");
        jPanel1.add(l1);
        l1.setBounds(30, 170, 90, 20);

        jcAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        jPanel1.add(jcAlumnos);
        jcAlumnos.setBounds(110, 170, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Parcial a evaluar");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 80, 120, 20);

        jcParcial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Primer Parcial", "Segundo Parcial", "Tercer Parcial" }));
        jcParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcParcialActionPerformed(evt);
            }
        });
        jPanel1.add(jcParcial);
        jcParcial.setBounds(350, 70, 140, 30);

        jtCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCalificacionActionPerformed(evt);
            }
        });
        jPanel1.add(jtCalificacion);
        jtCalificacion.setBounds(260, 210, 140, 30);

        jbGrabar.setText("GRABAR CALIFICACIÓN");
        jbGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGrabarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGrabar);
        jbGrabar.setBounds(70, 310, 170, 30);

        jbNuevoGrupo.setText("Evaluar un Nuevo Grupo");
        jbNuevoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoGrupoActionPerformed(evt);
            }
        });
        jPanel1.add(jbNuevoGrupo);
        jbNuevoGrupo.setBounds(300, 310, 190, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcGruposActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_jcGruposActionPerformed

    private void jtCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCalificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCalificacionActionPerformed

    private void jcParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcParcialActionPerformed
        // TODO add your handling code here:
        if (jcParcial.getSelectedItem().equals("Primer Parcial") ||jcParcial.getSelectedItem().equals("Segundo Parcial") ||
                jcParcial.getSelectedItem().equals("Tercer Parcial")) {
            l1.setVisible(true);
            jtCalificacion.setVisible(true);
            jcAlumnos.setVisible(true);
            jbGrabar.setVisible(true);
            jbNuevoGrupo.setVisible(true);
        }
    }//GEN-LAST:event_jcParcialActionPerformed

    private void jbGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGrabarActionPerformed
        // TODO add your handling code here:
        
            if(jcParcial.getSelectedItem().equals("Primer Parcial")){
                String grupo=String.valueOf(jcGrupos.getSelectedItem());
                String alumno=String.valueOf(jcAlumnos.getSelectedItem());
                String calificacion=jtCalificacion.getText();
                ClaseCalificaciones a=new ClaseCalificaciones(grupo, alumno, calificacion);
                a.agregarPrimer();
                jtCalificacion.setText("");
            }else if (jcParcial.getSelectedItem().equals("Segundo Parcial")) {
                String grupo=String.valueOf(jcGrupos.getSelectedItem());
                String alumno=String.valueOf(jcAlumnos.getSelectedItem());
                String calificacion=jtCalificacion.getText();
                ClaseCalificaciones a=new ClaseCalificaciones(grupo, alumno, calificacion);
                a.agregarSegundo();
                jtCalificacion.setText("");
            }else if (jcParcial.getSelectedItem().equals("Tercer Parcial")){
                String grupo=String.valueOf(jcGrupos.getSelectedItem());
                String alumno=String.valueOf(jcAlumnos.getSelectedItem());
                String calificacion=jtCalificacion.getText();
                ClaseCalificaciones a=new ClaseCalificaciones(grupo, alumno, calificacion);
                a.agregarTercero();
                jtCalificacion.setText("");
            }
        
    }//GEN-LAST:event_jbGrabarActionPerformed

    private void jbNuevoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoGrupoActionPerformed
        // TODO add your handling code here:
            jcGrupos.setSelectedItem("Selecciona");
            jcParcial.setSelectedItem("Selecciona");
            
            jtCalificacion.setText("");
            jcAlumnos.removeAllItems();
            jcAlumnos.addItem("Selecciona");
            l1.setVisible(false);
            jtCalificacion.setVisible(false);
            jcAlumnos.setVisible(false);
            jbGrabar.setVisible(false);
            jbNuevoGrupo.setVisible(false);
    }//GEN-LAST:event_jbNuevoGrupoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Califica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Califica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Califica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Califica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Califica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbGrabar;
    private javax.swing.JButton jbNuevoGrupo;
    private javax.swing.JComboBox<String> jcAlumnos;
    private javax.swing.JComboBox<String> jcGrupos;
    private javax.swing.JComboBox<String> jcParcial;
    private javax.swing.JTextField jtCalificacion;
    private javax.swing.JLabel l1;
    // End of variables declaration//GEN-END:variables

    private void mostrar_grupos() {
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="Select nombreGrupo from grupos";
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                jcGrupos.addItem(registro.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void buscar() {
       // ArrayList<Calificaciones> List=new ArrayList();
        
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select concat(nombre,' ',apellidos) from alumnos where id_grupo="
            + "(select id_grupo from grupos where nombregrupo='"+jcGrupos.getSelectedItem()+"')";
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
              jcAlumnos.addItem(registro.getString(1));
            }    
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}