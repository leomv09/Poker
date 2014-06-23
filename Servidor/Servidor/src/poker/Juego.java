/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;
import servidor.Servidor;

/**
 *
 * @author Marcelo
 */
public abstract class Juego {
    
    //Parametros del juego
    protected int cartasMesa;
    protected int cartasJugador;
    protected Mesa mesa;
    
    public Juego(Mesa mesa)
    {
        this.mesa = mesa;
    }
    
    //Metodo jugar que se hereda en los juegos
    public abstract void jugar();
    
    public abstract void apuestasFinalizadas();
    
    protected void finalizarJuego()
    {
        // Obtener las manos.
        List<Mano> manos = this.mesa.generarManos();
        List<Jugador> jugadores = this.mesa.getJugadores();
        int indiceMejorMano = 0;
        
        // Obtener la mejor mano.
        for (int i=1; i<manos.size(); i++)
        {
            if (manos.get(i).compareTo(manos.get(i-1)) > 0)
            {
                indiceMejorMano = i;
            }
        }
        
        // Notificar a los jugadores si ganaron o perdieron.
        String param;
        for (int i=0; i<jugadores.size(); i++)
        {
            if (i == indiceMejorMano)
            {
                param = "ganador";
            }
            else
            {
                param = "perdedor";
            }
            Servidor.getInstance().enviarComando(jugadores.get(i).getId(), "finPartida", param + " " + manos.get(i).toString());
        }
    }
    
}
