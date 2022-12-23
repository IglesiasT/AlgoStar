package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public abstract class Recurso{
    protected boolean ocupado;
    protected int cantidad;

    public Recurso(){
        this.ocupado = false;
        this.cantidad = 0;
    }
    protected int recolectar(int recoleccionPorTurno) {
        this.cantidad -= recoleccionPorTurno;
        if(this.cantidad <= 0) {
            int recursoRecolectado = recoleccionPorTurno + this.cantidad;
            this.cantidad = 0;
            return recursoRecolectado;
        }
        return recoleccionPorTurno;
    }

    public abstract RecursoObtenido recolectar(Zangano zangano, Construccion construccion, int recoleccionPorTurno);
    public abstract RecursoObtenido recolectar(Construccion construccion, int recoleccionPorTurno);
    public void ocupar(){
        if (this.ocupado){
            throw new RecursoOcupado();
        }
        this.ocupado = true;
    }
    public void liberar(){
        this.ocupado = false;
    }

    public void visitar(VisitanteConstruccion visitante){}

}
