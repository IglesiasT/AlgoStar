package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Zangano extends UnidadZerg {

    private int recursoRecolectado;
    public Zangano(){
        super();
        this.vida = 25;
        this.vidaMaxima = 25;
        this.turnosParaConstruirse = 1;
        this.suministro = 1;
        this.recursoRecolectado = 0;
        this.recursosNecesarios.agregar(new Mineral(25));
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
    public void moverse(Casillero nuevaUbicacion) {
        super.moverse(nuevaUbicacion);
        if ((nuevaUbicacion.obtenerConstruccion() != null) && (nuevaUbicacion.obtenerConstruccion().getClass() == Extractor.class)) {
            ((Extractor) nuevaUbicacion.obtenerConstruccion()).asignarZangano(this);
        }
        else nuevaUbicacion.obtenerRecurso().ocupar();
    }
    public int producir(){
        Recurso recurso = this.ubicacion.obtenerRecurso();
        if (recurso.getClass()== Volcan.class && !(this.ubicacion.obtenerConstruccion().getClass() == Extractor.class))
            return 0;
        recursoRecolectado = recurso.recolectar(10);
        return recursoRecolectado;
    }

    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        if (this.turnos > turnosParaConstruirse ){
            if (this.ubicacion.obtenerRecurso().getClass() == Nodo.class) {
                raza.agregarRecurso(new Mineral(this.producir()));
            }
        }

    }

}
