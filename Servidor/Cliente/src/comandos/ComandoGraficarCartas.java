package comandos;

import gui.VentanaJuego;
import java.util.ArrayList;
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
    
    /**
     *
     * @param args Arreglo de objetos, que contendrá el dto de cartas en la posición 0.
     * @return
     */
    @Override
    public Object ejecutar(Object args)
    {
        ArrayList<CartasDTO> datos = (ArrayList<CartasDTO>) args;
        CartasDTO dto = datos.get(0);
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

                System.out.println(rutaImagen);
                labelActual.setIcon( new ImageIcon(this.getClass().getResource(rutaImagen)) );
                labelActual.setVisible(true);
            }
        }
    }
    
}
