/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme.zaposleni;

import domen.Odeljenje;
import domen.Zaposleni;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.Odgovor;
import komunikacija.VrstaOdgovora;

/**
 *
 * @author Danilo
 */
public class FormaKreirajZaposlenog extends javax.swing.JFrame {

    /**
     * Creates new form FormaKreirajZaposlenog
     */
    public FormaKreirajZaposlenog() {
        initComponents();
        setLocationRelativeTo(null);
        popuniOdeljenja();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJmbg = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblGodineStaza = new javax.swing.JLabel();
        lblOdeljenje = new javax.swing.JLabel();
        txtJmbg = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtGodineStaza = new javax.swing.JTextField();
        cmbOdeljenja = new javax.swing.JComboBox();
        btnSacuvajZaposlenog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kreiraj zaposlenog");

        lblJmbg.setText("JMBG:");

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        lblGodineStaza.setText("Godine radnog staža:");

        lblOdeljenje.setText("Odeljenje");

        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        cmbOdeljenja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvajZaposlenog.setText("Sačuvaj zaposlenog");
        btnSacuvajZaposlenog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajZaposlenogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSacuvajZaposlenog)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGodineStaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJmbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOdeljenje, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJmbg)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(txtGodineStaza)
                            .addComponent(cmbOdeljenja, 0, 240, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJmbg)
                    .addComponent(txtJmbg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGodineStaza)
                    .addComponent(txtGodineStaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOdeljenje)
                    .addComponent(cmbOdeljenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvajZaposlenog)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void btnSacuvajZaposlenogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajZaposlenogActionPerformed
        String jmbg = txtJmbg.getText();
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        int staz = Integer.parseInt(txtGodineStaza.getText());
        Odeljenje odeljenje = (Odeljenje) cmbOdeljenja.getSelectedItem();
        Zaposleni noviZaposleni = new Zaposleni(jmbg, ime, prezime, staz, odeljenje);
        Odgovor odgovor = kontroler.KontorlerKIZaposleni.getInstance().kreirajZaposlenog(noviZaposleni);
        if (odgovor != null && odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
            JOptionPane.showMessageDialog(this, odgovor.getPoruka(), konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti zaposlenog", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajZaposlenogActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajZaposlenog;
    private javax.swing.JComboBox cmbOdeljenja;
    private javax.swing.JLabel lblGodineStaza;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblJmbg;
    private javax.swing.JLabel lblOdeljenje;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JTextField txtGodineStaza;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJmbg;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniOdeljenja() {
        cmbOdeljenja.removeAllItems();
        ArrayList<Odeljenje> svaOdeljenja = kontroler.KontorlerKIZaposleni.getInstance().vratiSvaOdeljenja();
        if (svaOdeljenja != null && !svaOdeljenja.isEmpty()) {
            for (Odeljenje odeljenje : svaOdeljenja) {
                cmbOdeljenja.addItem(odeljenje);
            }
        }
    }
}