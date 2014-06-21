package poker;


public class MesaDTO {

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

    @Override
    public String toString()
    {
        return this.nombre;
    }
    
}
