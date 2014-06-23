/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;

public class FiveCards extends Juego {
    
    //Constructor
    public FiveCards(Mesa juego)
    {
        super(juego);
        this.cartasJugador = 5;
        this.cartasMesa = 0;
    }
    
    //Metodo jugar del tipo de juego FiveCards
    @Override
    public void jugar()
    {
       this.mesa.repartirCartasJugadores(5);
       this.mesa.notificarCartas();
       this.mesa.recibirApuestas();
       this.mesa.notificarApuestas();
       
       int j=0;
       while (j != 2)
       {
            this.mesa.recibirCambios();
            this.mesa.recibirApuestas();
            this.mesa.notificarApuestas();
            j++;
       }
        
       finalizarJuego();
    }
    
}
