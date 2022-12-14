package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.UnidadZerg;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Zangano extends UnidadZerg {

    public Zangano(){
        super();
        this.vida = 25;
        this.vidaMaxima = 25;
        this.turnosParaConstruirse = 1;
        this.suministro = 1;
        this.recursosNecesarios.agregar(new Mineral(25));
    }
    public void ubicar(Casillero nuevaUbicacion) {
        nuevaUbicacion.obtenerRecurso().ocupar();
        this.ubicacion = nuevaUbicacion;
    }
    public int producir(){
        Recurso recurso = this.ubicacion.obtenerRecurso();
        return recurso.recolectar(10);
    }

}
