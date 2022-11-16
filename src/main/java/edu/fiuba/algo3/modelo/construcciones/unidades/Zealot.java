package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Zealot extends UnidadProtoss{
    public Zealot(){
        super();
        this.danioBase = 8;
        this.escudo = 60;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 1;
        this.superficie = "Tierra";
        this.mineralNecesarioParaConstruir = 100;
    }
    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
