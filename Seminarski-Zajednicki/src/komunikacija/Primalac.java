/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Primalac {
    private Socket soket;
    private ObjectInputStream ulaz;

    public Primalac(Socket socket) throws IOException {
        this.soket = socket;
        this.ulaz = new ObjectInputStream(socket.getInputStream());
    }
    
    public Object primi() throws Exception{
        return ulaz.readObject();
    }
    public void zatvori() throws IOException{
        ulaz.close();
    }
}
