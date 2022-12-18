package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Espiral extends ConstruccionZerg {
    public Espiral(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.recursosNecesarios.agregar(new Gas(100));
        this.turnosParaConstruirse = 10;
        this.vidaMaxima = 1300;
        this.vida = this.vidaMaxima;
    }
}
