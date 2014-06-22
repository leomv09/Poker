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
    
    public static final String COMANDO = "iniciarPartida";//Comando de la clase.
    private VentanaEspera frame;//Ventana a avisar cuando crear el juego.
    
    public ComandoIniciarPartidaCliente(VentanaEspera frame)
    {
        this.frame = frame;
    }
    
    /**
     *
     * @param args Arreglo de objetos, que será vacío.
     * @return
     */
    @Override
    public Object ejecutar(Object args)
    {
        this.frame.crearVentanaJuego();
        return null;
    }
    
}
