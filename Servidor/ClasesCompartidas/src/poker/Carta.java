/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

public class Carta implements Comparable<Carta>{
    int Palo;
    int Valor;
    public Carta(int pPalo,int pValor)
    {
        this.Palo=pPalo;
        this.Valor=pValor;
    }
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
