package comandos;

import gui.VentanaJuego;
import java.util.ArrayList;
import java.util.List;
import poker.CartasDTO;

/**
 *
 * @author jose
 */
public class ComandoFinalPartida extends Comando
{
    public static String COMANDO = "finPartida";
    
    private VentanaJuego frame;
    
    public ComandoFinalPartida(VentanaJuego frame)
    {
        this.frame = frame;
    }
    
    @Override
    public Object ejecutar(Object args)
    {
        List<Object> datos = (ArrayList<Object>) args;
        String estado = (String) datos.get(0);
        frame.notificarFinalPartida(estado);
        return null;
    }
    
}
