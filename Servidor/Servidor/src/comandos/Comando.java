/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

/**
 *
 * Permite ejecutar funcionalidades mediante comandos.
 */
public abstract class Comando {
    
    
    /*
     *Método que se encarga de ejecutar la acción dependiendo del comando.
     */
    public abstract void ejecutar(Object dto);
    
}
