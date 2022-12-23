package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Asimilador extends ConstruccionProtoss implements ProductorDeGas {
    private final int produccionPorTurno;

    public Asimilador(){
        super();
        this.escudo = new Escudo(450);
        this.vida = 450;
        this.turnosParaConstruirse = 6;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.produccionPorTurno = 20;
    }

    public void nuevoTurno(Raza raza){
        try {raza.agregarRecurso(producirGas());}catch (Exception e){};
        super.nuevoTurno(raza);
    }


    public RecursoObtenido producirGas(){
        return this.ubicacion.recolectarRecurso(this.produccionPorTurno);
    }

    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
    }

}
