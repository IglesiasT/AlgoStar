package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Volcan extends Recurso{

    public Volcan(){
        super();
        this.cantidad = 5000;
    }

    @Override
    public void visitar(VisitanteConstruccion visitante){
        visitante.construir(this);
    }
 }
