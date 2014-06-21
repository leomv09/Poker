/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;

public class Jugador {
    String Id;
    int dinero;
    Mano manoJugador;
    
    public Jugador(String id)
    {
        this.Id=id;
        this.dinero=20;
    }
    public void setId(String id)
    {
        this.Id=id;
    }
            
    
    public String getId()
    {
        return Id; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Carta> getCartas()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
