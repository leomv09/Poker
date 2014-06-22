/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;

public abstract class Mano implements Comparable<Mano>{
    //Parametro de mano
    List<Carta> cartas;
    
    //Metodo para agregar cartas a la mano
    public void agregarCarta(Carta c)
    {
        cartas.add(c);
    }
    //Metodo para obtener la mano
    public List<Carta> getMano()
    {
        return cartas;
    }
    //Metodo para obtener el valor de la mano
    public int obtenerValor()
    {
        int valor=0;
        
        return valor;
    }
    //Metodo compareTo de la interfaz Comparable
    public int compareTo(Mano mano)
    {
        int resultado=0;
        if (this.obtenerValor()>mano.obtenerValor())
        {
            resultado=1;
        }
        else if (this.obtenerValor()<mano.obtenerValor()){resultado=-1;}
        else
        {
            resultado=0;
        }        
        return resultado;
    }
}
