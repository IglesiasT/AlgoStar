package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Dragon extends UnidadProtoss{
    public Dragon(){
        super();
        this.danioPorSuperficie.put("Tierra", 20);
        this.danioPorSuperficie.put("Aire", 20);
        this.escudo = new Escudo(80);
        this.turnosParaConstruirse = 6;
        this.rangoDeAtaque = 4;
        this.mineralNecesarioParaConstruir = 125;
        this.gasNecesarioParaConstruir = 50;
        this.superficie = new AreaTerrestre();
    }
    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
