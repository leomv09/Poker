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
public class ComandoSolicitarCambioCarta extends Comando{
    
    public static final String COMANDO = "solicitarCarta";//Comando de la clase
    private VentanaJuego frame;// Cliente del cual se extraen las cartas.
    
    
    /**
     *
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoSolicitarCambioCarta(VentanaJuego frame)
    {
        this.frame = frame;
    }
    
   
    @Override
   public Object ejecutar(Object args)
   {
       this.frame.setCambiarCartas();//Se habilita el botón de cambiar cartas.
       return null;
   }
    
}
