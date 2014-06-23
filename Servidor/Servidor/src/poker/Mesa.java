/*
 /*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import servidor.ListenerComandos;
import servidor.Servidor;

public class Mesa implements ListenerComandos {
    private int cantidadCambios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private final String id;
    private final Jugador creador;
    private Deck deck;
    private PokerBet pokerBet;
    private final List<Jugador> jugadores;
    private final List<Carta> cartasMesa;
    private final List<Carta>[] cartasJugadores;
    private final List<Mano> manos;
    private int dealer;
    private String nombre;
    private int tipoJuego;
    private Juego juego;
    private int cantidadJugadores;
    private int cantidadApuestas;
    
    public Mesa(Jugador creador, PokerBet bet, String Nombre, int tipo, int cantidadJugadores)
    {
        this.id = UUID.randomUUID().toString();
        this.dealer = 0;
        this.creador = creador;
        this.pokerBet = bet;
        this.deck = new Deck(false);
        this.manos = new LinkedList<>();
        this.cartasMesa = new LinkedList<>();
        this.cartasJugadores = new List[cantidadJugadores];
        this.jugadores = new LinkedList<>();
        this.jugadores.add(creador);
        this.nombre=Nombre;
        this.tipoJuego=tipo;
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadApuestas = 0;
        this.cantidadCambios = 0;
        
        for (int i=0; i<cantidadJugadores; i++)
        {
            this.cartasJugadores[i] = new LinkedList<>();
        }
        this.deck.shuffle();
    }
    
    public void crearJuego()
    {
        System.out.println(tipoJuego);
        switch (tipoJuego)
        {
            case Constantes.JUEGO_HOLDEM:
                this.juego = new Holdem(this);
                break;
            case Constantes.JUEGO_FIVECARDS:
                this.juego = new FiveCards(this);
                break;
            case Constantes.JUEGO_OMAHA:
                this.juego = new Omaha(this);
                break;
        }
    }
    
    public void notificarInicioJuego()
    {
        for (Jugador jugador : this.jugadores)
        {
            Servidor.getInstance().enviarComando(jugador.getId(), "iniciarPartida", null);//Hace falta enviarle las cartas al cliente.
            Servidor.getInstance().getConexion(jugador.getId()).agregarListener(this);
        }
        System.out.println(tipoJuego);
        crearJuego();
        this.juego.jugar();
    }
    
    public void cambiarCartas(String idJugador, List<Carta> cartas)
    {
        int index = this.getIndexJugador(idJugador);
        List<Carta> cartasJugador = this.cartasJugadores[index];
        Iterator<Carta> iter = this.deck.iterador();
        
        int indiceCarta;
        for (Carta carta : cartas)
        {
            if (iter.hasNext()) {
                indiceCarta = cartasJugador.indexOf(carta);
                cartasJugador.set(indiceCarta, iter.next());   
            }
        }
    }
    
    public void repartirCartasJugadores(int cantidadCartas)
    {
        Servidor.getInstance().post("Repartiendo Cartas...");
        System.out.println("Repartiendo Cartas...");
        Iterator<Carta> iter = deck.iterador();
        for (int i=0; i<this.jugadores.size(); i++)
        {
            for (int j=0; j<cantidadCartas; j++)
            {
                if (iter.hasNext())
                {
                    this.cartasJugadores[i].add( iter.next() );
                    iter.remove();
                }
            }
        }
    }
    
    public void repartirCartasMesa(int cantidadCartas)
    {
        Iterator<Carta> iter = deck.iterador();
        for (int j=0; j<cantidadCartas; j++)
        {
            if (iter.hasNext())
            {
                this.cartasMesa.add( iter.next() );
                iter.remove();
            }
        }
    }
    
    private void escucharApuestas()
    {
        System.out.println("Esperando apuestas");
        while (this.cantidadApuestas < this.jugadores.size()) { }
        System.out.println("listo!");
        this.cantidadApuestas = 0;
    }
    
    private void escucharCambios()
    {
        while (this.cantidadCambios < this.jugadores.size()) { }
        this.cantidadCambios = 0;
    }
    
    public List<Mano> generarManos()
    {
        this.manos.clear();
        for (List<Carta> cartas : this.cartasJugadores)
        {
            this.manos.add( new Mano(cartas) );
        }
        return this.manos;
    }
    
    public void notificarApuestas()
    {
        BetStatusDTO status = this.generarBetStatusDTO();
        for (Jugador jugador : this.jugadores)
        {
            Servidor.getInstance().enviarComando(jugador.getId(), "graficarApuestas", status);
        }
    }
    
    public void notificarCartas()
    {
        Servidor.getInstance().post("Notificando Cartas...");
        System.out.println("Notificando cartas...");
        for (Jugador current : this.jugadores)
        {
            CartasDTO status = this.generarCartasDTO(current);
            Servidor.getInstance().enviarComando(current.getId(), "graficarCartas", status);
        }
    }
    
    public void recibirApuestas()
    {
        this.pokerBet.iniciarRondaApuesta();
        for (Jugador jugador : this.jugadores)
        {
            Servidor.getInstance().enviarComando(jugador.getId(), "solicitarApuesta", this.pokerBet.getbBlind());
        }
    }
    
    public void recibirCambios()
    {
        for (Jugador jugador : this.jugadores)
        {
            Servidor.getInstance().enviarComando(jugador.getId(), "solicitarCarta", null);
        }
    }
    
    public BetStatusDTO generarBetStatusDTO()
    {
        return new BetStatusDTO(this.jugadores, this.pokerBet.getApuestas());
    }
    
    public CartasDTO generarCartasDTO(Jugador jugador)
    {
        int indiceJugador = this.jugadores.indexOf(jugador);
        return new CartasDTO(this.cartasMesa, this.cartasJugadores[indiceJugador]);
    }
    
    public void agregarJugador(Jugador jugador)
    {
        this.jugadores.add(jugador);
    }
    
    public Object eliminarJugador(String idJugador)
    {
        for (Jugador current : this.jugadores)
        {
            if (current.getId().equals(idJugador))
            {
                this.jugadores.remove(current);
                return current;
            }
        }
        
        return null;
    }
    
    private int getIndexJugador(String idJugador)
    {
        for (int i=0; i<this.jugadores.size(); i++)
        {
            if (this.jugadores.get(i).getId().equals(idJugador))
            {
                return i;
            }
        }
        return -1;
    }

    public String getId()
    {
        return id;
    }

    public int getDealer()
    {
        return dealer;
    }

    public Jugador getCreador()
    {
        return creador;
    }

    public List<Jugador> getJugadores() 
    {
        return jugadores;
    }

    public PokerBet getPokerBet()
    {
        return pokerBet;
    }
    public List<Carta> getCartasMesa() {
        return cartasMesa;
    }

    public int getTipoJuego() {
        return tipoJuego;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    @Override
    public void handleEvent(String comando)
    {
        if (comando.equals("apostar"))
        {
            this.cantidadApuestas++;
            if (this.cantidadApuestas == this.jugadores.size())
            {
                this.juego.apuestasFinalizadas();
                this.cantidadApuestas = 0;
            }
        }
        if (comando.equals("cambiarCarta"))
        {
            this.cantidadCambios++;
            if (this.cantidadCambios == this.jugadores.size())
            {
                this.cantidadCambios = 0;
            }
        }
    }
    
}
