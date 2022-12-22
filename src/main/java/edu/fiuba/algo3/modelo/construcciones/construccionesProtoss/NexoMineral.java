package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;


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
        estado.jugar();
        this.mineralProducido = this.ubicacion.obtenerRecurso().recolectar(produccionPorTurno);
    }

    public Mineral obtenerMineralProducido(){
        estado.jugar();
        return new Mineral(this.mineralProducido);
    }

    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        this.turnos ++;
        try{
            this.recolectarMineral();
            raza.agregarRecurso(new Mineral(this.mineralProducido));
        }catch (RuntimeException EdificioNoEstaOperativo){};
    }

    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
    }

}
