/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;


public class Omaha extends Juego{
    public Omaha(Jugador jugador,PokerBet poker)
    {
        this.cartasJugador=4;
        this.cartasMesa=5;
        this.juego=new Mesa(jugador,poker);
    }
    @Override
    public void jugar()
    {
        int j=0;
        while (j!=2){
        this.juego.recibirApuestas();
        this.juego.generarBetStatusDTO();
        List<Jugador> jugadores=this.juego.getJugadores();
        for (int i=0;i<jugadores.size();i++)
        {
            CartasDTO generarCartasDTO = this.juego.generarCartasDTO(jugadores.get(i));
        }
        this.juego.notificarApuestas();
        this.juego.notificarCartas();
        j++;}
    }
    
}
