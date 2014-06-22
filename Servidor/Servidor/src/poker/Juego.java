/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

/**
 *
 * @author Marcelo
 */
public class Juego {
    
    //Parametros del juego
    protected int cartasMesa;
    protected int cartasJugador;
    protected Mesa mesa;
    
    public Juego(Mesa mesa)
    {
        this.mesa = mesa;
    }
    
    //Metodo jugar que se hereda en los juegos
    public void jugar()
    {
    }
    
}
