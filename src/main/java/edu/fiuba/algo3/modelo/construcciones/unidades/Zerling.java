package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Zerling extends UnidadZerg{
    public Zerling(){
        this.danioPorSuperficie.put("Tierra", 4);
        this.vida = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.superficie = "Tierra";
        this.mineralNecesarioParaConstruir = 25;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
