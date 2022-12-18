package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class NexoMineral extends ConstruccionProtoss {
    private int turnos;
    private final int produccionPorTurno;
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
    private void recolectarMineral(){
        if (this.turnos < this.turnosParaConstruirse ){
            throw new EdificioNoEstaOperativo();
        }
        this.mineralProducido = this.ubicacion.obtenerRecurso().recolectar(produccionPorTurno);
    }
    public Mineral obtenerMineralProducido(){

        if(this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new Mineral(this.mineralProducido);

    }
    @Override
    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        this.turnos ++;
        if (this.turnos > turnosParaConstruirse ){
            this.recolectarMineral();
            raza.agregarRecurso(new Mineral(this.mineralProducido));
        };
    }
}
