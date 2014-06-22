/*
 /*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import servidor.ListenerComandos;
import servidor.Servidor;

public class Mesa implements ListenerComandos {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private final String id;
    private final Jugador creador;
    private final Servidor servidor;
    private Deck deck;
    private PokerBet pokerBet;
    private final List<Jugador> jugadores;
    private final List<Carta> cartasMesa;
    private final List<Carta>[] cartasJugadores;
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
        this.servidor = Servidor.getInstance();
        this.cartasMesa = new LinkedList<>();
        this.cartasJugadores = new List[cantidadJugadores];
        this.jugadores = new LinkedList<>();
        this.jugadores.add(creador);
        this.nombre=Nombre;
        this.tipoJuego=tipo;
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadApuestas = 0;
        
        for (int i=0; i<cantidadJugadores; i++)
        {
            this.cartasJugadores[i] = new LinkedList<>();
        }
        this.deck.shuffle();
    }
    
    public void crearJuego()
    {
        switch(tipoJuego)
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
            this.servidor.enviarComando(jugador.getId(), "iniciarPartida", null);
        }
    }
    
    public void repartirCartasJugadores(int cantidadCartas)
    {
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
        while (this.cantidadApuestas < this.jugadores.size()) { }
        this.cantidadApuestas = 0;
    }
    
    public void notificarApuestas()
    {
        BetStatusDTO status = this.generarBetStatusDTO();
        for (Jugador jugador : this.jugadores)
        {
            this.servidor.enviarComando(jugador.getId(), "graficarApuestas", status);
        }
    }
    
    public void notificarCartas()
    {
        for (Jugador current : this.jugadores)
        {
            CartasDTO status = this.generarCartasDTO(current);
            this.servidor.enviarComando(current.getId(), "graficarCartas", status);
        }
    }
    
    public void recibirApuestas()
    {
        this.pokerBet.iniciarRondaApuesta();
        for (Jugador jugador : this.jugadores)
        {
            this.servidor.enviarComando(jugador.getId(), "solicitarApuesta", this.pokerBet.getbBlind());
        }
        escucharApuestas();
    }
    
    public void recibirCambios()
    {
        for (Jugador jugador : this.jugadores)
        {
            this.servidor.enviarComando(jugador.getId(), "solicitarCarta", null);
        }
    }
    
    public BetStatusDTO generarBetStatusDTO()
    {
        return new BetStatusDTO(this.jugadores, this.pokerBet.getApuestas());
    }
    
    public CartasDTO generarCartasDTO(Jugador jugador)
    {
        return new CartasDTO(this.cartasMesa, jugador.getCartas());
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

    public Servidor getServidor() {
        return servidor;
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
        }
    }
    
}
