package comandos;

import cliente.Cliente;
import gui.VentanaJuego;
import java.util.List;
import javax.swing.JLabel;
import poker.BetStatusDTO;
import poker.Jugador;

public class ComandoGraficarApuestas extends Comando{

    public static final String COMANDO = "graficarApuestas";
    
    JLabel labelApuestas;//Label donde se mostrará la situación de las apuestas.
    Cliente cliente;
    
    public ComandoGraficarApuestas(VentanaJuego frame, Cliente cliente)
    {
        this.labelApuestas = frame.getLabelApuestas();
        this.cliente = cliente;
    }
    
    @Override
    public void ejecutar(Object[] args)
    {
        BetStatusDTO dto = BetStatusDTO.deserialize((String)args[0]);
        List<Jugador> jugadores = dto.getJugadores();
        int[][] rondaApuestas = dto.getApuestas();
        
    }
    
}
