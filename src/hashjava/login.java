package hashjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jessd
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Connection cn;
    public Statement st = null;
    String hash;

    public login() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hashtable", "root", "");
            st = cn.createStatement();
            JOptionPane.showMessageDialog(null, "Connected");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not Connected");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        usuariotxt = new javax.swing.JTextField();
        contratxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jButton1.setText("Hash");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        usuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariotxtActionPerformed(evt);
            }
        });

        contratxt.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuariotxt)
                            .addComponent(contratxt, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            crearHash();
            String sql = "INSERT INTO usuarios (nombre, contra, hash) VALUES ('" + usuariotxt.getText() + "', '" + contratxt.getText() + "', '" + hash + "');";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Insert Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert into table was interrumped.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariotxtActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contratxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField usuariotxt;
    // End of variables declaration//GEN-END:variables

    private void crearHash() {
        String psw = contratxt.getText();
        long dec, digito = 0;
        char[] abecedario = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n'};
        int x = psw.length() - 1;
        int a = 10;
        int c = 20;
        int m = 30;
        String cadena = "";

        // Convertir vocales en numeros
        psw = psw.replace("a", "4");
        psw = psw.replace("e", "3");
        psw = psw.replace("i", "1");
        psw = psw.replace("o", "0");
        // formula
        x = (x * a + c) % m;
        hash = psw + Integer.toString(x);

        // convertir a binario
        binario();

        // Convertir a decimal
        dec = 0;
        System.out.println(hash + " asignacion");
        double multiplicador;
        char carac;
        for(int s = 0; s <= hash.length()-1; s++){
            carac = hash.charAt(s);
            digito = (long) carac;
            multiplicador = Math.pow(2, digito);
            dec += digito * multiplicador;
        }
        System.out.println(hash + " a decimal 1");
        hash = Long.toString(dec);
        System.out.println(hash + " a decimal");
        // convertir a letras
        hash = hash.substring(0, 10);
        int rou = Integer.parseInt(hash);
        int dig = rou % 10, d1 = 0;
        cadena += cadena + abecedario[dig];
        for (int w = 0; w <= hash.length() - 1; w++) {
            dig = rou / 10;
            d1 = dig % 10;
            rou = dig;
            cadena += cadena + abecedario[d1];
        }
        hash = cadena;
        System.out.println(hash + " Convertido a abecedario");
    }

    ////////////////////////////////
    public void binario() {
        String n, bin = "";
        int x = 0;
        for (int i = 0; i < hash.length(); i++) {
            x = hash.charAt(i);
            n = Integer.toBinaryString(x);
            bin = bin + n;
        }
        hash = bin;
    }
    /////////////////////////////////
}
