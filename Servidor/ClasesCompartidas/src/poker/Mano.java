/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.ArrayList;
import java.util.List;

public class Mano implements Comparable<Mano>{
    //Parametro de mano
    List<Carta> cartas;
    //Constructor
    public Mano()
    {
        cartas=new ArrayList<Carta>();
    }
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
        this.ordenarMano();
        return valor;
    }
    //Metodo para ordenar la mano
   public void ordenarMano()
    {
        for (int i=1;i<cartas.size();i++)
            for (int j=0;j<cartas.size()-1;j++)
                if (cartas.get(j).Valor>cartas.get(j+1).Valor)
                {
                    Carta temp=cartas.get(j);
                    cartas.set(j, cartas.get(j+1));
                    cartas.set(j+1, temp);
                    
                }
        
    }
    //Metodo compareTo de la interfaz Comparable
   @Override
    public int compareTo(Mano mano)
    {
        int resultado;
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
