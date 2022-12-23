package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Zangano extends UnidadZerg {

    private RecursoObtenido recursoRecolectado;
    private boolean enExtractor;
    public Zangano(){
        super();
        this.vida = 25;
        this.vidaMaxima = 25;
        this.turnosParaConstruirse = 1;
        this.suministro = 1;
        this.enExtractor=false;
        this.recursosNecesarios.agregar(new Mineral(25));
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
    public void moverse(Casillero nuevaUbicacion) {
        super.moverse(nuevaUbicacion);
        if ((nuevaUbicacion.obtenerConstruccion() != null) && (nuevaUbicacion.obtenerConstruccion().getClass() == Extractor.class)) {
            ((Extractor) nuevaUbicacion.obtenerConstruccion()).asignarZangano(this);
            enExtractor = true;
        }
        else {
            nuevaUbicacion.ocuparRecurso();
            enExtractor = false;
        }
    }
    public RecursoObtenido producir(){
        recursoRecolectado = ubicacion.recolectarRecurso(this,10);
        return recursoRecolectado;
    }

    public void nuevoTurno(Raza raza){

        if (activa() && !enExtractor){
            raza.agregarRecurso(producir());
        }
        super.nuevoTurno(raza);
    }

}
