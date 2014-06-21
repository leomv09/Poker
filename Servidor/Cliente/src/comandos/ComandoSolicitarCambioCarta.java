/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import cliente.Cliente;

/**
 *
 * @author Leo
 */
public class ComandoSolicitarCambioCarta extends Comando{
    
    public static final String COMANDO = "solicitarCarta";//Comando de la clase
    private Cliente cliente;// Cliente del cual se extraen las cartas.
    
    
    /**
     *
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoSolicitarCambioCarta(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
   
    @Override
   public void ejecutar(Object args)
   {
       
   }
    
}
