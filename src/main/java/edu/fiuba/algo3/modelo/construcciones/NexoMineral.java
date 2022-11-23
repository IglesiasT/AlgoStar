package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.MineralProducido;

public class NexoMineral extends ConstruccionProtoss {
    private int turnos;
    private int produccionPorTurno;

    private int mineralProducido;
    public NexoMineral(){
        super();
        this.escudo = new Escudo(250);
        this.vida = 250;
        this.produccionPorTurno = 20;
        this.turnosParaConstruirse = 4;
        this.recursosNecesarios.agregar(new Mineral(50));
        this.mineralProducido = 0;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Mineral()) && !casillero.contiene(new Moho()));
    }

    private void recolectarMineral(){
        if (this.turnos < this.turnosParaConstruirse ){
            throw new EdificioNoEstaOperativo();
        }
        this.mineralProducido += this.ubicacion.obtenerRecurso().recolectar(produccionPorTurno);
    }

    public MineralProducido obtenerMineralProducido(){

        if(this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new MineralProducido(this.mineralProducido);

    }

    @Override
    public void nuevoTurno(){
        super.nuevoTurno();
        this.turnos ++;
        if (this.turnos > turnosParaConstruirse ){
            this.recolectarMineral();
        };
    }
}
