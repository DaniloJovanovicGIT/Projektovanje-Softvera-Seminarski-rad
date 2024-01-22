/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import config.PostaviParametre;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class FormaKonfiguracijaServera extends javax.swing.JDialog {

    public FormaKonfiguracijaServera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ucitajParametreServera();
        ucitajParametreBaze();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPostaviServer = new javax.swing.JButton();
        txtServerskiPort = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPostaviBazu = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtLokacija = new javax.swing.JTextField();
        btnZatvori = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Konfiguracija servera");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametri servera"));

        jLabel1.setText("Serverski port:");

        btnPostaviServer.setText("Postavi parametre servera");
        btnPostaviServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostaviServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPostaviServer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServerskiPort)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServerskiPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnPostaviServer)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametri za povezivanje sa bazom podataka"));

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jLabel4.setText("Lokacija:");

        btnPostaviBazu.setText("Postavi parametre baze podataka");
        btnPostaviBazu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostaviBazuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addComponent(txtLokacija)
                            .addComponent(txtUsername)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 168, Short.MAX_VALUE)
                        .addComponent(btnPostaviBazu)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLokacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnPostaviBazu)
                .addContainerGap())
        );

        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnZatvori)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnZatvori)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnPostaviServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostaviServerActionPerformed
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(Konstante.LOKACIJA_PARAMETARA_SERVERA);
            // postavi port servera
            String brojPorta = txtServerskiPort.getText().trim();
            if (brojPorta.matches("^\\d+$")) {
                prop.setProperty(Konstante.PORT_SERVERA_KEY, brojPorta);
            } else {
                JOptionPane.showMessageDialog(this, "Polje serverski port mora sadržati samo cifre.", "Došlo je do greške.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // sacuvaj paramtere
            prop.store(output, null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Uspešno postavljeni parametri servera.", "Uspešno izvršeno.", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_btnPostaviServerActionPerformed

    private void btnPostaviBazuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostaviBazuActionPerformed
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(Konstante.LOKACIJA_PARAMETARA_BAZE);
            // postavi parametre baze
            String lokacija = txtLokacija.getText().trim();
            if (!lokacija.isEmpty()) {
                prop.setProperty(Konstante.LOKACIJA_BAZE_KEY, "jdbc:mysql://localhost:3306/seminarski");
            } else {
                JOptionPane.showMessageDialog(this, "Polje lokacija ne sme biti prazno.", "Došlo je do greške.", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String username = txtUsername.getText().trim();
            if (!username.isEmpty()) {
                prop.setProperty(Konstante.USERNAME_BAZA_KEY, "root");
            } else {
                JOptionPane.showMessageDialog(this, "Polje username ne sme biti prazno.", "Došlo je do greške.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String password = txtPassword.getText();
            prop.setProperty(Konstante.PASSWORD_BAZA_KEY, password);
            // sacuvaj postavljene parametre
            prop.store(output, null);

        } catch (IOException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Uspešno postavljeni parametri baze.", "Uspešno izvršeno.", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_btnPostaviBazuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPostaviBazu;
    private javax.swing.JButton btnPostaviServer;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtLokacija;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtServerskiPort;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void ucitajParametreServera() {
        Properties parametri = new Properties();
        try {
            parametri.load(new FileInputStream(Konstante.LOKACIJA_PARAMETARA_SERVERA));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormaKonfiguracijaServera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormaKonfiguracijaServera.class.getName()).log(Level.SEVERE, null, ex);
        }
        String port = parametri.getProperty(Konstante.PORT_SERVERA_KEY);
        txtServerskiPort.setText(port);
    }

    private void ucitajParametreBaze() {
        Properties parametri = new Properties();
        try {
            parametri.load(new FileInputStream(Konstante.LOKACIJA_PARAMETARA_BAZE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormaKonfiguracijaServera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormaKonfiguracijaServera.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = parametri.getProperty(Konstante.USERNAME_BAZA_KEY);
        txtUsername.setText(username);

        String password = parametri.getProperty(Konstante.PASSWORD_BAZA_KEY);
        txtPassword.setText(password);

        String lokacija = parametri.getProperty(Konstante.LOKACIJA_BAZE_KEY);
        txtLokacija.setText(lokacija);
    }

}
