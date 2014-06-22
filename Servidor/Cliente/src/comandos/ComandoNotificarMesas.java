/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;


import gui.DialogoUnirseMesa;
import java.util.ArrayList;
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
     * @param frame La ventana de mesas que se va a llenar.
     */
    public ComandoNotificarMesas(DialogoUnirseMesa frame)
    {
        this.frame = frame;
    }
    
    

    /**
     *
     * @param args Arreglo de objetos que contendrá el arreglo de mesas.
     */
    @Override
   public Object ejecutar(Object args)
   {
       if(args != null)
       {
        ArrayList<Object> datos = (ArrayList<Object>) args;
        ArrayList<MesaDTO> dtos = (ArrayList<MesaDTO>) datos.get(0);
        this.frame.setMesas(dtos);
       }
       return null;
       
   }
    
}
