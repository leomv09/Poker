/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;


import gui.DialogoUnirseMesa;
import java.util.List;
import poker.MesaDTO;

/**
 *
 * @author Leo
 */
public class ComandoNotificarMesas extends Comando{
    
    public static final String COMANDO = "notificarMesas";//Comando de la clase
    private DialogoUnirseMesa frame;//Cliente al que se le notifican las mesas.
    
    
    /**
     *
     * @param cliente El cliente al cual se le notifican las mesas.
     */
    public ComandoNotificarMesas(DialogoUnirseMesa frame)
    {
        this.frame = frame;
    }
    
    

    /**
     *
     * @param args
     */
    @Override
   public void ejecutar(Object[] args)
   {
       if(args[0] != null)
       {
        List<MesaDTO> dtos = (List<MesaDTO>)args[0];
        this.frame.setMesas(dtos);
       }
       
       
   }
    
}
