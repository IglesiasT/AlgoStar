package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.visitante.VisitanteArea;


public class Devorador extends UnidadZerg implements EstadoMutalisco {


    public Devorador(){
        super();
        this.danioAereo = 15;
        this.vidaMaxima = 200;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 5;
        this.recursosNecesarios.agregar(new Mineral(150));
        this.recursosNecesarios.agregar(new Gas(50));
        this.area = new AreaEspacial();
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
}
