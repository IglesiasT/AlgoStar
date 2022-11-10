package edu.fiuba.algo3.modelo;

public class Extractor extends ConstruccionZerg{
    private int gasProducido;
    private int capacidadMaximaDeZanganos;
    private int zanganosAsignados;
    public Extractor(){
        this.turnosParaConstruirse = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = 0;
        this.gasProducido = 0;
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos <= turnosParaConstruirse ){
            throw new EdificioNoEstaOperativo();
        }
        this.producirGas();
        this.regenerar();
    }

    protected void producirGas(){
        this.gasProducido += this.zanganosAsignados * 10;
    }

    public void asignarZangano() throws MaximoDeZanganosAsignados{
        if (this.zanganosAsignados >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.zanganosAsignados++;
    }

    public int obtenerGasProducido(){
        return this.gasProducido;
    }
}
