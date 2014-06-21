package comandos;

import gui.VentanaJuego;
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
    
    @Override
    public void ejecutar(String[] args)
    {
        BetStatusDTO dto = BetStatusDTO.deserialize(args[0]);
        List<Jugador> jugadores = dto.getJugadores();
        int[][] rondaApuestas = dto.getApuestas();
        
    }
    
}
