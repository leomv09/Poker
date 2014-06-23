/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class ComandoMesaCreada extends Comando{
    
     public static final String COMANDO = "mesaCreada";//Comando de la clase
   
    /**
     *
     * @param args En este caso se recibe un arreglo que contiene el id de la mesa creada.
     * @return
     */
    @Override
   public Object ejecutar(Object args)
   {
       List<Object> datos = (ArrayList<Object>) args;
       Cliente.getInstance().setidMesa((String) datos.get(0));
       return null;
   }
    
}
