package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.Recurso;
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
    }
    public void ubicar(Casillero nuevaUbicacion) {
        nuevaUbicacion.obtenerRecurso().ocupar();
        this.ubicacion = nuevaUbicacion;
    }
    public int producir(){
        Recurso recurso = this.ubicacion.obtenerRecurso();
        recursoRecolectado = recurso.recolectar(10);
        return recursoRecolectado;
    }

    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        if (this.turnos > turnosParaConstruirse ){
            if (this.ubicacion.obtenerRecurso().getClass() == Nodo.class) {
                this.producir();
                raza.agregarRecurso(new Mineral(recursoRecolectado));
            }
        }

    }

}
