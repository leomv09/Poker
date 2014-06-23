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
    
    private int cantCartas;
    
    public ComandoGraficarCartas(VentanaJuego frame)
    {
        this.labelsCartasMesa = frame.getCartasMesa();
        this.labelsCartasJugador = frame.getCartasJugador();
        this.cantCartas = 0;
    }
    
    /**
     *
     * @param args Arreglo de objetos, que contendrá el dto de cartas en la posición 0.
     * @return
     */
    @Override
    public Object ejecutar(Object args)
    {
        ArrayList<Object> datos = (ArrayList<Object>) args;
        CartasDTO dto = (CartasDTO) datos.get(0);
        
        //System.out.println(dto);
        //System.out.println("Carta Mesa " + dto.getCartasMesa().size());
        //System.out.println("Carta Jugador " + dto.getCartasJugador().size());
        
        graficarCartas(dto.getCartasMesa(), labelsCartasMesa);
        graficarCartas(dto.getCartasJugador(), labelsCartasJugador);
        
        this.enseñarCartas(labelsCartasJugador, 5);
        
        switch (this.cantCartas)
        {
            case 1:
                this.enseñarCartas(labelsCartasMesa, 3);
                break;
            case 2:
                this.enseñarCartas(labelsCartasMesa, 4);
                break;
            case 3:
                this.enseñarCartas(labelsCartasMesa, 5);
                break;
        }
        
        this.cantCartas++;
        return null;
    }
    
    private void graficarCartas(ArrayList<Carta> cartas, JLabel[] labels)
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

                labelActual.setIcon( new ImageIcon(this.getClass().getResource(rutaImagen)) );
            }
        }
    }
    
    private void enseñarCartas(JLabel[] labels, int cantCartas)
    {
        for (int i=0; i<cantCartas; i++)
        {
            labels[i].setVisible(true);
        }
    }
    
}
