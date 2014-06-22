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
    //Parametros de jugador
    String Id;
    int dinero;
    Mano manoJugador;
    
    //Constructor
    public Jugador(String id,int dinero)
    {
        this.Id=id;
        this.dinero=dinero;
    }
    //Metodo para definir un id
    public void setId(String id)
    {
        this.Id=id;
    }
            
    //Metodo para obtener el id de un jugador
    public String getId()
    {
        return Id;
    }
    //Metodo para obtener la cantidad de dinero de un jugador
    public int getDinero()
    {
        return this.dinero;
    }
    //Metodo para definir la cantidad de dinero de un jugador
    public void setDinero(int dinero)
    {
        this.dinero=dinero;
    }
    //Metodo para obtener las cartas que tiene el jugador
    public List<Carta> getCartas()
    {
        return this.manoJugador.getMano();
    }
    
}
