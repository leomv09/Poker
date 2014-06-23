/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD
public class CartasDTO implements Serializable{
=======
public class CartasDTO implements Serializable {
>>>>>>> 349355b6dc2c09a2b8c3f52ccca35dd536cb3ae5

    public static Gson gson = new Gson();
    
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
    
    public static CartasDTO deserialize(String text)
    {
        return CartasDTO.gson.fromJson(text, CartasDTO.class);
    }
    
    public String serialize()
    {
        return CartasDTO.gson.toJson(this);
    }
    
}
