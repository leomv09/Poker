package comandos;

import gui.VentanaJuego;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import poker.Carta;
import poker.CartasDTO;

public class ComandoGraficarCartas extends Comando{
    
    public static final String COMANDO = "graficarCartas";
    
    private final JLabel[] labelsCartasMesa;
    private final JLabel[] labelsCartasJugador;
    
    public ComandoGraficarCartas(VentanaJuego frame)
    {
        this.labelsCartasMesa = frame.getCartasMesa();
        this.labelsCartasJugador = frame.getCartasJugador();
    }
    
    @Override
    public Object ejecutar(Object args)
    {
        CartasDTO dto = CartasDTO.deserialize(String.valueOf(args));
        graficarCartas(dto.getCartasMesa(), labelsCartasMesa);
        graficarCartas(dto.getCartasJugador(), labelsCartasJugador);
        return null;
    }
    
    private void graficarCartas(List<Carta> cartas, JLabel[] labels)
    {
        Carta cartaActual;
        JLabel labelActual;
        String rutaImagen;
        
        if (cartas.size() <= labels.length)
        {
            for (int i=0; i<cartas.size(); i++)
            {
                labelActual = labels[i];
                cartaActual = cartas.get(i);
                rutaImagen = "/res/cards/" + cartaActual.toString() + ".png";

                labelActual.setIcon( new ImageIcon(ClassLoader.getSystemResource(rutaImagen)) );
                labelActual.setVisible(true);
            }
        }
    }
    
}
