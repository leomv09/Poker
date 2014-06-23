/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;

public class BetStatusDTO implements Serializable{
    
    public static Gson gson = new Gson();

    private List<Jugador> jugadores;
    private int[][] apuestas;
    private int rondaActual;
    
    public BetStatusDTO(List<Jugador> jugadores, int[][] apuestas, int rondaActual)
    {
        this.jugadores = jugadores;
        this.apuestas = apuestas;
        this.rondaActual = rondaActual;
    }

    public List<Jugador> getJugadores()
    {
        return jugadores;
    }

    public int[][]getApuestas()
    {
        return apuestas;
    }
    
    public int getRondaActual()
    {
        return this.rondaActual;
    }
    
    public static BetStatusDTO deserialize(String text)
    {
        return BetStatusDTO.gson.fromJson(text, BetStatusDTO.class);
    }
    
    public String serialize()
    {
        return BetStatusDTO.gson.toJson(this);
    }
    
}
