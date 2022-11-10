package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pilon extends Construccion{
    private int radioAfectado;
    private Casillero ubicacion;

    public void Pilon(Casillero casilleroDeConstruccion){
        this.radioAfectado = 3;
        this.ubicacion = casilleroDeConstruccion;
    }

    public void energizar(){
        ArrayList casillerosEnergizados = new ArrayList<Casillero>();
           //Energizar cada uno
    }

    @Override
    public void recibirDanio(int danioInflingido) {

    }

    @Override
    protected void regenerar() {

    }
}
