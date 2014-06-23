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
import java.util.ArrayList;
import java.util.List;


public final class CartasDTO implements Serializable{

    private static final long serialVersionUID = 7526472295622776147L;
    public static Gson gson = new Gson();
    
    private final ArrayList<Carta> cartasMesa;
    private final ArrayList<Carta> cartasJugador;

    public CartasDTO(ArrayList<Carta> cartasMesa, ArrayList<Carta> cartasJugador)
    {
        this.cartasMesa = cartasMesa;
        this.cartasJugador = cartasJugador;
    }

    public ArrayList<Carta> getCartasMesa()
    {
        return cartasMesa;
    }

    public ArrayList<Carta> getCartasJugador()
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
