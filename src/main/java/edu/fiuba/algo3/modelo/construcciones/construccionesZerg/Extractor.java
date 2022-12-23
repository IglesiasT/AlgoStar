package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.MaximoDeZanganosAsignados;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.RecursoObtenido;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

import java.util.LinkedList;
import java.util.List;

public class Extractor extends ConstruccionZerg implements ProductorDeGas {
    private final int capacidadMaximaDeZanganos;
    private final List<Zangano> zanganosAsignados;
    public Extractor(){
        this.turnosParaConstruirse = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = new LinkedList<>();
        this.recursosNecesarios.agregar(new Mineral(100));
        this.vida = 750;
        this.vidaMaxima = 750;
    }
    public void nuevoTurno(Raza raza){
        try{raza.agregarRecurso(producirGas());}catch (Exception e){};
        super.nuevoTurno(raza);

    }
    public void asignarZangano(Zangano zangano) throws MaximoDeZanganosAsignados {
        if (this.zanganosAsignados.size() >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.zanganosAsignados.add(zangano);
    }
    public RecursoObtenido producirGas(){
        estado.jugar();
        Gas gasProducido = new Gas(0);
        for(Zangano zangano: zanganosAsignados){
            gasProducido.agregar(zangano.producir());
        }
        return gasProducido;
    }

    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
        visitante.construir(this,espacio);
    }

}
