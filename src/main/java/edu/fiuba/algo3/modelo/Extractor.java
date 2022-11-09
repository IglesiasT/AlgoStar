package edu.fiuba.algo3.modelo;

public class Extractor {
    private static final int turnosParaSerConstruido = 6;
    private int turnos;
    private int capacidadMaximaDeZanganos;
    private int zanganosAsignados;
    private int gasProducido;
    public Extractor(){
        this.turnos = 0;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = 0;
        this.gasProducido = 0;
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos >= turnosParaSerConstruido ){
            this.producirGas();
        }
    }

    private void producirGas(){
        this.gasProducido += this.zanganosAsignados * 10;
    }
    public int obtenerGasProducido() throws EdificioNoEstaOperativo{
        if (this.turnos < turnosParaSerConstruido){
            throw new EdificioNoEstaOperativo();
        }

        return this.gasProducido;
    }

    public void asignarZangano() throws MaximoDeZanganosAsignados{
        if (this.zanganosAsignados >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.zanganosAsignados++;
    }
}
