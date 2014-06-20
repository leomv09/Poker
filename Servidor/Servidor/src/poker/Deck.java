/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck {
      ArrayList<Carta> baraja=null;
      String num="10";
      char[] valores={'1','2','3','4','5','6','7','8','9','D','J','Q','K','A'};
      public Deck()
      {
          baraja=new ArrayList();
          nuevaBaraja();
      }
      private void nuevaBaraja()
      {
          for (int i=0;i<=4;i++)
          {
            for(int j=1;j<=valores.length-1;j++)
            {
                Carta c=new Carta(i,valores[j]);
                baraja.add(c);
            }
              
          }
      }
      public Iterator<Carta> iterador()
      {
          return new IteradorDeck();
      }
      @Override
      public String toString()
      {
          return baraja.toString();
      }
      
      protected class IteradorDeck implements Iterator<Carta>
      {
         int posicion=0;
         @Override
         public boolean hasNext()
         {
             return posicion<baraja.size();
         }
         @Override
         public Carta next()
         {
             Carta sig=baraja.get(posicion);
             posicion++;
             return sig;
         }
         @Override
         public void remove()
         {
         }
      }
      public void setJoker(boolean joker)
      {
          
      }
}
