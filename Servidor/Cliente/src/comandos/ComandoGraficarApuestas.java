package comandos;

import gui.VentanaJuego;
import java.util.ArrayList;
import java.util.List;
import poker.BetStatusDTO;
import poker.Jugador;

public class ComandoGraficarApuestas extends Comando{

    public static final String COMANDO = "graficarApuestas";
    private VentanaJuego frame;
    
    public ComandoGraficarApuestas(VentanaJuego frame)
    {
        this.frame = frame;
    }
    
    /**
     *
     * @param args Arreglo de objetos, que contendrá el dto de apuestas en la posición 0.
     * @return null.
     */
    @Override
    public Object ejecutar(Object args)
    {
        ArrayList<BetStatusDTO> datos = (ArrayList<BetStatusDTO>) args;
        BetStatusDTO dto = datos.get(0);
        List<Jugador> jugadores = dto.getJugadores();
        int[][] rondaApuestas = dto.getApuestas();
        
        String msj = "";
        int i = 0;
        //Por cada jugador se obtiene su apuesta.
        for(Jugador jugador : jugadores)
        {
            msj += obtenerApuestaJugador(rondaApuestas[i], jugador);
            i++;
        }
        
        msj += "Pot: " + obtenerPot(rondaApuestas) + "\n"; 
        
        this.frame.setRondaApuestas(msj);
        return null;
    }
    
    
    /*
     * Método que obtiene la última apuesta realizada por el jugador.
     * @param ronda Ronda de apuestas del jugador.
     * @param jugador Objeto de tipo jugador que representa el apostador.
     */
    private String obtenerApuestaJugador(int[] ronda, Jugador jugador)
    {
        int ultimaApuesta = ronda[ronda.length];//Se obtiene la última cantidad apostada por el jugador.
        
        String res = "Jugador: "+jugador.getId() + " | " +"Apuesta: " + ultimaApuesta + "\n";
        
        return res;
    }
    
    /*
     * Método que obtiene el pot total de la ronda de apuestas.
     */
    private int obtenerPot(int[][] rondaApuestas)
    {
        int pot = 0;
        //Se recorre la matriz de la ronda de apuestas para sumar todas las apuestas.
        for(int i = 0; i < rondaApuestas.length; i++ )
        {
            for(int j = 0; j < rondaApuestas[i].length; j++)
            {
                pot += rondaApuestas[i][j];
            }
        }
        
        return pot;
    }
    
}
