package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Nodo;

public class MutaliscoEstado extends UnidadZerg implements EstadoMutalisco {
    public MutaliscoEstado(){
        super();
        this.danioAereo = 9;
        this.danioTerrestre = 9;
        this.vidaMaxima = 120;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.recursosNecesarios.agregar(new Gas(100));
        this.area = new AreaEspacial();
        this.suministro = 4;
    }




}
