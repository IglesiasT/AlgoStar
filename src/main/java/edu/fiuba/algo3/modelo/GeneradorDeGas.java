package edu.fiuba.algo3.modelo;

public abstract class GeneradorDeGas extends Construccion{
    protected int turnos;
    protected int gasProducido;
    protected int turnosParaSerConstruido;


    public GeneradorDeGas(){
        this.turnos = 0;
        this.gasProducido = 0;
        this.turnosParaSerConstruido = 1;
    }
    @Override
    public void esGeneradorDeGas(){}
    abstract void producirGas();
    abstract void nuevoTurno();
    public int obtenerGasProducido() throws EdificioNoEstaOperativo{
        if (this.turnos < turnosParaSerConstruido){
            throw new EdificioNoEstaOperativo();
        }

        return this.gasProducido;
    }
}
