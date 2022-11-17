package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Zealot extends UnidadProtoss{
    public Zealot(){
        super();
        this.danioPorSuperficie.put("Tierra", 8);
        this.escudo = new Escudo(60);
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 1;
        this.mineralNecesarioParaConstruir = 100;
    }
    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
