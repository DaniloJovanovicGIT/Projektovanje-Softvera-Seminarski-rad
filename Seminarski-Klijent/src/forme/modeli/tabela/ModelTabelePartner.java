/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli.tabela;

import domen.Partner;
import domen.Zadatak;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class ModelTabelePartner extends AbstractTableModel{
    ArrayList<Partner> lista = new ArrayList<>();
    String[] naziviKolona = {"Naziv","PIB","Kontakt osoba"};

    public void setLista(ArrayList<Partner> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Partner  p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNaziv();
            case 1: return p.getPib();
            case 2: return p.getKontaktOsoba();
            default: return "N/A";
        }
        
    }

    public Partner vratiPartnera(int izabraniRed) {
        return lista.get(izabraniRed);
    }

    
    
}
