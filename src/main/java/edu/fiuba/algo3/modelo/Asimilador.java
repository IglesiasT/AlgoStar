package edu.fiuba.algo3.modelo;

public class Asimilador {
    private static final int turnosParaSerConstruido = 6;
    private int turnos;
    private int gasProducido;

    public Asimilador(){
        this.turnos = 0;
        this.gasProducido = 0;
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos >= turnosParaSerConstruido ){
            this.producirGas();
        }
    }

    private void producirGas(){
        this.gasProducido += 20;
    }

    public int obtenerGasProducido() throws EdificioNoEstaOperativo{
        if (this.turnos < turnosParaSerConstruido){
            throw new EdificioNoEstaOperativo();
        }

        return this.gasProducido;
    }
}
