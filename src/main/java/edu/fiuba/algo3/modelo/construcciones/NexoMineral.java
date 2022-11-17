package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class NexoMineral extends ConstruccionProtoss {
    private int turnos;
    private int produccionPorTurno;

    public NexoMineral(){
        super();
        this.escudo = new Escudo(250);
        this.vida = 250;
        this.produccionPorTurno = 20;
        this.turnosParaConstruirse = 4;
        this.mineralNecesarioParaConstruir = 50;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Mineral()) && !casillero.contiene(new Moho()));
    }

    public int recolectarMineral(){
        if (this.turnos < this.turnosParaConstruirse ){
            throw new EdificioNoEstaOperativo();
        }
        return produccionPorTurno;
    }

    public void nuevoTurno(){
        this.turnos++;
    }
}
