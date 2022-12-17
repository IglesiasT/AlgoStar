package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;

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

    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
            raza.agregarRecurso(new Gas(this.gasProducido));
        }
    }

    public Gas obtenerGasProducido(){
        if(this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new Gas(this.gasProducido);
    }

    public void producirGas(){
        this.gasProducido = this.ubicacion.obtenerRecurso().recolectar(this.produccionPorTurno);
    }
}
