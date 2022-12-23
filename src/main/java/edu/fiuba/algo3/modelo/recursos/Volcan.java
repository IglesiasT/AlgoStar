package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Volcan extends Recurso{

    public Volcan(){
        super();
        this.cantidad = 5000;
    }
    public RecursoObtenido recolectar(Zangano zangano, Construccion construccion, int recoleccionPorTurno) {
        if (construccion.getClass() != Extractor.class || !construccion.activa())
            return new Gas(0);
        return new Gas(recolectar(recoleccionPorTurno));
    }

    public RecursoObtenido recolectar(Construccion construccion, int recoleccionPorTurno) {
        return new Gas(recolectar(recoleccionPorTurno));
    }

    @Override
    public void visitar(VisitanteConstruccion visitante){
        visitante.construir(this);
    }
 }
