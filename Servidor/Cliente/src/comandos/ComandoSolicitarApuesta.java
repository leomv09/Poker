/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import cliente.Cliente;
import gui.VentanaJuego;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class ComandoSolicitarApuesta extends Comando{
   
    public static final String COMANDO = "solicitarApuesta";//Comando de la clase
    private VentanaJuego frame;//Cliente al cual se le va a soliciatar la apuesta.
    
    
    /**
     * Constructor.
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoSolicitarApuesta(VentanaJuego frame)
    {
        this.frame = frame;
    }
    
    
    /**
     * Método que ejecuta el comando.
     * @param args En este caso es la cantidad de fichas a igualar.
     * @return
     */
    @Override
   public Object ejecutar(Object args)
    {
        ArrayList<Object> args2 = (ArrayList<Object>)args;
        int cantApostar = (int) args2.get(0);
        this.frame.setCantIgualar(cantApostar);//Se establece la cantidad a igualar en la apuesta.
        this.frame.realizarApuesta();//Se habilitan los botones relacionados con apostar.
        return null;
    }

}
