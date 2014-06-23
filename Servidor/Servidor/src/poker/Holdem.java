/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

public class Holdem extends Juego {
    
    private int rondaApuestas;
    
    //Constructor
    public Holdem(Mesa juego)
    {
        super(juego);
        this.rondaApuestas = 0;
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
    }

    @Override
    public void apuestasFinalizadas()
    {
        System.out.println("apuestas Finalizadas");
        switch (this.rondaApuestas)
        {
            case 0:
                //this.mesa.notificarApuestas();
                this.mesa.repartirCartasMesa(3);
                this.mesa.notificarCartas();
                this.mesa.recibirApuestas();
                break;
            case 3:
                finalizarJuego();
                break;
            default:
                //this.mesa.notificarApuestas();
                this.mesa.repartirCartasMesa(1);
                this.mesa.notificarCartas();
                this.mesa.recibirApuestas();
                break;
        }
        this.rondaApuestas++;
    }
    
}
