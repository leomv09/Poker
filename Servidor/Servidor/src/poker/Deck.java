/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck {
    
      //Parametros del deck
      private int posicion;
      private boolean joker;
      private ArrayList<Carta> baraja;
      
      //Constructor
      public Deck(boolean joker)
      {
          this.posicion = 0;
          this.joker = joker;
          this.baraja = new ArrayList();
          nuevaBaraja();
      }
      
      //Metodo para la creacion de una nueva baraja
      private void nuevaBaraja()
      {
          for (int i=1; i<=4; i++)
          {
            for(int j=1; j<=13; j++)
            {
                this.baraja.add( new Carta(i,j) );
            }
          }
          if (this.joker)
          {
            Carta jr = new Carta(20, 0);
            Carta jn = new Carta(21, 0);
            this.baraja.add(jr);
            this.baraja.add(jn);
          }
      }
      
      //Metodo shuffle que hace barajar a la baraja
      public void shuffle()
      {
          Collections.shuffle(baraja);
      }
      
      //Metodo iterador del deck de la interfaz Iterator
      public Iterator<Carta> iterador()
      {
          return new IteradorDeck();
      }
      
      //Metodo toString
      @Override
      public String toString()
      {
          return baraja.toString();
      }
      
      //Clase interna de Iteracion del deck
      protected class IteradorDeck implements Iterator<Carta>
      {
        //Metodo para ver si la baraja tiene cartas
         @Override
         public boolean hasNext()
         {
             return posicion < baraja.size() - 1;
         }
         
         //Metodo next para dar la siguiente carta
         @Override
         public Carta next()
         {
             if (this.hasNext())
             {
                 return baraja.get(posicion++);
             }
             else
             {
                 return null;
             }
         }
         
         //Metodo para quitar cartas
         @Override
         public void remove()
         {
             baraja.remove(posicion - 1);
         }
      }
}
