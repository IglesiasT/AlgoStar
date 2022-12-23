package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.RecursoObtenido;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;


public class NexoMineral extends ConstruccionProtoss {
    private final int produccionPorTurno;
    public NexoMineral(){
        super();
        this.escudo = new Escudo(250);
        this.vida = 250;
        this.produccionPorTurno = 20;
        this.turnosParaConstruirse = 4;
        this.recursosNecesarios.agregar(new Mineral(50));
    }
    public RecursoObtenido recolectarMineral(){
        estado.jugar();
        return this.ubicacion.recolectarRecurso(produccionPorTurno);
    }
    public void nuevoTurno(Raza raza){
        try{raza.agregarRecurso(recolectarMineral());}catch (Exception e){};
        super.nuevoTurno(raza);

;
    }
    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
    }
}
