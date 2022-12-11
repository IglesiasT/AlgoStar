package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.MaximoDeZanganosAsignados;
import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.ArrayList;

public class Extractor extends ConstruccionZerg implements ProductorDeGas {
    private int gasProducido;
    private int capacidadMaximaDeZanganos;
    private ArrayList<Zangano> zanganosAsignados;
    public Extractor(){
        this.turnosParaConstruirse = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = new ArrayList<>();
        this.gasProducido = 0;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.vida = 750;
        this.vidaMaxima = 750;
    }
    public void nuevoTurno(){
        super.nuevoTurno();
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
        }
    }
    public void producirGas(){
        for (Zangano zangano: this.zanganosAsignados) {
            this.gasProducido += zangano.producir();
        }
    }
    public void asignarZangano(Zangano zangano) throws MaximoDeZanganosAsignados {
        if (this.zanganosAsignados.size() >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.ubicacion.obtenerRecurso().liberar();
        zangano.ubicar(this.ubicacion);
        this.zanganosAsignados.add(zangano);
    }
    public Gas obtenerGasProducido() throws EdificioNoEstaOperativo {
        if(this.turnos < turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new Gas(this.gasProducido);
    }
}
