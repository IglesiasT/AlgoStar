package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Nodo extends Recurso{
    public Nodo(){
        super();
        this.cantidad = 2000;
    }
    public RecursoObtenido recolectar(Zangano zangano, Construccion construccion, int recoleccionPorTurno) {
        return new Mineral(recolectar(recoleccionPorTurno));
    }

    public RecursoObtenido recolectar(Construccion construccion, int recoleccionPorTurno) {
        return new Mineral(recolectar(recoleccionPorTurno));
    }

    @Override
    public void visitar(VisitanteConstruccion visitante){
        visitante.construir(this);
    }

}
