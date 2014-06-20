package comandos;

import gui.VentanaJuego;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import poker.Carta;
import poker.CartasDTO;

public class ComandoGraficarCartas extends Comando{
    
    public static final String COMANDO = "graficarCartas";
    
    private final JLabel[] cartasMesa;
    private final JLabel[] cartasJugador;
    
    public ComandoGraficarCartas(VentanaJuego frame)
    {
        this.cartasMesa = null;//frame.getCartasMesa();
        this.cartasJugador = null;//frame.getCartasJugador();
    }
    
    @Override
    public void ejecutar(String[] args)
    {
        CartasDTO dto = CartasDTO.deserialize(args[0]);
        List<Carta> dtoCartasMesa = dto.getCartasMesa();
        List<Carta> dtoCartasJugador = dto.getCartasJugador();
        
        Carta cartaActual;
        JLabel labelActual;
        String rutaImagen;
        
        for (int i=0; i<dtoCartasMesa.size(); i++)
        {
            labelActual = this.cartasMesa[i];
            cartaActual = dtoCartasMesa.get(i);
            rutaImagen = "/res/cards/" + cartaActual.toString() + ".png";
            
            labelActual.setIcon( new ImageIcon(ClassLoader.getSystemResource(rutaImagen)) );
            labelActual.setVisible(true);
        }
        
        for (int i=0; i<dtoCartasJugador.size(); i++)
        {
            labelActual = this.cartasJugador[i];
            cartaActual = dtoCartasJugador.get(i);
            rutaImagen = "/res/cards/" + cartaActual.toString() + ".png";
            
            labelActual.setIcon( new ImageIcon(ClassLoader.getSystemResource(rutaImagen)) );
            labelActual.setVisible(true);
        }
    }
    
}
