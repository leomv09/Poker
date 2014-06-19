/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

public abstract class Carta implements Comparable<Carta>{
    int Palo;
    char Valor;
    
    public int compareTo(Carta c)
    {
        return this.Valor-c.Valor;
    }
    
}
