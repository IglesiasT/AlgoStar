package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Zerling extends UnidadZerg{
    public Zerling(){
        super();
        this.danioPorSuperficie.put("Tierra", 4);
        this.vida = 35;
        this.vidaMaxima = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.recursosNecesarios.agregar(new Mineral(25));
    }
}
