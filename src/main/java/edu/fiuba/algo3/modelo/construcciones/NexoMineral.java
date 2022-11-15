package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public class NexoMineral extends ConstruccionProtoss {
    private int turnos;
    private int produccionPorTurno;

    public NexoMineral(){
        this.produccionPorTurno = 20;
        this.turnos = 0;
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
