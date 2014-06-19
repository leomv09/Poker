/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.List;

public class CartasDTO {

    private List<Carta> cartasMesa;
    private List<Carta> cartasJugador;

    public CartasDTO(List<Carta> cartasMesa, List<Carta> cartasJugador)
    {
        this.cartasMesa = cartasMesa;
        this.cartasJugador = cartasJugador;
    }

    public List<Carta> getCartasMesa()
    {
        return cartasMesa;
    }

    public List<Carta> getCartasJugador()
    {
        return cartasJugador;
    }
    
}
