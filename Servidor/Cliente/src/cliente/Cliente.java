/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import poker.Jugador;

/**
 *
 * @author Leo
 */
public class Cliente {
    
    private static Cliente instance = null;
    private String idMesa;//id de la mesa en la que está jugando.
    private SocketCliente socketCliente;//Socket por el cuál se va a comunicar con el server.
    private Jugador jugador;
    

    /**
     * Constructor.
     * @param idJugador El identificador del jugador (Nickname).
     * @param cantidadFichas Entero indicando la cantidad de fichas del jugador.
     */
    private Cliente()
    {
        this.idMesa = "-1";
        this.socketCliente = new SocketCliente();
        this.jugador = new Jugador("", 50);
    }
    
    
    
    /**
     * Método que establece el atributo jugador.
     * @param jugador Objeto de tipo jugador.
     */
    public void setJugador(Jugador jugador)
    {
        this.jugador = jugador;
    }
    private static void createInstance()
    {
        if(instance == null)
        {
            instance = new Cliente();
        }
    }
    
    public static Cliente getInstance()
    {
        if(instance == null)
            createInstance();
        return instance;
    }
    
   
    
    /**
     * Método que obtiene el jugador del cliente.
     * @return El jugador del cliente.
     */
    public Jugador getJugador()
    {
        return this.jugador;
    }
    
    /**
     * Método que obtiene el socket por el cual se comunica el cliente con el servidor.
     * @return El socket del cliente.
     */
    public SocketCliente getsocketCliente()
    {
        return this.socketCliente;
    }
    
    /*
     * Método que establece el id del jugador.
     * Parámetros: id El id del jugador. 
     */
    public void setidJugador(String id)
    {
        this.jugador.setId(id);
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
        this.socketCliente.enviarComando("obtenerMesas", args);
    }
    
    /*
     * Método que le solcita al servidor ingresar a una mesa.
     * Parámetros: idMesa El id de la mesa a unirse.
     */
    public void unirseMesa(String idMesa)
    {
        String[] args = {idMesa, this.jugador.getId()};//Se envía el id de la mesa a unirse y el jugador a unirse.
        this.socketCliente.enviarComando("unirseMesa", args);
    }
    
    /*
     * Método que le solicita al servidor un cambio de carta.
     * Parámetros: carta Objeto de tipo carta que indica la carta que va a cambiar.
     * 
     */
    public void cambiarCarta()
    {
        
    }
    
    /**
     * Método que le avisa al servidor sobre la apuesta a realizar.
     * @param apuesta Cantidad de fichas a apostar.
     */
    public void realizarApuesta(int apuesta)
    {
        String[] args = {this.jugador.getId(), Integer.toString(apuesta)};
        this.socketCliente.enviarComando("apostar", args);
    }
}
