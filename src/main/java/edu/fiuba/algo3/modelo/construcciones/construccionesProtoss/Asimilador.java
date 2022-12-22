package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public class Asimilador extends ConstruccionProtoss implements ProductorDeGas {
    private int gasProducido;
    private final int produccionPorTurno;

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
        estado.jugar();
        return new Gas(this.gasProducido);
    }

    public void producirGas(){
        this.gasProducido = this.ubicacion.obtenerRecurso().recolectar(this.produccionPorTurno);
    }

    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this, recurso);
    }

}
