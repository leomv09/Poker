/*
 /*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package poker;

public class PokerBet {

    public static int FOLD = -1;
    public static int CHECK = 0;
    public static int BET_ROUNDS = 4;
    
    private int lBlind;
    private int bBlind;
    private int rondaActual;
    private int[][] apuestas;
    
    public PokerBet(int lBlind, int bBlind)
    {
        this.lBlind = lBlind;
        this.bBlind = bBlind;
        this.rondaActual = 0;
        this.apuestas = new int[PokerBet.BET_ROUNDS][];
    }
    
    public void almacenarApuesta(int indiceJugador, int apuesta)
    {
        this.apuestas[rondaActual][indiceJugador] = apuesta;
    }
    
    public void establecerCantJugadores(int cantJugadores)
    {
        for (int i=0; i<PokerBet.BET_ROUNDS; i++)
        {
            this.apuestas[i] = new int[cantJugadores];
        }
    }
    
    public void iniciarRondaApuesta()
    {
        this.rondaActual++;
    }

    public int getlBlind()
    {
        return lBlind;
    }

    public int getbBlind()
    {
        return bBlind;
    }

    public int getRondaActual()
    {
        return rondaActual;
    }

    public int[][] getApuestas()
    {
        return apuestas;
    }
    
}
