package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.MaximoDeZanganosAsignados;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

import java.util.LinkedList;
import java.util.List;

public class Extractor extends ConstruccionZerg implements ProductorDeGas {
    private int gasProducido;
    private final int capacidadMaximaDeZanganos;
    private final List<Zangano> zanganosAsignados;
    public Extractor(){
        this.turnosParaConstruirse = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = new LinkedList<>();
        this.gasProducido = 0;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.vida = 750;
        this.vidaMaxima = 750;
    }
    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        try{
            this.producirGas();
            raza.agregarRecurso(new Gas(this.gasProducido));
        }catch (RuntimeException EdificioNoEstaOperativo){};
    }
    public void producirGas(){
        this.gasProducido = 0;
        for (Zangano zangano: this.zanganosAsignados) {
            this.gasProducido += zangano.producir();
        }
    }
    public void asignarZangano(Zangano zangano) throws MaximoDeZanganosAsignados {
        if (this.zanganosAsignados.size() >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.zanganosAsignados.add(zangano);
    }
    public Gas obtenerGasProducido() throws EdificioNoEstaOperativo {
        estado.jugar();
        return new Gas(this.gasProducido);
    }

    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
        visitante.construir(this,espacio);
    }

}
