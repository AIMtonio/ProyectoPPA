
package froms;


import clases.*;
import javax.swing.JOptionPane;


public class ad extends javax.swing.JFrame {

    public ad() {
        initComponents();
        setSize(1280, 720);
        setLocationRelativeTo(null);
//        setIconImage(new ImageIcon(getClass().getResource("../img/logopequeño.png")).getImage());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtfIdGrupo = new javax.swing.JTextField();
        jtfNombreG = new javax.swing.JTextField();
        jtfMateria1 = new javax.swing.JTextField();
        jtfMateria2 = new javax.swing.JTextField();
        jtfMateria3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaGrupos = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtdIdA = new javax.swing.JTextField();
        jtfNombreA = new javax.swing.JTextField();
        jtfApellidosA = new javax.swing.JTextField();
        jtfCurpA = new javax.swing.JTextField();
        jtfUsuarioA = new javax.swing.JTextField();
        jtfContraseñaA = new javax.swing.JTextField();
        jtfIdGrupoA = new javax.swing.JTextField();
        jtfTipoA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel1.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarsesion.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1060, 610, 220, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(330, 60, 850, 550);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventanaadmistrador.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, -10, 650, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo pequeño.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 240, 290, 230);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 700);

        jTabbedPane1.addTab("Principal", jPanel1);

        jPanel3.setLayout(null);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrodegrupos.png"))); // NOI18N
        jPanel3.add(jLabel17);
        jLabel17.setBounds(390, 10, 420, 80);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo pequeño.png"))); // NOI18N
        jPanel3.add(jLabel19);
        jLabel19.setBounds(80, 210, 290, 230);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombre.png"))); // NOI18N
        jPanel3.add(jLabel21);
        jLabel21.setBounds(400, 140, 140, 40);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materia.png"))); // NOI18N
        jPanel3.add(jLabel22);
        jLabel22.setBounds(410, 190, 130, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materia.png"))); // NOI18N
        jPanel3.add(jLabel23);
        jLabel23.setBounds(410, 230, 120, 40);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materia.png"))); // NOI18N
        jPanel3.add(jLabel24);
        jLabel24.setBounds(410, 280, 130, 30);

        jtfIdGrupo.setEditable(false);
        jtfIdGrupo.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.add(jtfIdGrupo);
        jtfIdGrupo.setBounds(540, 100, 150, 30);
        jPanel3.add(jtfNombreG);
        jtfNombreG.setBounds(540, 150, 150, 30);
        jPanel3.add(jtfMateria1);
        jtfMateria1.setBounds(540, 200, 150, 30);
        jPanel3.add(jtfMateria2);
        jtfMateria2.setBounds(540, 240, 150, 30);
        jPanel3.add(jtfMateria3);
        jtfMateria3.setBounds(540, 280, 150, 30);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ID.png"))); // NOI18N
        jPanel3.add(jLabel25);
        jLabel25.setBounds(470, 90, 50, 40);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/escuela.png"))); // NOI18N
        jPanel3.add(jLabel26);
        jLabel26.setBounds(740, 400, 450, 280);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(770, 190, 140, 40);

        jtaGrupos.setEditable(false);
        jtaGrupos.setColumns(20);
        jtaGrupos.setRows(5);
        jScrollPane2.setViewportView(jtaGrupos);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(930, 110, 200, 190);

        jButton5.setText("jButton5");
        jPanel3.add(jButton5);
        jButton5.setBounds(760, 370, 73, 23);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingresar_1.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(430, 360, 150, 40);

        jButton7.setText("jButton5");
        jPanel3.add(jButton7);
        jButton7.setBounds(630, 370, 73, 23);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel3.add(jLabel20);
        jLabel20.setBounds(0, 0, 1280, 690);

        jTabbedPane1.addTab("Registro Grupos", jPanel3);

        jPanel2.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrodealumnos.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(380, 20, 460, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ID.png"))); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(460, 80, 50, 46);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombre.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(390, 120, 141, 47);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apellidos.png"))); // NOI18N
        jPanel2.add(jLabel9);
        jLabel9.setBounds(370, 170, 150, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/curp.png"))); // NOI18N
        jPanel2.add(jLabel10);
        jLabel10.setBounds(430, 200, 90, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ID.png"))); // NOI18N
        jPanel2.add(jLabel11);
        jLabel11.setBounds(450, 460, 60, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contraseña_1.png"))); // NOI18N
        jPanel2.add(jLabel12);
        jLabel12.setBounds(340, 280, 183, 46);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario_1.png"))); // NOI18N
        jPanel2.add(jLabel13);
        jLabel13.setBounds(390, 240, 130, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tipo_1.png"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(430, 500, 90, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo pequeño.png"))); // NOI18N
        jPanel2.add(jLabel15);
        jLabel15.setBounds(40, 270, 300, 250);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alumno1.png"))); // NOI18N
        jPanel2.add(jLabel16);
        jLabel16.setBounds(1010, 260, 230, 270);

        jtdIdA.setEditable(false);
        jtdIdA.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(jtdIdA);
        jtdIdA.setBounds(520, 90, 190, 30);
        jPanel2.add(jtfNombreA);
        jtfNombreA.setBounds(520, 130, 190, 30);
        jPanel2.add(jtfApellidosA);
        jtfApellidosA.setBounds(520, 170, 190, 30);
        jPanel2.add(jtfCurpA);
        jtfCurpA.setBounds(520, 210, 190, 30);
        jPanel2.add(jtfUsuarioA);
        jtfUsuarioA.setBounds(520, 250, 190, 30);
        jPanel2.add(jtfContraseñaA);
        jtfContraseñaA.setBounds(520, 290, 190, 30);
        jPanel2.add(jtfIdGrupoA);
        jtfIdGrupoA.setBounds(510, 460, 190, 30);

        jtfTipoA.setEditable(false);
        jtfTipoA.setText("alumno");
        jPanel2.add(jtfTipoA);
        jtfTipoA.setBounds(510, 500, 190, 30);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(720, 320, 190, 150);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jPanel2.add(jButton1);
        jButton1.setBounds(570, 370, 130, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingresar_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(370, 580, 150, 40);

        jButton3.setText("jButton3");
        jPanel2.add(jButton3);
        jButton3.setBounds(640, 600, 73, 23);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel2.add(jLabel18);
        jLabel18.setBounds(0, 0, 1280, 700);

        jTabbedPane1.addTab("Registro Alumnos", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            //Asignos valores
            //int empleadosId=Integer.parseInt(jtfId.getText());
            String nombreA=jtfNombreA.getText();
            String apellidosA=jtfApellidosA.getText();
            String curpA =jtfCurpA.getText();
            String usuarioA =jtfUsuarioA.getText();
            String contraseñaA =jtfContraseñaA.getText();
            int id_grupo=Integer.parseInt(jtfIdGrupoA.getText());
            String tipoA =jtfTipoA.getText();
            //Envio parametros al contrucctor
            ClaseAlumnos obj= new ClaseAlumnos(nombreA, apellidosA, curpA,usuarioA,contraseñaA,id_grupo,tipoA);
           // obj.setEmpleadosId(empleadosId);
            obj.setNombreA(nombreA);
            obj.setApellidosA(apellidosA);
            obj.setCurpA(curpA);
            obj.setNombreUsuarioA(usuarioA);
            obj.setContraseñaA(contraseñaA);
            obj.setId_grupo(id_grupo);
            obj.setTipo(tipoA);
            obj.insertarAlmunos();
            //jtfId.setText(null);
            jtfNombreA.setText(null);
            jtfApellidosA.setText(null);
            jtfCurpA.setText(null);
            jtfUsuarioA.setText(null);
            jtfContraseñaA.setText(null);
            jtfIdGrupoA.setText(null);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            //Asignos valores
            //int empleadosId=Integer.parseInt(jtfId.getText());
            String nombreG=jtfNombreG.getText();
            String materia1=jtfMateria1.getText();
            String materia2 =jtfMateria2.getText();
            String materia3 =jtfMateria3.getText();
            //Envio parametros al contrucctor
            ClaseGrupos obj= new ClaseGrupos(nombreG,materia1,materia2,materia3);
           // obj.setEmpleadosId(empleadosId);
            obj.setNombreG(nombreG);
            obj.setMateria1(materia1);
            obj.setMateria2(materia2);
            obj.setMateria3(materia3);
            obj.insertarGrupos();
            //jtfId.setText(null);
            jtfNombreG.setText(null);
            jtfMateria1.setText(null);
            jtfMateria2.setText(null);
            jtfMateria3.setText(null);
            JOptionPane.showMessageDialog(null,"Registro correcto");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al registro");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{

            ClaseGrupos obj= new ClaseGrupos();//Objeto de la clase Persona
            obj.verGrupos();
            jtaGrupos.setText(obj.verGrupos());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jtaGrupos;
    private javax.swing.JTextField jtdIdA;
    private javax.swing.JTextField jtfApellidosA;
    private javax.swing.JTextField jtfContraseñaA;
    private javax.swing.JTextField jtfCurpA;
    private javax.swing.JTextField jtfIdGrupo;
    private javax.swing.JTextField jtfIdGrupoA;
    private javax.swing.JTextField jtfMateria1;
    private javax.swing.JTextField jtfMateria2;
    private javax.swing.JTextField jtfMateria3;
    private javax.swing.JTextField jtfNombreA;
    private javax.swing.JTextField jtfNombreG;
    private javax.swing.JTextField jtfTipoA;
    private javax.swing.JTextField jtfUsuarioA;
    // End of variables declaration//GEN-END:variables
}
