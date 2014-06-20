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
    private String[] mesas;
    private String idMesa;//id de la mesa en la que está jugando.
    private SocketCliente socketCliente;//Socket por el cuál se va a comunicar con el server.
    
    /*
     * Constructor
     */
    public Cliente()
    {
        this.idJugador = "-1";
        this.idMesa = "-1";
        this.mesas = new String[10];
        this.socketCliente = new SocketCliente();
    }
    
    /*
     * Método que establece el id del jugador.
     * Parámetros: id El id del jugador. 
     */
    public void setidJugador(String id)
    {
        this.idJugador = id;
    }
    
    /*
     * Método que establece las mesas a mostrar.
     * Parámetros: Mesas Las mesas a mostrar. 
     */
    public void setMesas(String[] Mesas)
    {
        this.mesas = Mesas;
    }
    
    /*
     * Método que establece el id de mesa.
     * Parámetros: id El id de la mesa. 
     */
    public void setidMesa(String id)
    {
        this.idMesa = id;
    }
    
    /*
     * Método que obtiene el id del jugador.
     * Retorna: El id del jugador.
     */
    public String getidJugador()
    {
        return this.idJugador;
    }
    
    /*
     * Método que obtiene el id de la mesa.
     * Retorna: El id de la mesa. 
     */
    public String getidMesa()
    {
        return this.idMesa;
    }
    
/*
 * Método que le solicita al servidor las mesas disponibles.
 */
    public void solicitarMesas()
    {
        String[] args = {""};
        this.socketCliente.enviarDato("obtenerMesas", args);
    }
    
    /*
     * Método que le solcita al servidor ingresar a una mesa.
     * Parámetros: idMesa El id de la mesa a unirse.
     */
    public void unirseMesa(String idMesa)
    {
        String[] args = {idMesa, this.idJugador};//Se envía el id de la mesa a unirse y el jugador a unirse.
        this.socketCliente.enviarDato("unirseMesa", args);
    }
    
    /*
     * Método que le solicita al servidor un cambio de carta.
     * Parámetros: carta Objeto de tipo carta que indica la carta que va a cambiar.
     * 
     */
    public void cambiarCarta()
    {
        
    }
    
    public void realizarApuesta(int apuesta)
    {
        String[] args = {idJugador, Integer.toString(apuesta)};
        this.socketCliente.enviarDato("apostar", args);
    }
}
