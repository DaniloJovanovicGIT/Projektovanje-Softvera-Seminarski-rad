/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

/**
 *
 * @author Danilo
 */
public class Odgovor {
    private Object parametar;
    private String poruka;
    private VrstaOdgovora vrstaOdgovora;

    public Odgovor(Object parametar, String poruka, VrstaOdgovora vrstaOdgovora) {
        this.parametar = parametar;
        this.poruka = poruka;
        this.vrstaOdgovora = vrstaOdgovora;
    }

    public Odgovor() {
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public VrstaOdgovora getVrstaOdgovora() {
        return vrstaOdgovora;
    }

    public void setVrstaOdgovora(VrstaOdgovora vrstaOdgovora) {
        this.vrstaOdgovora = vrstaOdgovora;
    }
    
}
