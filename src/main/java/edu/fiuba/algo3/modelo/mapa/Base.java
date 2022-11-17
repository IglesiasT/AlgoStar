package edu.fiuba.algo3.modelo.mapa;

public class Base {

    private Casillero ubicacion;

    public Base(Casillero ubicacion){
        this.ubicacion = ubicacion;
    }

    public Casillero obtenerUbicacion(){
        return ubicacion;
    }
}
