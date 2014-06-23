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

<<<<<<< HEAD
public class BetStatusDTO implements Serializable{
=======
public class BetStatusDTO implements Serializable {
>>>>>>> 349355b6dc2c09a2b8c3f52ccca35dd536cb3ae5
    
    public static Gson gson = new Gson();

    private List<Jugador> jugadores;
    private int[][] apuestas;
    
    public BetStatusDTO(List<Jugador> jugadores, int[][] apuestas)
    {
        this.jugadores = jugadores;
        this.apuestas = apuestas;
    }

    public List<Jugador> getJugadores()
    {
        return jugadores;
    }

    public int[][]getApuestas()
    {
        return apuestas;
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
