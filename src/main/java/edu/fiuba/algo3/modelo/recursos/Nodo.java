package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Nodo extends Recurso{
    public Nodo(){
        super();
        this.cantidad = 2000;
    }

    @Override
    public void visitar(VisitanteConstruccion visitante){
        visitante.construir(this);
    }

}
