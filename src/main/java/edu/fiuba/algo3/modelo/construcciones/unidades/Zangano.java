package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Zangano extends UnidadZerg {
    private Casillero ubicacion;

    public Zangano(){
        super();
        this.vida = 25;
        this.turnosParaConstruirse = 1;
        this.mineralNecesarioParaConstruir = 25;
    }

    @Override
    public void nuevoTurno(){
        super.nuevoTurno();
        if (this.turnos > turnosParaConstruirse ){
            this.producir();
        }
    }

    public void ubicar(Casillero nuevaUbicacion) {
        nuevaUbicacion.obtenerRecurso().ocupar();
        this.ubicacion = nuevaUbicacion;
    }


    public int producir(){
        if(this.turnos < turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        Recurso recurso = this.ubicacion.obtenerRecurso();
        return recurso.recolectar(10);
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
