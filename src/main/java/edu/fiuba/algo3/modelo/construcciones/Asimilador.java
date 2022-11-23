package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Asimilador extends ConstruccionProtoss implements ProductorDeGas {
    private int gasProducido;
    private int produccionPorTurno;

    public Asimilador(){
        super();
        this.escudo = new Escudo(450);
        this.vida = 450;
        this.gasProducido = 0;
        this.turnosParaConstruirse = 6;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.produccionPorTurno = 20;
    }

    public void nuevoTurno(){
        super.nuevoTurno();
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
        }
    }

    public GasProducido obtenerGasProducido(){
        if(this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new GasProducido(this.gasProducido);
    }

    public void producirGas(){
        this.gasProducido += this.ubicacion.obtenerRecurso().recolectar(this.produccionPorTurno);
    }
}
