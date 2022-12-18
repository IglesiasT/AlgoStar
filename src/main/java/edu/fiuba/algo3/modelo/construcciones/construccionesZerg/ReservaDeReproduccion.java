package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.recursos.Mineral;
public class ReservaDeReproduccion extends ConstruccionZerg {

    public ReservaDeReproduccion(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.turnosParaConstruirse = 12;
        this.vida = 1000;
        this.vidaMaxima = 1000;
    }
}
