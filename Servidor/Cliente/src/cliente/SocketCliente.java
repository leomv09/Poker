/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import comandos.Comando;
import comandos.ComandoSolicitarApuesta;
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
    
    /*
     *Método que permite enviar un dato al servidor(DTO).
     * Parametro: comando Comando para el servidor.
     *            args Arreglo de argumentos.
     */
    public void enviarDato(String comando, String[] args)
    {
        try {
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
    private void ejecutarComando(String nombre, String[] args)
    {
        Comando comando = this.comandos.get(nombre);
        if(comando != null)
        {
            comando.ejecutar(args);
        }
    }
    
    /*
     *Método que elimina el primer elemento de un arreglo.
     * Parametros: array Arreglo a eliminar el elementos.
     *             elem  Elemento a eliminar.
     */
    private String[] removeFirst(String[] array, String elem)
    {
        String[] res =(String[]) new String[array.length - 1];
        System.arraycopy(array, 1, res, 0, array.length - 1);
        return res;
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
            String[] datos;//Arreglo de datos recibidos.
            while((input = in.readObject()) != null)
            {
                datos = (String[])input;
                if(datos[0] != null)
                {
                    ejecutarComando(datos[0], removeFirst(datos, datos[0]));
                }
            }
        }catch ( ClassNotFoundException | IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
