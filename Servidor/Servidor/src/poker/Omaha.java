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
       this.mesa.repartirCartasJugadores(4);
       this.mesa.notificarCartas();
       this.mesa.recibirApuestas();
       this.mesa.notificarApuestas();
        
       this.mesa.repartirCartasMesa(3);
       this.mesa.notificarCartas();
       this.mesa.recibirApuestas();
       this.mesa.notificarApuestas();
        
       int j=0;
       while (j != 2)
       {
           this.mesa.repartirCartasMesa(1);
           this.mesa.notificarCartas();
           this.mesa.recibirApuestas();
           this.mesa.notificarApuestas();
           j++;
       }
    }
    
}
