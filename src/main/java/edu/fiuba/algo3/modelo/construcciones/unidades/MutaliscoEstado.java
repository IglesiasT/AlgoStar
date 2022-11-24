package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class MutaliscoEstado extends UnidadZerg implements EstadoMutalisco{
    public MutaliscoEstado(){
        super();
        this.danioPorSuperficie.put("Tierra", 9);
        this.danioPorSuperficie.put("Aire", 9);
        this.vidaMaxima = 120;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.recursosNecesarios.agregar(new Gas(100));
        this.superficie = "Aire";
        this.area = new AreaEspacial();
        this.suministro = 4;
    }




}
