package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;

public class SinRecurso extends Recurso{

    @Override
    public RecursoObtenido recolectar(Zangano zangano, Construccion construccion, int recoleccionPorTurno) {
        return new RecursoObtenido(0);
    }
    @Override
    public RecursoObtenido recolectar(Construccion construccion, int recoleccionPorTurno) {
        return new RecursoObtenido(0);
    }
    @Override
    public void ocupar(){}
}
