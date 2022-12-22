package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Set;

public abstract class Recurso{
    protected boolean ocupado;
    protected int cantidad;

    public Recurso(){
        this.ocupado = false;
        this.cantidad = 0;
    }
    public int recolectar(int recoleccionPorTurno) {
        this.cantidad -= recoleccionPorTurno;
        if(this.cantidad <= 0) {
            int recursoRecolectado = recoleccionPorTurno + this.cantidad;
            this.cantidad = 0;
            return recursoRecolectado;
        }
        return recoleccionPorTurno;
    }

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
