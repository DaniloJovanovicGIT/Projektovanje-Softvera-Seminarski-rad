/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import domen.Menadzer;

/**
 *
 * @author Danilo
 */
public class Sesija {

    private static Sesija instance;
    private Menadzer ulogovaniMenadzer;

    private Sesija() {
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Menadzer getUlogovaniMenadzer() {
        return ulogovaniMenadzer;
    }

    public void setUlogovaniMenadzer(Menadzer ulogovaniMenadzer) {
        this.ulogovaniMenadzer = ulogovaniMenadzer;
    }
}
