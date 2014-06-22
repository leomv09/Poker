/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import comandos.Comando;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
    
    
    /**
     * Constructor.
     */
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
        return res;
    }
    
    
    /**
     * Método agrega un comando al mapa de comandos.
     * @param nombre Nombre del comando.
     * @param comando Objeto de tipo comando.
     */
    public void setComando(String nombre, Comando comando)
    {
        this.comandos.put(nombre, comando);
    }
    
    /**
     * Método que permite enviar datos al servidor.
     * @param dato Dato a enviar.
     */
    public void enviarDato(Object dato)
    {
        try {
            this.out.writeObject(dato);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     *Método que permite enviar un comando y sus argumentos al servidor.
     * Parametro: comando Comando para el servidor.
     *            args Arreglo de argumentos.
     */
    public void enviarComando(String comando, Object args)
    {
        try {
            this.out.writeObject(comando);
            this.out.writeObject(args);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    /*
     *Método que se encarga de llamar al comando con los datos brindados por el servidor.
     * Parametros: nombre Nombre del comando.
     *             dto DTO a procesar.
     */
    private void ejecutarComando(String nombre, Object args)
    {
        Comando comando = this.comandos.get(nombre);
        if(comando != null)
        {
            comando.ejecutar(args);
        }
    }
    
    
    /*
     * Método que cierra la conexión con el servidor.
     */
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
    
    /*
     *Método que escucha al servidor.
     */
    @Override
    public void run()
    {
        Object input;//Objeto que se recibe del servidor.
        try {
            ArrayList<Object> datos;//Arreglo de datos recibidos.
            while((input = in.readObject()) != null)
            {
                datos = (ArrayList<Object>) input;
                if(datos != null)
                {
                    String comando = (String)datos.get(0);
                    datos.remove(0);
                    ejecutarComando(comando, datos);
                }
            }
        }catch ( ClassNotFoundException | IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
