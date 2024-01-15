/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme.zaposleni;

import domen.Odeljenje;
import domen.Partner;
import domen.Zaposleni;
import forme.modeli.tabela.ModelTabelePartner;
import forme.modeli.tabela.ModelTabeleZaposleni;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class FormaObrisiZaposlenog extends javax.swing.JFrame {

    private Zaposleni izabraniZaposleni;

    /**
     * Creates new form FormaIzmeniZaposlenog
     */
    public FormaObrisiZaposlenog() {
        initComponents();
        setLocationRelativeTo(null);
        postaviModelTabele();
        popuniTabeluSvimZaposlenim();
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
        txtVrednostPretrage = new javax.swing.JTextField();
        btnPonadji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZaposleni = new javax.swing.JTable();
        btnUcitajZaposlenog = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtGodineStaza = new javax.swing.JTextField();
        btnObrisiZaposlenog = new javax.swing.JButton();
        txtOdeljenje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Obriši zaposlenog");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pronađi zaposlenog"));

        btnPonadji.setText("Pronađi");
        btnPonadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonadjiActionPerformed(evt);
            }
        });

        tblZaposleni.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblZaposleni);

        btnUcitajZaposlenog.setText("Učitaj zaposlenog");
        btnUcitajZaposlenog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajZaposlenogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUcitajZaposlenog, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtVrednostPretrage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPonadji, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVrednostPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPonadji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUcitajZaposlenog)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Zaposleni"));

        jLabel1.setText("JMBG:");

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        jLabel4.setText("Godine staža:");

        jLabel5.setText("Odeljenje:");

        txtJMBG.setEditable(false);
        txtJMBG.setFocusable(false);

        txtIme.setEditable(false);
        txtIme.setFocusable(false);
        txtIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeActionPerformed(evt);
            }
        });

        txtPrezime.setEditable(false);
        txtPrezime.setFocusable(false);
        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        txtGodineStaza.setEditable(false);
        txtGodineStaza.setFocusable(false);
        txtGodineStaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGodineStazaActionPerformed(evt);
            }
        });

        btnObrisiZaposlenog.setText("Obriši zaposlenog");
        btnObrisiZaposlenog.setEnabled(false);
        btnObrisiZaposlenog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiZaposlenogActionPerformed(evt);
            }
        });

        txtOdeljenje.setEditable(false);
        txtOdeljenje.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnObrisiZaposlenog, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJMBG, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(txtGodineStaza)
                            .addComponent(txtOdeljenje))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGodineStaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtOdeljenje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnObrisiZaposlenog)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeActionPerformed

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void txtGodineStazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGodineStazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGodineStazaActionPerformed

    private void btnUcitajZaposlenogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajZaposlenogActionPerformed
        int izabraniRed = tblZaposleni.getSelectedRow();
        if (izabraniRed == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da učita zaposlenog.", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            ModelTabeleZaposleni mtz = (ModelTabeleZaposleni) tblZaposleni.getModel();
            izabraniZaposleni = mtz.vratiZaposlenog(izabraniRed);
            popuniPodatkeZaposlenog(izabraniZaposleni);
            btnObrisiZaposlenog.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Sistem je učitao zaposlenog.", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUcitajZaposlenogActionPerformed

    private void btnPonadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonadjiActionPerformed
        String uslov = txtVrednostPretrage.getText();
        ArrayList<Zaposleni> listaZaposlenih = kontroler.KontorlerKIZaposleni.getInstance().vratiZaposleneSaUslovom(uslov);
        if (listaZaposlenih != null && !listaZaposlenih.isEmpty()) {
            ModelTabeleZaposleni mtz = (ModelTabeleZaposleni) tblZaposleni.getModel();
            mtz.setLista(listaZaposlenih);
            JOptionPane.showMessageDialog(this, "Sistem je našao zaposlene po zadatoj vrednosti.", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe zaposlene po zadatoj vrednosti", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnPonadjiActionPerformed

    private void btnObrisiZaposlenogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiZaposlenogActionPerformed
        boolean uspesnaIzmena = kontroler.KontorlerKIZaposleni.getInstance().obrisiZaposlenog(izabraniZaposleni);
        if (uspesnaIzmena) {
            JOptionPane.showMessageDialog(this, "Sistem je obrisao zaposlenog", konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da obriše zaposlenog", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
        }
        popuniTabeluSvimZaposlenim();
    }//GEN-LAST:event_btnObrisiZaposlenogActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisiZaposlenog;
    private javax.swing.JButton btnPonadji;
    private javax.swing.JButton btnUcitajZaposlenog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZaposleni;
    private javax.swing.JTextField txtGodineStaza;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtOdeljenje;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtVrednostPretrage;
    // End of variables declaration//GEN-END:variables

    private void postaviModelTabele() {
        ModelTabeleZaposleni mtz = new ModelTabeleZaposleni();
        tblZaposleni.setModel(mtz);
    }

    private void popuniTabeluSvimZaposlenim() {
        ArrayList<Zaposleni> listaSvihZaposlnih = kontroler.KontorlerKIZaposleni.getInstance().vratiSveZaposlene();
        if (listaSvihZaposlnih != null) {
            ModelTabeleZaposleni mtz = (ModelTabeleZaposleni) tblZaposleni.getModel();
            mtz.setLista(listaSvihZaposlnih);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može ucita zaposlene", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

   

    private void popuniPodatkeZaposlenog(Zaposleni izabraniZaposleni) {
        txtJMBG.setText(izabraniZaposleni.getJmbg());
        txtIme.setText(izabraniZaposleni.getIme());
        txtPrezime.setText(izabraniZaposleni.getPrezime());
        txtGodineStaza.setText(String.valueOf(izabraniZaposleni.getStaz()));
        txtOdeljenje.setText(izabraniZaposleni.getOdeljenje().getNaziv());
    }
}
