package edu.fiuba.algo3.modelo;

public class Zangano {
    private Casillero ubicacion;

    public Zangano(){
        this.ubicacion = null;
    }

    public void ubicar(Casillero nuevaUbicacion){
        nuevaUbicacion.obtenerRecurso().ocupar();
        this.ubicacion = nuevaUbicacion;
    }

    public int producir(){
        Recurso recurso = this.ubicacion.obtenerRecurso();
        return recurso.recolectar(10);
    }
}
