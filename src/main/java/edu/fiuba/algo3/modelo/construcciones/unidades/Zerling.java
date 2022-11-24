package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.mapa.*;
public class Zerling extends UnidadZerg{
    public Zerling(){
        super();
        this.danioPorSuperficie.put("Tierra", 4);
        this.vida = 35;
        this.vidaMaxima = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.mineralNecesarioParaConstruir = 25;
        this.suministro = 1;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }

}
