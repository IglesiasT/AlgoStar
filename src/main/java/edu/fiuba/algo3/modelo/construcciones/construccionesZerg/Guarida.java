package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Nodo;

public class Guarida extends ConstruccionZerg {
    public Guarida(){
        this.recursosNecesarios.agregar(new Mineral(200));
        this.recursosNecesarios.agregar(new Gas(100));
        this.turnosParaConstruirse = 12;
        this.vida = 1250;
        this.vidaMaxima = 1250;
    }

    public void evolucionarAHidralisco(){
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        // recibir Larva y cambiar estado a Hidralisco
    }
}
