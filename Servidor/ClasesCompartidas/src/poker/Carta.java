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
    private int Palo;
    private int Valor;
    
    //Constructor
    public Carta(int pPalo,int pValor)
    {
        this.Palo=pPalo;
        this.Valor=pValor;
    }
    
    public int getValor()
    {
        return this.Valor;
    }
    
    public int getPalo()
    {
        return this.Palo;
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
        return this.Valor - c.Valor;
    }
    
}
