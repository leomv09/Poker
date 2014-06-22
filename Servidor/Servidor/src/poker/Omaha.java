/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;


public class Omaha extends Juego {
    
//Constructor
    public Omaha(Mesa juego)
    {
        super(juego);
        this.cartasJugador = 4;
        this.cartasMesa = 5;
    }
    
    //Metodo jugar del tipo de juego Omaha
    @Override
    public void jugar()
    {
        int j=0;
        while (j!=2){
        this.mesa.recibirApuestas();
        this.mesa.generarBetStatusDTO();
        List<Jugador> jugadores=this.mesa.getJugadores();
        for (int i=0;i<jugadores.size();i++)
        {
            CartasDTO generarCartasDTO = this.mesa.generarCartasDTO(jugadores.get(i));
        }
        this.mesa.notificarApuestas();
        this.mesa.notificarCartas();
        j++;}
    }
    
}
