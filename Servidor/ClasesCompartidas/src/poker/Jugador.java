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
    
    public Jugador(String id,int dinero)
    {
        this.Id=id;
        this.dinero=dinero;
    }
    public void setId(String id)
    {
        this.Id=id;
    }
            
    
    public String getId()
    {
        return Id; //To change body of generated methods, choose Tools | Templates.
    }
    public int getDinero()
    {
        return this.dinero;
    }
    
    public List<Carta> getCartas()
    {
        return this.manoJugador.getMano();
    }
    
}
