package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.MaximoDeZanganosAsignados;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.razas.Raza;
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
    public void nuevoTurno(Raza raza){
        super.nuevoTurno();
        try{
            this.producirGas();
            raza.agregarRecurso(new Gas(this.gasProducido));
        }catch (RuntimeException EdificioNoEstaOperativo){};
    }
    public void producirGas(){
        gasProducido = 0;
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
}
