/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

public class Carta implements Comparable<Carta>{
    //Parametros de una carta
    int Palo;
    int Valor;
    
    //Constructor
    public Carta(int pPalo,int pValor)
    {
        this.Palo=pPalo;
        this.Valor=pValor;
    }
    
    //Metodo toString de carta
    @Override
    public String toString()
    {
        return ""+this.Palo+"-"+this.Valor;
    } 
    //Metodo compareTo que implementa de la interfaz Comparable
    @Override
    public int compareTo(Carta c)
    {
        if (this.Valor>c.Valor){return 1;}
        else if (this.Valor<c.Valor){return -1;}
        else
        {
            return 0;
        }
    }
    
}
