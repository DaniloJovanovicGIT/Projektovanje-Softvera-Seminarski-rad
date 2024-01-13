/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Partner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Odgovor;
import komunikacija.VrstaOdgovora;
import kontroler.KontrolerKIPartner;

/**
 *
 * @author Danilo
 */
public class FormaKreirajPartnera extends javax.swing.JFrame {

    KontrolerKIPartner kkip;

    /**
     * Creates new form KreirajPartnera
     */
    public FormaKreirajPartnera() {
        initComponents();
        setLocationRelativeTo(null);
        kkip = KontrolerKIPartner.getInstance();
        kkip.setFkp(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblPIB = new javax.swing.JLabel();
        lblNaziv = new javax.swing.JLabel();
        lblDatumOsnivanja = new javax.swing.JLabel();
        lblKontaktOsoba = new javax.swing.JLabel();
        lblBrojTelefona = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtPIB = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtDatumOsnivanja = new javax.swing.JTextField();
        txtKontaktOsoba = new javax.swing.JTextField();
        txtBrojTelefona = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnKreirajPartnera = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kreiraj partnera");

        lblPIB.setText("PIB:");

        lblNaziv.setText("Naziv:");

        lblDatumOsnivanja.setText("Datum osnivanja:");

        lblKontaktOsoba.setText("Kontakt osoba:");

        lblBrojTelefona.setText("Broj telefona:");

        lblEmail.setText("Email:");

        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        btnKreirajPartnera.setText("Kreiraj partnera");
        btnKreirajPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajPartneraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDatumOsnivanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPIB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKontaktOsoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBrojTelefona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKreirajPartnera, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPIB)
                        .addComponent(txtNaziv)
                        .addComponent(txtDatumOsnivanja)
                        .addComponent(txtKontaktOsoba)
                        .addComponent(txtBrojTelefona)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPIB)
                    .addComponent(txtPIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatumOsnivanja)
                    .addComponent(txtDatumOsnivanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktOsoba)
                    .addComponent(txtKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojTelefona)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKreirajPartnera)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivActionPerformed

    private void btnKreirajPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajPartneraActionPerformed
        String pib = txtPIB.getText();
        String naziv = txtNaziv.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date datumOsnivanja = null;
        try {
            datumOsnivanja = sdf.parse(txtDatumOsnivanja.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti u formatu dd.MM.yyyy", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            return;
        }
        String kontaktOsoba = txtKontaktOsoba.getText();
        String brojTelefona = txtBrojTelefona.getText();
        String email = txtEmail.getText();

        kkip.kreirajPartnera(new Partner(pib, naziv, datumOsnivanja, kontaktOsoba, brojTelefona, email));

        //JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti partnera.", "Došlo je do greške.", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnKreirajPartneraActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreirajPartnera;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBrojTelefona;
    private javax.swing.JLabel lblDatumOsnivanja;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblKontaktOsoba;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblPIB;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtDatumOsnivanja;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKontaktOsoba;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPIB;
    // End of variables declaration//GEN-END:variables

    public void obradiServerskiOdgovor(Odgovor odgovor) {
        if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio partnera.", "Operacija uspešno obavljena.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti partnera.", "Došlo je do greške.", JOptionPane.ERROR_MESSAGE);
        }
        vratiVrednostiNaPodrazumevane();
    }

    private void vratiVrednostiNaPodrazumevane() {
        txtPIB.setText("");
        txtNaziv.setText("");
        txtDatumOsnivanja.setText("");
        txtKontaktOsoba.setText("");
        txtBrojTelefona.setText("");
        txtEmail.setText("");
    }
}
