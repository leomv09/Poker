/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import gui.VentanaEspera;

/**
 *
 * @author Leo
 */
public class ComandoIniciarPartidaCliente extends Comando{
    
    public static final String COMANDO = "iniciarPartida";//Comando de la clase
    private VentanaEspera frame;//Ventana a avisar cuando crear juego.
    
    public ComandoIniciarPartidaCliente(VentanaEspera frame)
    {
        this.frame = frame;
    }
    
    @Override
    public Object ejecutar(Object args)
    {
        return null;
    }
    
}
