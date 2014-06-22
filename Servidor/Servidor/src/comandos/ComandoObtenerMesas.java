/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package comandos;

import java.util.ArrayList;
import poker.Mesa;
import poker.MesaDTO;
import servidor.Servidor;

/**
 * Esta clase se encarga de implementar el comportamiento del comando
 * ObtenerMesas.
 * @author kortega
 */
public class ComandoObtenerMesas extends Comando{
    
    public static final String COMANDO = "obtenerMesas";//Comando de la clase.
    
   public Object ejecutar(Object args)
   {
       Servidor serv = Servidor.getInstance();
       ArrayList<Mesa> mesas = serv.getMesas();
       ArrayList<MesaDTO> dtos = new ArrayList<MesaDTO>();
       for(Mesa i: mesas){
           dtos.add(new MesaDTO(i.getId(),
                                null,
                                ));
       }
       ArrayList<Object> respuesta = new ArrayList<>();
       respuesta.add("notificarMesas");
       respuesta.add(dtos);
       return respuesta;
   }
}
