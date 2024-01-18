/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli.tabela;

import domen.Kampanja;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class ModelTabeleKampanja extends AbstractTableModel{
    ArrayList<Kampanja> lista = new ArrayList<>();
    String[] naziviKolona = {"Naziv","Partner","Glavni odgovorni","Datum početka","Datum završetka"};

    public void setLista(ArrayList<Kampanja> lista) {
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
       Kampanja  k = lista.get(rowIndex);
       SimpleDateFormat sdf = Konstante.SIMPLE_DATE_FORMAT;
        switch (columnIndex) {
            case 0: return k.getNaziv();
            case 1: return k.getPartner().getNaziv();
            case 2: return k.getOdgovorniZaposleni().toString();
            case 3: return sdf.format(k.getDatumPocetka());
            case 4: return sdf.format(k.getDatumZavrsetka());
            default: return "N/A";
        }
        
    }

    public Kampanja vratiKampanju(int izabraniRed) {
        return lista.get(izabraniRed);
    }

    
    
}
