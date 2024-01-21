/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme.partner;

import domen.Partner;
import forme.modeli.tabela.ModelTabelePartner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class FormaObrisiPartnera extends javax.swing.JFrame {

    Partner izabraniPartner;

    /**
     * Creates new form FormaIzmeniPartnera
     */
    public FormaObrisiPartnera() {
        initComponents();
        setLocationRelativeTo(null);
        postaviModelTabele();
        popuniTabeluSvimPartnerima();
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
        txtPretrazi = new javax.swing.JTextField();
        btnPronadji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartneri = new javax.swing.JTable();
        txtIzaberiPartnera = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        btnObrisiPartnera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Obriši partnera");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pronadji partnera"));

        btnPronadji.setText("Pronadji");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        tblPartneri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPartneri);

        txtIzaberiPartnera.setText("Učitaj partnera");
        txtIzaberiPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIzaberiPartneraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPretrazi)
                                .addGap(18, 18, 18)
                                .addComponent(btnPronadji))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 180, Short.MAX_VALUE)
                                .addComponent(txtIzaberiPartnera, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPronadji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIzaberiPartnera))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Partner"));

        lblPIB.setText("PIB:");

        lblNaziv.setText(" Naziv:");

        lblDatumOsnivanja.setText("Datum osnivanja:");

        lblKontaktOsoba.setText("Kontakt osoba:");

        lblBrojTelefona.setText("Broj telefona:");

        lblEmail.setText("Email:");

        txtPIB.setEditable(false);
        txtPIB.setFocusable(false);

        txtNaziv.setEditable(false);
        txtNaziv.setFocusable(false);

        txtDatumOsnivanja.setEditable(false);
        txtDatumOsnivanja.setFocusable(false);

        txtKontaktOsoba.setEditable(false);
        txtKontaktOsoba.setFocusable(false);
        txtKontaktOsoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontaktOsobaActionPerformed(evt);
            }
        });

        txtBrojTelefona.setEditable(false);
        txtBrojTelefona.setFocusable(false);

        txtEmail.setEditable(false);
        txtEmail.setFocusable(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnObrisiPartnera.setText("Obriši partnera");
        btnObrisiPartnera.setEnabled(false);
        btnObrisiPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPartneraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnObrisiPartnera, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDatumOsnivanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKontaktOsoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBrojTelefona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPIB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPIB)
                            .addComponent(txtNaziv)
                            .addComponent(txtDatumOsnivanja)
                            .addComponent(txtKontaktOsoba)
                            .addComponent(txtBrojTelefona)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPIB)
                    .addComponent(txtPIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatumOsnivanja)
                    .addComponent(txtDatumOsnivanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktOsoba)
                    .addComponent(txtKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojTelefona)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisiPartnera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKontaktOsobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontaktOsobaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKontaktOsobaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtIzaberiPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIzaberiPartneraActionPerformed
        int izabraniRed = tblPartneri.getSelectedRow();
        if (izabraniRed == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da učita partnera.", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            this.dispose();
        } else {
            ModelTabelePartner mtp = (ModelTabelePartner) tblPartneri.getModel();
            izabraniPartner = mtp.vratiPartnera(izabraniRed);
            popuniPodatkePartnera(izabraniPartner);
            JOptionPane.showMessageDialog(this, "Sistem je učitao partnera.", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
            btnObrisiPartnera.setEnabled(true);
        }
    }//GEN-LAST:event_txtIzaberiPartneraActionPerformed

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed
        String uslov = txtPretrazi.getText();
        ArrayList<Partner> listaPartnera = kontroler.KontrolerKIPartner.getInstance().vratiPartnereSaUslovom(uslov);
        if (listaPartnera != null && !listaPartnera.isEmpty()) {
            ModelTabelePartner mtp = (ModelTabelePartner) tblPartneri.getModel();
            mtp.setLista(listaPartnera);
            JOptionPane.showMessageDialog(this, "Sistem je našao partnere po zadatoj vrednosti.", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe partnere po zadatoj vrednosti", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnObrisiPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPartneraActionPerformed
        Partner partnerZaBrisanje = izabraniPartner;
        boolean uspesnoBrisanje = kontroler.KontrolerKIPartner.getInstance().obrisiPartnera(partnerZaBrisanje);
        if (uspesnoBrisanje) {
            JOptionPane.showMessageDialog(this, "Sistem je obrisao partnera", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da obriše partnera", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnObrisiPartneraActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisiPartnera;
    private javax.swing.JButton btnPronadji;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojTelefona;
    private javax.swing.JLabel lblDatumOsnivanja;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblKontaktOsoba;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblPIB;
    private javax.swing.JTable tblPartneri;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtDatumOsnivanja;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JButton txtIzaberiPartnera;
    private javax.swing.JTextField txtKontaktOsoba;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPIB;
    private javax.swing.JTextField txtPretrazi;
    // End of variables declaration//GEN-END:variables

    private void postaviModelTabele() {
        ModelTabelePartner mtp = new ModelTabelePartner();
        tblPartneri.setModel(mtp);
    }

    private void popuniTabeluSvimPartnerima() {
        ArrayList<Partner> listaSvihPartnera = kontroler.KontrolerKIPartner.getInstance().vratiSvePartnere();
        if (listaSvihPartnera != null) {
            ModelTabelePartner mtp = (ModelTabelePartner) tblPartneri.getModel();
            mtp.setLista(listaSvihPartnera);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može ucita partnere", Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    private void popuniPodatkePartnera(Partner izabraniPartner) {
        txtPIB.setText(izabraniPartner.getPib());
        txtNaziv.setText(izabraniPartner.getNaziv());
        SimpleDateFormat sdf = Konstante.SIMPLE_DATE_FORMAT;
        txtDatumOsnivanja.setText(sdf.format(izabraniPartner.getDatumOsnivanja()));
        txtKontaktOsoba.setText(izabraniPartner.getKontaktOsoba());
        txtBrojTelefona.setText(izabraniPartner.getBrojTelefona());
        txtEmail.setText(izabraniPartner.getEmail());
    }
}
