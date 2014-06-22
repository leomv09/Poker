package comandos;

import gui.VentanaJuego;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import poker.BetStatusDTO;
import poker.Jugador;

public class ComandoGraficarApuestas extends Comando{

    public static final String COMANDO = "graficarApuestas";
    
    JLabel labelApuestas;//Label donde se mostrará la situación de las apuestas.
    
    public ComandoGraficarApuestas(VentanaJuego frame)
    {
        this.labelApuestas = frame.getLabelApuestas();
    }
    
    /**
     *
     * @param args Arreglo de objetos, que contendrá el dto de apuestas en la posición 0.
     * @return
     */
    @Override
    public Object ejecutar(Object args)
    {
        ArrayList<BetStatusDTO> datos = (ArrayList<BetStatusDTO>) args;
        BetStatusDTO dto = datos.get(0);
        List<Jugador> jugadores = dto.getJugadores();
        int[][] rondaApuestas = dto.getApuestas();
        return null;
    }
    
}
