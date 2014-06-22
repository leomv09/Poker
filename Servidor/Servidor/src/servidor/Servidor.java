/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package servidor;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import poker.BetStatusDTO;
import poker.CartasDTO;
import poker.Jugador;
import poker.Mesa;
import poker.PokerBet;

/**
 * Servidor, Se encarga de recibir las conexiones entrantes
 * y la comunicación entre cada jugador y sus mesas.
 * Clase Singleton
 * @author kortega
 */
public class Servidor extends Thread implements ConstantesServ{
    //Atributos
    /**
     * Única instancia del servidor
     */
    private static Servidor instance;
    /**
     * Única unstancia de ServerLog, para ir posteando los cambios
     * ocurridos en el servidor
     */
    private static ServerLog ventana;
    /**
     * Conexiones existentes.
     */
    private static ArrayList<Conexion> conexiones;
    
    private static ArrayList<Mesa> mesas;
    
    //Constructores
    /**
     * Crea una nueva instancia del servidor.
     */
    private Servidor(){
        mesas = new ArrayList<>();
    }
    
    //Métodos
    
    public void crearVentana(){
        if(ventana == null){
            ventana = new ServerLog();
        }
    }
    
    /**
     * Devuelve la única instancia de servidor.
     * @return Servidor
     */
    public static Servidor getInstance(){
        if(instance == null){
            instance = new Servidor();
        }
        return instance;
    }
    
    public void asignarVentana(ServerLog pVentana){
        Servidor.ventana = pVentana;
    }
    
    /**
     * Postea un cambio en ventana ServerLog
     * @param msg
     */
    public final void post(String msg){
        ventana.post(msg);
    }
    
    /**
     * Envia un objeto al cliente
     */
    private void enviarDatos(){
        
    }
    
    /**
     * Inicia las labores del servidor.
     */
    public void runServer(){
        ServerSocket serv;// es para counicacion y admin
        boolean listening = true;// bandera del while
        
        try
        {
            //Crea el socket que va a estar escuchando las peticiones
            serv = new ServerSocket(7777);
            
            post(".:: Servidor Activo");
            
            
            //Ciclo infinito que espera los clientes
            while(listening)
            {
                
                // Dos cokets para los clientes que acepta
                post(".::Esperando Conexiones");
                Socket sock1;
                
                try{
                    // espera las conexiones de los clientes
                    // a ambos sockets, por eso sson dos accepts
                    
                    sock1 = serv.accept();
                    
                }
                catch(IOException e){
                    post("Conexión falida: "+
                            serv+ ", "+ e.getMessage());
                    continue;
                }
                
                //crea un hilo para cada conexion con los clientes
                // y server
                Conexion user = new Conexion(sock1,this);
                conexiones.add(user);
                user.start();

            }
        }
        catch (IOException e)
        {
            post("Error: "+e);
        }
        
        
        
    }

    public String crearMesa(Jugador plr,String nombre,int cantidad,int tipojuego){
        PokerBet apuesta = new PokerBet(LITTLE_BLIND,BIG_BLIND);
        Mesa mesa = new Mesa(plr,apuesta,nombre,cantidad,tipojuego);
        mesas.add(mesa);
        mesa.crearJuego();
        return mesa.getId();
    }
    
    /**
     * Devuelve todas las mesas que tiene el servidor.
     * @return mesas
     */
    public ArrayList<Mesa> getMesas(){
        return mesas;
    }
    
    public boolean unirJugador(String idmesa,Jugador jugador){
        for(Mesa mesa : mesas){
            if(mesa.getId().equals(idmesa)){
                mesa.agregarJugador(jugador);
                return true;
            }
        }
        return false;
    }
    
    public void solicitarCambios(String id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void solicitarApuestas(String id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notificarCartas(String id, CartasDTO status)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notificarEstadoApuesta(String id, BetStatusDTO status)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
