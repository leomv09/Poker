/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Leo
 */
public class Cliente {
    
    private String idJugador;//id de jugador que se le asigna.
    private String idMesa;//id de la mesa en la que está jugando.
    private SocketCliente socketCliente;//Socket por el cuál se va a comunicar con el server.
    
    
    public Cliente()
    {
        this.idJugador = "-1";
        this.idMesa = "-1";
        this.socketCliente = new SocketCliente();
    }
    
    private void solicitarMesas()
    {
        String[] args = {""};
        this.socketCliente.enviarDato("obtenerMesas", args);
    }
}
