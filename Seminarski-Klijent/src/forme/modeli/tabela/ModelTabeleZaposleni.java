/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli.tabela;

import domen.Zaposleni;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class ModelTabeleZaposleni extends AbstractTableModel{
    ArrayList<Zaposleni> lista = new ArrayList<>();
    String[] naziviKolona = {"Ime","Prezime","JMBG","Odeljenje"};

    public void setLista(ArrayList<Zaposleni> lista) {
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
       Zaposleni  z = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return z.getIme();
            case 1: return z.getPrezime();
            case 2: return z.getJmbg();
            case 3: return z.getOdeljenje().getNaziv();
            default: return "N/A";
        }
        
    }

    public Zaposleni vratiZaposlenog(int izabraniRed) {
        return lista.get(izabraniRed);
    }
    
}
