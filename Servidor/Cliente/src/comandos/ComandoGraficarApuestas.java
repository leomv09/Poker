package comandos;

import poker.BetStatusDTO;

public class ComandoGraficarApuestas extends Comando{

    public static final String COMANDO = "graficarApuestas";
    
    @Override
    public void ejecutar(String[] args)
    {
        BetStatusDTO dto = BetStatusDTO.deserialize(args[0]);
    }
    
}
