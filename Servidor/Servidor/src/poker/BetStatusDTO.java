/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;

public class BetStatusDTO {

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
    
}
