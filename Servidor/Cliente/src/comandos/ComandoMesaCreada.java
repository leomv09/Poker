/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import cliente.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class ComandoMesaCreada extends Comando{
    
     public static final String COMANDO = "mesaCreada";//Comando de la clase
    
    
    /**
     *
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoMesaCreada()
    {
    }
    
   
    /**
     *
     * @param args En este caso se recibe un arreglo que contiene el id de la mesa creada.
     * @return
     */
    @Override
   public Object ejecutar(Object args)
   {
       ArrayList<String> datos = (ArrayList<String>) args;
       Cliente.getInstance().setidMesa(datos.get(0));
       return null;
   }
    
}
