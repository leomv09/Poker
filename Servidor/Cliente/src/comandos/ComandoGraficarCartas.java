package comandos;

import poker.CartasDTO;

public class ComandoGraficarCartas extends Comando{
    
    public static final String COMANDO = "graficarCartas";
   
    @Override
    public void ejecutar(String[] args)
    {
        CartasDTO dto = CartasDTO.deserialize(args[0]);
    }
    
}
