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
public class ComandoSolicitarApuesta extends Comando{
   
    public static final String COMANDO = "solicitarAouesta";//Comando de la clase
    private Cliente cliente;//Cliente al cual se le va a soliciatar la apuesta.
    
    
    /**
     * Constructor.
     * @param cliente Objeto de tipo Cliente.
     */
    public ComandoSolicitarApuesta(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    
    @Override
   public void ejecutar(String[] args)
    {
        
    }

}
