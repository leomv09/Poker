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
    List<Carta> cartas;
    
    public int obtenerValor()
    {
        return 0;
    }
    
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
