/*
 /*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package poker;

import servidor.Servidor;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Mesa {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private final String id;
    private final Jugador creador;
    private final List<Jugador> jugadores;
    private final List<Carta> cartasMesa;
    private final Servidor servidor;
    private PokerBet pokerBet;
    private int dealer;
    private String nombre;
    private String tipoJuego;
    private Juego juego;
    
    public Mesa(Jugador creador, PokerBet bet,String Nombre,String tipo)
    {
        this.id = UUID.randomUUID().toString();
        this.dealer = 0;
        this.creador = creador;
        this.pokerBet = bet;
        this.servidor = Servidor.getInstance();
        this.cartasMesa = new LinkedList<>();
        this.jugadores = new LinkedList<>();
        this.jugadores.add(creador);
        this.nombre=Nombre;
        this.tipoJuego=tipo;
    }
    public void crearJuego()
    {
        if (this.tipoJuego=="Omaha")
        {
            this.juego=new Omaha(this);
        }
        else if (this.tipoJuego=="Holdem")
        {
            this.juego=new Holdem(this);
        }
        else if (this.tipoJuego=="FiveCards")
        {
            this.juego=new FiveCards(this);
        }
    }
    
    public void notificarApuestas()
    {
        BetStatusDTO status = this.generarBetStatusDTO();
        this.servidor.notificarEstadoApuesta(this.id, status);
    }
    
    public void notificarCartas()
    {
        for (Jugador current : this.jugadores)
        {
            CartasDTO status = this.generarCartasDTO(current);
            this.servidor.notificarCartas(current.getId(), status);
        }
    }
    
    public void recibirApuestas()
    {
        this.pokerBet.iniciarRondaApuesta();
        this.servidor.solicitarApuestas(this.id);
    }
    
    public void recibirCambios()
    {
        this.servidor.solicitarCambios(this.id);
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
}
