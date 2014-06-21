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
      int posicion=0;
      ArrayList<Carta> baraja=null;
      int[] valores={1,2,3,4,5,6,7,8,9,10,11,12,13};
      public Deck()
      {
          baraja=new ArrayList();
          nuevaBaraja();
      }
      private void nuevaBaraja()
      {
          for (int i=1;i<=4;i++)
          {
            for(int j=1;j<=valores.length-1;j++)
            {
                Carta c=new Carta(i,valores[j]);
                baraja.add(c);
            }
              
          }
      }
      public void shuffle()
      {
          Collections.shuffle(baraja);
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
          if(joker==true)
          {
          Carta jr=new Carta(20,0);
          Carta jn=new Carta(21,0);
          baraja.add(jr);
          baraja.add(jn);
          
          }
          
      }
}
