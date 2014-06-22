/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import cliente.Cliente;
import gui.VentanaJuego;

/**
 *
 * @author Leo
 */
public class ComandoSolicitarApuesta extends Comando{
   
    public static final String COMANDO = "solicitarAouesta";//Comando de la clase
    private VentanaJuego frame;//Cliente al cual se le va a soliciatar la apuesta.
    
    
    /**
     * Constructor.
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoSolicitarApuesta(VentanaJuego frame)
    {
        this.frame = frame;
    }
    
    
    @Override
   public Object ejecutar(Object args)
    {
        this.frame.setButtonsEnabled(true);
        return null;
    }

}
