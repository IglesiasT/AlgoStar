package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pilon extends ConstruccionProtoss{
    private int radioAfectado;
    private Casillero ubicacion;

    public Pilon(){
        this.escudo = 300;
        this.vida = 300;
        this.mineralNecesarioParaConstruir = 100;
    }

    public Pilon(Casillero casilleroDeConstruccion){
        this.radioAfectado = 3;
        this.ubicacion = casilleroDeConstruccion;
    }

    public void energizar(){
        ArrayList casillerosEnergizados = new ArrayList<Casillero>();
           //Energizar cada uno
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (!casillero.contiene(new Moho()));
    }
}
