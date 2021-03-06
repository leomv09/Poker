package poker;

import java.io.Serializable;


public class MesaDTO implements Serializable{

    private final String id;
    private final String nombre;
    private final int cantidadJugadores;
    private final int tipoJuego;

    public MesaDTO(String id, String nombre, int cantidadJugadores, int tipoJuego)
    {
        this.id = id;
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
        this.tipoJuego = tipoJuego;
    }

    public String getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getCantidadJugadores()
    {
        return cantidadJugadores;
    }

    public int getTipoJuego()
    {
        return tipoJuego;
    }
    
    public String getNombreTipoJuego()
    {
        String nombreTipo = null;
        switch(tipoJuego)
        {
            case Constantes.JUEGO_HOLDEM:
                nombreTipo = "Holdem";
                break;
            case Constantes.JUEGO_FIVECARDS:
                nombreTipo = "Five Cards";
                break;
            case Constantes.JUEGO_OMAHA:
                nombreTipo = "Omaha";
                break;
        }
        return nombreTipo;
    }

    @Override
    public String toString()
    {
        return "Nombre: " + nombre + " | " + "Cantidad de jugadores: "+ cantidadJugadores + " | " + "Juego: " + this.getNombreTipoJuego();
    }
    
}
