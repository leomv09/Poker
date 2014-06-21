/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;


import cliente.Cliente;
import java.util.List;

/**
 *
 * @author Leo
 */
public class ComandoNotificarMesas extends Comando{
    
    public static final String COMANDO = "notificarMesas";//Comando de la clase
    private Cliente cliente;//Cliente al que se le notifican las mesas.
    
    
    /**
     *
     * @param cliente El cliente al cual se le notifican las mesas.
     */
    public ComandoNotificarMesas(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    
    /*
     * En este caso el arreglo de argumentos sería un arreglo de id's de mesa.
     */
    @Override
   public void ejecutar(String[] args)
   {
       //List<Mesa> listaMesas = args[0];
       
   }
    
}
