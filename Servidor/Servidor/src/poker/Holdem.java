/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

public class Holdem extends Juego {
    
    //Constructor
    public Holdem(Mesa juego)
    {
        super(juego);
        this.cartasJugador = 2;
        this.cartasMesa = 5;
    }
    
    //Metodo jugar del tipo de juego Holdem
    @Override
    public void jugar()
    {
        this.mesa.repartirCartasJugadores(2);
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
        
        finalizarJuego();
    }
    
}
