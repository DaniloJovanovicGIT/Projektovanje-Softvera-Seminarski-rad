/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli.tabela;

import domen.Zadatak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class ModelTabeleZadatak extends AbstractTableModel {

    ArrayList<Zadatak> lista = new ArrayList<>();
    String[] naziviKolona = {"Naziv", "Opis", "Očekivani završetak", "Status zadatka"};

    public void setLista(ArrayList<Zadatak> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public ArrayList<Zadatak> getLista() {
        return lista;
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
        Zadatak z = lista.get(rowIndex);
        SimpleDateFormat sdf = Konstante.SIMPLE_DATE_FORMAT;
        switch (columnIndex) {
            case 0:
                return z.getNaziv();
            case 1:
                return z.getOpis();               
            case 2:
                return sdf.format(z.getOcekivaniZavrsetak());
            case 3:
                return z.getStatusZadatka();
            default:
                return "N/A";
        }

    }

    public Zadatak vratiZadatak(int izabraniRed) {
        return lista.get(izabraniRed);
    }

    public void dodaj(Zadatak noviZadatak) {
        lista.add(noviZadatak);
        fireTableDataChanged();
    }

    public void obrisi(int izabraniRed) {
        lista.remove(izabraniRed);
        fireTableDataChanged();
    }

    public void izmeniIzabraniZadatak(Zadatak noviZadatak, int izabraniRed) {
        Zadatak zadatakZaMenjanje = lista.get(izabraniRed);
        zadatakZaMenjanje.setNaziv(noviZadatak.getNaziv());
        zadatakZaMenjanje.setOpis(noviZadatak.getOpis());
        zadatakZaMenjanje.setOcekivaniZavrsetak(noviZadatak.getOcekivaniZavrsetak());
        zadatakZaMenjanje.setStatusZadatka(noviZadatak.getStatusZadatka());
        fireTableRowsUpdated(izabraniRed, izabraniRed);
    }

}
