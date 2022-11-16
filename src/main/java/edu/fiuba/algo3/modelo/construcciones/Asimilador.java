package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Asimilador extends ConstruccionProtoss {
    private int gasProducido;
    private int produccionPorTurno;

    public Asimilador(){
        super();
        this.escudo = new Escudo(450);
        this.vida = 450;
        this.gasProducido = 0;
        this.turnosParaConstruirse = 6;
        this.mineralNecesarioParaConstruir = 100;
        this.produccionPorTurno = 20;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Gas()) && !casillero.contiene(new Moho()));
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
        }
    }

    public int obtenerGasProducido(){
        if(this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return this.gasProducido;
    }

    public void producirGas(){
        this.gasProducido += this.ubicacion.obtenerRecurso().recolectar(this.produccionPorTurno);
    }
}
