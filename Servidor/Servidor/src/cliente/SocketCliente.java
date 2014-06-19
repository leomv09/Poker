/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import comandos.Comando;
import comandos.ComandoSolicitarApuesta;
import comandos.ComandoSolicitarCambioCarta;
import comandos.ComandoGraficarCarta;
import comandos.ComandoGraficarApuesta;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class SocketCliente extends Thread{
    
    /*Atributos*/
    
    public ObjectInputStream in;//Para leer objetos del servidor.
    public ObjectOutputStream out;//Para enviar objetos al servidor.
    private Socket server;//Cambiar por clase server.
    private Map<String, Comando> comandos;//Mapa con los comandos para el cliente.
    
    
    public SocketCliente()
    {
        try {
            this.server = new Socket("localhost", 2020);//Cambiar por el server y la dirección IP del server.
            this.in = new ObjectInputStream(server.getInputStream());
            this.out = new ObjectOutputStream(server.getOutputStream());
            this.comandos = inicializarComandos();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     *Método que inicializa el mapa de comandos del cliente.
     * Retorna: El mapa con los comandos.
     */
    private Map<String, Comando> inicializarComandos()
    {
        Map<String, Comando> res = new HashMap<>();
	res.put(ComandoSolicitarApuesta.COMANDO, new ComandoSolicitarApuesta());
        res.put(ComandoSolicitarCambioCarta.COMANDO, new ComandoSolicitarCambioCarta());
        res.put(ComandoGraficarCarta.COMANDO, new ComandoGraficarCarta());
        res.put(ComandoGraficarApuesta.COMANDO, new ComandoGraficarApuesta());
        return res;
    }
    
    /*
     *Método que permite enviar un dato al servidor(DTO).
     * Parametro: dato Objeto a enviar al servidor.
     */
    public void enviarDato(Object dato)
    {
        try {
            this.out.writeObject(dato);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    //Método que cierra la conexión con el servidor.
    public void cerrarConexion()
    {
        try {
            this.out.close();//Se cierra el objeto de salida de datos.
            this.in.close();//Se cierra el objeto de entrada de datos.
            this.server.close();//se cierra la conexión con el servidor.
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run()
    {
        Object input;//Objeto que se recibe del servidor.
        try {
            while((input = in.readObject()) != null)
            {
            
                //Avisar sobre el objeto que ingresó.
            }
        }catch ( ClassNotFoundException | IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
